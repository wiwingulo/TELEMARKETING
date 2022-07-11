package com.telemarket.usermanagement.pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telemarket.utilities.OtherFunc;

public class PhoneApprovePage {
	protected WebDriver driver;
	
	@FindBy(xpath = "//input[@value='ADDITIONAL PHONE']")
	public WebElement txtPhoneApprove;
	@FindBy(xpath = "(//input[contains(@type,'text')])[2]")
	public WebElement fieldAgentSearch;
	@FindBy(xpath = "//span[normalize-space()='Search']")
	public WebElement btnSearch;
	@FindBy(xpath = "//span[normalize-space()='Approve']")
	public WebElement btnApprove;
	@FindBy(xpath = "//span[normalize-space()='Reject']")
	public WebElement btnReject;
	@FindBy(xpath = "//span[normalize-space()='YES']")
	public WebElement btnYes;
	@FindBy(xpath = "//p[normalize-space()='DATA BERHASIL DI SETUJUI']")
	public WebElement txtBerhasilApprove;
	@FindBy(xpath = "//p[normalize-space()='DATA BERHASIL DI TOLAK']")
	public WebElement txtBerhasilReject;
	
	public PhoneApprovePage(WebDriver driver) {
		this.driver = driver;
	}

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getTxtPhoneApprove() {
		return txtPhoneApprove.getAttribute("value");
	}
	
	public void clickSearch() {
		btnSearch.click();
	}
	
	public void clickApprove() {
		btnApprove.click();
		delay(1);
		btnYes.click();
	}
	
	public void clickReject() {
		btnReject.click();
		delay(1);
		btnYes.click();
	}
	
	public void sendFieldAgentSearch(String xpath, String isiSendKeys) {
		fieldAgentSearch.sendKeys(isiSendKeys);
		clickSearch();
		delay(1);
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.verifDataContainsNotArray(xpath, isiSendKeys);
	}
	
	public void checkBoxChecked(int jumlahCheck) {
		for (int i = 1; i <= jumlahCheck; i++) {
			driver.findElement(By.xpath("//div[5]/div[6]/table[1]/tbody[1]/tr[" + i + "]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]")).click();
		}
	}
	
	public void verifApprove(String checked) {
		if (checked == "yes") {
			assertEquals(txtBerhasilApprove.getText(), "DATA BERHASIL DI SETUJUI");
		}
		else if (checked == "no") {
			assertNotEquals(txtBerhasilApprove.getText(), "DATA BERHASIL DI SETUJUI");
		}
		
	}
	
	public void verifReject(String checked) {
		if (checked == "yes") {
			assertEquals(txtBerhasilReject.getText(), "DATA BERHASIL DI TOLAK");
		}
		else if (checked == "no") {
			assertNotEquals(txtBerhasilReject.getText(), "DATA BERHASIL DI TOLAK");
		}
		
	}

}
