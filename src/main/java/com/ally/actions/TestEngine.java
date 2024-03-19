package com.ally.actions;

import org.openqa.selenium.By;

import com.ally.base.Base;

public class TestEngine extends Base {
	
	static int MAX_TIME_OUT = 100;
	/*
	 * 
	 */
	public static boolean isElementPresent(String locator) {
		boolean isElementPresent = false;
		int nStartTime = 1;
		while (nStartTime <= MAX_TIME_OUT) {
			try {
				if (driver.findElements(By.xpath(locator)).size()>0) {
					nStartTime = 500;
					isElementPresent = true;
				} else {
					nStartTime = nStartTime + 1;
				}
			} catch (Throwable t) {
				nStartTime = nStartTime + 1;
			}
		}
		return isElementPresent;
	}

	public static void maximize() {
		driver.manage().window().maximize();
	}
	
	public static void deleteCookies() {
		driver.manage().deleteAllCookies();
	}
	
	public static void quit () {
		try {
			driver.quit();
		} catch (Exception e) {
			
		}
	}
	
}
