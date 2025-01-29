package org.example.puppy.transfer;

import org.example.pages.LoginPage;
import org.example.pages.TransferTransactionPage;
import org.example.puppy.base.BaseWebTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmptyFieldsTest extends BaseWebTest {
    private final LoginPage loginPage = new LoginPage();
    private final TransferTransactionPage transferTransactionPage = new TransferTransactionPage();
    private static final String TRANSFER_AMOUNT_ERROR_MESSAGE = "Please fill in this field.";
    private static final String FROM_PUPPY_ERROR_MESSAGE = "Please select an item in the list.";
    private static final String TO_PUPPY_ERROR_MESSAGE = "Please select an item in the list.";

    @BeforeEach
    public void preCondition() {
        loginPage
                .loginAsAdmin()
                .clickTransferDropdown()
                .goNewTransfer();
    }

    @Test
    public void emptyFieldsTest() {
        transferTransactionPage
                .clearTransferAmountField()
                .selectEmptyFromPuppyOption()
                .selectEmptyToPuppyOption()
                .clickConfirm()
                .checkTransferTransactionTitleIsDisplayed()
                .checkErrorMessageTransferAmountFieldExist()
                .checkErrorMessageInTransferAmountFieldIsCorrect(TRANSFER_AMOUNT_ERROR_MESSAGE)
                .checkErrorMessageFromPuppyFieldExist()
                .checkErrorMessageFromPuppyFieldIsCorrect(FROM_PUPPY_ERROR_MESSAGE)
                .checkErrorMessageToPuppyFieldExist()
                .checkErrorMessageToPuppyFieldIsCorrect(TO_PUPPY_ERROR_MESSAGE);
    }
}
