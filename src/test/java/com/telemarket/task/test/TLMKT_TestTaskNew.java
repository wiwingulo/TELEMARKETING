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
import com.telemarket.task.pom.TaskAgreePage;
import com.telemarket.task.pom.TaskFinalPage;
import com.telemarket.task.pom.TaskFollowUpPage;
import com.telemarket.task.pom.TaskNewPage;

public class TLMKT_TestTaskNew {

	protected WebDriver driver;
	protected LoginPage loginPage;
	protected MainPage mainPage;

	protected TaskNewPage newPage;

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt * 1000);
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
	

	public boolean verifDataNotArray(String xpathIsi, String refDataSatu, String refDataDua) {
		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		
		for (WebElement webElement : lstElement) {
			String isiElement = webElement.getText();
			System.out.println(isiElement);
			if (isiElement.contains(refDataSatu) && isiElement.contains(refDataDua)) {
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
		assertEquals(newPage.getTextNewActivity(), "Data Detail");
		delay(2);
		newPage.clickCloseActivityNew();
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
		newPage.clickCloseActivityNew();
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
		assertEquals(newPage.getTextKonfirmasi(), "Data Berhasil Diajukan!");
		delay(1);
//		newPage.btnCloseKonfirmasi.click();
		newPage.btnSaveKonfirmasi.click();
		delay(2);
		newPage.clickCloseActivityNew();
		delay(1);
		newPage.clickBtnLogoutAtMain();
		delay(1);
		newPage.logout();
		delay(2);
	}

	@DataProvider(name = "phoneData")
	public Object[] phoneData() {
		Object[] myData = { "0821", "0821123456789011" };
		return myData;
	}

	@Test(priority = 7, dataProvider = "phoneData")
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
		assertEquals(newPage.txtDataKonfirmasi.getText(), "Data Berhasil Diajukan!");
		delay(1);
		boolean cek = true;
		int length = in.length();
		if (length != 12) {
			cek = false;
		}
		assertFalse(cek, "Ukuran data tidak sesuai");
		delay(1);
		newPage.btnSaveKonfirmasi.click();
		delay(2);
		newPage.clickCloseActivityNew();
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

	@Test(priority = 8, dataProvider = "phoneCharData", enabled = false)
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
		assertEquals(newPage.getTextKonfirmasi(), "Data Berhasil Diajukan!");
		boolean cek = true;
		int length = in.length();
		if (length != 12) {
			cek = false;
		}
		assertFalse(cek, "Ukuran data tidak sesuai");
		delay(1);
		newPage.btnSaveKonfirmasi.click();
		delay(2);
		newPage.clickCloseActivityNew();
		delay(1);
		newPage.clickBtnLogoutAtMain();
		delay(1);
		newPage.logout();
	}

	@DataProvider(name = "WAData")
	public Object[][] WAData() {
		Object[][] myData = { { "", "" }, { "", "ini tanpa nomor" }, { "082121212121", "ini pesan wa" },
				{ "082121212121", "" }, { "0821", "ini empat angka" }, { "0821", "" },
				{ "0812345678901213", "ini enam belas" }, { "0812345678901213", "" } };
		return myData;
	}

	@Test(priority = 9, dataProvider = "WAData")
	public void testNewActivity_sendWA_validPhone_validMsg(String phone, String msg) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew("Yopi Kopi");
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.inputDataWA(phone, msg);
		delay(1);
		newPage.clickCloseActivityNew();
		delay(1);
		newPage.clickBtnWA();
		delay(1);
		newPage.clickBtnMessageWA();
		delay(1);
		newPage.topTableWA();
		// assert
		assertEquals(newPage.getTextMessageWA(), msg);
		assertEquals(newPage.getTextPhoneWA(), phone);
		delay(1);
		newPage.clickBtnLogoutAtMain();
		delay(1);
		newPage.logout();
		delay(1);
	}

	@DataProvider(name = "statusAct")
	public Object[][] statusAct() {
		Object[][] myData = { { "Call", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" } };
		return myData;
	}

	@Test(priority = 10, dataProvider = "statusAct")
	public void testNewActivity_status_valid(String channel, String status, String statusCall, String statusResult,
			String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew("makananminuman231");
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(2);
		newPage.clickSubmit();
		delay(1);
		assertEquals(newPage.getTextPemberitahuan(), "Apakah Anda Yakin?");
		delay(2);
//		newPage.clickClosePemberitahuan();
		newPage.clickNOPemberitahuan();
		delay(1);
		newPage.clickCloseActivityNew();
		delay(1);
		newPage.clickBtnLogoutAtMain();
		delay(1);
		newPage.logout();
	}

	@DataProvider(name = "statusAgree")
	public Object[][] statusAgree() {
		Object[][] myData = { { "Call", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" },
				{ "Call", "Tersambung", "Diangkat", "Setuju", "Follow Up Download" } };
		return myData;
	}

	@Test(priority = 11, dataProvider = "statusAgree")
	public void testNewActivity_status_saveAgree(String channel, String status, String statusCall, String statusResult,
			String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String nama = "Dakota Club";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(nama);
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(1);
		newPage.clickSubmit();
		delay(3);
		newPage.clickYESPemberitahuan();
		delay(3);
		TaskAgreePage agreePage = newPage.clickDataAgree();
		delay(1);
		agreePage.searchDataAgree(nama);
		delay(1);
		List<WebElement> lstElement = driver.findElements(By.xpath("(//tr)[41]"));
		boolean check = false;
		for (WebElement webElement : lstElement) {
			if (webElement.getText().contains(nama) && webElement.getText().contains(statusResult)) {
				check = true;
				delay(2);
				break;
			}
		}
		assertTrue(check);
		delay(1);
		newPage.clickBtnLogoutAtMain();
		delay(1);
		newPage.logout();
	}
	
	@DataProvider(name = "statusFollowUp")
	public Object[][] statusFollowUp() {
		Object[][] myData = { 
				{"Call","Tersambung","Diangkat","Follow Up","Telpon Kembali Lain Waktu" },
				{"Call","Tersambung","Diangkat","Follow Up","Request Kirim Whatsapp Untuk Dipelajari"},
				{"Call","Tersambung","Diangkat","Follow Up","Minta Nomer Manager/Pemilik"},
				{"Call","Tersambung","Diangkat","Follow Up","Minta Pendapat Partner/Pasangan/Orangtua"},
				{"Call","Tersambung","Diangkat","Follow Up","Follow Up"},
				{"Call","Tersambung","Diangkat","Follow Up","Follow Convert"}
		};
		return myData;
	}

	@Test(priority = 12, dataProvider = "statusFollowUp")
	public void testNewActivity_status_saveFollowUp(String channel, String status, String statusCall,
			String statusResult, String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String nama = "Dakota Club";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(nama);
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(3);
		newPage.clickSubmit();
		delay(1);
		newPage.clickYESPemberitahuan();
		delay(1);
		TaskFollowUpPage followUpPage = newPage.clickDataFollowUp();
		delay(1);
		followUpPage.searchDataFollowUp(nama);
		delay(1);
		verifDataNotArray("(//tr)[41]", nama, statusResult);
		delay(10);
		newPage.clickBtnLogoutAtMain();
		delay(1);
		newPage.logout();
		delay(2);
	}
	
	@DataProvider(name = "statusTolak")
	public Object[][] statusTolak() {
		Object[][] myData = { 
				{"Call","Tersambung","Diangkat","Tolak","Tidak Bersedia Memberikan Kontak Owner" },
//				{"Call","Tersambung","Diangkat","Tolak","Tidak Fokus Online" },
//				{"Call","Tersambung","Diangkat","Tolak","Tidak Tertarik, Tidak Memberi Alasan" },
//				{"Call","Tersambung","Diangkat","Tolak","Tidak Mengerti dan Tidak Bersedia Dijelaskan" },
//				{"Call","Tersambung","Diangkat","Tolak","Tidak Mengenal Tokko/Bukukas" },
//				{"Call","Tersambung","Diangkat","Tolak","Rating/Comment Buruk Tokko di Sosial Media" },
//				{"Call","Tersambung","Diangkat","Tolak","Tidak Mau Dipersulit Menggunakan Tokko" },
//				{"Call","Tersambung","Diangkat","Tolak","Terlalu Banyak Aplikasi atau Platform" },
//				{"Call","Tersambung","Diangkat","Tolak","Memory Handphone Penuh" },
//				{"Call","Tersambung","Diangkat","Tolak","Tidak Punya Android" },
//				{"Call","Tersambung","Diangkat","Tolak","Lebih Nyaman Dengan Platform Selain Tokko" },
//				{"Call","Tersambung","Diangkat","Tolak","Usaha Sudah Tutup/Bangkrut" },
		};
		return myData;
	}

	@Test(priority = 13, dataProvider = "statusTolak")
	public void testNewActivity_status_saveTolak(String channel, String status, String statusCall,
			String statusResult, String reason) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String nama = "Dakota Club";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(nama);
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(1);
		newPage.clickSubmit();
		delay(1);
		newPage.clickYESPemberitahuan();
		delay(1);
		TaskFinalPage finalPage = newPage.clickTaskFinal();
		delay(1);
		finalPage.setSearchFinal(nama);
		delay(1);
		verifDataNotArray("(//tr)[40]", nama, statusResult);
		delay(10);
		newPage.clickBtnLogoutAtMain();
		delay(1);
		newPage.logout();
		delay(2);
	}

	@AfterTest
	public void close() {
		File file = new File("C:\\Users\\nexsoft\\Downloads\\exportnew.xls");
		file.delete();
		driver.close();
	}
}
