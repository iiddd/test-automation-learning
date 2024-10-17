import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;

public class WrongCredentialsTest extends BaseTest{
    private final LoginPage loginPage = new LoginPage();
    private static final String USERNAME = "kitty";
    private static final String PASSWORD = "cat";


    @Test
    public void wrongCredentialsTest () {
        loginPage
                .navigateToPuppyPage()
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .clickLoginButton()
                .checkErrorMessageIsDisplayed();

    }
}
