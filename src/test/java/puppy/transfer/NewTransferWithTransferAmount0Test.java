package puppy.transfer;

import org.example.pages.DashboardPage;
import org.example.pages.LoginPage;
import org.example.pages.TransferTransactionPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import puppy.base.BaseTest;

public class NewTransferWithTransferAmount0Test extends BaseTest {

    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();
    private final TransferTransactionPage transferTransactionPage = new TransferTransactionPage();
    private static final String ZERO = "0";

    @BeforeEach
    public void setUp() {
        loginPage
                .loginAsAdmin();
        dashboardPage
                .checkDashboardIsDisplayed();

    }

    @Test
    public void newTransferWithTransferAmount0Test() {
        dashboardPage
                .clickNewTransfer();
        transferTransactionPage
                .checkToTransferTransactionPage()
                .enterTransferAmount(ZERO)
                .clickFromPuppy()
                .clickFromPoodleWhite()
                .clickToPuppy()
                .clickToSiberianHusky()
                .clickConfirm()
                .checkCreateErrorZero();
    }
}
