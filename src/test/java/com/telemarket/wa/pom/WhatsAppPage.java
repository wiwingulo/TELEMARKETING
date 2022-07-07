package com.telemarket.wa.pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telemarket.report.pom.OtherFunc;

public class WhatsAppPage {
	protected WebDriver driver;

	@FindBy(xpath = "//input[@value='DATA MESSAGE WA']")
	public WebElement txtMessageWA;
	@FindBy(xpath = "//span[normalize-space()='[d] Activity']")
	public WebElement txtMessagePopUpKedua;
	
	public WhatsAppPage(WebDriver driver) {
		this.driver = driver;
	}

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getTxtMessageWA() {
		return txtMessageWA.getAttribute("value");
	}
	
	public void assertNomorWA() {
		delay(1);
		String isiTabelNomorWA = driver.findElement(By.xpath("//tbody[1]/tr[1]/td[4]")).getText();
		driver.findElement(By.xpath("//div[1]/div[3]/div[6]/table[1]/tbody[1]/tr[1]/td[4]")).click();
		delay(1);
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.verifDataNotArray("//div[3]/div[1]/div[6]/table[1]/tbody[1]/tr/td[4]", isiTabelNomorWA);
	}
	
	public void assertPopUpWithinPopUp() {
		delay(1);
		driver.findElement(By.xpath("//div[1]/div[3]/div[6]/table[1]/tbody[1]/tr[1]/td[4]")).click();
		driver.findElement(By.xpath("//div[3]/div[1]/div[6]/table[1]/tbody[1]/tr/td[4]")).click();
		assertNotEquals(txtMessagePopUpKedua.getText(), "[d] Activity");
	}
}
