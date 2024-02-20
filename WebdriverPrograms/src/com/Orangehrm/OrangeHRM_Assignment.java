package com.Orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class OrangeHRM_Assignment {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver Driver;
       	String  ApplicationURLAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
				
		 System.setProperty("webdriver.gecko.driver", "./browserdriverfiles/geckodriver.exe");
		  Driver =new FirefoxDriver();
		  
		  //	System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
			// ChromeDriver driver = new ChromeDriver();

			// driver = new ChromeDriver();
			 
		 
		 Driver.get(ApplicationURLAddress);
		
		 System.out.println();
		 System.out.println("Verifying And validating of OrangeHRM Application Login PageTitle");
		 System.out.println();
		
		
		 String Expected_OrangeHRMApplicationPageTitle ="OrangeHRM";
		 System.out.println("The Expected Title Of OrangeHRM Application Login Web page is :-"+Expected_OrangeHRMApplicationPageTitle);
		 
		 String Actual_OrangeHRMApplicationpageTitle=Driver.getTitle();
		 System.out.println("The Actual   Title of OrangeHRM Application Login Web page is :-"+Actual_OrangeHRMApplicationpageTitle);
		 
		 if(Actual_OrangeHRMApplicationpageTitle.equals(Expected_OrangeHRMApplicationPageTitle))
		 {
			 System.out.println("SuccessFully Navigated to OrangeHRM Application WebPage:-Pass");
		 }
		 else
		 {
			 System.out.println("Failed to Navigate to OrangeHRM Application WebPage:-Fail ");
		 }
		 System.out.println();
		 System.out.println("Verifying And validating of OrangeHRMApplicationURLAddress");
		 System.out.println();
		 
		 String Expected_OrangeHRMApplicationURLAddress="orangehrm-4.2.0.1";
		 System.out.println("The Expected URLAddress of OrangeHRMApplication is:- "+Expected_OrangeHRMApplicationURLAddress);
		 String Actual_OrangeHRMApplicationURLAddress=Driver.getCurrentUrl();
		 System.out.println("The Actual   URLAddress of OrangeHRMApplication is:- "+Actual_OrangeHRMApplicationURLAddress);
		 if (Actual_OrangeHRMApplicationURLAddress.contains(Expected_OrangeHRMApplicationURLAddress))
		 {
	        	System.out.println("OrangeHRM Application URLAddress is Matched:- Pass");
	        
	     }
	     else
	     {
	        	System.out.println("OrangeHRMApplicationURLAddress is Not Matched:- Fail");
	     }
		 
		                 //<div id="logInPanelHeading">LOGIN Panel</div>
		 
		 System.out.println();
		 System.out.println("Verifying And validating of Login panel");
		 System.out.println();
		   
		 By LoginPanelProperty=By.id("logInPanelHeading");
		 WebElement loginPanelHeading=Driver.findElement(LoginPanelProperty);
		 String LoginPanel=loginPanelHeading.getText();
		 System.out.println("The Text of webpage Title is :-"+LoginPanel);
		
		  String Expected_loginpanelheading="LOGIN Panel";
		  System.out.println("The Expected Login Panel Heading is :-"+Expected_loginpanelheading);
		  String Actual_loginpanelheading =loginPanelHeading.getText();
		  System.out.println("The Actual   Login Panel Heading is :-"+Actual_loginpanelheading);
		  if(Actual_loginpanelheading.equals(Expected_loginpanelheading))
		  {
			  System.out.println("The Login Panel Heading is Matched :- Pass");
		  }
		  else 
		  {
			  System.out.println("The LoginPanel Heading is Not Matched:- Fail");
	      }
		  
		  // <input name="txtUsername" id="txtUsername" type="text">
          String UserNameTestData ="Naveenpatel";          
          By UserNameProperty=By.id("txtUsername");
          WebElement UserName =Driver.findElement(UserNameProperty);  
          UserName.sendKeys(UserNameTestData);
      
          //  <input name="txtPassword" id="txtPassword" auto complete ="off" type="password">
      
          String PasswordTestData="Naveen@123";
          By PasswordProperty =By.id("txtPassword");
          WebElement Password=Driver.findElement(PasswordProperty);
          Password.sendKeys(PasswordTestData);
          
          //<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
        
          By LogInButtonProperty=By.className("button");
          WebElement LoginButton=Driver.findElement(LogInButtonProperty);
          LoginButton.click();
          
          System.out.println();
 		  System.out.println("Verifying And validating of OrangeHRM Application Homepage PageTitle ");
 		  System.out.println();
		  
          
          String Expected_OrangeHRMApplicationHomepagePageTitle="OrangeHRM";
	 	  System.out.println("The Expected Title of the OrangeHRM Application Homepage Web page is:-"+Expected_OrangeHRMApplicationHomepagePageTitle);
	 		
	 	  String Actual_OrangeHRMApplicationHomepagePageTitle=Driver.getTitle();
	 	  System.out.println("The Actual   Title of the OrangeHRM Application Homepage Web page is:-"+Actual_OrangeHRMApplicationHomepagePageTitle);
	 		
	 	  if (Actual_OrangeHRMApplicationHomepagePageTitle.contains(Expected_OrangeHRMApplicationHomepagePageTitle))
	 	  {
	 			System.out.println("Successfully Navigated to OrangeHRM Application Homepage Web page:- PASS");
	 	  }
	 	  else
	 	  {
	 			System.out.println("Successfully Navigated to OrangeHRM Application Homepage Web page:- Fail");	
	 			
	 	  }
	 	  
	 	  System.out.println();
 		  System.out.println("Valiadte welcome  ");
 		  System.out.println(); 
 		  
	 	   // <a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
	 	  
   	   	 By WelcomeAdminProperty=By.id("welcome");
		 WebElement WelcomeAdminHeading=Driver.findElement(WelcomeAdminProperty);
		 String WelcomeAdmin=WelcomeAdminHeading.getText();
		 System.out.println("The Text of webpage Title is :-"+WelcomeAdmin);
		
		  String Expected_WelcomeAdminheading="Welcome";
		  System.out.println("The Expected Welcome Admin Heading is :-"+Expected_WelcomeAdminheading);
		  String Actual_WelcomeAdminheading =WelcomeAdminHeading.getText();
		  System.out.println("The  Actual  Welcome Admin Heading is :-"+Actual_WelcomeAdminheading);
		  if(Actual_WelcomeAdminheading.contains(Expected_WelcomeAdminheading))
		  {
			  System.out.println("The Welcome Admin Heading is Matched :- Pass");
		  }
		  else 
		  {
			  System.out.println("The Welcome Admin Heading is Not Matched:- Fail");
	      }
		     
	 		  //<a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
		     
	 	   By WelComeButtonProperty=By.id("welcome");
           WebElement WelcomeButton=Driver.findElement(WelComeButtonProperty);
           WelcomeButton.click();		 
		 
           //<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
           
           Thread.sleep(3000);
           
           By LogoutButtonProperty=By.linkText("Logout");
           WebElement LogOutButton=Driver.findElement(LogoutButtonProperty);
           LogOutButton.click();
           
          Expected_OrangeHRMApplicationPageTitle ="OrangeHRM";
  		 System.out.println("The Expected Title Of OrangeHRM Application Login Web page is :-"+Expected_OrangeHRMApplicationPageTitle);
  		 
  		  Actual_OrangeHRMApplicationpageTitle=Driver.getTitle();
  		 System.out.println("The Actual   Title of OrangeHRM Application Login Web page is :-"+Actual_OrangeHRMApplicationpageTitle);
  		 
  		 if(Actual_OrangeHRMApplicationpageTitle.equals(Expected_OrangeHRMApplicationPageTitle))
  		 {
  			 System.out.println("SuccessFully Navigated to OrangeHRM Application WebPage:-Pass");
  		 }
  		 else
  		 {
  			 System.out.println("Failed to Navigate to OrangeHRM Application WebPage:-Fail ");
  		 }
  		 System.out.println();
  		 System.out.println("Verifying And validating of OrangeHRMApplicationURLAddress");
  		 System.out.println();
  		 
  		  Expected_OrangeHRMApplicationURLAddress="orangehrm-4.2.0.1";
  		 System.out.println("The Expected URLAddress of OrangeHRMApplication is:- "+Expected_OrangeHRMApplicationURLAddress);
  		  Actual_OrangeHRMApplicationURLAddress=Driver.getCurrentUrl();
  		 System.out.println("The Actual   URLAddress of OrangeHRMApplication is:- "+Actual_OrangeHRMApplicationURLAddress);
  		 if (Actual_OrangeHRMApplicationURLAddress.contains(Expected_OrangeHRMApplicationURLAddress))
  		 {
  	        	System.out.println("OrangeHRM Application URLAddress is Matched:- Pass");
  	        
  	     }
  	     else
  	     {
  	        	System.out.println("OrangeHRMApplicationURLAddress is Not Matched:- Fail");
  	     }
  		 
  		                 //<div id="logInPanelHeading">LOGIN Panel</div>
  		 
  		 System.out.println();
  		 System.out.println("Verifying And validating of Login panel");
  		 System.out.println();
  		   
  		  LoginPanelProperty=By.id("logInPanelHeading");
  		 loginPanelHeading=Driver.findElement(LoginPanelProperty);
  		  LoginPanel=loginPanelHeading.getText();
  		 System.out.println("The Text of webpage Title is :-"+LoginPanel);
  		
  		   Expected_loginpanelheading="LOGIN Panel";
  		  System.out.println("The Expected Login Panel Heading is :-"+Expected_loginpanelheading);
  		   Actual_loginpanelheading =loginPanelHeading.getText();
  		  System.out.println("The Actual   Login Panel Heading is :-"+Actual_loginpanelheading);
  		  if(Actual_loginpanelheading.equals(Expected_loginpanelheading))
  		  {
  			  System.out.println("The Login Panel Heading is Matched :- Pass");
  		  }
  		  else 
  		  {
  			  System.out.println("The LoginPanel Heading is Not Matched:- Fail");
  	      }
           
        
  		  
           
           
		 
		 
		 
		   Driver.quit();
		
		
		
		
		
	}
	

}
