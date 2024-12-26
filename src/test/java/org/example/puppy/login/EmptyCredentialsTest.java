package org.example.puppy.login;

import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.example.puppy.base.BaseTest;

public class EmptyCredentialsTest extends BaseTest {
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