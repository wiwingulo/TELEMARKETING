package com.telemarket.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	protected WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//span[@id='ui-id-1']")
	public WebElement txtLogin;
	
	@FindBy(xpath = "//input[@id='tl_login-1-51550_text']")
	public WebElement inputUsername;
	
	@FindBy(xpath = "//input[@id='tl_login-1-51551_text']")
	public WebElement inputPassword;
	
	@FindBy(xpath = "//span[normalize-space()='Sign In']")
	public WebElement btnSignIn;
	
	public MainPage login_goto_main_page(String inUser, String inPass) {
		inputUsername.clear();
		inputUsername.sendKeys(inUser);
		inputPassword.clear();
		inputPassword.sendKeys(inPass);
		btnSignIn.click();
		
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		
		return mainPage;
	}
	
//	@FindBy(xpath = "//span[@id='ui-id-1']")
//	public WebElement txtLogin;
//	@FindBy(xpath = "//span[@id='ui-id-1']")
//	public WebElement txtLogin;
	
}
