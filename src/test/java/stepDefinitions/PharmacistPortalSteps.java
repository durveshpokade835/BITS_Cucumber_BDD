package stepDefinitions;

import com.pages.LoginPage;
import io.cucumber.java.en.*;
import org.testng.Assert;
import com.pages.PharmacyPortalPage;
import com.qa.Factory.DriverFactory;

public class PharmacistPortalSteps {


    private PharmacyPortalPage pharmacyPortalPage = new PharmacyPortalPage(DriverFactory.getDriver());
    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(io.cucumber.datatable.DataTable credentials) {
        // Assuming login steps are handled elsewhere, skipping the login method
        loginPage.openLoginPage();
        java.util.List<java.util.Map<String, String>> loginData = credentials.asMaps(String.class, String.class);
        String username = loginData.get(0).get("username");
        String password = loginData.get(0).get("password");
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
        loginPage.clickSignIn();
//        pharmacyPortalPage.clickAcceptAgreementButton();

        System.out.println("User is logged in with credentials");
    }

//    @Given("the user should be logged in")
//    public void the_user_should_be_logged_in() {
//        // Login validation method if required
//        System.out.println("User is already logged in");
//    }

    @When("the user clicks on Patient button and ADVANCED text button")
    public void the_user_clicks_on_patient_button_and_advanced_text_button() {
        pharmacyPortalPage.clickPatientButton();
        pharmacyPortalPage.clickAdvancedButton();
    }

    @Then("the Advanced Patient Search popup should open")
    public void the_advanced_patient_search_popup_should_open() {
        Assert.assertTrue(pharmacyPortalPage.isAdvancedSearchPopupDisplayed(), "Advanced Search Popup is not displayed");
    }

    @When("user enters First Name {string}")
    public void user_enters_first_name(String firstName) {
        pharmacyPortalPage.enterFirstName(firstName);
    }

    @When("user enters Last Name {string}")
    public void user_enters_last_name(String lastName) {
        pharmacyPortalPage.enterLastName(lastName);
    }

    @When("user enters City {string}")
    public void user_enters_city(String city) {
        pharmacyPortalPage.enterCity(city);
    }

    @When("user clicks on Search button")
    public void user_clicks_on_search_button() {
        pharmacyPortalPage.clickSearchButton();
    }

    @Then("the result should get displayed")
    public void the_result_should_get_displayed() {
        // Add verification logic for results display
        Assert.assertTrue(pharmacyPortalPage.isAdvancedSearchResultTableVisible(), "Advanced Search Result is not displayed");
//        System.out.println("Results are displayed");
    }

    @Then("the First Name {string} should get displayed")
    public void the_first_name_should_get_displayed(String firstName) {
        // Validate first name in result

        String actualResult = pharmacyPortalPage.getResultMessage();
        org.junit.Assert.assertTrue(actualResult.contains(firstName));
        System.out.println("First Name in result is: " + firstName);
    }

    @Then("the Last Name {string} should get displayed")
    public void the_last_name_should_get_displayed(String lastName) {
        // Validate last name in result
        String actualResult = pharmacyPortalPage.getResultMessage();
        org.junit.Assert.assertTrue(actualResult.contains(lastName));
        System.out.println("Last Name in result is: " + lastName);
    }

    @Then("the error pop up should appear {string}")
    public void the_error_pop_up_should_appear(String errorMessage) {
        Assert.assertTrue(pharmacyPortalPage.isErrorPopupDisplayed(errorMessage), "Error message not displayed");
    }
}