package com.juaracoding.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {
        // private constructor to prevent instantiation
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private static WebDriver createDriver() {
        String browser = System.getProperty("browser", "firefox-headless").toLowerCase();

        switch (browser) {
            case "chrome-headless":
                return initChrome(true);
            case "firefox":
                return initFirefox(false);
            case "firefox-headless":
                return initFirefox(true);
            case "chrome":
            default:
                return initChrome(false);
        }
    }

    private static WebDriver initChrome(boolean headless) {
        // If chromedriver not in PATH, set the path here:
        // System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1366,768");
        }
        return new ChromeDriver(options);
    }

    private static WebDriver initFirefox(boolean headless) {
        // If geckodriver not in PATH, set the path here:
        // System.setProperty("webdriver.gecko.driver", "C:\\path\\to\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        if (headless) {
            options.addArguments("-headless");
            options.addPreference("browser.window.width", 1366);
            options.addPreference("browser.window.height", 768);
        }
        return new FirefoxDriver(options);
    }
}
