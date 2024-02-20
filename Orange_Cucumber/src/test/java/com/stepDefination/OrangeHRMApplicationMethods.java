package com.stepDefination;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Utility.Log;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRMApplicationMethods
{

public static WebDriver driver;
String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";

@Given("^User should open Browser in the System$")
public void user_should_open_browser_in_the_system()
{

//System.setProperty("webdriver.chrome.driver", "./browserdriverfiles/chromedriver.exe");
driver = new ChromeDriver();

System.out.println(" *** Chrome Browser launched Successfully *****");
   
}

@When("User enters OrangeHRM Application URL Address")
public void user_enters_orange_hrm_application_url_address()
{
driver.get(applicationUrlAddress);

System.out.println(" Successfully Provided OrangeHRM Application Url address on the Browser ");

driver.manage().window().maximize();
}




@Then("^User should enter userName and password and click on login button$")
public void user_should_enter_userName_and_password_and_click_on_login_button()
{


String userNameTestData="NaveenPatel"; 
By userNamePoperty=By.id("txtUsername"); 
WebElement userName=driver.findElement(userNamePoperty); 
userName.sendKeys(userNameTestData); 

String passwordTestData="Naveen@123";
By passwordProperty=By.name("txtPassword");
WebElement password=driver.findElement(passwordProperty);
password.sendKeys(passwordTestData);

By logInButtonProperty=By.className("button");
WebElement logInButton=driver.findElement(logInButtonProperty);
logInButton.click();

}

@Then("^User should be navigated to OrangeHRM Application HomePage$")
public void user_should_be_navigated_to_OrangeHRM_Application_HomePage()
{

By welComeAdminProperty=By.partialLinkText("Admin");

WebElement welComeAdmin=driver.findElement(welComeAdminProperty);

String expected_OrangeHRMApplicationHomePageText="Welcome";
System.out.println(" The Expected Text of the OrangeHRM Application HomePage is :- "+expected_OrangeHRMApplicationHomePageText);

String actual_OrangeHRMApplicationHomePageText=welComeAdmin.getText();
System.out.println(" The Actual Text of the OrangeHRM Application HomePage is :- "+actual_OrangeHRMApplicationHomePageText);

if(actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMApplicationHomePageText))
{
System.out.println(" Successfully Navigated to OrangeHRM Application HomePage - PASS ");
}
else
{
System.out.println("Failed to Navigate to OrangeHRM Application HomePage - FAIL ");
}



}

@Then("^User should click on WelCome Admin and click on Logout$")
public void user_should_click_on_WelCome_Admin_and_click_on_Logout() throws InterruptedException
{
By welComeAdminProperty=By.partialLinkText("Admin");

WebElement welComeAdmin=driver.findElement(welComeAdminProperty);
welComeAdmin.click();

Thread.sleep(5000);


By logOutProperty=By.linkText("Logout");
WebElement logOut=driver.findElement(logOutProperty);
logOut.click();
}




@Then("User should be navigated to OrangeHRM Application LogIn WebPage")
public void user_should_be_navigated_to_orange_hrm_application_log_in_web_page()
{

String expected_OrangeHRMAplicationLogInPageTitle="OrangeHRM";
System.out.println(" The expected title of the OrangeHRm Application LogIn Page is :- "+expected_OrangeHRMAplicationLogInPageTitle);

String actual_OrangeHRMAplicationLogInPageTitle=driver.getTitle();
System.out.println(" The actual title of the OrangeHRm Application LogIn Page is :- "+actual_OrangeHRMAplicationLogInPageTitle);

if(actual_OrangeHRMAplicationLogInPageTitle.equals(expected_OrangeHRMAplicationLogInPageTitle))
{
System.out.println("Successfully Navigated to OrangeHRM Application LogIn WebPage - PASS");
}
else
{
System.out.println("Failed to Navigate to OrangeHRM Application LogIn WebPage - FAIL");
}


// Validating Text - LOGIN Panel

String expected_OrangeHRMApplicationLogInPageText="LOGIN Panel";
System.out.println(" The Expected Text of the OrangeHRM Application LogIN Page is :- "+expected_OrangeHRMApplicationLogInPageText);

// id="logInPanelHeading"
By orangeHRMApplicationLogInPageTextProperty=By.id("logInPanelHeading");
WebElement orangeHRMApplicationLogInPage=driver.findElement(orangeHRMApplicationLogInPageTextProperty);

String actual_OrangeHRMApplicationLogInPageText=orangeHRMApplicationLogInPage.getText();
System.out.println(" The Actual Text of the OrangeHRM Application LogIN Page is :- "+actual_OrangeHRMApplicationLogInPageText);

if(actual_OrangeHRMApplicationLogInPageText.equals(expected_OrangeHRMApplicationLogInPageText))
{
System.out.println(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
}
else
{
System.out.println(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
}
 
}





@Then("User should close the OrangeHRM Application along with the browser")
public void user_should_close_the_orange_hrm_application_along_with_the_browser()
{
   driver.quit();
   System.out.println("***** OrangeHRM Application along with the Browser closed Successfully ******");
}



}
