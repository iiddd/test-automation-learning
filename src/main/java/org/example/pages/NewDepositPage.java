package org.example.pages;

import org.example.utils.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static org.example.core.DriverHolder.getDriver;

public class NewDepositPage extends BasePage {

    private static final By TRANSACTION_REFERENCE_FIELD_LOCATOR = By.xpath("//input[@name='transaction_reference']");
    private static final String VALUE_ATTRIBUTE_NAME = "value";
    private static final By DEPOSIT_AMOUNT_FIELD_LOCATOR = By.xpath("//input[@name='deposit_amount']");
    private static final By PUPPY_OPTION_LOCATOR = By.xpath("//option[text()='Deposit Puppy']");
    private static final By CONFIRM_BUTTON_LOCATOR = By.xpath("//span[text()='Confirm']");
    private static final By PUPPY_OPTION_EMPTY_LOCATOR = By.xpath("//option[text()='---------']");
    private static final By NEW_DEPOSIT_PAGE_HEADER_LOCATOR = By.xpath("//h1[text()='Deposit Transaction']");
    private static final By PUPPY_FIELD_LOCATOR = By.xpath("//select[@id='id_puppy']");
    private static final By ZERO_DEPOSIT_AMOUNT_ERROR_LOCATOR = By.xpath("//span[text()='The deposit amount should be more than zero.']");

    public String getTransactionReference() {
        return getDriver().findElement(TRANSACTION_REFERENCE_FIELD_LOCATOR).getAttribute(VALUE_ATTRIBUTE_NAME);
    }

    public NewDepositPage enterDepositAmount(float input) {
        getDriver().findElement(DEPOSIT_AMOUNT_FIELD_LOCATOR).sendKeys(Float.toString(input));
        return this;
    }

    public NewDepositPage selectPuppyOption() {
        getDriver().findElement(PUPPY_OPTION_LOCATOR).click();
        return this;
    }

    public NewDepositPage clickConfirmButton() {
        getDriver().findElement(CONFIRM_BUTTON_LOCATOR).click();
        return this;
    }

    public NewDepositPage clearDepositAmountField() {
        getDriver().findElement(DEPOSIT_AMOUNT_FIELD_LOCATOR).clear();
        return this;
    }

    public NewDepositPage selectPuppyOptionEmpty() {
        getDriver().findElement(PUPPY_OPTION_EMPTY_LOCATOR).click();
        return this;
    }

    public NewDepositPage checkNewDepositPageHeaderIsDisplayed() {
        getDriver().findElement(NEW_DEPOSIT_PAGE_HEADER_LOCATOR).isDisplayed();
        return this;
    }

    public NewDepositPage checkErrorEmptyDepositAmountFieldExist() {
        Assertions.assertTrue(Boolean.parseBoolean(getDriver().findElement(DEPOSIT_AMOUNT_FIELD_LOCATOR).getAttribute("required")));
        return this;
    }

    public NewDepositPage checkErrorMessageInPuppyFieldIsCorrect(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, getDriver().findElement(PUPPY_FIELD_LOCATOR).getAttribute("validationMessage"));
        return this;
    }

    public NewDepositPage checkErrorEmptyPuppyFieldExist() {
        Assertions.assertTrue(Boolean.parseBoolean(getDriver().findElement(PUPPY_FIELD_LOCATOR).getAttribute("required")));
        return this;
    }

    public NewDepositPage checkErrorMessageInDepositAmountFieldIsCorrect(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, getDriver().findElement(DEPOSIT_AMOUNT_FIELD_LOCATOR).getAttribute("validationMessage"));
        return this;
    }

    public NewDepositPage checkZeroDepositAmountErrorIsDisplayed() {
        getDriver().findElement(ZERO_DEPOSIT_AMOUNT_ERROR_LOCATOR).isDisplayed();
        return this;
    }

    public NewDepositPage enterDepositAmount(String input) {
        getDriver().findElement(DEPOSIT_AMOUNT_FIELD_LOCATOR).sendKeys(input);
        return this;
    }

    public NewDepositPage enterRandomLettersInDepositAmountField(int length) {
        enterDepositAmount(StringUtils.generateAlphabeticalString(length));
        return this;
    }

    public NewDepositPage checkDepositAmountFieldIsEmpty() {
        Assertions.assertTrue(getDriver().findElement(DEPOSIT_AMOUNT_FIELD_LOCATOR).getText().isEmpty());
        return this;
    }
}

