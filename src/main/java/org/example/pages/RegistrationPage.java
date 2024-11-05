package org.example.pages;

import org.openqa.selenium.By;

import static org.example.core.DriverHolder.getDriver;

public class RegistrationPage {

    private static final String REGISTRATION_PAGE_URL = "http://localhost:8000/app_users/register";
    private static final By USERNAME_INPUT_LOCATOR = By.xpath("//input[@name='username']");
    private static final By PASSWORD_INPUT_LOCATOR = By.xpath("//input[@name='password1']");
    private static final By REPEAT_PASSWORD_INPUT_LOCATOR = By.xpath("//input[@name='password2']");
    private static final By REGISTRATION_BUTTON_LOCATOR = By.xpath("//button[contains(text(), 'Register User')]");

    public RegistrationPage navigateToRegistrationPage() {
        getDriver().get(REGISTRATION_PAGE_URL);
        return this;
    }

    public RegistrationPage enterUsername(String input) {
        getDriver().findElement(USERNAME_INPUT_LOCATOR).sendKeys(input);
        return this;
    }

    public RegistrationPage enterPassword(String input) {
        getDriver().findElement(PASSWORD_INPUT_LOCATOR).sendKeys(input);
        return this;
    }

    public RegistrationPage enterRepeatPassword(String input) {
        getDriver().findElement(REPEAT_PASSWORD_INPUT_LOCATOR).sendKeys(input);
        return this;
    }

    public RegistrationPage clickRegistrationButton() {
        getDriver().findElement(REGISTRATION_BUTTON_LOCATOR).click();
        return this;
    }
}
