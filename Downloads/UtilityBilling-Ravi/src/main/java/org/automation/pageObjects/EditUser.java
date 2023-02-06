package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.ActionEngine;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EditUser extends BasePage {
     
	
	By adminTab = By.xpath("(//*[@class='icon-lock'])[2]");
    By usersDetailsBtn = By.xpath("//p[contains(text(),'User Details')]");
    By firstNameField = By.id("firstName");
	By lastNameField = By.id("lastName");
    By saveBtn = By.xpath("//*[@id='btnDetailsSave']");
    By okBtn = By.xpath("//*[@class='btn btn-primary']");
	
	public void clickAdmin() {
	ActionEngine.clickBtn_custom(adminTab);
    }
	
	public void clickUsersDetails() {
	ActionEngine.clickBtn_custom(usersDetailsBtn);
    }
	
	public void enterFirstName(String userNameText) {
	ActionEngine.sendKeys_withClear(firstNameField, userNameText);
	}
	
	public void enterLastName(String userNameText) {
	ActionEngine.sendKeys_withClear(lastNameField, userNameText);
	}
	
	public void clickSaveBtn() {
		ActionEngine.clickBtn_custom(saveBtn, "SaveBtn");
	    }
	
	public void clickOkBtn() {
		ActionEngine.clickBtn_custom(okBtn, "OkBtn Popup");
	    }
   }


