package com.ally.base;

import java.io.IOException;
import java.net.URL;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import com.ally.actions.TestEngine;
import com.ally.support.WebDriverFactory;
import com.ally.support.Xls_Reader;
import com.ally.util.Util;

public class Base {
	public static WebDriver driver = null;
	public static String baseUrl = null;
	public static String BROWSER = null;
	public static final URL scriptUrl = Base.class.getResource("/axe.min.js");
	
	public static boolean isRunnable (String URL) throws NumberFormatException, IOException {
		BROWSER = Util.getProperty ("Browser");
		driver = null;
		if (driver == null) {
			baseUrl = URL;
			String platform = Util.getProperty("Platform");
			if (platform.toUpperCase().equals("LOCAL")) {
				WebDriverFactory.initialize();
			}
			return true;
		}
		return false;
	}
	
	@AfterMethod
	public void tearDown() {
		TestEngine.quit();
	}
	
}
