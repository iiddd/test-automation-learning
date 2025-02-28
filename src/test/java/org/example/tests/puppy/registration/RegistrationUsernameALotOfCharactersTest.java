package org.example.tests.puppy.registration;

import org.example.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import org.example.tests.puppy.base.BaseWebTest;

public class RegistrationUsernameALotOfCharactersTest extends BaseWebTest {
    private static final int RANDOM_USERNAME_LENGHT = 151;
    private static final String PASSWORD = "AbobaPuppy";
    private final RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registrationUsernameALotOfCharacters() {
        registrationPage
                .navigateToRegistrationPage()
                .enterRandomUsername(RANDOM_USERNAME_LENGHT)
                .enterPassword(PASSWORD)
                .enterRepeatPassword(PASSWORD)
                .clickRegistrationButton()
                .TooManyCharactersError();
    }
}
