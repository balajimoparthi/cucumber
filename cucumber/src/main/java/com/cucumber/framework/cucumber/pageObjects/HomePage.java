package com.cucumber.framework.cucumber.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.framework.cucumber.helper.WaitHelper;

public class HomePage {

	private WebDriver driver;
	
	WaitHelper waitHelper;
	
	@FindBy(xpath="//span[contains(text(),'Administrator')]")
	public WebElement adminstrator;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	
		
		
	}
}
