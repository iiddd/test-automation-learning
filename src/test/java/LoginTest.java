import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;


public class LoginTest extends BaseTest {
    private final LoginPage puppySearchPage = new LoginPage();
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Test
    public void loginTest() {
        puppySearchPage
                .openPuppyPage()
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .login();
    }
}
