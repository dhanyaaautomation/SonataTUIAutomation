package org.sonatatui.drivers;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface IDriver {

    //interface gives you skeleton.
    public WebDriver getDriver() throws MalformedURLException;
}
