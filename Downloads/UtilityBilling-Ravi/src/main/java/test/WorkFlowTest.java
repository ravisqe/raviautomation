package test;

import java.util.Date;

import org.automation.base.BaseTest;
import org.automation.pageObjects.EditUser;
import org.automation.pageObjects.LoginPage;
import org.automation.pageObjects.WorkFlow;
import org.automation.utilities.PropertiesUtil;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WorkFlowTest extends BaseTest {
	
	public  Select select;
	public  Date date = new Date();

	@Test(priority = 1,description = "To Edit User ")
	public void workFlowTypes()  {
		WorkFlow wft = new WorkFlow();
		wft.clickAdmin();
		wft.clickWorkFlowTypes();
		wft.clickCreateNewlog();
	    String clname=date.toString();
		clname= clname.replace(":", "");
		clname=clname.replace(" ", "");
		wft.enterTypename("AA TN"+clname);
		wft.enterDisplayName("AA DN"+clname);
	    wft.clickSaveButton();
	    wft.clickSaveButton();
	    wft.enterSearchLog("AA TN"+clname);  
	  //  Assert.assertEquals(false, true);
  }
}
	
