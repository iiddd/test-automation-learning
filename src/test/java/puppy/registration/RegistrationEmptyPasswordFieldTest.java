package puppy.registration;

import org.example.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import puppy.base.BaseTest;

public class RegistrationEmptyPasswordFieldTest extends BaseTest {

    private static final String USERNAME = "Newaccount7";
    private final RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registrationEmptyPasswordFieldTest() {
        registrationPage
                .navigateToRegistrationPage()
                .enterUsername(USERNAME)
                .clickRegistrationButton()
                .checkCreateAUserTitleIsDisplayed();
    }

}
