package com.telemarket.usermanagement.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telemarket.utilities.OtherFunc;

public class RecordingPage {
	protected WebDriver driver;
	
	@FindBy(xpath = "//input[@value='RECORDING']")
	public WebElement txtRecording;
	@FindBy(xpath = "(//input[@type='text'])[2]")
	public WebElement fieldSearchRec;
	@FindBy(xpath = "//span[normalize-space()='Search']")
	public WebElement btnSearch;
	@FindBy(xpath = "//span[normalize-space()='[d] Records']")
	public WebElement txtPopupRecords;
	@FindBy(xpath = "//img[@alt='Nikita Generator']")
	public WebElement btnHijau;
	
	public RecordingPage(WebDriver driver) {
		this.driver = driver;
	}

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getTxtRecording() {
		return txtRecording.getAttribute("value");
	}
	
	public void clickSearch() {
		btnSearch.click();
	}
	
	public void clickBtnHijau() {
		btnHijau.click();
	}
	
	public void sendFieldSearchRec(String xpath, String isiSendKeys) {
		fieldSearchRec.sendKeys(isiSendKeys);
		clickSearch();
		delay(1);
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.verifDataContainsNotArray(xpath, isiSendKeys);
	}
	
	public void testBtnHijau(String xpath, String isiSendKeys) {
		fieldSearchRec.sendKeys(isiSendKeys);
		clickBtnHijau();
		delay(1);
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.verifDataContainsNotArray(xpath, isiSendKeys);
	}
	
	public String getTxtPopup(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
		return txtPopupRecords.getText();
	}
}
