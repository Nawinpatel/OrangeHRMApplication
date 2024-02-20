package com.DropDown;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown_GetOptionalValues {

		WebDriver driver ;
		String applicationUrlAddress="https://www.osmania.ac.in/";



		public void applicationLaunch()
		{

		System.setProperty("webdriver.chrome.driver", "./browserDriverFiles/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get(applicationUrlAddress);

		// Maximizing the Browser
		driver.manage().window().maximize();


		}


		public void applicationClose()
		{
		driver.quit();
		}



		public void gettingOptionalValuesOfSelectLanugaagesDropDown()
		{
		// Identifying the Select Languages DropDown Property
		// id="gtranslate_selector"

		By selectLanguagesDropDownProperty=By.id("gtranslate_selector");
		WebElement selectLanugages=driver.findElement(selectLanguagesDropDownProperty);

		// <option value="en|fr">French</option>
		// <option value="en|de">German</option>
		// <option value="en|ur">Urdu</option>

		By dropDownProperty=By.tagName("option");
		List<WebElement>selectOptionalLanguages=selectLanugages.findElements(dropDownProperty);

		int languagesCount=selectOptionalLanguages.size();
		System.out.println(" The number of languages in the Select Languages drop down is :- "+languagesCount);

		for(int index=0;index<languagesCount;index++)
		{
		String languageName=selectOptionalLanguages.get(index).getText();
		System.out.println(index+" "+languageName);
		}

		}

		public static void main(String[] args) {

		DropDown_GetOptionalValues osmaniaUniversity = new DropDown_GetOptionalValues();
		osmaniaUniversity.applicationLaunch();
		osmaniaUniversity.gettingOptionalValuesOfSelectLanugaagesDropDown();
		osmaniaUniversity.applicationClose();

		}}



