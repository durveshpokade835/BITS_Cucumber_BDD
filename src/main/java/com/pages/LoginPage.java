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

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
//	        return wait.until(ExpectedConditions.urlContains("pharmacist-portal"));
        String CurrentUrl = driver.getCurrentUrl();
        return CurrentUrl;
    }

//		public boolean isLoginPageDisplayed() {
//	        return wait.until(ExpectedConditions.urlContains("https://pharmacist-dev.arine.io/"));
//	    }

    public void openLoginPage() {
        driver.get("https://pharmacist-dev.arine.io/");
    }

    public void enterEmail(String email) {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailId));

//	    	WebElement emailElement = driver.findElement(emailId);
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void enterPassword(String pwd) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
//	    	WebElement passwordElement = driver.findElement(password);
        passwordElement.clear();
        passwordElement.sendKeys(pwd);
    }

    public void clickSignIn() {
        WebElement signInElement = wait.until(ExpectedConditions.elementToBeClickable(signIn));
//	    	WebElement signInElement = driver.findElement(signIn);
        signInElement.click();
    }

    public String getErrorMessage() {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
//	    	WebElement error = driver.findElement(errorMsg);
        return error.getText();
    }

    public boolean isDashboardDisplayed() {
//		wait.until(ExpectedConditions.visibilityOfElementLocated())
        return wait.until(ExpectedConditions.urlContains("pharmacist-portal"));
//	    	boolean DashBoardUrl = driver.getCurrentUrl().contains("pharmacist-portal");
//			System.out.println(DashBoardUrl);
//	    	return DashBoardUrl;
    }


}
