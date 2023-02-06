package org.automation.pageObjects;

import org.automation.base.BasePage;
import org.openqa.selenium.By;


public class LoginPage extends BasePage {
    BasePage base = new BasePage();
     
	By userNameField=By.xpath("//input[@name='j_username']");
	By PasswordField = By.xpath("//input[@name='predigpass']");
	By login = By.xpath("//*[@name='submit']");

	public void enterUsername(String userNameText) {
		base.sendKeys_custom(userNameField, userNameText);
	}
	
		public void enterPassword(String passNameText)  {
		base.sendKeys_custom(PasswordField ,passNameText);
     }
		
		public void clickLoginBtn() {
			base.clickBtn_custom(login);
    }
		public void login(String userName,String password)  {
			enterUsername(userName);
			enterPassword(password);
			clickLoginBtn();
    }
}
