package com.telemarket.pom.data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EditData {

	public WebDriver driver;
	
	@FindBy(id = "tl_edit_data--52532_text")
	protected WebElement inputSearchNew;
	
	@FindBy(xpath = "//span[normalize-space()='Search']")
	protected WebElement btnSearchNew;
	
	public EditData(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchDataNew(String inString) {
		inputSearchNew.clear();
		inputSearchNew.sendKeys(inString);
		btnSearchNew.click();
	}
}
