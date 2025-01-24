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

public class ZeroTransferAmountTest extends BaseWebTest {

    private static final int ID1 = 1;
    private static final String FIRST_NAME1 = "Jack";
    private static final String LAST_NAME1 = "Russell";
    private static final int ID2 = 2;
    private static final String FIRST_NAME2 = "Spitz";
    private static final String LAST_NAME2 = "Pomeranian";
    private static final String ACCOUNT_NUMBER1 = UuidGenerator.generateUuid();
    private static final String ACCOUNT_NUMBER2 = UuidGenerator.generateUuid();
    private static final String EMAIL1 = "jack@mail.com";
    private static final String EMAIL2 = "spitz@mail.com";
    private static final float ACCOUNT_BALANCE = 1;
    private final LoginPage loginPage = new LoginPage();
    private final TransferTransactionPage transferTransactionPage = new TransferTransactionPage();
    private static final String TRANSFER_AMOUNT = "0";
    private final LoginRequestProvider loginRequestProvider = new LoginRequestProvider();
    private final PuppyRequestProvider puppyRequestProvider = new PuppyRequestProvider();
    private static final String COOKIE_NAME = "sessionid";

    @BeforeEach
    public void preCondition() {
        PuppyRepository.createPuppy(ID1, FIRST_NAME1, LAST_NAME1, ACCOUNT_NUMBER1, EMAIL1, ACCOUNT_BALANCE);
        PuppyRepository.createPuppy(ID2, FIRST_NAME2, LAST_NAME2, ACCOUNT_NUMBER2, EMAIL2, ACCOUNT_BALANCE);
        loginPage
                .loginAsAdmin()
                .clickTransferDropdown()
                .goNewTransfer();
    }

    @Test
    public void zeroTransferAmountTest() {
        transferTransactionPage
                .enterTransferAmount(TRANSFER_AMOUNT)
                .selectFromJackRussellOption()
                .selectToSpitzPomeranianOption()
                .clickConfirm()
                .checkTransferTransactionTitleIsDisplayed()
                .checkErrorCreateZero();
    }

    @AfterEach
    public void postCondition() {
        ValidatableResponse response = RestUtils.post(loginRequestProvider.prepareLoginRequest());
        String cookieValue = response.extract().cookie(COOKIE_NAME);
        Cookie cookie = new Cookie.Builder(COOKIE_NAME, cookieValue).build();
        RestUtils.post(puppyRequestProvider.deletePuppyAccount(ID1, cookie));
        RestUtils.post(puppyRequestProvider.deletePuppyAccount(ID2, cookie));
    }
}