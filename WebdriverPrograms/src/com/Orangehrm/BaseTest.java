package com.Orangehrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver; // Import FirefoxDriver
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    WebDriver driver;
    String applicationUrlAddress = "http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";

    @BeforeTest
    public void applicationLaunch() {
      
        // System.setProperty("webdriver.chrome.driver", "./chromeBrowser/chromedriver.exe");
         driver = new ChromeDriver();

      //  System.setProperty("webdriver.gecko.driver", "./browserdriverfiles/geckodriver.exe");
      //  driver = new FirefoxDriver();

        driver.get(applicationUrlAddress);
        driver.manage().window().maximize();
    }
/*
    @AfterTest
    public void applicationClose() {
     
            driver.quit();
        
    }*/
}
