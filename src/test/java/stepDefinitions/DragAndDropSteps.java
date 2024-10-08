package stepDefinitions;

import com.pages.DragAndDropPage;
import com.pages.PharmacyPortalPage;
import com.qa.Factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DragAndDropSteps {

    private DragAndDropPage dragAndDropPage = new DragAndDropPage(DriverFactory.getDriver());

    @Given("User is on the table page")
    public void user_is_on_the_table_page() {

        dragAndDropPage.clickTasksButton();

    }

    @When("User drags the {string} and drops it on {string}")
    public void user_drags_the_and_drops_it_on(String column1, String column2) {
        dragAndDropPage.dragAndDrop(column1, column2);
    }

    @Then("The new column index sequence should be:")
    public void the_new_column_index_sequence_should_be(DataTable expectedTable) {
        dragAndDropPage.validateColumns(expectedTable);
    }


    @When("User drags the {string} and drops it on {string} from show hide section")
    public void userDragsTheAndDropsItOnFromShowHideSection(String column1, String column2) {
        dragAndDropPage.clicksThreeDotAndShowHideButton();
        dragAndDropPage.dragAndDropInList(column1, column2);
    }

    @Then("The new column index sequence in a list should be:")
    public void theNewColumnIndexSequenceInAListShouldBe(DataTable expectedTable) throws InterruptedException {
        dragAndDropPage.validateList(expectedTable);
    }

    @And("User clicks on Reset Button")
    public void userClicksOnResetButton() {
        dragAndDropPage.clickResetButton();
    }
}
