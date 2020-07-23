package com.cucumber.framework.cucumber.pageObjects;

import com.cucumber.framework.utils.WaitHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CreateNewFundPage {

    private WebDriver driver;

    WaitHelper waitHelper;

    @FindBy(xpath = "//input[@placeholder='Reference RC Number'] | //input[@formcontrolname='referenceNumber']")
    public WebElement refRCNumber;
    //input[@class='form-control ng-pristine ng-invalid ng-touched']
    @FindBy(xpath = "//input[@placeholder='GO Number']")
    public WebElement goNumber;

    @FindBy(xpath = "//input[@placeholder='Fund Name']")
    public WebElement fundName;

    @FindBy(xpath = "//input[@placeholder='Account Number']")
    public WebElement accountNumber;

    @FindBy(xpath = "//input[@placeholder='IFSC Code']")
    public WebElement ifscCode;

    @FindBy(xpath = "//input[@placeholder='Bank and Branch Name'] | //input[@formcontrolname='bankAndBranchName']")
    public WebElement bankName;

    @FindBy(xpath = "//textarea[@class='form-control ng-untouched ng-pristine ng-invalid']")
    public WebElement otherDetails;

    @FindBy(xpath = "//input[@placeholder='Head Name']")
    public WebElement headName;

    @FindBy(xpath = "//p[@class='add-sub-head']")
    public WebElement addSubHead;

    @FindBy(xpath = "//button[contains(text(),'Add New Head')]")
    public WebElement addNewHeadButton;

    @FindBy(xpath = "//p[@class='add-sub-head']//img[@class='img-fluid']")
    public WebElement addSubHeadButton;


    @FindBy(xpath = "//input[@placeholder='Sub Header Name']")
    public WebElement addSubHeadName;

    @FindBy(xpath = "(//input[@placeholder='Sub Header Name'])[last()]")
    public WebElement addSubHeadName1;



    @FindBy(xpath = "//div[@class='upload-img']//input[@class='form-control ng-untouched ng-pristine ng-valid']']")
    public WebElement uploadFile;

    @FindBy(xpath = "//button[contains(text(),'CREATE FUND')]")
    public WebElement createFundButton;

    @FindBy(xpath = "//button[contains(text(),'CANCEL')]")
    public WebElement cancelButton;

    @FindBy(xpath = "//button[contains(text(),'CLEAR')]")
    public WebElement clearButton;

    @FindBy(xpath = "//button[@class='btn active-status']")
    public WebElement activeButton;

    @FindBy(xpath = "//button[@class='btn btn-light']")
    public WebElement inactiveButton;

    //@FindBy(xpath = "//div[@id='swal2-content']")
   // public WebElement fundCreationPopup;

    @FindBy(id = "swal2-content")
    public WebElement fundCreationPopup;

    @FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
    public WebElement okButton;

    @FindBy(xpath = "//span[@class='fund-name-info']")
    public WebElement fmFundName;







    public CreateNewFundPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);

    }

    public static String enterNumber(){
        Random rand = new Random();
        //int val= rand.nextInt(1000000000);

      int val=100000000 + rand.nextInt(900000000);
        String random_val=  Integer.toString(val);
        return random_val;
    }

    public void enterIfscCode(){
        try {
            ifscCode.sendKeys("UTIB0001234");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterBankName(){
        try {
            bankName.sendKeys("AXIS-Guntur");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterOtherDetails(){
        try {
            otherDetails.sendKeys("Test details");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterHeadName(){
        try {
            waitHelper.waitForElement(headName,2000);
            headName.sendKeys("EMI");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterSubHeadName(String sbName){
        if(sbName.equalsIgnoreCase("Principal"))
            addSubHeadName.sendKeys(sbName);
        else
            addSubHeadName1.sendKeys(sbName);

    }

   /* public void enterHeader(String headers){
        if(headers.equalsIgnoreCase("EMI")) {
            headName.sendKeys(headers);
            clickSubHeadButton();
        }
        else if(headers.equalsIgnoreCase("Principal")) {
            addSubHeadName.sendKeys(headers);
            clickSubHeadButton();
        }
        else if(headers.equalsIgnoreCase("Interest")) {
            addSubHeadName1.sendKeys(headers);
        }
        else
        {
            Assert.fail(headers + "not valid data");
        }




    }*/



    public void clickSubHeadButton(){
        try {
            waitHelper.waitForElement(addSubHeadButton,2000);
            //addSubHeadButton.sendKeys(Keys.ENTER);
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();",addSubHeadButton);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickCreateFundButton(){
        try {
            waitHelper.waitForElement(createFundButton,2000);
            createFundButton.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createFundPopupDisplayed(){
        try {
            fundCreationPopup.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickOKbutton(){
        try {
            waitHelper.waitForElement(okButton,1000);
            //okButton.click();
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView();", okButton);
            js.executeScript("arguments[0].click();",okButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }













    //button[contains(text(),'Add New Head')]






}
