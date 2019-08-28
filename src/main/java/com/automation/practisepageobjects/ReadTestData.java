package com.automation.practisepageobjects;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;


public class ReadTestData {
    static Fillo fillo = new Fillo();

    public static Object[][] readExcel(String excelFilePath) throws Exception {
        String filePath = "C:\\Users\\kapil-pc\\Desktop\\Java Practise\\AutoFramework\\src\\main\\resources\\LoginTestData.xlsx";
        String[][] loginData = null;
        Connection connection = fillo.getConnection(filePath);
        String strQuery = "Select * from Sheet1";
        Recordset recordset = connection.executeQuery(strQuery);

        int totalRows = recordset.getCount();
        int totalColumns = recordset.getFieldNames().size();
        loginData = new String[totalRows][totalColumns];
        int i = 0;
        while (recordset.next()) {
            for (int j = 0; j < totalColumns; j++) {
                loginData[i][j] = recordset.getField(j).value();
            }

            i++;
        }
        return (loginData);
    }

}
