package com.telemarket.task.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.telemarket.task.pom.LoginPage;
import com.telemarket.task.pom.MainPage;
import com.telemarket.task.pom.TaskFinalPage;

public class TLMKT_TestTaskFinal {
	
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected MainPage mainPage;
	
	protected TaskFinalPage finalPage;

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@BeforeTest
	public void init() {
		System.setProperty("url", "https://sqa.peluangkerjaku.com/tele/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		loginPage = new LoginPage(driver);
		mainPage = new MainPage(driver);
		finalPage = new TaskFinalPage(driver);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
	}

	@BeforeMethod
	public void cekSession() {
		driver.get(System.getProperty("url"));
	}

	@Test(priority = 1)
	public void test_final_page() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(2);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskFinalPage finalPage = mainPage.clickTaskFinal();
		delay(1);
		assertEquals(finalPage.getTextFinal(),"DATA FINAL");
		delay(1);
		finalPage.clickBtnLogoutAtMain();
		delay(1);
		finalPage.logout();
	}
	
	@DataProvider(name = "validData")
	public Object[][] validData() {
		Object[][] myData = { {"warungkopiyoi", "https://tokko.io/warungkopiyoi0"} };
		return myData;
	}
	
	@Test(priority = 2, dataProvider = "validData")
	public void test_final_search_valid(String inNama, String inLink ) {
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
		finalPage.clickSearchFinal();
		delay(2);
		List<WebElement> lstElement = driver.findElements(By.xpath("//tbody"));
		boolean check = false;
		for (WebElement webElement : lstElement) {
			if (webElement.getText().contains(inNama) && webElement.getText().contains(inLink)) {
				check = true;
				delay(3);
				break;
			}
		}
		assertTrue(check);
		delay(1);
		finalPage.clickBtnLogoutAtMain();
		delay(1);
		finalPage.logout();
		delay(3);
	}
	
	@Test(priority = 3, dataProvider = "validData")
	public void test_final_search_valid_greenBtn(String inNama, String inLink ) {
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
		finalPage.clickGreenSearchFinal();
		delay(2);
		List<WebElement> lstElement = driver.findElements(By.xpath("//tbody"));
		boolean check = false;
		for (WebElement webElement : lstElement) {
			if (webElement.getText().contains(inNama) && webElement.getText().contains(inLink)) {
				check = true;
				delay(3);
				break;
			}
		}
		assertTrue(check);
		delay(1);
		finalPage.clickBtnLogoutAtMain();
		delay(1);
		finalPage.logout();
		delay(2);
	}
	
	@Test(priority = 4)
	public void testFinal_clickTable_gotoActivity() {
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
		delay(1);
		finalPage.viewTable(500);
		delay(3);
		finalPage.setSearchFinal("kopi");
		delay(1);
		finalPage.clickSearchFinal();
		delay(3);
		finalPage.clickBtnLogoutAtMain();
		delay(1);
		finalPage.logout();
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
}
