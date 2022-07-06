package com.telemarket.task.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskFollowUpPage extends MainPage{
	
	protected WebDriver driver;

	public TaskFollowUpPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(id = "tl_thinking--52762_text")
	protected WebElement txtTaskFollowUp;

	public String getTextFollowUp() {
		return txtTaskFollowUp.getAttribute("value");
	}
}
