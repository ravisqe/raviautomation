package org.automation.pageObjects;

import java.util.List;

import org.automation.base.BasePage;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.Assertions;
import org.automation.utilities.WebdriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChargePage extends BasePage {
	BasePage bp = new BasePage();
	Assertions as;
	// Charges
	public By Chargetab = By.xpath("//a[text()=' Charges']");
	public By AddIconForManualCharge = By.xpath("//a[@title='Add Charge']");
	public By ServiceDropdownField = By.xpath("//select[@name='lineSeqNo']");
	public By ChargeDescriptionField = By.xpath("//input[@name='description']");
	public By RollupDescriptionField = By.xpath("//input[@name='rollupDescription']");
	public By unitsField = By.xpath("//input[@name='units']");
	public By rateField = By.xpath("//input[@name='rate']");
	public By ActiveDayField = By.xpath("//td[@class='active day']");
	public By PriceChargeDollarField = By.xpath("//input[@name='price_charge_dollar']");
	public By SaveButton = By.xpath("//a[@value='Save']");
	public By ClickOnDatepickerField = By.xpath("//input[@id='dateStart']");
	public By clickOnOkButton = By.xpath("//button[@class='btn btn-default'])[2]");
	String SUCCESS_MSG = "Showing 1 to 1 of 1 entries";
	public By entryMsgOnAddingManualMessage = By.xpath("(//div[@class='dataTables_info'])[1]");
	// Recurring Charges
	public By AddIconForRecurringCharge = By.xpath("(//i[@class='icon-plus'])[2]");
	public By ServiceDropdownRecurringField = By.xpath("//select[@name='lineSeqNo']");
	public By CodeField = By.xpath("//select[@name='code']");
	public By CurrentDateField = By.xpath("//td[@class='active day']");
	public By PlanNameField = By.xpath("//input[@name='planName']");
	public By NumberOfPeriodsField = By.xpath("//input[@name='cycleInMonth']");
	public By ChargeOngoingField = By.xpath("//input[@name='chargeOngoing']");
	public By entryMsgOnAddingRecurringMessage = By.xpath("(//div[@class='dataTables_info'])[2]");

	public void clickOnChargeTab() {
		ActionEngine.clickBtn_custom(Chargetab, "Charge");
	}

	public void clickOnSaveBtn() {
		ActionEngine.clickBtn_custom(SaveButton, "Save");
	}

	public void clickOnPlusIcon() {
		ActionEngine.clickBtn_custom(AddIconForManualCharge, "Plus Icon");
	}

	public void selectService(int serviceByIndex) {
		ActionEngine.clickBtn_custom(ServiceDropdownField, "Service");
		ActionEngine.selectDropDownByIndex_custom(ServiceDropdownField, serviceByIndex, "Service");
	}

	public void enterChargeDesciption(String chargeDescriptionText) {
		ActionEngine.sendKeys_custom(ChargeDescriptionField, chargeDescriptionText, " Charge Desciption");
	}

	public void enterRollupDesciption(String rollupDescriptionText) {
		ActionEngine.sendKeys_custom(RollupDescriptionField, rollupDescriptionText, " Rollup Desciption");
	}

	public void enterStartDate() {
		ActionEngine.clickBtn_custom(ClickOnDatepickerField, "Start Date");
		ActionEngine.clickBtn_custom(ActiveDayField, "Datepicker");
	}

	public void enterUnitsRate(String unitText) {
		bp.scrollIntoView(unitsField);
		ActionEngine.sendKeys_custom(unitsField, unitText, "Unit");
	}

	public void enterFlatRate(String rateText) {
		ActionEngine.sendKeys_custom(rateField, rateText, "Rate");
	}

	public void enterPriceChargeDollar(String PriceChargetext) {
		ActionEngine.sendKeys_custom(PriceChargeDollarField, PriceChargetext, "Charge");
	}

	public void clickOkButton() {
		ActionEngine.clickBtn_custom(clickOnOkButton, "Ok");
	}

	public void clickOnRecurringPlusIcon() {
		ActionEngine.clickBtn_custom(AddIconForRecurringCharge, "Plus Icon ");
	}

	public void enterServiceDropdownOption(int serviceText) {
		ActionEngine.clickBtn_custom(ServiceDropdownRecurringField, "Service");
		ActionEngine.selectDropDownByIndex_custom(ServiceDropdownRecurringField, serviceText, "Service");
	}

	public void enterChargeDescriptionDropdownOption(int chargeText) {
		ActionEngine.clickBtn_custom(CodeField, "Charge Description");
		ActionEngine.selectDropDownByIndex_custom(CodeField, chargeText, "Charge Description");
	}

	public void clickOnGoingToggleBtn() {
		ActionEngine.clickBtn_custom(ChargeOngoingField, "On Going - always Recurring");
	}

	public void enterPeriodOFCharge(String PeriodOfChargeText) {
		ActionEngine.sendKeys_custom(NumberOfPeriodsField, PeriodOfChargeText, "Period Of Charge");
	}

	public String newRowAddUnderManualCharge() {
		WebdriverWaits.waitForElementVisible(entryMsgOnAddingManualMessage, 40);
		return ActionEngine.getText_custom(entryMsgOnAddingManualMessage);
	}

	public String newRowAddUnderRecurringCharge() {
		WebdriverWaits.waitForElementVisible(entryMsgOnAddingRecurringMessage, 40);
		return ActionEngine.getText_custom(entryMsgOnAddingRecurringMessage);
	}

	public void addOnceOffCharges(int selectServiceIndex, String ChargeDescriptionText, String rollUpText,
			String unitRateText, String flatRateText, String priceChargeText) throws InterruptedException {
		as = new Assertions();
		clickOnChargeTab();
		clickOnPlusIcon();
		selectService(selectServiceIndex);
		enterChargeDesciption(ChargeDescriptionText);
		Thread.sleep(3000);
		enterRollupDesciption(rollUpText);
		enterStartDate();
		enterUnitsRate(unitRateText);
		enterFlatRate(flatRateText);
		enterPriceChargeDollar(priceChargeText);
		clickOnSaveBtn();
		as.assertStrings(newRowAddUnderManualCharge(), SUCCESS_MSG);

	}

	public void addNewRecurringCharge(int serviceText, int chargeText, String PeriodOfChargeText)
			throws InterruptedException {
		as = new Assertions();
		clickOnRecurringPlusIcon();
		enterServiceDropdownOption(serviceText);
		Thread.sleep(3000);
		enterChargeDescriptionDropdownOption(chargeText);
		enterStartDate();
		Thread.sleep(2000);
		clickOnGoingToggleBtn();
		enterPeriodOFCharge(PeriodOfChargeText);
		clickOnSaveBtn();
		as.assertStrings(newRowAddUnderRecurringCharge(), SUCCESS_MSG);

	}

}
