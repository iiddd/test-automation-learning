package org.example.puppy.withdraw;

import io.restassured.http.Cookie;
import io.restassured.response.ValidatableResponse;
import org.example.pages.*;
import org.example.puppy.base.BaseWebTest;
import org.example.utils.PuppyRepository;
import org.example.utils.RestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requstprovider.LoginRequestProvider;
import requstprovider.PuppyRequestProvider;

public class WithdrawTransactionHappyFlowTest extends BaseWebTest {
    private static final int ID = 1;
    private static final double ACCOUNT_BALANCE = 1;
    private final LoginPage loginPage = new LoginPage();
    private final BasePage basePage = new BasePage();
    private final NewWithdrawPage newWithdrawPage = new NewWithdrawPage();
    private final WithdrawTransactionListPage withdrawTransactionListPage = new WithdrawTransactionListPage();
    private final float WITHDRAW_AMOUNT = 1;
    private String TRANSACTION_ID = "";
    private final LoginRequestProvider loginRequestProvider = new LoginRequestProvider();
    private final PuppyRequestProvider puppyRequestProvider = new PuppyRequestProvider();
    private static final String COOKIE_NAME = "sessionid";

    @BeforeEach
    public void preCondition() {
       PuppyRepository.createPuppyBalance(ID, ACCOUNT_BALANCE);
        loginPage
                .loginAsAdmin();
        basePage
                .clickWithdrawDropdown()
                .goNewWithdraw();
    }

    @Test
    public void withdrawTransactionHappyFlowTest() {
        TRANSACTION_ID = newWithdrawPage.getTransactionReference();
        newWithdrawPage
                .enterWithdrawAmount(WITHDRAW_AMOUNT)
                .selectPuppyOption()
                .clickConfirmButton();
        withdrawTransactionListPage
                .checkWithdrawTransactionListIsDisplayed()
                .checkTransactionListContainsTransaction(TRANSACTION_ID);
    }

    @AfterEach
    public void postCondition() {
        ValidatableResponse response = RestUtils.post(loginRequestProvider.prepareLoginRequest());
        String cookieValue = response.extract().cookie(COOKIE_NAME);
        Cookie cookie = new Cookie.Builder(COOKIE_NAME, cookieValue).build();
        RestUtils.post(puppyRequestProvider.deletePuppyAccount(ID, cookie));
    }
}
