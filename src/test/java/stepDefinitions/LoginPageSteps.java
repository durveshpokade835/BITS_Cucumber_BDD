package stepDefinitions;

import com.pages.PharmacyPortalPage;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.Factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginPageSteps {
    private String title;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private PharmacyPortalPage pharmacyPortalPage = new PharmacyPortalPage(DriverFactory.getDriver());

///////////////////////////////////////////////////////////////////////

    @Given("the user is on the login page {string}")
    public void theUserIsOnTheLoginPage(String application) {
        try {
            loginPage.openLoginPage(application);
            title = loginPage.getCurrentUrl();
            System.out.println(title);
            Assert.assertTrue(title.equalsIgnoreCase(application));
        } catch (Exception e) {
            throw e; // Re-throw exception to fail the test
        }
    }

    @When("User login with {string} and {string}")
    public void userLoginWithAnd(String userName, String password) {
        loginPage.enterEmail(userName);
        loginPage.enterPassword(password);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        try {
            loginPage.clickSignIn();
//            boolean visibility = pharmacyPortalPage.isLoginUserAgreementPopUpVisible();
//            System.out.println(visibility);
//            if (visibility) {
//                pharmacyPortalPage.clickAcceptAgreementButton();
//            }
        } catch (Exception e) {
            throw new RuntimeException(e);
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
        } catch (Exception e) {
            throw e;
        }
    }

    @Then("the user should see an error message {string}")
    public void theUserShouldSeeAnErrorMessage(String errorMessage) {
        try {
            String actualErrorMsg = loginPage.getErrorMessage();
            Assert.assertTrue(actualErrorMsg.contains(errorMessage));
        } catch (Exception e) {
            throw e;
        }
    }
}
///////////////////////////////////////////////////////////////
