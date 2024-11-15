package puppy.login;

import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;
import puppy.base.BaseTest;

public class EmptyLoginTest extends BaseTest {
    private static final String PASSWORD = "password";
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void emptyLoginTest() {
        loginPage
                .navigateToPuppyPage()
                .clearUsername()
                .enterPassword(PASSWORD)
                .clickLoginButton()
                .checkLoginPageTitleIsDisplayed();
    }
}
