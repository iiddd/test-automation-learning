package org.example.pages;

import org.openqa.selenium.By;

import static org.example.core.DriverHolder.getDriver;

public class BasePage {

    private static final By SYSTEM_USERS_DROPDOWN_LOCATOR = By.xpath("//a[@data-target='#collapseUsers']");
    private static final By SYSTEM_USER_LIST_LOCATOR = By.xpath("//a[text()='System User List']");
    private static final By WITHDRAW_DROPDOWN_LOCATOR = By.xpath("//a[@data-target='#collapseWithdraw']");
    private static final By NEW_WITHDRAW_LOCATOR = By.xpath("//a[text()='New Withdraw']");
    private static final By DEPOSIT_DROPDOWN_LOCATOR = By.xpath("//a[@data-target='#collapseDeposit']");
    private static final By NEW_DEPOSIT_LOCATOR = By.xpath("//a[text()='New Deposit']");
    private static final By PUPPY_ACCOUNTS_DROPDOWN_LOCATOR = By.xpath("//a[@data-target='#collapsePuppies']");
    private static final By PUPPY_ACCOUNT_LIST_LOCATOR = By.xpath("//a[text()='Puppy Account List']");

    public BasePage clickSystemUsersDropdown() {
        getDriver().findElement(SYSTEM_USERS_DROPDOWN_LOCATOR).click();
        return this;
    }

    public BasePage goToSystemUserListPage() {
        getDriver().findElement(SYSTEM_USER_LIST_LOCATOR).click();
        return this;
    }

    public BasePage clickWithdrawDropdown() {
        getDriver().findElement(WITHDRAW_DROPDOWN_LOCATOR).click();
        return this;
    }

    public BasePage goNewWithdraw() {
        getDriver().findElement(NEW_WITHDRAW_LOCATOR).click();
        return this;
    }

    public BasePage clickDepositDropdown() {
        getDriver().findElement(DEPOSIT_DROPDOWN_LOCATOR).click();
        return this;
    }

    public BasePage goNewDeposit() {
        getDriver().findElement(NEW_DEPOSIT_LOCATOR).click();
        return this;
    }

    public BasePage clickPuppyAccountsDropdown() {
        getDriver().findElement(PUPPY_ACCOUNTS_DROPDOWN_LOCATOR).click();
        return this;
    }

    public BasePage goPuppyAccountList() {
        getDriver().findElement(PUPPY_ACCOUNT_LIST_LOCATOR).click();
        return this;
    }
}
