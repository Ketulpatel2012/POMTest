package com.facebook.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.FLoginPage;
import com.facebook.qa.pages.HomePage;

//import com.facebook.qa.base.TestBase;
//import com.facebook.qa.pages.FLoginPage;
//import com.facebook.qa.pages.HomePage;

//import pages.LoginPage;

public class FLoginPageTest extends TestBase {
	
	FLoginPage floginPage;
	HomePage homePage;
	
	public FLoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		floginPage = new FLoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = floginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Facebook - log in or sign up");
	}
	
	@Test(priority=2)
	public void facebookLogoImageTest(){
		boolean flag = floginPage.validateFacebookImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest(){
		homePage = floginPage.login(prop.getProperty("email"), prop.getProperty("pass"));
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	


}
