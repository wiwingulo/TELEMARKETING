package com.telemarket.pom.data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

	protected WebDriver driver;
	
	@FindBy(xpath = "//h3[@id='ui-id-11']")
	public WebElement btnData;
	
	@FindBy(xpath = "//span[normalize-space()='Upload Data']")
	public WebElement btnUploadData;
	
	@FindBy(xpath = "//span[normalize-space()='Distribute Data']")
	public WebElement btnDistributeData;
	
	public Dashboard (WebDriver driver) {
		this.driver=driver;
	}
	

}
