package org.example.puppy.login;

import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.example.puppy.base.BaseWebTest;

public class WrongPasswordTest extends BaseWebTest {
    private static final String USERNAME = "admin";
    private static final int RANDOM_PASSWORD_LENGHT = 6;
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void wrongPasswordTest() {
        loginPage
                .navigateToPuppyPage()
                .enterUsername(USERNAME)
                .enterRandomPassword(RANDOM_PASSWORD_LENGHT)
                .clickLoginButton()
                .checkErrorMessageIsDisplayed();

    }
}
