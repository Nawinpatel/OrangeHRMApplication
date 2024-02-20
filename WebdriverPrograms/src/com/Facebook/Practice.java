package com.Facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {
	
	
	public static void main(String[] args) {
		
		 String FacebookUrlAddress="https://www.facebook.com";
			System.setProperty("webdriver.chrome.driver", "./browserdriverfiles/chromedriver.exe");
	        ChromeDriver Driver=new ChromeDriver();
			Driver.get(FacebookUrlAddress);
		
			String expected_FacebookApplicationLoginpageTitle="Facebook";
			System.out.println("The expected Title of the facebook Application login webpage is:-"+expected_FacebookApplicationLoginpageTitle);
			
			String Actual_FacebookApplicationLoginpageTitle=Driver.getTitle();
			System.out.println("The Actual Title of the facebook Application login webpage is:-"+Actual_FacebookApplicationLoginpageTitle);
			
			if(Actual_FacebookApplicationLoginpageTitle.contains(expected_FacebookApplicationLoginpageTitle)) {
				System.out.println("successfully Navigated to FacebookApplication Login page:-Pass ");
			}
			else {
				System.out.println("successfully Navigated to FacebookApplication Login page:-Fail");
			}
			String expeected_FacebookcurrentUrlAddress="https://www.facebook.com";
			System.out.println("The expected Title of thre FacebookcurrentUrlAddress is:-"+expeected_FacebookcurrentUrlAddress);
			
			String Actual_FacebookcurrentUrlAddress=Driver.getCurrentUrl();
			System.out.println("The expected Title of the FacebookcurrentUrlAddress is:-"+Actual_FacebookcurrentUrlAddress);
			
			if(Actual_FacebookcurrentUrlAddress.contains(expeected_FacebookcurrentUrlAddress)) {
				System.out.println("Successfully Naviagated to FacebookApplication Login page:-pass");
				}
			else {
				System.out.println("Failed Navigate to FacebookApplication Login page:-Fail");
			}
			
		//	<input type="text" class="inputtext _55r1 _6luy" name="email" id="email" data-testid="royal_email" placeholder="Email address or phone number" autofocus="1" aria-label="Email address or phone number">
	       //  Driver.findElement(By.id("email")).sendKeys("6304017062"); 
	         
	          By Email=By.id("email");
	          WebElement Username =Driver.findElement(Email);
	          Username.sendKeys("6304017062");
	          
	         
	      //<input type="password" class="inputtext _55r1 _6luy _9npi" name="pass" id="pass" data-testid="royal_pass" placeholder="Password" aria-label="Password">
	      // Driver.findElement(By.id("pass")).sendKeys("9490580006"); 
	       
	       
	       By passwordProperty =By.id("pass");
	        WebElement password  =Driver.findElement(passwordProperty);
	        password.sendKeys("9490580006");
	       
	       
	       
		//<button value="1" class="_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy" name="login" data-testid="royal_login_button" type="submit" id="u_0_5_f7">Log in</button>
	     // Driver.findElement(By.name("login")).click();
	      
		             By  loginProperty =By.name("login");
		             WebElement  login  =Driver.findElement(loginProperty);
		              login.submit();
		                        
		                        
		//      //     <image style="height:40px;width:40px" x="0" y="0" height="100%" preserveAspectRatio="xMidYMid slice" 
		 //  width="100%" xlink:href="https://scontent.fbpm1-2.fna.fbcdn.net/v/t1.6435-1/52494554_807931236211705_6480828190481711104_n.jpg?stp=cp0_dst-jpg_p60x60&amp;_nc_cat=108&amp;ccb=1-7&amp;_nc_sid=2b6aad&amp;_nc_ohc=Vf037ZTu7REAX8EYu_Q&amp;_nc_ht=scontent.fbpm1-2.fna&amp;oh=00_AfDEdJ4-ZwUNNQWyQPEelywN3xCPsRojYA81POyYkHvCOw&amp;oe=65D071D3"></image>                        
		                        
		                        
		            //   String Imagelinkproperty="<image style=\"height:40px;width:40px\"";       
		                        
		                 //By Image_link =By.xpath(Imagelinkproperty);		                        
		                        
		                        
		                        
		 
	 		  	       //  Driver.quit();
		  
			
	}

}
