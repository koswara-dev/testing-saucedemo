package com.juaracoding;

import com.juaracoding.drivers.WebDriverSingleton;
import com.juaracoding.pages.PracticeFormPage;
import com.juaracoding.utils.Utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PracticeFormTest {

    private WebDriver driver;
    private PracticeFormPage practiceFormPage;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        WebDriverSingleton.setBrowser(browser);
        driver = WebDriverSingleton.getDriver();
        driver.manage().window().maximize();
        practiceFormPage = new PracticeFormPage(driver);
        practiceFormPage.open();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }

    // Add your test methods here use xpath
    @Test
    public void testPracticeForm() {
        System.out.println("Testing practice form submission with valid data");
        practiceFormPage.fillFirstName("John");
        practiceFormPage.fillLastName("Doe");
        practiceFormPage.fillEmail("john.doe@example.com");
        practiceFormPage.selectGenderMale();
        practiceFormPage.fillMobile("1234567890");
        practiceFormPage.setDateOfBirth("1999", "January", "1");
        Utils.delay(1); // quick pause untuk stabilitas
        practiceFormPage.scrollToHobbies();
        practiceFormPage.addSubjects("Maths", "Physics");
        practiceFormPage.selectHobbies("Sports", "Music");
        practiceFormPage.uploadPicture("C:\\Users\\Lenovo\\Downloads\\silabus-sqa.jpeg"); // Update with the actual path to your picture
        practiceFormPage.scrollToAddress();
        practiceFormPage.fillCurrentAddress("123 Main St, Anytown, USA");
        practiceFormPage.selectState("NCR");
        practiceFormPage.selectCity("Delhi");
        practiceFormPage.submitForm();
        practiceFormPage.waitForModal();
        String modalHeader = practiceFormPage.getModalHeaderText();
        Assert.assertEquals(modalHeader, "Thanks for submitting the form", "Modal header should match expected text");
    }
}
