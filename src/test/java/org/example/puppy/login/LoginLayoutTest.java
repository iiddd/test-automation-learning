package org.example.puppy.login;

import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.example.puppy.base.BaseWebTest;


public class LoginLayoutTest extends BaseWebTest {
    private final LoginPage loginPage = new LoginPage();


    @Test
    public void loginLayout() {
        loginPage
                .navigateToPuppyPage()
                .checkLayout();
    }
}