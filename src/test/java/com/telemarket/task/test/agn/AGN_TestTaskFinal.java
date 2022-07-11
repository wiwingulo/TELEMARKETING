package com.telemarket.task.test.agn;

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

import com.telemarket.task.pom.agent.AGN_LoginPage;
import com.telemarket.task.pom.agent.AGN_MainPage;
import com.telemarket.task.pom.agent.AGN_TaskFinalPage;


public class AGN_TestTaskFinal {
	
	protected WebDriver driver;
	protected AGN_LoginPage loginPage;
	protected AGN_MainPage mainPage;
	protected AGN_TaskFinalPage finalPage;

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
		loginPage = new AGN_LoginPage(driver);
		mainPage = new AGN_MainPage(driver);
		finalPage = new AGN_TaskFinalPage(driver);
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
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(2);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskFinalPage finalPage = mainPage.clickTaskFinal();
		delay(1);
		assertEquals(finalPage.getTextFinal(),"DATA FINAL");
		delay(1);
		finalPage.clickBtnLogoutAtMain();
		delay(1);
		finalPage.logout();
		delay(2);
	}
	
	@DataProvider(name = "validData")
	public Object[][] validData() {
		Object[][] myData = { {"Two d coffee roastery", "https://tokko.io/twodcoffeeroastery"} };
		return myData;
	}
	
	@Test(priority = 2, dataProvider = "validData")
	public void test_final_search_valid(String inNama, String inLink ) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(2);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskFinalPage finalPage = mainPage.clickTaskFinal();
		delay(1);
		finalPage.setSearchFinal(inNama);
		delay(1);
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
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(2);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskFinalPage finalPage = mainPage.clickTaskFinal();
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
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskFinalPage finalPage = mainPage.clickTaskFinal();
		delay(1);
		finalPage.clickLastPagination();
		delay(1);
		finalPage.clickFirstPagination();
		delay(1);
		finalPage.clickPage1();
		delay(1);
		finalPage.clickPage2();
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
