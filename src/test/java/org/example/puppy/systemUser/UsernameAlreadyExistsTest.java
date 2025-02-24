package org.example.puppy.systemUser;

import io.restassured.http.Cookie;
import io.restassured.response.ValidatableResponse;
import org.example.helpers.TestDataHelper;
import org.example.models.db.Admin;
import org.example.pages.LoginPage;
import org.example.pages.NewSystemUserPage;
import org.example.puppy.base.BaseWebTest;
import org.example.repository.PuppyRepository;
import org.example.utils.RestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requstprovider.AdminRequestProvider;
import requstprovider.LoginRequestProvider;

public class UsernameAlreadyExistsTest extends BaseWebTest {

    private final LoginPage loginPage = new LoginPage();
    private final NewSystemUserPage newSystemUserPage = new NewSystemUserPage();
    private static final int ID = 2;
    private static final String USERNAME = "admin0000";
    private static final String PASSWORD = "Ssmog790";
    private final LoginRequestProvider loginRequestProvider = new LoginRequestProvider();
    private final AdminRequestProvider adminRequestProvider = new AdminRequestProvider();
    private static final String COOKIE_NAME = "sessionid";

    @BeforeEach
    public void preCondition() {
        Admin admin = TestDataHelper.createDummyAdmin();
        admin.setId(ID);
        admin.setUsername(USERNAME);
        PuppyRepository.createAdmin(admin);
        loginPage
                .loginAsAdmin()
                .clickSystemUsersDropdown()
                .goToNewSystemUser();
    }

    @Test
    public void usernameAlreadyExistsTest() {
        newSystemUserPage
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .enterRepeatPassword(PASSWORD)
                .clickConfirmButton()
                .checkNewSystemUserIsDisplayed()
                .checkErrorUsernameAlreadyExistsIsDisplayed();
    }

    @AfterEach
    public void postCondition() {
        ValidatableResponse response = RestUtils.post(loginRequestProvider.prepareLoginRequest());
        String cookieValue = response.extract().cookie(COOKIE_NAME);
        Cookie cookie = new Cookie.Builder(COOKIE_NAME, cookieValue).build();
        RestUtils.post(adminRequestProvider.deleteAdminAccount(ID, cookie));
    }
}
