package org.example.utils;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestStepFinished;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static org.example.core.DriverHolder.getDriver;

public class TestListener implements ConcurrentEventListener {

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestStepFinished.class, this::onStepFinish);
    }

    public void onStepFinish(TestStepFinished event) {
        if (event.getResult().getStatus().name().equals("FAILED")) {
            if (getDriver() != null) {
                byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
                Allure.getLifecycle().addAttachment(
                        "Screenshot on Failure", "image/png", "png", screenshot
                );
            }
        }
    }
}
