package com.cucumber.framework.cucumber.stepdefinitions;

import com.cucumber.framework.cucumber.pageObjects.FundsManagementPage;
import com.cucumber.framework.cucumber.pageObjects.HomePage;
import com.cucumber.framework.cucumber.pageObjects.LoginPage;
import com.cucumber.framework.cucumber.testBase.TestBase;
import com.cucumber.framework.utils.WaitHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class FMStepDefinitions extends TestBase{

    private static Logger log= LogManager.getLogger(HomePageStepDefinitions.class.getName());

    HomePage homePage= new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    FundsManagementPage fmPage = new FundsManagementPage(driver);


    WaitHelper waitHelper;

    @Then("^I should see funds management page$")
    public void iShouldSeeFundsManagementPage() {
        waitHelper = new WaitHelper(driver);
        waitHelper.waitForElement(fmPage.fmHome, 120);
        try {
            fmPage.fmHome.isDisplayed();
            log.info("funds management home page is displayed");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @When("^I click on create new fund button$")
    public void iClickOnCreateNewFundButton() {
        try {
            fmPage.clickOnCreateNewFund();
            log.info("user is able to click on create new fund button");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^I should see create new fund page$")
    public void iShouldSeeCreateNewFundPage() {
        try {
            fmPage.createFundPage.isDisplayed();
            log.info("create new fund page is displayed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("^I click on create transaction link$")
    public void iClickOnCreateTransactionLink() {
        try {
            fmPage.clickOnCreateTransaction();
            log.info("clicked on create transaction link");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
