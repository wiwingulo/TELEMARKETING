package com.telemarket.task.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskDataAllPage extends MainPage {

	protected WebDriver driver;

	public TaskDataAllPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(id = "tl_all_data--53024_text")
	protected WebElement txtTaskDataAll;

	public String getTextDataAll() {
		return txtTaskDataAll.getAttribute("value");
	}
			
}
