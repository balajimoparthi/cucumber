package com.cucumber.framework.cucumber.pageObjects;

import com.cucumber.framework.cucumber.stepdefinitions.CreateFundStepDefinitions;
import com.cucumber.framework.utils.WaitHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.ThreadLocalRandom;

import static com.cucumber.framework.cucumber.pageObjects.CreateNewFundPage.enterNumber;

public class CreateTransactionPage {
    private WebDriver driver;

    WaitHelper waitHelper;

    // CreateFundStepDefinitions cfsd = new CreateFundStepDefinitions();


    @FindBy(xpath = " //ng-select[@formcontrolname='unitName']")
    public WebElement unitDropdown;

    @FindBy(className = "ng-option")
    public List<WebElement> unitDropdownItems;

    @FindBy(xpath = " //ng-select[@formcontrolname='fundName']")
    public WebElement fundNameDropdown;

    @FindBy(className = "ng-option")
    public List<WebElement> fundDropdownItems;

    @FindBy(xpath = " //ng-select[@formcontrolname='fundHead']")
    public WebElement headerNameDropdown;

    @FindBy(className = "ng-option")
    public List<WebElement> headerDropdownItem;


    @FindBy(xpath = " //ng-select[@formcontrolname='fundSubHead']")
    public WebElement subHeaderNameDropdown;

    @FindBy(className = "ng-option")
    public List<WebElement> subHeaderNameDropdownItem;


    @FindBy(xpath = " //ng-select[@formcontrolname='transationType']")
    public WebElement transactionTypeDropDown;

    @FindBy(className = "ng-option")
    public List<WebElement> transactionTypeDropDownItem;

    @FindBy(xpath = "//input[@formcontrolname='transactionAmount']")
    public WebElement transactionAmount;

    @FindBy(xpath = "//input[@formcontrolname='referenceNoOrChequeNo']")
    public WebElement chequeNumber;

    @FindBy(xpath = "//input[@formcontrolname='dateOfTransfer']")
    public WebElement dateOfTransferCalender;

    @FindBy(xpath = "//input[@formcontrolname='bankAndBranchName']")
    public WebElement bankBranchName;

    @FindBy(xpath = "//textarea[@class='form-control ng-untouched ng-pristine ng-invalid']")
    public WebElement otherDetails;

    // @FindBy(xpath = "//input[@formcontrolname='files']")
    // public WebElement uploadDocuments;

    @FindBy(xpath = "//h5[contains(text(),'Drag files here')]")
    public WebElement uploadDocuments;


    @FindBy(xpath = "//button[@class='btn btn-primary modal-btn']")
    public WebElement createTransactionButton;

    @FindBy(xpath = "//span[contains(text(),'Create Transaction')]")
    public WebElement createTransactionBreadCrumb;

    @FindBy(xpath = "//button[@class='swal2-confirm swal2-styled']")
    public WebElement clickYes;

    @FindBy(xpath = "//button[@class='swal2-cancel swal2-styled']")
    public WebElement clickNo;


    public CreateTransactionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }

    public void createTransactionPageDisplayed() {
        try {
            waitHelper.waitForElement(createTransactionBreadCrumb,5000);
            createTransactionBreadCrumb.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectUnitName() {
        try {
            //waitHelper.waitForElement(unitDropdown,5000);
            //Thread.sleep(5000);
           // WebDriverWait wait = new WebDriverWait(driver, 15);
            //wait.until(webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete"));

            new WebDriverWait(driver, 40).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            unitDropdown.click();
            int size = unitDropdownItems.size();

            // System.out.println(unitDropdownItems.toString());
            int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
            int i=0;
            unitDropdownItems.get(i).click();
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectFundName() {
        try {
            new WebDriverWait(driver, 40).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            waitHelper.waitForElement(fundNameDropdown,5000);
            fundNameDropdown.click();

            for (int i = 0; i < fundDropdownItems.size(); i++) {
                String s = fundDropdownItems.get(i).getText();
                if (s.equals(CreateFundStepDefinitions.fudName)) {
                    fundDropdownItems.get(i).click();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectHeaderName() {
        try {
            new WebDriverWait(driver, 40).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            waitHelper.waitForElement(headerNameDropdown,5000);
            headerNameDropdown.click();
            for (int i = 0; i < headerDropdownItem.size(); i++) {
                String s = headerDropdownItem.get(i).getText();
                if (s.equalsIgnoreCase("emi")) {
                    headerDropdownItem.get(i).click();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void selectSubHeaderName() {
        try {
            new WebDriverWait(driver, 40).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            waitHelper.waitForElement(subHeaderNameDropdown,5000);
            subHeaderNameDropdown.click();
            for (int i = 0; i < subHeaderNameDropdownItem.size(); i++) {
                String s = subHeaderNameDropdownItem.get(i).getText();
                if (s.equalsIgnoreCase("principal")) {
                    subHeaderNameDropdownItem.get(i).click();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void selectTransactionType() {
        try {
            new WebDriverWait(driver, 40).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            waitHelper.waitForElement(transactionTypeDropDown,5000);
            transactionTypeDropDown.click();
            for (int i = 0; i < transactionTypeDropDownItem.size(); i++) {
                String s = transactionTypeDropDownItem.get(i).getText();
                if (s.equalsIgnoreCase("credit")) {
                    transactionTypeDropDownItem.get(i).click();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void enterTransactionAmount() {
        try {
            new WebDriverWait(driver, 40).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            waitHelper.waitForElement(transactionAmount,5000);
            transactionAmount.sendKeys("500000");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterChequeNumber() {
        try {
            new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            waitHelper.waitForElement(chequeNumber,5000);
            chequeNumber.sendKeys(enterNumber());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void uploadDocs() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", uploadDocuments);

        //uploadDocuments.click();
        String path = System.getProperty("user.dir" + "\\screenshot\\Creation of transaction for the fund.png");
        uploadDocuments.sendKeys(path);
    }


    public void enterDate() {
        new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
        waitHelper.waitForElement(dateOfTransferCalender,7000);
        dateOfTransferCalender.click();
        String s = getCurrentDay();
        dateOfTransferCalender.sendKeys(s);
    }

    public String getCurrentDay() {


        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);

        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);

        return todayStr;
    }

    public void clickCreateTransaction() {
        try {
            new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            waitHelper.waitForElement(createTransactionButton,5000);
           // createTransactionButton.click();
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView();", createTransactionButton);
            js.executeScript("arguments[0].click();",createTransactionButton);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickYesOnPopup() {
        try {
            new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
            clickYes.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickNoOnPopup() {

        for (int i = 0; i <= 2; i++) {
            try {
                clickNo.click();
                break;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
