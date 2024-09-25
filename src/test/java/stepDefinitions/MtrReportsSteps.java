//package stepDefinitions;
//
//import com.pages.LoginPage;
//import com.pages.PharmacyPortalPage;
//import com.pages.MtrReportPage;
//import com.qa.Factory.DriverFactory;
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//
//public class MtrReportsSteps {
//
//    private MtrReportPage mtrReportPage = new MtrReportPage(DriverFactory.getDriver());
//    private PharmacyPortalPage pharmacyPortalPage = new PharmacyPortalPage(DriverFactory.getDriver());
//    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
//
////    private MtrReportPage mtrReportPage;
//    private WebDriver driver; // WebDriver instance for the step definitions
//
//    // Constructor
//    public MtrReportsSteps() {
//        this.driver = DriverFactory.getDriver(); // Retrieve WebDriver from DriverFactory
//        this.mtrReportPage = new MtrReportPage(driver); // Pass driver to the MtrReportPage
//    }
//
////    @When("the user clicks on Patient button")
////    public void the_user_clicks_on_patient_button() {
////        pharmacyPortalPage.clickPatientButton();
////    }
//    @When("enters Id {string}")
//    public void enters_id(String pId) {
//        mtrReportPage.enterPatientId(pId);
//    }
//
//    @And("the user clicks on Search button then report button and MTM Reports button")
//    public void theUserClicksOnSearchButtonAndMTMReportsButton() {
////        mtrReportPage.clickSearchPatientButton();
//        mtrReportPage.clickReportButton();
//        mtrReportPage.clickMtmReportButton();
//    }
//
//    @And("the user selects CMR as review type")
//    public void theUserSelectsCMRAsReviewType() {
//        mtrReportPage.selectCmrRadtioInput();
//    }
//
//    @And("the user clicks on Set Conversation Date Button")
//    public void theUserClicksOnSetConversationDateButton() {
//        mtrReportPage.clickSetConversationDateButton();
//    }
//
//    @Then("the pop up msg should get displayed {string}")
//    public void thePopUpMsgShouldGetDisplayed(String validationMsg) {
//        Assert.assertTrue(MtrReportPage.isValidationPopupDisplayed(validationMsg), "Pop up message not displayed");
//    }
//
//    @And("the user select a date {string} days before the current date")
//    public void theUserSelectADateDaysBeforeTheCurrentDate(String validationMsg) {
//    }
//
//
//    @Given("the user is on the Patient page")
//    public void the_user_is_on_the_patient_page() {
//
//        mtrReportPage.clickPatientButton();
//        boolean isDashBoardVisible = mtrReportPage.isPatientTabSelected();
//        boolean isTableVisible = mtrReportPage.isPatientTableVisible();
//        org.junit.Assert.assertTrue(isDashBoardVisible);
//    }
//
////    @Given("user has already logged in to application and is on patient page")
////    public void userHasAlreadyLoggedInToApplicationAndIsOnPatientPage(io.cucumber.datatable.DataTable credentials) {
////        DriverFactory.getDriver().get("https://pharmacist-dev.arine.io/");
////        loginPage.openLoginPage();
////        java.util.List<java.util.Map<String, String>> loginData = credentials.asMaps(String.class, String.class);
////        String username = loginData.get(0).get("username");
////        String password = loginData.get(0).get("password");
////        loginPage.enterEmail(username);
////        loginPage.enterPassword(password);
////        loginPage.clickSignIn();
////    }
//    @Given("user has already logged in to application and is on patient page")
//    public void user_has_already_logged_in_to_application_and_is_on_patient_page(io.cucumber.datatable.DataTable dataTable) {
//        DriverFactory.getDriver().get("https://pharmacist-dev.arine.io/");
//        loginPage.openLoginPage();
//        java.util.List<java.util.Map<String, String>> loginData = dataTable.asMaps(String.class, String.class);
//        String username = loginData.get(0).get("username");
//        String password = loginData.get(0).get("password");
//        loginPage.enterEmail(username);
//        loginPage.enterPassword(password);
//        loginPage.clickSignIn();
//    }
////    @Given("the user is on the Patient page")
////    public void the_user_is_on_the_patient_page() {
////        // Write code here that turns the phrase above into concrete actions
////        throw new io.cucumber.java.PendingException();
////    }
////    @When("enters Id {string}")
////    public void enters_id(String string) {
////        // Write code here that turns the phrase above into concrete actions
////        throw new io.cucumber.java.PendingException();
////    }
//}
