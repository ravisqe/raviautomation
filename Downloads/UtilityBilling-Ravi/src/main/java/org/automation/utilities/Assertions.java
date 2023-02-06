package org.automation.utilities;

import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class Assertions {
	
	
	public void assertStrings(String actual , String  expected) {
		Assertion softAssert = new SoftAssert();
		softAssert.assertEquals(actual, expected);
		
		
	}

public void assertBoolean(boolean value) {
	Assertion softAssert = new SoftAssert();
	softAssert.assertTrue(value);
	
		
	}
}
