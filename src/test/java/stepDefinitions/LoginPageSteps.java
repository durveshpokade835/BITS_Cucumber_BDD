package stepDefinitions;

import com.pages.PharmacyPortalPage;
//import com.qa.util.ExtentReportManager;
import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.Factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

    private static String title;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private PharmacyPortalPage pharmacyPortalPage = new PharmacyPortalPage(DriverFactory.getDriver());

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

        DriverFactory.getDriver()
                .get("https://pharmacist-dev.arine.io/");

//		loginPage.openLoginPage();
        title = loginPage.getCurrentUrl();
        System.out.println(title);
//		Assert.assertTrue(title.equalsIgnoreCase("https://pharmacist-dev.arine.io/"));

    }

    @When("the user enters the valid email {string}")
    public void the_user_enters_the_valid_email(String userName) {

//        ExtentReportManager.createTest("Test Login Functionality");
        loginPage.enterEmail(userName);
//        ExtentReportManager.log("User has entered username and password");

    }

    @When("valid password {string}")
    public void valid_password(String userPassword) {

        loginPage.enterPassword(userPassword);

    }

    @Then("the user should be logged in")
    public void the_user_should_be_logged_in() {

        boolean isDashBoardVisible = loginPage.isDashboardDisplayed();
        boolean isTableVisible = pharmacyPortalPage.isTableVisible();
        Assert.assertTrue(isDashBoardVisible);

    }

    @When("the user enters invalid password {string}")
    public void the_user_enters_invalid_password(String invalidPassword) {

        loginPage.enterPassword(invalidPassword);

//		throw new io.cucumber.java.PendingException();
    }

    @Then("an error message should be displayed {string}")
    public void an_error_message_should_be_displayed(String expErrorMsg) {

        String actualErrorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(actualErrorMsg.contains(expErrorMsg));
//		throw new io.cucumber.java.PendingException();
    }

    @When("the user enters an invalid email {string}")
    public void the_user_enters_an_invalid_email(String invalidUserName) {

        loginPage.enterEmail(invalidUserName);

//		throw new io.cucumber.java.PendingException();
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {

        loginPage.clickSignIn();


    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expErrorMsg2) {


        String actualErrorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(actualErrorMsg.contains(expErrorMsg2));

//		throw new io.cucumber.java.PendingException();
    }

}
