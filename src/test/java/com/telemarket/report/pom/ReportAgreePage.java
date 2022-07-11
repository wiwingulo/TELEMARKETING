package com.telemarket.report.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telemarket.utilities.CalendarViewFunction;
import com.telemarket.utilities.OtherFunc;


public class ReportAgreePage {

	protected WebDriver driver;
	
	@FindBy(xpath = "//input[@value='REPORT SETUJU']")
	public WebElement txtReportAgree;
	@FindBy(xpath = "//span[normalize-space()='View']")
	public WebElement btnView;
	@FindBy(xpath = "//span[normalize-space()='Export']")
	public WebElement btnExport;

	@FindBy(xpath = "(//img[@alt='Nikita Gebnerator'])[1]")
	public WebElement btnStartDate;
	@FindBy(xpath = "(//img[@alt='Nikita Gebnerator'])[2]")
	public WebElement btnEndDate;	
	
	public ReportAgreePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTxtReportAgree() {
		return txtReportAgree.getAttribute("value");
	}
	
	public void clickView() {
		btnView.click();
	}
	
	public void clickExport() {
		btnExport.click();
	}
	
	public void setStartDate(String date) {
		btnStartDate.click();
		CalendarViewFunction calendar = PageFactory.initElements(driver, CalendarViewFunction.class);
		calendar.setDate(date);
	}
	
	public void setEndDate(String date) {
		btnEndDate.click();
		CalendarViewFunction calendar = PageFactory.initElements(driver, CalendarViewFunction.class);
		calendar.setDate(date);
	}
	
	public void checkDataAgree(String xpath) {
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.verifDataAgree(xpath);
	}
	
	public void checkActivityDate(String xpath, String startDate, String endDate) {
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.verifActivityDate(xpath, startDate, endDate);
	}
	
}
