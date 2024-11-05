import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;


public class LoginLayoutTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();


    @Test
    public void loginLayout() {
        loginPage
                .navigateToPuppyPage()
                .checkLoginPageTitleIsDisplayed()
                .checkCredentialsFieldIsDisplayed()
                .checkCredentialsFieldIsEmpty()
                .checkButtonsIsDisplayed()
                .checkAboutLinkIsDisplayed();
    }
}
