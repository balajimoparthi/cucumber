package com.cucumber.framework.cucumber.stepdefinitions;

import com.cucumber.framework.cucumber.enums.Browsers;
import com.cucumber.framework.cucumber.testBase.TestBase;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ServiceHooks {

	TestBase testBase;
	
	@Before
	public void initializeTest() {
		testBase = new TestBase();
		testBase.selectBrowser(Browsers.CHROME.name());		
	}
	
	@After
	public void endTest() {
		TestBase.driver.quit();
	}
}
