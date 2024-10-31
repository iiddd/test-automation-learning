import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;

public class EmptyPasswordTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private static final String USERNAME = "admin";

    @Test
    public void emptyPasswordTest() {
        loginPage
                .navigateToPuppyPage()
                .enterUsername(USERNAME)
                .clearPassword()
                .clickLoginButton()
                .checkLoginPageTitleIsDisplayed();
    }

}
