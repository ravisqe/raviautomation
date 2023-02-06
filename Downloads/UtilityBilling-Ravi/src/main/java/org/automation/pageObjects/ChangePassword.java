package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.automation.utilities.ActionEngine;
import org.openqa.selenium.By;

public class ChangePassword {
	
	By adminTab = By.xpath("(//*[@class='icon-lock'])[2]");
	By passwordTab = By.xpath("//p[contains(text(),'Password')]");
    By newPasswordField = By.xpath("//input[@id='predigpass']");
    By reNewPassword = By.xpath("//input[@id='repredigpass']");
    By changePasswordBtn = By.xpath("//*[@class='buttonLrg']");
    By confirmationPopUp = By.xpath("//button[@class='btn btn-primary']");
    By informationMessage = By.xpath("//p[@class='message']");
    
    
	
    public void clickAdmin() {
		ActionEngine.clickBtn_custom(adminTab);
	    }
    
    public void clickPassword() {
		ActionEngine.clickBtn_custom(passwordTab);
	    }

    public void enterNewPassword(String userNameText ) {
		ActionEngine.sendKeys_custom(newPasswordField, userNameText);
	    }
    
    public void ReEnterNewPassword(String userNameText ) {
		ActionEngine.sendKeys_custom(reNewPassword, userNameText);
	    }

    public void clickChangePassword() {
		ActionEngine.clickBtn_custom(changePasswordBtn);
	    }
    
    public void clickConfirmPopup() {
		ActionEngine.clickBtn_custom(confirmationPopUp);
	    }
    
    public void getInformationMessage() {
		ActionEngine.clickBtn_custom(informationMessage);
	    }
}
