package com.automation.applepageobjects;

import com.automation.framework.report.Reporting;
import com.automation.framework.uicontrols.WebApTool;
import com.aventstack.extentreports.Status;

public class BasePage {

    WebApTool webApTool;

    public BasePage(WebApTool webApTool) {
        this.webApTool = webApTool;
    }

    public void launchURL(String url){
        Reporting.getLogger().log(Status.INFO,"Launch URL" +url);
        webApTool.get(url);
    }
}
