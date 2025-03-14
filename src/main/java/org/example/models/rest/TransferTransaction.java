package org.example.models.rest;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TransferTransaction {
    private String transactionReference;
    private Date transactionDate;
    private String fromPuppyAccount;
    private String toPuppyAccount;
    private float transferAmount;
    private String currency;
}