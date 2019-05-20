package com.selenium.utils.utilities;

import org.openqa.selenium.WebDriver;

public class Base {

	
	public static void tearDown(WebDriver driver) {
		driver.close();

	}

}
