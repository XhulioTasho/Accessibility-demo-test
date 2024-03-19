package com.ally.support;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ally.actions.TestEngine;
import com.ally.base.Base;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory extends Base {
	
	public static WebDriver initialize () throws NumberFormatException, IOException {
		if (BROWSER.toUpperCase().equals("CHROME")) {
			System.setProperty ("webdriver.chrome.silentOutput", "true");
			System.setProperty ("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "Drivers" + File.separator + "chromedriver");
			driver = new ChromeDriver();
			TestEngine.deleteCookies();
			driver.get (baseUrl);
			TestEngine.maximize();
		} else if (BROWSER.toUpperCase().equals("IE")) {
			//code
		} else if (BROWSER.toUpperCase().equals("FIREFOX")) {
			System.setProperty ("webdriver.firefox.silentOutput", "true");
			System.setProperty ("webdriver.firefox.driver", System.getProperty("user.dir") + File.separator + "Drivers" + File.separator + "firefoxdriver");
			driver = new FirefoxDriver();
			TestEngine.deleteCookies();
			driver.get (baseUrl);
			TestEngine.maximize();
		}
		return driver;
	}
	
}
