package org.example.admin.rest;

import io.restassured.response.ValidatableResponse;
import org.example.utils.RestUtils;
import org.junit.jupiter.api.Test;
import requstprovider.LoginRequestProvider;

public class CreateAdminTest {

    private final LoginRequestProvider loginRequestProvider = new LoginRequestProvider();
    private static final String USERNAME = "admin790";
    private static final String PASSWORD = "SSmog6359";

    @Test
    public void createAdminTest() {
        ValidatableResponse response = RestUtils.post(loginRequestProvider.prepareLoginRequest());
    }
}
