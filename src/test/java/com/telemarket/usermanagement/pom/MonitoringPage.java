package com.telemarket.usermanagement.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MonitoringPage {
protected WebDriver driver;
	
	@FindBy(xpath = "//input[@value='MONITORING']")
	public WebElement txtMonitoring;
	
	public MonitoringPage(WebDriver driver) {
		this.driver = driver;
	}

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getTxtMonitoring() {
		return txtMonitoring.getAttribute("value");
	}
}
