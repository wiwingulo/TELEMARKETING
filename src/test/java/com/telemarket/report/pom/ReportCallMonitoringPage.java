package com.telemarket.report.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportCallMonitoringPage {
	protected WebDriver driver;
	
	@FindBy(xpath = "//input[@value='REPORT CALL MONITORING']")
	public WebElement txtReportCallMonitoring;
	
	public ReportCallMonitoringPage(WebDriver driver) {
		this.driver = driver;
	}

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getTxtReportCallMonitoring() {
		return txtReportCallMonitoring.getAttribute("value");
	}
}
