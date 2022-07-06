package com.nopcommerce.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user,String pwd) throws InterruptedException
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.clearEmail();
		lp.clearPwd();
		lp.setUserName(user);//the page is showing user/pwd entered by default
		lp.setPassword(pwd);
		
		lp.clickLogin();
		logger.info("Login clicked");
		Thread.sleep(5000);
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("Logout clicked");
		}
		else
		{
			//capture screenshot 
			//captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("login failed");
		}
		
		
	}
     
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/nopcommerce/testData/LoginData.xlsx";
		
		int rownum= XLUtils.getRowCount(path,"Sheet1");
		int colnum= XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colnum];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}
		}
		
		return logindata;
		
	}
}
