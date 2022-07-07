package com.telemarket.pom.data;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Utilities {
	
	public WebDriver driver;

	public Utilities (WebDriver driver) {
		this.driver = driver;
	}
	
	public void delay(int inInt) {
		try {
			Thread.sleep(inInt * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public boolean verifDataAgree(String xpathIsi) {
		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();

			if (status.equalsIgnoreCase("AGREE")) {
				checkData = true;
			} else if (status.isBlank()) {
				break;
			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);

		return checkData;
	}
	
	public boolean verifDataArray(String xpathIsi, String refArray[]) {
		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		boolean finalCheckData = false;
		for (WebElement webElement : lstElement) {
			String isiElement = webElement.getText();

			for (String i : refArray) {
				System.out.println(i);
				if (isiElement.equalsIgnoreCase(i)) {
					checkData = true;
				} else if (isiElement.isBlank()) {
					break;
				} else {
					checkData = false;
				}
				if (checkData = true) {
					finalCheckData = true;
				}
			}
		}
		assertTrue(finalCheckData);

		return finalCheckData;
	}

}
