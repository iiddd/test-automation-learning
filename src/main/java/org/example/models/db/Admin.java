package org.example.models.db;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Admin {
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String lastLogin;
    private String dateJoined;
    private Boolean isSuperUser;
    private Boolean isStaff;
    private Boolean isActive;
}
