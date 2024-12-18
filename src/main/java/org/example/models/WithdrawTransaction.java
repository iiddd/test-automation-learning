package org.example.models;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class WithdrawTransaction {
    private String transactionReference;
    private Date transactionDate;
    private String puppyName;
    private float withdrawAmount;
    private float startBalance;
    private float newBalance;
    private String currency;
}
