package org.example.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static org.example.core.DriverHolder.getDriver;
import static org.example.utils.WaitUtils.dummyWait;

public class SearchPage {

    private final static boolean IS_GDPR = true;
    public static final String DOTA_BUFF_URL = "https://www.dotabuff.com/";
    public static final By GDPR_CLOSE_BUTTON_LOCATOR = By.xpath("//button[@mode='primary']");
    public static final By SEARCH_FIELD_LOCATOR = By.xpath("//input[@id='q'][@tabindex='1']");
    public static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//button[@type='submit']");
    public static final By SEARCH_RESULT_TEXT_LOCATOR = By.xpath("//header[@style='position: relative'][contains(text(),'1 Heroes')]");

    public SearchPage openSearchPage() {
        getDriver().get(DOTA_BUFF_URL);
        return this;
    }

    public SearchPage handleCookiePopup() {
        if (IS_GDPR) {
            dummyWait(1);
            getDriver().findElement(GDPR_CLOSE_BUTTON_LOCATOR).click();
        }
        return this;
    }

    public SearchPage inputSearchText(String input) {
        getDriver().findElement(SEARCH_FIELD_LOCATOR).sendKeys(input);
        return this;
    }

    public SearchPage clickSubmitButton() {
        getDriver().findElement(SUBMIT_BUTTON_LOCATOR).click();
        return this;
    }

    public SearchPage checkSingleResultIsDisplayed() {
        Assertions.assertTrue(getDriver().findElement(SEARCH_RESULT_TEXT_LOCATOR).isDisplayed());
        return this;
    }
}
