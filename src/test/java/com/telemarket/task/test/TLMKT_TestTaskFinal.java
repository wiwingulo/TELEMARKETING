package com.telemarket.task.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.telemarket.task.pom.LoginPage;
import com.telemarket.task.pom.MainPage;
import com.telemarket.task.pom.TaskFinalPage;

public class TLMKT_TestTaskFinal extends Utility {
	
	protected WebDriver driver;
	
	public boolean verifyDataInTable(String xpath, String data1, String data2) {
		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath(xpath));
		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String isiElement = webElement.getText();
			System.out.println(isiElement);
			if (isiElement.contains(data1) && isiElement.contains(data2)) {
				checkData = true;
			} else if (isiElement.isBlank()) {
				break;
			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		return checkData;
	}
	
	@BeforeMethod
	public void cekSession() {
		System.setProperty("url", "https://sqa.peluangkerjaku.com/tele/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
	}

	@Test(priority = 1)
	public void testSPVFinal_goToFinalPage() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskFinalPage finalPage = mainPage.clickTaskFinal();
		delay(1);
		assertEquals(finalPage.getTextFinal(),"DATA FINAL");
		delay(3);
	}
	
	@DataProvider(name = "validData")
	public Object[][] validData() {
		Object[][] myData = { {"pipinos.bakery", "https://pipinos.bakery.com"} };
		return myData;
	}
	
	@Test(priority = 2, dataProvider = "validData")
	public void testSPVFinal_validSearch(String inNama, String inLink ) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskFinalPage finalPage = mainPage.clickTaskFinal();
		delay(1);
		finalPage.setSearchFinal(inNama);
		delay(1);
		finalPage.clickSearchFinal();
		delay(2);
		try {
			verifyDataInTable("(//tr)[40]", inNama, inLink);
		} finally {
			delay(3);
		}
	}
	
	@Test(priority = 3, dataProvider = "validData")
	public void testSPVFinal_validSearch_btnGreen(String inNama, String inLink ) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(2);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskFinalPage finalPage = mainPage.clickTaskFinal();
		delay(1);
		finalPage.setSearchFinal(inNama);
		delay(1);
		finalPage.clickGreenSearchFinal();
		delay(2);
		try {
			verifyDataInTable("(//tr)[40]", inNama, inLink);
		} finally {
			delay(3);
		}
	}
	
	@Test(priority = 4)
	public void testSPVFinal_clickTableToActivity() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskFinalPage finalPage = mainPage.clickTaskFinal();
		delay(1);
		finalPage.clickLastPagination();
		delay(1);
		finalPage.clickFirstPagination();
		delay(1);
		finalPage.clickPage1();
		delay(1);
		finalPage.clickPage2();
		delay(1);
		finalPage.clickPage3();
		delay(1);
		finalPage.clickPage4();
		delay(1);
		finalPage.clickPage5();
		delay(1);
		finalPage.clickPage6();
		delay(1);
		finalPage.clickFirstPagination();
		delay(1);
		finalPage.viewTable(10);
		delay(1);
		finalPage.viewTable(25);
		delay(1);
		finalPage.viewTable(50);
		delay(1);
		finalPage.viewTable(100);
		delay(2);
		finalPage.viewTable(500);
		delay(3);
		finalPage.setSearchFinal("kopi");
		delay(1);
		finalPage.clickSearchFinal();
		delay(4);
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
