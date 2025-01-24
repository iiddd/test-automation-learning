package org.example.puppy.transfer;

import io.restassured.http.Cookie;
import io.restassured.response.ValidatableResponse;
import org.example.pages.LoginPage;
import org.example.pages.TransferTransactionPage;
import org.example.puppy.base.BaseWebTest;
import org.example.repository.PuppyRepository;
import org.example.utils.RestUtils;
import org.example.utils.UuidGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requstprovider.LoginRequestProvider;
import requstprovider.PuppyRequestProvider;

public class UsageOnePuppyAccountTest extends BaseWebTest {
    private static final int ID = 1;
    private static final String ACCOUNT_NUMBER = UuidGenerator.generateUuid();
    private static final float ACCOUNT_BALANCE = 1;
    private final LoginPage loginPage = new LoginPage();
    private final TransferTransactionPage transferTransactionPage = new TransferTransactionPage();
    private static final String TRANSFER_AMOUNT = "1";
    private final LoginRequestProvider loginRequestProvider = new LoginRequestProvider();
    private final PuppyRequestProvider puppyRequestProvider = new PuppyRequestProvider();
    private static final String COOKIE_NAME = "sessionid";

    @BeforeEach
    public void preCondition() {
        PuppyRepository.createPuppy(ID, ACCOUNT_NUMBER, ACCOUNT_BALANCE);
        loginPage
                .loginAsAdmin()
                .clickTransferDropdown()
                .goNewTransfer();
    }

    @Test
    public void usageOnePuppyAccountTest() {
        transferTransactionPage
                .enterTransferAmount(TRANSFER_AMOUNT)
                .selectFromNewPuppyOption()
                .selectToNewPuppyOption()
                .clickConfirm()
                .checkTransferTransactionTitleIsDisplayed()
                .checkErrorSamePuppies();
    }

    @AfterEach
    public void postCondition() {
        ValidatableResponse response = RestUtils.post(loginRequestProvider.prepareLoginRequest());
        String cookieValue = response.extract().cookie(COOKIE_NAME);
        Cookie cookie = new Cookie.Builder(COOKIE_NAME, cookieValue).build();
        RestUtils.post(puppyRequestProvider.deletePuppyAccount(ID, cookie));
    }
}