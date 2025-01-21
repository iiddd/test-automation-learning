package org.example.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverHolder {

    private static WebDriver driver;

    public static void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(
                new ChromeOptions()
                        .addArguments("--disable-search-engine-choice-screen")
                        .addArguments("--lang=en-GB")
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void killDriver() {
        driver.quit();
    }
}
