package org.example.tests.puppy.withdraw;

import org.example.pages.LoginPage;
import org.example.pages.NewWithdrawPage;
import org.example.tests.puppy.base.BaseWebTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LettersInWithdrawAmountTest extends BaseWebTest {
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

    //TODO: Doesn't work on CI
    @Test
    public void lettersInAmountTest() {
        newWithdrawPage
                .enterRandomLettersInWithdrawAmountField(RANDOM_AMOUNT_LENGTH)
                .checkWithdrawAmountFieldIsEmpty();
    }
}
