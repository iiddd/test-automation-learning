//package puppy.transfer;
//
//import org.example.pages.DashboardPage;
//import org.example.pages.LoginPage;
//import org.example.pages.TransferTransactionListPage;
//import org.example.pages.TransferTransactionPage;
//import org.junit.jupiter.api.Test;
//import puppy.base.BaseTest;
//
//public class ExceedingTheTransferAmountTest extends BaseTest {
//
//    private final LoginPage loginPage = new LoginPage();
//    private final DashboardPage dashboardPage = new DashboardPage();
//    private final TransferTransactionPage transferTransactionPage = new TransferTransactionPage();
//    private final TransferTransactionListPage transferTransactionListPage = new TransferTransactionListPage();
//    private static final String MANY = "999999999999999999999999999999999999999999999999999999999";
//
//    @Test
//    public void exceedingTheTransferAmountTest() {
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
//                .enterTransferAmount(MANY)
//                .clickFromPuppy()
//                .clickFromSiberianHusky()
//                .clickToPuppy()
//                .clickToPoodleWhite()
//                .clickConfirm()
//                .checkNotMoneyError();
//    }
//}
