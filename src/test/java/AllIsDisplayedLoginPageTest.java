import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;

public class AllIsDisplayedLoginPageTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void allIsDisplayed () {
        loginPage
                .navigateToPuppyPage()
                .checkHeaderIsDisplayed()
                .checkImageIsDisplayed()
                .checkWelcomeIsDisplayed()
                .checkUsernameFieldIsDisplayed()
                .checkPasswordFieldIsDisplayed()
                .checkLoginButtonIsDisplayed()
                .checkRegisterButtonIsDisplayed()
                .checkAboutLinkIsDisplayed();

        //если убрать 11 и 12 строку - код работает. Но я пока не понимаю, почему конкретно их не находит
    }
}
