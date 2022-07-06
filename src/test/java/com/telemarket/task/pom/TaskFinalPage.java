package com.telemarket.task.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskFinalPage extends MainPage {

	protected WebDriver driver;

	public TaskFinalPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(id = "tl_final--52228_text")
	protected WebElement txtTaskFinal;

	public String getTextFinal() {
		return txtTaskFinal.getAttribute("value");
	}
}
