package com.cucumber.framework.cucumber.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.cucumber.framework.cucumber.helper.WaitHelper;
import com.cucumber.framework.cucumber.pageObjects.HomePage;
import com.cucumber.framework.cucumber.testBase.TestBase;

import cucumber.api.java.en.Then;

public class HomePageStepDefinitions extends TestBase{

	HomePage homePage= new HomePage(driver);
	
	WaitHelper waitHelper;

	@Then("^I should see application homepage$")
	public void i_should_see_application_homepage() throws Throwable {
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(homePage.adminstrator, 60);
	    homePage.adminstrator.isDisplayed();
	}

	@Then("^I should see administrator text message on home page$")
	public void i_should_see_administrator_text_message_on_home_page() throws Throwable {
		  homePage.adminstrator.isDisplayed();
	
	
}
}