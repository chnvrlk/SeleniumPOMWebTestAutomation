package org.example.utilities;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;


public class Utilities {

    public static final int IMPLICIT_WAIT_TIME=10;

    public static String generateEmailWithTimeStamp(){
        Date date = new Date();
        String timeStamp= date.toString().replace(" ","_").replace(":","_");
        return "cihan"+ timeStamp +"@gmail.com";
    }

    public static Object[][] getTestDataFromExcel(String sheetName){

        File excelFile = new File
                (System.getProperty("user.dir")+"\\src\\main\\java\\org\\example\\testdata\\LoginTestData.xlsx");

        XSSFWorkbook workBook = null;

        try {
            FileInputStream fisExcel = new FileInputStream(excelFile);
            workBook = new XSSFWorkbook(fisExcel);
        }catch (Throwable e){
            e.printStackTrace();
        }

        XSSFSheet sheet = workBook.getSheet(sheetName);

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows][cols];

        for (int i=0;i<rows;i++){
            XSSFRow row = sheet.getRow(i+1);

            for (int j=0;j<cols;j++){
                XSSFCell cell = row.getCell(j);
                CellType cellType = cell.getCellType();

                switch (cellType){

                    case STRING:
                        data[i][j] = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        data[i][j] = Integer.toString((int)cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        data[i][j] = cell.getBooleanCellValue();
                        break;

                }


            }
        }

        return data;
    }



}
