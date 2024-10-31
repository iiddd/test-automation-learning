import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;

public class EmptyLoginTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private static final String PASSWORD = "password";

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
