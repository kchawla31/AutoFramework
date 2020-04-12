package com.automation.framework.webapTestTools.reporting.com.automation.framework.test;

import com.automation.framework.basetest.BaseClass;
import com.automation.pageobjects.FacebookLogin;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class LoginTests extends BaseClass {

    FacebookLogin facebook;

    @Test
    public void facebooklaunch() throws Exception {
        facebook = new FacebookLogin(uiTestTools.get());
        facebook.launchURL("https://www.facebook.com");
        facebook.login("saaru", "saaru224");
    }

    @Test
    public void facebooklaunch2() throws Exception {
        facebook = new FacebookLogin(uiTestTools.get());
        facebook.launchURL("https://www.facebook.com");
        facebook.login("saaru", "saaru224");
    }






}
