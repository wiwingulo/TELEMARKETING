package com.telemarket.task.test.agn;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
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
import com.telemarket.task.pom.TaskDataAllPage;
import com.telemarket.task.pom.TaskFinalPage;
import com.telemarket.task.pom.TaskNewPage;
import com.telemarket.task.pom.agent.AGN_LoginPage;
import com.telemarket.task.pom.agent.AGN_MainPage;
import com.telemarket.task.pom.agent.AGN_TaskAgreePage;
import com.telemarket.task.pom.agent.AGN_TaskDataAllPage;
import com.telemarket.task.pom.agent.AGN_TaskFinalPage;
import com.telemarket.task.pom.agent.AGN_TaskFollowUpPage;
import com.telemarket.task.pom.agent.AGN_TaskNewPage;


public class AGN_TestTaskNew {
	
	protected WebDriver driver;
	protected AGN_LoginPage loginPage;
	protected AGN_MainPage mainPage;
	protected AGN_TaskNewPage newPage;
	protected AGN_TaskDataAllPage allPage;
	
	protected LoginPage login2Page;
	protected MainPage main2Page;
	protected TaskNewPage new2Page;

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
		newPage = new AGN_TaskNewPage(driver);
		allPage = new AGN_TaskDataAllPage(driver);
		login2Page = new LoginPage(driver);
		main2Page = new MainPage(driver);
		new2Page = new TaskNewPage(driver);
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
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(in);
		delay(1);
		verifyDataInTable("(//tr)[26]", in);
		delay(1);
		newPage.clickBtnLogoutAtMain();
		delay(1);
		newPage.logout();
		delay(2);
	}
	
	@DataProvider(name = "unusualData")
	public Object[] unusualData() {
		Object[] myData = { "", "@", "&" };
		return myData;
	}

	@Test(priority = 2, dataProvider = "unusualData")
	public void test_new_search_empty_and_unusual(String in) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(in);
		delay(1);
		verifyDataInTable("(//tr)[26]", in);
		delay(2);
		newPage.clickBtnLogoutAtMain();
		delay(1);
		newPage.logout();
		delay(2);
	}

	@Test(priority = 3)
	public void test_clickTable_gotoActivity() {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskNewPage newPage = mainPage.clickDataNew();
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
		delay(2);
		newPage.viewTable(500);
		delay(3);
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

	@Test(priority = 4)
	public void test_newActivity_phoneSelect_phoneAddCancel() {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew("minum");
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

	@Test(priority = 5)
	public void test_newActivity_phoneSelect_phoneAdd_valid() {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew("minum");
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
		assertEquals(newPage.getTextKonfirmasi(), "Konfirmasi");
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

	@Test(priority = 6, dataProvider = "phoneData")
	public void test_newActivity_phoneSelect_phoneAdd_invalid(String in) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew("minum");
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.btnAddPhone.click();
		delay(1);
		newPage.setTextMultiAddPhone(in);
		delay(1);
		newPage.btnSaveMultiAddPhone.click();
		delay(2);
		assertEquals(newPage.txtDataKonfirmasi.getText(), "Konfirmasi");
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

	@Test(priority = 7, dataProvider = "phoneCharData", enabled = false)
	public void test_newActivity_phoneSelect_phoneAdd_invalidChar(String in) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskNewPage newPage = mainPage.clickDataNew();
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
		assertEquals(newPage.getTextKonfirmasi(), "Konfirmasi");
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

	@Test(priority = 8, dataProvider = "WAData")
	public void testNewActivity_sendWA_validPhone_validMsg(String phone, String msg) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew("Yopi Kopi");
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.inputDataWA(phone, msg);
		delay(1);
		newPage.clickCloseActivityNew();
		delay(1);
		newPage.clickBtnLogoutAtMain();
		delay(1);
		newPage.logout();
		delay(2);
		LoginPage login2Page = PageFactory.initElements(driver, LoginPage.class);
		MainPage main2Page = login2Page.loginToMainPage();
		delay(1);
		main2Page.clickOKPopUpAfterLogin();
		delay(1);
		main2Page.clickTask();
		delay(1);
		TaskNewPage new2Page = main2Page.clickDataNew();
		delay(1);
		new2Page.clickBtnWA();
		delay(1);
		new2Page.clickBtnMessageWA();
		delay(1);
		new2Page.topTableWA();
		// assert
		assertEquals(new2Page.getTextMessageWA(), msg);
		assertEquals(new2Page.getTextPhoneWA(), phone);
		delay(1);
		new2Page.clickBtnLogoutAtMain();
		delay(1);
		new2Page.logout();
		delay(1);
	}

	@DataProvider(name = "statusAct")
	public Object[][] statusAct() {
		Object[][] myData = { { "Call", "Tersambung", "Diangkat", "Setuju", "Berhasil Download" } };
		return myData;
	}

	@Test(priority = 9, dataProvider = "statusAct")
	public void testNewActivity_status_valid(String channel, String status, String statusCall, String statusResult,
			String reason) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew("Tempo");
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
//				{ "Call", "Tersambung", "Diangkat", "Setuju", "Follow Up Download" } 
				};
		return myData;
	}

	@Test(priority = 10, dataProvider = "statusAgree")
	public void testNewActivity_status_saveAgree(String channel, String status, String statusCall, String statusResult,
			String reason) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		String nama = "naurashop";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskNewPage newPage = mainPage.clickDataNew();
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
		AGN_TaskAgreePage agreePage = newPage.clickDataAgree();
		delay(1);
		agreePage.searchDataAgree(nama);
		delay(1);
		List<WebElement> lstElement = driver.findElements(By.xpath("(//tr)[26]"));
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
//				{"Call","Tersambung","Diangkat","Follow Up","Request Kirim Whatsapp Untuk Dipelajari"},
//				{"Call","Tersambung","Diangkat","Follow Up","Minta Nomer Manager/Pemilik"},
//				{"Call","Tersambung","Diangkat","Follow Up","Minta Pendapat Partner/Pasangan/Orangtua"},
//				{"Call","Tersambung","Diangkat","Follow Up","Follow Up"},
//				{"Call","Tersambung","Diangkat","Follow Up","Follow Convert"}
		};
		return myData;
	}

	@Test(priority = 11, dataProvider = "statusFollowUp")
	public void testNewActivity_status_saveFollowUp(String channel, String status, String statusCall,
			String statusResult, String reason) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		String nama = "Lumina";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskNewPage newPage = mainPage.clickDataNew();
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
		AGN_TaskFollowUpPage followUpPage = newPage.clickDataFollowUp();
		delay(1);
		followUpPage.searchDataFollowUp(nama);
		delay(1);
		verifyDataInTable("(//tr)[26]", nama);
		delay(10);
		newPage.clickBtnLogoutAtMain();
		delay(1);
		newPage.logout();
		delay(2);
	}
	
	@DataProvider(name = "statusFollowUpWA")
	public Object[][] statusFollowUpWA() {
		Object[][] myData = { 
				{"Whatsapp","Tersambung","Diangkat","Follow Up","Telpon Kembali Lain Waktu" },
//				{"Whatsapp","Tersambung","Diangkat","Follow Up","Request Kirim Whatsapp Untuk Dipelajari"},
//				{"Whatsapp","Tersambung","Diangkat","Follow Up","Minta Nomer Manager/Pemilik"},
//				{"Whatsapp","Tersambung","Diangkat","Follow Up","Minta Pendapat Partner/Pasangan/Orangtua"},
//				{"Whatsapp","Tersambung","Diangkat","Follow Up","Follow Up"},
//				{"Whatsapp","Tersambung","Diangkat","Follow Up","Follow Convert"}
		};
		return myData;
	}
	
	@Test(priority = 12, dataProvider = "statusFollowUpWA")
	public void testNewActivity_status_saveFollowUp_whatsapp(String channel, String status, String statusCall,
			String statusResult, String reason) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		String nama = "Lumina";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskNewPage newPage = mainPage.clickDataNew();
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
		AGN_TaskFollowUpPage followUpPage = newPage.clickDataFollowUp();
		delay(1);
		followUpPage.searchDataFollowUp(nama);
		delay(1);
		verifyDataInTable("(//tr)[26]", nama);
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
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		String nama = "Lumina";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskNewPage newPage = mainPage.clickDataNew();
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
		AGN_TaskDataAllPage allPage = newPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
