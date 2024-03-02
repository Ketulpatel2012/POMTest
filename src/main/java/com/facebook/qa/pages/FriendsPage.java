package com.facebook.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.qa.base.TestBase;

public class FriendsPage extends TestBase {
	
	@FindBy(xpath="//h1[contains(text(),'Friends')]")
	WebElement friendslabel;
	
	@FindBy(xpath="//span[@class='x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x1lkfr7t x1lbecb7 xk50ysn xzsf02u'][contains(text(),'Friend Requests')]")
	WebElement friendsreqlink;
	
	@FindBy(xpath="//span[contains(text(),'Close Friends')]")
	WebElement closefriendslink;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchboxlink;
	
	public FriendsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyFriendsPageTitle(){
		return driver.getTitle();
	}
	public boolean verifyfriendslabel(){
		return friendslabel.isDisplayed();

}
	public boolean verifysearchboxlink(){
		return searchboxlink.isDisplayed();
	
}
}
