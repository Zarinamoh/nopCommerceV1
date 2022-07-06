package com.nopcommerce.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopcommerce.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	
@Test
public void loginTest() throws InterruptedException, IOException
{
	driver.get(baseURL);
	logger.info("URL is opened");
	
	LoginPage lp=new LoginPage(driver);
	lp.clearEmail();
	lp.clearPwd();
	lp.setUserName(username);//the page is showing user/pwd entered by default
	lp.setPassword(password);
	
	lp.clickLogin();
	logger.info("Login clicked");
	Thread.sleep(5000);
	
	if(driver.getTitle().equals("Dashboard / nopCommerce administration123"))
	{
		Assert.assertTrue(true);
		lp.clickLogout();
		logger.info("Logout clicked");
	}
	else
	{
		//capture screenshot 
		captureScreen(driver,"loginTest");
		Assert.assertTrue(false);
		logger.info("login failed");
	}
	
}

}