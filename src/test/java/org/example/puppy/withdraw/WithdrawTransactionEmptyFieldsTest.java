package org.example.puppy.withdraw;

import org.example.pages.LoginPage;
import org.example.pages.NewWithdrawPage;
import org.example.puppy.base.BaseWebTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WithdrawTransactionEmptyFieldsTest extends BaseWebTest {
    private final LoginPage loginPage = new LoginPage();
    private final NewWithdrawPage newWithdrawPage = new NewWithdrawPage();
    private static final String EMPTY_WITHDRAW_AMOUNT_FIELD_MESSAGE = "Please fill in this field.";
    private static final String EMPTY_PUPPY_FIELD_MESSAGE = "Please select an item in the list.";

    @BeforeEach
    public void preCondition() {
        loginPage
                .loginAsAdmin()
                .clickWithdrawDropdown()
                .goNewWithdraw();
    }

    @Test
    public void withdrawTransactionEmptyFieldsTest() {
        newWithdrawPage
                .clearWithdrawAmountField()
                .selectPuppyOptionEmpty()
                .clickConfirmButton()
                .checkNewWithdrawPageHeaderIsDisplayed()
                .checkErrorEmptyWithdrawAmountFieldExist()
                .checkErrorMessageInWithdrawAmountFieldIsCorrect(EMPTY_WITHDRAW_AMOUNT_FIELD_MESSAGE)
                .checkErrorEmptyPuppyFieldExist()
                .checkErrorMessageInPuppyFieldIsCorrect(EMPTY_PUPPY_FIELD_MESSAGE);
    }
}
