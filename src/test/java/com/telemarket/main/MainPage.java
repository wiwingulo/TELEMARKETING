package com.telemarket.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telemarket.report.pom.ReportActivityPage;
import com.telemarket.report.pom.ReportAgreePage;
import com.telemarket.report.pom.ReportCallMonitoringPage;
import com.telemarket.report.pom.ReportCallTrackPage;
import com.telemarket.report.pom.ReportStatusCustomerPage;
import com.telemarket.usermanagement.pom.MonitoringPage;
import com.telemarket.usermanagement.pom.PhoneApprovePage;
import com.telemarket.usermanagement.pom.RecordingPage;
import com.telemarket.wa.pom.WhatsAppPage;

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
	
	@FindBy(xpath = "(//span[@class='ui-button-text'])[1]")
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
	@FindBy(xpath = "//span[normalize-space()='Report Call Monitoring (NEW)']")
	public WebElement btnReportCallMonitoring;
	@FindBy(xpath = "//span[normalize-space()='Report Status Customer']")
	public WebElement btnReportStatusCustomer;
	
	//dropdown Message WA
	@FindBy(xpath = "(//h3[normalize-space()='Message WA'])[1]")
	public WebElement dropdownWA;
	@FindBy(xpath = "//span[normalize-space()='WA']")
	public WebElement btnWA;
	
	//dropdown User Management
	@FindBy(xpath = "(//h3[normalize-space()='User Management'])[1]")
	public WebElement dropdownUserManagement;
	@FindBy(xpath = "//span[normalize-space()='Phone Approve']")
	public WebElement btnPhoneApprove;
	@FindBy(xpath = "//span[normalize-space()='Recording']")
	public WebElement btnRecording;
	@FindBy(xpath = "//span[normalize-space()='Monitoring']")
	public WebElement btnMonitoring;
	
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
	
	public ReportCallTrackPage clickReportCallTrack() {
		dropdownReport.click();
		btnReportCallTrack.click();
		
		ReportCallTrackPage reportCallTrack = PageFactory.initElements(driver, ReportCallTrackPage.class);
		
		return reportCallTrack;
	}
	
	public ReportCallMonitoringPage clickReportCallMonitoring() {
		dropdownReport.click();
		btnReportCallMonitoring.click();
		
		ReportCallMonitoringPage reportCallMonitoring = PageFactory.initElements(driver, ReportCallMonitoringPage.class);
		
		return reportCallMonitoring;
	}
	
	public ReportStatusCustomerPage clickReportStatusCustomer() {
		dropdownReport.click();
		btnReportStatusCustomer.click();
		
		ReportStatusCustomerPage reportStatusCustomer = PageFactory.initElements(driver, ReportStatusCustomerPage.class);
		
		return reportStatusCustomer;
	}
	
	public WhatsAppPage clickMessageWA() {
		dropdownWA.click();
		btnWA.click();
		
		WhatsAppPage whatsAppPage = PageFactory.initElements(driver, WhatsAppPage.class);
		
		return whatsAppPage;
	}
	
	public PhoneApprovePage clickPhoneApprove() {
		dropdownUserManagement.click();
		btnPhoneApprove.click();
		
		PhoneApprovePage phoneApprovePage = PageFactory.initElements(driver, PhoneApprovePage.class);
		
		return phoneApprovePage;
	}
	
	public RecordingPage clickRecording() {
		dropdownUserManagement.click();
		btnRecording.click();
		
		RecordingPage recordingPage = PageFactory.initElements(driver, RecordingPage.class);
		
		return recordingPage;
	}
	
	public MonitoringPage clickMonitoring() {
		dropdownUserManagement.click();
		btnMonitoring.click();
		
		MonitoringPage monitoringPage = PageFactory.initElements(driver, MonitoringPage.class);
		
		return monitoringPage;
	}
	
}
