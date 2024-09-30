package stepDefinitions;

import com.pages.LoginPage;
import com.pages.PatientDataValidationPage;
import com.pages.PatientReportPage;
import com.pages.PharmacyPortalPage;
import com.qa.Factory.DriverFactory;
import com.qa.util.ExtentReportUtil;
import io.cucumber.datatable.DataTable;
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

    @Given("user has already logged in to application and is on patient page")
    public void isPatientDashboard() {
        try {
            DriverFactory.getDriver().get("https://pharmacist-dev.arine.io/");
            loginPage.enterEmail("hardstop-pharmacist6@mailinator.com");
            loginPage.enterPassword("Password1#");
            loginPage.clickSignIn();
//            pharmacyPortalPage.clickAcceptAgreementButton();
            pharmacyPortalPage.clickPatientButton();
            boolean loginVal = loginPage.isDashboardDisplayed();
            Assert.assertTrue(loginVal, "Login was not successful");

        } catch (Exception e) {

            throw e; // Re-throw exception to fail the test
        }
    }

    @Given("user has entered credentials")
    public void user_has_entered_credentials(DataTable table) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

        Map<String, String> credentials = table.asMap(String.class, String.class);
        String patientId = credentials.get("userId");
        patientReportPage.enterPatientID(patientId);
        System.out.println("Entered User ID: " + patientId);


    }

    @Given("User tries to validate the information")
    public void user_tries_to_validate_the_information() {
        patientDataValidationPage.clickNameButton();
        System.out.println("Entered User ID: ");
    }

    @Then("User verifies the data")
    public void user_verifies_the_data(DataTable table) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

        Map<String, String> credentials = table.asMap(String.class, String.class);
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
        String actualFirstName = patientDataValidationPage.getFirstName();
        String actualLastName = patientDataValidationPage.getLastName();
        String actualHosp30d = patientDataValidationPage.getHosp30d();
        String actualDOB = patientDataValidationPage.getDOB();
        String actualSex = patientDataValidationPage.getSex();
        String actualAge = patientDataValidationPage.getAge();
        String actualPtLang = patientDataValidationPage.getPtLang();
        String actualInsurance = patientDataValidationPage.getInsurance();
        String actualInsuranceCo = patientDataValidationPage.getInsuranceCo();


        // Conditional validations
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


//        patientDataValidationPage.verifyData(expectedFirstName, expectedLastName, expectedSex, expectedAge);
//        System.out.println("Data " + expectedFirstName + " " + expectedLastName + " " + expectedSex + " " + expectedAge);
//
//
    }

}
