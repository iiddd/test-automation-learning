package org.example.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Puppy {
    private String accountNumber;
    private float accountBalance;
    private String firstName;
    private String lastName;
    private String address;
    private String mobileNumber;
    private String emailAddress;
}
