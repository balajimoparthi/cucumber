package com.cucumber.framework.cucumber.stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.cucumber.framework.cucumber.enums.Browsers;
import com.cucumber.framework.cucumber.testBase.TestBase;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	private static Logger log=LogManager.getLogger(Hooks.class.getName());
	TestBase testBase;
	
	@SuppressWarnings("static-access")
	@Before
	public void initializeTest() {
		testBase = new TestBase();
		testBase.selectBrowser(Browsers.CHROME.name());
		testBase.driver.manage().window().maximize();
		testBase.driver.manage().deleteAllCookies();
		testBase.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
		
	@After
		public void endTest(Scenario scenario) throws IOException {
			if (scenario.isFailed()) {

				try {
					log.info(scenario.getName() + " is Failed");
					final byte[] screenshot = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES);
					File scrFile = ((TakesScreenshot)TestBase.driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(scrFile, new File("./screenshot//" + scenario.getName() + ".png"));	
					scenario.embed(screenshot, "image/png"); 
				} catch (WebDriverException e) {
					e.printStackTrace();
				}

			} /*else {
				try {
					log.info(scenario.getName() + " is pass");
					scenario.embed(((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES), "image/png");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}*/
		TestBase.driver.quit();
		
	}
}
