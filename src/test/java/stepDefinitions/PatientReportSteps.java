package stepDefinitions;

import com.pages.PatientReportPage;

import com.pages.LoginPage;
import com.pages.PharmacyPortalPage;
import com.qa.Factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PatientReportSteps {

    private PharmacyPortalPage pharmacyPortalPage = new PharmacyPortalPage(DriverFactory.getDriver());
    private PatientReportPage patientReportPage = new PatientReportPage(DriverFactory.getDriver());

    //-----------------------------------------------------------------------------------------
    @When("^User clicks on the Patient button for patient search$")
    public void user_clicks_on_patient_button() {
        try {
            pharmacyPortalPage.clickPatientButton();
        } catch (Exception e) {
            throw e;
        }
    }

    @When("^User enters the patient ID \"([^\"]*)\"$")
    public void user_enters_the_patient_id(String patientId) {
        try {
            patientReportPage.enterPatientID(patientId);
        } catch (Exception e) {
            throw e;
        }
    }

    @And("User clicks Reports button, MTM Reports button and selects CMR review type")
    public void userClicksReportsButtonMTMReportsButtonAndSelectsCMRReviewType() {
        try {
            patientReportPage.clickReportsButton();
//            patientReportPage.clickMTMReportButton();
//            patientReportPage.selectsCMRButton();
        } catch (Exception e) {
            throw e;
        }
    }

    @And("User selects the date {int} days back")
    public void userSelectsTheDateDaysBack(int n) {
        try {
            patientReportPage.selectDateNDaysBack(n);
        } catch (Exception e) {
            throw e;
        }
    }

    @Then("User clicks on the Date Conversation button")
    public void user_clicks_on_the_date_conversation_button() {
        try {
            patientReportPage.clickSetReviewButton();
        } catch (Exception e) {
            throw e;
        }
    }

    //------------------------------------------------------------------------

}
