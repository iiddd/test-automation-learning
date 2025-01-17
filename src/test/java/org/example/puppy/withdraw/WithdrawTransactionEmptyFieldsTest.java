package org.example.puppy.withdraw;

import org.example.pages.BasePage;
import org.example.pages.LoginPage;
import org.example.pages.NewWithdrawPage;
import org.example.puppy.base.BaseWebTest;
import org.junit.jupiter.api.Test;

public class WithdrawTransactionEmptyFieldsTest extends BaseWebTest {
    private final LoginPage loginPage = new LoginPage();
    private final BasePage basePage = new BasePage();
    private final NewWithdrawPage newWithdrawPage = new NewWithdrawPage();

    @Test
    public void withdrawTransactionEmptyFieldsTest() {
        loginPage
                .loginAsAdmin();
        basePage
                .clickWithdrawDropdown()
                .goNewWithdraw();
        newWithdrawPage
                .clearWithdrawAmountField()
                .selectPuppyOptionEmpty()
                .clickConfirmButton()
                .checkNewWithdrawPageHeaderIsDisplayed();
    }
}
