package com.webtable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CapturingCompleteWebTableData extends BaseTestWeb {

    @Test(priority = 1, description = "Capturing Complete WebTable data from World Clock WebTable")
    public void dynamicWebTableData() throws IOException, InterruptedException {
        // Identify the web table
        By webtableProperty = By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody");
        WebElement webTable = driver.findElement(webtableProperty);

        // Read test data from Excel
        FileInputStream testData = new FileInputStream("./src/com/Excelfiles/Fulldynamicdata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(testData);
        XSSFSheet testDataSheet = workbook.getSheet("webtabledata");

        // Identify the rows of the web table
        By webTableRowProperty = By.tagName("tr");
        List<WebElement> rows = webTable.findElements(webTableRowProperty);

        // Iterate through all rows of the web table
        for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
            WebElement row = rows.get(rowIndex);
            Row rowData = testDataSheet.createRow(rowIndex);

            // Identify the cells in the current row
            By webTableRowOfCellProperty = By.tagName("td");
            List<WebElement> rowOfCellData = row.findElements(webTableRowOfCellProperty);

            // perform through all cells in the current row
            for (int cellIndex = 0; cellIndex < rowOfCellData.size(); cellIndex++) {
                WebElement webTableRowOfCell = rowOfCellData.get(cellIndex);

                // Get data from the cell
                String data = webTableRowOfCell.getText();
                System.out.print(data + " | ");

                // Write data to the corresponding cell in Excel
                Cell cellData = rowData.createCell(cellIndex);
                cellData.setCellValue(data);
            }
            System.out.println();
        }

        // Save changes to the Excel file
        FileOutputStream testOutputFile = new FileOutputStream("./src/com/Excelfiles/Fulldynamicdata.xlsx");
        workbook.write(testOutputFile);
         
       // Close the workbook and release resources
        workbook.close();
        testData.close();
        testOutputFile.close();

    }
}
