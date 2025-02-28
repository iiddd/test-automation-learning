package org.example.tests.puppy.registration;

import org.example.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import org.example.tests.puppy.base.BaseWebTest;

public class RegistrationDifferentPasswordsTest extends BaseWebTest {

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
