package com.cucumber.framework.cucumber.pageObjects;

import com.cucumber.framework.cucumber.stepdefinitions.CreateFundStepDefinitions;
import com.cucumber.framework.utils.WaitHelper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PendingTransactionsPage {
    private WebDriver driver;

    WaitHelper waitHelper;

    public PendingTransactionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);

    }

    @FindBy(xpath = "//span[contains(text(),'Pending transactions for clearance')]")
    public WebElement pendTransBrdCrumb;

    @FindBy(xpath = "(//div[@class='posting-list-table']//table[@class='table custom-borders transaction-table custom-striped'])[1]")
    public WebElement pendTransTable;

    @FindBy(xpath = "//tab[@class='tab-pane active']//tr//td[7]//div[1]//button[1]")
    public WebElement viewDetailsBtn;

    @FindBy(id = "createTransactionTitle")
    public WebElement viewDtlsPopup;

    //@FindBy(xpath = "//button[@class='btn btn-approve']")
    @FindBy(xpath = "//div[@class='col-sm-12 col-md-4 col-lg-4']//button[@class='btn btn-approve']")
    public WebElement approveBtn;


    @FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
    public WebElement okayBtn;



    public void pendTransPageDisplayed() {
        try {
            pendTransBrdCrumb.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewDtlsPopupDisplayed() {
        try {
            waitHelper.waitForElement(viewDtlsPopup, 3000);
            viewDtlsPopup.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickOkayBtn(){
        try {
            okayBtn.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickOnApproveBtn() {

        try {
           // waitHelper.waitForElement(approveBtn, 3000);

            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete"));
           // Thread.sleep(5000);

            new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            //driver.findElement(By.class="btn btn-approve").click();
            driver.findElement(By.xpath("//button[@class='btn btn-approve']")).sendKeys(Keys.ENTER);

        } catch (Exception e) {
            e.printStackTrace();
        }


        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", approveBtn);
        js.executeScript("arguments[0].click();", approveBtn);*/


    }






    public void clickViewDetails() {
        List<WebElement> rows = pendTransTable.findElements(By.tagName("tr"));

        for (WebElement row : rows) {

            List<WebElement> cells = row.findElements(By.tagName("td"));
           // System.out.println(cells.get(i).getText());
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", viewDetailsBtn);
            // Print the contents of each cell
            /*for (WebElement cell : cells) {
               // System.out.println(cell);
                cell.getText().equals(CreateFundStepDefinitions.fudName);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", viewDetailsBtn);
            }*/

       /* for(int rnum=0;rnum<rows.size();rnum++)
        {
            List<WebElement> columns=rows.get(rnum).findElements(By.tagName("th"));
            System.out.println("Number of columns:"+columns.size());

            for(int cnum=0;cnum<columns.size();cnum++)
            {
                System.out.println("in the loop");


                 if(columns.get(cnum).getText().equals(CreateFundStepDefinitions.fudName)){
                    //Thread.sleep(5000);
                    //viewDetailsBtn.click();
                     //viewDetailsBtn.sendKeys(Keys.ENTER);
                     JavascriptExecutor js = (JavascriptExecutor)driver;
                     js.executeScript("arguments[0].click();",viewDetailsBtn);
                     System.out.println("clicked view btn");
                   // Thread.sleep(2000);
                    break;
                }


            }
        }*/
        }
    }
}
