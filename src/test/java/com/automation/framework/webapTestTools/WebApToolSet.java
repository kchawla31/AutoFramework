package com.automation.framework.webapTestTools;

import com.automation.framework.uicontrols.WebApTool;
import com.automation.framework.webdriver.WebApDrivers;
import org.openqa.selenium.WebDriver;

public class WebApToolSet {

    public static void main(String[] args) {

        WebApDrivers webApDrivers = new WebApDrivers();
        WebDriver driver = webApDrivers.getWebDriver("CHROME");
        WebApTool webApTool = new WebApTool(driver);
        webApTool.get("https://www.google.com");
        webApTool.switchTo().frame("test");
    }
}
