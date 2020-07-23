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

public class CreateTransactionStepDefinitions extends TestBase {

    private static Logger log= LogManager.getLogger(HomePageStepDefinitions.class.getName());

    HomePage homePage= new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    FundsManagementPage fmPage = new FundsManagementPage(driver);
    CreateNewFundPage createFundPage = new CreateNewFundPage(driver);
    CreateTransactionPage crtTransactionPage = new CreateTransactionPage(driver);

    WaitHelper waitHelper;

    @Then("^I should see create transaction page$")
    public void iShouldSeeCreateTransactionPage() {
        try {
            crtTransactionPage.createTransactionPageDisplayed();
            log.info("create transaction page is displayed");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @When("^I select unit name$")
    public void iSelectUnitName() {
        //waitHelper.waitForPageLoaded();
        try {
            crtTransactionPage.selectUnitName();
           // log.info("unit name is selected");
            Assert.assertTrue(true,"unit name is selected");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("unit name is not selected");
        }

    }

    @And("^I select fund name$")
    public void iSelectFundName() {
        try {
            crtTransactionPage.selectFundName();
            log.info("fund name is selected");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("fund name is not selected");
            log.error(e.toString() + "  "
                    + "select fund name method execution is failed");
        }
    }

    @And("^I select header name$")
    public void iSelectHeaderName() {
        try {
            crtTransactionPage.selectHeaderName();
            log.info("header name is selected");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("header name is not selected");
        }
    }

    @And("^I select sub header name$")
    public void iSelectSubHeaderName() {
        try {
            crtTransactionPage.selectSubHeaderName();
            log.info("Sub header name is selected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^I select transaction type$")
    public void iSelectTransactionType() {
        try {
            crtTransactionPage.selectTransactionType();
            log.info("Transaction type is selected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^I enter transaction amount$")
    public void iEnterTransactionAmount() {
        try {
            crtTransactionPage.enterTransactionAmount();
            log.info("Transaction amount is entered");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^I enter cheque number$")
    public void iEnterChequeNumber() {
        try {
            crtTransactionPage.enterChequeNumber();
            log.info("Cheque number is entered");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^I choose date of transfer$")
    public void iChooseDateOfTransfer() {
        try {
            crtTransactionPage.enterDate();
            log.info("date is entered");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^I upload supporting documents$")
    public void iUploadSupportingDocuments() {
        try {
            crtTransactionPage.uploadDocs();
            log.info("supporting document is uploaded");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^I click on create transaction button$")
    public void iClickOnCreateTransactionButton() {
        try {
            crtTransactionPage.clickCreateTransaction();
            log.info("clicked on create transaction button");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^I click yes on the popup window$")
    public void iClickYesOnThePopupWindow() {
        try {
            crtTransactionPage.clickYesOnPopup();
            log.info("clicked YES on the Are you sure window");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^I click no on add another transaction popup window$")
    public void iClickNoOnAddAnotherTransactionPopupWindow() {
        try {
            crtTransactionPage.clickNoOnPopup();
            log.info("clicked NO on the Are you sure window");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("^I click on pending transactions for clearance$")
    public void iClickOnPendingTransactionsForClearance() {
        try {
            fmPage.clickOnPendingTransLink();
            log.info("clicked on pending transactions link");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @And("^I click on the fund under the fund history$")
    public void iClickOnTheFundUnderTheFundHistory() {
    }

    @Then("^I should see fund details$")
    public void iShouldSeeFundDetails() {
    }

    @And("^I should see transaction amount in the subheader$")
    public void iShouldSeeTransactionAmountInTheSubheader() {
    }
}
