package com.selenium.utils.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {//TODO Swaroop

	private static WebDriver driver = null;

	private WebDriverSingleton() {
	}

	public static WebDriver getDriverInstance() {
		if (driver == null) {
			driver = new ChromeDriver();
		}

		return driver;
	}

}
