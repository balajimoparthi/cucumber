package com.cucumber.framework.cucumber.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.framework.utils.WaitHelper;

public class HomePage {

	private WebDriver driver;
	
	WaitHelper waitHelper;
	
	@FindBy(xpath="")
	public WebElement maphome;
	
	@FindBy(xpath="")
	public WebElement logout;
	
	@FindBy(xpath="")
	public WebElement homepageTitle;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);		
		
	}
}
