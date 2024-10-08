package com.pages;

import io.cucumber.datatable.DataTable;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DragAndDropPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //instances
    PatientReportPage patientReportPage = new PatientReportPage(driver);
    Actions act;


    // Locators
    private By tasksIdInputLocator = By.xpath("//button[text()='Tasks']");
    private By taskTableLocator = By.xpath("//tr[@class='mantine-fvktgm']");
    //    private By sourceColumnButton = By.xpath("//div[text()='Due Date']/parent::div/following-sibling::div/child::button[1]");
//    private By destinatioColumnButton = By.xpath("//div[text()='Status']/parent::div/following-sibling::div/child::button[1]");
    private By threeDotButtonLocator = By.xpath("//button[contains(@class,'mantine-4nqhrt')]");
    private By showHideLocator = By.xpath("//button[@aria-label='Show/Hide columns']");
    private By showHideDropDownLocator = By.xpath("//button[@class='mantine-Menu-item mantine-1okg4gn']");
    private By resetBtnLocator = By.xpath("(//button[contains(@class,'mantine-Button-root')])[2]");

    //constructor
    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.act = new Actions(driver);
    }

    //WebElements
//    WebElement threeDotBtn = driver.findElement(threeDotButtonLocator);
//    WebElement showHideBtn = driver.findElement(showHideLocator);

    //Page Actions
    //----------------------------------------------------------------------------
    public void clickTasksButton() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(patientReportPage.loader));
        wait.until(ExpectedConditions.elementToBeClickable(tasksIdInputLocator)).click();
    }

    public void clicksThreeDotAndShowHideButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(taskTableLocator));

        WebElement threeDotBtn = driver.findElement(threeDotButtonLocator);
        act.moveToElement(threeDotBtn).click().perform();
        WebElement showHideBtn = driver.findElement(showHideLocator);
        act.moveToElement(showHideBtn).click().perform();
    }

    public void dragAndDrop(String column1, String column2) {
        By sourceColumnButton = By.xpath("//div[text()='" + column1 + "']/parent::div/following-sibling::div/child::button[1]");
        By destinationColumnButton = By.xpath("//div[text()='" + column2 + "']/parent::div/following-sibling::div/child::button[1]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(taskTableLocator));
        WebElement sourceColumn = driver.findElement(sourceColumnButton);
        WebElement destinationColumn = driver.findElement(destinationColumnButton);
        act.dragAndDrop(sourceColumn, destinationColumn).perform();

    }

    public void dragAndDropInList(String column1, String column2) {

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(showHideDropDownLocator));
        By sourceColumnButton = By.xpath("//label[text()='" + column1 + "']/parent::div/parent::div/parent::div/preceding-sibling::button");
        By destinationColumnButton = By.xpath("//label[text()='" + column2 + "']/parent::div/parent::div/parent::div/preceding-sibling::button");


        WebElement sourceColumn = driver.findElement(sourceColumnButton);
        WebElement destinationColumn = driver.findElement(destinationColumnButton);
        act.dragAndDrop(sourceColumn, destinationColumn).perform();
    }

    public void validateColumns(DataTable expectedTable) {
//        Thread.sleep(5000);
        List<Map<String, String>> expectedColumns = expectedTable.asMaps(String.class, String.class);
        List<String> expectedColumnOrder = new ArrayList<>();
        for (Map<String, String> row : expectedColumns) {
            expectedColumnOrder.add(row.get("Column"));
        }
        // Re-fetch the actual column order from the table
        List<WebElement> columns = driver.findElements(By.xpath("//div[contains(@class,'mantine-TableHeadCell-Content-Wrapper')]"));
        List<String> actualColumnOrder = new ArrayList<>();
        for (WebElement column : columns) {
            actualColumnOrder.add(column.getText());
        }
        // Skip the first element of actualColumnOrder
        List<String> actualColumnOrderWithoutFirst = actualColumnOrder.subList(1, actualColumnOrder.size());

        // Validate the sequence (skipping the first element of actualColumnOrder)
        Assert.assertEquals(actualColumnOrderWithoutFirst, expectedColumnOrder, "The column sequence is incorrect after drag and drop.");

    }

    public void validateList(DataTable expectedTable) throws InterruptedException {
        Thread.sleep(5000);
        List<Map<String, String>> expectedColumns = expectedTable.asMaps(String.class, String.class);
        List<String> expectedColumnOrder = new ArrayList<>();
        for (Map<String, String> row : expectedColumns) {
            expectedColumnOrder.add(row.get("Column"));
        }
        // Re-fetch the actual column order from the table
        List<WebElement> columns = driver.findElements(By.xpath("//label[contains(@class,'mantine-Switch-label')]"));
        List<String> actualColumnOrder = new ArrayList<>();
        for (WebElement column : columns) {
            actualColumnOrder.add(column.getText());
        }
        // Skip the first element of actualColumnOrder
        List<String> actualColumnOrderWithoutFirst = actualColumnOrder.subList(1, actualColumnOrder.size());

        // Validate the sequence (skipping the first element of actualColumnOrder)
        Assert.assertEquals(actualColumnOrderWithoutFirst, expectedColumnOrder, "The column sequence is incorrect after drag and drop.");

    }

    public void clickResetButton() {
        wait.until(ExpectedConditions.elementToBeClickable(resetBtnLocator)).click();
    }

}
