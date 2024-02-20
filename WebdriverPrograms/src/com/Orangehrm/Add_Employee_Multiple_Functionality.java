package com.Orangehrm;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Add_Employee_Multiple_Functionality extends BaseTest {

	FileInputStream excelTestDataFile;
	XSSFWorkbook excelworkbook;
	XSSFSheet excelsheet;
	Row testDatarow;
	Cell rowOfCell;

	@Test(priority = 1)
	public void OHRM_Login_functionality() throws IOException {

		excelTestDataFile = new FileInputStream("./src/com/Excelfiles/AddEmployee.xlsx");
		excelworkbook = new XSSFWorkbook(excelTestDataFile);
		excelsheet = excelworkbook.getSheet("sheet1");
		testDatarow = excelsheet.getRow(2);

		 rowOfCell = testDatarow.getCell(0);// Getting login panel
		String Loginpanel = rowOfCell.getStringCellValue();

		String expected_OrangeHRMApplicationLogInPageText = Loginpanel;
		System.out.println(" The Expected Text of the OrangeHRM Application Login Page is :- "
				+ expected_OrangeHRMApplicationLogInPageText);
		By orangeHRMApplicationLogInPageTextProperty = By.id("logInPanelHeading");
		WebElement orangeHRMApplicationLogInPage = driver.findElement(orangeHRMApplicationLogInPageTextProperty);
		String actual_OrangeHRMApplicationLogInPageText = orangeHRMApplicationLogInPage.getText();
		System.out.println(" The Actual Text of the OrangeHRM Application Login Page is :- "
				+ actual_OrangeHRMApplicationLogInPageText);
		if (actual_OrangeHRMApplicationLogInPageText.equals(expected_OrangeHRMApplicationLogInPageText)) {
			System.out.println(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
			 rowOfCell = testDatarow.createCell(1);
			rowOfCell.setCellValue("LOGIN Panel");
			rowOfCell = testDatarow.createCell(2);
			rowOfCell.setCellValue("Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
		} else {
			System.out.println(
					" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
			Cell rowOfCell = testDatarow.createCell(1);
			rowOfCell.setCellValue("Not Matched");
			rowOfCell = testDatarow.createCell(2);
			rowOfCell.setCellValue("Failed Navigated to OrangeHRM Application LogIn Page - Fail ");
		}

		 rowOfCell = testDatarow.getCell(3);// Getting OrangeHRM
		String OrangeHRM = rowOfCell.getStringCellValue();

		String Expected_OrangeHRMApplicationPageTitle = OrangeHRM;
		System.out.println("The Expected Title Of OrangeHRM Application Login Web page is :-"
				+ Expected_OrangeHRMApplicationPageTitle);
		String Actual_OrangeHRMApplicationpageTitle = driver.getTitle();
		System.out.println("The Actual   Title of OrangeHRM Application Login Web page is :-"
				+ Actual_OrangeHRMApplicationpageTitle);
		if (Actual_OrangeHRMApplicationpageTitle.equals(Expected_OrangeHRMApplicationPageTitle)) {
			System.out.println("SuccessFully Navigated to OrangeHRM Application WebPage:-Pass");
			Cell rowOfCell = testDatarow.createCell(4);
			rowOfCell.setCellValue("OrangeHRM");
			rowOfCell = testDatarow.createCell(5);
			rowOfCell.setCellValue("Successfully Navigated to OrangeHRM Application  - PASS ");
		} else {
			System.out.println("Failed to Navigate to OrangeHRM Application WebPage:-Fail ");
			Cell rowOfCell = testDatarow.createCell(4);
			rowOfCell.setCellValue("Not Matched");
			rowOfCell = testDatarow.createCell(5);
			rowOfCell.setCellValue("Successfully Navigated to OrangeHRM Application  - Fail ");
		}

		Cell UserNameDataCell = testDatarow.getCell(6);
		String UserNameData = UserNameDataCell.getStringCellValue();
		By userNamePoperty = By.id("txtUsername");
		WebElement userName = driver.findElement(userNamePoperty);
		userName.sendKeys(UserNameData);

		Cell passwordDataCell = testDatarow.getCell(7);
		String passwordData = passwordDataCell.getStringCellValue();
		By passwordProperty = By.name("txtPassword");
		WebElement password = driver.findElement(passwordProperty);
		password.sendKeys(passwordData);

//<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
		By logInButtonProperty = By.className("button");
		WebElement logInButton = driver.findElement(logInButtonProperty);
		logInButton.click();

		By welComeAdminProperty = By.partialLinkText("Admin");
		WebElement welComeAdmin = driver.findElement(welComeAdminProperty);

		String expected_OrangeHRMApplicationHomePageText = "Welcome";
		System.out.println(" The Expected Text of the OrangeHRM Application HomePage is :- "
				+ expected_OrangeHRMApplicationHomePageText);

		String actual_OrangeHRMApplicationHomePageText = welComeAdmin.getText();
		System.out.println(" The Actual Text of the OrangeHRM Application HomePage is :- "
				+ actual_OrangeHRMApplicationHomePageText);

		if (actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMApplicationHomePageText)) {
			System.out.println(" Successfully Navigated to OrangeHRM Application HomePage - PASS ");
			rowOfCell = testDatarow.createCell(9);
			rowOfCell.setCellValue("Admin");
			rowOfCell = testDatarow.createCell(10);
			rowOfCell.setCellValue("Successfully Navigated to OrangeHRM Application  - PASS ");

		} else {
			System.out.println("Failed to Navigate to OrangeHRM Application HomePage - FAIL ");
			System.out.println("OrangeHRMApplicationURLAddress is Not Matched:-FAIL ");
			rowOfCell = testDatarow.createCell(9);
			rowOfCell.setCellValue("Not Matched");
			rowOfCell = testDatarow.createCell(10);
			rowOfCell.setCellValue("Successfully Navigated to OrangeHRM Application  - Fail ");
		}
	}

	@Test(priority = 2)
	public void pim_Test() {
//id="menu_pim_viewPimModule"
		By pimproperty = By.id("menu_pim_viewPimModule");
		WebElement pim = driver.findElement(pimproperty);
		Actions pimAction = new Actions(driver);
		pimAction.moveToElement(pim).build().perform();
	}

	@Test(priority = 3)
	public void add_EmployeeTest() {
   //id="menu_pim_addEmployee"
		By addEmployeeproperty = By.id("menu_pim_addEmployee");
		WebElement addEmployee = driver.findElement(addEmployeeproperty);
		addEmployee.click();
	}

	@Test(priority = 5)
	public void Loginpanelafterlogout() throws InterruptedException, IOException {

		// Cell rowOffCell=testDatarow.getCell(29);//Getting login panel
		// String Loginpanel =rowOffCell.getStringCellValue();

		// <a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>

		By WelComeButtonProperty = By.id("welcome");
		WebElement WelcomeButton = driver.findElement(WelComeButtonProperty);
		WelcomeButton.click();

		// <a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>

		Thread.sleep(3000);

		By LogoutButtonProperty = By.linkText("Logout");
		WebElement LogOutButton = driver.findElement(LogoutButtonProperty);
		LogOutButton.click();

		String expected_OrangeHRMApplicationLogInPageText = "LOGIN Panel";
		System.out.println(" The Expected Text of the OrangeHRM Application Login Page After Logout is :- "
				+ expected_OrangeHRMApplicationLogInPageText);
		By orangeHRMApplicationLogInPageTextProperty = By.id("logInPanelHeading");
		WebElement orangeHRMApplicationLogInPage = driver.findElement(orangeHRMApplicationLogInPageTextProperty);

		String actual_OrangeHRMApplicationLogInPageText = orangeHRMApplicationLogInPage.getText();
		System.out.println(" The Actual Text of the OrangeHRM Application Login Page  After Logout is :- "
				+ actual_OrangeHRMApplicationLogInPageText);

		if (actual_OrangeHRMApplicationLogInPageText.equals(expected_OrangeHRMApplicationLogInPageText)) {
			System.out.println(" Successfully Navigated to OrangeHRM Application LogIn Page After Logout- PASS ");
			Cell rowOfCells = testDatarow.createCell(31);
			rowOfCell = testDatarow.createCell(30);
			rowOfCells.setCellValue("Successfully Navigated to OrangeHRM Application LogIn Page After Logout - PASS");
			rowOfCell.setCellValue("LOGIN Panel");
		} else {
			System.out.println(
					" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page After Logout - FAIL");
			rowOfCell = testDatarow.createCell(31);
			rowOfCell.setCellValue("Failed to Navigate to OrangeHRM Application LogIn PageAfter Logout - Fail");
			rowOfCell = testDatarow.createCell(30);
			rowOfCell.setCellValue("Not Matched");
		}


		FileOutputStream testDataResultFile = new FileOutputStream("./src/com/OrangeHRMApplicationTestResultfiles/OrangeHRMAddemployeeTestResults.xlsx");
		excelworkbook.write(testDataResultFile);

	}

	@Test(priority = 4)
	public void add_NewEmployeeTest() throws IOException, InterruptedException   {

		
		for (int rowindex = 2;rowindex < excelsheet.getPhysicalNumberOfRows(); rowindex++) {
			
			     Row testDatarow = excelsheet.getRow(rowindex);
				Cell FirstNameTestDataCell = testDatarow.getCell(14);
				String FirstNameTestData = FirstNameTestDataCell.getStringCellValue();// Getting First Name
				Cell MiddleNameTEstDataCell = testDatarow.getCell(15);
				String MiddleNameTestData = MiddleNameTEstDataCell.getStringCellValue();// Getting Middle Name
				Cell LastNameTestDataCell = testDatarow.getCell(16);
				String LastNameTestData = LastNameTestDataCell.getStringCellValue();// Getting Last Name

				// <input class="formInputText" max length="30" type="text" name="firstName"
				// id="firstName">
				By firstNameProperty1 = By.name("firstName");
				WebElement firstName = driver.findElement(firstNameProperty1);
				firstName.sendKeys(FirstNameTestData);

				// <input class="formInputText" max length="30" type="text" name="lastName"
				// id="middleName">
				By middleNameProperty = By.id("middleName");
				WebElement middleName = driver.findElement(middleNameProperty);
				middleName.sendKeys(MiddleNameTestData);
				
				// <input class="formInputText" max length="30" type="text" name="lastName"
				// id="lastName">
				By lastNameProperty = By.name("lastName");
				WebElement lastName = driver.findElement(lastNameProperty);
				lastName.sendKeys(LastNameTestData);
				

				// <input class="formInputText valid" max length="10" type="text"
				// name="employeeId" value="0002" id="employeeId">
				By employeeIdProperty = By.name("employeeId");
				WebElement employeeId = driver.findElement(employeeIdProperty);
				String Expected_employeeId = employeeId.getAttribute("value");
				System.out.println("The text of the Expected webelement employee id is: " + Expected_employeeId);
				rowOfCell = testDatarow.createCell(17);
				rowOfCell.setCellValue(Expected_employeeId);
				System.out.println();
				
				//employeeId
				Actions keyBoardActions = new Actions(driver);
				keyBoardActions.sendKeys(Keys.TAB).build().perform();
				
				
				//Photograph
				keyBoardActions.sendKeys(Keys.TAB).build().perform();
				
				//Choose file
				keyBoardActions.sendKeys(Keys.ENTER).build().perform();
				
				Thread.sleep(5000);

				java.lang.Runtime.getRuntime().exec("./AutoItTestScripts/UploadPhotograph.exe");

				Thread.sleep(5000);

				Cell AddEmployeeTestDataCell = testDatarow.getCell(11);
				String AddEmployeeTestData = AddEmployeeTestDataCell.getStringCellValue();// Getting AddEmployee
               //  /html/body/div[1]/div[3]/div/div[1]/h1
				String Expected_OrangeHRMFullNameText = AddEmployeeTestData;
				System.out.println(" The Expected Text of the OrangeHRM Application Login Page is :- "
						+ Expected_OrangeHRMFullNameText);
				WebElement headingElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/h1"));
				String actual_OrangeHRMFullNameText = headingElement.getText();
				System.out.println(" The Actual Text of the OrangeHRM Application Login Page is :- "
						+ actual_OrangeHRMFullNameText);

				if (actual_OrangeHRMFullNameText.equals(Expected_OrangeHRMFullNameText)) {
					System.out.println(
							" Text Found - Successfully Navigated to OrangeHRM Application Add Employee Page - PASS ");
					rowOfCell = testDatarow.createCell(12);
					rowOfCell.setCellValue(actual_OrangeHRMFullNameText);
					rowOfCell = testDatarow.createCell(13);
					rowOfCell.setCellValue("Successfully Navigated to OrangeHRM Application  Add Employee Page - PASS ");
				} else {
					System.out.println(
							" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application Add Employee Page - FAIL");
					rowOfCell = testDatarow.createCell(12);
					rowOfCell.setCellValue("Not Matched");
					rowOfCell = testDatarow.createCell(13);
					rowOfCell.setCellValue("Failed Navigated to OrangeHRM Application Add Employee Page - Fail ");
				}

				By saveButtonProperty = By.id("btnSave");
				WebElement saveButton = driver.findElement(saveButtonProperty);
				saveButton.click();
				
				Thread.sleep(5000);
			

				Cell PersonalTestDataCell = testDatarow.getCell(18);
				String PersonalTestData = PersonalTestDataCell.getStringCellValue();// Getting PersonalDetails
				// /html/body/div[1]/div[3]/div/div[2]/div[1]/h1
				String Expected_OrangeHRMPersonalDetailsText = PersonalTestData;
				System.out.println(" The Expected Text of the OrangeHRM Application PersonalDetails Page is :- "
						+ Expected_OrangeHRMPersonalDetailsText);
				WebElement PersonalheadingElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/h1"));
				String actual_OrangeHRMPersonalDetailsText = PersonalheadingElement.getText();
				System.out.println(" The Actual Text of the OrangeHRM Application PersonalDetailsPage is :- "
						+ actual_OrangeHRMPersonalDetailsText);

				if (actual_OrangeHRMPersonalDetailsText.equals(Expected_OrangeHRMPersonalDetailsText)) {
					System.out.println(
							" Text Found - Successfully Navigated to OrangeHRM Application PersonalDetails Page - PASS ");
					rowOfCell = testDatarow.createCell(19);
					rowOfCell.setCellValue(actual_OrangeHRMPersonalDetailsText);
					rowOfCell = testDatarow.createCell(20);
					rowOfCell.setCellValue(
							"Successfully Navigated to OrangeHRM Application  PersonalDetails Page - PASS ");
				} else {
					System.out.println(
							" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application PersonalDetails Page - FAIL");
				    rowOfCell = testDatarow.createCell(19);
					rowOfCell.setCellValue("Not Matched");
					rowOfCell = testDatarow.createCell(20);
					rowOfCell.setCellValue("Failed Navigated to OrangeHRM Application PersonalDetails Page - Fail ");
				}

				String expected_firstNameTestData = FirstNameTestData;
				By firstNameProperty2 = By.id("personal_txtEmpFirstName");
				WebElement firstNameElement = driver.findElement(firstNameProperty2);
				String Actual_firstNameValue = firstNameElement.getAttribute("value");
				System.out.println("The Actual value of the first name is: " + Actual_firstNameValue);

				if (Actual_firstNameValue.equals(expected_firstNameTestData)) {
					System.out.println("The Employee First Name Is Matched :-Pass");
					rowOfCell = testDatarow.createCell(21);
					rowOfCell.setCellValue(Actual_firstNameValue);
				    rowOfCell = testDatarow.createCell(22);
					rowOfCell.setCellValue("The Employee First Name Is Matched :-Pass");

				} else {
					System.out.println("The Employee First Name Is Not Matched :-Fail");
				    rowOfCell = testDatarow.createCell(21);
					rowOfCell.setCellValue(Actual_firstNameValue);
					rowOfCell = testDatarow.createCell(22);
					rowOfCell.setCellValue("The Employee First Name Is Not Matched :-FAIL");

				}
				System.out.println();

                    //name="personal[txtEmpMiddleName]" 
				String expected_middleNameTestData = MiddleNameTestData;
				By Middlenameproperty = By.name("personal[txtEmpMiddleName]");
				WebElement MiddlenameElement = driver.findElement(Middlenameproperty);
				String Actual_MiddleNameValue = MiddlenameElement.getAttribute("value");
				System.out.println("The Actual value of the Middle name is: " + Actual_MiddleNameValue);
				if (Actual_MiddleNameValue.equals(expected_middleNameTestData)) {
					System.out.println("The Employee Middle Name Is Matched :-Pass");
					rowOfCell = testDatarow.createCell(23);
					rowOfCell.setCellValue(Actual_MiddleNameValue);
					rowOfCell = testDatarow.createCell(24);
					rowOfCell.setCellValue("The Employee Middle Name Is Matched :-Pass");

				} else {
					System.out.println("The Employee Middle Name Is Not Matched :-Fail");
					rowOfCell = testDatarow.createCell(23);
					rowOfCell.setCellValue(Actual_MiddleNameValue);
					rowOfCell = testDatarow.createCell(24);
					rowOfCell.setCellValue("The Employee Last Name Is Matched :- FAIL");

				}
				System.out.println();

                 //name="personal[txtEmpLastName]"
				String expected_lastNameTestData = LastNameTestData;
				By Lastnameproperty = By.name("personal[txtEmpLastName]");
				WebElement LastnameElement = driver.findElement(Lastnameproperty);
				String Actual_LastNameValue = LastnameElement.getAttribute("value");
				System.out.println("The Actual value of the Last name is: " + Actual_LastNameValue);
				if (Actual_LastNameValue.equals(expected_lastNameTestData)) {
					System.out.println("The Employee Last Name Is Matched :-Pass");
					rowOfCell = testDatarow.createCell(25);
					rowOfCell.setCellValue(Actual_LastNameValue);
					rowOfCell = testDatarow.createCell(26);
					rowOfCell.setCellValue("The Employee Last Name Is Matched :-Pass");

				} else {
					System.out.println("The Employee Last Name Is Not Matched :-Fail");
				}
				System.out.println();

                 //name="personal[txtEmployeeId]" 
 				By employeeIdProperty2 = By.name("personal[txtEmployeeId]");
				WebElement employeeId2 = driver.findElement(employeeIdProperty2);
				String Actual_employeeId = employeeId2.getAttribute("value");
				System.out.println("The text of the Actual webelement employee id is: " + Actual_employeeId);

				if (Actual_employeeId.equals(Expected_employeeId)) {
					System.out.println("The Employee Id Is Matched :-Pass");
					rowOfCell = testDatarow.createCell(27);
					rowOfCell.setCellValue(Actual_employeeId);
					rowOfCell = testDatarow.createCell(28);
					rowOfCell.setCellValue("The Actual And Expected Employee ID is Matched-pass");
				}

				else {
					System.out.println("The Employee Id Is Not Matched :-Fail");
				}

			
				driver.navigate().back();
				driver.navigate().refresh();

		}

	}
}
