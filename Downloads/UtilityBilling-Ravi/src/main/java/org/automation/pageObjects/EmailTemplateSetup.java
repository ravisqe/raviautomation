package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;

public class EmailTemplateSetup 

{
	BasePage bp = new BasePage();
	Assertions as;
	
	
	public  By TemplateIcon = By.xpath("//i[@class='glyphicon glyphicon-comment']");
	public  By MsgType = By.xpath("//select[@id='email_message_type']");
	public  By Emailfrom = By.xpath("//input[@id='email_rem_from']");
	public  By Emailbcc = By.xpath("//input[@id='email_rem_bcc']");
	public  By Subject = By.xpath("//input[@id='email_rem_subject']");
	public  By SaveEmailTemp = By.xpath("(//button[@id='validtagsEmail'])[2]");
	public  By SavedEmailMsg = By.xpath("//div[@class='alert alert-success']/center/p");
	public  By SMStab = By.xpath("//ul[@id='myTab']/li[2]/a");
	public  By Messagetyp = By.xpath("(//tr[@class='frmTb2'])[5]/td[2]/select");
	public  By SMSmsg = By.xpath("//textarea[@id='sms_rem_message']");
	public  By SaveSMS = By.xpath("(//a[@class='buttonSml'])[2]");
	public  By CustDetailsTab = By.xpath("//ul[@class='nav nav-tabs']/li[2]");
	public  By CustEmailField = By.xpath("//input[@name='contact_email']");
	public  By SaveCust = By.xpath("//a[@id='saveButton']");
	public  By OKbtnn = By.xpath("//button[text()='OK']");
	public  By SavedCustMsg = By.xpath("//div[@id='notification']/center");
	public  By CustNumberCreated = By.xpath("(//a[@class='prevent'])[3]/p/b");
	public  By BillRunCycle = By.xpath("(//div[@class='box-content quicklinksbox'])[6]/div[2]");
	public  By CreateCycle = By.xpath("//a[@id='addBtn']");
	public  By CycleName = By.xpath("//input[@id='cyclename']");
	public  By SearchCustForCycle = By.xpath("//input[@class='filter form-control']");
	public  By SelectCust = By.xpath("//select[@name='custnos_helper1']/option");
	public  By RightArrow = By.xpath("(//i[@class='glyphicon glyphicon-arrow-right'])[3]");
	public  By SaveCyc = By.xpath("//button[@id='saveCycle']");
	public  By CycleSavedSuccess = By.xpath("//span[@id='resultMsg']");
	public  By MainCustSearch = By.xpath("//input[@id='search_input']");
	public  By SearchIcon = By.xpath("//button[@id='btn_search']");
	public  By Admin = By.xpath("//a[@title='Administration']");
	public  By SMTPicon = By.xpath("(//i[@class='icon-hdd'])[2]");
	public  By SrverField = By.xpath("//input[@name='smtpServer']");
	public  By PortField = By.xpath("//input[@name='smtpPort']");
	public  By UserAuthCheckbox = By.xpath("//input[@id='auth']");
	public  By Username = By.xpath("//input[@class='auth-inputs']");
	public  By Password = By.xpath("(//input[@class='auth-inputs'])[2]");
	public  By UpdateSMTPbutton = By.xpath("//a[@class='btn btn-large btn-primary']");

	String SUCCESS_MSG="Successfully saved message.";

	public  By MeterReadsTab = By.xpath("//ul[@class='nav nav-tabs']/li[4]");
	public  By AddRead = By.xpath("//a[@class='btn btn-mini btn-primary addRead']");
	public  By ReadType = By.xpath("//select[@id='modalReadType']");
	public  By ReadDate = By.xpath("//input[@id='modalReadDate']");
	public  By TodayDate = By.xpath("//td[@class='active day']");
	public  By ReadReadings = By.xpath("//input[@id='modalReadingA']");
	public  By SaveReads = By.xpath("(//button[@class='btn btn-primary'])[2]");
	public  By ReadTypeSaved = By.xpath("//tr[@id='0']/td[4]");
	public  By SelectMeterNumbr = By.xpath("//select[@name='meterNo']");
	public  By NextDate = By.xpath("//td[@class='active day']/following-sibling::td");

	public  By BillRunTab = By.xpath("//a[@title='Saas Bill Run']/i");
	public  By RunTheBills = By.xpath("//button[@class='btn btn-success']");
	public  By Reccurringdate = By.xpath("//input[@id='cycleDate']");
	public  By IssueDate = By.xpath("//input[@id='issueDate']");
	public  By DueDate = By.xpath("//input[@id='dueDate']");
	public  By CycleNumber = By.xpath("//select[@id='cycleno']");
	public  By RunBillBtn = By.xpath("//button[@class='btn btn-primary']");
	public  By NextDay = By.xpath("//td[@class='new day']");


	public void clickOnAdminTab() {
		ActionEngine.clickBtn_custom(Admin, "Admin");
	}
	
	public void clickOnTemplateIcon() 
	{
		ActionEngine.clickBtn_custom(TemplateIcon, "Admin");
	}
	
	public void selectMessageDropdownOption(String messageText) 
	{
		ActionEngine.clickBtn_custom(MsgType, "Message Type");
		ActionEngine.selectDropDownByVisibleText_custom(MsgType, messageText, "Message Type");
	}
	
	public void enterEmailBcc(String emailText) 
	{
		ActionEngine.sendKeys_withClear(Emailbcc, emailText, "Email Bcc");
		
	}
	public void enterEmailSubject(String EmailSubjectText) 
	{
		ActionEngine.sendKeys_withClear(Emailbcc, EmailSubjectText, "Email Subject");
		
	}
	
	public void clickOnSaveBtn() 
	{
		bp.scrollIntoView(SaveEmailTemp);
	ActionEngine.clickBtn_custom(SaveEmailTemp, "Save");
		
	}
	
	public String newRowAddUnderRecurringCharge()
	{

		WebdriverWaits.waitForElementVisible(SavedEmailMsg, 40);
		return ActionEngine.getText_custom(SavedEmailMsg);
	}
	
	
	public void emailSetup(String messageText, String emailText, String EmailSubjectText)
	{
		clickOnAdminTab();
		clickOnTemplateIcon() ;
		selectMessageDropdownOption( messageText) ;
		enterEmailBcc( emailText);
		enterEmailSubject( EmailSubjectText);
		clickOnSaveBtn();
		as.assertStrings(newRowAddUnderRecurringCharge(), SUCCESS_MSG);
	}
}
