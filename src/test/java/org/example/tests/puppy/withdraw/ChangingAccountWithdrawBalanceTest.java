package org.example.tests.puppy.withdraw;

import io.restassured.http.Cookie;
import io.restassured.response.ValidatableResponse;
import org.example.helpers.DbAssertions;
import org.example.helpers.TestDataHelper;
import org.example.models.db.Puppy;
import org.example.pages.LoginPage;
import org.example.pages.NewWithdrawPage;
import org.example.pages.PuppyAccountListPage;
import org.example.tests.puppy.base.BaseWebTest;
import org.example.repository.PuppyRepository;
import org.example.utils.RestUtils;
import org.example.utils.UuidGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requstprovider.LoginRequestProvider;
import requstprovider.PuppyRequestProvider;

public class ChangingAccountWithdrawBalanceTest extends BaseWebTest {
    private static final int ID = 1;
    private static final String ACCOUNT_NUMBER = UuidGenerator.generateUuid();
    private final LoginPage loginPage = new LoginPage();
    private final NewWithdrawPage newWithdrawPage = new NewWithdrawPage();
    private final float WITHDRAW_AMOUNT = 1;
    private final PuppyAccountListPage puppyAccountListPage = new PuppyAccountListPage();
    private final LoginRequestProvider loginRequestProvider = new LoginRequestProvider();
    private final PuppyRequestProvider puppyRequestProvider = new PuppyRequestProvider();
    private static final String COOKIE_NAME = "sessionid";

    @BeforeEach
    public void preCondition() {
        Puppy puppy = TestDataHelper.createDummyPuppy();
        puppy.setId(ID);
        puppy.setAccountNumber(ACCOUNT_NUMBER);
        PuppyRepository.createPuppy(puppy);
        loginPage
                .loginAsAdmin()
                .clickWithdrawDropdown()
                .goNewWithdraw();
    }

    //TODO: Fix me
    @Test
    public void changingAccountBalanceTest() {
        newWithdrawPage
                .enterWithdrawAmount(WITHDRAW_AMOUNT)
                .selectPuppyOption()
                .clickConfirmButton()
                .clickPuppyAccountsDropdown()
                .goPuppyAccountList();
        puppyAccountListPage
                .checkAccountBalance(0, ACCOUNT_NUMBER);
        DbAssertions.checkAccountBalance(0, ID);
    }

    @AfterEach
    public void postCondition() {
        ValidatableResponse response = RestUtils.post(loginRequestProvider.prepareLoginRequest());
        String cookieValue = response.extract().cookie(COOKIE_NAME);
        Cookie cookie = new Cookie.Builder(COOKIE_NAME, cookieValue).build();
        RestUtils.post(puppyRequestProvider.deletePuppyAccount(ID, cookie));
    }
}
