package org.example.tests.puppy.login;

import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.example.tests.puppy.base.BaseWebTest;

public class EmptyPasswordTest extends BaseWebTest {
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
