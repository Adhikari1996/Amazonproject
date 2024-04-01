package com.amazon.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class AmazonHome extends TestBase {
	// Page Factory - Initialize the Object Repository

		// amazon page sign in button
			@FindBy(xpath = "//span[text()=\"Account & Lists\"]")
			WebElement signinText;
			
			// user email address for login
			@FindBy(name = "email")
			WebElement emailAddress;
			
			// user email address for login
			@FindBy(name = "password")
			WebElement password;


			// user continue button for login
			@FindBy(xpath = "//input[@type='submit' and @id='continue']")
			WebElement emailButton;
			
			// user continue button for password
			@FindBy(xpath = "//input[@type='submit' and @id='signInSubmit']")
			WebElement passwordButton;
			
			@FindBy(xpath="//input[@name=\"field-keywords\"]")
			WebElement searchResultBox;
			
			//Add to card
			@FindBy(xpath="//button[@id=\"a-autoid-1-announce\"]")
			WebElement Addtocart;
			
			//Click on cart
			@FindBy(xpath="//a[@id=\"nav-cart\"]")
			WebElement clickoncart;
			
			//proceed to checkout
			@FindBy(xpath="//input[@name=\"proceedToRetailCheckout\" and @type=\"submit\"]")
			WebElement proceedtocheckout;
			
			//update the address
			@FindBy(xpath="//input[@id=\"address-ui-widgets-enterAddressPhoneNumber\" and @type=\"text\"]")
			WebElement updateAddress;

			//add address
			@FindBy(xpath="//input[@id=\"address-ui-widgets-enterAddressPhoneNumber\" and @type=\"text\"]")
			WebElement address;
			
			//item deleted
			@FindBy(xpath="//input[@name=\"submit.delete.341a9461-4f5f-48f0-a341-b458869e6617\"]")
			WebElement deleteItems;
			
			// Page Factory - Initialize the Elements
			public AmazonHome() {
				PageFactory.initElements(driver, this);
			}

			// Action to Elements
			public void Signin(){
				signinText.click();
			}
			
			public void userEmailLogin(String email) {
				this.emailAddress.sendKeys(email);
				emailButton.click();
			}
			
			public void userPasswordLogin(String password) {
				this.password.sendKeys(password);
				passwordButton.click();
			}
			
			public void homeSearchResult(String products){
				this.searchResultBox.clear();
				this.searchResultBox.sendKeys(products);
				System.out.println(products);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				List<WebElement> list = driver.findElements(
						By.xpath("//div[@class=\"left-pane-results-container\"]//descendant::div//div//div//span[@class=\"s-heavy\"]"));
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i).getText());
					if (list.get(i).getText().contains("pro")) {
						list.get(i).click();
						System.out.println(list.get(i));
						break;
					}else if (list.get(i).getText().contains("charger")) {
						list.get(i).click();
						System.out.println(list.get(i));
						break;
					}
				}
			}
			
			public void addToCart() {
				this.Addtocart.click();
			}
			
			public void clickOnCartBox() {
				this.clickoncart.click();
			}
			
			public void proceedToCheckOutItem() {
				this.proceedtocheckout.click();
			}
			
			public void updateAddress(String phonenumber) {
				this.updateAddress.clear();
				this.updateAddress.sendKeys(phonenumber);
			}
			public void itemDeletedAddCart() {
				this.deleteItems.click();
			}
}
