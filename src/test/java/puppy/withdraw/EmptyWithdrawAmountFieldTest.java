package puppy.withdraw;

import org.example.pages.BasePage;
import org.example.pages.LoginPage;
import org.example.pages.NewWithdrawPage;
import org.junit.jupiter.api.Test;
import puppy.base.BaseTest;

public class EmptyWithdrawAmountFieldTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final BasePage basePage = new BasePage();
    private final NewWithdrawPage newWithdrawPage = new NewWithdrawPage();

    @Test
    public void emptyWithdrawAmountFieldTest() {
        loginPage
                .loginAsAdmin();
        basePage
                .clickWithdrawDropdown()
                .goNewWithdraw();
        newWithdrawPage
                .clearWithdrawAmountField()
                .selectPuppyOptionPoodle()
                .clickConfirmButton()
                .checkNewWithdrawPageHeaderIsDisplayed();
    }
}
