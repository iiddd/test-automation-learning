package org.example.admin.db;

import org.example.utils.PuppyRepository;
import org.junit.jupiter.api.Test;

public class CreateAdminDbTest {

    @Test
    public void createAdminTest() {
        //Define SQL request
        String sql = "INSERT INTO auth_user (\n" +
                "    id, \n" +
                "    password, \n" +
                "    last_login, \n" +
                "    is_superuser, \n" +
                "    username, \n" +
                "    last_name, \n" +
                "    email, \n" +
                "    is_staff, \n" +
                "    is_active, \n" +
                "    date_joined, \n" +
                "    first_name\n" +
                ") \n" +
                "VALUES (\n" +
                "    2, \n" +
                "    'hashed_password123', \n" +
                "    '2025-01-12 10:00:00', \n" +
                "    1, \n" +
                "    'john_doe', \n" +
                "    'Doe', \n" +
                "    'john.doe@example.com', \n" +
                "    1, \n" +
                "    1, \n" +
                "    '2025-01-01 08:00:00', \n" +
                "    'John'\n" +
                ");";

        //Shot and forget request example:
        PuppyRepository.executeSqlCommand(sql);

        //Extract DB data example:
        PuppyRepository.getAdmins();
        PuppyRepository.getPuppies();

        //TODO: Create functions to create Admin/Puppy with DB with DSL (e.g. avoiding shot and forget)
    }
}
