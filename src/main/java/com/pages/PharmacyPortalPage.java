package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
    public By phoneNumberInput = By.xpath("//input[@name='phone']");
    public By birthDateInput = By.xpath("//input[@name='dob']");
    private By hpIdInput = By.xpath("//input[@name='hpid']");

    private By searchButton = By.cssSelector("button[aria-label='search button']");

    private By advancedPopup = By.xpath("//div[contains(@class,'src-routes-PharmacistPortal-LandingPage-components-units-SearchPatient-__popUp___1ABAd')]");
    private By errorPopup = By.id("swal2-content");

    private By resultString = By.xpath("//div[contains(@class,'src-routes-PharmacistPortal-LandingPage-components-units-SearchPatient-__popUp___1ABAd')]/div/h3");
    private By resultTable = By.xpath("//div[@class='src-routes-PharmacistPortal-LandingPage-components-units-SearchPatient-__drugSelectContainer___2eR2Q']/table");
    private By acceptAgreementButton = By.xpath("//button[@class='swal2-confirm swal2-styled']");
    private By acceptAgreementPopUp = By.xpath("//div[@class='swal2-popup swal2-modal animated fadeInDown']");
    private By validationLocator = By.xpath("//div[@class='mantine-1c45i6c']/table");


    // Constructor
    public PharmacyPortalPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    //Page factory
//    @FindBy(xpath = "//input[@name='firstname']")
//    private WebElement firstNameField;
//    @FindBy(xpath = "//input[@name='lastname']")
//    private WebElement lastNameField;
//    @FindBy(xpath = "//input[@name='city']")
//    private WebElement cityField;
//    @FindBy(xpath = "//input[@name='state']")
//    private WebElement stateElement;
//    @FindBy(xpath = "//input[@name='zip_code']")
//    private WebElement zipCodeField;
//    @FindBy(xpath = "//input[@name='phone']")
//    private WebElement phoneNumberField;
//    @FindBy(xpath = "//input[@name='dob']")
//    private WebElement bithDayField;
//    @FindBy(xpath = "//input[@name='hpid']")
//    private WebElement hpIDField;


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
        if (firstName != null && !firstName.equalsIgnoreCase("[empty]")) {
            firstNameField.sendKeys(firstName);
        }
    }

    public void enterLastName(String lastName) {
        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput));
        lastNameField.clear();
        if (lastName != null && !lastName.equalsIgnoreCase("[empty]")) {
            lastNameField.sendKeys(lastName);
        }
    }

    public void enterCity(String city) {
        WebElement cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(cityInput));
        cityField.clear();
        if (city != null && !city.equalsIgnoreCase("[empty]")) {
            cityField.sendKeys(city);
        }
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }

    public boolean isErrorPopupDisplayed(String errorMessage) {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorPopup));
        return errorElement.getText().contains(errorMessage);
    }

    public void clickAcceptAgreementButton() {
        js.executeScript("arguments[0].scrollIntoView(true);", acceptAgreementButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(acceptAgreementButton));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(acceptAgreementButton)).click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            js.executeScript("arguments[0].click();", acceptAgreementButton);
        }
    }

    public boolean isLoginUserAgreementPopUpVisible() {
        return driver.findElement(acceptAgreementPopUp).isDisplayed();
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(acceptAgreementPopUp)).isDisplayed();
    }

    public boolean isTableVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(validationLocator)).isDisplayed();
    }

    public boolean isAdvancedSearchResultTableVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resultTable)).isDisplayed();
    }

    public String getResultMessage() {
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(resultString));
        return result.getText();
    }

    public void selectState(String state) {

        WebElement stateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(stateInput));

