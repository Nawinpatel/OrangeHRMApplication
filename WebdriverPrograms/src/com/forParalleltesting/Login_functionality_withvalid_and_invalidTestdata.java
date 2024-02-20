package com.forParalleltesting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.Utility.Log;

public class Login_functionality_withvalid_and_invalidTestdata extends BaseTest {
	
	@Test(priority = 1)
	public void Login_functionality() throws IOException, InterruptedException{
		
	
		 
	     
	FileInputStream logInTestDataFile = new FileInputStream("./src/com/Excelfiles/Excel.xlsx");
	XSSFWorkbook workBook = new XSSFWorkbook(logInTestDataFile);
	XSSFSheet logInTestDataSheet = workBook.getSheet("LogInTestData");
	
        int rowCount=logInTestDataSheet.getLastRowNum();//FINDING CELL COUNT
		for(int rowIndex=1;rowIndex<=rowCount;rowIndex++){
	    Row testDataSheetRow=logInTestDataSheet.getRow(rowIndex);
		Cell userNameTestDataCell=testDataSheetRow.getCell(4);
		String userNameTestData=userNameTestDataCell.getStringCellValue();
	    Cell rowOfCell=testDataSheetRow.getCell(5);
	    String passwordTestData=rowOfCell.getStringCellValue();
	
	String expected_OrangeHRMApplicationLogInPageText="LOGIN Panel";
	Log.info(" The Expected Text of the OrangeHRM Application Login Page is :- "+expected_OrangeHRMApplicationLogInPageText);
	By orangeHRMApplicationLogInPageTextProperty=By.id("logInPanelHeading");
	WebElement orangeHRMApplicationLogInPage=driver.findElement(orangeHRMApplicationLogInPageTextProperty);

	String actual_OrangeHRMApplicationLogInPageText=orangeHRMApplicationLogInPage.getText();
	Log.info(" The Actual Text of the OrangeHRM Application Login Page is :- "+actual_OrangeHRMApplicationLogInPageText);

	if(actual_OrangeHRMApplicationLogInPageText.equals(expected_OrangeHRMApplicationLogInPageText)){
	Log.info(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
	Cell testRowOfCell=testDataSheetRow.createCell(2);
	testRowOfCell.setCellValue("LOGIN Panel");
	}
	else{
	Log.info(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
	Cell testRowOfCell=testDataSheetRow.createCell(2);
	testRowOfCell.setCellValue("Not Matched");}

	By userNamePoperty=By.id("txtUsername"); 
	WebElement userName=driver.findElement(userNamePoperty); 
	userName.sendKeys(userNameTestData);
	
	By passwordProperty=By.name("txtPassword");
	WebElement password=driver.findElement(passwordProperty);
	password.sendKeys(passwordTestData);

	By logInButtonProperty=By.className("button");
	WebElement logInButton=driver.findElement(logInButtonProperty);
	logInButton.click();
	
	// <a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
		try {
			By welComeAdminProperty=By.partialLinkText("Admin");
			WebElement welComeAdmin=driver.findElement(welComeAdminProperty);

			String expected_OrangeHRMApplicationHomePageText="Welcome";
			Log.info(" The Expected Text of the OrangeHRM Application HomePage is :- "+expected_OrangeHRMApplicationHomePageText);

			String actual_OrangeHRMApplicationHomePageText=welComeAdmin.getText();
			Log.info(" The Actual Text of the OrangeHRM Application HomePage is :- "+actual_OrangeHRMApplicationHomePageText);
			
			
			if(actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMApplicationHomePageText))
			{
			Log.info(" Successfully Navigated to OrangeHRM Application HomePage - PASS ");
			Cell testRowOfCell=testDataSheetRow.createCell(8);
	    	testRowOfCell.setCellValue ("Successfully Navigated to OrangeHRM Application HomePage - pass");
	    	 
	    	 welComeAdmin.click();
	    	 testRowOfCell=testDataSheetRow.createCell(7);
	         testRowOfCell.setCellValue("Welcome");

	    	 Thread.sleep(2000);

	    	 By logOutProperty=By.linkText("Logout");
	    	 WebElement logOut=driver.findElement(logOutProperty);
	    	 logOut.click();

			}
			else
			{
			Log.info("Failed to Navigate to OrangeHRM Application HomePage - FAIL ");
			 Log.info("OrangeHRMApplicationURLAddress is Not Matched:-FAIL ");
	    	 Cell testRowOfCell=testDataSheetRow.createCell(8);
	    	 testRowOfCell.setCellValue("Failed to Navigate to OrangeHRM Application HomePage:- FAIL ");
	         testRowOfCell=testDataSheetRow.createCell(7);
	         testRowOfCell.setCellValue("Not Matched");
			}}
			catch(NoSuchElementException Error )
			{
				Log.info(""+Error);
			}
		
		try {
	
	//<span id="spanMessage">Invalid credentials</span>
	By InvalidProperty=By.id("spanMessage");
	WebElement Invalidcredentials =driver.findElement(InvalidProperty);
	
	String expected_OrangeHRMApplicationLoginpageText="Invalid credentials";
	Log.info(" The Expected Text of the OrangeHRM Application Loginpage is :- "+expected_OrangeHRMApplicationLoginpageText);

	String actual_OrangeHRMApplicationLoginPageText=Invalidcredentials.getText();
	Log.info(" The Actual Text of the OrangeHRM Application Loginpage is :- "+actual_OrangeHRMApplicationLoginPageText);
	if(expected_OrangeHRMApplicationLoginpageText.equals(actual_OrangeHRMApplicationLoginPageText))
	{
		Log.info("Failed to Navigate to OrangeHRM Application HomePage - Pass ");
		Log.info("OrangeHRMApplicationURLAddress is Not Matched:-Pass ");
   	    Cell testRowOfCell=testDataSheetRow.createCell(3);
   	    testRowOfCell.setCellValue("Failed to Navigate to OrangeHRM Application HomePage:- Pass ");
        testRowOfCell=testDataSheetRow.createCell(1);
        testRowOfCell.setCellValue("Invalid credentials");
        
        File webPageScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(webPageScreenShot, new File("./OrangeHrmApplicationscreenshot/"+rowIndex+""+actual_OrangeHRMApplicationLoginPageText+".png"));
        
        
	}
	
	else
	{
		Log.info(" Navigate to OrangeHRM Application HomePage - Fail ");
		Log.info("OrangeHRMApplicationURLAddress is Matched:-Fail ");
   	    Cell testRowOfCell=testDataSheetRow.createCell(3);
   	    testRowOfCell.setCellValue(" Navigate to OrangeHRM Application HomePage:- Fail ");
        testRowOfCell=testDataSheetRow.createCell(1);
        testRowOfCell.setCellValue("Not Matched");
	}}
	
		
		catch(NoSuchElementException Error )
		{
			Log.info(""+Error);
		}
	 
	     expected_OrangeHRMApplicationLogInPageText="LOGIN Panel";
		 Log.info(" The Expected Text of the OrangeHRM Application Login Page After Logout is :- "+expected_OrangeHRMApplicationLogInPageText);
		 orangeHRMApplicationLogInPageTextProperty=By.id("logInPanelHeading");
		 orangeHRMApplicationLogInPage=driver.findElement(orangeHRMApplicationLogInPageTextProperty);

	    actual_OrangeHRMApplicationLogInPageText=orangeHRMApplicationLogInPage.getText();
		Log.info(" The Actual Text of the OrangeHRM Application Login Page  After Logout is :- "+actual_OrangeHRMApplicationLogInPageText);

		if(actual_OrangeHRMApplicationLogInPageText.equals(expected_OrangeHRMApplicationLogInPageText)){
		Log.info(" Successfully Navigated to OrangeHRM Application LogIn Page After Logout- PASS ");
		Cell testRowOfCell=testDataSheetRow.createCell(11);
		Cell testRowOfCells=testDataSheetRow.createCell(10);
		testRowOfCell.setCellValue ("Successfully Navigated to OrangeHRM Application LogIn Page After Logout - PASS");
		testRowOfCells.setCellValue("LOGIN Panel");}
		else{
		Log.info(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page After Logout - FAIL");
		Cell testRowOfCell=testDataSheetRow.createCell(11);
		testRowOfCell.setCellValue ("Failed to Navigate to OrangeHRM Application LogIn PageAfter Logout - Fail");
		testRowOfCell=testDataSheetRow.createCell(10);
		testRowOfCell.setCellValue("Not Matched");}


	   FileOutputStream testResultFile = new FileOutputStream("./src/com/OrangeHRMApplicationTestResultfiles/OrangeHRMApplicationLogInTestResult.xlsx");
	   workBook.write(testResultFile);
	
	}}}