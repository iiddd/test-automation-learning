package org.example.puppy.base;

import org.example.core.DriverHolder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    public void setup() {
        DriverHolder.initDriver();
    }

    @AfterEach
    public void tearDown() {
        DriverHolder.killDriver();
    }
}
