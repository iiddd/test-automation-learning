package org.example.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static org.example.core.DriverHolder.getDriver;

public class LoginPage {

    private static final String PUPPY_URL = "http://localhost:8000/";
    private static final By LOGIN_PAGE_TITLE_LOCATOR = By.xpath("//h1[text()='Welcome to Puppy Bank']");
    private static final By USERNAME_INPUT_LOCATOR = By.xpath("//input[@placeholder='Username']");
    private static final By PASSWORD_INPUT_LOCATOR = By.xpath("//input[@placeholder='Password']");
    private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//input[@value='Log in']");

    public LoginPage navigateToPuppyPage() {
        getDriver().get(PUPPY_URL);
        return this;
    }

    public LoginPage checkLoginPageTitleIsDisplayed() {
        Assertions.assertTrue(getDriver().findElement(LOGIN_PAGE_TITLE_LOCATOR).isDisplayed());
        return this;
    }

    public LoginPage enterUsername(String input) {
        getDriver().findElement(USERNAME_INPUT_LOCATOR).sendKeys(input);
        return this;
    }

    public LoginPage clearUsername() {
        getDriver().findElement(USERNAME_INPUT_LOCATOR).clear();
        return this;
    }

    public LoginPage enterPassword(String input) {
        getDriver().findElement(PASSWORD_INPUT_LOCATOR).sendKeys(input);
        return this;
    }

    public LoginPage clearPassword() {
        getDriver().findElement(PASSWORD_INPUT_LOCATOR).clear();
        return this;
    }

    public LoginPage clickLoginButton() {
        getDriver().findElement(LOGIN_BUTTON_LOCATOR).click();
        return this;
    }

    public LoginPage loginTestAccount() {
        getDriver().findElement(USERNAME_INPUT_LOCATOR).sendKeys("Testaccount5");
        getDriver().findElement(PASSWORD_INPUT_LOCATOR).sendKeys("AbobaPuppy");
        getDriver().findElement(LOGIN_BUTTON_LOCATOR).click();
        return this;
    }

    public LoginPage deleteTestAccount() {
        getDriver().findElement(By.xpath("//a[@data-target='#collapseUsers']")).click();
        getDriver().findElement(By.xpath("//a[text()='System User List']")).click();
        getDriver().findElement(By.xpath("//a[text()='Testaccount5']")).click();
        getDriver().findElement(By.xpath("//div[@data-target='#deleteModal']")).click();
        getDriver().findElement(By.xpath("//button[@name='delete_object']")).click();
        return this;
    }
}
