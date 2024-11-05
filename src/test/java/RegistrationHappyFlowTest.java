import org.example.pages.LoginPage;
import org.example.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationHappyFlowTest extends BaseTest {

    private final RegistrationPage registrationPage = new RegistrationPage();
    private final LoginPage loginPage = new LoginPage();
    private static final String USERNAME = "Newaccount";
    private static final String PASSWORD = "AbobaPuppy";

    @Test
    public void registrationHappyFlowTest() {
        registrationPage
                .navigateToRegistrationPage()
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .enterRepeatPassword(PASSWORD)
                .clickRegistrationButton();
        loginPage
                .checkLoginPageTitleIsDisplayed();
    }

}
