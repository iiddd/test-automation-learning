package org.example.puppy.systemUser;

import org.example.pages.LoginPage;
import org.example.pages.NewSystemUserPage;
import org.example.puppy.base.BaseWebTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DifferentPasswordsTest extends BaseWebTest {

    private final LoginPage loginPage = new LoginPage();
    private final NewSystemUserPage newSystemUserPage = new NewSystemUserPage();
    private final String USERNAME = "admin0000";
    private final String PASSWORD = "Ssmog790";
    private final String REPEAT_PASSWORD = "Ssmog890";

    @BeforeEach
    public void preCondition() {
        loginPage
                .loginAsAdmin()
                .clickSystemUsersDropdown()
                .goToNewSystemUser();
    }

    @Test
    public void differentPasswordsTest() {
        newSystemUserPage
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .enterRepeatPassword(REPEAT_PASSWORD)
                .clickConfirmButton()
                .checkNewSystemUserIsDisplayed()
                .checkErrorPasswordDidNotMatchIsDisplayed();
    }
}
