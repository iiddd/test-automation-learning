package org.example.tests.admin.rest;

import io.restassured.http.Cookie;
import io.restassured.response.ValidatableResponse;
import org.example.utils.RestUtils;
import org.junit.jupiter.api.Test;
import requstprovider.AdminRequestProvider;
import requstprovider.LoginRequestProvider;

public class CreateAdminTest {

    private final LoginRequestProvider loginRequestProvider = new LoginRequestProvider();
    private final AdminRequestProvider adminRequestProvider = new AdminRequestProvider();
    private static final String USERNAME = "admin780";
    private static final String PASSWORD = "SSmog6359";
    private static final String COOKIE_NAME = "sessionid";

    //TODO: Fix me
//    @Test
//    public void createAdminTest() {
//        ValidatableResponse response = RestUtils.post(loginRequestProvider.prepareLoginRequest());
//        String cookieValue = response.extract().cookie(COOKIE_NAME);
//        Cookie cookie = new Cookie.Builder(COOKIE_NAME, cookieValue).build();
//        RestUtils.post(adminRequestProvider.createAdminAccount(USERNAME, PASSWORD, cookie));
//TODO: Finish test with UI
//    }
}
