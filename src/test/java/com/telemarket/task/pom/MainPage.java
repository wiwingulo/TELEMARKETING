package com.telemarket.task.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	protected WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//font[normalize-space()='Tele Marketing']")
	protected WebElement txtMainPage;

	public String getTextMainPage() {
		return txtMainPage.getText();
	}
	
	@FindBy(xpath = "//span[normalize-space()='DEVELOPER']")
	protected WebElement btnLogoutMainPage;
	
	public void clickBtnLogoutAtMain() {
		btnLogoutMainPage.click();
	}
	
	@FindBy(xpath = "//h3[@id='ui-id-15']")
	protected WebElement btnTask;
	
	public void clickTask() {
		btnTask.click();
	}

	@FindBy(xpath = "//button[@id='52827_query']")
	protected WebElement btnDataNew;

	public TaskNewPage clickDataNew() {
		btnDataNew.click();
		return PageFactory.initElements(driver, TaskNewPage.class);
	}

	@FindBy(xpath = "//button[@id='52826_query']")
	protected WebElement btnDataAgree;

	public TaskAgreePage clickDataAgree() {
		btnDataAgree.click();
		return PageFactory.initElements(driver, TaskAgreePage.class);
	}

	@FindBy(xpath = "(//button[@id='52834_query'])[1]")
	protected WebElement btnDataFollowUp;

	public TaskFollowUpPage clickDataFollowUp() {
		btnDataFollowUp.click();
		return PageFactory.initElements(driver, TaskFollowUpPage.class);
	}

	@FindBy(xpath = "(//button[@id='52858_query'])[1]")
	protected WebElement btnDataAll;

	public TaskDataAllPage clickTaskAll() {
		btnDataAll.click();
		return PageFactory.initElements(driver, TaskDataAllPage.class);
	}

	@FindBy(xpath = "(//button[@id='52841_query'])[1]")
	protected WebElement btnTaskFinal;
	
	public TaskFinalPage clickTaskFinal() {
		btnTaskFinal.click();
		return PageFactory.initElements(driver, TaskFinalPage.class);
	}

	/////// POPUP AFTER LOGIN --------------------------------------------
	@FindBy(xpath = "//span[@id='ui-id-21']")
	protected WebElement txtPopUpOnMainPage;

	public String getTextPopUp() {
		return txtPopUpOnMainPage.getText();
	}

	@FindBy(xpath = "//span[normalize-space()='OK']")
	protected WebElement btnOKPopUpOnMainPage;

	public void clickOKPopUpAfterLogin() {
		btnOKPopUpOnMainPage.click();
	}

	@FindBy(xpath = "//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']")
	protected WebElement btnClosePopUpOnMainPage;

	public void clickCancelPopUpAfterLogin() {
		btnClosePopUpLogout.click();
	}

	/////// POPUP LOGOUT ----------------------------------------------------
	@FindBy(xpath = "//span[@id='ui-id-21']")
	protected WebElement txtPopUpLogout;
	
	public String getTextPopUpLogout() {
		return txtPopUpLogout.getText();
	}
	
	@FindBy(xpath = "//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']")
	protected WebElement btnClosePopUpLogout;
	
	public void clickClosePopUpLogout() {
		btnClosePopUpLogout.click();
	}
	
	@FindBy(xpath = "(//span[normalize-space()='TIDAK'])[1]")
	public WebElement btnNoLogout;
	
	public void clickNOPopUpLogout() {
		btnNoLogout.click();
	}
	
	@FindBy(xpath = "(//span[normalize-space()='YA'])[1]")
	protected WebElement btnYesLogout;

	public LoginPage logout() {
		btnYesLogout.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
}
