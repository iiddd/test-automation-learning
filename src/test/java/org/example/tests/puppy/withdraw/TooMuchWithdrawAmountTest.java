package org.example.tests.puppy.withdraw;

import io.restassured.http.Cookie;
import io.restassured.response.ValidatableResponse;
import org.example.helpers.TestDataHelper;
import org.example.models.db.Puppy;
import org.example.pages.LoginPage;
import org.example.pages.NewWithdrawPage;
import org.example.tests.puppy.base.BaseWebTest;
import org.example.repository.PuppyRepository;
import org.example.utils.RestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requstprovider.LoginRequestProvider;
import requstprovider.PuppyRequestProvider;

public class TooMuchWithdrawAmountTest extends BaseWebTest {
    private static final int ID = 1;
    private final LoginPage loginPage = new LoginPage();
    private final NewWithdrawPage newWithdrawPage = new NewWithdrawPage();
    private final float WITHDRAW_AMOUNT = 2;
    private final LoginRequestProvider loginRequestProvider = new LoginRequestProvider();
    private final PuppyRequestProvider puppyRequestProvider = new PuppyRequestProvider();
    private static final String COOKIE_NAME = "sessionid";

    @BeforeEach
    public void preCondition() {
        Puppy puppy = TestDataHelper.createDummyPuppy();
        puppy.setId(ID);
        PuppyRepository.createPuppy(puppy);
        loginPage
                .loginAsAdmin()
                .clickWithdrawDropdown()
                .goNewWithdraw();
    }

    //TODO: Fix me
    @Test
    public void tooMuchAmountTest() {
        newWithdrawPage
                .enterWithdrawAmount(WITHDRAW_AMOUNT)
                .selectPuppyOption()
                .clickConfirmButton()
                .checkNewWithdrawPageHeaderIsDisplayed()
                .checkTooMuchAmountErrorIsDisplayed();
    }

    @AfterEach
    public void postCondition() {
        ValidatableResponse response = RestUtils.post(loginRequestProvider.prepareLoginRequest());
        String cookieValue = response.extract().cookie(COOKIE_NAME);
        Cookie cookie = new Cookie.Builder(COOKIE_NAME, cookieValue).build();
        RestUtils.post(puppyRequestProvider.deletePuppyAccount(ID, cookie));
    }
}
