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

            // Get the mode value from property file
            String modevalue = PropertyUtils.getValue("mode");

            /*Modes is an Enum which contains the variables like Local and BS
            Mode value is given in upper case in Enum file.
            Hence, convert the mode value to upper case.*/

            WebDriver driver = DriverFactory.getMode(Modes.valueOf(modevalue.toUpperCase()));
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
