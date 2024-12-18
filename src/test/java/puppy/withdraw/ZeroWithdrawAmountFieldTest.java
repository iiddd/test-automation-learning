package puppy.withdraw;

import org.example.pages.BasePage;
import org.example.pages.LoginPage;
import org.example.pages.NewWithdrawPage;
import org.junit.jupiter.api.Test;
import puppy.base.BaseTest;

public class ZeroWithdrawAmountFieldTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final BasePage basePage = new BasePage();
    private final NewWithdrawPage newWithdrawPage = new NewWithdrawPage();
    private final float WITHDRAW_AMOUNT = 0;

    @Test
    public void zeroWithdrawAmountFieldTest() {
        loginPage
                .loginAsAdmin();
        basePage
                .clickWithdrawDropdown()
                .goNewWithdraw();
        newWithdrawPage
                .enterWithdrawAmount(WITHDRAW_AMOUNT)
                .selectPuppyOptionPoodle()
                .clickConfirmButton()
                .checkNewWithdrawPageHeaderIsDisplayed()
                .checkZeroWithdrawAmountErrorIsDisplayed();
    }
}
