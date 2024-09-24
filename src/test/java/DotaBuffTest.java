import org.example.pages.SearchPage;
import org.junit.jupiter.api.Test;

public class DotaBuffTest extends BaseTest {

    private static final String HERO_INPUT_TEXT = "Nyx";
    private final SearchPage searchPage = new SearchPage();

    @Test
    public void test1() {
        searchPage
                .openSearchPage()
                .handleCookiePopup()
                .inputSearchText(HERO_INPUT_TEXT)
                .clickSubmitButton()
                .checkSingleResultIsDisplayed();
    }
}
