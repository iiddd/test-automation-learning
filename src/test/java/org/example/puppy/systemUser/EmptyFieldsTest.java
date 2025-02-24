package org.example.puppy.systemUser;

import org.example.pages.LoginPage;
import org.example.pages.NewSystemUserPage;
import org.example.puppy.base.BaseWebTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmptyFieldsTest extends BaseWebTest {

    private final LoginPage loginPage = new LoginPage();
    private final NewSystemUserPage newSystemUserPage = new NewSystemUserPage();
    private static final String EMPTY_USERNAME_FIELD_MESSAGE = "Please fill in this field.";
    private static final String EMPTY_PASSWORD_FIELD_MESSAGE = "Please fill in this field.";
    private static final String EMPTY_REPEAT_PASSWORD_FIELD_MESSAGE = "Please fill in this field.";


    @BeforeEach
    public void preCondition() {
        loginPage
                .loginAsAdmin()
                .clickSystemUsersDropdown()
                .goToNewSystemUser();
    }

    @Test
    public void emptyFieldsTest() {
        newSystemUserPage
                .clearUsername()
                .clearPassword()
                .clearRepeatPassword()
                .clickConfirmButton()
                .checkNewSystemUserIsDisplayed()
                .checkErrorEmptyUsernameFieldExist()
                .checkErrorMessageInUsernameFieldIsCorrect(EMPTY_USERNAME_FIELD_MESSAGE)
                .checkErrorEmptyPasswordFieldExist()
                .checkErrorMessageInPasswordFieldIsCorrect(EMPTY_PASSWORD_FIELD_MESSAGE)
                .checkErrorEmptyRepeatPasswordFieldExist()
                .checkErrorMessageInRepeatPasswordFieldIsCorrect(EMPTY_REPEAT_PASSWORD_FIELD_MESSAGE);
    }
}
