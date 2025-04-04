package org.example.pages;

import org.example.utils.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static org.example.core.DriverHolder.getDriver;

public class NewWithdrawPage extends BasePage {
    private static final By TRANSACTION_REFERENCE_FIELD_LOCATOR = By.xpath("//input[@name='transaction_reference']");
    private static final By WITHDRAW_AMOUNT_FIELD_LOCATOR = By.xpath("//input[@name='withdraw_amount']");
    private static final By PUPPY_OPTION_LOCATOR = By.xpath("//option[text()='New Puppy']");
    private static final By CONFIRM_BUTTON_LOCATOR = By.xpath("//span[text()='Confirm']");
    private static final By PUPPY_OPTION_EMPTY_LOCATOR = By.xpath("//option[text()='---------']");
    private static final By NEW_WITHDRAW_PAGE_HEADER_LOCATOR = By.xpath("//h1[text()='Withdraw Transaction']");
    private static final By ZERO_WITHDRAW_AMOUNT_ERROR_LOCATOR = By.xpath("//span[text()='The withdraw amount should be more than zero.']");
    private static final By TOO_MUCH_AMOUNT_ERROR_LOCATOR = By.xpath("//span[text()='The withdraw amount cannot be more than the account balance.']");
    private static final String VALUE_ATTRIBUTE_NAME = "value";
    private static final By PUPPY_FIELD_LOCATOR = By.xpath("//select[@id='id_puppy']");

    public String getTransactionReference() {
        return getDriver().findElement(TRANSACTION_REFERENCE_FIELD_LOCATOR).getAttribute(VALUE_ATTRIBUTE_NAME);
    }

    public NewWithdrawPage enterWithdrawAmount(float input) {
        getDriver().findElement(WITHDRAW_AMOUNT_FIELD_LOCATOR).sendKeys(Float.toString(input));
        return this;
    }

    public NewWithdrawPage selectPuppyOption() {
        getDriver().findElement(PUPPY_OPTION_LOCATOR).click();
        return this;
    }

    public NewWithdrawPage clickConfirmButton() {
        getDriver().findElement(CONFIRM_BUTTON_LOCATOR).click();
        return this;
    }

    public NewWithdrawPage clearWithdrawAmountField() {
        getDriver().findElement(WITHDRAW_AMOUNT_FIELD_LOCATOR).clear();
        return this;
    }

    public NewWithdrawPage selectPuppyOptionEmpty() {
        getDriver().findElement(PUPPY_OPTION_EMPTY_LOCATOR).click();
        return this;
    }

    public NewWithdrawPage checkNewWithdrawPageHeaderIsDisplayed() {
        getDriver().findElement(NEW_WITHDRAW_PAGE_HEADER_LOCATOR).isDisplayed();
        return this;
    }

    public NewWithdrawPage checkZeroWithdrawAmountErrorIsDisplayed() {
        getDriver().findElement(ZERO_WITHDRAW_AMOUNT_ERROR_LOCATOR).isDisplayed();
        return this;
    }

    public NewWithdrawPage checkTooMuchAmountErrorIsDisplayed() {
        getDriver().findElement(TOO_MUCH_AMOUNT_ERROR_LOCATOR).isDisplayed();
        return this;
    }

    public NewWithdrawPage enterWithdrawAmount(String input) {
        getDriver().findElement(WITHDRAW_AMOUNT_FIELD_LOCATOR).sendKeys(input);
        return this;
    }

    public NewWithdrawPage enterRandomLettersInWithdrawAmountField(int length) {
        enterWithdrawAmount(StringUtils.generateAlphabeticalString(length));
        return this;
    }

    public NewWithdrawPage checkWithdrawAmountFieldIsEmpty() {
        Assertions.assertTrue(getDriver().findElement(WITHDRAW_AMOUNT_FIELD_LOCATOR).getText().isEmpty());
        return this;
    }

    public NewWithdrawPage checkErrorEmptyWithdrawAmountFieldExist() {
        Assertions.assertTrue(Boolean.parseBoolean(getDriver().findElement(WITHDRAW_AMOUNT_FIELD_LOCATOR).getAttribute("required")));
        return this;
    }

    public NewWithdrawPage checkErrorMessageInWithdrawAmountFieldIsCorrect(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, getDriver().findElement(WITHDRAW_AMOUNT_FIELD_LOCATOR).getAttribute("validationMessage"));
        return this;
    }

    public NewWithdrawPage checkErrorEmptyPuppyFieldExist() {
        Assertions.assertTrue(Boolean.parseBoolean(getDriver().findElement(PUPPY_FIELD_LOCATOR).getAttribute("required")));
        return this;
    }

    public NewWithdrawPage checkErrorMessageInPuppyFieldIsCorrect(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, getDriver().findElement(PUPPY_FIELD_LOCATOR).getAttribute("validationMessage"));
        return this;
    }
}
