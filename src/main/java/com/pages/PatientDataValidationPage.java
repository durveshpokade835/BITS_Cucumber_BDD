package com.pages;

import com.qa.Factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PatientDataValidationPage {
    private WebDriver driver;
    private static WebDriverWait wait;
    private JavascriptExecutor js;

    // Locators
    private By nameButton = By.xpath("//div[@class='src-routes-PharmacistPortal-LandingPage-components-TabsGlobal-Patients-__patientName___3tbx5 src-routes-PharmacistPortal-LandingPage-components-TabsGlobal-Patients-__trimtext___1PFDy']");
    private By PatientDataValidationTableLocator = By.xpath("//div[@class='src-routes-PharmacistPortal-LandingPage-components-units-PatientInput-__container___3AgPD']");

    // Locators for input fields
    private By firstNameLocator = By.xpath("//label[text()='First Name']/following-sibling::input");
    private By lastNameLocator = By.xpath("//label[text()='Last Name']/following-sibling::input");
    private By hosp30dLocator = By.xpath("//label[text()='Hosp 30d']/following-sibling::input");
    private By dobLocator = By.xpath("//label[text()='DOB']/following-sibling::div/div/div/input");
    private By sexLocator = By.xpath("//label[text()='Sex']/following-sibling::input");
    private By ageLocator = By.xpath("//label[text()='Age']/following-sibling::input");
    private By ptLangLocator = By.xpath("//label[text()='Pt. Lang.']/following-sibling::span");
    private By insuranceLocator = By.xpath("//label[text()='Insurance #']/following-sibling::span");
    private By insuranceCoLocator = By.xpath("//label[text()='Insurance Co.']/following-sibling::span");


    //constructor
    public PatientDataValidationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    private PatientReportPage patientReportPage = new PatientReportPage(DriverFactory.getDriver());

    //WebElement
//    WebElement PatientDataValidationTableEle = tdriver.findElement(PatientDataValidationTableLocator);

    @FindBy(xpath = "//div[@class='src-routes-PharmacistPortal-LandingPage-components-units-PatientInput-__container___3AgPD']")
    private WebElement PatientDataValidationTableEle;

    //Page Actions
    public void clickNameButton() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(patientReportPage.loader));
        wait.until(ExpectedConditions.elementToBeClickable(nameButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(PatientDataValidationTableLocator));
        js.executeScript("arguments[0].scrollIntoView(true);", PatientDataValidationTableEle);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PatientDataValidationTableLocator));
    }

//    public void verifyData(String firstName, String lastName, String sex, String age) {
//
//
//    }

    public String getFirstName() {
        return driver.findElement(firstNameLocator).getAttribute("value");
    }

    public String getLastName() {
        return driver.findElement(lastNameLocator).getAttribute("value");
    }

    public String getHosp30d() {
        return driver.findElement(hosp30dLocator).getAttribute("value");
    }

    public String getDOB() {
        return driver.findElement(dobLocator).getAttribute("value");
    }

    public String getSex() {
        return driver.findElement(sexLocator).getAttribute("value");
    }

    public String getAge() {
        return driver.findElement(ageLocator).getAttribute("value");
    }

    public String getPtLang() {
        return driver.findElement(ptLangLocator).getAttribute("value");
    }

    public String getInsurance() {
        return driver.findElement(insuranceLocator).getAttribute("value");
    }

    public String getInsuranceCo() {
        return driver.findElement(insuranceCoLocator).getAttribute("value");
    }
}
