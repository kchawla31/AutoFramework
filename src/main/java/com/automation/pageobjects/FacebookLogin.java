package com.automation.pageobjects;

import com.automation.framework.report.Reporting;
import com.automation.framework.uicontrols.WebApTool;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;

public class FacebookLogin extends BasePage {

    public FacebookLogin(WebApTool webApTool) {
        super(webApTool);
    }

    /**
     * Login into facebook:-
     */
    public void login(String userName, String password) throws Exception {
        Reporting.getLogger().log(Status.INFO, "UserName " + userName);
        Reporting.getLogger().log(Status.INFO, "Password " + password);
        webApTool.findElement(By.id("email")).sendKeys(userName);
        webApTool.findElement(By.id("pass")).sendKeys(password);
        webApTool.findElement(By.id("login")).click();
    }
}
