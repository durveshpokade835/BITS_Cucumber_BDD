package stepDefinitions;

import com.pages.LoginPage;
import com.pages.PatientDataValidationPage;
import com.pages.PatientReportPage;
import com.pages.PharmacyPortalPage;
import com.qa.Factory.DriverFactory;
//import com.qa.util.ExtentReportUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class PatientDataValidationSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private PharmacyPortalPage pharmacyPortalPage = new PharmacyPortalPage(DriverFactory.getDriver());
    private PatientReportPage patientReportPage = new PatientReportPage(DriverFactory.getDriver());
    private PatientDataValidationPage patientDataValidationPage = new PatientDataValidationPage(DriverFactory.getDriver());


    @And("user has entered credentials {string}")
    public void userHasEnteredCredentials(String patientId) {
        patientReportPage.enterPatientID(patientId);
        patientReportPage.clickSearchButton();
        System.out.println("Entered User ID: " + patientId);
    }


    @Given("User tries to validate the information")
    public void user_tries_to_validate_the_information() {
        patientDataValidationPage.clickNameButton();
        System.out.println("Entered User ID: ");
    }

    @Then("User verifies the data")
    public void user_verifies_the_data(DataTable table) {
        Map<String, String> credentials = table.asMap(String.class, String.class);
        patientDataValidationPage.verifyData(credentials);
    }


}
