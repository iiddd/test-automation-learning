package org.example.tests.puppy.deposit;

import io.restassured.http.Cookie;
import io.restassured.response.ValidatableResponse;
import org.example.helpers.DbAssertions;
import org.example.helpers.TestDataHelper;
import org.example.models.db.Puppy;
import org.example.pages.LoginPage;
import org.example.pages.NewDepositPage;
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

public class ChangingAccountBalanceTest extends BaseWebTest {

    private static final int ID = 34;
    private static final String ACCOUNT_NUMBER = UuidGenerator.generateUuid();
    private static final String COOKIE_NAME = "sessionid";
    private final LoginPage loginPage = new LoginPage();
    private final NewDepositPage newDepositPage = new NewDepositPage();
    private final float DEPOSIT_AMOUNT = 1;
    private final PuppyAccountListPage puppyAccountListPage = new PuppyAccountListPage();
    private final LoginRequestProvider loginRequestProvider = new LoginRequestProvider();
    private final PuppyRequestProvider puppyRequestProvider = new PuppyRequestProvider();

    @BeforeEach
    public void preCondition() {
        Puppy puppy = TestDataHelper.createPuppyForDeposit();
        puppy.setAccountNumber(ACCOUNT_NUMBER);
        PuppyRepository.createPuppy(puppy);
        loginPage
                .loginAsAdmin()
                .clickDepositDropdown()
                .goNewDeposit();
    }

    @Test
    public void changingAccountBalanceTest() {
        newDepositPage
                .enterDepositAmount(DEPOSIT_AMOUNT)
                .selectPuppyOption()
                .clickConfirmButton()
                .clickPuppyAccountsDropdown()
                .goPuppyAccountList();
        puppyAccountListPage
                .checkAccountBalance(1, ACCOUNT_NUMBER);
        DbAssertions.checkAccountBalance(1, ID);
    }

    @AfterEach
    public void postCondition() {
        ValidatableResponse response = RestUtils.post(loginRequestProvider.prepareLoginRequest());
        String cookieValue = response.extract().cookie(COOKIE_NAME);
        Cookie cookie = new Cookie.Builder(COOKIE_NAME, cookieValue).build();
        RestUtils.post(puppyRequestProvider.deletePuppyAccount(ID, cookie));
    }
}
