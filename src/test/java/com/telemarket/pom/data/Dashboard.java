package com.telemarket.pom.data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telemarket.pom.message.LoginPage;

public class Dashboard {

	protected WebDriver driver;
	
	@FindBy(xpath = "//h3[@id='ui-id-11']")
	public WebElement btnData;
	
	@FindBy(xpath = "//span[normalize-space()='Upload Data']")
	public WebElement btnUploadData;
	
	@FindBy(xpath = "//span[normalize-space()='Distribute Data']")
	public WebElement btnDistributeData;
	
	@FindBy(xpath = "//span[normalize-space()='Edit Data']")
	public WebElement btnEditData;
	
	@FindBy(xpath = "//span[@id='ui-id-21']")
	public WebElement txtPopUpLogout;
	@FindBy(xpath = "//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']")
	public WebElement btnClosePopUpLogout;
	@FindBy(xpath = "(//span[normalize-space()='TIDAK'])[1]")
	public WebElement btnNoLogout;
	@FindBy(xpath = "(//span[normalize-space()='YA'])[1]")
	public WebElement btnYesLogout;
	@FindBy(xpath = "//span[normalize-space()='DEVELOPER']")
	private WebElement btnLogoutMainPage;

	public LoginPage logout() {
		btnYesLogout.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}

	public void clickBtnLogoutAtMain() {
		btnLogoutMainPage.click();
	}

	
	public Dashboard (WebDriver driver) {
		this.driver=driver;
	}
	
	public void delay(int inInt) {
		try {
			Thread.sleep(inInt*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
    public void gotoDistributeData() {
		btnData.click();
		delay(1);
		btnDistributeData.click();
		delay(2);
    }
	

}
