package com.telemarket.pom.message;

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

	@FindBy(xpath = "//span[normalize-space()='Edit Data']")
	public WebElement btnEditData;

	@FindBy(xpath = "(//h3[normalize-space()='User Management'])[1]")
	public WebElement btnUserManagement;

	@FindBy(xpath = "//span[normalize-space()='User']")
	public WebElement btnUser;

	
	public Dashboard(WebDriver driver) {
		this.driver = driver;
	}

}
