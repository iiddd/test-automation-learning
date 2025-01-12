package org.example.puppy.registration;

import org.example.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import org.example.puppy.base.BaseTest;

public class RegistrationDifferentPasswordsTest extends BaseTest {

    private static final String USERNAME = "Newacconut3";
    private static final String PASSWORD = "AbobaPuppy";
    private static final String PASSWORD2 = "AbobaPoppy";
    private final RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registrationDifferentPasswordAndRepeatPasswordTest() {
        registrationPage
                .navigateToRegistrationPage()
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .enterRepeatPassword(PASSWORD2)
                .clickRegistrationButton()
                .checkPasswordsDiffError();
    }
}
