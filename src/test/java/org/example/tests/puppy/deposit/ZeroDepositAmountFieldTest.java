package org.example.tests.puppy.deposit;

import io.restassured.http.Cookie;
import io.restassured.response.ValidatableResponse;
import org.example.helpers.TestDataHelper;
import org.example.models.db.Puppy;
import org.example.pages.LoginPage;
import org.example.pages.NewDepositPage;
import org.example.tests.puppy.base.BaseWebTest;
import org.example.repository.PuppyRepository;
import org.example.utils.RestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requstprovider.LoginRequestProvider;
import requstprovider.PuppyRequestProvider;

public class ZeroDepositAmountFieldTest extends BaseWebTest {

    private static final int ID = 34;
    private static final String COOKIE_NAME = "sessionid";
    private final LoginPage loginPage = new LoginPage();
    private final NewDepositPage newDepositPage = new NewDepositPage();
    private final float DEPOSIT_AMOUNT = 0;
    private final LoginRequestProvider loginRequestProvider = new LoginRequestProvider();
    private final PuppyRequestProvider puppyRequestProvider = new PuppyRequestProvider();

    @BeforeEach
    public void preCondition() {
        Puppy puppy = TestDataHelper.createPuppyForDeposit();
        PuppyRepository.createPuppy(puppy);
        loginPage
                .loginAsAdmin()
                .clickDepositDropdown()
                .goNewDeposit();
    }

    @Test
    public void zeroDepositAmountFieldTest() {
        newDepositPage
                .enterDepositAmount(DEPOSIT_AMOUNT)
                .selectPuppyOption()
                .clickConfirmButton()
                .checkNewDepositPageHeaderIsDisplayed()
                .checkZeroDepositAmountErrorIsDisplayed();
    }

    @AfterEach
    public void postCondition() {
        ValidatableResponse response = RestUtils.post(loginRequestProvider.prepareLoginRequest());
        String cookieValue = response.extract().cookie(COOKIE_NAME);
        Cookie cookie = new Cookie.Builder(COOKIE_NAME, cookieValue).build();
        RestUtils.post(puppyRequestProvider.deletePuppyAccount(ID, cookie));
    }
}
