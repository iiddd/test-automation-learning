package org.example.puppy.systemUser;

import io.restassured.http.Cookie;
import io.restassured.response.ValidatableResponse;
import org.example.pages.LoginPage;
import org.example.pages.NewSystemUserPage;
import org.example.pages.SystemUserListPage;
import org.example.puppy.base.BaseWebTest;
import org.example.repository.PuppyRepository;
import org.example.utils.RestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requstprovider.AdminRequestProvider;
import requstprovider.LoginRequestProvider;
import requstprovider.PuppyRequestProvider;

public class CreateSystemUserHappyFlowTest extends BaseWebTest {

    private final LoginPage loginPage = new LoginPage();
    private final NewSystemUserPage newSystemUserPage = new NewSystemUserPage();
    private final SystemUserListPage systemUserListPage = new SystemUserListPage();
    private static final String USERNAME = "admin0000";
    private static final String PASSWORD = "Ssmog790";
    private final LoginRequestProvider loginRequestProvider = new LoginRequestProvider();
    private final AdminRequestProvider adminRequestProvider = new AdminRequestProvider();
    private static final String COOKIE_NAME = "sessionid";


    @BeforeEach
    public void preCondition() {
        loginPage
                .loginAsAdmin()
                .clickSystemUsersDropdown()
                .goToNewSystemUser();
    }

    @Test
    public void createSystemUserHappyFlowTest() {
        newSystemUserPage
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .enterRepeatPassword(PASSWORD)
                .clickConfirmButton();
        systemUserListPage
                .checkSystemUserListIsDisplayed()
                .checkSystemUserListContainsUsername(USERNAME);
    }

    @AfterEach
    public void postCondition() {
        int ID = PuppyRepository.getAdminId(USERNAME);
        ValidatableResponse response = RestUtils.post(loginRequestProvider.prepareLoginRequest());
        String cookieValue = response.extract().cookie(COOKIE_NAME);
        Cookie cookie = new Cookie.Builder(COOKIE_NAME, cookieValue).build();
        RestUtils.post(adminRequestProvider.deleteAdminAccount(ID, cookie));
    }

}
