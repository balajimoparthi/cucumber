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
	
	@FindBy(xpath="//span[@class='pi pi-home']")
	public WebElement apolisHome;
	
	@FindBy(xpath="//div[@id='navbarDropdown-1']//img[@class='img-fluid']")
	public WebElement logoutDropDown;
	
	@FindBy(xpath="//span[contains(text(),'logout')]")
	public WebElement logout;

	@FindBy(xpath="//a[contains(text(),'Bhadratha Section')]")
	public WebElement bhadrathaSection;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);		
		
	}
}
