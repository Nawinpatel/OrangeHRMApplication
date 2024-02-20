package com.Orangehrm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class OrangeHrm_LoginFunctionality extends BaseTest {
	
	FileInputStream logInTestDataFile;
	XSSFWorkbook workBook;
	XSSFSheet logInTestDataSheet;
	Row testDataSheetRow;
	Cell rowOfCell;

	@Test(priority = 1)
	public void Login_functionality() throws IOException, InterruptedException {
		
		int attempts = 0;
		while (attempts < 3) {
		    try {   
		 logInTestDataFile = new FileInputStream("./src/com/Excelfiles/Excel.xlsx");
		 workBook = new XSSFWorkbook(logInTestDataFile);
		 logInTestDataSheet = workBook.getSheet("LogInTestData");
		
	        int rowCount=logInTestDataSheet.getLastRowNum();//FINDING CELL COUNT
			for(int rowIndex=1;rowIndex<=rowCount;rowIndex++){
		     testDataSheetRow=logInTestDataSheet.getRow(rowIndex);
			Cell userNameTestDataCell=testDataSheetRow.getCell(4);
			String userNameTestData=userNameTestDataCell.getStringCellValue();
		     rowOfCell=testDataSheetRow.getCell(5);
		    String passwordTestData=rowOfCell.getStringCellValue();
		     
		   
		    
			String expected_OrangeHRMApplicationLogInPageText="LOGIN Panel";
			System.out.println(" The Expected Text of the OrangeHRM Application Login Page is :- "+expected_OrangeHRMApplicationLogInPageText);
			By orangeHRMApplicationLogInPageTextProperty=By.id("logInPanelHeading");
			WebElement orangeHRMApplicationLogInPage=driver.findElement(orangeHRMApplicationLogInPageTextProperty);

			String actual_OrangeHRMApplicationLogInPageText=orangeHRMApplicationLogInPage.getText();
			System.out.println(" The Actual Text of the OrangeHRM Application Login Page is :- "+actual_OrangeHRMApplicationLogInPageText);

			if(actual_OrangeHRMApplicationLogInPageText.equals(expected_OrangeHRMApplicationLogInPageText)){
			System.out.println(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
			Cell testRowOfCell=testDataSheetRow.createCell(2);
			testRowOfCell.setCellValue("LOGIN Panel");
			}
			else{
			System.out.println(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
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
			logInButton.click();}
		    break;
	    } catch (NoSuchElementException e) {
	        // Handle the exception or add a delay
	        attempts++;
	    
	    }}}
	
	@Test(priority = 2)
	public void welComeAdmin() throws IOException, InterruptedException{
		
		try {
			By welComeAdminProperty=By.partialLinkText("Admin");
			WebElement welComeAdmin=driver.findElement(welComeAdminProperty);

			String expected_OrangeHRMApplicationHomePageText="Welcome";
			System.out.println(" The Expected Text of the OrangeHRM Application HomePage is :- "+expected_OrangeHRMApplicationHomePageText);

			String actual_OrangeHRMApplicationHomePageText=welComeAdmin.getText();
			System.out.println(" The Actual Text of the OrangeHRM Application HomePage is :- "+actual_OrangeHRMApplicationHomePageText);
			
			
			if(actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMApplicationHomePageText))
			{
			System.out.println(" Successfully Navigated to OrangeHRM Application HomePage - PASS ");
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
			System.out.println("Failed to Navigate to OrangeHRM Application HomePage - FAIL ");
			 System.out.println("OrangeHRMApplicationURLAddress is Not Matched:-FAIL ");
	    	 Cell testRowOfCell=testDataSheetRow.createCell(8);
	    	 testRowOfCell.setCellValue("Failed to Navigate to OrangeHRM Application HomePage:- FAIL ");
	         testRowOfCell=testDataSheetRow.createCell(7);
	         testRowOfCell.setCellValue("Not Matched");
			}}
			catch(NoSuchElementException Error )
			{
				System.out.println(""+Error);
			}
	}
		@Test(priority = 3)
		public void Invalidcredentials() {
		
		
		try {
	
	//<span id="spanMessage">Invalid credentials</span>
	By InvalidProperty=By.id("spanMessage");
	WebElement Invalidcredentials =driver.findElement(InvalidProperty);
	
	String expected_OrangeHRMApplicationLoginpageText="Invalid credentials";
	System.out.println(" The Expected Text of the OrangeHRM Application Loginpage is :- "+expected_OrangeHRMApplicationLoginpageText);

	String actual_OrangeHRMApplicationLoginPageText=Invalidcredentials.getText();
	System.out.println(" The Actual Text of the OrangeHRM Application Loginpage is :- "+actual_OrangeHRMApplicationLoginPageText);
	if(expected_OrangeHRMApplicationLoginpageText.equals(actual_OrangeHRMApplicationLoginPageText))
	{
		System.out.println("Failed to Navigate to OrangeHRM Application HomePage - Pass ");
		System.out.println("OrangeHRMApplicationURLAddress is Not Matched:-Pass ");
   	    Cell testRowOfCell=testDataSheetRow.createCell(3);
   	    testRowOfCell.setCellValue("Failed to Navigate to OrangeHRM Application HomePage:- Pass ");
        testRowOfCell=testDataSheetRow.createCell(1);
        testRowOfCell.setCellValue("Invalid credentials");
        
      //  File webPageScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//	FileUtils.copyFile(webPageScreenShot, new File("./OrangeHrmApplicationscreenshot/"+rowIndex+""+actual_OrangeHRMApplicationLoginPageText+".png"));
        
        
	}
	
	else
	{
		System.out.println(" Navigate to OrangeHRM Application HomePage - Fail ");
		System.out.println("OrangeHRMApplicationURLAddress is Matched:-Fail ");
   	    Cell testRowOfCell=testDataSheetRow.createCell(3);
   	    testRowOfCell.setCellValue(" Navigate to OrangeHRM Application HomePage:- Fail ");
        testRowOfCell=testDataSheetRow.createCell(1);
        testRowOfCell.setCellValue("Not Matched");
	}}
	
		
		catch(NoSuchElementException Error )
		{
			System.out.println(""+Error);
		}}
		
		@Test(priority = 4)
		public void AfterLogout() throws IOException {
			
	
	 
	    String expected_OrangeHRMApplicationLogInPageText="LOGIN Panel";
		 System.out.println(" The Expected Text of the OrangeHRM Application Login Page After Logout is :- "+expected_OrangeHRMApplicationLogInPageText);
		 By orangeHRMApplicationLogInPageTextProperty=By.id("logInPanelHeading");
		WebElement orangeHRMApplicationLogInPage=driver.findElement(orangeHRMApplicationLogInPageTextProperty);

	    String  actual_OrangeHRMApplicationLogInPageText=orangeHRMApplicationLogInPage.getText();
		System.out.println(" The Actual Text of the OrangeHRM Application Login Page  After Logout is :- "+actual_OrangeHRMApplicationLogInPageText);

		if(actual_OrangeHRMApplicationLogInPageText.equals(expected_OrangeHRMApplicationLogInPageText)){
		System.out.println(" Successfully Navigated to OrangeHRM Application LogIn Page After Logout- PASS ");
		Cell testRowOfCell=testDataSheetRow.createCell(11);
		testRowOfCell=testDataSheetRow.createCell(10);
		testRowOfCell.setCellValue ("Successfully Navigated to OrangeHRM Application LogIn Page After Logout - PASS");
		testRowOfCell.setCellValue("LOGIN Panel");}
		else{
		System.out.println(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page After Logout - FAIL");
		Cell testRowOfCell=testDataSheetRow.createCell(11);
		testRowOfCell.setCellValue ("Failed to Navigate to OrangeHRM Application LogIn PageAfter Logout - Fail");
		testRowOfCell=testDataSheetRow.createCell(10);
		testRowOfCell.setCellValue("Not Matched");}


	   FileOutputStream testResultFile = new FileOutputStream("./src/com/OrangeHRMApplicationTestResultfiles/OrangeHRMApplicationLogInTestResult.xlsx");
	   workBook.write(testResultFile);
	   
	   driver.navigate().refresh();
	
	}
		
		
}
		