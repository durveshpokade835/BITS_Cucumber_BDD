//package AppHooks;
//
//import java.util.Properties;
//
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//import com.qa.Factory.DriverFactory;
//import com.qa.util.ConfigReader;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//
//public class ApplicationHooks {
//
//	private DriverFactory driverFactory;
//	private WebDriver driver;
//
//	private ConfigReader configReader;
//	Properties prop;
//
//	@Before(order = 0)
//	public void getProperty() {
//		configReader = new ConfigReader();
//		prop = configReader.init_prop();
//	}
//
//	@Before(order = 1)
//	public void launchBrowser() {
//		String browserName = prop.getProperty("browser");
//		driverFactory = new DriverFactory();
//		driver = driverFactory.init_driver(browserName);
//
//	}
//
//	@After(order = 0)
//	public void quitBrowser() {
//		driver.quit();
//	}
//
//	@After(order = 1)
//	public void tearDown(Scenario scenario) {
//		if (scenario.isFailed()) {
//			// take screenshot:
//			String screenshotName = scenario.getName().replaceAll(" ", "_");
//			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//			scenario.attach(sourcePath, "image/png", screenshotName);
//
//		}
//
//	}
//
//}


package AppHooks;

import java.util.Arrays;
import java.util.Properties;

//import com.qa.util.ExtentReportManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.Factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
//    private ExtentReportManager extentReportManager;
    private ConfigReader configReader;
    Properties prop;


    @Before(order = 0)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser() {
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
//        extentReportManager = new ExtentReportManager();
//        extentReportManager.initExtentReports();
    }

    @After(order = 0)
    public void quitBrowser() {
//        ExtentReportManager.flush();
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        // Take screenshot for both passed and failed scenarios
        String screenshotName = scenario.getName().replaceAll(" ", "_");
        byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        // Attach screenshot to the report
        scenario.attach(sourcePath, "image/png", screenshotName);
//        ExtentReportManager.addScreenCaptureFromPath(Arrays.toString(sourcePath));
        // If scenario fails, log additional information if needed (already handled here)
        if (scenario.isFailed()) {
//            scenario.attach(sourcePath, "image/png", sourcePath.toString());
            System.out.println("Scenario failed: " + scenario.getName());
        } else {
//            scenario.attach(sourcePath, "image/png", sourcePath.toString());
            System.out.println("Scenario passed: " + scenario.getName());
        }

    }
}
