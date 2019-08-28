package com.automation.framework.webapTestTools.reporting.com.automation.framework.test.com.automation.practise;

import com.automation.framework.basetest.BaseClass;
import com.automation.practisepageobjects.Header;
import com.automation.practisepageobjects.Login;
import com.automation.practisepageobjects.ReadTestData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestHeader extends BaseClass {

    Header header;
    Login login;


    @Test(dataProvider = "Authentication")
    public void checkHeader(String username, String password, String searchName) throws Exception {
        System.out.println("Username: "+username);
        System.out.println("PWD: "+password);
        System.out.println("searchName: "+searchName);

        login = new Login(uiTestTools.get());
        login.launchURL("https://www.facebook.com");
        login.signIn(username, password);

        header = new Header(uiTestTools.get());
        header.search(searchName);
        header.profileInfo();
        header.homeDisplay();
        header.create();
        header.logout();
    }

    @DataProvider
    public Object[][] Authentication() throws Exception{
        Object[][] testObjArray = ReadTestData.readExcel("C:\\Users\\kapil-pc\\Desktop\\Java Practise\\AutoFramework\\src\\main\\resources\\LoginTestData.xlsx");
        return (testObjArray);
    }
}
