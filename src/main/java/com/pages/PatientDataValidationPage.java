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
import org.testng.Assert;

import java.time.Duration;
import java.util.Map;


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
    public void verifyData(Map<String, String> credentials) {
        String expectedFirstName = credentials.get("FirstName");
        String expectedLastName = credentials.get("LastName");
        String expectedHosp30d = credentials.get("Hosp 30d");
        String expectedDOB = credentials.get("DOB");
        String expectedSex = credentials.get("Sex");
        String expectedAge = credentials.get("Age");
        String expectedPtLang = credentials.get("Pt. Lang.");
        String expectedInsurance = credentials.get("Insurance #");
        String expectedInsuranceCo = credentials.get("Insurance Co.");

        // Fetching actual data from the UI fields
        String actualFirstName = getFirstName();
        String actualLastName = getLastName();
        String actualHosp30d = getHosp30d();
        String actualDOB = getDOB();
        String actualSex = getSex();
        String actualAge = getAge();
        String actualPtLang = getPtLang();
        String actualInsurance = getInsurance();
        String actualInsuranceCo = getInsuranceCo();

        if (expectedFirstName != null && !expectedFirstName.isEmpty()) {
            Assert.assertEquals(actualFirstName, expectedFirstName, "First Name doesn't match");
        } else {
            System.out.println("Skipping validation for First Name as the expected value is null or empty.");
        }

        if (expectedLastName != null && !expectedLastName.isEmpty()) {
            Assert.assertEquals(actualLastName, expectedLastName, "Last Name doesn't match");
        } else {
            System.out.println("Skipping validation for Last Name as the expected value is null or empty.");
        }
        if (actualHosp30d != null && !actualHosp30d.isEmpty()) {
            Assert.assertEquals(actualHosp30d, expectedHosp30d, "Hospital 30d doesn't match");
        } else {
            System.out.println("Skipping validation for Hospital 30d as the expected value is null or empty.");
        }
        if (actualDOB != null && !actualDOB.isEmpty()) {
            Assert.assertEquals(actualDOB, expectedDOB, "DOB doesn't match");
        } else {
            System.out.println("Skipping validation for DOB as the expected value is null or empty.");
        }

        if (expectedSex != null && !expectedSex.isEmpty()) {
            Assert.assertEquals(actualSex, expectedSex, "Sex doesn't match");
        } else {
            System.out.println("Skipping validation for Sex as the expected value is null or empty.");
        }

        if (expectedAge != null && !expectedAge.isEmpty()) {
            Assert.assertEquals(actualAge, expectedAge, "Age doesn't match");
        } else {
            System.out.println("Skipping validation for Age as the expected value is null or empty.");
        }
        if (actualPtLang != null && !actualPtLang.isEmpty()) {
            Assert.assertEquals(actualPtLang, expectedPtLang, "PtLang doesn't match");
        } else {
            System.out.println("Skipping validation for expectedPtLang as the expected value is null or empty.");
        }
        if (actualInsurance != null && !actualInsurance.isEmpty()) {
            Assert.assertEquals(actualInsurance, expectedInsurance, "Insurance Number doesn't match");
        } else {
            System.out.println("Skipping validation for Insurance Number as the expected value is null or empty.");
        }
        if (actualInsuranceCo != null && !actualInsuranceCo.isEmpty()) {
            Assert.assertEquals(actualInsuranceCo, expectedInsuranceCo, "Insurance Company doesn't match");
        } else {
            System.out.println("Skipping validation for Insurance Co as the expected value is null or empty.");
        }

    }

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
