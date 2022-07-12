package com.telemarket.task.test.agn;

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

import com.telemarket.task.pom.agent.AGN_LoginPage;
import com.telemarket.task.pom.agent.AGN_MainPage;
import com.telemarket.task.pom.agent.AGN_TaskDataAllPage;
import com.telemarket.task.pom.agent.AGN_TaskFinalPage;

public class AGN_TestDataAll {
	
	protected WebDriver driver;
	protected AGN_LoginPage loginPage;
	protected AGN_MainPage mainPage;
	protected AGN_TaskDataAllPage allPage;

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
	
	public boolean verifyDataInTable(String xpath, String data) {
		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath(xpath));
		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String isiElement = webElement.getText();
			System.out.println(isiElement);
			if (isiElement.contains(data)) {
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
	
	public boolean verifyDataInTable(String xpath, String data, String data2) {
		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath(xpath));
		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String isiElement = webElement.getText();
			System.out.println(isiElement);
			if (isiElement.contains(data) && isiElement.contains(data2)) {
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
	
	@BeforeTest
	public void init() {
		System.setProperty("url", "https://sqa.peluangkerjaku.com/tele/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		loginPage = new AGN_LoginPage(driver);
		mainPage = new AGN_MainPage(driver);
		allPage = new AGN_TaskDataAllPage(driver);
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
		Object[] myData = { "Milan", "123", "warung1240" };
		return myData;
	}

	@Test(priority = 1, dataProvider = "validData")
	public void test_all_search_valid(String in) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(2);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		assertEquals(allPage.getTextDataAll(),"DATA ALL");
		delay(1);
		allPage.setSearchAll(in);
		delay(1);
		allPage.clickSearchDataAll();
		delay(2);
		verifyDataInTable("(//tr)[28]", in);
		delay(2);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
		delay(2);
	}
	
	@DataProvider(name = "unusualData")
	public Object[] unusualData() {
		Object[] myData = { "", "@", "&" };
		return myData;
	}

	@Test(priority = 2, dataProvider = "unusualData")
	public void test_all_search_empty_and_unusual(String in) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(in);
		delay(1);
		allPage.clickSearchDataAll();
		delay(2);
		verifyDataInTable("(//tr)[28]", in);
		delay(2);
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
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(in);
		delay(1);
		allPage.clickSearchDataAll();
		delay(3);
		verifyDataInTable("(//tr)[28]", in);
		delay(2);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
	}
	
	@Test(priority = 4)
	public void test_all_search_agent() {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		String agen = "AGENT01";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
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
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		String status = "Berhasil";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
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
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		String cust = "Kopi";
		String agen = "AGENT01";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
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
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		String cust = "Kopi";
		String status = "Berhasil";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
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
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		String agen = "AGENT01";
		String status = "Berhasil";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
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
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		String cust = "Cookies";
		String agen = "AGENT01";
		String status = "Setuju";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
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
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
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
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
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
	
	@Test(priority = 12)
	public void test_all_search_clickGreen() {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		String cust = "Cookies";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
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
	
	@Test(priority = 13)
	public void testDataAllActivity_phoneSelect_phoneAddCancel() {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll("makanan4160");
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		driver.findElement(By.xpath("//option[@value='0895330144928']")).click(); //berubah tergantung data
		delay(1);
		allPage.clickAddPhone();
		delay(1);
		allPage.setTextMultiAddPhone("0811");
		delay(1);
		allPage.clickCloseMultiAddPhone();
		delay(1);
		allPage.closeDataAllActivity();
		delay(1);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
		delay(2);
	}

	@Test(priority = 14)
	public void testDataAllActivity_phoneSelect_phoneAdd_valid() {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll("makanan4160");
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		driver.findElement(By.xpath("//option[@value='0895330144928']")).click(); //berubah tergantung data
		delay(1);
		allPage.clickAddPhone();
		delay(1);
		allPage.setTextMultiAddPhone("082112345678");
		delay(1);
		allPage.btnSaveMultiAddPhone.click();
		delay(1);
		assertEquals(allPage.getTextKonfirmasi(), "Konfirmasi");
		delay(1);
		allPage.clickSaveKonfirmasi();
		delay(2);
		allPage.closeDataAllActivity();
		delay(1);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
		delay(2);
	}

	@DataProvider(name = "phoneData")
	public Object[] phoneData() {
		Object[] myData = { "0821", "0821123456789011" };
		return myData;
	}

	@Test(priority = 15, dataProvider = "phoneData")
	public void testDataAllActivity_phoneSelect_phoneAdd_invalid(String in) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll("MULIA ABADI");
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickAddPhone();
		delay(1);
		allPage.setTextMultiAddPhone(in);
		delay(1);
		allPage.btnSaveMultiAddPhone.click();
		delay(2);
		assertEquals(allPage.getTextKonfirmasi(), "Konfirmasi");
		delay(1);
		boolean cek = true;
		int length = in.length();
		if (length != 12) {
			cek = false;
		}
		assertFalse(cek, "Ukuran data tidak sesuai");
		delay(1);
		allPage.clickSaveKonfirmasi();
		delay(2);
		allPage.closeDataAllActivity();
		delay(1);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
	}

	@DataProvider(name = "phoneCharData")
	public Object[] phoneCharData() {
		Object[] myData = { "aabb", "@#$%" };
		return myData;
	}

	@Test(priority = 16, dataProvider = "phoneCharData", enabled = false)
	public void testDataAllActivity_phoneSelect_phoneAdd_invalidChar(String in) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll("MULIA ABADI");
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		driver.findElement(By.xpath("//option[@value='0226077564']")).click(); //berubah tergantung data
		delay(1);
		allPage.clickAddPhone();
		delay(1);
		allPage.setTextMultiAddPhone(in);
		delay(1);
		assertEquals(allPage.txtMultiAddPhone.getText(), in, "Data tidak sesuai!");
		allPage.btnSaveMultiAddPhone.click();
		delay(1);
		assertEquals(allPage.getTextKonfirmasi(), "Data Berhasil Diajukan!");
		boolean cek = true;
		int length = in.length();
		if (length != 12) {
			cek = false;
		}
		assertFalse(cek, "Ukuran data tidak sesuai");
		delay(1);
		allPage.clickSaveKonfirmasi();
		delay(2);
		allPage.closeDataAllActivity();
		delay(1);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
	}

	@DataProvider(name = "WAData")
	public Object[][] WAData() {
		Object[][] myData = { { "", "" }, { "", "ini tanpa nomor" }, { "082121212121", "ini pesan wa" },
				{ "082121212121", "" }, { "0821", "ini empat angka" }, { "0821", "" },
				{ "0812345678901213", "ini enam belas" }, { "0812345678901213", "" } };
		return myData;
	}

	@Test(priority = 17, dataProvider = "WAData")
	public void testDataAllActivity_sendWA_validPhone_validMsg(String phone, String msg) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll("MULIA ABADI");
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.inputDataWA(phone, msg);
		delay(3);
		allPage.closeDataAllActivity();
		delay(1);
		allPage.clickMessageWA();
		delay(1);
		allPage.clickWA();
		delay(2);
		// assert
		assertEquals(allPage.getTextMessageWA(), msg);
		assertEquals(allPage.getTextPhoneWA(), phone);
		delay(3);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
		delay(2);
	}

