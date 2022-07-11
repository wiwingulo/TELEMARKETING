package com.telemarket.report.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportStatusCustomerPage {
	protected WebDriver driver;

	@FindBy(xpath = "//input[@value='REPORT LEVEL CUSTOMER']")
	public WebElement txtReportStatusCustomer;
	@FindBy(xpath = "//span[normalize-space()='Export']")
	public WebElement btnExport;
	
	public ReportStatusCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getTxtReportStatusCustomer() {
		return txtReportStatusCustomer.getAttribute("value");
	}
	
	public void clickExport() {
		btnExport.click();
	}
}
