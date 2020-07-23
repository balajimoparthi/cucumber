package com.cucumber.framework.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WaitHelper {

	Logger logger=LoggerHelper.getLogger(WaitHelper.class);
	private WebDriver driver;
	
	public WaitHelper(WebDriver driver) {
		this.driver=driver;
		}
	
	public void waitForElement(WebElement element,long timeOutInSeconds) {
	    logger.info("waiting for element visibility");
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		logger.info("element visible");
	}

	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = driver -> {
			assert driver != null;
			return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
		};
		try {
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}


	}


