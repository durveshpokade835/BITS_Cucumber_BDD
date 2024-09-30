package stepDefinitions;

import com.pages.PharmacyPortalPage;
//import com.qa.util.ExtentReportManager;
import com.qa.util.ExtentReportUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.Factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginPageSteps {
//    WebDriver driver = DriverFactory.getDriver();

    private static String title;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private PharmacyPortalPage pharmacyPortalPage = new PharmacyPortalPage(DriverFactory.getDriver());

    @Before
    public void setUp() {
//        ExtentReportUtil ExtentReportUtil;
        ExtentReportUtil.initExtentReport();
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        ExtentReportUtil.startTest("Successful login with valid credentials");
        try {

            DriverFactory.getDriver()
                    .get("https://pharmacist-dev.arine.io/");

//		loginPage.openLoginPage();
            title = loginPage.getCurrentUrl();
            System.out.println(title);
		Assert.assertTrue(title.equalsIgnoreCase("https://pharmacist-dev.arine.io/"));
            ExtentReportUtil.logInfo("User logged in successfully for patient search.");
        }catch (Exception e) {
            ExtentReportUtil.logFail("Login failed for patient search: " + e.getMessage());
            throw e; // Re-throw exception to fail the test
        }



    }

    @When("the user enters the valid email {string}")
    public void the_user_enters_the_valid_email(String userName) {
        try {
//        ExtentReportManager.createTest("Test Login Functionality");
            loginPage.enterEmail(userName);
//        ExtentReportManager.log("User has entered username and password");
        } catch (Exception e) {
            ExtentReportUtil.logFail("Failed to enter valid email address: " + e.getMessage());
            throw e;
        }

    }

    @When("valid password {string}")
    public void valid_password(String userPassword) {
        try {
            loginPage.enterPassword(userPassword);
        }catch (Exception e) {
            ExtentReportUtil.logFail("Failed to enter valid password address: " + e.getMessage());
            throw e;
        }

    }

    @Then("the user should be logged in")
    public void the_user_should_be_logged_in() {
    try {
        boolean isDashBoardVisible = loginPage.isDashboardDisplayed();
//        if(pharmacyPortalPage.isLoginUserAgreementPopUpVisible()){
//            pharmacyPortalPage.clickAcceptAgreementButton();
//        }
        boolean isTableVisible = pharmacyPortalPage.isTableVisible();
        Assert.assertTrue(isDashBoardVisible);
        ExtentReportUtil.logPass("Test Case Passed.");
    }catch (Exception e) {
        ExtentReportUtil.logFail("Test Case Failed " + e.getMessage());
        throw e;
    }

    }

    @When("the user enters invalid password {string}")
    public void the_user_enters_invalid_password(String invalidPassword) {
        try {
            loginPage.enterPassword(invalidPassword);
        } catch (Exception e) {
            ExtentReportUtil.logFail("Test Case Failed " + e.getMessage());
            throw new RuntimeException(e);
        }

//		throw new io.cucumber.java.PendingException();
    }

    @Then("an error message should be displayed {string}")
    public void an_error_message_should_be_displayed(String expErrorMsg) {
    try {
        String actualErrorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(actualErrorMsg.contains(expErrorMsg));
//		throw new io.cucumber.java.PendingException();
        ExtentReportUtil.logPass("Test Case Passed ");
    } catch (Exception e) {
        ExtentReportUtil.logFail("Test Case Failed " + e.getMessage());
        throw e;
    }
    }

    @When("the user enters an invalid email {string}")
    public void the_user_enters_an_invalid_email(String invalidUserName) {
        try {
            loginPage.enterEmail(invalidUserName);

//		throw new io.cucumber.java.PendingException();
        } catch (Exception e) {
            ExtentReportUtil.logFail("Test Case Failed " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        try {
            loginPage.clickSignIn();

        } catch (Exception e) {
            ExtentReportUtil.logFail("Test Case Failed " + e.getMessage());
            throw new RuntimeException(e);
        }


    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expErrorMsg2) {
        try {
            String actualErrorMsg = loginPage.getErrorMessage();
            Assert.assertTrue(actualErrorMsg.contains(expErrorMsg2));
            ExtentReportUtil.logPass("Test Case Passed ");
//		throw new io.cucumber.java.PendingException();
        } catch (Exception e) {
            ExtentReportUtil.logFail("Test Case Failed " + e.getMessage());
            throw e;
        }
    }

    @After
    public void tearDown() {
        ExtentReportUtil.flushReport(); // Flush report at the end of each scenario
//        DriverFactory.closeDriver(); // Close the driver after the scenario
    }
}
