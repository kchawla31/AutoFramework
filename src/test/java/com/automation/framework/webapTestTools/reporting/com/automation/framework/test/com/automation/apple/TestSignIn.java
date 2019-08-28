package com.automation.framework.webapTestTools.reporting.com.automation.framework.test.com.automation.apple;

import com.automation.applepageobjects.Header;
import com.automation.applepageobjects.SignInPage;
import com.automation.framework.basetest.BaseClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSignIn extends BaseClass {

    SignInPage signInPage;
    Header header;

    @Test(dataProvider = "LoginData")
    public void checkSignIn(String usrnm, String pwd) throws Exception{
        signInPage = new SignInPage(uiTestTools.get());
        header = new Header(uiTestTools.get());

        header.launchURL("https://www.apple.com");
        header.signIn();
        signInPage.logIn(usrnm, pwd);
    }

    @DataProvider
    public Object[][] LoginData() throws Exception{
        Object[][] testDataArray = ReadExcel.readData("C:\\Users\\kapil-pc\\Desktop\\Java Practise\\AutoFramework\\src\\main\\resources\\AppleData.xlsx");
        return (testDataArray);
    }
}
