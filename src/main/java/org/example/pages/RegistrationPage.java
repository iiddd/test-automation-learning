package org.example.pages;

import org.example.utils.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static org.example.core.DriverHolder.getDriver;

public class RegistrationPage extends BasePage {

    private static final String REGISTRATION_PAGE_URL = "http://localhost:8000/app_users/register";
    private static final By USERNAME_INPUT_LOCATOR = By.xpath("//input[@name='username']");
    private static final By PASSWORD_INPUT_LOCATOR = By.xpath("//input[@name='password1']");
    private static final By REPEAT_PASSWORD_INPUT_LOCATOR = By.xpath("//input[@name='password2']");
    private static final By REGISTRATION_BUTTON_LOCATOR = By.xpath("//button[contains(text(), 'Register User')]");
    private static final By ALREADY_HAVE_AN_ACCOUNT_LOCATOR = By.xpath("//a[contains(text(), 'Login!')]");
    private static final By CREATE_A_USER_TITLE_LOCATOR = By.xpath("//h1[text()='Create a User!']");
    private static final By TOO_MANY_CHARACTERS_ERROR_LOCATOR = By.xpath("//li[text()='Ensure this value has at most 150 characters (it has 151).']");
    private static final By FORBIDDEN_CHARACTERS_ERROR_LOCATOR = By.xpath("//li[text()='Enter a valid username. This value may contain only letters, numbers, and @/./+/-/_ characters.']");
    private static final By PASSWORDS_DIFFERENT_ERROR_LOCATOR = By.xpath("//li[text()='The two password fields didn’t match.']");
    private static final By SHORT_PASSWORD_ERROR_LOCATOR = By.xpath("//li[text()='This password is too short. It must contain at least 8 characters.']");
    private static final By PASSWORD_ONLY_DIGITS_ERROR_LOCATOR = By.xpath("//li[text()='This password is entirely numeric.']");
    private static final By PASSWORD_AND_USERNAME_ARE_SIMILAR_ERROR_LOCATOR = By.xpath("//li[text()='The password is too similar to the username.']");

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

    public RegistrationPage checkUsernameFieldIsDisplayed() {
        Assertions.assertTrue(getDriver().findElement(USERNAME_INPUT_LOCATOR).isDisplayed());
        return this;
    }

    public RegistrationPage checkPasswordFieldIsDisplayed() {
        Assertions.assertTrue(getDriver().findElement(PASSWORD_INPUT_LOCATOR).isDisplayed());
        return this;
    }

    public RegistrationPage checkRepeatPasswordFieldIsDisplayed() {
        Assertions.assertTrue(getDriver().findElement(REPEAT_PASSWORD_INPUT_LOCATOR).isDisplayed());
        return this;
    }

    public RegistrationPage checkRegistrationButtonIsDisplayed() {
        Assertions.assertTrue(getDriver().findElement(REGISTRATION_BUTTON_LOCATOR).isDisplayed());
        return this;
    }

    public RegistrationPage checkBackToLoginPageLinkIsDisplayed() {
        Assertions.assertTrue(getDriver().findElement(ALREADY_HAVE_AN_ACCOUNT_LOCATOR).isDisplayed());
        return this;
    }

    public RegistrationPage checkCreateAUserTitleIsDisplayed() {
        Assertions.assertTrue(getDriver().findElement(CREATE_A_USER_TITLE_LOCATOR).isDisplayed());
        return this;
    }

    public RegistrationPage TooManyCharactersError() {
        Assertions.assertTrue(getDriver().findElement(TOO_MANY_CHARACTERS_ERROR_LOCATOR).isDisplayed());
        return this;
    }

    public RegistrationPage checkForbiddenCharactersError() {
        Assertions.assertTrue(getDriver().findElement(FORBIDDEN_CHARACTERS_ERROR_LOCATOR).isDisplayed());
        return this;
    }

    public RegistrationPage checkPasswordsDiffError() {
        Assertions.assertTrue(getDriver().findElement(PASSWORDS_DIFFERENT_ERROR_LOCATOR).isDisplayed());
        return this;
    }

    public RegistrationPage checkShortPasswordError() {
        Assertions.assertTrue(getDriver().findElement(SHORT_PASSWORD_ERROR_LOCATOR).isDisplayed());
        return this;
    }

    public RegistrationPage checkPasswordOnlyDigitsError() {
        Assertions.assertTrue(getDriver().findElement(PASSWORD_ONLY_DIGITS_ERROR_LOCATOR).isDisplayed());
        return this;
    }

    public RegistrationPage checkPasswordAndUsernameAreSimilarError() {
        Assertions.assertTrue(getDriver().findElement(PASSWORD_AND_USERNAME_ARE_SIMILAR_ERROR_LOCATOR).isDisplayed());
        return this;
    }

    public RegistrationPage checkUsernameFieldIsEmpty() {
        Assertions.assertTrue(getDriver().findElement(USERNAME_INPUT_LOCATOR).getText().isEmpty());
        return this;
    }

    public RegistrationPage checkPasswordFieldIsEmpty() {
        Assertions.assertTrue(getDriver().findElement(PASSWORD_INPUT_LOCATOR).getText().isEmpty());
        return this;
    }

    public RegistrationPage checkRepeatPasswordFieldIsEmpty() {
        Assertions.assertTrue(getDriver().findElement(REPEAT_PASSWORD_INPUT_LOCATOR).getText().isEmpty());
        return this;
    }

    public RegistrationPage clearUsername() {
        getDriver().findElement(USERNAME_INPUT_LOCATOR).clear();
        return this;
    }

    public RegistrationPage clearPassword() {
        getDriver().findElement(PASSWORD_INPUT_LOCATOR).clear();
        return this;
    }

    public RegistrationPage clearRepeatPassword() {
        getDriver().findElement(REPEAT_PASSWORD_INPUT_LOCATOR).clear();
        return this;
    }

    public RegistrationPage enterRandomUsername(int lenght) {
        enterUsername(StringUtils.genrateString(lenght));
        return this;
    }

    public RegistrationPage checkLayout() {
        checkUsernameFieldIsDisplayed();
        checkUsernameFieldIsEmpty();
        checkPasswordFieldIsDisplayed();
        checkPasswordFieldIsEmpty();
        checkRepeatPasswordFieldIsDisplayed();
        checkRepeatPasswordFieldIsEmpty();
        checkRegistrationButtonIsDisplayed();
        checkBackToLoginPageLinkIsDisplayed();
        checkCreateAUserTitleIsDisplayed();
        return this;
    }

}
