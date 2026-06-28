package org.sonatatui.drivers;

import org.openqa.selenium.WebDriver;
import org.sonatatui.enums.Modes;
import org.sonatatui.utils.PropertyUtils;

import java.net.MalformedURLException;
import java.util.Objects;

public class Driver {

    private Driver() {
    }

    public static void initDriver() throws MalformedURLException {

        if (Objects.isNull(DriverManager.getDriver())) {

            String modeValue = PropertyUtils.getValue("mode");

            WebDriver driver = DriverFactory.getMode(Modes.valueOf(modeValue.toUpperCase()));
            DriverManager.setDriver(driver);
        }
    }

    public static void quitDriver() {

        if (Objects.nonNull(DriverManager.getDriver())) {

            DriverManager.getDriver().quit();
            // Close the driver and remove the threads
            DriverManager.unLoad();

        }
    }
}
