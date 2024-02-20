package com.OHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Utility.Log;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserDefineMethods {
	WebDriver driver;
	String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";

@Given("^User should open Browser in the System$")
public void user_should_open_browser_in_the_system() {
    
	System.setProperty("webdriver.chrome.driver", "./browserdriverfiles/chromedriver.exe");
	driver = new ChromeDriver();

	Log.info(" *** Chrome Browser launched Successfully *****");
	   
}

@When("^User enters OrangeHRM Application URL Address$")
public void user_enters_orange_hrm_application_url_address() {
	driver.get(applicationUrlAddress);

	Log.info(" Successfully Provided OrangeHRM Application Url address on the Browser ");

	driver.manage().window().maximize();
}

@Then("^User should be navigated to OrangeHRM Application LogIn WebPage$")
public void user_should_be_navigated_to_orange_hrm_application_log_in_web_page() {
	String expected_OrangeHRMAplicationLogInPageTitle="OrangeHRM";
	Log.info(" The expected title of the OrangeHRm Application LogIn Page is :- "+expected_OrangeHRMAplicationLogInPageTitle);

	String actual_OrangeHRMAplicationLogInPageTitle=driver.getTitle();
	Log.info(" The actual title of the OrangeHRm Application LogIn Page is :- "+actual_OrangeHRMAplicationLogInPageTitle);

	if(actual_OrangeHRMAplicationLogInPageTitle.equals(expected_OrangeHRMAplicationLogInPageTitle))
	{
	Log.info("Successfully Navigated to OrangeHRM Application LogIn WebPage - PASS");
	}
	else
	{
	Log.info("Failed to Navigate to OrangeHRM Application LogIn WebPage - FAIL");
	}


	// Validating Text - LOGIN Panel

	String expected_OrangeHRMApplicationLogInPageText="LOGIN Panel";
	Log.info(" The Expected Text of the OrangeHRM Application LogIN Page is :- "+expected_OrangeHRMApplicationLogInPageText);

	// id="logInPanelHeading"
	By orangeHRMApplicationLogInPageTextProperty=By.id("logInPanelHeading");
	WebElement orangeHRMApplicationLogInPage=driver.findElement(orangeHRMApplicationLogInPageTextProperty);

	String actual_OrangeHRMApplicationLogInPageText=orangeHRMApplicationLogInPage.getText();
	Log.info(" The Actual Text of the OrangeHRM Application LogIN Page is :- "+actual_OrangeHRMApplicationLogInPageText);

	if(actual_OrangeHRMApplicationLogInPageText.equals(expected_OrangeHRMApplicationLogInPageText))
	{
	Log.info(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
	}
	else
	{
	Log.info(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
	}
   
}

@Then("^User should close the OrangeHRM Application along with the browser$")
public void user_should_close_the_orange_hrm_application_along_with_the_browser() {
	driver.quit();
	   Log.info("***** OrangeHRM Application along with the Browser closed Successfully ******");
    
}

}
