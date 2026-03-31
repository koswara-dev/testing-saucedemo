package com.juaracoding;

import com.juaracoding.drivers.WebDriverSingleton;
import com.juaracoding.pages.LoginPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * TestNG test for SauceDemo login functionality using Selenium.
 */
public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        WebDriverSingleton.setBrowser(browser);
        driver = WebDriverSingleton.getDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }

    @Test
    public void testLoginPositive() {
        System.out.println("Testing valid login with standard_user");
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(loginPage.isLoggedIn(), "Login should redirect to inventory page");
    }

    @Test
    public void testLoginNegative() {
        System.out.println("Testing invalid login with wrong credentials");
        loginPage.login("invalid_user", "wrong_password");
        Assert.assertTrue(loginPage.isErrorVisible(), "Error message should be displayed for invalid login");
        Assert.assertTrue(loginPage.getErrorText().contains("Username and password do not match"), "Error message should indicate invalid credentials");
    }
}
