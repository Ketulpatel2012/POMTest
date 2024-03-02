package com.facebook.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.FLoginPage;
import com.facebook.qa.pages.FriendsPage;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	FLoginPage floginPage;
	HomePage homePage;
	TestUtil testUtil;
	FriendsPage friendsPage;

	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		friendsPage = new FriendsPage();
		floginPage = new FLoginPage();
		homePage = floginPage.login(prop.getProperty("email"), prop.getProperty("pass"));
		Thread.sleep(5000);
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Facebook","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyFriendsLinkTest(){
		friendsPage = homePage.clickOnfriendsLink();
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
