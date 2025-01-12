package org.example.puppy.registration;

import org.example.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import org.example.puppy.base.BaseTest;

public class RegistrationUsernameForbiddenCharactersTest extends BaseTest {

    private static final String USERNAME = "Newacconut*?2";
    private static final String PASSWORD = "AbobaPuppy";
    private final RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registrationUsernameForbiddenCharactersTest() {
        registrationPage
                .navigateToRegistrationPage()
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .enterRepeatPassword(PASSWORD)
                .clickRegistrationButton()
                .checkForbiddenCharactersError();
    }
}
