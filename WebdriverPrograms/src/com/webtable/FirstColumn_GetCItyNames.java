package com.webtable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FirstColumn_GetCItyNames extends BaseTestWeb {

@Test(priority=1,description=" Capturing First Column CityNames of the World Clock WebTable ")
public void firstColun_CityNames()
{

// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[2]/td[1]
// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[3]/td[1]
// /html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[36]/td[1]

for(int rowIndex=1;rowIndex<=36;rowIndex++)
{
By webTableCityNameProperty=By.xpath
("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+rowIndex+"]/td[1]");
WebElement cityName=driver.findElement(webTableCityNameProperty);
String cityName_Text=cityName.getText();
System.out.println(" The CityName is :- "+cityName_Text);
}



}

}





