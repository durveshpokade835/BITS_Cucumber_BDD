package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PharmacyPortalPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // By Locators
    private By patientButton = By.xpath("//button[text()='Patient']"); // Replace with actual ID
    private By advancedButton = By.xpath("//span[text()='ADVANCED']");
    private By firstNameInput = By.xpath("//input[@name='firstname']"); // Replace with actual ID
    private By lastNameInput = By.xpath("//input[@name='lastname']"); // Replace with actual ID
    private By cityInput = By.xpath("//input[@name='city']"); // Replace with actual ID
    private By searchButton = By.xpath("//button[@aria-label='search button']"); // Replace with actual ID
    private By advancedPopup = By.xpath("//div[contains(@class,'src-routes-PharmacistPortal-LandingPage-components-units-SearchPatient-__popUp___1ABAd')]"); // Replace with actual ID
    private By errorPopup = By.id("swal2-content"); // Replace with actual ID

    // Constructor
    public PharmacyPortalPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Page Actions
    public void clickPatientButton() {
        wait.until(ExpectedConditions.elementToBeClickable(patientButton)).click();
    }

    public void clickAdvancedButton() {
        wait.until(ExpectedConditions.elementToBeClickable(advancedButton)).click();
    }

    public boolean isAdvancedSearchPopupDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(advancedPopup)).isDisplayed();
    }

    public void enterFirstName(String firstName) {
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput));
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput));
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void enterCity(String city) {
        WebElement cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(cityInput));
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public boolean isErrorPopupDisplayed(String errorMessage) {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorPopup));
        return errorElement.getText().contains(errorMessage);
    }

    // Add more methods if needed for validations, other actions, etc.
}
