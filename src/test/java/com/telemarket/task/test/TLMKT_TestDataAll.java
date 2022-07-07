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
		TaskDataAllPage allPage = mainPage.clickTaskAll();
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
		delay(2);
		allPage.logout();
		delay(3);
	}
	
	@DataProvider(name = "unusualData")
	public Object[] unusualData() {
		Object[] myData = { "", "@", "&" };
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
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(in);
		delay(1);
		allPage.clickSearchDataAll();
		delay(4);
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
	}
	
	@DataProvider(name = "dataCust")
	public Object[] dataCust() {
		Object[] myData = {"","kopi"};
		return myData;
	}

	@Test(priority = 3, dataProvider="dataCust")
	public void test_all_search_empty(String in) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(in);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		List<WebElement> lstElement = driver.findElements(By.xpath("(//tr)[43]"));
		boolean check = false;
		for (WebElement webElement : lstElement) {
			if (webElement.getText().contains(in)) {
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
	}
	
	@Test(priority = 4)
	public void test_all_search_agent() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String agen = "AGENT01";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.clickAgent(agen);
		delay(1);
		allPage.clickSearchDataAll();
		delay(2);
		List<WebElement> lstElement = driver.findElements(By.xpath("(//tr)[43]"));
		boolean check = false;
		for (WebElement webElement : lstElement) {
			if (webElement.getText().contains(agen)) {
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
	}
	
	@Test(priority = 5)
	public void test_all_search_status() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String status = "Berhasil";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.clickStatus(status);
		delay(1);
		allPage.clickSearchDataAll();
		delay(2);
		List<WebElement> lstElement = driver.findElements(By.xpath("//tbody"));
		boolean check = false;
		for (WebElement webElement : lstElement) {
			System.out.println(webElement.getText());
			if (webElement.getText().contains(status)) {
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
	}
	
	@Test(priority = 6)
	public void test_all_search_customer_agent() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String cust = "Kopi";
		String agen = "AGENT01";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(cust);
		allPage.clickAgent(agen);
		delay(1);
		allPage.clickSearchDataAll();
		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath("(//tr)[43]"));
		boolean check = false;
		for (WebElement webElement : lstElement) {
			if (webElement.getText().contains(agen) && webElement.getText().contains(agen)) {
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
	}
	
	@Test(priority = 7)
	public void test_all_search_customer_status() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String cust = "Kopi";
		String status = "Berhasil";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(cust);
		allPage.clickStatus(status);
		delay(1);
		allPage.clickSearchDataAll();
		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath("(//tr)[43]"));
		boolean check = false;
		for (WebElement webElement : lstElement) {
			if (webElement.getText().contains(cust) && webElement.getText().contains(status)) {
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
	}
	
	@Test(priority = 8)
	public void test_all_search_agent_status() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String agen = "AGENT01";
		String status = "Berhasil";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.clickAgent(agen);
		allPage.clickStatus(status);
		delay(1);
		allPage.clickSearchDataAll();
		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath("(//tr)[43]"));
		boolean check = false;
		for (WebElement webElement : lstElement) {
			if (webElement.getText().contains(agen) && webElement.getText().contains(status)) {
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
	}
	
	@Test(priority = 9)
	public void test_all_search_customer_agent_status() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String cust = "Cookies";
		String agen = "AGENT01";
		String status = "Setuju";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(cust);
		allPage.clickAgent(agen);
		allPage.clickStatus(status);
		delay(1);
		allPage.clickSearchDataAll();
		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath("(//tr)[43]"));
		boolean check = false;
		for (WebElement webElement : lstElement) {
			if (webElement.getText().contains(cust) && webElement.getText().contains(agen) && webElement.getText().contains(status)) {
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
	}

	@Test(priority = 10)
	public void test_all_export_data() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll("kopi");
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickExportDataAll();
		delay(4);
		String downloadPath = "C:\\Users\\nexsoft\\Downloads";
		File getLatestFile = getLatestFilefromDir(downloadPath);
		String fileName = getLatestFile.getName();
		assertTrue(fileName.contains("exportall"), "Data tidak ada/tidak sesuai");
		delay(1);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
	}
	
	@Test(priority = 11)
	public void testAll_clickTable_gotoActivity() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.clickLastPagination();
		delay(1);
		allPage.clickFirstPagination();
		delay(1);
		allPage.clickPage1();
		delay(1);
		allPage.clickPage2();
		delay(1);
		allPage.clickPage3();
		delay(1);
		allPage.clickPage4();
		delay(1);
		allPage.clickPage5();
		delay(1);
		allPage.clickPage6();
		delay(1);
		allPage.clickFirstPagination();
		delay(1);
		allPage.viewTable(10);
		delay(1);
		allPage.viewTable(25);
		delay(1);
		allPage.viewTable(50);
		delay(1);
		allPage.viewTable(100);
		delay(1);
		allPage.viewTable(500);
		delay(3);
		allPage.setSearchAll("kopi");
		delay(1);
		allPage.clickSearchDataAll();
		delay(3);
		allPage.clickTopTable();
		delay(1);
		System.out.println(allPage.getTextDataAllActivity());
		assertEquals(allPage.getTextDataAllActivity(),"Data Detail");
		delay(2);
		allPage.closeDataAllActivity();
		delay(1);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
		delay(2);
	}
	
	@Test(priority = 11)
	public void test_all_search_clickGreen() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String cust = "Cookies";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(cust);
		delay(1);
		allPage.clickGreenSearchAll();
		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath("(//tr)[43]"));
		boolean check = false;
		for (WebElement webElement : lstElement) {
			if (webElement.getText().contains(cust) ) {
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
	}
	
	@AfterTest
	public void close() {
		File file = new File("C:\\Users\\nexsoft\\Downloads\\exportall.xls");
		file.delete();
		driver.close();
	}
}
