package com.automation.framework.webapTestTools.reporting.com.automation.framework.test.com.automation.apple;

import com.automation.applepageobjects.Header;
import com.automation.framework.basetest.BaseClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestHeader extends BaseClass {

    Header header;

    @Test
    public void checkAppleHeader() throws Exception{
        header = new Header(uiTestTools.get());
        header.launchURL("https://www.apple.com");

        header.home();
        header.mac();
        header.iPad();
        header.signIn();
    }


}