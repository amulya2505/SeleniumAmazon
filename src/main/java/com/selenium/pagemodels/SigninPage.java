package com.selenium.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.utils.constants.SigninPageConstants;
import com.selenium.utils.utilities.WebDriverSingleton;

public class SigninPage {

	public static WebElement Emailfield() {
		return getWebElementFromId(SigninPageConstants.emailfield);
	}

	public static WebElement Passwordfield() {
		return getWebElementFromId(SigninPageConstants.passwordfield);
	}

	public static WebElement SinginBtn() {
		return getWebElementFromId(SigninPageConstants.Signinbtn);
	}

	private static WebElement getWebElementFromId(String id) {
		return WebDriverSingleton.getDriverInstance().findElement(By.id(id));
	}
}
