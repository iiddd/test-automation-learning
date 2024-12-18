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
    //private static final float HIGHER_BALANCE = ACCOUNT_BALANCE + 1;
    //private float ACCOUNT_BALANCE = ;

    @Test
    public void tooMuchAmountTest() {
        loginPage
                .loginAsAdmin();
        basePage
                .clickPuppyAccountsDropdown()
                .goPuppyAccountList();
        //puppyAccountListPage
                //.getAccountBalance();
        //ACCOUNT_BALANCE = puppyAccountListPage.getAccountBalance();
        basePage
                .clickWithdrawDropdown()
                .goNewWithdraw();
        newWithdrawPage
                .enterWithdrawAmount(HIGHER_BALANCE)
                .selectPuppyOptionPoodle()
                .clickConfirmButton()
                .checkNewWithdrawPageHeaderIsDisplayed()
                .checkTooMuchAmountErrorIsDisplayed();
    }
}
