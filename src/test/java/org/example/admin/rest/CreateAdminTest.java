package org.example.admin.rest;

import io.restassured.http.Cookie;
import io.restassured.response.ValidatableResponse;
import org.example.pages.LoginPage;
import org.example.pages.SystemUserListPage;
import org.example.puppy.base.BaseWebTest;
import org.example.utils.RestUtils;
import org.junit.jupiter.api.Test;
import requstprovider.AdminRequestProvider;
import requstprovider.LoginRequestProvider;

public class CreateAdminTest extends BaseWebTest {

    private final LoginRequestProvider loginRequestProvider = new LoginRequestProvider();
    private final AdminRequestProvider adminRequestProvider = new AdminRequestProvider();
    private final LoginPage loginPage = new LoginPage();
    private final SystemUserListPage systemUserListPage = new SystemUserListPage();
    private static final String USERNAME = "admin780";
    private static final String PASSWORD = "SSmog6359";
    private static final String COOKIE_NAME = "sessionid";

    @Test
    public void createAdminTest() {
        ValidatableResponse response = RestUtils.post(loginRequestProvider.prepareLoginRequest());
        String cookieValue = response.extract().cookie(COOKIE_NAME);
        Cookie cookie = new Cookie.Builder(COOKIE_NAME, cookieValue).build();
        RestUtils.post(adminRequestProvider.createAdminAccount(USERNAME, PASSWORD, cookie));
        loginPage
                .navigateToPuppyPage()
                .loginAsAdmin()
                .clickSystemUsersDropdown()
                .goToSystemUserListPage();
        systemUserListPage
                .checkAdminAccountProfile()
                .goToAdminAccountProfile()
                .clickDeleteButton()
                .clickAcceptDeleteButton();
    }
}
