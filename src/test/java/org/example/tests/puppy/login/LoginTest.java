package org.example.tests.puppy.login;

import org.example.pages.DashboardPage;
import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.example.tests.puppy.base.BaseWebTest;


public class LoginTest extends BaseWebTest {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void loginTest() {
        loginPage
                .navigateToPuppyPage()
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .clickLoginButton();
        dashboardPage
                .checkDashboardIsDisplayed();
    }
}
