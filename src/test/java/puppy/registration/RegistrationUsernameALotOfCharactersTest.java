package puppy.registration;

import org.example.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import puppy.base.BaseTest;

public class RegistrationUsernameALotOfCharactersTest extends BaseTest {

    private static final String USERNAME = "AbobusgavkAbobusgavkAbobusgavkAbobusgavkAbobusgavkAbobusgavkAbobu" +
            "sgavkAbobusgavkAbobusgavkAbobusgavkAbobusgavkAbobusgavkAbobusgavkAbobusgavkAbobusgavkc";
    private static final String PASSWORD = "AbobaPuppy";
    private final RegistrationPage registrationPage = new RegistrationPage();

    @Test
    public void registrationUsernameALotOfCharacters() {
        registrationPage
                .navigateToRegistrationPage()
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .enterRepeatPassword(PASSWORD)
                .clickRegistrationButton()
                .check150OverCharactersError();
    }
}
