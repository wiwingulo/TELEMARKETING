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
import com.telemarket.task.pom.TaskDataAllPage;
import com.telemarket.task.pom.TaskFollowUpPage;

public class TLMKT_TestTaskFollowUp {
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected MainPage mainPage;
	protected TaskFollowUpPage followUpPage;
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
		loginPage = new LoginPage(driver);
		mainPage = new MainPage(driver);
		followUpPage = new TaskFollowUpPage(driver);
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
		Object[] myData = { "kopi", "1", "somad1" };
		return myData;
	}

	@Test(priority = 1, dataProvider = "validData")
	public void test_followUp_search_valid(String in) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskFollowUpPage followUpPage = mainPage.clickDataFollowUp();
		delay(1);
		assertEquals(followUpPage.getTextFollowUp(),"DATA THINKING");
		delay(1);
		followUpPage.searchDataFollowUp(in);
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
		followUpPage.clickBtnLogoutAtMain();
		delay(1);
		followUpPage.logout();
		delay(2);
	}
	
	@DataProvider(name = "unusualData")
	public Object[] unusualData() {
		Object[] myData = { "", "@", "&", "_" };
		return myData;
	}

	@Test(priority = 2, dataProvider = "unusualData")
	public void test_followUp_search_empty_and_unusual(String in) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskFollowUpPage followUpPage = mainPage.clickDataFollowUp();
		delay(1);
		followUpPage.searchDataFollowUp(in);
		delay(1);
		List<WebElement> lstElement = driver.findElements(By.xpath("(//tbody)[38]"));
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
		followUpPage.clickBtnLogoutAtMain();
		delay(1);
		followUpPage.logout();
		delay(2);
	}

	@Test(priority = 3)
	public void test_followUp_export_data() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskFollowUpPage followUpPage = mainPage.clickDataFollowUp();
		delay(1);
		followUpPage.clickExportFollowUp();
		delay(3);
		String downloadPath = "C:\\Users\\nexsoft\\Downloads";
		File getLatestFile = getLatestFilefromDir(downloadPath);
		String fileName = getLatestFile.getName();
		assertTrue(fileName.contains("exportthinking"), "Data tidak ada/tidak sesuai");
		delay(3);
		followUpPage.clickBtnLogoutAtMain();
		delay(1);
		followUpPage.logout();
		delay(2);
	}
	
	@Test(priority = 4)
	public void testFollowUp_clickTable_gotoActivity() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskFollowUpPage followUpPage = mainPage.clickDataFollowUp();
		delay(1);
		followUpPage.clickLastPagination();
		delay(1);
		followUpPage.clickFirstPagination();
		delay(1);
		followUpPage.clickPage1();
		delay(1);
		followUpPage.clickPage2();
		delay(1);
		followUpPage.clickPage3();
		delay(1);
		followUpPage.clickPage4();
		delay(1);
		followUpPage.clickPage5();
		delay(1);
		followUpPage.clickPage6();
		delay(1);
		followUpPage.clickFirstPagination();
		delay(1);
		followUpPage.viewTable(10);
		delay(1);
		followUpPage.viewTable(25);
		delay(1);
		followUpPage.viewTable(50);
		delay(1);
		followUpPage.viewTable(100);
		delay(1);
		followUpPage.viewTable(500);
		delay(2);
		followUpPage.searchDataFollowUp("kopi");
		delay(3);
		followUpPage.clickTopTable();
		delay(1);
		System.out.println(followUpPage.getTextFollowUpActivity());
		assertEquals(followUpPage.getTextFollowUpActivity(),"Data Detail");
		delay(2);
		followUpPage.closeFollowUpActivity();
		delay(1);
		followUpPage.clickBtnLogoutAtMain();
		delay(1);
		followUpPage.logout();
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
		TaskFollowUpPage followUpPage = mainPage.clickDataFollowUp();
		delay(1);
		followUpPage.searchDataFollowUp("Makanan");
		delay(1);
		followUpPage.clickTopTable();
		delay(1);
		driver.findElement(By.xpath("//option[@value='085335903695']")).click(); //berubah tergantung data
		delay(1);
		followUpPage.clickAddPhone();
		delay(1);
		followUpPage.setTextMultiAddPhone("0811");
		delay(1);
		followUpPage.clickCloseMultiAddPhone();
		delay(1);
		followUpPage.closeFollowUpActivity();
		delay(1);
		followUpPage.clickBtnLogoutAtMain();
		delay(1);
		followUpPage.logout();
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
		TaskFollowUpPage followUpPage = mainPage.clickDataFollowUp();
		delay(1);
		followUpPage.searchDataFollowUp("MULIA ABADI");
		delay(1);
		followUpPage.clickTopTable();
		delay(1);
		driver.findElement(By.xpath("//option[@value='0226077564']")).click(); //berubah tergantung data
		delay(1);
		followUpPage.clickAddPhone();
		delay(1);
		followUpPage.setTextMultiAddPhone("082112345678");
		delay(1);
		followUpPage.btnSaveMultiAddPhone.click();
		delay(1);
		assertEquals(followUpPage.getTextKonfirmasi(), "Konfirmasi");
		delay(1);
