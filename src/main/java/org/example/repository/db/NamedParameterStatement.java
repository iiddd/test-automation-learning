package org.example.repository.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class NamedParameterStatement implements AutoCloseable {
    private final PreparedStatement preparedStatement;
    private final Map<String, Integer> parameterIndex;

    public NamedParameterStatement(Connection connection, String query) throws SQLException {
        parameterIndex = new HashMap<>();
        String parsedQuery = parse(query, parameterIndex);
        this.preparedStatement = connection.prepareStatement(parsedQuery);
    }

    private String parse(String query, Map<String, Integer> parameterIndex) {
        int index = 1;
        StringBuilder parsedQuery = new StringBuilder();
        StringBuilder paramName = new StringBuilder();
        boolean inParam = false;

        for (char c : query.toCharArray()) {
            if (c == ':') {
                inParam = true;
                paramName.setLength(0);
            } else if (inParam && (Character.isLetterOrDigit(c) || c == '_')) {
                paramName.append(c);
            } else if (inParam) {
                inParam = false;
                parameterIndex.put(paramName.toString(), index++);
                parsedQuery.append("?");
                parsedQuery.append(c);
            } else {
                parsedQuery.append(c);
            }
        }

        if (inParam) {
            parameterIndex.put(paramName.toString(), index++);
            parsedQuery.append("?");
        }

        return parsedQuery.toString();
    }

    public void setParameter(String name, Object value) throws SQLException {
        if (!parameterIndex.containsKey(name)) {
            throw new IllegalArgumentException("Parameter not found: " + name);
        }
        int index = parameterIndex.get(name);
        preparedStatement.setObject(index, value);
    }

    public void executeUpdate() throws SQLException {
        preparedStatement.executeUpdate();
    }

    @Override
    public void close() throws SQLException {
        preparedStatement.close();
    }
}