	@DataProvider(name = "statusAct")
	public Object[][] statusAct() {
		Object[][] myData = { 
				{ "kopi", "Call", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" },
				{ "kopi", "Whatsapp", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" } 
				
		};
		return myData;
	}

	@Test(priority = 18, dataProvider = "statusAct")
	public void testDataAllActivity_status_valid(String nama, String channel, String status, String statusCall, String statusResult,
			String reason) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(2);
		allPage.clickSubmit();
		delay(1);
		assertEquals(allPage.getTextPemberitahuan(), "Apakah Anda Yakin?");
		delay(2);
		allPage.clickClosePemberitahuan();
//		allPage.clickNOPemberitahuan();
		delay(1);
		allPage.closeDataAllActivity();
		delay(1);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
	}

	@DataProvider(name = "statusAgree")
	public Object[][] statusAgree() {
		Object[][] myData = { 
				{ "Dakota Club", "Call", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" },
				{ "Dakota Club", "Whatsapp", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" },
				{ "kopi", "Call", "Tersambung", "Diangkat", "Setuju", "Follow Up Download" },
				{ "kopi", "Whatsapp", "Tersambung", "Diangkat", "Setuju", "Follow Up Download" } 
				};
		return myData;
	}

	@Test(priority = 19, dataProvider = "statusAgree")
	public void testDataAllActivity_status_saveAgree(String nama, String channel, String status, String statusCall, String statusResult,
			String reason) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(1);
		allPage.clickSubmit();
		delay(3);
		allPage.clickYESPemberitahuan();
		delay(3);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickStatus(reason);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		verifyDataInTable("(//tr)[43]",nama,reason);
		delay(3);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
		delay(2);
	}
	
	@DataProvider(name = "statusFollowUp")
	public Object[][] statusFollowUp() {
		Object[][] myData = { 
				{"Dakota Club","Call","Tersambung","Diangkat","Follow Up","Telpon Kembali Lain Waktu" },
				{"Dakota Club","Call","Tersambung","Diangkat","Follow Up","Request Kirim Whatsapp Untuk Dipelajari"},
				{"Dakota Club","Call","Tersambung","Diangkat","Follow Up","Minta Nomer Manager/Pemilik"},
				{"Dakota Club","Call","Tersambung","Diangkat","Follow Up","Minta Pendapat Partner/Pasangan/Orangtua"},
				{"Dakota Club","Call","Tersambung","Diangkat","Follow Up","Follow Up"},
				{"Dakota Club","Call","Tersambung","Diangkat","Follow Up","Follow Convert"},
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Follow Up","Telpon Kembali Lain Waktu" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Follow Up","Request Kirim Whatsapp Untuk Dipelajari"},
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Follow Up","Minta Nomer Manager/Pemilik"},
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Follow Up","Minta Pendapat Partner/Pasangan/Orangtua"},
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Follow Up","Follow Up"},
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Follow Up","Follow Convert"}
		};
		return myData;
	}

	@Test(priority = 20, dataProvider = "statusFollowUp")
	public void testDataAllActivity_status_saveFollowUp(String nama,String channel, String status, String statusCall,
			String statusResult, String reason) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(3);
//		allPage.closeDataAllActivity();
//		delay(2);
		allPage.clickSubmit();
		delay(1);
		allPage.clickYESPemberitahuan();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		verifyDataInTable("(//tr)[43]", nama, statusResult);
		delay(6);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
		delay(2);
	}
	
