package com.automation.applepageobjects;

import com.automation.framework.report.Reporting;
import com.automation.framework.uicontrols.WebApTool;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;

public class SignInPage extends Header {

    public SignInPage(WebApTool webApTool){
        super(webApTool);
    }

    By txtBox = By.xpath("//input[@type='email']");
    By pwd = By.xpath("//input[@type='password']");
    By btn_signIn = By.className("as-signin-button");

    public void logIn(String userName, String password) throws Exception{
        Reporting.getLogger().log(Status.INFO,"Username" +userName);
        Reporting.getLogger().log(Status.INFO,"Password" +password);
        webApTool.findElement(txtBox).sendKeys(userName);
        webApTool.findElement(pwd).sendKeys(password);
        webApTool.findElement(btn_signIn).click();
    }

}
