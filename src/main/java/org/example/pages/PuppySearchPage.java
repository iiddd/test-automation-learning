package org.example.pages;

import org.openqa.selenium.By;

import static org.example.core.DriverHolder.getDriver;

public class PuppySearchPage {

    public static final String PUPPY_URL = "http://localhost:8000/";
    public static final By ENTER_USERNAME = By.xpath("//input[@placeholder='Username']");
    public static final By ENTER_PASSWORD = By.xpath("//input[@placeholder='Password']");
    public static final By LOGIN = By.xpath("//input[@value='Log in']");

    public PuppySearchPage openPuppyPage() {
        getDriver().get(PUPPY_URL);
        return this;
    }

    public PuppySearchPage enterUsername(String input) {
        getDriver().findElement(ENTER_USERNAME).sendKeys(input);
        return this;
    }

    public PuppySearchPage enterPassword(String input) {
        getDriver().findElement(ENTER_PASSWORD).sendKeys(input);
        return this;
    }

    public PuppySearchPage logIn() {
        getDriver().findElement(LOGIN);
        return this;
    }
}
