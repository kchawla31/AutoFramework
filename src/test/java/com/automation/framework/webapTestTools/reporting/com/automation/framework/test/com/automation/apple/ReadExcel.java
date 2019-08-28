package com.automation.framework.webapTestTools.reporting.com.automation.framework.test.com.automation.apple;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ReadExcel {

    static Fillo fillo = new Fillo();


    public static Object[][] readData(String filePath) throws Exception{
        filePath = "C:\\Users\\kapil-pc\\Desktop\\Java Practise\\AutoFramework\\src\\main\\resources\\AppleData.xlsx";
        Connection connection = fillo.getConnection(filePath);
        String strQuery = "Select * from Sheet1";
        Recordset recordset = connection.executeQuery(strQuery);
        String loginData[][] = null;

        int totalRows = recordset.getCount();
        int totalColumns = recordset.getFieldNames().size();

        loginData = new String[totalRows][totalColumns];

        int i=0;
        while (recordset.next()){
            for(int j=0;j<totalColumns;j++){
                loginData[i][j]=recordset.getField(j).value();
            }
            i++;
        }
        return(loginData);
    }

}
