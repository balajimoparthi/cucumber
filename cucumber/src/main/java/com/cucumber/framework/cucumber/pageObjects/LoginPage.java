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


	@FindBy(xpath="//input[@id='username']")
	public WebElement userName;
	
	@FindBy(xpath="//input[@id='password']")
	public WebElement passWord;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-lg login-button']")
	public WebElement loginButton;



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
	

}
