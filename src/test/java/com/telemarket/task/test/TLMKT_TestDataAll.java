package com.telemarket.task.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
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
import com.telemarket.task.pom.TaskAgreePage;
import com.telemarket.task.pom.TaskDataAllPage;

public class TLMKT_TestDataAll {
	
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected MainPage mainPage;
	
	protected TaskDataAllPage allPage;

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

	@BeforeTest
	public void init() {
		System.setProperty("url", "https://sqa.peluangkerjaku.com/tele/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		loginPage = new LoginPage(driver);
		mainPage = new MainPage(driver);
		allPage = new TaskDataAllPage(driver);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
	}

	@BeforeMethod
	public void cekSession() {
		driver.get(System.getProperty("url"));
	}

	@DataProvider(name = "validData")
	public Object[] validData() {
		Object[] myData = { "kopi", "1", "Toko_Adil_3" };
		return myData;
	}

	@Test(priority = 1, dataProvider = "validData")
	public void test_all_search_valid(String in) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(2);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickDataAll();
		delay(1);
		assertEquals(allPage.getTextDataAll(),"DATA ALL");
		delay(1);
		allPage.setSearchAll(in);
		delay(1);
		allPage.clickSearchDataAll();
		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath("(//tbody)[40]"));
		String expectedChar = in;
		boolean check = false;
		for (WebElement webElement : lstElement) {
			if (webElement.getText().contains(expectedChar)) {
				check = true;
				delay(1);
				break;
			}
		}
		assertTrue(check);
		delay(1);
		allPage.clickBtnLogoutAtMain();
		delay(3);
		allPage.logout();
	}
	
	@DataProvider(name = "unusualData")
	public Object[] unusualData() {
		Object[] myData = { "", "@", "&", "_" };
		return myData;
	}

	@Test(priority = 2, dataProvider = "unusualData")
	public void test_all_search_empty_and_unusual(String in) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickDataAll();
		delay(1);
		allPage.setSearchAll(in);
		delay(1);
		List<WebElement> lstElement = driver.findElements(By.xpath("(//tbody)[40]"));
		String expectedChar = in;
		boolean check = false;
		for (WebElement webElement : lstElement) {
			if(webElement.getText().isBlank()) {
				break;
			}else if (webElement.getText().contains(expectedChar)) {
				check = true;
				delay(2);
				break;
			}
		}
		assertTrue(check);
		delay(1);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
		delay(2);
	}

	@Test(priority = 3)
	public void test_agree_export_data() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskAgreePage agreePage = mainPage.clickDataAgree();
		delay(1);
		agreePage.clickExportAgree();
		delay(3);
		String downloadPath = "C:\\Users\\nexsoft\\Downloads";
		File getLatestFile = getLatestFilefromDir(downloadPath);
		String fileName = getLatestFile.getName();
		assertTrue(fileName.contains("exportagree"), "Data tidak ada/tidak sesuai");
		delay(3);
		agreePage.clickBtnLogoutAtMain();
		delay(1);
		agreePage.logout();
	}
	
	@Test(priority = 4)
	public void testAgree_clickTable_gotoActivity() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskAgreePage agreePage = mainPage.clickDataAgree();
		delay(1);
		agreePage.clickLastPagination();
		delay(1);
		agreePage.clickFirstPagination();
		delay(1);
		agreePage.clickPage1();
		delay(1);
		agreePage.clickPage2();
		delay(1);
		agreePage.clickPage3();
		delay(1);
		agreePage.clickPage4();
		delay(1);
		agreePage.clickPage5();
		delay(1);
		agreePage.clickPage6();
		delay(1);
		agreePage.clickFirstPagination();
		delay(1);
		agreePage.viewTable(10);
		delay(1);
		agreePage.viewTable(25);
		delay(1);
		agreePage.viewTable(50);
		delay(1);
		agreePage.viewTable(100);
		delay(1);
		agreePage.viewTable(500);
		delay(2);
		agreePage.searchDataAgree("kopi");
		delay(3);
		agreePage.clickTopTable();
		delay(1);
		System.out.println(agreePage.getTextAgreeActivity());
		assertEquals(agreePage.getTextAgreeActivity(),"Data Detail");
		delay(2);
		agreePage.closeAgreeActivity();
		delay(1);
		agreePage.clickBtnLogoutAtMain();
		delay(1);
		agreePage.logout();
	}
	
	@AfterTest
	public void close() {
//		File file = new File("C:\\Users\\nexsoft\\Downloads\\exportagree.xls");
//		file.delete();
		driver.close();
	}
}
