package org.example.helpers;

import org.junit.jupiter.api.Assertions;

import static org.example.repository.PuppyRepository.getAccountBalance;

public class DbAssertions {
    public static void checkAccountBalance(float expected, int id) {
        Assertions.assertEquals(expected, getAccountBalance(id));
    }
}
