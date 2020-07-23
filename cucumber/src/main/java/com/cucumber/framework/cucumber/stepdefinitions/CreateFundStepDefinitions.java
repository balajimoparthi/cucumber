package com.cucumber.framework.cucumber.stepdefinitions;

import com.cucumber.framework.cucumber.pageObjects.CreateNewFundPage;
import com.cucumber.framework.cucumber.pageObjects.FundsManagementPage;
import com.cucumber.framework.cucumber.pageObjects.HomePage;
import com.cucumber.framework.cucumber.pageObjects.LoginPage;
import com.cucumber.framework.cucumber.testBase.TestBase;
import com.cucumber.framework.utils.WaitHelper;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateFundStepDefinitions extends TestBase {

    private static Logger log = LogManager.getLogger(HomePageStepDefinitions.class.getName());
    public static String fudName = "";

    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    FundsManagementPage fmPage = new FundsManagementPage(driver);
    CreateNewFundPage createFundPage = new CreateNewFundPage(driver);

    WaitHelper waitHelper;


   /* @When("^I enter RC number in to the RC number field$")
    public void iEnterRCNumberInToTheRCNumberField() {
        try {
            Thread.sleep(10000);
            newFundPage.enterRCNumber();
            Thread.sleep(10000);
            log.info("RC number is entered successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/

    @When("^I enter \"([^\"]*)\" number in to the RC number field$")
    public void iEnterNumberInToTheRCNumberField(String rc) throws Throwable {
        try {
            //Thread.sleep(1000);
            String number = createFundPage.enterNumber();

            String rcNumber = rc + number;
            WebElement enter = createFundPage.refRCNumber;
            enter.sendKeys(rcNumber);
            //Thread.sleep(10000);
            log.info("RC number is entered successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^I should see the RC number$")
    public void iShouldSeeTheRCNumber() {

    }

    @When("^I enter \"([^\"]*)\" number in to the GO number field$")
    public void iEnterNumberInToTheGONumberField(String go) throws Throwable {
        try {
            // Thread.sleep(1000);
            String number = createFundPage.enterNumber();

            String goNumber = go + number;
            WebElement goNum = createFundPage.goNumber;
            goNum.sendKeys(goNumber);
            // Thread.sleep(1000);
            log.info("GO number is entered successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^I should see the GO number$")
    public void iShouldSeeTheGONumber() {
    }


    @Then("^I should see the account number$")
    public void iShouldSeeTheAccountNumber() {
    }

    @When("^I enter AccountNumber number in to the account number field$")
    public void iEnterAccountNumberNumberInToTheAccountNumberField() {
        try {
            // Thread.sleep(1000);
            String acNumber = createFundPage.enterNumber();
            WebElement accNum = createFundPage.accountNumber;
            accNum.sendKeys(acNumber);
            //Thread.sleep(1000);
            log.info("Account number is entered successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //public static String fudName="";
    @When("^I enter \"([^\"]*)\" name in to the fund name field$")
    public void iEnterNameInToTheFundNameField(String fund) throws Throwable {
        try {
            String number = createFundPage.enterNumber();
            String fundName = fund + number;
            WebElement fName = createFundPage.fundName;
            fName.sendKeys(fundName);
            fudName = fName.getAttribute("value");
            log.info(fudName + " " + "Fund Name is entered successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^I should see the fund name$")
    public void iShouldSeeTheFundName() {


    }


    @When("^I enter IFSC code$")
    public void iEnterIFSCCode() {
        try {
            createFundPage.enterIfscCode();
            log.info("IFSC code is entered successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^I enter bank name$")
    public void iEnterBankName() {
        try {
            createFundPage.enterBankName();
            log.info("Bank name is entered successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^I should see ifsc and bank name$")
    public void iShouldSeeIfscAndBankName() {


    }

    @When("^I enter other details$")
    public void iEnterOtherDetails() {
        try {
            createFundPage.enterOtherDetails();
            log.info("Other details are entered successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^I should see other details$")
    public void iShouldSeeOtherDetails() {
    }

    @When("^I enter head name$")
    public void iEnterHeadName() {
        try {
            createFundPage.enterHeadName();
            log.info("Head Name is entered successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^I click on add sub head button$")
    public void iClickOnAddSubHeadButton() {
        try {
            createFundPage.clickSubHeadButton();
            log.info("Clicked on the Sub Head Button");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* @And("^I enter sub head name$")
    public void iEnterSubHeadName() {
        try {
            Thread.sleep(500);
            createFundPage.enterSubHeadName();
            log.info("Sub Head Name is entered successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    @And("^I click on create fund button$")
    public void iClickOnCreateFundButton() {
        try {
            createFundPage.clickCreateFundButton();
            log.info("Clicked on the Create Fund Button");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^I should see fund created successfully popup$")
    public void iShouldSeeFundCreatedSuccessfullyPopup() {
        try {
            createFundPage.createFundPopupDisplayed();
            log.info("create fund pop is displayed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^I click on ok button$")
    public void iClickOnOkButton() {
        try {
            createFundPage.clickOKbutton();
            log.info("clicked on OK button");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^I should see the fund name in the funds management page$")
    public void iShouldSeeTheFundNameInTheFundsManagementPage() {

        try {
            String s = createFundPage.fmFundName.getText();
            System.out.println(s);
            if (s.equalsIgnoreCase(fudName)) {
                log.info("fund created successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    /*@When("^I enter headers name$")
    public void iEnterHeadersName(DataTable data) {

        List<List<String>> enterHeaders = new ArrayList<>();

        enterHeaders = data.raw();
        System.out.println(enterHeaders+"header");
        for (int i = 0; i < enterHeaders.size(); i++) {
            createFundPage.enterHeader(enterHeaders.get(i).get(i));
            System.out.println((enterHeaders.get(i).get(i))+"in the loop");

        }
    }*/



    @And("^I enter \"([^\"]*)\" name$")
    public void iEnterName(String head) throws Throwable {
        try {
            createFundPage.enterSubHeadName(head);
            log.info(head+" "+ "subhead name is entered");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}



