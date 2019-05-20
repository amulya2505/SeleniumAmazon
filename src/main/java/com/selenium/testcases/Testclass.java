package com.selenium.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium.pagemodels.CartPage;
import com.selenium.pagemodels.HomePage;
import com.selenium.pagemodels.SearchResultPage;
import com.selenium.pagemodels.SigninPage;
import com.selenium.utils.constants.HomePageConstants;
import com.selenium.utils.constants.SigninPageConstants;
import com.selenium.utils.utilities.Base;
import com.selenium.utils.utilities.PropertiesContext;
import com.selenium.utils.utilities.WebDriverSingleton;

public class Testclass {

	public WebDriver driver = WebDriverSingleton.getDriverInstance();

	@Test(description = "Login Case", priority = 1)
	@Parameters({ "verifylogin" })
	public void login(String verifylogin) {

		driver.get(HomePageConstants.url);
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.AmazonLogo()));

		HomePage.Signinclickable().click();
		PropertiesContext.getPropertiesContext();
		SigninPage.Emailfield()
				.sendKeys(PropertiesContext.getPropertiesContext().getConfigProp(SigninPageConstants.unameinput));
		SigninPage.Passwordfield()
				.sendKeys(PropertiesContext.getPropertiesContext().getConfigProp(SigninPageConstants.pwdinput));
		SigninPage.SinginBtn().click();
		String user = HomePage.Signinclickable().getText();
		Assert.assertTrue(user.contains(verifylogin));

	}

	@Test(description = "Search Headphones from Electronics and add into Cart", enabled = true, priority = 2)
	@Parameters({ "number_of_items" })
	public void headphoneSearch(String number_of_items) {
		Actions action = new Actions(driver);
		action.moveToElement(HomePage.DepartmentList()).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(HomePage.ElectronicsDepartment()));
		action.moveToElement(HomePage.ElectronicsDepartment()).click().build().perform();

		HomePage.HeadphoneSelect().click();
		SearchResultPage.headphoneresult().click();

		wait.until(ExpectedConditions.elementToBeClickable(CartPage.addtocart_btn()));
		CartPage.addtocart_btn().click();
		String cartitems = CartPage.no_of_CartItems().getText();
		Assert.assertTrue(cartitems.contains(number_of_items));

	}

	@Test(description = "Search Macbook and add second item to cart with quantity =2", enabled = true, priority = 3)
	@Parameters({ "searchkey", "quantity", "totalcart_items" })
	public void macbookSearch(String searchkey, String quantity, String totalcart_items) {
		HomePage.Searchbox().sendKeys(searchkey + Keys.RETURN);
		SearchResultPage.Macbookresult().click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		Select quant = new Select(CartPage.quantitydropdown());
		quant.selectByValue(quantity);

		CartPage.addtocart_btn().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO use Explicit wait
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.elementToBeClickable(CartPage.crossbutton()));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", CartPage.crossbutton());
		String cartitems = CartPage.no_of_CartItems().getText();
		Assert.assertTrue(cartitems.contains(totalcart_items));

	}

	@Test(description = "removal of headphones and decrease quantity of macbook", enabled = true, priority = 4)
	public void modifyCart() {
		CartPage.cartbutton().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO use Explicit wait
			e.printStackTrace();// TODO Can user logger Here
		}
		CartPage.deltHeadphones().click();
		Select quant = new Select(CartPage.checkoutquantitydropdown());
		quant.selectByValue("1");
		CartPage.checoutbtn().click();

	}

	@Test(description = "Logout Successfully", priority = 5)
	public void logout() {

		driver.navigate().back();
		Actions action = new Actions(driver);
		action.moveToElement(HomePage.Signinclickable()).build().perform();

		HomePage.signoutbtn().click();
		Assert.assertTrue(SigninPage.Emailfield().isDisplayed());

	}

	
	  @AfterClass
	  public void closeSesssion() 
	  { 
		  Base.tearDown(driver);
	  
	  }
	 
}