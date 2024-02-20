package com.webtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestWeb {


WebDriver driver;

String applicationUrlAddress="https://www.timeanddate.com/worldclock/";

@BeforeTest
public void setUp()
{
driver = new ChromeDriver();

driver.get(applicationUrlAddress);

driver.manage().window().maximize();

}

@AfterTest
public void tearDown()
{
driver.quit();
}


}
