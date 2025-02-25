package org.example.puppy.withdraw;

import org.example.pages.LoginPage;
import org.example.pages.NewWithdrawPage;
import org.example.puppy.base.BaseWebTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LettersInAmountTest extends BaseWebTest {
    private final LoginPage loginPage = new LoginPage();
    private final NewWithdrawPage newWithdrawPage = new NewWithdrawPage();
    private static final int RANDOM_AMOUNT_LENGTH = 2;


    @BeforeEach
    public void preCondition() {
        loginPage
                .loginAsAdmin()
                .clickWithdrawDropdown()
                .goNewWithdraw();
    }

    @Test
    public void lettersInAmountTest() {
        newWithdrawPage
                .enterRandomLettersInWithdrawAmountField(RANDOM_AMOUNT_LENGTH)
                .checkWithdrawAmountFieldIsEmpty();
    }
}
