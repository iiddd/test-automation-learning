package puppy.registration;

import org.example.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import puppy.base.BaseTest;

public class RegistrationEmptyRepeatPasswordFieldTest extends BaseTest {

    private static final String USERNAME = "Newaccount8";
    private static final String PASSWORD = "AbobaPuppy";
    private final RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registrationRepeatPasswordFieldTest() {
        registrationPage
                .navigateToRegistrationPage()
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .clearRepeatPassword()
                .clickRegistrationButton()
                .checkCreateAUserTitleIsDisplayed();
    }
}
