package puppy.withdraw;

import org.example.pages.*;
import org.junit.jupiter.api.Test;
import puppy.base.BaseTest;

public class WithdrawTransactionHappyFlowTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final BasePage basePage = new BasePage();
    private final NewDepositPage newDepositPage = new NewDepositPage();
    private final NewWithdrawPage newWithdrawPage = new NewWithdrawPage();
    private final WithdrawTransactionListPage withdrawTransactionListPage = new WithdrawTransactionListPage();
    private static final String WITHDRAW_AMOUNT = "1";
    private String TRANSACTION_ID = "";

    @Test
    public void withdrawTransactionHappyFlowTest() {
        loginPage
                .loginAsAdmin();
        basePage
                .clickDepositDropdown()
                .goNewDeposit();
        newDepositPage
                .createDepositTransaction();
        basePage
                .clickWithdrawDropdown()
                .goNewWithdraw();
        TRANSACTION_ID = newWithdrawPage.getTransactionReference();
        newWithdrawPage
                .enterWithdrawAmount(WITHDRAW_AMOUNT)
                .selectPuppyOptionPoodle()
                .clickConfirmButton();
        withdrawTransactionListPage
                .checkWithdrawTransactionListIsDisplayed()
                .checkTransactionListContainsTransaction(TRANSACTION_ID);
    }
}
