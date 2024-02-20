package com.OrangeHRMApplicationPages;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseTest.BaseTest;
import com.Utility.Log;

public class LogInPage extends BaseTest {

// Object Repository Class

// <div id="logInPanelHeading">LOGIN Panel</div>

// WebElement logInPanelText=driver.findElement(By.id("logInPanelHeading"));

// 1. Identification of WebElements
// 2.  Performing Operation on the WebElements - Business Logics

// @FindBy - is an Annotion - works smilar to findElement method

public LogInPage() // Constructor - When a Class Name is similar to the Method Name
{

PageFactory.initElements(driver,this );
}


// 1. Identification of WebElements
@FindBy(id="logInPanelHeading")
WebElement logInPanelText;

// 2.  Performing Operation on the WebElements - Business Logics(user defined method)
public void orangeHRMApplicationLogInPage_logInPannelTextValidation()
{

String expected_OrangeHRMApplicationLogInPageLogInPannelText="LOGIN Panel";

//System.out.println(" The Expected Text of the WebElement LogIn Pannel is :- "+expected_OrangeHRMApplicationLogInPageLogInPannelText);
Log.info(" The Expected Text of the WebElement LogIn Pannel is :- "+expected_OrangeHRMApplicationLogInPageLogInPannelText);

String actual_OrangeHRMApplicationLogInPageLogInPannelText=logInPanelText.getText();
//System.out.println(" The Actual Text of the WebElement LogIn Pannel is :- "+actual_OrangeHRMApplicationLogInPageLogInPannelText);
Log.info(" The Actual Text of the WebElement LogIn Pannel is :- "+actual_OrangeHRMApplicationLogInPageLogInPannelText);

if(actual_OrangeHRMApplicationLogInPageLogInPannelText.equals(expected_OrangeHRMApplicationLogInPageLogInPannelText))
{
Log.info(" LogIn Pannel Text Validation Successful - PASS");
}
else
{
Log.info(" LogIn Pannel Text Validation NOT Successful - FAIL");
}

}


// OrangeHRM Application WebElement Property
// /html/body/div[1]/div/div[2]/div/img

@FindBy(xpath="/html/body/div[1]/div/div[2]/div/img")
WebElement orangeHRMApplicationLogInPageLogo;


public void orangeHRMApplicationLogInPageLogoValidation()
{

boolean flag=orangeHRMApplicationLogInPageLogo.isDisplayed();

if(flag)
{
// System.out.println(" OrangeHRM Applicaiton LogIn page Logo found - PASS ");
Log.info(" OrangeHRM Applicaiton LogIn page Logo found - PASS ");
}
else
{
Log.info(" OrangeHRM Applicaiton LogIn page Logo NOT found - FAIL ");
}

}


// id="txtUsername"

@FindBy(id="txtUsername")
WebElement userName;


// name="txtPassword"
@FindBy(name="txtPassword")
WebElement password;

// class="button"
@FindBy(className="button")
WebElement logInButton;



public void orangeHRMApplicationLogInPage_logInValdiation(String UserName,String Password) throws InterruptedException, IOException
{
userName.sendKeys(UserName);
password.sendKeys(Password);
logInButton.click();


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
//	Cell testRowOfCell=testDataSheetRow.createCell(8);
	//testRowOfCell.setCellValue ("Successfully Navigated to OrangeHRM Application HomePage - pass");
	 
	 welComeAdmin.click();
	// testRowOfCell=testDataSheetRow.createCell(7);
    // testRowOfCell.setCellValue("Welcome");

	 Thread.sleep(2000);

	 By logOutProperty=By.linkText("Logout");
	 WebElement logOut=driver.findElement(logOutProperty);
	 logOut.click();

	}
	else
	{
	Log.info("Failed to Navigate to OrangeHRM Application HomePage - FAIL ");
	 Log.info("OrangeHRMApplicationURLAddress is Not Matched:-FAIL ");
	/* Cell testRowOfCell=testDataSheetRow.createCell(8);
	 testRowOfCell.setCellValue("Failed to Navigate to OrangeHRM Application HomePage:- FAIL ");
     testRowOfCell=testDataSheetRow.createCell(7);
     testRowOfCell.setCellValue("Not Matched");*/
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
/*   Cell testRowOfCell=testDataSheetRow.createCell(3);
   testRowOfCell.setCellValue("Failed to Navigate to OrangeHRM Application HomePage:- Pass ");
testRowOfCell=testDataSheetRow.createCell(1);
testRowOfCell.setCellValue("Invalid credentials");*/

//File webPageScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//FileUtils.copyFile(webPageScreenShot, new File("./OrangeHrmApplicationscreenshot/"+rowIndex+""+actual_OrangeHRMApplicationLoginPageText+".png"));


}

else
{
Log.info(" Navigate to OrangeHRM Application HomePage - Fail ");
Log.info("OrangeHRMApplicationURLAddress is Matched:-Fail ");
  /* Cell testRowOfCell=testDataSheetRow.createCell(3);
   testRowOfCell.setCellValue(" Navigate to OrangeHRM Application HomePage:- Fail ");
testRowOfCell=testDataSheetRow.createCell(1);
testRowOfCell.setCellValue("Not Matched");*/
}}


catch(NoSuchElementException Error )
{
	Log.info(""+Error);
}

// Log Message
}



}