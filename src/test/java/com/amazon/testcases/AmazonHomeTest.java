package com.amazon.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.AmazonHome;

public class AmazonHomeTest extends TestBase  {
	public AmazonHome homepage;
	
	public AmazonHomeTest() {
		super();
	}

	@BeforeMethod
	public void Setup(){
		initilization();
		homepage = new AmazonHome();
	}
	
	@Test()
	public void addToCartTest(){
		homepage.Signin();
		homepage.userEmailLogin(prop.getProperty("email"));
		homepage.userPasswordLogin(prop.getProperty("password"));
		homepage.homeSearchResult("macbook ");
		homepage.addToCart();
		homepage.clickOnCartBox();
		homepage.proceedToCheckOutItem();
		homepage.updateAddress("1234567890");
	}
	
	@Test()
	public void multiItemsTest(){
		homepage.Signin();
		homepage.userEmailLogin(prop.getProperty("email"));
		homepage.userPasswordLogin(prop.getProperty("password"));
		homepage.homeSearchResult("airbook");
		homepage.addToCart();
		homepage.homeSearchResult("macbook ");
		homepage.addToCart();
		homepage.clickOnCartBox();
		homepage.itemDeletedAddCart();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	} 

}
