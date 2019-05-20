package com.selenium.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.selenium.utils.constants.SearchResultConstants;
import com.selenium.utils.utilities.WebDriverSingleton;

public class SearchResultPage {

	public static WebElement headphoneresult() {
		return WebDriverSingleton.getDriverInstance().findElement(By.xpath(SearchResultConstants.headphonesresult));
	}

	public static WebElement Macbookresult() {
		return WebDriverSingleton.getDriverInstance().findElement(By.id(SearchResultConstants.macbookresult));
	}
}