	@DataProvider(name = "statusTolak")
	public Object[][] statusTolak() {
		Object[][] myData = { 
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Tidak Bersedia Memberikan Kontak Owner" },
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Tidak Fokus Online" },
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Tidak Tertarik, Tidak Memberi Alasan" },
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Tidak Mengerti dan Tidak Bersedia Dijelaskan" },
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Tidak Mengenal Tokko/Bukukas" },
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Rating/Comment Buruk Tokko di Sosial Media" },
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Tidak Mau Dipersulit Menggunakan Tokko" },
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Terlalu Banyak Aplikasi atau Platform" },
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Memory Handphone Penuh" },
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Tidak Punya Android" },
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Lebih Nyaman Dengan Platform Selain Tokko" },
				{"Dakota Club","Call","Tersambung","Diangkat","Tolak","Usaha Sudah Tutup/Bangkrut" },
		};
		return myData;
	}

	@Test(priority = 21, dataProvider = "statusTolak")
	public void testDataAllActivity_status_saveTolak(String nama, String channel, String status, String statusCall,
			String statusResult, String reason) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(3);
//		allPage.closeDataAllActivity();
//		delay(2);
		allPage.clickSubmit();
		delay(1);
		allPage.clickYESPemberitahuan();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickStatus(statusResult);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		verifyDataInTable("(//tr)[43]", nama, statusResult);
		delay(10);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
		delay(2);
	}
	
	@DataProvider(name = "statusTolakWA")
	public Object[][] statusTolakWA() {
		Object[][] myData = { 
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Tidak Bersedia Memberikan Kontak Owner" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Tidak Fokus Online" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Tidak Tertarik, Tidak Memberi Alasan" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Tidak Mengerti dan Tidak Bersedia Dijelaskan" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Tidak Mengenal Tokko/Bukukas" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Rating/Comment Buruk Tokko di Sosial Media" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Tidak Mau Dipersulit Menggunakan Tokko" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Terlalu Banyak Aplikasi atau Platform" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Memory Handphone Penuh" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Tidak Punya Android" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Lebih Nyaman Dengan Platform Selain Tokko" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Tolak","Usaha Sudah Tutup/Bangkrut" },
		};
		return myData;
	}

	@Test(priority = 22, dataProvider = "statusTolakWA")
	public void testDataAllActivity_status_saveTolak_whatsapp(String nama, String channel, String status, String statusCall,
			String statusResult, String reason) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(3);
