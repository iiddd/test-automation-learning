package org.example.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static org.example.core.DriverHolder.getDriver;


public class NewSystemUserPage extends BasePage {

    private static final By CREATE_SYSTEM_USER_HEADER_LOCATOR = By.xpath("//h1[text()='Create System User']");
    private static final By USERNAME_FIELD_LOCATOR = By.xpath("//input[@name='username']");
    private static final By PASSWORD_FIELD_LOCATOR = By.xpath("//input[@name='password1']");
    private static final By REPEAT_PASSWORD_FIELD_LOCATOR = By.xpath("//input[@name='password2']");
    private static final By CONFIRM_BUTTON_LOCATOR = By.xpath("//span[text()='Confirm']");
    private static final By PASSWORD_TOO_COMMON_ERROR_LOCATOR = By.xpath("//li[text()='This password is too common.']");
    private static final By PASSWORD_NUMBERS_ERROR_LOCATOR = By.xpath("//li[text()='This password is entirely numeric.']");
    private static final By SAME_PASSWORD_AND_USERNAME_ERROR_LOCATOR = By.xpath("//li[text()='The password is too similar to the username.']");
    private static final By SMALL_PASSWORD_ERROR_LOCATOR = By.xpath("//li[text()='This password is too short. It must contain at least 8 characters.']");
    private static final By PASSWORD_DID_NOT_MATCH_ERROR_LOCATOR = By.xpath("//li[text()='The two password fields didn’t match.']");
    private static final By ILLEGAL_USERNAME_ERROR_LOCATOR = By.xpath("//li[text()='Enter a valid username. This value may contain only letters, numbers, and @/./+/-/_ characters.']");
    private static final By TOO_MANY_CHARACTERS_ERROR_LOCATOR = By.xpath("//li[text()='Ensure this value has at most 150 characters (it has 151).']");
    private static final By USERNAME_ALREADY_EXISTS_ERROR_LOCATOR = By.xpath("//li[text()='A user with that username already exists.']");

    public NewSystemUserPage checkNewSystemUserIsDisplayed() {
        Assertions.assertTrue(getDriver().findElement(CREATE_SYSTEM_USER_HEADER_LOCATOR).isDisplayed());
        return this;
    }

    public NewSystemUserPage clearUsername() {
        getDriver().findElement(USERNAME_FIELD_LOCATOR).clear();
        return this;
    }

    public NewSystemUserPage clearPassword() {
        getDriver().findElement(PASSWORD_FIELD_LOCATOR).clear();
        return this;
    }

    public NewSystemUserPage clearRepeatPassword() {
        getDriver().findElement(REPEAT_PASSWORD_FIELD_LOCATOR).clear();
        return this;
    }

    public NewSystemUserPage enterUsername(String input) {
        getDriver().findElement(USERNAME_FIELD_LOCATOR).sendKeys(input);
        return this;
    }

    public NewSystemUserPage enterPassword(String input) {
        getDriver().findElement(PASSWORD_FIELD_LOCATOR).sendKeys(input);
        return this;
    }

    public NewSystemUserPage enterRepeatPassword(String input) {
        getDriver().findElement(REPEAT_PASSWORD_FIELD_LOCATOR).sendKeys(input);
        return this;
    }

    public NewSystemUserPage clickConfirmButton() {
        getDriver().findElement(CONFIRM_BUTTON_LOCATOR).click();
        return this;
    }

    public NewSystemUserPage checkErrorEmptyUsernameFieldExist() {
        Assertions.assertTrue(Boolean.parseBoolean(getDriver().findElement(USERNAME_FIELD_LOCATOR).getAttribute("required")));
        return this;
    }

    public NewSystemUserPage checkErrorMessageInUsernameFieldIsCorrect(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, getDriver().findElement(USERNAME_FIELD_LOCATOR).getAttribute("validationMessage"));
        return this;
    }

    public NewSystemUserPage checkErrorEmptyPasswordFieldExist() {
        Assertions.assertTrue(Boolean.parseBoolean(getDriver().findElement(PASSWORD_FIELD_LOCATOR).getAttribute("required")));
        return this;
    }

    public NewSystemUserPage checkErrorMessageInPasswordFieldIsCorrect(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, getDriver().findElement(PASSWORD_FIELD_LOCATOR).getAttribute("validationMessage"));
        return this;
    }

    public NewSystemUserPage checkErrorEmptyRepeatPasswordFieldExist() {
        Assertions.assertTrue(Boolean.parseBoolean(getDriver().findElement(REPEAT_PASSWORD_FIELD_LOCATOR).getAttribute("required")));
        return this;
    }

    public NewSystemUserPage checkErrorMessageInRepeatPasswordFieldIsCorrect(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, getDriver().findElement(REPEAT_PASSWORD_FIELD_LOCATOR).getAttribute("validationMessage"));
        return this;
    }

    public NewSystemUserPage checkErrorPasswordTooCommonIsDisplayed() {
        getDriver().findElement(PASSWORD_TOO_COMMON_ERROR_LOCATOR).isDisplayed();
        return this;
    }

    public NewSystemUserPage checkErrorPasswordNumbersIsDisplayed() {
        getDriver().findElement(PASSWORD_NUMBERS_ERROR_LOCATOR).isDisplayed();
        return this;
    }

    public NewSystemUserPage checkErrorSamePasswordAndUsernameIsDisplayed() {
        getDriver().findElement(SAME_PASSWORD_AND_USERNAME_ERROR_LOCATOR).isDisplayed();
        return this;
    }

    public NewSystemUserPage checkErrorSmallPasswordIsDisplayed() {
        getDriver().findElement(SMALL_PASSWORD_ERROR_LOCATOR).isDisplayed();
        return this;
    }

    public NewSystemUserPage checkErrorPasswordDidNotMatchIsDisplayed() {
        getDriver().findElement(PASSWORD_DID_NOT_MATCH_ERROR_LOCATOR).isDisplayed();
        return this;
    }

    public NewSystemUserPage checkErrorIllegalUsernameIsDisplayed() {
        getDriver().findElement(ILLEGAL_USERNAME_ERROR_LOCATOR).isDisplayed();
        return this;
    }

    public NewSystemUserPage checkErrorTooManyCharactersIsDisplayed() {
        getDriver().findElement(TOO_MANY_CHARACTERS_ERROR_LOCATOR).isDisplayed();
        return this;
    }

    public NewSystemUserPage checkErrorUsernameAlreadyExistsIsDisplayed() {
        getDriver().findElement(USERNAME_ALREADY_EXISTS_ERROR_LOCATOR).isDisplayed();
        return this;
    }

}
