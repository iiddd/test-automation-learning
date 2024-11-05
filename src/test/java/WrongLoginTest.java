import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;

public class WrongLoginTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private static final int RANDOM_USERNAME_LENGHT = 6;
    private static final String PASSWORD = "password";


    @Test
    public void wrongLoginTest () {
        loginPage
                .navigateToPuppyPage()
                .enterRandomUsername(RANDOM_USERNAME_LENGHT)
                .enterPassword(PASSWORD)
                .clickLoginButton()
                .checkErrorMessageIsDisplayed();

    }

}
