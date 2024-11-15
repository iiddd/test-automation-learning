import org.example.pages.DashboardPage;
import org.example.pages.LoginPage;
import org.example.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationHappyFlowTest extends BaseTest {

    private final RegistrationPage registrationPage = new RegistrationPage();
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private static final String USERNAME = "Testaccount5";
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
                .loginWithTestAccount();
        dashboardPage
                .checkDashboardIsDisplayed();
        loginPage
                .deleteTestAccount();
    }
}
