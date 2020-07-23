package com.cucumber.framework.cucumber.stepdefinitions;

import com.cucumber.framework.cucumber.pageObjects.*;
import com.cucumber.framework.cucumber.testBase.TestBase;
import com.cucumber.framework.utils.WaitHelper;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class PendingTransStepDefinitions extends TestBase {

    private static Logger log= LogManager.getLogger(HomePageStepDefinitions.class.getName());

    HomePage homePage= new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    FundsManagementPage fmPage = new FundsManagementPage(driver);
    CreateNewFundPage createFundPage = new CreateNewFundPage(driver);
    CreateTransactionPage crtTransactionPage = new CreateTransactionPage(driver);
    PendingTransactionsPage pendTransPage = new PendingTransactionsPage(driver);

    WaitHelper waitHelper;

    @Then("^I should see transactions for clearance page$")
    public void iShouldSeeTransactionsForClearancePage() {
        try {
            pendTransPage.pendTransPageDisplayed();
            log.info("pending transactions for clearance page is displayed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("^I click on view details for the transaction created$")
    public void iClickOnViewDetailsForTheTransactionCreated() {
        try {
            pendTransPage.clickViewDetails();
            log.info("clicked on view details button");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^I should see transaction popup window$")
    public void iShouldSeeTransactionPopupWindow() {
        try {
            pendTransPage.viewDtlsPopupDisplayed();
            log.info("view details pop up window is displayed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("^I click on \"([^\"]*)\" button$")
    public void iClickOnButton(String arg0) throws Throwable {

    }

    @And("^I click on okay button$")
    public void iClickOnOkayButton() {
        try {
            pendTransPage.clickOkayBtn();
            log.info("clicked on Okay button");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^I click on fund management from the breadcrumb$")
    public void iClickOnFundManagementFromTheBreadcrumb() {
    }

    @When("^I click on approve button$")
    public void iClickOnApproveButton() {
        try {
            pendTransPage.clickOnApproveBtn();
            //log.info("clicked on Approve Button");
            Assert.assertTrue(true,"Approve button is clicked");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Approve button is not clicked");
        }

    }
}
