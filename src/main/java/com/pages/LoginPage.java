package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {

    public static WebDriver driver;
    public static WebDriverWait wait;

    //1. By Locators:
    private By emailId = By.xpath("//input[@name='email']");
    private By password = By.xpath("//input[@name='password']");
    private By signIn = By.xpath("//button[@type='submit']");
    private By errorMsg = By.xpath("//div[@class='src-routes-User-Login-__textError___1dP6Q']");

    //2.Constructor of the page Class:
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    // 3. page actions: features(behavior) of the page the form of methods:
//-----------------------------------------------------------------------------------------------------------------------

    public void openLoginPage(String link) {
        driver.get(link);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void enterEmail(String email) {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailId));
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void enterPassword(String pwd) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        passwordElement.clear();
        passwordElement.sendKeys(pwd);
    }

    public void clickSignIn() {
        WebElement signInElement = wait.until(ExpectedConditions.elementToBeClickable(signIn));
        signInElement.click();
    }

    public boolean isDashboardDisplayed() {
        return wait.until(ExpectedConditions.urlContains("pharmacist-portal"));
    }

    public String getErrorMessage() {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
        return error.getText();
    }

    //-----------------------------------------------------------------------------------------------------------------


}
