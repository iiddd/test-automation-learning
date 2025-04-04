package org.example.tests.puppy.base;

import org.example.core.DriverHolder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseWebTest {

    @BeforeEach
    public void setup() {
        DriverHolder.initDriver();
    }

    @AfterEach
    public void tearDown() {
        DriverHolder.killDriver();
    }
}
