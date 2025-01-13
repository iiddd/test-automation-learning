package org.example.puppy.login;

import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.example.puppy.base.BaseWebTest;

public class EmptyLoginTest extends BaseWebTest {
    private static final String PASSWORD = "password";
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void emptyLoginTest() {
        loginPage
                .navigateToPuppyPage()
                .clearUsername()
                .enterPassword(PASSWORD)
                .clickLoginButton()
                .checkLoginPageTitleIsDisplayed();
    }
}
