package com.telemarket.report.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	
	protected WebDriver driver;
	
	// pop up at main page
	@FindBy(xpath = "//p[normalize-space()='Welcome to Tele Kita']")
	public WebElement txtPopUpOnMainPage;
	@FindBy(xpath = "//span[normalize-space()='OK']")
	public WebElement btnOKPopUpOnMainPage;
	@FindBy(xpath = "//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']")
	public WebElement btnClosePopUpOnMainPage;

	@FindBy(xpath = "//font[normalize-space()='Tele Marketing']")
	protected WebElement txtMainPage;
	
	@FindBy(xpath = "//span[normalize-space()='DEVELOPER']")
	public WebElement btnLogoutMainPage;
	
	// pop out logout
	@FindBy(xpath = "//span[@id='ui-id-21']")
	public WebElement txtPopUpLogout;
	@FindBy(xpath = "//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']")
	public WebElement btnClosePopUpLogout;
	@FindBy(xpath = "//span[normalize-space()='TIDAK']")
	public WebElement btnNoLogout;
	@FindBy(xpath = "//span[normalize-space()='YA']")
	public WebElement btnYesLogout;
	
	//dropdown Report
	@FindBy(xpath = "(//h3[normalize-space()='Report'])[1]")
	public WebElement dropdownReport;
	@FindBy(xpath = "//span[normalize-space()='Report Agree']")
	public WebElement btnReportAgree;
	@FindBy(xpath = "//span[normalize-space()='Report Activity']")
	public WebElement btnReportActivity;
	@FindBy(xpath = "//span[normalize-space()='Report Call Track (NEW)']")
	public WebElement btnReportCallTrack;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTxtMainPage() {
		return txtMainPage.getText();
	}
	
	public void clickOk() {
		btnOKPopUpOnMainPage.click();
	}
	
	public ReportAgreePage clickReportAgree() {
		dropdownReport.click();
		btnReportAgree.click();
		
		ReportAgreePage reportAgreePage = PageFactory.initElements(driver, ReportAgreePage.class);
		
		return reportAgreePage;
	}
	
	public ReportActivityPage clickReportActivity() {
		dropdownReport.click();
		btnReportActivity.click();
		
		ReportActivityPage reportActivityPage = PageFactory.initElements(driver, ReportActivityPage.class);
		
		return reportActivityPage;
	}
	
	public ReportCallTrack clickReportCallTrack() {
		dropdownReport.click();
		btnReportCallTrack.click();
		
		ReportCallTrack reportCallTrack = PageFactory.initElements(driver, ReportCallTrack.class);
		
		return reportCallTrack;
	}
	
}
