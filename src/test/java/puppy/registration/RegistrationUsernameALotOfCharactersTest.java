package puppy.registration;

import org.example.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import puppy.base.BaseTest;

public class RegistrationUsernameALotOfCharactersTest extends BaseTest {
    private static final int RANDOM_USERNAME_LENGHT = 151;
    private static final String PASSWORD = "AbobaPuppy";
    private final RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registrationUsernameALotOfCharacters() {
        registrationPage
                .navigateToRegistrationPage()
                .enterRandomUsername(RANDOM_USERNAME_LENGHT)
                .enterPassword(PASSWORD)
                .enterRepeatPassword(PASSWORD)
                .clickRegistrationButton()
                .TooManyCharactersError();
    }
}
