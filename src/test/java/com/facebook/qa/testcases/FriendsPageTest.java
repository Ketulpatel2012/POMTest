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

public class FriendsPageTest extends TestBase{
	
	FLoginPage floginPage;
	HomePage homePage;
	TestUtil testUtil;
	FriendsPage friendsPage;

	public FriendsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		floginPage = new FLoginPage();
		homePage = new HomePage();
		friendsPage = new FriendsPage();
		homePage = floginPage.login(prop.getProperty("email"), prop.getProperty("pass"));
		Thread.sleep(5000);
		homePage.clickOnfriendsLink();
		Thread.sleep(5000);
	}
	
	@Test(priority=1)
	public void friendsPageTitleTest(){
		String title = friendsPage.verifyFriendsPageTitle();
		Assert.assertEquals(title, "Friends | Facebook", "Title not match");
	}
	
	@Test(priority=2)
		public void verifyfriendslabelTest(){
			Assert.assertTrue(friendsPage.verifyfriendslabel());
	}
	
	@Test(priority=3)
	public void verifysearchboxlink(){
		Assert.assertTrue(friendsPage.verifysearchboxlink());
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
