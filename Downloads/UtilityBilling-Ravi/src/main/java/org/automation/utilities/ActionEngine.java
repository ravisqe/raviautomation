package org.automation.utilities;

import org.automation.base.BasePage;
import org.automation.base.BaseTest;
import org.automation.elements.Button;
import org.automation.elements.CheckBox;
import org.automation.elements.DropDown;
import org.automation.elements.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.Status;
import org.testng.Assert;



    public class ActionEngine   {

    	public static String text;
        public static void sendKeys_custom( By path, String valueToBeSent,String... fieldName) {
        	String var="";
        	try {
            	 var =fieldName.length > 0 ? (String)fieldName[0]  : path.toString() ;
            	Element element = new Element( var,  path);
                element.getWebElement().sendKeys(valueToBeSent);
                //log success message in extent report
               // ExtentFactory.getInstance().getExtent().log(Status.PASS,"Entered value as: "+valueToBeSent);
            } catch (Exception e) {
                //log failure in extent
              //  ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Value enter in field: is failed due to exception: "+e);
            }
        }

        public static void sendKeys_withClear(By path ,String valueToBeSent,String... fieldName) {
           
        	String var="";
        	try {
            	 var =fieldName.length > 0 ? (String)fieldName[0]  : path.toString() ;
            	Element element = new Element(var,path);
            	element.clear();
                element.getWebElement().sendKeys(valueToBeSent);;
                //log success message in extent report
                ExtentFactory.getInstance().getExtent().log(Status.PASS,"Ented value as: ");
            } catch (Exception e) {
              //  log failure in extent
              //  ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Value enter in field: is failed due to exception: "+e);
            }
        }


        //custom click method to log evey click action in to extent report
        public static void clickBtn_custom(By path, String... fieldName) {
        	String var="";
            try {
            	 var =fieldName.length > 0 ? (String)fieldName[0]  : path.toString() ;

            	Button btn =  new Button(var,path);
            	btn.click();
                //log success message in exgent report
                ExtentFactory.getInstance().getExtent().log(Status.PASS, var+"==> Clicked Successfully! ");
            } catch (Exception e) {
                //log failure in extent
               // ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Unable to click on field: " +fieldName +" due to exception: "+e);
            }
        }


        //clear data from field
        public static void clear_custom(By element) {
            try {
            	
                ((WebElement) element).clear();
                Thread.sleep(250);
                ExtentFactory.getInstance().getExtent().log(Status.PASS,"==> Data Cleared Successfully! ");
            } catch (Exception e) {
                ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Unable to clear Data on field:  due to exception: "+e);

            }
        }

        //custom mouseHover
        public  static void moveToElement_custom(By element,String fieldName){
//            try{
//                JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
//                executor.executeScript("arguments[0].scrollIntoView(true);", element);
//                Actions actions = new Actions(DriverFactory.getInstance().getDriver());
//                actions.moveToElement(element).build().perform();
//                ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+"==> Mouse hovered Successfully! ");
//                Thread.sleep(1000);
//            }catch(Exception e){
//                ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Unable to hover mouse on field: " +fieldName +" due to exception: "+e);
//
//            }
        }


        //check if element is Present
        public static boolean isElementPresent_custom(WebElement element,String fieldName){
            boolean flag = false;
            try {
                flag = element.isDisplayed();
                ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+"==> Presence of field is: "+ flag);
                return flag;
            } catch (Exception e) {
                ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Checking for presence of field: " +fieldName +" not tested due to exception: "+e);
                return flag;
            }
        }


        //Select dropdown value value by visibleText
        public  static void selectDropDownByVisibleText_custom(By path, String ddVisibleText, String... fieldName)  {
            
        	String var="";
        	try {
            	 var =fieldName.length > 0 ? (String)fieldName[0]  : path.toString() ;
            	DropDown dd= new DropDown(var,path);
                   dd.selectByVisibleText(ddVisibleText);
             //   ExtentFactory.getInstance().getExtent().log(Status.PASS, var+"==> Dropdown Value Selected by visible text: "+ ddVisibleText);
            } catch (Exception e) {
            //    ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Dropdown value not selected for field: " +var +"  due to exception: "+e);
            }
        }
        

        //Select dropdown value value by value
        public static void selectDropDownByValue_custom(By path,String ddValue,String... fieldName) 
        {
        	String var="";
            try {
            	 var =fieldName.length > 0 ? (String)fieldName[0]  : path.toString() ;
            	DropDown dd= new DropDown(var,path);
            	dd.selectByValue(ddValue);
             //   ExtentFactory.getInstance().getExtent().log(Status.PASS, var+"==> Dropdown Value Selected by visible text: "+ ddValue);
            } catch (Exception e) {
             //   ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Dropdown value not selected for field: " +var +"  due to exception: "+e);
            }
        }
        //Select dropdown list by index
        public static void  selectDropDownByIndex_custom(By  path,int ddValue, String... fieldName) 
        {
        	String var="";
            try {
            	 var =fieldName.length > 0 ? (String)fieldName[0]  : path.toString() ;
            	DropDown dd= new DropDown(var,path);
            	dd.selectByIndex(ddValue);
             //   ExtentFactory.getInstance().getExtent().log(Status.PASS, var+"==> Dropdown Value Selected by visible text: "+ ddValue);
            } catch (Exception e) {
              //  ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Dropdown value not selected for field: " +var +"  due to exception: "+e);
            }
        }

        //String Asserts
        public void assertEqualsString_custom(String expvalue, String actualValue, String locatorName) throws Throwable {
            try {
                if(actualValue.equals(expvalue)) {
                    ExtentFactory.getInstance().getExtent().log(Status.PASS, "String Assertion is successful on field "+ locatorName + " Expected value was: "+ expvalue + " actual value is: "+actualValue);
                }else {
                    ExtentFactory.getInstance().getExtent().log(Status.FAIL, "String Assertion FAILED on field "+ locatorName + " Expected value was: "+ expvalue + " actual value is: "+actualValue);
                    Assert.assertTrue(false);
                }
            } catch (Exception e) {
                Assert.assertTrue(false, e.toString());
            }
        }

        //Get text from webelement
        public static  String getText_custom(By path) {
            text = "";
            try {
            	
            	Element element=new Element("",path);
                text = element.getText();
              //  ExtentFactory.getInstance().getExtent().log(Status.PASS, "==> Text retried is: "+ text);
                return text;
            } catch (Exception e) {
             //   ExtentFactory.getInstance().getExtent().log(Status.FAIL, "==> Text not retried due to exception: "+ e);

            }
            return text;
        }
        public static void selectCheckBox(By path,String... fieldName) {
       	 String var =fieldName.length > 0 ? (String)fieldName[0]  : path.toString() ;
        	CheckBox checkBox =new CheckBox(var,path);
        	checkBox.check();
         }
        
        public static void uncheckCheckBox(By path,String... fieldName) {
          	 String var =fieldName.length > 0 ? (String)fieldName[0]  : path.toString() ;
           	CheckBox checkBox =new CheckBox(var,path);
           	checkBox.uncheck();
            }
        public static boolean getCheckBoxValue(By path,String... fieldName) {
         	 String var =fieldName.length > 0 ? (String)fieldName[0]  : path.toString() ;
          	CheckBox checkBox =new CheckBox(var,path);
          	return checkBox.isChecked();
           }
    }

