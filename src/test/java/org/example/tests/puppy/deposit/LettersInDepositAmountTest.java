package org.example.tests.puppy.deposit;

import org.example.pages.LoginPage;
import org.example.pages.NewDepositPage;
import org.example.tests.puppy.base.BaseWebTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LettersInDepositAmountTest extends BaseWebTest {

    private static final int RANDOM_AMOUNT_LENGTH = 2;
    private final LoginPage loginPage = new LoginPage();
    private final NewDepositPage newDepositPage = new NewDepositPage();

    @BeforeEach
    public void preCondition() {
        loginPage
                .loginAsAdmin()
                .clickDepositDropdown()
                .goNewDeposit();
    }

    @Test
    public void lettersInDepositAmountTest() {
        newDepositPage
                .enterRandomLettersInDepositAmountField(RANDOM_AMOUNT_LENGTH)
                .checkDepositAmountFieldIsEmpty();
    }
}
