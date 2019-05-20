package com.selenium.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.selenium.utils.constants.CartConstants;
import com.selenium.utils.utilities.WebDriverSingleton;

public class CartPage {	

		public static  WebElement no_of_CartItems() {
			return WebDriverSingleton.getDriverInstance().findElement(By.id(CartConstants.numberofitems));
		}
		
		public static WebElement addtocart_btn() {
			return WebDriverSingleton.getDriverInstance().findElement(By.id(CartConstants.addtocartbtn));
		}
		
		public static WebElement quantitydropdown() {
			return WebDriverSingleton.getDriverInstance().findElement(By.id(CartConstants.quantitydropdown));
		}
		public static WebElement checkoutquantitydropdown() {
			return WebDriverSingleton.getDriverInstance().findElement(By.name(CartConstants.quantitydropdown));
		}
		
		public static WebElement crossbutton() {
			return WebDriverSingleton.getDriverInstance().findElement(By.xpath(CartConstants.crossbtn));
		}
		
		public static WebElement cartbutton() {
			return WebDriverSingleton.getDriverInstance().findElement(By.id(CartConstants.cartbtn));
		}
		
		public static WebElement deltHeadphones() {
			return WebDriverSingleton.getDriverInstance().findElement(By.xpath(CartConstants.delheadphones));
		}
		
		public static WebElement checoutbtn() {
			return WebDriverSingleton.getDriverInstance().findElement(By.id(CartConstants.checkoutbtn));
		}
		
}