package com.facebook.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath ="//span[contains(text(),'Ketul Patel')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "(//span[contains(text(),'Friends')])[1]")
	WebElement friendsLink;
	
	@FindBy(xpath = "//span[contains(text(),'Memories')]")
	WebElement memoriesLink;
	

	@FindBy(xpath = "//span[contains(text(),'Video')]")
	WebElement videoLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public FriendsPage clickOnfriendsLink(){
		friendsLink.click();
		return new FriendsPage();
	}
	
	public MemoriesPage clickOnmemoriesLink(){
		memoriesLink.click();
		return new MemoriesPage();
	}
	
	public VideoPage clickOnvideoLink(){
		videoLink.click();
		return new VideoPage();
	}
	
	
	

}
