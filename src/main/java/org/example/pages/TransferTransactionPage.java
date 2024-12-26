package org.example.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import static org.example.core.DriverHolder.getDriver;

public class TransferTransactionPage extends BasePage{

    private static final By TRANSFER_TRANSACTION_LOCATOR = By.xpath("//h1[text()='Transfer Transaction']");
    private static final By TRANSFER_AMOUNT_INPUT_LOCATOR = By.xpath("//input[@name='transfer_amount']");
    private static final By FROM_PUPPY_INPUT_LOCATOR = By.xpath("//select[@name='from_puppy']");
    private static final By FROM_POODLE_WHITE_LOCATOR = By.xpath("//select[@name='from_puppy']/child::option[text()='Poodle White']");
    private static final By FROM_SIBERIAN_HUSKY_LOCATOR = By.xpath("//select[@name='from_puppy']/child::option[text()='Siberian Husky']");
    private static final By FROM_GOLDEN_RETRIEVER_LOCATOR = By.xpath("//select[@name='from_puppy']/child::option[text()='Golden Retriever']");
    private static final By TO_PUPPY_INPUT_LOCATOR = By.xpath("//select[@name='to_puppy']");
    private static final By TO_POODLE_WHITE_LOCATOR = By.xpath("//select[@name='to_puppy']/child::option[text()='Poodle White']");
    private static final By TO_SIBERIAN_HUSKY_LOCATOR = By.xpath("//select[@name='to_puppy']/child::option[text()='Siberian Husky']");
    private static final By TO_GOLDEN_RETRIEVER_LOCATOR = By.xpath("//select[@name='to_puppy']/child::option[text()='Golden Retriever']");
    private static final By CONFIRM_BUTTON_LOCATOR = By.xpath("//span[text()='Confirm']");
    private static final By ERROR_LESS_ZERO_LOCATOR = By.xpath("//span[text()='The transfer amount should be more than zero.']");
    private static final By ERROR_NOT_ENOUGH_MONEY_LOCATOR = By.xpath("//span[text()='The transfer amount cannot be more than the account balance.']");

    public TransferTransactionPage checkToTransferTransactionPage() {
        Assertions.assertTrue(getDriver().findElement(TRANSFER_TRANSACTION_LOCATOR).isDisplayed());
        return this;
    }

    public TransferTransactionPage enterTransferAmount(String input) {
        getDriver().findElement(TRANSFER_AMOUNT_INPUT_LOCATOR).sendKeys(input);
        return this;
    }

    public TransferTransactionPage clickFromPuppy() {
        getDriver().findElement(FROM_PUPPY_INPUT_LOCATOR).click();
        return this;
    }

    public TransferTransactionPage clickFromPoodleWhite() {
        getDriver().findElement(FROM_POODLE_WHITE_LOCATOR).click();
        return this;
    }

    public TransferTransactionPage clickFromSiberianHusky() {
        getDriver().findElement(FROM_SIBERIAN_HUSKY_LOCATOR).click();
        return this;
    }

    public TransferTransactionPage clickFromGoldenRetriever() {
        getDriver().findElement(FROM_GOLDEN_RETRIEVER_LOCATOR).click();
        return this;
    }

    public TransferTransactionPage clickToPuppy() {
        getDriver().findElement(TO_PUPPY_INPUT_LOCATOR).click();
        return this;
    }

    public TransferTransactionPage clickToPoodleWhite () {
        getDriver().findElement(TO_POODLE_WHITE_LOCATOR).click();
        return this;
    }

    public TransferTransactionPage clickToSiberianHusky() {
        getDriver().findElement(TO_SIBERIAN_HUSKY_LOCATOR).click();
        return this;
    }

    public TransferTransactionPage clickToGoldenRetriever() {
        getDriver().findElement(TO_GOLDEN_RETRIEVER_LOCATOR).click();
        return this;
    }

    public TransferTransactionPage clickConfirm() {
        getDriver().findElement(CONFIRM_BUTTON_LOCATOR).click();
        return this;
    }

    public TransferTransactionPage checkCreateErrorZero() {
        Assertions.assertTrue(getDriver().findElement(ERROR_LESS_ZERO_LOCATOR).isDisplayed());
        return this;
    }

    public TransferTransactionPage checkNotMoneyError() {
        Assertions.assertTrue(getDriver().findElement(ERROR_NOT_ENOUGH_MONEY_LOCATOR).isDisplayed());
        return this;
    }
}
