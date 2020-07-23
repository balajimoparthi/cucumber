package com.cucumber.framework.cucumber.testBase;

import java.io.*;
import java.util.Properties;

import com.cucumber.framework.cucumber.stepdefinitions.HomePageStepDefinitions;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cucumber.framework.cucumber.enums.Browsers;
import com.cucumber.framework.cucumber.enums.OS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestBase {

	//private static final long DEFAULT_TIMEOUT = ;
	public static WebDriver driver;
	private static Logger log= LogManager.getLogger(HomePageStepDefinitions.class.getName());
	static Properties properties;
	
	public WebDriver selectBrowser(String browser) {
		if(System.getProperty("os.name").toLowerCase().contains(OS.WINDOW.name().toLowerCase())) {
			if(browser.equalsIgnoreCase(Browsers.CHROME.name())) {
				 WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver();
				//WebDriverManager.chromedriver().version("2.40").setup();
				 
			}else if(browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
				 WebDriverManager.firefoxdriver().setup();
				 driver = new FirefoxDriver();

			}else if(browser.equalsIgnoreCase(Browsers.IE.name())) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();

			}else if(browser.equalsIgnoreCase(Browsers.EDGE.name())) {
				WebDriverManager.edgedriver().setup();
				driver = new InternetExplorerDriver();
		}
		}
		return driver;
		
	}

	public static void propertyFileLoader() throws IOException {
		properties = new Properties();

		File file = new File(System.getProperty("user.dir")+"\\Config\\config.properties");

		FileReader fr = new FileReader(file);
		properties.load(fr);

	}


	public static String propertyFileReader(String Data) throws IOException {
		propertyFileLoader();
		String data = properties.getProperty(Data);
		return data;
	}

	public void launchApp() throws IOException {

		String url=propertyFileReader("url");
		driver.get(url);
	}


	
	public void getScreenshot(String result) {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./screenshot//"+result+"screenshot.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}


}
	