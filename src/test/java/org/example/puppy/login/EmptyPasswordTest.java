package org.example.puppy.login;

import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.example.puppy.base.BaseTest;

public class EmptyPasswordTest extends BaseTest {
    private static final String USERNAME = "admin";
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void emptyPasswordTest() {
        loginPage
                .navigateToPuppyPage()
                .enterUsername(USERNAME)
                .clearPassword()
                .clickLoginButton()
                .checkLoginPageTitleIsDisplayed();
    }

}
