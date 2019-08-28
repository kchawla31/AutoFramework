package com.automation.practisepageobjects;

import com.automation.framework.report.Reporting;
import com.automation.framework.uicontrols.WebApTool;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Header extends BasePage {

    public Header(WebApTool webApTool) {
        super(webApTool);
    }

    By txtBox = By.xpath("//input[@class='_1frb']");
    By btn_Profile = By.xpath("//span[@class='_1vp5']");
    By btn_Home = By.linkText("Home");
    By btn_Create = By.linkText("Create");
    By btn_Settings = By.linkText("Account Settings");
    By btn_Logout = By.xpath("//span[.='Log Out' and @class ]");

    public void search(String name) throws Exception {
        Reporting.getLogger().log(Status.INFO, "Search" + name);
        webApTool.findElement(txtBox).sendKeys(name);
    }

    public void profileInfo() throws Exception {
        Reporting.getLogger().log(Status.INFO, "Profile Information");
        webApTool.findElement(btn_Profile).click();
    }

    public void homeDisplay() throws Exception {
        Reporting.getLogger().log(Status.INFO, "Home Page Info");
        webApTool.findElement(btn_Home).click();
    }

    public void create() throws Exception {
        Reporting.getLogger().log(Status.INFO, "Create Page or a Group");
        webApTool.findElement(btn_Create).click();
    }

    public void accountSettings() throws Exception {
        Reporting.getLogger().log(Status.INFO, "Account Settings");
        webApTool.findElement(btn_Settings).click();
    }

    public void logout() throws Exception {
        accountSettings();
        Reporting.getLogger().log(Status.INFO, "Log Out ");
        WebElement btn_Logut = webApTool.findElement(btn_Logout);
        btn_Logut.click();
    }

}
