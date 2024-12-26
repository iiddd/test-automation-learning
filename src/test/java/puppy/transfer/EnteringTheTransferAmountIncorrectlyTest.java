//package puppy.transfer;
//
//import org.example.pages.DashboardPage;
//import org.example.pages.LoginPage;
//import org.example.pages.TransferTransactionListPage;
//import org.example.pages.TransferTransactionPage;
//import org.junit.jupiter.api.Test;
//import puppy.base.BaseTest;
//
//public class EnteringTheTransferAmountIncorrectlyTest extends BaseTest {
//
//    private final LoginPage loginPage = new LoginPage();
//    private final DashboardPage dashboardPage = new DashboardPage();
//    private final TransferTransactionPage transferTransactionPage = new TransferTransactionPage();
//    private final TransferTransactionListPage transferTransactionListPage = new TransferTransactionListPage();
//    private static final String ZERO = "0";
//
//    @Test
//    public void enteringTheTransferAmountIncorrectly() {
//        loginPage
//                .loginAsAdmin();
//        dashboardPage
//                .checkDashboardIsDisplayed()
//                .clickTransfer()
//                .clickTransactionList();
//        transferTransactionListPage
//                .checkToTransactionListPage()
//                .clickCreateNewButton();
//        transferTransactionPage
//                .checkToTransferTransactionPage()
//                .enterTransferAmount(ZERO)
//                .clickFromPuppy()
//                .clickFromPoodleWhite()
//                .clickToPuppy()
//                .clickToSiberianHusky()
//                .clickConfirm()
//                .checkCreateErrorZero();
//    }
//}
