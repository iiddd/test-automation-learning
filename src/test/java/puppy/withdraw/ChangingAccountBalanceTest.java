package puppy.withdraw;

import org.example.pages.*;
import org.junit.jupiter.api.Test;
import puppy.base.BaseTest;

public class ChangingAccountBalanceTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final BasePage basePage = new BasePage();
    private final NewDepositPage newDepositPage = new NewDepositPage();
    private final NewWithdrawPage newWithdrawPage = new NewWithdrawPage();
    private final PuppyAccountListPage puppyAccountListPage = new PuppyAccountListPage();
    //private float ACCOUNT_BALANCE = ;
    private static final String WITHDRAW_AMOUNT = "1";

    @Test
    public void changingAccountBalanceTest() {
        loginPage
                .loginAsAdmin();
        basePage
                .clickDepositDropdown()
                .goNewDeposit();
        newDepositPage
                .createDepositTransaction();
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
                .enterWithdrawAmount(WITHDRAW_AMOUNT)
                .selectPuppyOptionPoodle()
                .clickConfirmButton();
        basePage
                .clickPuppyAccountsDropdown()
                .goPuppyAccountList();
        puppyAccountListPage
                .compareAccountBalance();
    }
}
