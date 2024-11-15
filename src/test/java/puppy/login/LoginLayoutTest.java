package puppy.login;

import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;
import puppy.base.BaseTest;


public class LoginLayoutTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();


    @Test
    public void loginLayout() {
        loginPage
                .navigateToPuppyPage()
                .checkLayout();
    }
}
