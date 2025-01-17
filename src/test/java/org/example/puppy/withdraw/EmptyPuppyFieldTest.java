package org.example.puppy.withdraw;

import org.example.pages.BasePage;
import org.example.pages.LoginPage;
import org.example.pages.NewWithdrawPage;
import org.example.puppy.base.BaseWebTest;
import org.junit.jupiter.api.Test;

public class EmptyPuppyFieldTest extends BaseWebTest {
    private final LoginPage loginPage = new LoginPage();
    private final BasePage basePage = new BasePage();
    private final NewWithdrawPage newWithdrawPage = new NewWithdrawPage();
    private final float WITHDRAW_AMOUNT = 1;

    @Test
    public void emptyPuppyFieldTest() {
        loginPage
                .loginAsAdmin();
        basePage
                .clickWithdrawDropdown()
                .goNewWithdraw();
        newWithdrawPage
                .enterWithdrawAmount(WITHDRAW_AMOUNT)
                .selectPuppyOptionEmpty()
                .clickConfirmButton()
                .checkNewWithdrawPageHeaderIsDisplayed();
    }
}
