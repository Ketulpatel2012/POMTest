package com.facebook.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.qa.base.TestBase;

public class FLoginPage extends TestBase{
	
	//Page Factory - OR:
		@FindBy(name="email")
		WebElement email;
		
		@FindBy(name="pass")
		WebElement pass;
		
		@FindBy(name="login")
		WebElement loginBtn;
		
		@FindBy(xpath="//a[@id='u_0_0_2r']")
		WebElement signUpBtn;
		
		@FindBy(xpath="//img[@alt='Facebook']")
		WebElement facebookLogo;
		
		//Initializing the Page Objects:
		public FLoginPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public boolean validateFacebookImage(){
			return facebookLogo.isDisplayed();
		}
		
		public HomePage login(String un, String pwd){
			email.sendKeys(un);
			pass.sendKeys(pwd);
			//loginBtn.click();
			    	JavascriptExecutor js = (JavascriptExecutor)driver;
			    	js.executeScript("arguments[0].click();", loginBtn);
			    	
			return new HomePage();
		}
		
	}
