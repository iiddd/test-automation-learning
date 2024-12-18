package org.example.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PuppyAccount {
    private String firstName;
    private String lastName;
    private String accountNumber;
    private String emailAddress;
    private float balance;
}
