package org.example.pages;

import org.openqa.selenium.By;

import static org.example.core.DriverHolder.getDriver;

public class LoginPage {

    private static final String PUPPY_URL = "http://localhost:8000/";
    private static final By USERNAME_INPUT_LOCATOR = By.xpath("//input[@placeholder='Username']");
    private static final By PASSWORD_INPUT_LOCATOR = By.xpath("//input[@placeholder='Password']");
    private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//input[@value='Log in']");

    public LoginPage navigateToPuppyPage() {
        getDriver().get(PUPPY_URL);
        return this;
    }

    public LoginPage enterUsername(String input) {
        getDriver().findElement(USERNAME_INPUT_LOCATOR).sendKeys(input);
        return this;
    }

    public LoginPage enterPassword(String input) {
        getDriver().findElement(PASSWORD_INPUT_LOCATOR).sendKeys(input);
        return this;
    }

    public LoginPage clickLoginButton() {
        getDriver().findElement(LOGIN_BUTTON_LOCATOR).click();
        return this;
    }
}
