package com.offline.qa.testdata;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.offline.qa.base.Testbase;
import com.offline.qa.pages.Login_Page;

public class Login_PageTest extends Testbase {
	Login_Page loginPage;

	public Login_PageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new Login_Page();
	}

	@Test
	public void Title(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "JavaByKiran | Log in");
	}
	
	@Test
	public void Logo(){
		loginPage.validateCRMImage();
		
	}
	@AfterMethod
	public void closebr() {
		driver.quit();
	}

}
