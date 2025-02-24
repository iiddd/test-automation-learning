package org.example.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static org.example.core.DriverHolder.getDriver;

public class DashboardPage extends BasePage {

    private static final By DASHBOARD_TITLE_LOCATOR = By.xpath("//h1[text()='Dashboard']");

    public DashboardPage checkDashboardIsDisplayed() {
        Assertions.assertTrue(getDriver().findElement(DASHBOARD_TITLE_LOCATOR).isDisplayed());
        return this;
    }

}