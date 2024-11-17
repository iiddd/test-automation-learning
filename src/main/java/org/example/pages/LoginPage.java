package org.example.pages;

import org.example.utils.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static org.example.core.DriverHolder.getDriver;

public class LoginPage {

    private static final String PUPPY_URL = "http://localhost:8000/";
    private static final By USERNAME_INPUT_LOCATOR = By.xpath("//input[@placeholder='Username']");
    private static final By PASSWORD_INPUT_LOCATOR = By.xpath("//input[@placeholder='Password']");
    private static final By LOGIN_BUTTON_LOCATOR = By.xpath("//input[@value='Log in']");
    private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//p[@class='errornote']");
    private static final By LOGIN_PAGE_TITLE_LOCATOR = By.xpath("//h1[text()='Welcome to Puppy Bank']");
    private static final By REGISTER_BUTTON_LOCATOR = By.xpath("//a[contains(text(),'Register')]");
    private static final By ABOUT_LINK_LOCATOR = By.xpath("//a[contains(text(),'About the App')]");

    public LoginPage loginAsAdmin() {
        getDriver().get(PUPPY_URL);
        getDriver().findElement(USERNAME_INPUT_LOCATOR).sendKeys("admin");
        getDriver().findElement(PASSWORD_INPUT_LOCATOR).sendKeys("password");
        getDriver().findElement(LOGIN_BUTTON_LOCATOR).click();
        return this;
    }

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

    public LoginPage enterRandomUsername(int lenght) {
        enterUsername(StringUtils.genrateString(lenght));
        return this;
    }

    public LoginPage enterRandomPassword(int lenght) {
        enterPassword(StringUtils.genrateString(lenght));
        return this;
    }

    public LoginPage clickLoginButton() {
        getDriver().findElement(LOGIN_BUTTON_LOCATOR).click();
        return this;
    }

    public LoginPage checkErrorMessageIsDisplayed() {
        Assertions.assertTrue(getDriver().findElement(ERROR_MESSAGE_LOCATOR).isDisplayed());
        return this;
    }

    public LoginPage checkUsernameFieldIsDisplayed() {
        Assertions.assertTrue(getDriver().findElement(USERNAME_INPUT_LOCATOR).isDisplayed());
        return this;
    }

    public LoginPage checkPasswordFieldIsDisplayed() {
        Assertions.assertTrue(getDriver().findElement(PASSWORD_INPUT_LOCATOR).isDisplayed());
        return this;
    }

    public LoginPage checkUsernameFieldIsEmpty() {
        Assertions.assertTrue(getDriver().findElement(USERNAME_INPUT_LOCATOR).getText().isEmpty());
        return this;
    }

    public LoginPage checkPasswordFieldIsEmpty() {
        Assertions.assertTrue(getDriver().findElement(PASSWORD_INPUT_LOCATOR).getText().isEmpty());
        return this;
    }

    public LoginPage checkLoginButtonIsDisplayed() {
        Assertions.assertTrue(getDriver().findElement(LOGIN_BUTTON_LOCATOR).isDisplayed());
        return this;
    }

    public LoginPage checkRegisterButtonIsDisplayed() {
        Assertions.assertTrue(getDriver().findElement(REGISTER_BUTTON_LOCATOR).isDisplayed());
        return this;
    }

    public LoginPage checkAboutLinkIsDisplayed() {
        Assertions.assertTrue(getDriver().findElement(ABOUT_LINK_LOCATOR).isDisplayed());
        return this;
    }

    public LoginPage loginWithTestAccount() {
        getDriver().findElement(USERNAME_INPUT_LOCATOR).sendKeys("Testaccount5");
        getDriver().findElement(PASSWORD_INPUT_LOCATOR).sendKeys("AbobaPuppy");
        getDriver().findElement(LOGIN_BUTTON_LOCATOR).click();
        return this;
    }

    public LoginPage checkLayout() {
        checkLoginPageTitleIsDisplayed();
        checkPasswordFieldIsDisplayed();
        checkUsernameFieldIsDisplayed();
        checkUsernameFieldIsEmpty();
        checkPasswordFieldIsEmpty();
        checkLoginButtonIsDisplayed();
        checkRegisterButtonIsDisplayed();
        checkAboutLinkIsDisplayed();
        return this;
    }
}
