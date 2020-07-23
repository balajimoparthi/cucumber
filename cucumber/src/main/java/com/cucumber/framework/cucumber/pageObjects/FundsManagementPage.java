package com.cucumber.framework.cucumber.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cucumber.framework.utils.WaitHelper;
import org.openqa.selenium.support.PageFactory;


public class FundsManagementPage {
    private WebDriver driver;

    WaitHelper waitHelper;


    @FindBy(xpath = "//h3[contains(text(),'Funds Management')]")
    public WebElement fmHome;

    @FindBy(xpath = "//button[@class='btn btn-create-fund']")
    public WebElement createNewFund;

    @FindBy(xpath = "//div[@class='sub-head-wrapper mb-3']//h3[@class='section-title'][contains(text(),'Create New Fund')]")
    public WebElement createFundPage;

   // @FindBy(xpath = "//div[@class='col-sm-12 col-md-3 col-lg-3']//li[6]")
    @FindBy(xpath = "//a[contains(text(),'Create Transaction')]")
    public WebElement createTransactionLink;


    @FindBy(xpath = "//a[contains(text(),'Pending transactions for clearance')]")
    public WebElement pendingTransactionsLink;





    public FundsManagementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);

    }

    public void clickOnCreateNewFund() {
        try {
            waitHelper.waitForElement(createNewFund,1000);
            //createNewFund.sendKeys(Keys.ENTER);
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView();", createNewFund);
            js.executeScript("arguments[0].click();",createNewFund);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickOnCreateTransaction() {
        try {
            waitHelper.waitForElement(createTransactionLink,2000);
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView();", createTransactionLink);
            js.executeScript("arguments[0].click();",createTransactionLink);
            //createTransactionLink.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickOnPendingTransLink(){
        try {
            waitHelper.waitForElement(pendingTransactionsLink,2000);
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView();", pendingTransactionsLink);
            js.executeScript("arguments[0].click();",pendingTransactionsLink);
           // pendingTransactionsLink.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
