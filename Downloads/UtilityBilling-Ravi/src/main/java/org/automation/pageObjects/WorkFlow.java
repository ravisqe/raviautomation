package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.ActionEngine;
import org.openqa.selenium.By;

public class WorkFlow {
	
	
	By adminTab = By.xpath("(//*[@class='icon-lock'])[2]");
    By workFlowTypes = By.xpath("(//*[@class='quick-button-small'])[22]");
    By createNewLog = By.id("addBtn");
    By displayNameField = By.xpath("//*[@name='display_name']");
	By typeNameField = By.xpath("//*[@name='type_name']");
	By saveButton = By.xpath("//button[@class='btn btn-primary save-logtype']");
	By searchLog = By.xpath("//*[@id=\"datatableLogType_filter\"]/label/input");
	By firstRecord = By.xpath("//tbody[@id='logtypeListBody']//tr[1]//td[]");
    
    
    
	
	public void clickAdmin() {
		ActionEngine.clickBtn_custom(adminTab);
	    }
	
	public void clickWorkFlowTypes() {
		ActionEngine.clickBtn_custom(workFlowTypes);
	    }
	public void clickCreateNewlog() {
		ActionEngine.clickBtn_custom(createNewLog);
	}
	
	public void enterDisplayName(String userNameText ) {
		ActionEngine.sendKeys_custom(displayNameField, userNameText);
	    }
	
	public void enterTypename(String userNameText ) {
		ActionEngine.sendKeys_custom(typeNameField, userNameText);
	    }
	
	public void clickSaveButton() {
		ActionEngine.clickBtn_custom(saveButton);
	    }
	
	public void enterSearchLog(String userNameText ) {
		ActionEngine.sendKeys_custom(searchLog, userNameText);
	    }
	
}
