package stepDefinitions;

import com.pages.LoginPage;
//import com.pages.MtrReportPage;
import io.cucumber.java.en.*;
import org.testng.Assert;
import com.pages.PharmacyPortalPage;
import com.qa.Factory.DriverFactory;

public class PharmacistPortalSteps {


    private PharmacyPortalPage pharmacyPortalPage = new PharmacyPortalPage(DriverFactory.getDriver());
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());


    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(io.cucumber.datatable.DataTable credentials) {

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

    @When("user selects State {string}")
    public void user_Selects_State(String state) {

        pharmacyPortalPage.selectState(state);

    }


    @Then("the result should get displayed")
    public void the_result_should_get_displayed() {

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


    @And("the City Name {string} should get displayed")
    public void theCityNameShouldGetDisplayed(String city) {

        String actualResult = pharmacyPortalPage.getResultMessage();
        org.junit.Assert.assertTrue(actualResult.contains(city));
        System.out.println("City Name in result is: " + city);
        
    }

    @And("the State {string} should get displayed")
    public void theStateShouldGetDisplayed(String state) {

        String actualResult = pharmacyPortalPage.getResultMessage();
        org.junit.Assert.assertTrue(actualResult.contains("CA"));
        System.out.println("State Name in result is: " + state);
        
    }

    @And("User enters {string} as Zip Code")
    public void userEntersAsZipCode(String zipCode) {
        pharmacyPortalPage.enterZipCode(zipCode);
        
    }

    @And("the ZipCode {string} should get displayed")
    public void theZipCodeShouldGetDisplayed(String zipCode) {
        String actualResult = pharmacyPortalPage.getResultMessage();
        org.junit.Assert.assertTrue(actualResult.contains(zipCode));
        System.out.println("Zip Code in result is: " + zipCode);
    }

    @And("User enters {string} as Phone")
    public void userEntersAsPhone(String phone) {
        pharmacyPortalPage.enterPhoneNumber(phone);
    }

    @And("the Phone {string} should get displayed")
    public void thePhoneShouldGetDisplayed(String phone) {
        String actualResult = pharmacyPortalPage.getResultMessage();
        org.junit.Assert.assertTrue(actualResult.contains(phone));
        System.out.println("Phone Number in result is: " + phone);
    }

    @And("User enters {string} as Birth Date")
    public void userEntersAsBirthDate(String birthDate) {

        pharmacyPortalPage.enterBirthDate(birthDate);
    }

    @And("the date {string} should get displayed")
    public void theDateShouldGetDisplayed(String birthDate) {
        String actualResult = pharmacyPortalPage.getResultMessage();
        org.junit.Assert.assertTrue(actualResult.contains(birthDate));
        System.out.println("Phone Number in result is: " + birthDate);
    }

    @And("User enters {string} as HPID")
    public void userEntersAsHPID(String hpId) {

        pharmacyPortalPage.enterHpId(hpId);

    }

    @And("the HPID {string} should get displayed")
    public void theHPIDShouldGetDisplayed(String hpId) {
        String actualResult = pharmacyPortalPage.getResultMessage();
        org.junit.Assert.assertTrue(actualResult.contains(hpId));
        System.out.println("Phone Number in result is: " + hpId);
    }

    @Then("Tooltip error message: {string} should display for Zip Code")
    public void tooltipErrorMessageShouldDisplayForZipCode(String expectedErrMsg) {
        String actualErrMsg = pharmacyPortalPage.getTooltipErrorMessage(pharmacyPortalPage.zipCodeInput);
//        Assert.assertEquals( expectedErrMsg, actualErrMsg,"Tooltip message did not match!");
//        org.junit.Assert.assertEquals(expectedErrMsg, actualErrMsg);
        org.junit.Assert.assertEquals("Tooltip message did not match!", expectedErrMsg, actualErrMsg);
    }

    @Then("Tooltip error message: {string} should display for Birth Date")
    public void tooltipErrorMessageShouldDisplayForBirthDate(String expectedErrMsg) {
        String actualErrMsg = pharmacyPortalPage.getTooltipErrorMessage(pharmacyPortalPage.birthDateInput);
//        Assert.assertEquals( expectedErrMsg, actualErrMsg,"Tooltip message did not match!");
//        org.junit.Assert.assertEquals(expectedErrMsg, actualErrMsg);
        org.junit.Assert.assertEquals("Tooltip message did not match!", expectedErrMsg, actualErrMsg);
    }

    @Then("Tooltip error message: {string} should display for Phone Number")
    public void tooltipErrorMessageShouldDisplayForPhoneNumber(String expectedErrMsg) {
        String actualErrMsg = pharmacyPortalPage.getTooltipErrorMessage(pharmacyPortalPage.phoneNumberInput);
//        Assert.assertEquals( expectedErrMsg, actualErrMsg,"Tooltip message did not match!");
//        org.junit.Assert.assertEquals(expectedErrMsg, actualErrMsg);
        org.junit.Assert.assertEquals("Tooltip message did not match!", expectedErrMsg, actualErrMsg);
    }


//    @Then("the tooltip error pop up should appear {string}")
//    public void theTooltipErrorPopUpShouldAppear(String toolTipError) {
//        String actualResult = pharmacyPortalPage.getToolTipMessage();
//        org.junit.Assert.assertTrue(actualResult.contains(toolTipError));
//        System.out.println("The Tooltip Error message is: " + toolTipError);
//    }

}