package org.example.repository;

import org.example.models.db.Admin;
import org.example.models.db.Puppy;
import org.example.repository.db.NamedParameterStatement;
import org.junit.jupiter.api.Assertions;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PuppyRepository {

    public static List<Admin> getAdmins() {
        String sql = "SELECT id, password, last_login, is_superuser, username, last_name, email, is_staff, " +
                "is_active, date_joined, first_name FROM auth_user au;";
        ArrayList<Admin> adminList = new ArrayList<>();

        try (Connection connection = connect(getDbUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Admin admin = new Admin();
                    admin.setId(resultSet.getInt("id"));
                    admin.setFirstName(resultSet.getString("first_name"));
                    admin.setLastName(resultSet.getString("last_name"));
                    admin.setUsername(resultSet.getString("username"));
                    admin.setPassword(resultSet.getString("password"));
                    admin.setEmailAddress(resultSet.getString("email"));
                    admin.setLastLogin(resultSet.getString("last_login"));
                    admin.setDateJoined(resultSet.getString("date_joined"));
                    admin.setIsSuperUser(resultSet.getBoolean("is_superuser"));
                    admin.setIsStaff(resultSet.getBoolean("is_staff"));
                    admin.setIsActive(resultSet.getBoolean("is_active"));
                    adminList.add(admin);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return adminList;
    }

    public static List<Puppy> getPuppies() {
        String sql = "SELECT id, first_name, last_name, email_address, address, mobile_number, account_number, " +
                "account_balance, created_by_id FROM app_clients_client acc;";
        ArrayList<Puppy> puppyList = new ArrayList<>();
        try (Connection connection = connect(getDbUrl());
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Puppy puppy = new Puppy();
                    puppy.setId(resultSet.getInt("id"));
                    puppy.setFirstName(resultSet.getString("first_name"));
                    puppy.setLastName(resultSet.getString("last_name"));
                    puppy.setEmailAddress(resultSet.getString("email_address"));
                    puppy.setAddress(resultSet.getString("address"));
                    puppy.setMobileNumber(resultSet.getString("mobile_number"));
                    puppy.setAccountNumber(resultSet.getString("account_number"));
                    puppy.setAccountBalance(resultSet.getFloat("account_balance"));
                    puppy.setCreatedById(resultSet.getInt("created_by_id"));
                    puppyList.add(puppy);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return puppyList;
    }

    public static float getAccountBalance(int id) {
        List<Puppy> puppyList = getPuppies().stream().filter(
                puppyAccount -> puppyAccount.getId() == id).toList();
        Assertions.assertTrue(puppyList.size() == 1);
        return puppyList.getFirst().getAccountBalance();
    }

    public static void executeSqlCommand(String sql) {
        try (Connection connection = connect(getDbUrl());
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Connection connect(String url) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Connection established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    private static String getDbUrl() {
        Path relativePath = Paths.get(System.getProperty("user.dir"), ".docker", "db.sqlite3");
        return "jdbc:sqlite:" + relativePath.toAbsolutePath();
    }

    public static void createPuppy(int id, String firstName, String lastName, String address,
                                   String accountNumber, String mobileNumber, String emailAddress,
                                   float accountBalance, int createdById) {
        String SqlQuery = "INSERT INTO app_clients_client ("
                + "id, first_name, last_name, address, account_number, "
                + "mobile_number, email_address, account_balance, created_by_id"
                + ") VALUES (:id, :first_name, :last_name, :address, :account_number, "
                + ":mobile_number, :email_address, :account_balance, :created_by_id)";

        try (Connection connection = connect(getDbUrl());
             NamedParameterStatement namedStatement = new NamedParameterStatement(connection, SqlQuery)) {

            namedStatement.setParameter("id", id);
            namedStatement.setParameter("first_name", firstName);
            namedStatement.setParameter("last_name", lastName);
            namedStatement.setParameter("address", address);
            namedStatement.setParameter("account_number", accountNumber);
            namedStatement.setParameter("mobile_number", mobileNumber);
            namedStatement.setParameter("email_address", emailAddress);
            namedStatement.setParameter("account_balance", accountBalance);
            namedStatement.setParameter("created_by_id", createdById);

            namedStatement.executeUpdate();
            System.out.println("Puppy created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createPuppy(int id, String accountNumber, float accountBalance) {
        createPuppy(id, "New", "Puppy", "Country", accountNumber, "1111",
                "newpuppy@mail.com", accountBalance, 1);
    }
}
