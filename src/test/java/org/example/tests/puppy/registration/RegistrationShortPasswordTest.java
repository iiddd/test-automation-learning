package org.example.tests.puppy.registration;

import org.example.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import org.example.tests.puppy.base.BaseWebTest;

public class RegistrationShortPasswordTest extends BaseWebTest {

    private static final String USERNAME = "Newacconut4";
    private static final String PASSWORD = "Aboba";
    private final RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registrationShortPasswordTest() {
        registrationPage
                .navigateToRegistrationPage()
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .enterRepeatPassword(PASSWORD)
                .clickRegistrationButton()
                .checkShortPasswordError();
    }
}