//		allPage.closeDataAllActivity();
//		delay(2);
		allPage.clickSubmit();
		delay(1);
		allPage.clickYESPemberitahuan();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickStatus(statusResult);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		verifyDataInTable("(//tr)[43]", nama, statusResult);
		delay(10);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
		delay(2);
	}
	
	@Test(priority = 23)
	public void testDataAllActivity_status_resultBerhasil_reasonBerhasil() {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		String nama = "tokogitardotid";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickStatus("Call","Tersambung","Diangkat","Berhasil","Berhasil");
		delay(1);
		allPage.clickSubmit();
		delay(1);
		allPage.clickYESPemberitahuan();
		delay(1);
		AGN_TaskFinalPage finalPage = allPage.clickTaskFinal();
		delay(1);
		finalPage.setSearchFinal(nama);
		delay(1);
		finalPage.clickSearchFinal();
		delay(1);
		verifyDataInTable("(//tr)[40]", nama, "Berhasil");
		delay(6);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
		delay(2);
	}
	
	@Test(priority = 24)
	public void testDataAllActivity_statusWA_resultBerhasil_reasonBerhasil() {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		String nama = "tokogitardotid";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickStatus("Whatsapp","Tersambung","Diangkat","Berhasil","Berhasil");
		delay(1);
		allPage.clickSubmit();
		delay(1);
		allPage.clickYESPemberitahuan();
		delay(1);
		AGN_TaskFinalPage finalPage = allPage.clickTaskFinal();
		delay(1);
		finalPage.setSearchFinal(nama);
		delay(1);
		finalPage.clickSearchFinal();
		delay(1);
		verifyDataInTable("(//tr)[40]", nama, "Berhasil");
		delay(6);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
		delay(2);
	}
	
	@DataProvider(name = "statusInvalid")
	public Object[][] statusInvalid() {
		Object[][] myData = { 
				{"Ragawi","Call","Tersambung","Diangkat","Tidak Berhasil","Tidak Berhasil" },
				{"Grand Am","Call","Tersambung","Salah Sambung","Salah Sambung","Salah Sambung" },
				{"Grand Am","Call","Tersambung","Tidak Diangkat","Tidak Diangkat","Tidak Diangkat" },
				{"Grand Am","Call","Tidak Tersambung","Nomer Salah","Nomer Salah","Nomer Salah" },
				{"Grand Am","Call","Tidak Tersambung","Mailbox","Mailbox","Mailbox" },
				{"Grand Am","Call","Tidak Tersambung","Invalid Number","Tidak Ada Nomor Telepon","Tidak Ada Nomor Telepon" },
				{"Grand Am","Call","Tidak Tersambung","Telepon Not Register","Tidak Terdaftar","Tidak Terdaftar" }
		};
		return myData;
	}
	
	@Test(priority = 25, dataProvider="statusInvalid")
	public void testDataAllActivity_status_invalid(String nama,String channel, String status, String statusCall,
			String statusResult, String reason) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickStatus(channel,status,statusCall,statusResult,reason);
		delay(1);