//		verifyDataInTable("(//tr)[28]", nama, statusResult);
		verifyDataInTable("(//tr)[28]", nama);
		delay(10);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
		delay(2);
	}
	
	@DataProvider(name = "statusTolakWA")
	public Object[][] statusTolakWA() {
		Object[][] myData = { 
				{"Whatsapp","Tersambung","Diangkat","Tolak","Tidak Bersedia Memberikan Kontak Owner" },
//				{"Whatsapp","Tersambung","Diangkat","Tolak","Tidak Fokus Online" },
//				{"Whatsapp","Tersambung","Diangkat","Tolak","Tidak Tertarik, Tidak Memberi Alasan" },
//				{"Whatsapp","Tersambung","Diangkat","Tolak","Tidak Mengerti dan Tidak Bersedia Dijelaskan" },
//				{"Whatsapp","Tersambung","Diangkat","Tolak","Tidak Mengenal Tokko/Bukukas" },
//				{"Whatsapp","Tersambung","Diangkat","Tolak","Rating/Comment Buruk Tokko di Sosial Media" },
//				{"Whatsapp","Tersambung","Diangkat","Tolak","Tidak Mau Dipersulit Menggunakan Tokko" },
//				{"Whatsapp","Tersambung","Diangkat","Tolak","Terlalu Banyak Aplikasi atau Platform" },
//				{"Whatsapp","Tersambung","Diangkat","Tolak","Memory Handphone Penuh" },
//				{"Whatsapp","Tersambung","Diangkat","Tolak","Tidak Punya Android" },
//				{"Whatsapp","Tersambung","Diangkat","Tolak","Lebih Nyaman Dengan Platform Selain Tokko" },
//				{"Whatsapp","Tersambung","Diangkat","Tolak","Usaha Sudah Tutup/Bangkrut" },
		};
		return myData;
	}

	@Test(priority = 14, dataProvider = "statusTolakWA")
	public void testNewActivity_status_saveTolak_whatsapp(String channel, String status, String statusCall,
			String statusResult, String reason) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		String nama = "Lumina";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskNewPage newPage = mainPage.clickDataNew();
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
		AGN_TaskDataAllPage allPage = newPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
