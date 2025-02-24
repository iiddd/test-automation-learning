package org.example.puppy.systemUser;

import org.example.pages.LoginPage;
import org.example.pages.NewSystemUserPage;
import org.example.puppy.base.BaseWebTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsernameAndPasswordAreSameTest extends BaseWebTest {

    private final LoginPage loginPage = new LoginPage();
    private final NewSystemUserPage newSystemUserPage = new NewSystemUserPage();
    private final String USERNAME_AND_PASSWORD = "admin0000";

    @BeforeEach
    public void preCondition() {
        loginPage
                .loginAsAdmin()
                .clickSystemUsersDropdown()
                .goToNewSystemUser();
    }

    @Test
    public void usernameAndPasswordAreSameTest() {
        newSystemUserPage
                .enterUsername(USERNAME_AND_PASSWORD)
                .enterPassword(USERNAME_AND_PASSWORD)
                .enterRepeatPassword(USERNAME_AND_PASSWORD)
                .clickConfirmButton()
                .checkNewSystemUserIsDisplayed()
                .checkErrorSamePasswordAndUsernameIsDisplayed();
    }
}
