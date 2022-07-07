package com.telemarket.task.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
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
import com.telemarket.task.pom.TaskNewPage;

public class TLMKT_TestTaskNew {
	
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected MainPage mainPage;
	
	protected TaskNewPage newPage;

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
		newPage = new TaskNewPage(driver);
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
		Object[] myData = { "Passat", "1", "Toko_Adil_3" };
		return myData;
	}

	@Test(priority = 1, dataProvider = "validData")
	public void test_new_search_valid(String in) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(in);
		delay(1);
		List<WebElement> lstElement = driver.findElements(By.xpath("(//tr)[41]"));
		String expectedChar = in;
		boolean check = false;
		for (WebElement webElement : lstElement) {
			if (webElement.getText().contains(expectedChar)) {
				check = true;
				delay(2);
				break;
			}
		}
		assertTrue(check);
		delay(1);
		mainPage.clickBtnLogoutAtMain();
		delay(1);
		newPage.logout();
	}

	@DataProvider(name = "unusualData")
	public Object[] unusualData() {
		Object[] myData = { "", "@", "&" };
		return myData;
	}

	@Test(priority = 2, dataProvider = "unusualData")
	public void test_new_search_empty_and_unusual(String in) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(in);
		delay(1);
		List<WebElement> lstElement = driver.findElements(By.xpath("(//tr)[41]"));
		String expectedChar = in;
		boolean check = false;
		for (WebElement webElement : lstElement) {
			if (webElement.getText().contains(expectedChar)) {
				check = true;
				delay(2);
				break;
			}
		}
		assertTrue(check);
		delay(1);
		mainPage.clickBtnLogoutAtMain();
		delay(1);
		newPage.logout();
	}

	@Test(priority = 3)
	public void test_new_export_data() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.clickExportNew();
		delay(3);
		String downloadPath = "C:\\Users\\nexsoft\\Downloads";
		File getLatestFile = getLatestFilefromDir(downloadPath);
		String fileName = getLatestFile.getName();
		assertTrue(fileName.contains("exportnew"), "Data tidak ada/tidak sesuai");
		delay(3);
		mainPage.clickBtnLogoutAtMain();
		delay(1);
		newPage.logout();
	}
	
	@Test(priority = 4)
	public void test_clickTable_gotoActivity() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.clickLastPagination();
		delay(1);
		newPage.clickFirstPagination();
		delay(1);
		newPage.clickPage1();
		delay(1);
		newPage.clickPage2();
		delay(1);
		newPage.clickPage3();
		delay(1);
		newPage.clickPage4();
		delay(1);
		newPage.clickPage5();
		delay(1);
		newPage.clickPage6();
		delay(1);
		newPage.clickFirstPagination();
		delay(1);
		newPage.viewTable(10);
		delay(1);
		newPage.viewTable(25);
		delay(1);
		newPage.viewTable(50);
		delay(1);
		newPage.viewTable(100);
		delay(1);
		newPage.viewTable(500);
		delay(2);
		newPage.searchDataNew("lumina");
		delay(1);
		newPage.clickTopTable();
		delay(1);
		System.out.println(newPage.getTextNewActivity());
		assertEquals(newPage.getTextNewActivity(),"Data Detail");
		delay(2);
		newPage.btnCloseNewActivity.click();
		delay(1);
		newPage.clickBtnLogoutAtMain();
		delay(1);
		newPage.logout();
	}
	
	@Test(priority = 5)
	public void test_newActivity_phoneSelect_phoneAddCancel() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew("abadi");
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.setPhone.click();
		delay(1);
		newPage.btnAddPhone.click();
		delay(1);
		newPage.setTextMultiAddPhone("0811");
		delay(1);
		newPage.clickCloseMultiAddPhone();
		delay(1);
		newPage.btnCloseNewActivity.click();
		delay(1);
		newPage.clickBtnLogoutAtMain();
		delay(1);
		newPage.logout();
		delay(2);
	}
	
	@Test(priority = 6)
	public void test_newActivity_phoneSelect_phoneAdd_valid() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew("abadi");
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.setPhone.click();
		delay(1);
		newPage.btnAddPhone.click();
		delay(1);
		newPage.setTextMultiAddPhone("082112345678");
		delay(1);
		newPage.btnSaveMultiAddPhone.click();
		delay(1);
		assertEquals(newPage.getTextKonfirmasi(),"Data Berhasil Diajukan!");
		delay(1);
//		newPage.btnCloseKonfirmasi.click();
		newPage.btnSaveKonfirmasi.click();
		delay(2);
		newPage.btnCloseNewActivity.click();
		delay(1);
		newPage.clickBtnLogoutAtMain();
		delay(1);
		newPage.logout();
		delay(2);
	}
	
	@DataProvider(name = "phoneData")
	public Object[] phoneData() {
		Object[] myData = { "0821", "0821123456789011"};
		return myData;
	}
	
	@Test(priority = 7,dataProvider="phoneData")
	public void test_newActivity_phoneSelect_phoneAdd_invalid(String in) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew("abadi");
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.btnAddPhone.click();
		delay(1);
		newPage.setTextMultiAddPhone(in);
		delay(1);
		newPage.btnSaveMultiAddPhone.click();
		delay(2);
		assertEquals(newPage.txtDataKonfirmasi.getText(),"Data Berhasil Diajukan!");
		delay(1);
		boolean cek = true;
		int length = in.length();
		if(length != 12) {
			cek = false;
		}
		assertFalse(cek, "Ukuran data tidak sesuai");
		delay(1);
		newPage.btnSaveKonfirmasi.click();
		delay(2);
		newPage.btnCloseNewActivity.click();
		delay(1);
		newPage.clickBtnLogoutAtMain();
		delay(1);
		newPage.logout();
	}
	
	@DataProvider(name = "phoneCharData")
	public Object[] phoneCharData() {
		Object[] myData = { "aabb", "@#$%" };
		return myData;
	}
	
	@Test(priority = 8,dataProvider="phoneCharData",enabled=false)
	public void test_newActivity_phoneSelect_phoneAdd_invalidChar(String in) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew("abadi");
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.setPhone.click();
		delay(1);
		newPage.btnAddPhone.click();
		delay(1);
		newPage.setTextMultiAddPhone(in);
		delay(1);
		assertEquals(newPage.txtMultiAddPhone.getText(), in, "Data tidak sesuai!");
		newPage.btnSaveMultiAddPhone.click();
		delay(1);
		assertEquals(newPage.getTextKonfirmasi(),"Data Berhasil Diajukan!");
		boolean cek = true;
		int length = in.length();
		if(length != 12) {
			cek = false;
		}
		assertFalse(cek, "Ukuran data tidak sesuai");
		delay(1);
		newPage.btnSaveKonfirmasi.click();
		delay(2);
		newPage.btnCloseNewActivity.click();
		delay(1);
		newPage.clickBtnLogoutAtMain();
		delay(1);
		newPage.logout();
	}

	@AfterTest
	public void close() {
		File file = new File("C:\\Users\\nexsoft\\Downloads\\exportnew.xls");
		file.delete();
		driver.close();
	}
}
