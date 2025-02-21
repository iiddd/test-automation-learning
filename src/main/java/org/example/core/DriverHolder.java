package org.example.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverHolder {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static void initDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions()
                .addArguments("--disable-search-engine-choice-screen")
                .addArguments("--lang=en-GB");

        driverThreadLocal.set(new ChromeDriver(options));
        System.out.println("Initialized WebDriver for thread: " + Thread.currentThread().threadId());

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void killDriver() {
        if (getDriver() != null) {
            System.out.println("Closing WebDriver for thread: " + Thread.currentThread().threadId());
            getDriver().quit();
            driverThreadLocal.remove();
        }
    }
}