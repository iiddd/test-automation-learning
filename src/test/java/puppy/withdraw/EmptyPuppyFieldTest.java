package puppy.withdraw;

import org.example.pages.BasePage;
import org.example.pages.LoginPage;
import org.example.pages.NewWithdrawPage;
import org.junit.jupiter.api.Test;
import puppy.base.BaseTest;

public class EmptyPuppyFieldTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final BasePage basePage = new BasePage();
    private final NewWithdrawPage newWithdrawPage = new NewWithdrawPage();
    private static final String WITHDRAW_AMOUNT = "1";

    @Test
    public void emptyPuppyFieldTest() {
        loginPage
                .loginAsAdmin();
        basePage
                .clickWithdrawDropdown()
                .goNewWithdraw();
        newWithdrawPage
                .enterWithdrawAmount(WITHDRAW_AMOUNT)
                .selectPuppyOptionEmpty()
                .clickConfirmButton()
                .checkNewWithdrawPageHeaderIsDisplayed();
    }
}
