package test;

import org.automation.base.BaseTest;
import org.automation.pageObjects.ChargePage;
import org.automation.pageObjects.CreateServicePage;
import org.automation.pageObjects.CustomerPage;
import org.automation.pageObjects.LoginPage;
import org.automation.pageObjects.PaymentsPage;
import org.automation.utilities.PropertiesUtil;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ElectPayment extends BaseTest

{
	CustomerPage cp = new CustomerPage();
	ChargePage sn = new ChargePage();
	CreateServicePage cs = new CreateServicePage();
	PaymentsPage pp = new PaymentsPage();

	@BeforeClass
	public void login() {
		try {

			LoginPage loginPage = new LoginPage();
			System.out.println(getDriver().getTitle());
			loginPage.login(PropertiesUtil.getPropertyValue("userName"), PropertiesUtil.getPropertyValue("password"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 1, description = "Create a Customer")
	public void createACustomer() throws InterruptedException {
		cp.createCustomer("Business", "SSLabs", "Dino", "Anotonello", "9988907865", "test12@gmail.com", "t12@gmail.com",
				"38 Decca Road", "35 Decca Road", "Goldsborough", "3156", "Australia", "Electricity Residential plan");
	}

	@Test(priority = 2, description = "Create a Retail Electricity Service")
	public void createARetailElectricity() {
		cs.newRetailElectricitySevice("Electricity Flat Template Plan", "Flat Rate", "Consumption");
	}

	@Test(priority = 3, description = "Add a Manual Charge")
	public void addManualCharge() throws InterruptedException {
		sn.addOnceOffCharges(1, "Connection Fee", "Description", "20", "20", "200");
	}

	@Test(priority = 4, description = "Add a Recurring Charge")
	public void addRecurringCharge() throws InterruptedException {
		sn.addNewRecurringCharge(1, 1, "1");
	}

	@Test(priority = 5, description = "Add a Payment from Credit Card")
	public void addPaymentFromCreditCard() throws InterruptedException {
		pp.PaymentsFromCreditCard("Payment", "Credit Card", "test11@gmail.com", "10",
				"Hey!!! this is the comment section under payment tab");
	}

	@Test(priority = 6, description = "Add a Security Deposit")
	public void addSecurityDeposit() throws InterruptedException {
		pp.PaymentsFromCreditCard("Security Deposit", "Deposit", "sqelabs11@gmail.com", "75",
				"Hey!!! this is the comment section under payment tab(Security Tab)");
	}

}
