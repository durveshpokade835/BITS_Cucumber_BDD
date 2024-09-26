package stepDefinitions;



import com.pages.PatientReportPage;
import com.qa.util.ExtentReportUtil;
import io.cucumber.java.en.Given;

import java.time.Duration;

import com.pages.LoginPage;
import com.pages.PharmacyPortalPage;
//import com.pages.MtrReportPage;
import com.qa.Factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
public class PatientReportSteps {
//    WebDriver driver = DriverFactory.getDriver();
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private PharmacyPortalPage pharmacyPortalPage = new PharmacyPortalPage(DriverFactory.getDriver());
    private PatientReportPage patientReportPage = new PatientReportPage(DriverFactory.getDriver());

    @Given("^User is logged in successfully for patient search$")
    public void user_is_logged_in_successfully_for_patient_search() {
        ExtentReportUtil.startTest("Patient Search Test Case");
        try {
            DriverFactory.getDriver().get("https://pharmacist-dev.arine.io/");
            loginPage.enterEmail("hardstop-pharmacist6@mailinator.com");
            loginPage.enterPassword("Password1#");
            loginPage.clickSignIn();
            boolean loginVal = loginPage.isDashboardDisplayed();
            Assert.assertTrue(loginVal, "Login was not successful");
            ExtentReportUtil.logPass("User logged in successfully for patient search.");
        } catch (Exception e) {
            ExtentReportUtil.logFail("Login failed for patient search: " + e.getMessage());
            throw e; // Re-throw exception to fail the test
        }
    }

    @When("^User clicks on the Patient button for patient search$")
    public void user_clicks_on_patient_button() {
        try {
            pharmacyPortalPage.clickPatientButton();  // Reuse the function from DashboardStep
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to click on the Patient button: " + e.getMessage());
            throw e;
        }
    }

    @When("^User enters the patient ID \"([^\"]*)\"$")
    public void user_enters_the_patient_id(String patientId) {
        try {
            patientReportPage.enterPatientID(patientId);
            ExtentReportUtil.logPass("Patient ID entered: " + patientId);
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to enter Patient ID: " + e.getMessage());
            throw e;
        }
    }

    @When("^User clicks on the Reports button$")
    public void user_clicks_on_reports_button() {
        try {
            patientReportPage.clickReportsButton();
            ExtentReportUtil.logPass("Reports button clicked.");
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to click on Reports button: " + e.getMessage());
            throw e;
        }
    }

    @When("^User selects the date 10 days back$")
    public void user_selects_date_10_days_back() {
        try {
            patientReportPage.selectDate10DaysBack();
            ExtentReportUtil.logPass("Date 10 days back selected.");
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to select the date 10 days back: " + e.getMessage());
            throw e;
        }
    }

//    @Then("^User clicks on the Date Conversation button$")
//    public void user_clicks_on_set_review_button() {
//        try {
//            patientReportPage.clickSetReviewButton();
////            ExtentReportUtil.logPass("Date Conversation button clicked.");
//        } catch (Exception e) {
////            ExtentReportUtil.logFail("Failed to click on Date Conversation button: " + e.getMessage());
//            throw e;
//        }
//    }
    @Then("User clicks on the Date Conversation button")
    public void user_clicks_on_the_date_conversation_button() {
        try {
            patientReportPage.clickSetReviewButton();
            ExtentReportUtil.logPass("Date Conversation button clicked.");
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to click on Date Conversation button: " + e.getMessage());
            throw e;
        }
    }

}
