package com.Alert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tsrtc_HandlingAlert {

WebDriver driver;

String applicationUrlAddress="https://www.tsrtconline.in/oprs-web/";

@BeforeTest
public void setUp()
{

System.setProperty("webdriver.chrome.driver", "./chromeBrowser/chromedriver.exe");
driver = new ChromeDriver();

driver.get(applicationUrlAddress);

driver.manage().window().maximize();

}

/*
@AfterTest
public void tearDown()
{
driver.quit();
}
*/
@Test
public void hadlingAlert() throws InterruptedException
{
// id="searchBtn"
By checkAvailabilityProperty=By.id("searchBtn");
WebElement checkAvailability=driver.findElement(checkAvailabilityProperty);
checkAvailability.click();

Thread.sleep(5000);

Alert tsrtcAlert=driver.switchTo().alert();

String expected_AlertWindowTextMessage="Please select start place.";
System.out.println(" The Expected Alert Message is "+expected_AlertWindowTextMessage);

String actual_AlertWindowText=tsrtcAlert.getText();
System.out.println(" The Actual Alert Message is :- "+actual_AlertWindowText);

if(actual_AlertWindowText.equals(expected_AlertWindowTextMessage))
{
System.out.println(" Message existing - PASS ");
}
else
{
System.out.println(" No Message Found - FAIL ");
}


tsrtcAlert.accept(); // accepting the OK button in the Alert Window

// tsrtcAlert.dismiss(); // is used to work with cancel Button

// tsrtcAlert.sendKeys(" Hyderabad "); // sending the Test Data into the Alert window



}

}
