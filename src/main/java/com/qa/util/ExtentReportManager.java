package com.qa.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.HashMap;
import java.util.Map;

public class ExtentReportManager {

    private static ExtentReports extent;
    private static ExtentTest test;
    private static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();

    // Method to initialize ExtentReports
    public static void initExtentReports() {
        String path = System.getProperty("user.dir") + "\\reports\\ExtentReport.html"; // Path for HTML report
        String pdfPath = System.getProperty("user.dir") + "\\reports\\ExtentReport.pdf"; // Path for PDF report

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(pdfPath);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter, htmlReporter);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Browser", "Chrome");
    }

    // Method to create test instances
    public static void createTest(String testName) {
        test = extent.createTest(testName);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
    }

    // Method to log messages
    public static void log(String message) {
        extentTestMap.get((int) Thread.currentThread().getId()).info(message);
    }

    // Method to finalize and flush reports
    public static void flush() {
        extent.flush();
    }

    // Method to capture screenshots
    public static void addScreenCaptureFromPath(String path) {
        extentTestMap.get((int) Thread.currentThread().getId()).addScreenCaptureFromPath(path);
    }


}
