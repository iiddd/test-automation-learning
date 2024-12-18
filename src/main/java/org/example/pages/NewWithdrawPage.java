package org.example.pages;

import org.openqa.selenium.By;

import static org.example.core.DriverHolder.getDriver;

public class NewWithdrawPage {
    private static final By TRANSACTION_REFERENSE_FIELD_LOCATOR = By.xpath("//input[@name='transaction_reference']");
    private static final By WITHDRAW_AMOUNT_FIELD_LOCATOR = By.xpath("//input[@name='withdraw_amount']");
    private static final By PUPPY_OPTION_POODLE_LOCATOR = By.xpath("//option[text()='Poodle White']");
    private static final By CONFIRM_BUTTON_LOCATOR = By.xpath("//span[text()='Confirm']");
    private static final By PUPPY_OPTION_EMPTY_LOCATOR = By.xpath("//option[text()='---------']");
    private static final By NEW_WITHDRAW_PAGE_HEADER_LOCATOR = By.xpath("//h1[text()='Withdraw Transaction']");
    private static final By ZERO_WITHDRAW_AMOUNT_ERROR_LOCATOR = By.xpath("//span[text()='The withdraw amount should be more than zero.']");
    private static final By TOO_MUCH_AMOUNT_ERROR_LOCATOR = By.xpath("//span[text()='The withdraw amount cannot be more than the account balance.']");
    private static final String GET_ATTRIBUTE_NAME = "value";

    public String getTransactionReference() {
        return getDriver().findElement(TRANSACTION_REFERENSE_FIELD_LOCATOR).getAttribute(GET_ATTRIBUTE_NAME);
    }

    public NewWithdrawPage enterWithdrawAmount(float input) {
        getDriver().findElement(WITHDRAW_AMOUNT_FIELD_LOCATOR).sendKeys(Float.toString(input));
        return this;
    }

    public NewWithdrawPage selectPuppyOptionPoodle() {
        getDriver().findElement(PUPPY_OPTION_POODLE_LOCATOR).click();
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
}