//		newPage.btnCloseKonfirmasi.click();
		followUpPage.clickSaveKonfirmasi();
		delay(2);
		followUpPage.closeFollowUpActivity();
		delay(1);
		followUpPage.clickBtnLogoutAtMain();
		delay(1);
		followUpPage.logout();
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
		TaskFollowUpPage followUpPage = mainPage.clickDataFollowUp();
		delay(1);
		followUpPage.searchDataFollowUp("MULIA ABADI");
		delay(1);
		followUpPage.clickTopTable();
		delay(1);
		followUpPage.clickAddPhone();
		delay(1);
		followUpPage.setTextMultiAddPhone(in);
		delay(1);
		followUpPage.btnSaveMultiAddPhone.click();
		delay(2);
		assertEquals(followUpPage.getTextKonfirmasi(), "Konfirmasi");
		delay(1);
		boolean cek = true;
		int length = in.length();
		if (length != 12) {
			cek = false;
		}
		assertFalse(cek, "Ukuran data tidak sesuai");
		delay(1);
		followUpPage.clickSaveKonfirmasi();
		delay(2);
		followUpPage.closeFollowUpActivity();
		delay(1);
		followUpPage.clickBtnLogoutAtMain();
		delay(1);
		followUpPage.logout();
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
		TaskFollowUpPage followUpPage = mainPage.clickDataFollowUp();
		delay(1);
		followUpPage.searchDataFollowUp("MULIA ABADI");
		delay(1);
		followUpPage.clickTopTable();
		delay(1);
		driver.findElement(By.xpath("//option[@value='0226077564']")).click(); //berubah tergantung data
		delay(1);
		followUpPage.clickAddPhone();
		delay(1);
		followUpPage.setTextMultiAddPhone(in);
		delay(1);
		assertEquals(followUpPage.txtMultiAddPhone.getText(), in, "Data tidak sesuai!");
		followUpPage.btnSaveMultiAddPhone.click();
		delay(1);
		assertEquals(followUpPage.getTextKonfirmasi(), "Data Berhasil Diajukan!");
		boolean cek = true;
		int length = in.length();
		if (length != 12) {
			cek = false;
		}
		assertFalse(cek, "Ukuran data tidak sesuai");
		delay(1);
		followUpPage.clickSaveKonfirmasi();
		delay(2);
		followUpPage.closeFollowUpActivity();
		delay(1);
		followUpPage.clickBtnLogoutAtMain();
		delay(1);
		followUpPage.logout();
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
		TaskFollowUpPage followUpPage = mainPage.clickDataFollowUp();
		delay(1);
		followUpPage.searchDataFollowUp("MULIA ABADI");
		delay(1);
		followUpPage.clickTopTable();
		delay(1);
		followUpPage.inputDataWA(phone, msg);
		delay(2);
		followUpPage.closeFollowUpActivity();
		delay(1);
		followUpPage.clickMessageWA();
		delay(1);
		followUpPage.clickWA();
		delay(1);
		// assert
		assertEquals(followUpPage.getTextMessageWA(), msg);
		assertEquals(followUpPage.getTextPhoneWA(), phone);
		delay(2);
		followUpPage.clickBtnLogoutAtMain();
		delay(1);
		followUpPage.logout();
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
		TaskFollowUpPage followUpPage = mainPage.clickDataFollowUp();
		delay(1);
		followUpPage.searchDataFollowUp("obby_kue");
		delay(1);
		followUpPage.clickTopTable();
		delay(1);
		followUpPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(2);
		followUpPage.clickSubmit();
		delay(1);
		assertEquals(followUpPage.getTextPemberitahuan(), "Apakah Anda Yakin?");
		delay(2);
