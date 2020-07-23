package com.cucumber.framework.cucumber.stepdefinitions;

import com.cucumber.framework.cucumber.pageObjects.LoginPage;
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
	LoginPage loginPage = new LoginPage(driver);
	
	WaitHelper waitHelper;

	@Then("^I should see application homepage$")
	public void i_should_see_application_homepage() throws Throwable {
		try {
			waitHelper = new WaitHelper(driver);
			waitHelper.waitForElement(homePage.apolisHome, 120);
			homePage.apolisHome.isDisplayed();
		    //String txt=	homePage.homepageTitle.getText();
			//Assert.assertEquals(txt, "bala");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("^I click on logout button$")
	public void i_click_on_logout_button() throws Throwable {
		try {
			waitHelper.waitForElement(homePage.logoutDropDown, 120);
			//Thread.sleep(4000);
			homePage.logoutDropDown.click();
			homePage.logout.click();
			log.info("user has clicked on logout button");
            //Assert.assertTrue(5>3);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.toString() + "  " + "Logout component execution failed");
		}
	    
	}


	@When("^I click on bhadratha section on homepage$")
	public void iClickOnBhadrathaSectionOnHomepage() {
		try {
			waitHelper.waitForElement(homePage.bhadrathaSection, 120);
			homePage.bhadrathaSection.click();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.toString() + "  " + "click on bhadrathasection component execution failed");
		}

	}


}