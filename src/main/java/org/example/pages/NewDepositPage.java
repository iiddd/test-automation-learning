package org.example.pages;

import org.openqa.selenium.By;

import static org.example.core.DriverHolder.getDriver;

public class NewDepositPage {
    private static final By DEPOSIT_AMOUNT_FIELD_LOCATOR = By.xpath("//input[@name='deposit_amount']");
    private static final By PUPPY_OPTION_POODLE_LOCATOR = By.xpath("//option[text()='Poodle White']");
    private static final By CONFIRM_BUTTON_LOCATOR = By.xpath("//span[text()='Confirm']");
    private static final String DEPOSIT_AMOUNT = "1";

    public NewDepositPage enterDepositAmount(String input) {
        getDriver().findElement(DEPOSIT_AMOUNT_FIELD_LOCATOR).sendKeys(input);
        return this;
    }

    public NewDepositPage selectPuppyOptionPoodle() {
        getDriver().findElement(PUPPY_OPTION_POODLE_LOCATOR).click();
        return this;
    }

    public NewDepositPage clickConfirmButton() {
        getDriver().findElement(CONFIRM_BUTTON_LOCATOR).click();
        return this;
    }

    public NewDepositPage createDepositTransaction() {
        enterDepositAmount(DEPOSIT_AMOUNT);
        selectPuppyOptionPoodle();
        clickConfirmButton();
        return this;
    }
}
