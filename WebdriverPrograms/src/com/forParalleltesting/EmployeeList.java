package com.forParalleltesting;

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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Utility.Log;

public class EmployeeList extends BaseTest {

    // Test for login functionality
    @Test(priority = 1)
    public void loginFunctionality() {
        // Provide test data for username and locate the username element
        String userNameTestData = "NaveenPatel";
        By userNameProperty = By.id("txtUsername");
        WebElement userName = driver.findElement(userNameProperty);
        userName.sendKeys(userNameTestData);

        // Provide test data for password and locate the password element
        String passwordTestData = "Naveen@123";
        By passwordProperty = By.name("txtPassword");
        WebElement password = driver.findElement(passwordProperty);
        password.sendKeys(passwordTestData);

        // Locate and click the login button
        By logInButtonProperty = By.className("button");
        WebElement logInButton = driver.findElement(logInButtonProperty);
        logInButton.click();
    }

    // Test for performing mouse hover on PIM and clicking on Employee List
    @Test(priority = 2)
    public void pimMouseHover() throws InterruptedException {
    	
      
        Thread.sleep(5000);

        // Locate PIM element and perform a mouse hover
        By pimProperty = By.id("menu_pim_viewPimModule");
        WebElement pim = driver.findElement(pimProperty);
        Actions mouseHoverOperation = new Actions(driver);
        mouseHoverOperation.moveToElement(pim).build().perform();

        // Locate Employee List and click
        By employeeListProperty = By.id("menu_pim_viewEmployeeList");
        WebElement employeeList = driver.findElement(employeeListProperty);
        employeeList.click();
        
       // <a href="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/pim/viewEmployeeList?sortField=employeeId&amp;sortOrder=DESC" 
        	//	class="ASC">Id</a>
        
      
       By IDproperty = By.partialLinkText("Id");
       WebElement Idlist=driver.findElement(IDproperty);
       Idlist.click();
        		
        		
    }

    // Test for extracting data from a web table and writing it to an Excel file
    @Test(priority = 3)
    public void webTableData() throws IOException, InterruptedException {
      
     ;

        // Locate the web table element
        By webTableProperty = By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table");
        WebElement webTableData = driver.findElement(webTableProperty);

        // Read data from the Excel file
        FileInputStream testDataFile = new FileInputStream("./src/com/OrangeHRMApplicationTestResultfiles/OrangeHRM_EmployeeList.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(testDataFile);
        XSSFSheet testDataSheet = workbook.getSheet("EmployeeList");

        // Identify rows in the table
        By rowDataProperty = By.tagName("tr");
        List<WebElement> rowData = webTableData.findElements(rowDataProperty);

        for (int rowIndex = 1; rowIndex < rowData.size(); rowIndex++) {
            WebElement row = rowData.get(rowIndex);
            Row rows = testDataSheet.createRow(rowIndex);

            // Identify cells in each row
       	 
        	By  rowofcelldataProperty=By.tagName("td");
        	List<WebElement>rowofcelldata=row.findElements(rowofcelldataProperty);

            
            for(int rowofcell=0;rowofcell<rowofcelldata.size();rowofcell++)
        	{
        		WebElement cell=rowofcelldata.get(rowofcell);
        	    String	data=cell.getText();
        	    Log.info(data+" | ");
        	    Cell celldata=rows.createCell(rowofcell);
        	    celldata.setCellValue(data);

        		
        	}
            
        }

        // Write the data to the Excel file
        FileOutputStream testOutputFile = new FileOutputStream("./src/com/OrangeHRMApplicationTestResultfiles/OrangeHRM_EmployeeList.xlsx");
        workbook.write(testOutputFile);
        
     // Close the workbook to release resources
        workbook.close();
    }

    // Test for logging out from the application
    @Test(priority = 4)
    public void loginPanelAfterLogout() throws InterruptedException, IOException {
        // Locate the welcome button and click
        By welcomeButtonProperty = By.id("welcome");
        WebElement welcomeButton = driver.findElement(welcomeButtonProperty);
        welcomeButton.click();

        // Wait for some time and locate the logout button and click
        Thread.sleep(3000);
        By logoutButtonProperty = By.linkText("Logout");
        WebElement logoutButton = driver.findElement(logoutButtonProperty);
        logoutButton.click();
    }
}
