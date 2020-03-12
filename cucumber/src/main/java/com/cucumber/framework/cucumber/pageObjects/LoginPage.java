package com.cucumber.framework.cucumber.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.framework.utils.PropertyFileReader;
import com.cucumber.framework.utils.WaitHelper;

import cucumber.api.java.en.Then;

public class LoginPage {

	private WebDriver driver;
	PropertyFileReader prop = new PropertyFileReader();
	
	@FindBy(xpath="")
	public WebElement userName;
	
	@FindBy(xpath="//")
	public WebElement passWord;
	
	@FindBy(xpath="//")
	public WebElement loginButton;
	
	@FindBy(xpath="//")
	public WebElement cntbutton;
	
	WaitHelper waitHelper;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitHelper=new WaitHelper(driver);
		//waitHelper.waitForElement(userName, 60);
		
		
	}	
	
	
	public void enterUserName(String userName) {
		this.userName.sendKeys(userName);
	}
	
	public void enterPassWord(String passWord) {
		this.passWord.sendKeys(passWord);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void continueButton() {
		cntbutton.click();
	}
}
