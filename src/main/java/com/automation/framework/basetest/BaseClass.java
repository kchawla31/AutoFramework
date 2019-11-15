package com.automation.framework.basetest;

import com.automation.framework.report.Reporting;
import com.automation.framework.uicontrols.WebApTool;
import com.automation.framework.webdriver.WebApDrivers;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

    ExtentReports extent;
    static protected ThreadLocal<WebApTool> uiTestTools = new ThreadLocal<>();


    @BeforeSuite
    public void beforeSuite() {

        //    Build new Report with HTML Template:-
        ExtentHtmlReporter htmlReporter;

        // Initialize HTML Report:-
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/baseReports.html");

        // Initialize ExtentReport and attach HTML Reporter:-
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Set HTML Report:-
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Test Execution Report");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        // Set Extent Reports in Reporting object:-
        Reporting.setExtenReports(extent);

    }

    @BeforeMethod
    public void beforeMethod(ITestResult result) {
        Reporting.startTest(result.getMethod().getMethodName(), result.getMethod().getMethodName());
        uiTestTools = new ThreadLocal<>();

        WebApDrivers webApDrivers = new WebApDrivers();
        WebDriver driver = webApDrivers.getWebDriver("CHROME");
        WebApTool webApTool = new WebApTool(driver);
        uiTestTools.set(webApTool);
    }

    @AfterMethod
    public void afterMethod(ITestResult iTestResult) {
        uiTestTools.get().quit();
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            Reporting.getLogger().log(Status.FAIL, MarkupHelper.createLabel(iTestResult.getName() + " FAILED ", ExtentColor.RED));
            Reporting.getLogger().fail(iTestResult.getThrowable());
        } else if (iTestResult.getStatus() == ITestResult.SUCCESS) {
            Reporting.getLogger().log(Status.PASS, MarkupHelper.createLabel(iTestResult.getName() + " PASSED ", ExtentColor.GREEN));
        } else if (iTestResult.getStatus() == ITestResult.SUCCESS) {
            Reporting.getLogger().log(Status.PASS, MarkupHelper.createLabel(iTestResult.getName() + " PASSED ", ExtentColor.GREEN));
        }
        Reporting.endTest();

    }

    @AfterTest
    public void tearDown() {
        extent.flush();
    }


}
