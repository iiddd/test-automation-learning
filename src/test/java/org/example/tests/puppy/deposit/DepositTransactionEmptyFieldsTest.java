package org.example.tests.puppy.deposit;

import org.example.pages.LoginPage;
import org.example.pages.NewDepositPage;
import org.example.tests.puppy.base.BaseWebTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DepositTransactionEmptyFieldsTest extends BaseWebTest {

    private static final String EMPTY_DEPOSIT_AMOUNT_FIELD_MESSAGE = "Please fill in this field.";
    private static final String EMPTY_PUPPY_FIELD_MESSAGE = "Please select an item in the list.";
    private final LoginPage loginPage = new LoginPage();
    private final NewDepositPage newDepositPage = new NewDepositPage();

    @BeforeEach
    public void preCondition() {
        loginPage
                .loginAsAdmin()
                .clickDepositDropdown()
                .goNewDeposit();
    }

    @Test
    public void depositTransactionEmptyFieldsTest() {
        newDepositPage
                .clearDepositAmountField()
                .selectPuppyOptionEmpty()
                .clickConfirmButton()
                .checkNewDepositPageHeaderIsDisplayed()
                .checkErrorEmptyDepositAmountFieldExist()
                .checkErrorMessageInDepositAmountFieldIsCorrect(EMPTY_DEPOSIT_AMOUNT_FIELD_MESSAGE)
                .checkErrorEmptyPuppyFieldExist()
                .checkErrorMessageInPuppyFieldIsCorrect(EMPTY_PUPPY_FIELD_MESSAGE);
    }
}
