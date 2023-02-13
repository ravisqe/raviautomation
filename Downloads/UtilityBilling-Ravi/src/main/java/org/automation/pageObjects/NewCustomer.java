package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class NewCustomer  extends BasePage {
	BasePage bp=new BasePage();
    String SUCCESS_MESG="Successfully saved customer.";

    public By customer_id = By.xpath("//label[@class=\"col-sm-12 control-label\"]");
    public  By customerTab = By.xpath("//a[@title='Customer']"); 
    public static By CustomerTypedropdown = By.xpath("//select[@id='custTypeEl']");
	public  By categoryDropdownField = By.xpath("//select[@name='category']"); 
	public By Tittle = By.xpath("//input[@name=\"sal\"]");
	public  By firstNameField= By.xpath("//input[@name='firstName']");
	public  By lastNameField= By.xpath("//input[@name='surname']");
	public  By phoneNumberField= By.xpath("//input[@name='contact_mobile']");
	public By Fax = By.xpath("//input[@name='contact_fax']");
	public By Reminder = By.xpath("//input[@name='agedRec']");
	public  By emailField= By.xpath("//input[@name='contact_email']");
	public  By billingEmailField= By.xpath("//input[@name='billingEmail']");
	public  By addressOneField= By.xpath("//input[@name='hAddress']");
	public  By addressTwoField= By.xpath("//input[@name='hAddress2']");
	public  By companyNameField= By.xpath("(//input[@name='company'])[1]");
	public By TradingName = By.xpath("//input[@name='legalEntity']");
	public  By cityField= By.xpath("//input[@name='hSuburb']");
	public  By stateField= By.xpath("//input[@name='hState']");
	public  By zipCodeField= By.xpath("//input[@name='pcode']");
	public  By countryField= By.xpath("//input[@name='hCountry']");
	// Billing Adress Xpath 
	public By Address1 = By.xpath("//input[@name='tmpaddr1']");
	public By Address2 = By.xpath("//input[@name='tmpaddr2']");
	public By CityTown = By.xpath("//input[@name='tmpsuburb']");
	public By State = By.xpath("//input[@name='tmpstate']");
	public By ZipCode = By.xpath("//input[@name='postcode']");
	public By Country = By.xpath("//input[@name='tmpel_country']");
	
	// Authentication Details Xpath 
	public By AccountNameField = By.xpath("//input[@name='crn']");
	public By AuthenticationTypeDropDown = By.xpath("//select[@name='custAuthorityType']");
	public By AuthenticationNoField = By.xpath("//input[@name='custAuthorityNo']");
	public By DOBField = By.xpath("//input[@class='date-picker']");
	public By RefereeField = By.xpath("//input[@name='refName']");
	public By ContactNumberRefereeField = By.xpath("//input[@name='refNumber']");
	public By RefereerelationshiptenantField = By.xpath("//input[@name='refRelationship']");
	//Banking Details Xpath
	
	public By BankAccountName = By.xpath("//input[@name='bankAccountName']");
	public By BankAccountType = By.xpath("//select[@name='bankAccountType']");
	public By BankAccountNo = By.xpath("//input[@name='bankAccountNo']");
	public By BankRoute = By.xpath("//input[@name='bankBSB']");
	public By BankName = By.xpath("//input[@name='bankName']");
    public By customerID=By.xpath("(//label[@class='col-sm-12 control-label'])[1]");


	public  By planDropdownField= By.xpath("//select[@name='planNo']");
	public  By physicalAddressTogglebutton= By.xpath("(//span[@class='switch-handle'])[1]");
	public  By saveCustomerbutton= By.xpath("//div[@class='col-lg-12 text-left']/a/i");
	public  By okbutton= By.xpath("//button[contains(text(),'OK')]");
	public  By successMessageForCustomerCreation= By.xpath("//div[@id='notification']//center");
	
	public By CustomerPortalToogle = By.xpath("//label[text()='Allow Access']/following::span[1]");
	public By NewCustomerDefaultToggle1 = By.xpath("//input[@name=\"defaultInvoiceSetting\"]/following::span[1]");
	public By NewCustomerDefaultToggle2 = By.xpath("//input[@name=\"defaultBillingOption\"]/following::span[1]");
	public By CustomerPortalPassword = By.xpath("//input[@name='password']");
	public By Note = By.xpath("//textarea[@name=\"notes\"]");

	 

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
	    	 String id = ActionEngine.getText_custom(customerID);
	    	 System.out.println(id);
	    	   return id ;
	    	
	    	
	    }
	    
	    public String getSuccessMsgText()
	    
	    {
	    	WebdriverWaits.waitForElementVisible(successMessageForCustomerCreation, 10);
	    	return ActionEngine.getText_custom(successMessageForCustomerCreation);
	    }

	
    public void clickCustomerTab()
    
    {
    	ActionEngine.clickBtn_custom(customerTab, "Customers");
    }
    
    public void enterAccountType(String CustomerTypeText,String categoryText)
    {
    	 ActionEngine.selectDropDownByValue_custom(CustomerTypedropdown, CustomerTypeText, "CustomerType");
     	ActionEngine.selectDropDownByVisibleText_custom(categoryDropdownField, categoryText,"Category");
    }

    public void enterCompanyDetails(String companyNameText,String TradingNameText)
    {
    	ActionEngine.sendKeys_custom(companyNameField, companyNameText, "Company Name");
   	    ActionEngine.sendKeys_custom(TradingName, TradingNameText);

    }
    public void enterGeneralDetails(String TittleText,String firstNameText,String lastnameText,String phoneNumberText, String FaxText,String emailText,String billingEmailText,String reminderText)
    {
   	 ActionEngine.sendKeys_custom(Tittle, TittleText, "Tittle");
 	ActionEngine.sendKeys_custom(firstNameField, firstNameText, "First Name");
	ActionEngine.sendKeys_custom(lastNameField,lastnameText, "Last Name");
	ActionEngine.sendKeys_custom(phoneNumberField, phoneNumberText, "Phone");
	 ActionEngine.sendKeys_custom(Fax, FaxText,"Fax");
	 bp.scrollIntoView(emailField);
 	ActionEngine.sendKeys_custom(emailField, emailText, "Email");
	ActionEngine.sendKeys_custom(billingEmailField, billingEmailText, "Billing Email");
	 ActionEngine.sendKeys_custom(Reminder, reminderText, "reminder");

    }

    	public void enterPhysicalAddressDetails(String addressOneText,String addressTwoText,String cityText,String stateText,String zipCodeText,String countryText)
    	{
	    	ActionEngine.sendKeys_custom(addressOneField,addressOneText, "Address1");
	    	ActionEngine.sendKeys_custom(addressTwoField,addressTwoText, "Address2");
	    	ActionEngine.sendKeys_custom(cityField,cityText, "City");
	    	ActionEngine.sendKeys_custom(stateField,stateText, "State");
	    	ActionEngine.sendKeys_custom(zipCodeField,zipCodeText, "Zip Code");
	    	ActionEngine.sendKeys_custom(countryField,countryText, "Country");
    	}
    	public void enterBillingAddressDetails(String addressOneText,String addressTwoText,String cityText,String stateText,String zipCodeText,String countryText)
    	{   
     	    	ActionEngine.sendKeys_custom(Address1,addressOneText, "Address1");
     	    	ActionEngine.sendKeys_custom(Address2,addressOneText, "Address2");
     	    	ActionEngine.sendKeys_custom(CityTown,cityText, "City");  
     	    	ActionEngine.sendKeys_custom(State,stateText, "State");
     	    	ActionEngine.sendKeys_custom(ZipCode,zipCodeText, "State");
     	    	ActionEngine.sendKeys_custom(Country,countryText, "Country");
     	    }
    	public void enterAuthenticationDetails(String AccountNameFieldText,String AuthenticationTypeDropDownText,String AuthenticationNoFieldText,String DOBFieldText, String RefereeFieldText, String ContactNumberRefereeText,String RefereerelationshiptenantText)
    	{
	    	ActionEngine.sendKeys_custom(AccountNameField,AccountNameFieldText, "Account Name");
	     	ActionEngine.selectDropDownByVisibleText_custom(AuthenticationTypeDropDown, AuthenticationTypeDropDownText,"Authentication Type");
	    	ActionEngine.sendKeys_custom(AuthenticationNoField,AuthenticationNoFieldText, "Authentication No.");
	    	ActionEngine.sendKeys_custom(DOBField,DOBFieldText, "DOBField");
	    	ActionEngine.sendKeys_custom(RefereeField,RefereeFieldText, "Name of Referee");
	    	ActionEngine.sendKeys_custom(ContactNumberRefereeField,ContactNumberRefereeText, "Contact Number of Referee");
	    	ActionEngine.sendKeys_custom(RefereerelationshiptenantField,RefereerelationshiptenantText, "Referee relationship to tenant");

    	}

    	public void enterBankingDetails(String BankAccountNameFieldText,String BankAccountTypeText,String BankAccountNoFieldText,String BankRoutefieldText,String BankNameText)
    	{
	    	ActionEngine.sendKeys_custom(BankAccountName,BankAccountNameFieldText, "Bank Account Name");
	     	ActionEngine.selectDropDownByVisibleText_custom(BankAccountType, BankAccountTypeText,"Bank Account Type");
	    //	ActionEngine.sendKeys_custom(BankAccountType,BankAccountTypeText, "Bank Account Type");
	    	ActionEngine.sendKeys_custom(BankAccountNo,BankAccountNoFieldText, "Bank Account No.");
	    	ActionEngine.sendKeys_custom(BankRoute,BankRoutefieldText, "Bank Route");
	    	ActionEngine.sendKeys_custom(BankName, BankNameText, "Bank Name");
    	}
      	    
    	    public void selectPlanDropdownField(String PlanText) 
    	    {
    	    	ActionEngine.clickBtn_custom(planDropdownField, "Plan");
    	    	ActionEngine.selectDropDownByVisibleText_custom(planDropdownField, PlanText,"Plan ");	
    	    }
    	        
    	 public void entercustomerPortaldetails(String AllowAccessToggleText,String PasswprdText)
    	  {
    		  
 	    	ActionEngine.clickBtn_custom(CustomerPortalToogle, "Allow Access");
 	    	
 	    	ActionEngine.sendKeys_custom(CustomerPortalPassword, PasswprdText, "Password");
 	    	ActionEngine.clickBtn_custom(CustomerPortalPassword, "Password");

    	 }
    	 
    	    
    	  public void newCustomerDefaultSetting(String ToggleText1,String ToggleText2 )
    	  {
   	    	ActionEngine.clickBtn_custom(NewCustomerDefaultToggle1, "Apply Group's Invoice Setting?");
   	    	ActionEngine.clickBtn_custom(NewCustomerDefaultToggle2, "Apply Group's Billing Option?");

    	  }
    	  public void enterNoteAndSave(String NoteText)
    	  {
    		   ActionEngine.sendKeys_custom(Note, NoteText, "Notes");
    	    	bp.scrollIntoView(saveCustomerbutton);
    		   ActionEngine.clickBtn_custom(saveCustomerbutton, "Save Customer");
    		   ActionEngine.clickBtn_custom(okbutton, "OK");
    	  }
    	  public void getCustomerIdText()
    	  {
    		    String ID = getText_custom( customer_id);
    		    System.out.println(ID);
    	  }
    	  
    	  public String createCustomer(String category , String companyName, String firstName, String lastName, String phoneNumber, String email, String billingEmail, String addressOne, String addressTwo, String city , String zipCode, String country,String plan) throws InterruptedException
    	    {
    	    	Assertions as=new Assertions();
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

   
   
    public String createCustomer( String CustomerType,String category ,String companyName, String Tradename,String Tittle, String firstName, String lastName, String phoneNumber, String Fax, String email, String billingEmail, String reminder, String addressOne, String addressTwo, String city, String state,String ZipCode1,String AddressCompany,String Address1,String Address2,String City,String State,String ZipCode,String Country ,String AccountName, String AuthenticationType,String AuthenticationNo,String DOB,String Refrence,String Contactno,String RefreeRelationship,String BankAccountName,String BankAccountType,String BankAccountNo,String BankRoute,String BankName,String a,String b,String Note) throws InterruptedException
    {
    	Assertions as=new Assertions();

        clickCustomerTab();
        enterAccountType(CustomerType,category);
        if (category.equals("Business")|| category.equals("Commercial")) {
            enterCompanyDetails(companyName,Tradename);
        }
      enterGeneralDetails(Tittle,firstName,lastName,phoneNumber,Fax,email,billingEmail,reminder);
      enterPhysicalAddressDetails(addressOne,addressTwo,city,state,ZipCode1,AddressCompany);
      enterBillingAddressDetails(addressOne,addressTwo,city,state,ZipCode1,AddressCompany); 
      enterAuthenticationDetails(AccountName,AuthenticationType, AuthenticationNo, DOB, Refrence, Contactno, RefreeRelationship);
      enterBankingDetails(BankAccountName, BankAccountType, BankAccountNo, BankRoute, BankName);
      entercustomerPortaldetails(a,b); 
      enterNoteAndSave(Note);
      //ne wline added
      Thread.sleep(5000);

  	return getCustomerId();
	
    }
    }