//		allPage.closeDataAllActivity();
//		delay(2);
		allPage.clickSubmit();
		delay(1);
		allPage.clickYESPemberitahuan();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickStatus(reason);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		verifyDataInTable("(//tr)[43]", nama, reason);
		delay(5);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
		delay(3);
	}
	
	@DataProvider(name = "statusInvalidWA")
	public Object[][] statusInvalidWA() {
		Object[][] myData = { 
				{"Grand Am","Whatsapp","Tersambung","Diangkat","Tidak Berhasil","Tidak Berhasil" },
				{"Grand Am","Whatsapp","Tersambung","Salah Sambung","Salah Sambung","Salah Sambung" },
				{"Grand Am","Whatsapp","Tersambung","Tidak Diangkat","Tidak Diangkat","Tidak Diangkat" },
				{"Grand Am","Whatsapp","Tidak Tersambung","Nomer Salah","Nomer Salah","Nomer Salah" },
				{"Grand Am","Whatsapp","Tidak Tersambung","Mailbox","Mailbox","Mailbox" },
				{"Grand Am","Whatsapp","Tidak Tersambung","Invalid Number","Tidak Ada Nomor Telepon","Tidak Ada Nomor Telepon" },
				{"hei.boo","Whatsapp","Tidak Tersambung","Telepon Not Register","Tidak Terdaftar","Tidak Terdaftar" }
		};
		return myData;
	}
	
	@Test(priority = 26, dataProvider="statusInvalidWA")
	public void testDataAllActivity_statusWA_invalid(String nama,String channel, String status, String statusCall,
			String statusResult, String reason) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickStatus(channel,status,statusCall,statusResult,reason);
		delay(1);
//		allPage.closeDataAllActivity();
//		delay(2);
		allPage.clickSubmit();
		delay(1);
		allPage.clickYESPemberitahuan();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickStatus(reason);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		verifyDataInTable("(//tr)[43]", nama, reason);
		delay(5);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
		delay(3);
	}
	
	@DataProvider(name = "statusEmpty")
	public Object[][] statusEmpty() {
		Object[][] myData = { 
				{"Dakota Club","Call","Tersambung","Diangkat","","" },
				{"Dakota Club","Call","Tersambung","","","" },
				{"Dakota Club","Call","","","","" },
				{"Dakota Club","Call","Tersambung","Diangkat","Setuju","" }
		};
		return myData;
	}
	
	@Test(priority = 27, dataProvider="statusEmpty")
	public void testDataAllActivity_status_empty(String nama,String channel, String status, String statusCall,
			String statusResult, String reason) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickStatus(channel,status,statusCall,statusResult,reason);
		delay(1);
		allPage.clickSubmit();
		delay(1);
		assertEquals(allPage.getTextPemberitahuanGagal(), "Status Result Wajib Diisi !");
		delay(3);
		allPage.clickClosePemberitahuanGagal();
		delay(1);
		allPage.closeDataAllActivity();
		delay(1);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
		delay(2);
	}
	
	@DataProvider(name = "statusEmptyWA")
	public Object[][] statusEmptyWA() {
		Object[][] myData = { 
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","","" },
				{"Dakota Club","Whatsapp","Tersambung","","","" },
				{"Dakota Club","Whatsapp","","","","" },
				{"Dakota Club","Whatsapp","Tersambung","Diangkat","Setuju","" }
		};
		return myData;
	}
	
	@Test(priority = 28, dataProvider="statusEmptyWA")
	public void testDataAllActivity_statusWA_empty(String nama,String channel, String status, String statusCall,
			String statusResult, String reason) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		allPage.clickTopTable();
		delay(1);
		allPage.clickStatus(channel,status,statusCall,statusResult,reason);
		delay(1);
		allPage.clickSubmit();
		delay(1);
		assertEquals(allPage.getTextPemberitahuanGagal(), "Status Result Wajib Diisi !");
		delay(3);
		allPage.clickClosePemberitahuanGagal();
		delay(1);
		allPage.closeDataAllActivity();
		delay(1);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
		delay(2);
	}
	
	@AfterTest
	public void close() {
		File file = new File("C:\\Users\\nexsoft\\Downloads\\exportall.xls");
		file.delete();
		driver.close();
	}
}