//		verifyDataInTable("(//tbody)[25]", nama, statusResult);
		verifyDataInTable("(//tr)[28]", nama);
		delay(10);
		allPage.clickBtnLogoutAtMain();
		delay(1);
		allPage.logout();
		delay(2);
	}
	
	@Test(priority = 15)
	public void testNewActivity_status_resultBerhasil_reasonBerhasil() {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		String nama = "anton_segar_online";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(nama);
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.clickStatus("Call","Tersambung","Diangkat","Berhasil","Berhasil");
		delay(1);
		newPage.clickSubmit();
		delay(1);
		newPage.clickYESPemberitahuan();
		delay(1);
		AGN_TaskAgreePage agreePage = newPage.clickDataAgree();
		delay(1);
		agreePage.searchDataAgree(nama);
		delay(1);
		try {
			verifyDataInTable("(//tr)[26]", nama, "Berhasil");
		} finally {
			delay(10);
			newPage.clickBtnLogoutAtMain();
			delay(1);
			newPage.logout();
			delay(2);
		}
	}
	
	@Test(priority = 16)
	public void testNewActivity_statusWA_resultBerhasil_reasonBerhasil() {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		String nama = "anton_segar_online";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(nama);
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.clickStatus("Whatsapp","Tersambung","Diangkat","Berhasil","Berhasil");
		delay(1);
		newPage.clickSubmit();
		delay(1);
		newPage.clickYESPemberitahuan();
		delay(1);
		AGN_TaskAgreePage agreePage = newPage.clickDataAgree();
		delay(1);
		agreePage.searchDataAgree(nama);
		delay(1);
		try {
			verifyDataInTable("(//tr)[26]", nama, "Berhasil");
		} finally {
			delay(10);
			newPage.clickBtnLogoutAtMain();
			delay(1);
			newPage.logout();
			delay(2);
		}
	}
	
	@DataProvider(name = "statusInvalid")
	public Object[][] statusInvalid() {
		Object[][] myData = { 
				{"Sportvan G20","Call","Tersambung","Diangkat","Tidak Berhasil","Tidak Berhasil" },
				{"Grand Am","Call","Tersambung","Salah Sambung","Salah Sambung","Salah Sambung" },
				{"Grand Am","Call","Tersambung","Tidak Diangkat","Tidak Diangkat","Tidak Diangkat" },
				{"Grand Am","Call","Tidak Tersambung","Nomer Salah","Nomer Salah","Nomer Salah" },
				{"Grand Am","Call","Tidak Tersambung","Mailbox","Mailbox","Mailbox" },
				{"Grand Am","Call","Tidak Tersambung","Invalid Number","Tidak Ada Nomor Telepon","Tidak Ada Nomor Telepon" },
				{"Grand Am","Call","Tidak Tersambung","Telepon Not Register","Tidak Terdaftar","Tidak Terdaftar" }
		};
		return myData;
	}
	
	@Test(priority = 17, dataProvider="statusInvalid")
	public void testNewActivity_status_invalid(String nama,String channel, String status, String statusCall,
			String statusResult, String reason) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(nama);
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.clickStatus(channel,status,statusCall,statusResult,reason);
		delay(1);
		newPage.clickSubmit();
		delay(1);
		newPage.clickYESPemberitahuan();
		delay(1);
		AGN_TaskDataAllPage allPage = newPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickStatus(reason);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		try {
			verifyDataInTable("(//tr)[43]", nama, reason);
		} finally {
			delay(3);
			newPage.clickBtnLogoutAtMain();
			delay(1);
			newPage.logout();
			delay(3);
		}
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
				{"Grand Am","Whatsapp","Tidak Tersambung","Telepon Not Register","Tidak Terdaftar","Tidak Terdaftar" }
		};
		return myData;
	}
	
	@Test(priority = 18, dataProvider="statusInvalidWA")
	public void testNewActivity_statusWA_invalid(String nama,String channel, String status, String statusCall,
			String statusResult, String reason) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(nama);
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.clickStatus(channel,status,statusCall,statusResult,reason);
		delay(1);
		newPage.clickSubmit();
		delay(1);
		newPage.clickYESPemberitahuan();
		delay(1);
		AGN_TaskDataAllPage allPage = newPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickStatus(reason);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		try {
			verifyDataInTable("(//tr)[43]", nama, reason);
		} finally {
			delay(3);
			newPage.clickBtnLogoutAtMain();
			delay(1);
			newPage.logout();
			delay(3);
		}
	}
	
	@DataProvider(name = "statusEmpty")
	public Object[][] statusEmpty() {
		Object[][] myData = { 
				{"HHR","Call","Tersambung","Diangkat","","" },
				{"HHR","Call","Tersambung","","","" },
				{"HHR","Call","","","","" },
				{"HHR","Call","Tersambung","Diangkat","Setuju","" }
		};
		return myData;
	}
	
	@Test(priority = 19, dataProvider="statusEmpty")
	public void testNewActivity_status_empty(String nama,String channel, String status, String statusCall,
			String statusResult, String reason) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(nama);
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.clickStatus(channel,status,statusCall,statusResult,reason);
		delay(1);
		newPage.clickSubmit();
		delay(1);
		try {
			assertEquals(newPage.getTextPemberitahuanGagal(), "Pemberitahuan !");
			delay(3);
		} finally {
			newPage.clickClosePemberitahuanGagal();
			delay(1);
			newPage.clickCloseActivityNew();
			delay(1);
			newPage.clickBtnLogoutAtMain();
			delay(1);
			newPage.logout();
			delay(2);
		}
	}
	
	@DataProvider(name = "statusEmptyWA")
	public Object[][] statusEmptyWA() {
		Object[][] myData = { 
				{"Grand Am","Whatsapp","Tersambung","Diangkat","","" },
				{"Grand Am","Whatsapp","Tersambung","","","" },
				{"Grand Am","Whatsapp","","","","" },
				{"Grand Am","Whatsapp","Tersambung","Diangkat","Setuju","" }
		};
		return myData;
	}
	
	@Test(priority = 20, dataProvider="statusEmptyWA")
	public void testNewActivity_statusWA_empty(String nama,String channel, String status, String statusCall,
			String statusResult, String reason) {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskNewPage newPage = mainPage.clickDataNew();
		delay(1);
		newPage.searchDataNew(nama);
		delay(1);
		newPage.clickTopTable();
		delay(1);
		newPage.clickStatus(channel,status,statusCall,statusResult,reason);
		delay(1);
		newPage.clickSubmit();
		delay(1);
		try {
			assertEquals(newPage.getTextPemberitahuanGagal(), "Pemberitahuan !");
			delay(3);
		} finally {
			newPage.clickClosePemberitahuanGagal();
			delay(1);
			newPage.clickCloseActivityNew();
			delay(1);
			newPage.clickBtnLogoutAtMain();
			delay(1);
			newPage.logout();
			delay(2);
		}
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
}
