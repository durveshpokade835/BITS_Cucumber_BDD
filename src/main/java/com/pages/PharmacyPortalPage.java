package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PharmacyPortalPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    // By Locators
    private By patientButton = By.xpath("//button[text()='Patient']");
    private By advancedButton = By.xpath("//span[text()='ADVANCED']");
    private By firstNameInput = By.xpath("//input[@name='firstname']");
    private By lastNameInput = By.xpath("//input[@name='lastname']");
    private By cityInput = By.xpath("//input[@name='city']");
    private By stateInput = By.xpath("//input[@name='state']");
    public By zipCodeInput = By.xpath("//input[@name='zip_code']");
    public By phoneNumberInput =By.xpath("//input[@name='phone']");
    public By birthDateInput = By.xpath("//input[@name='dob']");
    private By hpIdInput = By.xpath("//input[@name='hpid']");

    private By searchButton = By.cssSelector("button[aria-label='search button']");

    private By advancedPopup = By.xpath("//div[contains(@class,'src-routes-PharmacistPortal-LandingPage-components-units-SearchPatient-__popUp___1ABAd')]");
    private By errorPopup = By.id("swal2-content");

    private By resultString = By.xpath("//div[contains(@class,'src-routes-PharmacistPortal-LandingPage-components-units-SearchPatient-__popUp___1ABAd')]/div/h3");
    private By resultTable = By.xpath("//div[@class='src-routes-PharmacistPortal-LandingPage-components-units-SearchPatient-__drugSelectContainer___2eR2Q']/table") ;
    private By acceptAgreementButton= By.xpath("//button[@class='swal2-confirm swal2-styled']");
    private By acceptAgreementPopUp = By.xpath("//div[@class='swal2-popup swal2-modal animated fadeInDown']");
    private By validationLocator = By.xpath("//div[@class='mantine-1c45i6c']/table");


    // Constructor
    public PharmacyPortalPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js  = (JavascriptExecutor) driver;
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

    public void clickAcceptAgreementButton(){
        js.executeScript("arguments[0].scrollIntoView(true);", acceptAgreementButton);
        wait.until(ExpectedConditions.elementToBeClickable(acceptAgreementButton));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(acceptAgreementButton)).click();
        }catch (org.openqa.selenium.ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", acceptAgreementButton);
        }
    }
    public boolean isLoginUserAgreementPopUpVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(acceptAgreementPopUp)).isDisplayed();
    }

    public boolean isTableVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(validationLocator)).isDisplayed();
    }

    public boolean isAdvancedSearchResultTableVisible(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resultTable)).isDisplayed();
    }

    public String getResultMessage(){
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(resultString));
        return result.getText();
    }

    public void selectState(String state){

        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(stateInput));

//	    	WebElement emailElement = driver.findElement(emailId);
        emailElement.clear();
        emailElement.sendKeys(state);

    }
    public void enterZipCode(String zipCode){
        WebElement zipCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(zipCodeInput));
        zipCodeField.clear();
        zipCodeField.sendKeys(zipCode);

    }

    public void enterPhoneNumber(String phone){
        WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberInput));
        phoneNumberField.clear();
        phoneNumberField.sendKeys(phone);

    }
    public void enterBirthDate(String birthDate){
        WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(birthDateInput));
        phoneNumberField.clear();
        phoneNumberField.sendKeys(birthDate);

    }
    public void enterHpId(String hpId){
        WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(hpIdInput));
        phoneNumberField.clear();
        phoneNumberField.sendKeys(hpId);

    }
    public String getTooltipErrorMessage(By fieldLocator) {
        WebElement field = driver.findElement(fieldLocator);

        field.sendKeys(Keys.TAB);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", field);
    }



}
