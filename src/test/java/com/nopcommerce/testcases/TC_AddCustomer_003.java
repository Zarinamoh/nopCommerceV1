package com.nopcommerce.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws IOException
	{
		driver.get(baseURL);
		LoginPage lp=new LoginPage(driver);
		lp.clearEmail();
		lp.clearPwd();
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickLogin();
		
		logger.info("logged in ,now providing customer details..");
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickOnCustomersMenu();
		logger.info("Add new customer Menu clicked");
		addcust.clickOnCustomersMenuItem();
		
		addcust.clickOnAddnew();
		logger.info("Add new customer clicked");
		
		String email =randomestring() + "gmail.com";
		addcust.setEmail(email);
		
		addcust.setPassword("test123");
		logger.info("email and pwd set");
		
		//Registered - default
				//The customer cannot be in both 'Guests' and 'Registered' customer roles
				//Add the customer to 'Guests' or 'Registered' customer role
		
		addcust.setCustomerRoles("Guest");
		addcust.setGender("Male");
		addcust.setFirstName("Health");
		addcust.setLastName("nut");
		addcust.setDob("07/07/1990");
		
		addcust.clickOnSave();
		logger.info("validation started");
		
		
		//String msg=driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]")).getText();
String msg = driver.findElement(By.tagName("body")).getText();
			
		
		if(msg.contains("The new customer has been added successfully"))
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
		}
		else
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}	
	}

}

