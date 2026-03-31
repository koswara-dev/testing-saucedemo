package com.juaracoding.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {

    private final WebDriver driver;
    private final Actions actions;

    @FindBy(xpath = "//a[text()='Main Item 3']")
    private WebElement mainItem3;

    @FindBy(xpath = "//a[text()='SUB SUB LIST »']")
    private WebElement subSubList;

    @FindBy(xpath = "//a[text()='Sub Sub Item 2']")
    private WebElement subSubItem2;

    public MenuPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://demoqa.com/menu");
    }

    public void hoverMainItem3() {
        actions.moveToElement(mainItem3).perform();
    }

    public void hoverSubSubList() {
        actions.moveToElement(subSubList).perform();
    }

    public void clickSubSubItem2() {
        actions.moveToElement(subSubItem2).click().perform();
    }

    public boolean isSubSubItem2Visible() {
        return subSubItem2.isDisplayed();
    }
}