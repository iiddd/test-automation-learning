package org.example.puppy.registration;

import org.example.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import org.example.puppy.base.BaseWebTest;

public class RegistrationEmptyPasswordFieldTest extends BaseWebTest {

    private static final String USERNAME = "Newaccount7";
    private final RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registrationEmptyPasswordFieldTest() {
        registrationPage
                .navigateToRegistrationPage()
                .enterUsername(USERNAME)
                .clearPassword()
                .clickRegistrationButton()
                .checkCreateAUserTitleIsDisplayed();
    }

}
