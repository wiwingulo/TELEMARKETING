package com.telemarket.report.pom;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OtherFunc {

	public WebDriver driver;

	public OtherFunc(WebDriver driver) {
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

	public boolean verifActivityDate(String xpathIsi, String startDate, String endDate) {

		String tanggalAwal = startDate.substring(0, 2);
		String bulanAwal = startDate.substring(2, 4);
		String tahunAwal = startDate.substring(4, 8);
		String tanggalAkhir = endDate.substring(0, 2);
		String bulanAkhir = endDate.substring(2, 4);
		String tahunAkhir = endDate.substring(4, 8);

		String dateAwalS = tahunAwal + bulanAwal + tanggalAwal;
		String dateAkhirS = tahunAkhir + bulanAkhir + tanggalAkhir;

		int dateAwal = Integer.parseInt(dateAwalS);
		int dateAkhir = Integer.parseInt(dateAkhirS);

		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String actDateS = webElement.getText();

			String actDateThnS = actDateS.substring(0, 4);
			String actDateBlnS = actDateS.substring(5, 7);
			String actDateTglS = actDateS.substring(8, 10);

			actDateS = actDateThnS + actDateBlnS + actDateTglS;

			int actDate = Integer.valueOf(actDateS);

			if (actDate < dateAkhir && actDate > dateAwal) {
				checkData = true;
			} else if (actDateS.isBlank()) {
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
	
	public boolean verifDataNotArray(String xpathIsi, String refData) {
		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String isiElement = webElement.getText();
			System.out.println(isiElement);
			if (isiElement.equalsIgnoreCase(refData)) {
				checkData = true;
			} 
			else if (isiElement.isBlank()) {
				break;
			} 
			else {
				checkData = false;
			}
		}
		assertTrue(checkData);

		return checkData;
	}
	
	public boolean verifDataContainsNotArray(String xpathIsi, String refData) {
		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String isiElement = webElement.getText().toLowerCase();
			System.out.println(isiElement);
			if (isiElement.contains(refData.toLowerCase())) {
				checkData = true;
			} 
//			else if (isiElement.isBlank()) {
//				break;
//			} 
			else {
				checkData = false;
			}
		}
		assertTrue(checkData);

		return checkData;
	}

}
