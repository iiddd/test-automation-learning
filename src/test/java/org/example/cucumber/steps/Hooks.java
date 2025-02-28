package org.example.cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.core.DriverHolder;

public class Hooks {

    @Before
    public void beforeEach() {
        DriverHolder.initDriver();
    }

    @After
    public void afterEach() {
        DriverHolder.killDriver();
    }
}
