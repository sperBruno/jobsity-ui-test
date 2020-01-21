package com.womenshop.core.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements IDriver {
    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String DRIVER_PATH = "drivers/chromedriver.exe";

    @Override
    public WebDriver initWebDriver() {
        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        return new ChromeDriver();
    }
}
