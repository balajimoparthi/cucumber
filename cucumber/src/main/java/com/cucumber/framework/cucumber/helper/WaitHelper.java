package com.cucumber.framework.cucumber.helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
}
