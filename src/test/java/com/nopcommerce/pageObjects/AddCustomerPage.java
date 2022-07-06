package com.nopcommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	public WebDriver Idriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		Idriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}	
	//different approach from login page. choose one of the approaches across the project
	By lnkCustomer_menu=By.xpath("//a[@href='#']//span[contains(text(),'Customers')]");
	By lnkCustomer_menuitem=By.xpath("//span[@class='menu-item-title'][contains(text(),'Customers')]");
	
	By btnAddnew =By.xpath("//a[@class='btn bg-blue']");
	
	By txtEmail=By.name("Email");
	By txtPassword=By.name("Password");
	By txtFirstName=By.id("FirstName");
	By txtLastName=By.id("LastName");
	By rdMaleGender=By.id("Gender_Male");
	By rdFeMaleGender=By.id("Gender_Female");
	
	By txtDob=By.xpath("//*[@id=\'DateOfBirth\']");
	By chkTaxExempt=By.id("IsTaxExempt");
	
	By txtcustomerRoles=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	By lstitemAdministrators=By.xpath("//*[@id=\'a8fc70a6-7f09-4218-ad9b-e059fc206ce4\']");
	By lstitemGuests=By.xpath("//*[@id=\'a8fc70a6-7f09-4218-ad9b-e059fc206ce4\']");
	By lstitemForummoderators=By.xpath("//*[@id=\'SelectedCustomerRoleIds_listbox\']/li[2]");

    By drpmgrVendor=By.xpath("//*[@id=\'VendorId\']");
    
    By btnSave=By.xpath("/html/body/div[3]/div[1]/form/div[1]/div/button[1]");

	/*@FindBy(xpath="//a[@href='#']//span[contains(text(),'Customers')]")
     WebElement lnkCustomer_menu;
	
	public void clickOnCustomersMenu()
	{
		lnkCustomer_menu.click();
	}*/
	
    public void clickOnCustomersMenu()
    {
    	Idriver.findElement(lnkCustomer_menu).click();
    }
    public void clickOnCustomersMenuItem()
    {
    	Idriver.findElement(lnkCustomer_menuitem).click();
    }
    public void clickOnAddnew() {
		Idriver.findElement(btnAddnew).click();
	}
	
	public void setEmail(String email)
	{
		Idriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		Idriver.findElement(txtPassword).sendKeys(password);
	}
	
	public void setCustomerRoles(String role)
	{
		Idriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
		
		Idriver.findElement(txtcustomerRoles).click();
					
		WebElement listitem;
		
		switch(role)
		{
		case "Administrators":
				listitem=Idriver.findElement(lstitemAdministrators); break;
		case "Guests":
				listitem=Idriver.findElement(lstitemGuests); break;
		case "Forum Moderators":
			listitem=Idriver.findElement(lstitemForummoderators); break;
		
		default:
			listitem=Idriver.findElement(lstitemGuests);
		}
					
		//sometimes click method does not work so use this
		JavascriptExecutor js = (JavascriptExecutor)Idriver;
		js.executeScript("arguments[0].click();", listitem);
	}
	
		public void setManagerOfVendor(String value)
		{
			Select drp=new Select(Idriver.findElement(drpmgrVendor));
			drp.selectByVisibleText(value);
		}
		
		public void setGender(String gender)
		{
			if(gender.equals("Male"))
			{
				Idriver.findElement(rdMaleGender).click();
			}
			else if(gender.equals("Female"))
			{
				Idriver.findElement(rdFeMaleGender).click();
			}
			else
			{
				Idriver.findElement(rdMaleGender).click();//Default
			}
			
		}
		
		public void setFirstName(String fname)
		{
			Idriver.findElement(txtFirstName).sendKeys(fname);
		}
		
		public void setLastName(String lname)
		{
			Idriver.findElement(txtLastName).sendKeys(lname);
		}
		
		public void setDob(String dob)
		{
			Idriver.findElement(txtDob).sendKeys(dob);
		}
		
		public void setTaxExempt()
		{
			Idriver.findElement(chkTaxExempt).click();
		}
		
		
		public void clickOnSave()
		{
			Idriver.findElement(btnSave).click();
		}
	}











