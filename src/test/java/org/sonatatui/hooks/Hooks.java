package org.sonatatui.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.sonatatui.drivers.Driver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

public class Hooks {

    @Before
    public void setUp() throws MalformedURLException {

        Driver.initDriver();

    }

    @After
    public void tearDown() {

        Driver.quitDriver();
    }
}
