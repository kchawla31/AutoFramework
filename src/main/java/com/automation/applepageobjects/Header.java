package com.automation.applepageobjects;

import com.automation.framework.report.Reporting;
import com.automation.framework.uicontrols.WebApTool;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;

public class Header extends BasePage{

    public Header(WebApTool webApTool) {
        super(webApTool);
    }

    By btn_home = By.linkText("Apple");
    By btn_Mac = By.linkText("Mac");
    By btn_iPad = By.linkText("iPad");
    By btn_iPhone = By.linkText("iPhone");
    By btn_Watch = By.linkText("Watch");
    By btn_TV = By.linkText("TV");
    By btn_Music = By.linkText("Music");
    By btn_Support = By.linkText("Support");

    public void home() throws Exception{
        Reporting.getLogger().log(Status.INFO,"Home Page");
        webApTool.findElement(btn_home).click();
    }

    public void mac() throws Exception{
        Reporting.getLogger().log(Status.INFO,"Navigate to Mac");
        webApTool.findElement(btn_Mac).click();
    }

    public void iPad() throws Exception{
        Reporting.getLogger().log(Status.INFO,"Navigate to iPad");
        webApTool.findElement(btn_iPad).click();
    }

    public void iPhone() throws Exception{
        Reporting.getLogger().log(Status.INFO,"Navigate to iPhone");
        webApTool.findElement(btn_iPhone).click();
    }

    public void tv() throws Exception{
        Reporting.getLogger().log(Status.INFO,"Navigate to TV");
        webApTool.findElement(btn_TV).click();
    }

    public void music() throws Exception{
        Reporting.getLogger().log(Status.INFO,"Navigate to Music");
        webApTool.findElement(btn_Music).click();
    }

    public void watch() throws Exception{
        Reporting.getLogger().log(Status.INFO,"Navigate to Watch");
        webApTool.findElement(btn_Watch).click();
    }

    public void support() throws Exception{
        Reporting.getLogger().log(Status.INFO,"Navigate to Support");
        webApTool.findElement(btn_Support).click();
    }

    //NOT WORKING
    public void search(String searchInfo) throws Exception{
        Reporting.getLogger().log(Status.INFO,"Search info" +searchInfo);
        webApTool.findElement(By.xpath("//a[@href='/us/search' and @id='ac-gn-link-search-small']")).sendKeys(searchInfo);
    }

    public void shoppingBag() throws Exception{
        Reporting.getLogger().log(Status.INFO,"Shopping Bag");
        webApTool.findElement(By.linkText("Shopping Bag")).click();
    }

    public void signIn() throws Exception{
        shoppingBag();
        Reporting.getLogger().log(Status.INFO,"Navigate to Sign In page");
        webApTool.findElement(By.linkText("Sign in")).click();
//        Reporting.getLogger().log(Status.INFO,"Username" +username);
//        Reporting.getLogger().log(Status.INFO,"Password" +password);

    }


}
