package org.example.tests.puppy.transfer;

import io.restassured.http.Cookie;
import io.restassured.response.ValidatableResponse;
import org.example.helpers.TestDataHelper;
import org.example.models.db.Puppy;
import org.example.pages.LoginPage;
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

public class SymbolsInsteadNumbersTest extends BaseWebTest {
    private static final int ID_SENDER = 14;
    private static final int ID_ACCEPTING = 24;
    private static final String FIRST_NAME_SENDER = "Jack";
    private static final String FIRST_NAME_ACCEPTING = "Spitz";
    private static final String LAST_NAME_SENDER = "Russell";
    private static final String LAST_NAME_ACCEPTING = "Pomeranian";
    private static final String ACCOUNT_NUMBER_SENDER = UuidGenerator.generateUuid();
    private static final String ACCOUNT_NUMBER_ACCEPTING = UuidGenerator.generateUuid();
    private static final String EMAIL_SENDER = "jack@mail.com";
    private static final String EMAIL_ACCEPTING = "spitz@mail.com";
    private final LoginPage loginPage = new LoginPage();
    private final TransferTransactionPage transferTransactionPage = new TransferTransactionPage();
    private static final String TRANSFER_AMOUNT = "+";
    private static final String TRANSFER_AMOUNT_ERROR_MESSAGE = "Please enter a number.";
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

    //TODO: Doesn't work on CI
//    @Test
//    public void symbolsInsteadNumbersTest() {
//        transferTransactionPage
//                .enterTransferAmount(TRANSFER_AMOUNT)
//                .selectFromJackRussellOption()
//                .selectToSpitzPomeranianOption()
//                .clickConfirm()
//                .checkTransferTransactionTitleIsDisplayed()
//                .checkErrorMessageTransferAmountFieldExist()
//                .checkErrorMessageInTransferAmountFieldIsCorrect(TRANSFER_AMOUNT_ERROR_MESSAGE);
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
