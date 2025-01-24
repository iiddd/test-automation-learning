package org.example.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static org.example.core.DriverHolder.getDriver;

public class TransferTransactionPage extends BasePage {

    private static final By TRANSFER_TRANSACTION_TITLE_LOCATOR = By.xpath("//h1[text()='Transfer Transaction']");
    private static final By TRANSFER_AMOUNT_FIELD_LOCATOR = By.xpath("//input[@name='transfer_amount']");
    private static final By FROM_JACK_RUSSELL_LOCATOR = By.xpath("//select[@name='from_puppy']/child::option[text()='Jack Russell']");
    private static final By TO_SPITZ_POMERANIAN_LOCATOR = By.xpath("//select[@name='to_puppy']/child::option[text()='Spitz Pomeranian']");
    private static final By TO_NEW_PUPPY_LOCATOR = By.xpath("//select[@name='to_puppy']/child::option[text()='New Puppy']");
    private static final By FROM_NEW_PUPPY_LOCATOR = By.xpath("//select[@name='from_puppy']/child::option[text()='New Puppy']");
    private static final By CONFIRM_BUTTON_LOCATOR = By.xpath("//span[text()='Confirm']");
    private static final By ERROR_LESS_ZERO_LOCATOR = By.xpath("//span[text()='The transfer amount should be more than zero.']");
    private static final By ERROR_NOT_ENOUGH_MONEY_LOCATOR = By.xpath("//span[text()='The transfer amount cannot be more than the account balance.']");
    private static final By TRANSACTION_REFERENCE_LOCATOR = By.xpath("//input[@name='transaction_reference']");
    private static final By ERROR_SAME_PUPPIES_LOCATOR = By.xpath("//span[text()='The source and destination puppy cannot be the same.']");
    private static final String VALUE_ATTRIBUTE_NAME = "value";
    private static final By EMPTY_FROM_PUPPY_OPTION_LOCATOR = By.xpath("//select[@name='from_puppy']/child::option[text()='---------']");
    private static final By EMPTY_TO_PUPPY_OPTION_LOCATOR = By.xpath("//select[@name='to_puppy']/child::option[text()='---------']");
    private static final By FROM_PUPPY_FIELD_LOCATOR = By.xpath("//select[@name='from_puppy']");
    private static final By TO_PUPPY_FIELD_LOCATOR = By.xpath("//select[@name='to_puppy']");

    public TransferTransactionPage checkTransferTransactionTitleIsDisplayed() {
        Assertions.assertTrue(getDriver().findElement(TRANSFER_TRANSACTION_TITLE_LOCATOR).isDisplayed());
        return this;
    }

    public TransferTransactionPage enterTransferAmount(String input) {
        getDriver().findElement(TRANSFER_AMOUNT_FIELD_LOCATOR).sendKeys(input);
        return this;
    }


    public TransferTransactionPage selectFromJackRussellOption() {
        getDriver().findElement(FROM_JACK_RUSSELL_LOCATOR).click();
        return this;
    }


    public TransferTransactionPage selectToSpitzPomeranianOption() {
        getDriver().findElement(TO_SPITZ_POMERANIAN_LOCATOR).click();
        return this;
    }


    public TransferTransactionPage clickConfirm() {
        getDriver().findElement(CONFIRM_BUTTON_LOCATOR).click();
        return this;
    }

    public TransferTransactionPage checkErrorCreateZero() {
        Assertions.assertTrue(getDriver().findElement(ERROR_LESS_ZERO_LOCATOR).isDisplayed());
        return this;
    }

    public TransferTransactionPage checkErrorNotEnoughMoney() {
        Assertions.assertTrue(getDriver().findElement(ERROR_NOT_ENOUGH_MONEY_LOCATOR).isDisplayed());
        return this;
    }

    public String getTransactionReference() {
        return getDriver().findElement(TRANSACTION_REFERENCE_LOCATOR).getAttribute(VALUE_ATTRIBUTE_NAME);
    }

    public TransferTransactionPage selectToNewPuppyOption() {
        getDriver().findElement(TO_NEW_PUPPY_LOCATOR).click();
        return this;
    }

    public TransferTransactionPage selectFromNewPuppyOption() {
        getDriver().findElement(FROM_NEW_PUPPY_LOCATOR).click();
        return this;
    }

    public TransferTransactionPage checkErrorSamePuppies() {
        Assertions.assertTrue(getDriver().findElement(ERROR_SAME_PUPPIES_LOCATOR).isDisplayed());
        return this;
    }

    public TransferTransactionPage clearTransferAmountField() {
        getDriver().findElement(TRANSFER_AMOUNT_FIELD_LOCATOR).clear();
        return this;
    }

    public TransferTransactionPage selectEmptyFromPuppyOption() {
        getDriver().findElement(EMPTY_FROM_PUPPY_OPTION_LOCATOR).click();
        return this;
    }

    public TransferTransactionPage selectEmptyToPuppyOption() {
        getDriver().findElement(EMPTY_TO_PUPPY_OPTION_LOCATOR).click();
        return this;
    }

    public TransferTransactionPage checkErrorMessageTransferAmountFieldExist() {
        Assertions.assertTrue(Boolean.parseBoolean(getDriver().findElement(TRANSFER_AMOUNT_FIELD_LOCATOR).getAttribute("required")));
        return this;
    }

    public TransferTransactionPage checkErrorMessageFromPuppyFieldExist() {
        Assertions.assertTrue(Boolean.parseBoolean(getDriver().findElement(FROM_PUPPY_FIELD_LOCATOR).getAttribute("required")));
        return this;
    }

    public TransferTransactionPage checkErrorMessageToPuppyFieldExist() {
        Assertions.assertTrue((Boolean.parseBoolean(getDriver().findElement(TO_PUPPY_FIELD_LOCATOR).getAttribute("required"))));
        return this;
    }

    public TransferTransactionPage checkErrorMessageInTransferAmountFieldIsCorrect(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, getDriver().findElement(TRANSFER_AMOUNT_FIELD_LOCATOR).getAttribute("validationMessage"));
        return this;
    }

    public TransferTransactionPage checkErrorMessageFromPuppyFieldIsCorrect(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, getDriver().findElement(FROM_PUPPY_FIELD_LOCATOR).getAttribute("validationMessage"));
        return this;
    }

    public TransferTransactionPage checkErrorMessageToPuppyFieldIsCorrect(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, getDriver().findElement(TO_PUPPY_FIELD_LOCATOR).getAttribute("validationMessage"));
        return this;
    }
}