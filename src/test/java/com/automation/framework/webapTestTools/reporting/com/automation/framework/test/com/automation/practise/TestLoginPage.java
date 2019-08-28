package com.automation.framework.webapTestTools.reporting.com.automation.framework.test.com.automation.practise;

import com.automation.framework.basetest.BaseClass;
import com.automation.practisepageobjects.Login;
import org.testng.annotations.Test;

public class TestLoginPage extends BaseClass {
    Login login;

    @Test
    public void launchapp() throws Exception{
        login = new Login(uiTestTools.get());
        login.launchURL("https://www.facebook.com");
        login.signIn("saaru20","Kapilsaru2704");

    }
}
