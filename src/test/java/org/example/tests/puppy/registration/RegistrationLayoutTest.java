package org.example.tests.puppy.registration;

import org.example.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import org.example.tests.puppy.base.BaseWebTest;

public class RegistrationLayoutTest extends BaseWebTest {

    private final RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registrationLayoutTest() {
        registrationPage
                .navigateToRegistrationPage()
                .checkLayout();
    }
}
