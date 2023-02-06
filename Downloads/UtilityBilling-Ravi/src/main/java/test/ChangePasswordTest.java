package test;

import java.util.Date;

import org.automation.base.BaseTest;
import org.automation.pageObjects.ChangePassword;
import org.automation.pageObjects.EditUser;
import org.automation.pageObjects.LoginPage;
import org.automation.pageObjects.WorkFlow;
import org.automation.utilities.PropertiesUtil;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChangePasswordTest extends BaseTest {
	
	@Test(priority = 1,description = "Change Password")
	public void changePassword()  {
		ChangePassword cp = new ChangePassword();
		cp.clickAdmin();
		cp.clickPassword();
		cp.enterNewPassword("sqe.user");
		cp.ReEnterNewPassword("sqe.user");
		cp.clickChangePassword();
		cp.clickConfirmPopup();
		cp.getInformationMessage();
  }
}