//		followUpPage.clickClosePemberitahuan();
		followUpPage.clickNOPemberitahuan();
		delay(1);
		followUpPage.closeFollowUpActivity();;
		delay(1);
		followUpPage.clickBtnLogoutAtMain();
		delay(1);
		followUpPage.logout();
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
		TaskFollowUpPage followUpPage = mainPage.clickDataFollowUp();
		delay(1);
		followUpPage.searchDataFollowUp(nama);
		delay(1);
		followUpPage.clickTopTable();
		delay(1);
		followUpPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(1);
		followUpPage.clickSubmit();
		delay(3);
		followUpPage.clickYESPemberitahuan();
		delay(3);
		TaskAgreePage agreePage = followUpPage.clickDataAgree();
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
		followUpPage.clickBtnLogoutAtMain();
		delay(1);
		followUpPage.logout();
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
		TaskFollowUpPage followUpPage = mainPage.clickDataFollowUp();
		delay(1);
		followUpPage.searchDataFollowUp(nama);
		delay(1);
		followUpPage.clickTopTable();
		delay(1);
		followUpPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(3);
		followUpPage.clickSubmit();
		delay(1);
		followUpPage.clickYESPemberitahuan();
		delay(1);
		followUpPage.searchDataFollowUp(nama);
		delay(1);
		verifyDataInTable("(//tr)[41]", nama, statusResult);
		delay(10);
		followUpPage.clickBtnLogoutAtMain();
		delay(1);
		followUpPage.logout();
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
		String nama = "nasi_tumpeng_palembang";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskFollowUpPage followUpPage = mainPage.clickDataFollowUp();
		delay(1);
		followUpPage.searchDataFollowUp(nama);
		delay(1);
		followUpPage.clickTopTable();
		delay(1);
		followUpPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(1);
		followUpPage.clickSubmit();
		delay(1);
		followUpPage.clickYESPemberitahuan();
		delay(1);
		TaskDataAllPage allPage = followUpPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
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
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage();
		String nama = "hanshobbiescollezione";
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskFollowUpPage followUpPage = mainPage.clickDataFollowUp();
		delay(1);
		followUpPage.searchDataFollowUp(nama);
		delay(1);
		followUpPage.clickTopTable();
		delay(1);
		followUpPage.clickStatus(channel, status, statusCall, statusResult, reason);
		delay(1);
		followUpPage.clickSubmit();
		delay(1);
		followUpPage.clickYESPemberitahuan();
		delay(1);
		TaskDataAllPage allPage = followUpPage.clickTaskAll();
		delay(1);
		allPage.setSearchAll(nama);
		delay(1);
		allPage.clickSearchDataAll();
		delay(1);
		verifyDataInTable("(//tr)[43]", nama, statusResult);
		delay(10);
		followUpPage.clickBtnLogoutAtMain();
		delay(1);
		followUpPage.logout();
		delay(2);
	}
	
	@AfterTest
	public void close() {
		File file = new File("C:\\Users\\nexsoft\\Downloads\\exportthinking.xls");
		file.delete();
		driver.close();
	}
}
