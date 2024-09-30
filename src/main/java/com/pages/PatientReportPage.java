package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PatientReportPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By patientIdInput = By.xpath("//input[@type='search']");
    private By reportsButton = By.xpath("//div[contains(text(),'Reports')]");
    private By mtmReportsButton = By.xpath("//button[@data-tip='Reports for MTM']");
    private By tmrRadioButton = By.xpath("//input[@id='interactionReviewType_TMR' and @name='reportType' and @value='tmr']");
    private By calendarInput = By.xpath("//input[@name='conversationDate']");
    // Updated locator for Set Review Button
    private By setReviewButton = By.xpath("//button[contains(@class, 'src-routes-PharmacistPortal-LandingPage-components-composites-ViewLetter-__buttonConversation___1tdUr')]");
    public By loader = By.xpath("//div[@class='src-components-Loading-__code___py_kc']");
    //    private By nextYearLocator = By.xpath(null);
//    private By prevYearLocator = By.xpath(null);
    private By nextMonthLocator = By.xpath("//button[contains(@class,'react-datepicker__navigation--next')]");
    private By prevMonthLocator = By.xpath("//button[contains(@class,'react-datepicker__navigation--previous')]");


    //constructor
    public PatientReportPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    //Page Actions
    public void enterPatientID(String patientId) {
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(patientIdInput));
        input.clear();
        input.sendKeys(patientId);
    }

    public void clickReportsButton() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
        wait.until(ExpectedConditions.elementToBeClickable(reportsButton)).click();
    }

//    public void selectDate10DaysBack() {
//        // Get current date and calculate 10 days back
//        LocalDate currentDate = LocalDate.now();
//        LocalDate tenDaysBack = currentDate.minusDays(10);
//        String dateToSelect = tenDaysBack.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//
//        // Open calendar and set the date
//        WebElement calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(calendarInput));
//        calendar.clear();
//        calendar.sendKeys(dateToSelect);
//
//        // Select the date from calendar (ensure the date button is selectable after input)
//        By dateLocator = By.xpath("//div[@aria-label='day-" + tenDaysBack.getDayOfMonth() + "']");
//        wait.until(ExpectedConditions.elementToBeClickable(dateLocator)).click();
//    }

    public void selectDate10DaysBack() {
        // Get current date and calculate 10 days back
        LocalDate currentDate = LocalDate.now();
        LocalDate tenDaysBack = currentDate.minusDays(10);

        // Open the calendar popup
        WebElement calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(calendarInput));
        calendar.click();

        // Navigate to the correct month and year if needed
        int monthDifference = tenDaysBack.getMonthValue() - currentDate.getMonthValue();
        int yearDifference = tenDaysBack.getYear() - currentDate.getYear();

        // Adjust calendar navigation for year difference
//        while (yearDifference != 0) {
//            if (yearDifference > 0) {
//                WebElement nextYearButton = wait.until(ExpectedConditions.elementToBeClickable(nextYearLocator));
//                nextYearButton.click();
//                yearDifference--;
//            } else {
//                WebElement prevYearButton = wait.until(ExpectedConditions.elementToBeClickable(prevYearLocator));
//                prevYearButton.click();
//                yearDifference++;
//            }
//        }

        // Adjust calendar navigation for month difference
        while (monthDifference != 0) {
            if (monthDifference > 0) {
                WebElement nextMonthButton = wait.until(ExpectedConditions.elementToBeClickable(nextMonthLocator));
                nextMonthButton.click();
                monthDifference--;
            } else {
                WebElement prevMonthButton = wait.until(ExpectedConditions.elementToBeClickable(prevMonthLocator));
                prevMonthButton.click();
                monthDifference++;
            }
        }

        // Select the date (day) from the calendar
        By dateLocator = By.xpath("//div[@aria-label='day-" + tenDaysBack.getDayOfMonth() + "']");
        wait.until(ExpectedConditions.elementToBeClickable(dateLocator)).click();
    }


    public void clickSetReviewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(setReviewButton)).click();
    }

}
