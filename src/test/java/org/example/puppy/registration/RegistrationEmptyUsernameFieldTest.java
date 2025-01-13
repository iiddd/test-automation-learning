package org.example.puppy.registration;

import org.example.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import org.example.puppy.base.BaseWebTest;

public class RegistrationEmptyUsernameFieldTest extends BaseWebTest {

    private static final String PASSWORD = "AbobaPuppy";
    private final RegistrationPage registrationPage = new RegistrationPage();


    @Test
    public void registrationEmptyUsernameFieldTest() {
        registrationPage
                .navigateToRegistrationPage()
                .clearUsername()
                .enterPassword(PASSWORD)
                .enterRepeatPassword(PASSWORD)
                .clickRegistrationButton()
                .checkCreateAUserTitleIsDisplayed();
    }
}
