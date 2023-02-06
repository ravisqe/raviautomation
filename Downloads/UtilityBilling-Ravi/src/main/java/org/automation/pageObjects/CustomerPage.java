package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.elements.TextBox;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import test.LoginTest;

public class CustomerPage extends BasePage
{
	BasePage bp=new BasePage();
	Assertions as;
    public  By customerTab = By.xpath("//a[@title='Customer']"); 
	public  By categoryDropdownField = By.xpath("//select[@name='category']");    
	public  By firstNameField= By.xpath("//input[@name='firstName']");
	public  By lastNameField= By.xpath("//input[@name='surname']");
	public  By phoneNumberField= By.xpath("//input[@name='contact_mobile']");
	public  By emailField= By.xpath("//input[@name='contact_email']");
	public  By billingEmailField= By.xpath("//input[@name='billingEmail']");
	public  By addressOneField= By.xpath("//input[@name='hAddress']");
	public  By addressTwoField= By.xpath("//input[@name='hAddress2']");
	public  By cityField= By.xpath("//input[@name='hSuburb']");
	public  By stateField= By.xpath("//input[@name='hState']");
	public  By zipCodeField= By.xpath("//input[@name='pcode']");
	public  By countryField= By.xpath("//input[@name='hCountry']");
	public  By planDropdownField= By.xpath("//select[@name='planNo']");
	public  By physicalAddressTogglebutton= By.xpath("(//span[@class='switch-handle'])[1]");
	public  By saveCustomerbutton= By.xpath("//div[@class='col-lg-12 text-left']/a/i");
	public  By okbutton= By.xpath("//button[contains(text(),'OK')]");
	public  By companyNameField= By.xpath("(//input[@name='company'])[1]");
	public  By successMessageForCustomerCreation= By.xpath("//div[@id='notification']//center");
    String SUCCESS_MESG="Successfully saved customer.";
    
    public By customerID=By.xpath("(//label[@class='col-sm-12 control-label'])[1]");
    
    public void clickCustomerTab()
    
    {
    	ActionEngine.clickBtn_custom(customerTab, "Customers");
    }

    public void selectCategoryDropdownField(String categoryText) 
    {
    	//ActionEngine.clickBtn_custom(categoryDropdownField, "Category");
    	ActionEngine.selectDropDownByVisibleText_custom(categoryDropdownField, categoryText,"Category");
    }
    
    public void enterCompanyNameField(String companyNameText) 
    {
    	ActionEngine.sendKeys_custom(companyNameField, companyNameText, "Company Name");
    }
    public void enterFirstNameField(String firstNameText) 
    {
    	ActionEngine.sendKeys_custom(firstNameField, firstNameText, "First Name");
    }
    
    public void enterLastNameField(String lastnameText) 
    {
    	ActionEngine.sendKeys_custom(lastNameField,lastnameText, "Last Name");
    }
    
    public void enterPhoneNumber(String phoneNumberText) 
    {
    	ActionEngine.sendKeys_custom(phoneNumberField, phoneNumberText, "Phone");
    }
    
    public void enterEmailField(String emailText) 
    {
    	bp.scrollIntoView(emailField);
    	ActionEngine.sendKeys_custom(emailField, emailText, "Email");
    }
    
    public void enterBillingEmailField(String billingEmailText) 
    {
    	ActionEngine.sendKeys_custom(billingEmailField, billingEmailText, "Billing Email");
    }
    
    public void enterAddressOneField(String addressOneText) 
    {
    	ActionEngine.sendKeys_custom(addressOneField,addressOneText, "Address1");
    }
    
    public void enterAddressTwoField(String addressTwoText) 
    {
    	ActionEngine.sendKeys_custom(addressTwoField,addressTwoText, "Address2");
    }
    
    public void enterCityField(String cityText) 
    {
    	ActionEngine.sendKeys_custom(cityField,cityText, "City");
    }
    public void enterStateField(String stateText) 
    {
    	ActionEngine.sendKeys_custom(stateField,stateText, "State");
    }
    public void enterZipCodeField(String zipCodeText) 
    {
    	ActionEngine.sendKeys_custom(zipCodeField,zipCodeText, "State");
    }
    
    public void enterCountryField(String countryText) 
    {
    	ActionEngine.sendKeys_custom(countryField,countryText, "Country");
    }
    public void selectPlanDropdownField(String PlanText) 
    {
    	ActionEngine.clickBtn_custom(planDropdownField, "Plan");
    	ActionEngine.selectDropDownByVisibleText_custom(planDropdownField, PlanText,"Plan ");	
    }
    public void clickPhysicalAddressToggleBtn() 
    {
    	ActionEngine.clickBtn_custom(physicalAddressTogglebutton, "Use Physical Address ?");
    }
    public void clickSaveCustomerBtn() 
    {
    	bp.scrollIntoView(saveCustomerbutton);
    	ActionEngine.clickBtn_custom(saveCustomerbutton, "Save Customer");
    }
    public void clickOkBtn() 
    {
    	ActionEngine.clickBtn_custom(okbutton, "Ok");
    }
    
    public String getCustomerId()
    {
    	return ActionEngine.getText_custom(customerID);
    	
    	
    }
    
    public String getSuccessMsgText()
    
    {
    	WebdriverWaits.waitForElementVisible(successMessageForCustomerCreation, 5);
    	return ActionEngine.getText_custom(successMessageForCustomerCreation);
    }
    
    public String createCustomer(String category , String companyName, String firstName, String lastName, String phoneNumber, String email, String billingEmail, String addressOne, String addressTwo, String city , String zipCode, String country,String plan) throws InterruptedException
    {
    	as=new Assertions();
        clickCustomerTab();
    	selectCategoryDropdownField(category);
    	enterCompanyNameField(companyName);
    	Thread.sleep(1000);
    	enterFirstNameField(firstName);
    	enterLastNameField(lastName);
    	enterPhoneNumber(phoneNumber);
    	enterEmailField(email);
    	enterBillingEmailField(billingEmail);
    	enterAddressOneField(addressOne);
    	enterAddressTwoField(addressTwo);
    	enterCityField(city);
    	enterZipCodeField(zipCode);
    	enterCountryField(country);
    	selectPlanDropdownField(plan);
    	clickPhysicalAddressToggleBtn();
    	clickSaveCustomerBtn();
    	clickOkBtn();
    	as.assertStrings(getSuccessMsgText(), SUCCESS_MESG);
    	return getCustomerId();
	}
    }

