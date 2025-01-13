package org.example.models.db;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Puppy {
    private int id;
    private String accountNumber;
    private float accountBalance;
    private String firstName;
    private String lastName;
    private String address;
    private String mobileNumber;
    private String emailAddress;
    private int createdById;
}
