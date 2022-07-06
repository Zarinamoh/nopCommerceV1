package com.nopcommerce.utilities;


import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	//load the config file at runtime and read values
	public ReadConfig()
	{
		try {
		FileInputStream fis =new FileInputStream("./Configuration/config.properties");
		pro=new Properties();
		pro.load(fis);
	}
	catch(Exception e)
	{
		System.out.println("Exception is   "+e.getMessage());
	}
	}
	//method to read the values of variables.method to read each value
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url; //this url is used in baseclass
	}
	public String getUseremail()
	{
	String username=pro.getProperty("useremail");
	return username;
	}
	
	public String getPassword()
	{
	String password=pro.getProperty("password");
	return password;
	}
	
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}
	

}
