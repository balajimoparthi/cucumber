package com.cucumber.framework.cucumber.testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cucumber.framework.cucumber.enums.Browsers;
import com.cucumber.framework.cucumber.enums.OS;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	
	public  WebDriver selectBrowser(String browser) {
		if(System.getProperty("os.name").toLowerCase().contains(OS.WINDOW.name().toLowerCase())) {
			if(browser.equalsIgnoreCase(Browsers.CHROME.name())) {
				 WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver();
				 
			}else if(browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
				 WebDriverManager.firefoxdriver().setup();
				 driver = new FirefoxDriver();
		}
		}
		return driver;
		
	}
}
	