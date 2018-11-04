package com.cucumber.framework.cucumber.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.framework.cucumber.helper.WaitHelper;

public class LoginPage {

	private WebDriver driver;
	
	@FindBy(xpath="//*[@id='form']/div/div[2]/input")
	public WebElement userName;
	
	@FindBy(xpath="//*[@id='form']/div/div[4]/input")
	public WebElement passWord;
	
	@FindBy(xpath="//*[@id='submitButton']")
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
