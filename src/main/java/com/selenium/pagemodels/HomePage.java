package com.selenium.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.utils.constants.HomePageConstants;
import com.selenium.utils.utilities.WebDriverSingleton;

public class HomePage {

	public static WebElement AmazonLogo() {
		return WebDriverSingleton.getDriverInstance().findElement(By.id(HomePageConstants.amazonlogo));
	}
	public static WebElement Signinclickable() {
		return WebDriverSingleton.getDriverInstance().findElement(By.id(HomePageConstants.accounts_navbar));
	}

	public static WebElement DepartmentList(){
		return WebDriverSingleton.getDriverInstance().findElement(By.id(HomePageConstants.department_List));
		
	}

	public static WebElement signoutbtn()
	{
		return WebDriverSingleton.getDriverInstance().findElement(By.id(HomePageConstants.sign_outbtn));
		
	}
	
	public static WebElement ElectronicsDepartment(){
		return WebDriverSingleton.getDriverInstance().findElement(By.xpath(HomePageConstants.electronic_department));
		
	}
	public static WebElement HeadphoneSelect() {
		return WebDriverSingleton.getDriverInstance().findElement(By.linkText(HomePageConstants.headphones_selection));
	}
	
	public static WebElement Searchbox() {
		return WebDriverSingleton.getDriverInstance().findElement(By.id(HomePageConstants.search_box));
	}
	
}