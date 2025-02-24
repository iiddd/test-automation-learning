package org.example.pages;

import org.example.models.rest.SystemUser;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.example.core.DriverHolder.getDriver;

public class SystemUserListPage extends BasePage {

    private static final By SYSTEM_USER_LIST_HEADER_LOCATOR = By.xpath("//h1[text()='System User List']");
    private static final By TEST_ACCOUNT_PROFILE_LOCATOR = By.xpath("//a[text()='Testaccount5']");
    private static final By DELETE_BUTTON_LOCATOR = By.xpath("//div[@data-target='#deleteModal']");
    private static final By ACCEPT_DELETE_BUTTON_LOCATOR = By.xpath("//button[@name='delete_object']");
    private static final By SYSTEM_USER_ROW_LOCATOR = By.xpath("//tbody/tr");
    private static final By USERNAME_COLUMN_LOCATOR = By.xpath("./td[position()=1]");
    private static final By DATE_JOINED_COLUMN_LOCATOR = By.xpath("./td[position()=2]");


    public SystemUserListPage checkSystemUserListIsDisplayed() {
        getDriver().findElement(SYSTEM_USER_LIST_HEADER_LOCATOR).isDisplayed();
        return this;
    }

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

    public SystemUserListPage checkSystemUserListContainsUsername(String username) {
        Assertions.assertTrue(
                getSystemUser().stream().anyMatch(
                        systemUser -> systemUser.getUsername().equals(username)
                )
        );
        return this;
    }

    private List<SystemUser> getSystemUser() {
        return getDriver().findElements(SYSTEM_USER_ROW_LOCATOR).stream()
                .map(row -> mapSystemUser(row))
                .collect(Collectors.toList());
    }

    private SystemUser mapSystemUser(WebElement row) {
        SystemUser.SystemUserBuilder systemUser = SystemUser.builder();
        systemUser
                .username(row.findElement(USERNAME_COLUMN_LOCATOR).getText())
                .dateJoined(row.findElement(DATE_JOINED_COLUMN_LOCATOR).getText());
        return systemUser.build();
    }

}
