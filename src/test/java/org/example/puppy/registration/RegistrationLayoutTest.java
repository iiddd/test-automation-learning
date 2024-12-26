package org.example.puppy.registration;

import org.example.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import org.example.puppy.base.BaseTest;

public class RegistrationLayoutTest extends BaseTest {

    private final RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registrationLayoutTest() {
        registrationPage
                .navigateToRegistrationPage()
                .checkLayout();
    }
}
