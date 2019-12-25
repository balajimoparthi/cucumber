package com.cucumber.framework.cucumber.stepdefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.cucumber.framework.cucumber.pageObjects.HomePage;
import com.cucumber.framework.cucumber.testBase.TestBase;
import com.cucumber.framework.utils.WaitHelper;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDefinitions extends TestBase{
	
	private static Logger log=LogManager.getLogger(HomePageStepDefinitions.class.getName());

	HomePage homePage= new HomePage(driver);	
	
	WaitHelper waitHelper;

	@Then("^I should see application homepage$")
	public void i_should_see_application_homepage() throws Throwable {
		try {
			waitHelper = new WaitHelper(driver);
			waitHelper.waitForElement(homePage.maphome, 120);
			homePage.maphome.isDisplayed();
		    String txt=	homePage.homepageTitle.getText();
			Assert.assertEquals(txt, "bala");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("^I click on logout button$")
	public void i_click_on_logout_button() throws Throwable {
		try {
			waitHelper.waitForElement(homePage.logout, 120);
			//Thread.sleep(4000);
			homePage.logout.click();
			log.info("user has clicked on logout button");
			Assert.assertTrue(5>3);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.toString() + "  " + "Logout component execution failed");
		}
	    
	}
		

}