package com.juaracoding;

import com.juaracoding.drivers.WebDriverSingleton;
import com.juaracoding.pages.MenuPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MenuTest {

    private WebDriver driver;
    private MenuPage menuPage;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        WebDriverSingleton.setBrowser(browser);
        driver = WebDriverSingleton.getDriver();
        driver.manage().window().maximize();
        menuPage = new MenuPage(driver);
        menuPage.open();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }

    @Test(description = "Test hovering over menu items and clicking on Sub Sub Item 2")
    public void testMenuHoverAndAction() {
        menuPage.hoverMainItem3();
        menuPage.hoverSubSubList();
        Assert.assertTrue(menuPage.isSubSubItem2Visible(), "Sub Sub Item 2 should be visible after hover interactions");

        menuPage.clickSubSubItem2();
        Assert.assertTrue(menuPage.isSubSubItem2Visible(), "Sub Sub Item 2 should remain visible even after click.");
    }
}