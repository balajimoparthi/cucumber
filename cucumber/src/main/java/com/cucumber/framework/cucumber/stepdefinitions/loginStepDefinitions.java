package com.cucumber.framework.cucumber.stepdefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.cucumber.framework.cucumber.pageObjects.HomePage;
import com.cucumber.framework.cucumber.pageObjects.LoginPage;
import com.cucumber.framework.cucumber.testBase.TestBase;
import com.cucumber.framework.utils.WaitHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class loginStepDefinitions extends TestBase{
	
	private static Logger log=LogManager.getLogger(loginStepDefinitions.class.getName());
	
	LoginPage loginPage= new LoginPage(driver);		
	
	WaitHelper waitHelper;
	
	@Given("^i am on the Login page URL \"([^\"]*)\"$")
	public void i_am_on_the_Login_page_URL(String url) throws Throwable {
	    try {
			driver.get(url);
			waitHelper = new WaitHelper(driver);
			waitHelper.waitForElement(loginPage.userName, 60);
			log.info("user is on the login page");
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	}

	@Then("^I should see Login page$")
	public void i_should_see_Login_page() throws Throwable {
		//loginPage = new LoginPage(driver);
		try {
			loginPage.userName.isDisplayed();
			log.info("user name field is displayed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	   
	}

	@When("^I enter username as \"([^\"]*)\"$")
	public void i_enter_username_as(String username) throws Throwable {
			try {
				loginPage.enterUserName(username);
				log.info("entered the user name");
			} catch (Exception e) {
				e.printStackTrace();
			}
			  
	}


	@When("^I enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String password) throws Throwable {
		try {
			loginPage.enterPassWord(password);
			log.info("entered the password");
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}

	
	@When("^I click on Login button$")
	public void click_on_Login_button() throws Throwable {
		try {
			loginPage.clickLoginButton();
			log.info("clicked on login button");
		} catch (Exception e) {			
			e.printStackTrace();
			log.error(e.toString() + "  " + "click_on_Login_button component execution failed");
		}
	}
	
	@Then("^I should be logged out$")
	public void i_should_be_on_the_logout_page() throws Throwable {
		try {
			loginPage.userName.isDisplayed();
			log.info("user has successfully logged out");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.toString() + "  " + "Logout component execution failed");
		}		
	    
	}

	@Given("^I am on the Login page URL$")
	public void iAmOnTheLoginPageURL() {
		try {
			launchApp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}