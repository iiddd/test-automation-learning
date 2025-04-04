package org.example.tests.puppy.transfer;

import io.restassured.http.Cookie;
import io.restassured.response.ValidatableResponse;
import org.example.helpers.DbAssertions;
import org.example.helpers.TestDataHelper;
import org.example.models.db.Puppy;
import org.example.pages.LoginPage;
import org.example.pages.PuppyAccountListPage;
import org.example.pages.TransferTransactionPage;
import org.example.tests.puppy.base.BaseWebTest;
import org.example.repository.PuppyRepository;
import org.example.utils.RestUtils;
import org.example.utils.UuidGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requstprovider.LoginRequestProvider;
import requstprovider.PuppyRequestProvider;

public class ChangingAccountsBalanceTest extends BaseWebTest {

    private static final int ID_SENDER = 1;
    private static final String FIRST_NAME_SENDER = "Jack";
    private static final String LAST_NAME_SENDER = "Russell";
    private static final String ACCOUNT_NUMBER_SENDER = UuidGenerator.generateUuid();
    private static final String EMAIL_SENDER = "jack@mail.com";
    private static final int ID_ACCEPTING = 2;
    private static final String FIRST_NAME_ACCEPTING = "Spitz";
    private static final String LAST_NAME_ACCEPTING = "Pomeranian";
    private static final String ACCOUNT_NUMBER_ACCEPTING = UuidGenerator.generateUuid();
    private static final String EMAIL_ACCEPTING = "spitz@mail.com";
    private final LoginPage loginPage = new LoginPage();
    private final TransferTransactionPage transferTransactionPage = new TransferTransactionPage();
    private final String TRANSFER_AMOUNT = "1";
    private final PuppyAccountListPage puppyAccountListPage = new PuppyAccountListPage();
    private final LoginRequestProvider loginRequestProvider = new LoginRequestProvider();
    private final PuppyRequestProvider puppyRequestProvider = new PuppyRequestProvider();
    private static final String COOKIE_NAME = "sessionid";


    @BeforeEach
    public void preCondition() {
        Puppy puppy = TestDataHelper.createDummyPuppy();
        puppy.setId(ID_SENDER);
        puppy.setFirstName(FIRST_NAME_SENDER);
        puppy.setLastName(LAST_NAME_SENDER);
        puppy.setAccountNumber(ACCOUNT_NUMBER_SENDER);
        puppy.setEmailAddress(EMAIL_SENDER);
        PuppyRepository.createPuppy(puppy);
        puppy.setId(ID_ACCEPTING);
        puppy.setFirstName(FIRST_NAME_ACCEPTING);
        puppy.setLastName(LAST_NAME_ACCEPTING);
        puppy.setAccountNumber(ACCOUNT_NUMBER_ACCEPTING);
        puppy.setEmailAddress(EMAIL_ACCEPTING);
        PuppyRepository.createPuppy(puppy);
        loginPage
                .loginAsAdmin()
                .clickTransferDropdown()
                .goNewTransfer();
    }

    //TODO: Fix me
//    @Test
//    public void changingAccountsBalanceTest() {
//        transferTransactionPage
//                .enterTransferAmount(TRANSFER_AMOUNT)
//                .selectFromJackRussellOption()
//                .selectToSpitzPomeranianOption()
//                .clickConfirm()
//                .clickPuppyAccountsDropdown()
//                .goPuppyAccountList();
//        puppyAccountListPage
//                .checkAccountBalance(0, ACCOUNT_NUMBER_SENDER)
//                .checkAccountBalance(2, ACCOUNT_NUMBER_ACCEPTING);
//        DbAssertions.checkAccountBalance(0, ID_SENDER);
//        DbAssertions.checkAccountBalance(2, ID_ACCEPTING);
//    }

    @AfterEach
    public void postCondition() {
        ValidatableResponse response = RestUtils.post(loginRequestProvider.prepareLoginRequest());
        String cookieValue = response.extract().cookie(COOKIE_NAME);
        Cookie cookie = new Cookie.Builder(COOKIE_NAME, cookieValue).build();
        RestUtils.post(puppyRequestProvider.deletePuppyAccount(ID_SENDER, cookie));
        RestUtils.post(puppyRequestProvider.deletePuppyAccount(ID_ACCEPTING, cookie));
    }
}
