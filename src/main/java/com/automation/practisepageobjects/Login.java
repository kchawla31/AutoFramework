package com.automation.practisepageobjects;

import com.automation.framework.report.Reporting;
import com.automation.framework.uicontrols.WebApTool;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;

public class Login extends BasePage{

    public Login(WebApTool webApTool){
        super(webApTool);
    }

    By txtBox_username = By.id("email");
    By txtBox_pass = By.id("pass");
    By btn_Login = By.xpath("//input[@value='Log In']");

    public void signIn(String userName, String password) throws Exception {
        Reporting.getLogger().log(Status.INFO,"UserName " +userName);
        Reporting.getLogger().log(Status.INFO,"Password " +password);
        webApTool.findElement(txtBox_username).sendKeys(userName);
        webApTool.findElement(txtBox_pass).sendKeys(password);
        webApTool.findElement(btn_Login).click();
        webApTool.pageLoadTime();
        webApTool.waitForJavaScript();
        webApTool.waitForJquery();
    }

}
