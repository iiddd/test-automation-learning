package org.example.puppy.withdraw;

import org.example.pages.BasePage;
import org.example.pages.LoginPage;
import org.example.pages.NewWithdrawPage;
import org.example.puppy.base.BaseWebTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LettersInAmountTest extends BaseWebTest {
    private final LoginPage loginPage = new LoginPage();
    private final BasePage basePage = new BasePage();
    private final NewWithdrawPage newWithdrawPage = new NewWithdrawPage();
    private static final int RANDOM_AMOUNT_LENGHT = 2;


    @BeforeEach
    public void preCondition() {
        loginPage
                .loginAsAdmin();
        basePage
                .clickWithdrawDropdown()
                .goNewWithdraw();
    }
    @Test
    public void lettersInAmountTest() {
        newWithdrawPage
                .enterRandomLetters(RANDOM_AMOUNT_LENGHT)
                .checkWithdrawAmountFieldIsEmpty();
    }
}
