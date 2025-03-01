package org.example.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;
import org.example.core.DriverHolder;

public class Hooks {

    @Before
    public void beforeEach() {
        Allure.getLifecycle().updateFixture(hook -> hook.setName("Setup: Open Web Browser"));
        DriverHolder.initDriver();
    }

    @After
    public void afterEach() {
        Allure.getLifecycle().updateFixture(hook -> hook.setName("Tear down: Close Web Browser"));
        DriverHolder.killDriver();
    }
}
