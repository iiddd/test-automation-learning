package org.example.puppy.registration;

import org.example.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import org.example.puppy.base.BaseTest;

public class RegistrationShortPasswordTest extends BaseTest {

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