//	    	WebElement emailElement = driver.findElement(emailId);
        stateElement.clear();
        if (state != null && !state.equalsIgnoreCase("[empty]")) {
            stateElement.sendKeys(state);
        }

    }

    public void enterZipCode(String zipCode) {
        WebElement zipCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(zipCodeInput));
        zipCodeField.clear();
        System.out.println(zipCode);
        if (zipCode != null && !zipCode.equalsIgnoreCase("[empty]")) {
            zipCodeField.sendKeys(zipCode);
        }

    }

    public void enterPhoneNumber(String phone) {
        WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberInput));
        phoneNumberField.clear();
        if (phone != null && !phone.equalsIgnoreCase("[empty]")) {
            phoneNumberField.sendKeys(phone);
        }
    }

    public void enterBirthDate(String birthDate) {
        WebElement bithDayField = wait.until(ExpectedConditions.visibilityOfElementLocated(birthDateInput));
        bithDayField.clear();
        if (birthDate != null && !birthDate.equalsIgnoreCase("[empty]")) {
            bithDayField.sendKeys(birthDate);
        }

    }

    public void enterHpId(String hpId) {
        WebElement hpIDField = wait.until(ExpectedConditions.visibilityOfElementLocated(hpIdInput));
        if (hpIDField.isEnabled()) {
            hpIDField.clear();
            if (hpId != null && !hpId.equalsIgnoreCase("[empty]")) {
                hpIDField.sendKeys(hpId);
            }
        }
        System.out.println("HPID field is disabled or not interactable");

    }

    public String getTooltipErrorMessage(By fieldLocator) {
        WebElement field = driver.findElement(fieldLocator);

        field.sendKeys(Keys.TAB);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", field);
    }

    public void verifyFields(List<List<String>> credentials) {
        for (int i = 0; i < credentials.size(); i++) {
            String field = credentials.get(i).get(0);
            String actualResult;
            if (Objects.equals(field, "First Name")) {
                enterFirstName(credentials.get(i).get(1));
                System.out.println(credentials.get(i).get(1));
            }
            if (Objects.equals(field, "Last Name")) {
                enterLastName(credentials.get(i).get(1));
                System.out.println(credentials.get(i).get(1));
            }
            if (Objects.equals(field, "City")) {
                enterCity(credentials.get(i).get(1));
                System.out.println(credentials.get(i).get(1));
            }
            if (Objects.equals(field, "State")) {
                selectState(credentials.get(i).get(1));
                System.out.println(credentials.get(i).get(1));
            }
            if (Objects.equals(field, "Zip Code")) {
                enterZipCode(credentials.get(i).get(1));
                System.out.println(credentials.get(i).get(1));
            }
            if (Objects.equals(field, "Phone")) {
                enterPhoneNumber(credentials.get(i).get(1));
                System.out.println(credentials.get(i).get(1));
            }
            if (Objects.equals(field, "Birth Date")) {
                enterBirthDate(credentials.get(i).get(1));
                System.out.println(credentials.get(i).get(1));
            }
            if (Objects.equals(field, "HPID")) {
                enterHpId(credentials.get(i).get(1));
                System.out.println(credentials.get(i).get(1));
            }


//            switch (field) {
//
//                case "First Name":
//                    enterFirstName(credentials.get(i).get(1));
////                    clickSearchButton();
////                    isAdvancedSearchResultTableVisible();
////                    actualResult = getResultMessage();
////                    org.junit.Assert.assertTrue(actualResult.contains(credentials.get(i).get(1)));
//
//                    System.out.println(credentials.get(i).get(1));
//                    break;
//                case "Last Name":
//                    enterLastName(credentials.get(i).get(1));
////                    clickSearchButton();
////                    isAdvancedSearchResultTableVisible();
////                    actualResult = getResultMessage();
////                    org.junit.Assert.assertTrue(actualResult.contains(credentials.get(i).get(1)));
//                    System.out.println(credentials.get(i).get(1));
//                    break;
//                case "City":
//                    enterCity(credentials.get(i).get(1));
////                    clickSearchButton();
////                    isAdvancedSearchResultTableVisible();
////                    actualResult = getResultMessage();
////                    org.junit.Assert.assertTrue(actualResult.contains(credentials.get(i).get(1)));
//                    System.out.println(credentials.get(i).get(1));
//                    break;
//                case "State":
//                    selectState(credentials.get(i).get(1));
//                    System.out.println(credentials.get(i).get(1));
//                    break;
//                case "Zip Code":
//                    enterZipCode(credentials.get(i).get(1));
//                    System.out.println(credentials.get(i).get(1));
//                    break;
//                case "Phone":
//                    enterPhoneNumber(credentials.get(i).get(1));
//                    System.out.println(credentials.get(i).get(1));
//                    break;
//                case "Birth Date":
//                    enterBirthDate(credentials.get(i).get(1));
//                    System.out.println(credentials.get(i).get(1));
//                    break;
//                case "HPID":
//                    enterHpId(credentials.get(i).get(1));
//                    System.out.println(credentials.get(i).get(1));
//                    break;
//                default:
//                    System.out.println("Enter Valid Key");
//            }

        }
    }

    public void firstNameFields() {
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput));
        firstNameField.clear();
    }

    public void lastNameFields() {
        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput));
        lastNameField.clear();
    }

    public void cityFields() {
        WebElement cityField = wait.until(ExpectedConditions.visibilityOfElementLocated(cityInput));
        cityField.clear();
    }


}
