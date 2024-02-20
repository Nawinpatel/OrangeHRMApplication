package com.Orangehrm;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class OrangeHrm_Add_Employee {

	public static void main(String[] args) throws InterruptedException, IOException {
		
	                 	WebDriver driver;
	            	    String  ApplicationURLAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";		
	                    System.setProperty("webdriver.chrome.driver", "./browserdriverfiles/chromedriver.exe");
                        driver=new ChromeDriver();
	                    driver.get(ApplicationURLAddress);
	                    driver.manage().window().maximize();
	                
	                    FileInputStream logInTestDataFile =new FileInputStream("./src/com/Excelfiles/AddEmployeeTestSheet1.xlsx");
			            XSSFWorkbook WorkBook =new XSSFWorkbook(logInTestDataFile);
			            XSSFSheet AddEmployeeData =WorkBook.getSheet("Sheet1");
	                
	                    int rowCount=AddEmployeeData.getLastRowNum();//FINDING CELL COUNT
			 		    for(int rowIndex=2;rowIndex<=rowCount;rowIndex++){
			 			Row testDataSheetRow=AddEmployeeData.getRow(rowIndex);
			 			Cell userNameTestDataCell=testDataSheetRow.getCell(3);//Getting UserName
			 			String userNameTestData=userNameTestDataCell.getStringCellValue();
			 		    Cell rowOfCell=testDataSheetRow.getCell(4);//Getting Password
			 		    String passwordTestData=rowOfCell.getStringCellValue();
			 		    Cell rowOffCell=testDataSheetRow.getCell(0);//Getting login panel
			 		    String Loginpanel =rowOffCell.getStringCellValue();
			 		    Cell FirstNameTestDataCell=testDataSheetRow.getCell(14);
				 		String FirstNameTestData=FirstNameTestDataCell.getStringCellValue();//Getting First Name
				 	    Cell MiddleNameTEstDataCell=testDataSheetRow.getCell(15);
				 	    String MiddleNameTestData=MiddleNameTEstDataCell.getStringCellValue();//Getting Middle Name
				 	    Cell LastNameTestDataCell=testDataSheetRow.getCell(16);
				 	    String LastNameTestData=LastNameTestDataCell.getStringCellValue();//Getting Last Name
			 		    
			 		    
			 		    String expected_OrangeHRMApplicationLogInPageText=Loginpanel;
			 			System.out.println(" The Expected Text of the OrangeHRM Application Login Page is :- "+expected_OrangeHRMApplicationLogInPageText);
			 			By orangeHRMApplicationLogInPageTextProperty=By.id("logInPanelHeading");
			 			WebElement orangeHRMApplicationLogInPage=driver.findElement(orangeHRMApplicationLogInPageTextProperty);

			 			String actual_OrangeHRMApplicationLogInPageText=orangeHRMApplicationLogInPage.getText();
			 			System.out.println(" The Actual Text of the OrangeHRM Application Login Page is :- "+actual_OrangeHRMApplicationLogInPageText);

			 			if(actual_OrangeHRMApplicationLogInPageText.equals(expected_OrangeHRMApplicationLogInPageText)){
			 			System.out.println(" Text Found - Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
			 			Cell testRowOfCell=testDataSheetRow.createCell(1);
			 			testRowOfCell.setCellValue("LOGIN Panel");
			 			testRowOfCell=testDataSheetRow.createCell(2);
			 			testRowOfCell.setCellValue("Successfully Navigated to OrangeHRM Application LogIn Page - PASS ");
			 			}
			 			else{
			 			System.out.println(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page - FAIL");
			 			Cell testRowOfCell=testDataSheetRow.createCell(1);
			 			testRowOfCell.setCellValue("Not Matched");
			 			testRowOfCell=testDataSheetRow.createCell(2);
			 			testRowOfCell.setCellValue("Failed Navigated to OrangeHRM Application LogIn Page - Fail ");
			 			
			 			}

			 		    By userNamePoperty=By.id("txtUsername"); 
			 			WebElement userName=driver.findElement(userNamePoperty); 
			 			userName.sendKeys(userNameTestData);
			 			
			 			By passwordProperty=By.name("txtPassword");
			 			WebElement password=driver.findElement(passwordProperty);
			 			password.sendKeys(passwordTestData);

			 			By logInButtonProperty=By.className("button");
			 			WebElement logInButton=driver.findElement(logInButtonProperty);
			 			logInButton.click();
			 			
			 			
			 			By welComeAdminProperty=By.partialLinkText("Admin");
						WebElement welComeAdmin=driver.findElement(welComeAdminProperty);

						String expected_OrangeHRMApplicationHomePageText="Welcome";
						System.out.println(" The Expected Text of the OrangeHRM Application HomePage is :- "+expected_OrangeHRMApplicationHomePageText);

						String actual_OrangeHRMApplicationHomePageText=welComeAdmin.getText();
						System.out.println(" The Actual Text of the OrangeHRM Application HomePage is :- "+actual_OrangeHRMApplicationHomePageText);
						
						
						if(actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMApplicationHomePageText))
						{
						System.out.println(" Successfully Navigated to OrangeHRM Application HomePage - PASS ");
						Cell testRowOfCell=testDataSheetRow.createCell(10);
				    	testRowOfCell.setCellValue ("Successfully Navigated to OrangeHRM Application HomePage - pass");
				    	 testRowOfCell=testDataSheetRow.createCell(9);
				         testRowOfCell.setCellValue("Welcome");}
						else{
						System.out.println("Failed to Navigate to OrangeHRM Application HomePage - FAIL ");
						 System.out.println("OrangeHRMApplicationURLAddress is Not Matched:-FAIL ");
				    	 Cell testRowOfCell=testDataSheetRow.createCell(10);
				    	 testRowOfCell.setCellValue("Failed to Navigate to OrangeHRM Application HomePage:- FAIL ");
				         testRowOfCell=testDataSheetRow.createCell(9);
				         testRowOfCell.setCellValue("Not Matched");}
			       
			         
			
			            // id="menu_pim_viewPimModule"
			            By  pimProperty=By.id("menu_pim_viewPimModule");
			            WebElement pim=driver.findElement(pimProperty);
			       
			            Actions mouseHoverOperation=new Actions(driver);
			            mouseHoverOperation.moveToElement(pim).build().perform();   
			      
			      
			 	
			         
			            //<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/addEmployee" id="menu_pim_addEmployee">Add Employee</a>
			            By  AddEmployeeProperty= By.linkText("Add Employee");
			            WebElement AddEmployee=driver.findElement(AddEmployeeProperty);
			            AddEmployee.click();
			 		   
				 		
			    
			            // name="lastName"
			       
		                By firstNameProperty1=By.name("firstName");
		                WebElement firstName=driver.findElement(firstNameProperty1);
		                firstName.sendKeys(FirstNameTestData);
		        
		               //id="middleName"
		        
		               By middleNameProperty=By.id("middleName");
		               WebElement middleName=driver.findElement(middleNameProperty);
		               middleName.sendKeys(MiddleNameTestData);
		        
		              //<input class="formInputText" maxlength="30" type="text" name="lastName" id="lastName">
		        
		               By lastNameProperty=By.name("lastName");
		               WebElement lastName=driver.findElement(lastNameProperty);
		               lastName.sendKeys(LastNameTestData);
			      
		              // <input class="formInputText valid" maxlength="10" type="text" name="employeeId" value="0002" id="employeeId"> 

		              By employeeIdProperty = By.name("employeeId");
		              WebElement employeeId = driver.findElement(employeeIdProperty);
		              String Expected_employeeId = employeeId.getAttribute("value");
		              System.out.println("The text of the Expected webelement employee id is: " + Expected_employeeId);
		              Cell ExpectedtestsRowOfCell=testDataSheetRow.createCell(17);
			          ExpectedtestsRowOfCell.setCellValue(Expected_employeeId);
		              System.out.println();
			         //	<input type="button" class="" id="btnSave" value="Save">
		         
		         
		         
		             Cell AddEmployeeTestDataCell=testDataSheetRow.getCell(11);
				     String AddEmployeeTestData=AddEmployeeTestDataCell.getStringCellValue();//Getting AddEmployee
				   //  <h1>Add Employee</h1>
		            String Expected_OrangeHRMFullNameText=AddEmployeeTestData;
		 			System.out.println(" The Expected Text of the OrangeHRM Application Login Page is :- "+Expected_OrangeHRMFullNameText);
		 			WebElement headingElement = driver.findElement(By.xpath("//h1[text()='Add Employee']"));
		 			String actual_OrangeHRMFullNameText=headingElement.getText();
		 			System.out.println(" The Actual Text of the OrangeHRM Application Login Page is :- "+actual_OrangeHRMFullNameText);

		 			if(actual_OrangeHRMFullNameText.equals(Expected_OrangeHRMFullNameText)){
		 			System.out.println(" Text Found - Successfully Navigated to OrangeHRM Application Add Employee Page - PASS ");
		 			Cell tetRowOfCell=testDataSheetRow.createCell(12);
		 			tetRowOfCell.setCellValue(actual_OrangeHRMFullNameText);
		 			tetRowOfCell=testDataSheetRow.createCell(13);
		 			tetRowOfCell.setCellValue("Successfully Navigated to OrangeHRM Application  Add Employee Page - PASS ");
		 			}
		 			else{
		 			System.out.println(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application Add Employee Page - FAIL");
		 			Cell testRowOfCell=testDataSheetRow.createCell(12);
		 			testRowOfCell.setCellValue("Not Matched");
		 			testRowOfCell=testDataSheetRow.createCell(13);
		 			testRowOfCell.setCellValue("Failed Navigated to OrangeHRM Application Add Employee Page - Fail ");}
				
			    	By saveButtonProperty=By.id("btnSave");
		            WebElement saveButton=driver.findElement(saveButtonProperty);
		            saveButton.click();
				
		            
		            Thread.sleep(3000);

		            Cell PersonalTestDataCell=testDataSheetRow.getCell(18);
				    String PersonalTestData=PersonalTestDataCell.getStringCellValue();//Getting PersonalDetails
				     //Xpath <h1>Personal Details</h1>
		            String Expected_OrangeHRMPersonalDetailsText=PersonalTestData;
		 			System.out.println(" The Expected Text of the OrangeHRM Application PersonalDetails Page is :- "+Expected_OrangeHRMPersonalDetailsText);
		 			WebElement PersonalheadingElement = driver.findElement(By.xpath("//h1[text()='Personal Details']"));
		 			String actual_OrangeHRMPersonalDetailsText=PersonalheadingElement.getText();
		 			System.out.println(" The Actual Text of the OrangeHRM Application PersonalDetailsPage is :- "+actual_OrangeHRMPersonalDetailsText);

		 			if(actual_OrangeHRMPersonalDetailsText.equals(Expected_OrangeHRMPersonalDetailsText)){
		 			System.out.println(" Text Found - Successfully Navigated to OrangeHRM Application PersonalDetails Page - PASS ");
		 			Cell tetRowOfCell=testDataSheetRow.createCell(19);
		 			tetRowOfCell.setCellValue(actual_OrangeHRMPersonalDetailsText);
		 			tetRowOfCell=testDataSheetRow.createCell(20);
		 			tetRowOfCell.setCellValue("Successfully Navigated to OrangeHRM Application  PersonalDetails Page - PASS ");
		 			}
		 			else{
		 			System.out.println(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application PersonalDetails Page - FAIL");
		 			Cell testRowOfCell=testDataSheetRow.createCell(19);
		 			testRowOfCell.setCellValue("Not Matched");
		 			testRowOfCell=testDataSheetRow.createCell(20);
		 			testRowOfCell.setCellValue("Failed Navigated to OrangeHRM Application PersonalDetails Page - Fail ");}
		         
		         
		         
		        String expected_firstNameTestData =FirstNameTestData;
				By firstNameProperty2 = By.id("personal_txtEmpFirstName");
				WebElement firstNameElement = driver.findElement(firstNameProperty2);
				String Actual_firstNameValue = firstNameElement.getAttribute("value");
				System.out.println("The Actual value of the first name is: " + Actual_firstNameValue);
				
				if(Actual_firstNameValue.equals(expected_firstNameTestData)){
				System.out.println("The Employee First Name Is Matched :-Pass");
				Cell FirstNameCell=testDataSheetRow.createCell(21);
				FirstNameCell.setCellValue (Actual_firstNameValue);
	 			Cell FirstNameRowOfCell=testDataSheetRow.createCell(22);
	 			FirstNameRowOfCell.setCellValue("The Employee First Name Is Matched :-Pass");
				
				}
				else{
				System.out.println("The Employee First Name Is Not Matched :-Fail");
				Cell FirstNameCell=testDataSheetRow.createCell(21);
				FirstNameCell.setCellValue (Actual_firstNameValue);
	 			Cell FirstNameRowOfCell=testDataSheetRow.createCell(22);
	 			FirstNameRowOfCell.setCellValue("The Employee First Name Is Not Matched :-FAIL");
				
				}
				System.out.println();
				
				//name="personal[txtEmpMiddleName]" 
				String expected_middleNameTestData =MiddleNameTestData;
				By Middlenameproperty=By.name("personal[txtEmpMiddleName]");
		    	WebElement MiddlenameElement=driver.findElement(Middlenameproperty);
		    	String Actual_MiddleNameValue = MiddlenameElement.getAttribute("value");
				System.out.println("The Actual value of the Middle name is: " + Actual_MiddleNameValue);
				if(Actual_MiddleNameValue.equals(expected_middleNameTestData)){
				System.out.println("The Employee Middle Name Is Matched :-Pass");
				Cell MiddleNameCell=testDataSheetRow.createCell(23);
				MiddleNameCell.setCellValue (Actual_MiddleNameValue);
	 			Cell MiddleNameRowOfCell=testDataSheetRow.createCell(24);
	 			MiddleNameRowOfCell.setCellValue("The Employee Middle Name Is Matched :-Pass");
				
				
				}
				else{
				System.out.println("The Employee Middle Name Is Not Matched :-Fail");
				Cell LastNameCell=testDataSheetRow.createCell(23);
				LastNameCell.setCellValue (Actual_MiddleNameValue);
	 			Cell LastNameRowOfCell=testDataSheetRow.createCell(24);
	 			LastNameRowOfCell.setCellValue("The Employee Last Name Is Matched :- FAIL");
				
				}
				System.out.println();
				
				//name="personal[txtEmpLastName]"
				String expected_lastNameTestData =LastNameTestData;
				By Lastnameproperty=By.name("personal[txtEmpLastName]");
		    	WebElement LastnameElement=driver.findElement(Lastnameproperty);
		    	String Actual_LastNameValue = LastnameElement.getAttribute("value");
				System.out.println("The Actual value of the Last name is: " + Actual_LastNameValue);
				if(Actual_LastNameValue.equals(expected_lastNameTestData)){
				System.out.println("The Employee Last Name Is Matched :-Pass");
				Cell LastNameCell=testDataSheetRow.createCell(25);
				LastNameCell.setCellValue (Actual_LastNameValue);
	 			Cell LastNameRowOfCell=testDataSheetRow.createCell(26);
	 			LastNameRowOfCell.setCellValue("The Employee Last Name Is Matched :-Pass");
				
				}
				else{
				System.out.println("The Employee Last Name Is Not Matched :-Fail");}
			    System.out.println();

		    	//name="personal[txtEmployeeId]" 
			    By employeeIdProperty2 = By.name("personal[txtEmployeeId]");
		        WebElement employeeId2 = driver.findElement(employeeIdProperty2);
		        String Actual_employeeId = employeeId2.getAttribute("value");
		        System.out.println("The text of the Actual webelement employee id is: " + Actual_employeeId);
				
				if(Actual_employeeId.equals(Expected_employeeId)){
			    System.out.println("The Employee Id Is Matched :-Pass");
			    Cell  testsRowOfCell=testDataSheetRow.createCell(27);
				testsRowOfCell.setCellValue(Actual_employeeId);
				testsRowOfCell=testDataSheetRow.createCell(28);
				testsRowOfCell.setCellValue("The Actual And Expected Employee ID is Matched-pass");
				}

				else{
				System.out.println("The Employee Id Is Not Matched :-Fail");}
				
				
				
			    welComeAdminProperty=By.partialLinkText("Admin");
   			    welComeAdmin=driver.findElement(welComeAdminProperty);
			    welComeAdmin.click();

				Thread.sleep(2000);

				By logOutProperty=By.linkText("Logout");
				WebElement logOut=driver.findElement(logOutProperty);
				logOut.click();
				
				
				expected_OrangeHRMApplicationLogInPageText="LOGIN Panel";
				System.out.println(" The Expected Text of the OrangeHRM Application Login Page After Logout is :- "+expected_OrangeHRMApplicationLogInPageText);
				orangeHRMApplicationLogInPageTextProperty=By.id("logInPanelHeading");
				orangeHRMApplicationLogInPage=driver.findElement(orangeHRMApplicationLogInPageTextProperty);

			    actual_OrangeHRMApplicationLogInPageText=orangeHRMApplicationLogInPage.getText();
				System.out.println(" The Actual Text of the OrangeHRM Application Login Page  After Logout is :- "+actual_OrangeHRMApplicationLogInPageText);

				if(actual_OrangeHRMApplicationLogInPageText.equals(expected_OrangeHRMApplicationLogInPageText)){
				System.out.println(" Successfully Navigated to OrangeHRM Application LogIn Page After Logout- PASS ");
				Cell testRosOfCell=testDataSheetRow.createCell(31);
				Cell testRowsOfCell=testDataSheetRow.createCell(30);
				testRosOfCell.setCellValue ("Successfully Navigated to OrangeHRM Application LogIn Page After Logout - PASS");
				testRowsOfCell.setCellValue("LOGIN Panel");}
				else{
				System.out.println(" Expected LogIn Page Text Not Found - Failed to Navigate to OrangeHRM Application LogIn Page After Logout - FAIL");
				Cell testRosOfCell=testDataSheetRow.createCell(31);
				testRosOfCell.setCellValue ("Failed to Navigate to OrangeHRM Application LogIn PageAfter Logout - Fail");
				Cell testRowsOfCell=testDataSheetRow.createCell(30);
				testRowsOfCell.setCellValue("Not Matched");}


			    FileOutputStream testResultFile = new FileOutputStream("./src/com/OrangeHRMApplicationTestResultfiles/OrangeHRMAddemployeeTestResult.xlsx");
			    WorkBook.write(testResultFile);
				
				
		        driver.quit();
	}}}


