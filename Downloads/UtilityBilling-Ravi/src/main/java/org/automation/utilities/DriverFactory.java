//package org.automation.utilities; /**
// * Author: Prakash Narkhede
// * Blog: www.AutomationTalks.com
// * LinkedIn: https://www.linkedin.com/in/panarkhede89/
// */
//
//
//import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
//import org.openqa.selenium.Capabilities;
//import org.openqa.selenium.Proxy;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
///**
// * Author: Prakash Narkhede
// * Blog: www.AutomationTalks.com
// * LinkedIn: https://www.linkedin.com/in/panarkhede89/
// */
//
//import org.openqa.selenium.WebDriver;
//
//	public class DriverFactory {
//
//		//Singleton design Pattern
//		//private constructor so that no one else can create object of this class
//		private DriverFactory() {
//
//		}
//
//		private static DriverFactory instance  = new DriverFactory();
//
//		public static DriverFactory getInstance() {
//			return instance;
//		}
//
//
//		//factory design pattern --> define separate factory methods for creating objects and create objects by calling that methods
//		ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
//
//		public WebDriver getDriver() {
//			return driver.get();
//		}
//
//		public void setDriver(WebDriver driverParm) {
//			driver.set(driverParm);
//		}
//
//
//		public void closeBrowser() {
//			driver.get().quit();
//			driver.remove();
//		}
//	}
//
//
