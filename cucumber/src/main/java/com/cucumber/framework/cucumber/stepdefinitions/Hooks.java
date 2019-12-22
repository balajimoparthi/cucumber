package com.cucumber.framework.cucumber.stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.framework.cucumber.enums.Browsers;
import com.cucumber.framework.cucumber.testBase.TestBase;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	TestBase testBase;
	
	@Before
	public void initializeTest() {
		testBase = new TestBase();
		testBase.selectBrowser(Browsers.CHROME.name());
		testBase.driver.manage().window().maximize();
		testBase.driver.manage().deleteAllCookies();
		
	}
	
	@After
	public void endTest() throws IOException {
		File scrFile = ((TakesScreenshot)TestBase.driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File("./screenshot//screenshot.png"));
		
		TestBase.driver.quit();
		
	}
}
