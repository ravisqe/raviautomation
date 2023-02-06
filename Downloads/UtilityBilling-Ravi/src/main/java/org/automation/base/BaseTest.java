package org.automation.base;

import static java.io.File.separator;
import static java.lang.System.getProperty;
import static java.nio.file.Files.lines;
import static java.nio.file.Paths.get;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;
import static org.automation.logger.Log.error;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.automation.listeners.TestReporter;
import org.automation.listeners.TestRunListener;
import org.automation.pageObjects.LoginPage;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.BrowserFactory;
import org.automation.utilities.PropertiesUtil;
import org.automation.utilities.Screenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;


import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * To extend every test class created.
 * 
 * @author Sujay Sawant
 * @version 1.0.0
 * @since 6/11/2020
 *
 */



@Listeners({ TestRunListener.class, TestReporter.class })
public  class BaseTest extends ActionEngine {
	
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	
	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	/**
	 * Method to execute at the start of the suite execution.
	 */

	public static WebDriver getDriver() {
		return  driver.get();
	}
	
	public static void closeDriver() {
		getDriver().close();
		driver.remove();		
	}
	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws MalformedURLException {
		String browser = PropertiesUtil.getPropertyValue("browser");
		String url = 	PropertiesUtil.getPropertyValue("url");
	//	driver.set(new WebDriver(new URL("http://localhost:4444/wd/hub")));
		//driver = (ThreadLocal<WebDriver>) BrowserFactory.getDriver();

	         switch (browser) {
	         case "chrome":
	             WebDriverManager.chromedriver().setup();
	            // driver = new ChromeDriver(BrowserOptions.getChromeOptions());
	              driver.set(new ChromeDriver());
	             break;

	         case "fireFox":
	            // WebDriverManager.firefoxdriver().setup();
	             //driver = new FirefoxDriver(BrowserOptions.getFirefoxOptions());
	             break;
	         default:
	             throw new IllegalStateException("Unexpected value: " + browser);
	     }
	    // driver.set(Objects.requireNonNull(driver));

    	getDriver().manage().window().maximize();
 		getDriver().navigate().to(url);
	}

	/**
	 * Method to execute at the end of each test method execution.
	 */
	
	
	
	@AfterClass(alwaysRun = true)
	public void afterMethod() {
		//clearCookies();
		//closeDriver();
	}

	@BeforeMethod
	public void LaunchApplication() throws Exception {

	}
	
	
	
	
	@BeforeClass
	public void login(){
		try {
	
			LoginPage loginPage = new LoginPage();
		    System.out.println(getDriver().getTitle());
			loginPage.login(PropertiesUtil.getPropertyValue("userName"),PropertiesUtil.getPropertyValue("password"));

		}
	 catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }
	}

	/**
	 * Method to execute at the end of the suite execution
	 */
	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
	}


	/**
	 * Data Provider method to get data from Excel file.
	 * 
	 * @param method test method executed
	 * @return excel data
	 */
	@DataProvider(name = "ExcelDataProvider")
	public Iterator<Object[]> provideData(Method method) {
		List<Object[]> excelData = new ArrayList<Object[]>();
		String pathName = "src" + separator + "test" + separator + "resources" + separator + "ExcelData.xlsx";
		Connection con = null;
		Recordset record = null;
		try {
			Fillo fillo = new Fillo();
			con = fillo.getConnection(pathName);
			record = con.executeQuery("Select * from TestData where TestCase = '"
					+ method.getDeclaringClass().getSimpleName() + "." + method.getName() + "'");
			while (record.next()) {
				Map<String, String> data = new HashMap<String, String>();
				for (String field : record.getFieldNames()) {
					if (!record.getField(field).isEmpty()) {
						data.put(field, record.getField(field));
					}
				}
				excelData.add(new Object[] { data });
			}
		} catch (FilloException e) {
			error("Unable to get data from Excel", e);
			throw new RuntimeException("Could not read " + pathName + " file.\n" + e.getStackTrace().toString());
		} finally {
			con.close();
			record.close();
		}
		return excelData.iterator();
	}

	/**
	 * Data Provider method to get data from CSV file.
	 * 
	 * @param method test method executed
	 * @return CSV data
	 */
	@DataProvider(name = "CsvDataProvider")
	public Iterator<Object[]> getCsvData(Method method) {
		List<Object[]> csvData = new ArrayList<Object[]>();
		String csvRegex = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
		String pathName = "src" + separator + "test" + separator + "resources" + separator + "CsvData.csv";
		try {
			String[] keys = lines(get(pathName)).findFirst().orElseThrow(IOException::new).split(csvRegex);
			List<String[]> dataLines = lines(get(pathName)).filter(
					line -> line.startsWith(method.getDeclaringClass().getSimpleName() + "." + method.getName()))
					.map(line -> line.split(csvRegex)).collect(toList());
			for (String[] values : dataLines) {
				Map<String, String> data = new HashMap<String, String>();
				for (int i = 1; i < keys.length; i++) {
					if (!values[i].isEmpty()) {
						data.put(keys[i], values[i]);
					}
				}
				csvData.add(new Object[] { data });
			}
		} catch (IOException e) {
			error("Unable to get data from Csv", e);
			throw new RuntimeException("Could not read " + pathName + " file.\n" + e.getStackTrace().toString());
		}
		return csvData.iterator();
	}

	/**
	 * Get the user name from the command line.
	 * 
	 * @return user name
	 */
//	protected String getUsername() {
	//	return ofNullable(getProperty("username"))
		//		.orElseThrow(() -> new NullPointerException("Username was not provided"));
	//}

	/**
	 * Get the password from the command line.
	 * 
	 * @return password
	 */
	protected String getPassword() {
		return ofNullable(getProperty("password"))
				.orElseThrow(() -> new NullPointerException("Password was not provided"));
	}
	
	

//	@AfterMethod
//	public void tearDown(ITestResult result) throws IOException {
//
//		if (result.getStatus() == ITestResult.FAILURE) {
//			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName());
//			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
//			System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
//
//			String screenshotPath = Screenshot.getScreenshot(driver, result.getName());
//			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
//			// extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath));
//		} else if (result.getStatus() == ITestResult.SKIP) {
//			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
//			System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
//		} else if (result.getStatus() == ITestResult.SUCCESS) {
//			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());
//			System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
//		}
//		extent.endTest(extentTest);
//	}

	
	

}
