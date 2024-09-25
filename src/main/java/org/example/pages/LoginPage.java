package org.example.pages;

import org.openqa.selenium.By;

import static org.example.core.DriverHolder.getDriver;

public class LoginPage {

    private static final String PUPPY_URL = "http://localhost:8000/";
    private static final By ENTER_USERNAME = By.xpath("//input[@placeholder='Username']");
    private static final By ENTER_PASSWORD = By.xpath("//input[@placeholder='Password']");
    private static final By LOGIN = By.xpath("//input[@value='Log in']");

    public LoginPage openPuppyPage() {
        getDriver().get(PUPPY_URL);
        return this;
    }

    public LoginPage enterUsername(String input) {
        getDriver().findElement(ENTER_USERNAME).sendKeys(input);
        return this;
    }

    public LoginPage enterPassword(String input) {
        getDriver().findElement(ENTER_PASSWORD).sendKeys(input);
        return this;
    }

    public LoginPage login() {
        getDriver().findElement(LOGIN);
        return this;
    }
}
