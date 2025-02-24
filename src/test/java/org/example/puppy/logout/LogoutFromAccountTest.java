package org.example.puppy.logout;

import org.example.pages.DashboardPage;
import org.example.pages.LoginPage;
import org.example.puppy.base.BaseWebTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LogoutFromAccountTest extends BaseWebTest {

    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();

    @BeforeEach
    public void preCondition() {
        loginPage
                .loginAsAdmin();
    }

    @Test
    public void logoutFromAccountTest() {
        dashboardPage
                .clickUserDropdown()
                .clickLogoutDropdown()
                .clickLogoutButton();
        loginPage
                .checkLoginPageTitleIsDisplayed();
    }
}
