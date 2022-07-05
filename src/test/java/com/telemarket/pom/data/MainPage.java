package com.telemarket.pom.data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	protected WebDriver driver;

	@FindBy(xpath = "//span[normalize-space()='OK']")
	public WebElement btnOK;

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}


}
