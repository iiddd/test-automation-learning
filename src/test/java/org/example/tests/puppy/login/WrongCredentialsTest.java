package org.example.tests.puppy.login;

import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.example.tests.puppy.base.BaseWebTest;

public class WrongCredentialsTest extends BaseWebTest {
    private static final int RANDOM_CREDENTIALS_LENGHT = 6;
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void wrongCredentialsTest() {
        loginPage
                .navigateToPuppyPage()
                .enterRandomUsername(RANDOM_CREDENTIALS_LENGHT)
                .enterRandomPassword(RANDOM_CREDENTIALS_LENGHT)
                .clickLoginButton()
                .checkErrorMessageIsDisplayed();

    }
}
