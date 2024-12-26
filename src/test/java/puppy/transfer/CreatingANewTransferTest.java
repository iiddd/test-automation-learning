//package puppy.transfer;
//
//import org.example.pages.*;
//import org.junit.jupiter.api.Test;
//import puppy.base.BaseTest;
//
//public class CreatingANewTransferTest extends BaseTest {
//
//    private final LoginPage loginPage = new LoginPage();
//    private final DashboardPage dashboardPage = new DashboardPage();
//    private final TransferTransactionPage transferTransactionPage = new TransferTransactionPage();
//    private final TransferTransactionListPage transferTransactionListPage = new TransferTransactionListPage();
//    private static final String ONE = "1";
//
//    @Test
//    public void creatingANewTransfer() {
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
//                .enterTransferAmount(ONE)
//                .clickFromPuppy()
//                .clickFromGoldenRetriever()
//                .clickToPuppy()
//                .clickToPoodleWhite()
//                .clickConfirm();
//    }
//}
