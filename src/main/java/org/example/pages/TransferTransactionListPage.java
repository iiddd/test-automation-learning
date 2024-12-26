package org.example.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import static org.example.core.DriverHolder.getDriver;

public class TransferTransactionListPage extends BasePage{

    private static final By TRANSFER_TRANSACTION_LIST_LOCATOR = By.xpath("//h1[text()='Transfer Transaction List']");
    private static final By CREATE_NEW_BUTTON_LOCATOR = By.xpath("//a[@href='/app_transfers/create']");

    public TransferTransactionListPage checkToTransactionListPage() {
        Assertions.assertTrue(getDriver().findElement(TRANSFER_TRANSACTION_LIST_LOCATOR).isDisplayed());
        return this;
    }

    public TransferTransactionListPage clickCreateNewButton() {
        getDriver().findElement(CREATE_NEW_BUTTON_LOCATOR).click();
        return this;
    }

}
