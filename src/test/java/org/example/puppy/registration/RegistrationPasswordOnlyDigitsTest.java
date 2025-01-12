package org.example.puppy.registration;

import org.example.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import org.example.puppy.base.BaseTest;

public class RegistrationPasswordOnlyDigitsTest extends BaseTest {

    private static final String USERNAME = "Newacconut5";
    private static final String PASSWORD = "36905471";
    private final RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registrationPasswordOnlyDigitsTest() {
        registrationPage
                .navigateToRegistrationPage()
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .enterRepeatPassword(PASSWORD)
                .clickRegistrationButton()
                .checkPasswordOnlyDigitsError();
    }
}
