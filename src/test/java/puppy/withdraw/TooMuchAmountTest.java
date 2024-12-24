package puppy.withdraw;

import org.example.pages.BasePage;
import org.example.pages.LoginPage;
import org.example.pages.NewWithdrawPage;
import org.example.pages.PuppyAccountListPage;
import org.junit.jupiter.api.Test;
import puppy.base.BaseTest;

public class TooMuchAmountTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final BasePage basePage = new BasePage();
    private final PuppyAccountListPage puppyAccountListPage = new PuppyAccountListPage();
    private final NewWithdrawPage newWithdrawPage = new NewWithdrawPage();
    private float ACCOUNT_BALANCE;


    @Test
    public void tooMuchAmountTest() {
        loginPage
                .loginAsAdmin();
        basePage
                .clickPuppyAccountsDropdown()
                .goPuppyAccountList();
        ACCOUNT_BALANCE = puppyAccountListPage.getAccountBalance();
        basePage
                .clickWithdrawDropdown()
                .goNewWithdraw();
        newWithdrawPage
                .enterWithdrawAmount(ACCOUNT_BALANCE + 1)
                .selectPuppyOptionPoodle()
                .clickConfirmButton()
                .checkNewWithdrawPageHeaderIsDisplayed()
                .checkTooMuchAmountErrorIsDisplayed();
    }
}
