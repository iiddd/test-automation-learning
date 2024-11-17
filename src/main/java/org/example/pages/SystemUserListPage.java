package org.example.pages;

import org.openqa.selenium.By;

import static org.example.core.DriverHolder.getDriver;

public class SystemUserListPage extends BasePage {

    private static final By TEST_ACCOUNT_PROFILE_LOCATOR = By.xpath("//a[text()='Testaccount5']");
    private static final By DELETE_BUTTON_LOCATOR = By.xpath("//div[@data-target='#deleteModal']");
    private static final By ACCEPT_DELETE_BUTTON_LOCATOR = By.xpath("//button[@name='delete_object']");

    public SystemUserListPage goToTestAccountProfile() {
        getDriver().findElement(TEST_ACCOUNT_PROFILE_LOCATOR).click();
        return this;
    }

    public SystemUserListPage clickDeleteButton() {
        getDriver().findElement(DELETE_BUTTON_LOCATOR).click();
        return this;
    }

    public SystemUserListPage clickAcceptDeleteButton() {
        getDriver().findElement(ACCEPT_DELETE_BUTTON_LOCATOR).click();
        return this;
    }
}
