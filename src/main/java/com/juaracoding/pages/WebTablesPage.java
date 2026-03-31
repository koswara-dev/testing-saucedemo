package com.juaracoding.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablesPage {

    private final WebDriver driver;

    // btn Add
    @FindBy(xpath = "//button[@id='addNewRecordButton']")
    private WebElement addRecordButton;

    // Registration Form
    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='age']")
    private WebElement ageInput;

    @FindBy(xpath = "//input[@id='salary']")
    private WebElement salaryInput;

    @FindBy(xpath = "//input[@id='department']")
    private WebElement departmentInput;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitButton;

    // Validation first name
    @FindBy(xpath = "//div[@class='rt-tbody']//div[@class='rt-tr-group'][1]//div[@class='rt-td'][1]")
    private WebElement firstNameCell;

    // Validation negative test validated .form-control:invalid:focus
    @FindBy(xpath = "//input[@id='firstName' and @class='form-control:invalid:focus']")
    private WebElement firstNameInvalid;

    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://demoqa.com/webtables");
    }

    public void addNewRecord(String firstName, String lastName, String email, String age, String salary, String department) {
        addRecordButton.click();
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        ageInput.sendKeys(age);
        salaryInput.sendKeys(salary);
        departmentInput.sendKeys(department);
        submitButton.click();
    }

    // Validasi data yang ditambahkan dengan mengambil teks dari sel pertama (first name) di tabel
    public String getFirstNameFromTable() {
        return firstNameCell.getText();
    }

    // firstNameInvalid
    public boolean isFirstNameInvalid() {
        return firstNameInvalid.isDisplayed();
    }

}
