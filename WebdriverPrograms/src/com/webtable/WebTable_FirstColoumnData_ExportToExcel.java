package com.webtable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebTable_FirstColoumnData_ExportToExcel extends BaseTestWeb {

@Test
public void excel_ExportFirstColumnData() throws IOException
{

FileInputStream testDataFile = new FileInputStream("./src/com/Excelfiles/Singledata.xlsx");
XSSFWorkbook workBook = new XSSFWorkbook(testDataFile);
XSSFSheet testDataSheet = workBook.getSheet("Sheet1");


for(int rowIndex=0;rowIndex<=36;rowIndex++)
{
Row newRow=testDataSheet.createRow(rowIndex);
Cell newRowOfCell=newRow.createCell(0);

By webTableCityNameProperty=By.xpath
("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+rowIndex+1+"]/td[1]");
WebElement cityName=driver.findElement(webTableCityNameProperty);
String cityName_Text=cityName.getText();
System.out.println(" The CityName is :- "+cityName_Text);

newRowOfCell.setCellValue(cityName_Text);

FileOutputStream testOutPutFile = new FileOutputStream("./src/com/Excelfiles/Singledata.xlsx");
workBook.write(testOutPutFile);
workBook.close();
}

}

}













