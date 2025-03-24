package org.example.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.core.DriverHolder.getDriver;

public class DashboardPage extends BasePage {

    private static final By DASHBOARD_TITLE_LOCATOR = By.xpath("//h1[text()='Dashboard']");

    public DashboardPage checkDashboardIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(DASHBOARD_TITLE_LOCATOR)));
        Assertions.assertTrue(getDriver().findElement(DASHBOARD_TITLE_LOCATOR).isDisplayed());
        return this;
    }
}