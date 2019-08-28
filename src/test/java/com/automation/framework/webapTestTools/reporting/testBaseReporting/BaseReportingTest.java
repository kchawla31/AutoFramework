package com.automation.framework.webapTestTools.reporting.testBaseReporting;

import com.automation.framework.basetest.BaseClass;
import com.automation.framework.report.Reporting;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class BaseReportingTest extends BaseClass {

    @Test
    public void testMethod1() {
       ExtentTest test = Reporting.getLogger();
        test.log(Status.PASS, "Test Case1 has Passed");
        Reporting.getLogger().log(Status.PASS, "Test Case1 has Passed");
    }

    @Test
    public void testMethod2() {

        Reporting.getLogger().log(Status.FAIL, "Test Case2 has Failed");
    }

    @Test
    public void testMethod3() {

        Reporting.getLogger().log(Status.SKIP, "Test Case3 has Skip");
        throw new SkipException("Test Case has skipped");
    }
}
