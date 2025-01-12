package org.example.puppy.registration;

import org.example.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import org.example.puppy.base.BaseTest;

public class RegistrationUsernameAndPasswordSimilarTest extends BaseTest {

    private static final String USERNAME = "Newacconut656";
    private static final String PASSWORD = "Newacconut6";
    private final RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registrationUsernameAndPasswordSimilarTest() {
        registrationPage
                .navigateToRegistrationPage()
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .enterRepeatPassword(PASSWORD)
                .clickRegistrationButton()
                .checkPasswordAndUsernameAreSimilarError();
    }
}
