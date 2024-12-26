package org.example.pages;

import org.openqa.selenium.By;
import static org.example.core.DriverHolder.getDriver;

public class BasePage {

    private static final By SYSTEM_USERS_DROPDOWN_LOCATOR = By.xpath("//a[@data-target='#collapseUsers']");
    private static final By SYSTEM_USER_LIST_LOCATOR = By.xpath("//a[text()='System User List']");
    private static final By TRANSFER_LOCATOR = By.xpath("//a[@aria-controls='collapseTransfer']");
    private static final By TRANSACTION_LIST_LOCATOR = By.xpath("//a[@href='/app_transfers/list']");
    private static final By NEW_TRANSFER_LOCATOR = By.xpath("//a[@href='/app_transfers/create']");

    public BasePage clickSystemUsersDropdown() {
        getDriver().findElement(SYSTEM_USERS_DROPDOWN_LOCATOR).click();
        return this;
    }

    public BasePage goToSystemUserListPage() {
        getDriver().findElement(SYSTEM_USER_LIST_LOCATOR).click();
        return this;
    }

    public BasePage clickTransfer() {
        getDriver().findElement(TRANSFER_LOCATOR).click();
        return this;
    }

    public BasePage clickTransactionList() {
        getDriver().findElement(TRANSACTION_LIST_LOCATOR).click();
        return this;
    }

    public BasePage clickNewTransfer() {
        getDriver().findElement(NEW_TRANSFER_LOCATOR).click();
        return this;
    }
}
