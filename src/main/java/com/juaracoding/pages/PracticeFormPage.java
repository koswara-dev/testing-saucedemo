package com.juaracoding.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.utils.Utils;

public class PracticeFormPage {

    private final WebDriver driver;
    private final JavascriptExecutor jsExecutor;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement emailField;

    @FindBy(xpath = "//label[contains(@for, 'gender-radio-1')]")
    private WebElement genderMaleRadio;

    @FindBy(xpath = "//input[@id='userNumber']")
    private WebElement mobileField;

    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    private WebElement dateOfBirthField;

    @FindBy(xpath = "//input[@id='subjectsInput']")
    private WebElement subjectsInput;

    @FindBy(xpath = "//label[contains(@for, 'hobbies-checkbox')]")
    private List<WebElement> hobbiesCheckboxes;

    @FindBy(xpath = "//input[@id='uploadPicture']")
    private WebElement pictureField;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    private WebElement currentAddressField;

    @FindBy(xpath = "//div[@id='state']")
    private WebElement stateDropdown;

    @FindBy(xpath = "//div[@id='city']")
    private WebElement cityDropdown;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@id='example-modal-sizes-title-lg']")
    private WebElement modalHeaderElement;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://demoqa.com/automation-practice-form");
    }

    public void fillFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void fillEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void selectGenderMale() {
        genderMaleRadio.click();
    }

    public void fillMobile(String mobile) {
        mobileField.clear();
        mobileField.sendKeys(mobile);
    }

    public void setDateOfBirth(String yearValue, String monthValue, String dayValue) {
        dateOfBirthField.click();

        Select year = new Select(driver.findElement(By.cssSelector(".react-datepicker__year-select")));
        Select month = new Select(driver.findElement(By.cssSelector(".react-datepicker__month-select")));
        year.selectByVisibleText(yearValue);
        month.selectByVisibleText(monthValue);

        WebElement day = driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day') and not(contains(@class,'react-datepicker__day--outside-month')) and text()='" + dayValue + "']"));
        day.click();
    }

    public void addSubjects(String... subjects) {
        for (String subject : subjects) {
            subjectsInput.sendKeys(subject);
            subjectsInput.sendKeys("\n"); // Press Enter to select
        }
    }

    public void selectHobbies(String... hobbies) {
        for (WebElement checkbox : hobbiesCheckboxes) {
            for (String hobby : hobbies) {
                if (checkbox.getText().equals(hobby)) {
                    checkbox.click();
                    break;
                }
            }
        }
    }

    public void uploadPicture(String path) {
        pictureField.sendKeys(path);
    }

    public void fillCurrentAddress(String address) {
        currentAddressField.clear();
        currentAddressField.sendKeys(address);
    }

    public void selectState(String state) {
        stateDropdown.click();
        WebElement stateOption = driver.findElement(By.xpath("//div[contains(@id, 'react-select') and text()='" + state + "']"));
        stateOption.click();
    }

    public void selectCity(String city) {
        cityDropdown.click();
        WebElement cityOption = driver.findElement(By.xpath("//div[contains(@id, 'react-select') and text()='" + city + "']"));
        cityOption.click();
    }

    public void submitForm() {
        submitButton.click();
    }

    public String getModalHeaderText() {
        return modalHeaderElement.getText();
    }

    public void scrollToHobbies() {
        jsExecutor.executeScript("window.scrollBy(0, 500);");
    }

    public void scrollToAddress() {
        jsExecutor.executeScript("window.scrollBy(0, 500);");
    }

    public void waitForModal() {
        Utils.delay(5); // Adjust as needed
    }
}