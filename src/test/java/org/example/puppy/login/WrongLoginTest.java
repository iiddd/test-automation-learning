package org.example.puppy.login;

import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.example.puppy.base.BaseWebTest;

public class WrongLoginTest extends BaseWebTest {
    private static final int RANDOM_USERNAME_LENGHT = 6;
    private static final String PASSWORD = "password";
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void wrongLoginTest() {
        loginPage
                .navigateToPuppyPage()
                .enterRandomUsername(RANDOM_USERNAME_LENGHT)
                .enterPassword(PASSWORD)
                .clickLoginButton()
                .checkErrorMessageIsDisplayed();

    }

}
