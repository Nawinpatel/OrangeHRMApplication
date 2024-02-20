package com.webtable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebTable_FirstRow_FirstRowOfCell_GetCityName extends BaseTestWeb {

@Test
public void webTable_getCityName()
{
/*

Xpath is of 2 Types
1. Absolute
2. Relative


*/

// Xpath - The Locator of the webDriver

// any xpath Expression starting with /html tag - is an Absolute Xpath

// Xpath Expression - Selector
// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]


By webTableCityNameProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]");
WebElement cityName=driver.findElement(webTableCityNameProperty);
String cityName_Text=cityName.getText();
System.out.println(" The CityName is :- "+cityName_Text);


}

}