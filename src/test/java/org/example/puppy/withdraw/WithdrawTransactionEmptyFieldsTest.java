package org.example.puppy.withdraw;

import io.restassured.http.Cookie;
import io.restassured.response.ValidatableResponse;
import org.example.pages.LoginPage;
import org.example.pages.NewWithdrawPage;
import org.example.puppy.base.BaseWebTest;
import org.example.repository.PuppyRepository;
import org.example.utils.RestUtils;
import org.example.utils.UuidGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requstprovider.LoginRequestProvider;
import requstprovider.PuppyRequestProvider;

public class WithdrawTransactionEmptyFieldsTest extends BaseWebTest {
    private final LoginPage loginPage = new LoginPage();
    private final NewWithdrawPage newWithdrawPage = new NewWithdrawPage();

    @BeforeEach
    public void preCondition() {
        loginPage
                .loginAsAdmin()
                .clickWithdrawDropdown()
                .goNewWithdraw();
    }

    @Test
    public void withdrawTransactionEmptyFieldsTest() {
        newWithdrawPage
                .clearWithdrawAmountField()
                .selectPuppyOptionEmpty()
                .clickConfirmButton()
                .checkNewWithdrawPageHeaderIsDisplayed()
                .checkBrowserErrorMessageInWithdrawAmountFieldExist()
                .checkBrowserErrorMessageInPuppyFieldExist();
    }
}
