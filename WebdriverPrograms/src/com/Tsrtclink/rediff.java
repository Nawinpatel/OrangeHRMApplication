package com.Tsrtclink;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class rediff {
	
	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver;
		String applicationUrlAddress="https://register.rediff.com/register/register.php?FormName=user_details";

	//	System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		

		driver = new ChromeDriver();
		driver.get(applicationUrlAddress);
		
		//<input type="text" onblur="fieldTrack(this);" name="namef1d65de1" value="" style="width:185px;" maxlength="61">
		
		///html/body/center/form/div/table[2]/tbody/tr[3]/td[3]/input
		
   //  WebElement FullName =driver.findElement(By.xpath("html/body/center/form/div/table[2]/tbody/tr[3]/td[3]/input"));
		WebElement name=driver.findElement(By.name("name02b5ece4"));
		Thread.sleep(3000);
		name.sendKeys("NAvven");
		/*
		 * JavascriptExecutor js=(JavascriptExecutor)driver;
		 * js.executeScript("argument[0].click();",name);
		 */
   //  FullName.sendKeys("Naveen Patel");
     System.out.println("Successfully Printed Fullname");
       
     Thread.sleep(3000);
     driver.close();
}}
