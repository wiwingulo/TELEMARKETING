package com.telemarket.pom.message;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class User {
	
	public WebDriver driver;
	
	@FindBy(xpath = "51683_query")
	public WebElement btnAdd;
	
	@FindBy(xpath = "(//input[@id='tl_agent_editable-14-51730_text'])[1]")
	public WebElement fieldFullName;
	
	@FindBy(id = "tl_agent_editable-14-51731_text")
	public WebElement selectPriv;
	
	@FindBy(id = "tl_agent_editable-14-51733_text")
	public WebElement selectSpv;
	
	@FindBy(xpath = "(//input[@id='tl_agent_editable-14-51736_text'])[1]")
	public WebElement fieldHp;
	
	@FindBy(xpath = "(//input[@id='tl_agent_editable-14-51746_text'])[1]")
	public WebElement fieldExtension;
	
	@FindBy(xpath = "(//input[@id='tl_agent_editable-14-51740_text'])[1]")
	public WebElement username;
	
	@FindBy(xpath = "(//input[@id='tl_agent_editable-14-51741_text'])[1]")
	public WebElement password;
	
	@FindBy(xpath = "//span[normalize-space()='Save']")
	public WebElement btnSave;
	
	public User (WebDriver driver) {
		this.driver = driver;
	}
	
	public void addAgent() {
		fieldFullName.sendKeys("Wiwin PG");
		Select dropdown = new Select(driver.findElement(By.id("tl_agent_editable-14-51731_text")));
		dropdown.selectByValue("Admin");
		Select dropdown2 = new Select(driver.findElement(By.id("tl_agent_editable-14-51733_text")));
		dropdown2.selectByValue("ADMIN (ADMIN)");
		fieldHp.sendKeys("23121312");
		fieldExtension.sendKeys("210219");
		username.clear();
		username.sendKeys("wiwinguoleo");
		password.clear();
		password.sendKeys("12");
		btnSave.click();
	}

}
