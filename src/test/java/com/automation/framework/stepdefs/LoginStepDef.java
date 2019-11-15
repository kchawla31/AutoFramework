package com.automation.framework.stepdefs;

import com.automation.framework.basetest.BaseClass;
import com.automation.framework.report.Reporting;
import com.automation.framework.uicontrols.WebApTool;
import com.automation.framework.webdriver.WebApDrivers;
import com.automation.pageobjects.FacebookLogin;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

public class LoginStepDef extends BaseClass {
    ExtentReports extent;
    static protected ThreadLocal<WebApTool> uiTestTools = new ThreadLocal<>();

    FacebookLogin facebook;

    @Before
    public void before(Scenario scenario) {

        if (extent == null) {
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

        Reporting.startTest( scenario.getName(),scenario.getName());
        uiTestTools = new ThreadLocal<>();

        WebApDrivers webApDrivers = new WebApDrivers();
        WebDriver driver = webApDrivers.getWebDriver("CHROME");
        WebApTool webApTool = new WebApTool(driver);
        uiTestTools.set(webApTool);
    }

    @After
    public void afterScenario(Scenario scenario){

        uiTestTools.get().quit();
        if (scenario.isFailed()) {
            Reporting.getLogger().log(Status.FAIL, MarkupHelper.createLabel(scenario.getName() + " FAILED ", ExtentColor.RED));
        } else  {
            Reporting.getLogger().log(Status.PASS, MarkupHelper.createLabel(scenario.getName() + " PASSED ", ExtentColor.GREEN));
        }
        Reporting.endTest();
        extent.flush();
    }

    @Given("User launch URL")
    public void launchURL() throws Exception {
        facebook = new FacebookLogin(uiTestTools.get());
        facebook.launchURL("https://www.facebook.com");
        facebook.login("saaru", "saaru224");
    }
}
