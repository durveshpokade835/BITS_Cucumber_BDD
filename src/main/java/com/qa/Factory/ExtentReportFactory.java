//package com.qa.Factory;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//public class ExtentReportFactory {
//
//
//    public class BaseTest {
//        public ExtentReports extent;
//        public ExtentTest test;
//
//        @BeforeTest
//        public void setUpExtentReport() {
//            ExtentSparkReporter spark = new ExtentSparkReporter("test-output/SparkReport/Spark.html");
//            extent = new ExtentReports();
//            extent.attachReporter(spark);
//            extent.setSystemInfo("OS", "Windows");
//            extent.setSystemInfo("Tester", "Durvesh");
//        }
//
//        @AfterTest
//        public void tearDownExtentReport() {
//            extent.flush();  // This is crucial to ensure the report is written
//        }
//    }
//
//}
