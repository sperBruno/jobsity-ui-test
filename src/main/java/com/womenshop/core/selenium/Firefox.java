package com.womenshop.core.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements IDriver {
    private static final String FIREFOX_DRIVER = "webdriver.gecko.driver";
    private static final String DRIVER_PATH = "drivers/geckodriver.exe";

    @Override
    public WebDriver initWebDriver() {
        System.setProperty(FIREFOX_DRIVER, DRIVER_PATH);
        return new FirefoxDriver();
    }
}
