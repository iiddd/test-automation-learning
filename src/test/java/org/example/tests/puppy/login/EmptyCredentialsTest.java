package org.example.tests.puppy.login;

import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.example.tests.puppy.base.BaseWebTest;

public class EmptyCredentialsTest extends BaseWebTest {
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void emptyCredentialsTest() {
        loginPage
                .navigateToPuppyPage()
                .clearUsername()
                .clearPassword()
                .clickLoginButton()
                .checkLoginPageTitleIsDisplayed();
    }
}
