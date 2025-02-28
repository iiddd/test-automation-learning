package org.example.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.example.core.DriverHolder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class Hooks {

    @Before
    public void beforeEach() {
        Allure.getLifecycle().updateFixture(hook -> hook.setName("Setup: Open Web Browser"));
        DriverHolder.initDriver();
    }

    @After
    public void afterEach(Scenario scenario) {
        Allure.getLifecycle().updateFixture(hook -> hook.setName("Tear down: Close Web Browser"));
        if (scenario.isFailed()) {
            // Capture screenshot
            byte[] screenshot = ((TakesScreenshot) DriverHolder.getDriver()).getScreenshotAs(OutputType.BYTES);

            // Attach screenshot to Allure report
            Allure.addAttachment("Failure Screenshot", "image/png", new ByteArrayInputStream(screenshot), "png");

            System.out.println("Screenshot taken for failed step: " + scenario.getName());
        }
        DriverHolder.killDriver();
    }
}
