
import org.example.pages.PuppySearchPage;
import org.junit.jupiter.api.Test;


public class PuppyTest extends BaseTest {
    private final PuppySearchPage puppySearchPage = new PuppySearchPage();
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Test
    public void test3() {
        puppySearchPage
                .openPuppyPage()
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .logIn();
    }
}
