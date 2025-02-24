package org.example.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.core.DriverHolder.getDriver;

public class BasePage {

    private static final By SYSTEM_USERS_DROPDOWN_LOCATOR = By.xpath("//a[@data-target='#collapseUsers']");
    private static final By NEW_SYSTEM_USER_LOCATOR = By.xpath("//a[text()='New System User']");
    private static final By SYSTEM_USER_LIST_LOCATOR = By.xpath("//a[text()='System User List']");
    private static final By WITHDRAW_DROPDOWN_LOCATOR = By.xpath("//a[@data-target='#collapseWithdraw']");
    private static final By NEW_WITHDRAW_LOCATOR = By.xpath("//a[text()='New Withdraw']");
    private static final By DEPOSIT_DROPDOWN_LOCATOR = By.xpath("//a[@data-target='#collapseDeposit']");
    private static final By NEW_DEPOSIT_LOCATOR = By.xpath("//a[text()='New Deposit']");
    private static final By PUPPY_ACCOUNTS_DROPDOWN_LOCATOR = By.xpath("//a[@data-target='#collapsePuppies']");
    private static final By PUPPY_ACCOUNT_LIST_LOCATOR = By.xpath("//a[text()='Puppy Account List']");
    private static final By USER_DROPDOWN_LOCATOR = By.xpath("//a[@data-toggle='dropdown']");
    private static final By LOGOUT_DROPDOWN_LOCATOR = By.xpath("//a[@data-target='#logoutModal']");
    private static final By LOGOUT_BUTTON_LOCATOR = By.xpath("//a[text()='Logout']");
    private static final By CANCEL_BUTTON_LOCATOR = By.xpath("//button[text()='Cancel']");
    private static final By CLOSE_BUTTON_LOCATOR = By.xpath("//button[@aria-label='Close']");
    private static final By LOGOUT_WINDOW_LOCATOR = By.xpath("//div[contains(@class, 'modal')]");

    public BasePage clickSystemUsersDropdown() {
        getDriver().findElement(SYSTEM_USERS_DROPDOWN_LOCATOR).click();
        return this;
    }

    public BasePage goToNewSystemUser() {
        getDriver().findElement(NEW_SYSTEM_USER_LOCATOR).click();
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

    public BasePage clickUserDropdown() {
        getDriver().findElement(USER_DROPDOWN_LOCATOR).click();
        return this;
    }

    public BasePage clickLogoutDropdown() {
        getDriver().findElement(LOGOUT_DROPDOWN_LOCATOR).click();
        return this;
    }

    public BasePage clickLogoutButton() {
        getDriver().findElement(LOGOUT_BUTTON_LOCATOR).click();
        return this;
    }

    public BasePage clickCancelButton() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(CANCEL_BUTTON_LOCATOR)).click();
        return this;
    }

    public BasePage clickCloseButton() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(CLOSE_BUTTON_LOCATOR)).click();
        return this;
    }

    public BasePage checkLogoutWindowIsClosed() {
        Assertions.assertTrue(new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(LOGOUT_WINDOW_LOCATOR)));
        return this;
    }

}
