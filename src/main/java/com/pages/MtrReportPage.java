//package com.pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class MtrReportPage {
//    private WebDriver driver;
//    private static WebDriverWait wait;
//
//
//
//    // By Locators
//    private By patientIdInput = By.id("mantine-jreetfphx");
//    private By searchPatientButton =By.id("searchPatient");
//    private By reportsTab = By.xpath("//div[contains(@class,\"src-routes-PharmacistPortal-LandingPage-components-TabsGlobal-Patients-__defaultButton___Jg2w6\")][7]");
//    private By mtmReportsTab = By.xpath("//button[@data-tip='Reports for MTM']");
//    private By cmrReviewType = By.id("#interactionReviewType_CMR");
//    private By dateSelector = By.xpath("//input[@name='conversationDate']");
//    private By setConversationDate = By.xpath("//button[@class='src-routes-PharmacistPortal-LandingPage-components-composites-ViewLetter-__buttonConversation___1tdUr']");
//    private static By popUpMessage = By.id("swal2-content");
//    private By patientButton = By.xpath("//button[text()='Patient']");
//    private By patientTableValidation = By.xpath("//div[@class='src-routes-PharmacistPortal-LandingPage-components-TabsGlobal-Patients-__userContainer___3H1nx']");
//
//
//    //WebElements
//
//
//    //Strings
//    String attributeContains = "activeButton___-h8_T src-routes-PharmacistPortal-LandingPage-components-MenuBar";
//
//    // Constructor
//    public MtrReportPage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    }
//
//    //Page Actions
//    WebElement patientTabEle = driver.findElement(patientButton);
//    public void enterPatientId(String pId){
//        WebElement patientIdField = wait.until(ExpectedConditions.visibilityOfElementLocated(patientIdInput));
//        patientIdField.clear();
//        patientIdField.sendKeys(pId);
//    }
//    public void clickSearchPatientButton(){
//        wait.until(ExpectedConditions.elementToBeClickable(searchPatientButton)).click();
//
//    }
//
//    public void clickReportButton(){
//        wait.until(ExpectedConditions.elementToBeClickable(reportsTab)).click();
//
//    }
//    public void clickMtmReportButton(){
//        wait.until(ExpectedConditions.elementToBeClickable(mtmReportsTab)).click();
//
//    }
//
//    public void selectCmrRadtioInput(){
//        wait.until(ExpectedConditions.elementToBeClickable(cmrReviewType)).click();
//
//    }
//
//    public void clickSetConversationDateButton(){
//        wait.until(ExpectedConditions.elementToBeClickable(setConversationDate)).click();
//
//    }
//    public static boolean isValidationPopupDisplayed(String errorMessage) {
//        WebElement validationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(popUpMessage));
//        return validationElement.getText().contains(errorMessage);
//
//    }
//
//
//    public boolean isPatientTabSelected() {
////return wait.until(ExpectedConditions.attributeContains())
//        return wait.until(ExpectedConditions.attributeContains(patientTabEle,"class",attributeContains));
//    }
//
//
//    public boolean isPatientTableVisible() {
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(patientTableValidation)).isDisplayed();
//    }
//    public void clickPatientButton(){
//        wait.until(ExpectedConditions.elementToBeClickable(patientButton)).click();
//    }
//}
