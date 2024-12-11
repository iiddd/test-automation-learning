package puppy.registration;

import org.example.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import puppy.base.BaseTest;

public class RegistrationEmptyUsernameFieldTest extends BaseTest {

    private static final String PASSWORD = "AbobaPuppy";
    private final RegistrationPage registrationPage = new RegistrationPage();


    @Test
    public void registrationEmptyUsernameFieldTest() {
        registrationPage
                .navigateToRegistrationPage()
                .clearUsername()
                .enterPassword(PASSWORD)
                .enterRepeatPassword(PASSWORD)
                .clickRegistrationButton()
                .checkCreateAUserTitleIsDisplayed();
    }
}
