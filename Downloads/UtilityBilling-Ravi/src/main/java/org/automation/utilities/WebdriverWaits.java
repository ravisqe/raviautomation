package org.automation.utilities;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.automation.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverWaits extends BaseTest {
	/**
	 * Waits for a given element to be visible
	 * 
	 * @param driver WebDriver instance
	 * @param locator By of the element to wait for
	 */
	public static void waitForElementVisible( By locator,long waitTime){
	    WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	
	/**
	 * Waits for a given element to be visible
	 * 
	 * @param driver WebDriver instance
	 * @param e element to wait for
	 */
	public static void waitForElementVisible( By locator,  int waitTime)
	{		
		WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
		WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}

	
	/**
	 * Waits for a given element to be selected
	 * 
	 * @param driver WebDriver instance
	 * @param locator By of the element to wait for
	 */
	public static void waitForElementSelected(By locator,int waitTime)
	{
	    WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
	    Boolean bool = wait.until(ExpectedConditions.elementToBeSelected(locator));
	}
	
	
	/**
	 * Waits for a given element to be clickable
	 * 
	 * @param driver WebDriver instance
	 * @param locator By to locate element to wait for
	 */
	public static void waitForElementClickable(By locator, int waitTime)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
		WebElement e = wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public static WebElement waitForElementUntilVisible(By locator, int waitTime)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return e;
	}
	
	/**
	 * Waits for the page to have a given title
	 * 
	 * This method is an attempt to address a problem where Chrome/IE drivers
	 * are trying to check the page title on page load before the title has
	 * changed to that of the new page. 
	 * 
	 * @param driver WebDriver instance
	 * @param title title the page should have
	 */
	public static boolean waitForPageTitle(String title, int waitTime){
		WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
		return wait.until(ExpectedConditions.titleContains(title));
	}
	
	

	/**
	 * Sleep script for the specified length
	 * (generally not an ideal solution)
	 * 
	 * @param length
	 */
	public static void sleep(long length){
	    try {
	        Thread.sleep(length);
	    } catch (InterruptedException e) {
			/*
			 * Log.error("Sleep Interrupted"); e.printStackTrace();
			 */
	    }
	}
	    public static void fluentWait_ElementLocated (long waitTimeForTimeout, long waitTimeForPolling,By locator)
	    {
	    	Wait<WebDriver> wait = new FluentWait<>(getDriver())
	    			  .withTimeout(waitTimeForTimeout, TimeUnit.SECONDS)
	    			  .pollingEvery(waitTimeForPolling,TimeUnit.SECONDS)
	    			  .ignoring(NoSuchElementException.class);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	    			
	    
	}
	
	
}
