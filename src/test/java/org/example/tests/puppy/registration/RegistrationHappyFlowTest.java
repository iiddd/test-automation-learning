package org.example.tests.puppy.registration;

import org.example.pages.*;
import org.junit.jupiter.api.Test;
import org.example.tests.puppy.base.BaseWebTest;

public class RegistrationHappyFlowTest extends BaseWebTest {

    private static final String USERNAME = "Testaccount5";
    private static final String PASSWORD = "AbobaPuppy";
    private final RegistrationPage registrationPage = new RegistrationPage();
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final SystemUserListPage systemUserListPage = new SystemUserListPage();

    //TODO: Fix me
//    @Test
//    public void registrationHappyFlowTest() {
//        registrationPage
//                .navigateToRegistrationPage()
//                .enterUsername(USERNAME)
//                .enterPassword(PASSWORD)
//                .enterRepeatPassword(PASSWORD)
//                .clickRegistrationButton();
//        loginPage
//                .loginWithTestAccount();
//        dashboardPage
//                .checkDashboardIsDisplayed()
//                .clickSystemUsersDropdown()
//                .goToSystemUserListPage();
//        systemUserListPage
//                .goToTestAccountProfile()
//                .clickDeleteButton()
//                .clickAcceptDeleteButton();
//    }
}
