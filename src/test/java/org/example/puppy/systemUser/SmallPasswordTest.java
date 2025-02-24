package org.example.puppy.systemUser;

import org.example.pages.LoginPage;
import org.example.pages.NewSystemUserPage;
import org.example.puppy.base.BaseWebTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SmallPasswordTest extends BaseWebTest {

    private final LoginPage loginPage = new LoginPage();
    private final NewSystemUserPage newSystemUserPage = new NewSystemUserPage();
    private final String USERNAME = "admin0000";
    private final String PASSWORD = "smog";

    @BeforeEach
    public void preCondition() {
        loginPage
                .loginAsAdmin()
                .clickSystemUsersDropdown()
                .goToNewSystemUser();
    }

    @Test
    public void smallPasswordTest() {
        newSystemUserPage
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .enterRepeatPassword(PASSWORD)
                .clickConfirmButton()
                .checkNewSystemUserIsDisplayed()
                .checkErrorSmallPasswordIsDisplayed();
    }
}
