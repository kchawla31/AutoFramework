package com.automation.framework.webapTestTools.reporting.extentReportTest;

import com.automation.framework.report.Reporting;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;

public class ExtentReportTesting {

    //    Build new Report with HTML Template:-
    ExtentHtmlReporter htmlReporter;

    ExtentReports extent;

    // Helps to Generate Test Logs:-
    ExtentTest test;

    @Parameters({"OS", "browser"})
    @BeforeTest
    public void startReport(String OS, String browser) {

        // Initialize HTML Report:-
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/testReports.html");

        // Initialize ExtentReport and attach HTML Reporter:-
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // To Add System or environment info by using the setSystem Info method:-
        extent.setSystemInfo("OS", OS);
        extent.setSystemInfo("Browser", browser);

        // Configuration items to change the look and feel
//        add content , manage,test etc:-
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");


    }


    @Test
    public void testCase1() {

        test = extent.createTest("Test Case 1", "PASSED TEST CASE");
        test.log(Status.PASS,"Custom Pass Message for test case 1");
        Assert.assertTrue(true);
    }

    @Test
    public void testCase2() {
        test = extent.createTest("Test Case 2", "FAILED TEST CASE");
        test.log(Status.FAIL,"Custom Fail Message for test case 2");
        Assert.assertTrue(false);

    }

    @Test
    public void testCase3() {
        test = extent.createTest("Test Case 3", "PASSED TEST CASE");
        Assert.assertTrue(true);

    }

    @Test
    public void testCase4() {
        test = extent.createTest("Test Case 4", "PASSED TEST CASE");
        Assert.assertTrue(true);

    }

    @Test
    public void testCase5() {
        test = extent.createTest("Test Case 5", "SKIPPED TEST CASE");
        throw new SkipException("Skipping this test with exception");
    }

    @Test
    public void testCase6() {
        test = extent.createTest("Test Case 6", "NOT READY, DONT EXECUTE ME");
    }


    @AfterMethod
    public void getResult(ITestResult iTestResult) {

        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(iTestResult.getName() + " FAILED ", ExtentColor.RED));
            test.fail(iTestResult.getThrowable());
        } else if (iTestResult.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(iTestResult.getName() + " PASSED ", ExtentColor.GREEN));
        } else if (iTestResult.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(iTestResult.getName() + " PASSED ", ExtentColor.GREEN));
        }
    }

    @AfterTest
    public void tearDown() {

        extent.flush();
    }
}
