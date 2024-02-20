package com.GetAttribute;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttribute {
	
	
	
	
	public static void main(String[] args) {

		String applicationUrlAddress="http://google.com";

		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get(applicationUrlAddress);

		// <a class="gb_Aa gb_kd gb_Md gb_le" aria-label="Sign in"
		// href="https://accounts.google.com/ServiceLogin?hl=en&amp;passive=true&amp;continue=https://www.google.com/&amp;ec=GAZAmgQ"
		// target="_top"><span class="gb_Id">Sign in</span></a>

		By signInProperty=By.linkText("Sign in");
		WebElement signIn=driver.findElement(signInProperty);

		String signInHrefAttributeValue=signIn.getAttribute("href");
		System.out.println(" The href Attribute value of SignIn WebElement is :- "+signInHrefAttributeValue);

		// Performing Click on the Sign In WebElement
		signIn.click();

		String webPageUrlAddress=driver.getCurrentUrl();
		System.out.println(" The WebPage Url Address is :- "+webPageUrlAddress);

		//if(webPageUrlAddress.equals(signInHrefAttributeValue))
		//if(webPageUrlAddress.contains(signInHrefAttributeValue))
		if(signInHrefAttributeValue.contains(webPageUrlAddress))
		{
		System.out.println(" Url Matched - PASS ");
		}
		else
		{
		System.out.println(" Url NOT Matched - FAIL ");
		}

		driver.quit();
		}
	
	
	
	
	
	
	
	
	
	
	
	

}
