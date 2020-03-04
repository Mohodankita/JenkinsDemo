package com.offline.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.offline.qa.base.Testbase;

public class Login_Page extends Testbase {
	// Page factory or Object repo

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//button[@type= 'submit']")
	WebElement loginbutton;

	@FindBy(xpath = "//a[@class ='text-center']")
	WebElement signup;

	@FindBy(xpath = "//img[contains(src,'pages/images/jbk.png')]")
	WebElement imglogo;

	// Initializing the Page Objects:
	public Login_Page() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMImage() {
		return imglogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) {
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
		
		return new HomePage();
		
		

	}

}
