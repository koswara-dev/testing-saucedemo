package com.juaracoding;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.drivers.WebDriverSingleton;
import com.juaracoding.pages.WebTablesPage;

public class WebTablesTest {

    private WebDriver driver;
    private WebTablesPage webTablesPage;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
        driver.manage().window().maximize();
        webTablesPage = new WebTablesPage(driver);
        webTablesPage.open();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }

    @Test(description = "Test adding a new record to the web tables and verifying it appears in the table")
    public void testWebTables() {
        System.out.println("Testing web tables functionality");
        webTablesPage.addNewRecord("John", "Doe", "john.doe@example.com", "30", "50000", "QA");
        String firstName = webTablesPage.getFirstNameFromTable();
        Assert.assertEquals(firstName, "John", "First name in the table should match the input value");
    }

    // negative test case for validating required fields
    @Test(description = "Test adding a new record with missing first name and verifying that the input is marked as invalid")
    public void testWebTablesNegativeIsFirstNameInvalid() {
        System.out.println("Testing web tables functionality with missing required fields");
        webTablesPage.addNewRecord("", "Doe", "john.doe@example.com", "30", "50000", "QA");
        Assert.assertTrue(webTablesPage.isFirstNameInvalid(), "First name input should be marked as invalid when left empty");
    }
}
