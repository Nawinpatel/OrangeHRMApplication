package com.OrangeHRMApplicationPagesTests;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.BaseTest.BaseTest;
import com.OrangeHRMApplicationPages.LogInPage;

public class LogInPageTest extends BaseTest
{

@Test(priority=1,description=" Validating OrangeHRM Application LogIN Page Text")
public void orangeHRMApplicationLogInPage_logInPannelTextTest()
{

LogInPage logInPage = new LogInPage();
logInPage.orangeHRMApplicationLogInPage_logInPannelTextValidation();

}


@Test(priority=2,description=" Validating OrangeHRM Applicaiton LogIn Page Logo ")
public void orangeHRMApplicationLogInPage_LogoValidationTest()
{
LogInPage logInPage = new LogInPage();
logInPage.orangeHRMApplicationLogInPageLogoValidation();
}

@Test(priority=3,description=" Validating OrangeHRM Applicaiton LogIn Functionality ")
public void orangeHRMApplicationLogInPage_LogInTest() throws IOException, InterruptedException
{
	
	FileInputStream logInTestDataFile = new FileInputStream("./src/main/java/com/OrangeHRMApplicationTestDataFiles/Excel.xlsx");
	XSSFWorkbook workBook = new XSSFWorkbook(logInTestDataFile);
	XSSFSheet logInTestDataSheet = workBook.getSheet("LogInTestData");

	    int rowCount=logInTestDataSheet.getLastRowNum();
		for(int rowIndex=1;rowIndex<=rowCount;rowIndex++){
	    Row testDataSheetRow=logInTestDataSheet.getRow(rowIndex);
		Cell userNameTestDataCell=testDataSheetRow.getCell(4);
		 String userNameTestData=userNameTestDataCell.getStringCellValue();
	    Cell rowOfCell=testDataSheetRow.getCell(5);
	   String  passwordTestData=rowOfCell.getStringCellValue(); 
	
LogInPage logInPage = new LogInPage();
logInPage.orangeHRMApplicationLogInPage_logInValdiation(userNameTestData, passwordTestData);
}


}}
