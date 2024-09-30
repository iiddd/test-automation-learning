import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;

public class WrongLoginTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private static final String USERNAME = "kitty";
    private static final String PASSWORD = "password";


    @Test
    public void wrongLoginTest () {
        loginPage
                .navigateToPuppyPage()
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .clickLoginButton()
                .checkErrorMessageIsDisplayed();

    }

}
