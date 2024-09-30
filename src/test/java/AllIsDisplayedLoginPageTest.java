import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;

public class AllIsDisplayedLoginPageTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void allIsDisplayed () {
        loginPage
                .checkHeaderIsDisplayed()
                .checkImageIsDisplayed()
                .checkWelcomeIsDisplayed()
                .checkUsernameFieldIsDisplayed()
                .checkPasswordFieldIsDisplayed()
                .checkLoginButtonIsDisplayed()
                .checkRegisterButtonIsDisplayed()
                .checkAboutLinkIsDisplayed();

        //Почему-то не находит элементы :'(
    }
}
