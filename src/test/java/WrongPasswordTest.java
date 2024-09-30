import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;

public class WrongPasswordTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "cat";


    @Test
    public void wrongPasswordTest () {
        loginPage
                .navigateToPuppyPage()
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .clickLoginButton()
                .checkErrorMessageIsDisplayed();

    }
}
