package com.telemarket.usermanagement.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.telemarket.main.LoginPage;
import com.telemarket.main.MainPage;
import com.telemarket.usermanagement.pom.PhoneApprovePage;
import com.telemarket.usermanagement.pom.RecordingPage;
import com.telemarket.utilities.OtherFunc;

public class RecordingTest {
	protected WebDriver driver;

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void init() {
		System.setProperty("url", "https://sqa.peluangkerjaku.com/tele/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void test_goto_recording() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		RecordingPage recordingPage = mainPage.clickRecording();
		delay(1);
		assertEquals(recordingPage.getTxtRecording(), "RECORDING");
		delay(3);
		driver.close();
	}
	
	@Test(priority = 2)
	public void test_check_FieldSearch_kosong() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		RecordingPage recordingPage = mainPage.clickRecording();
		delay(1);
		recordingPage.sendFieldSearchRec("//div[1]/div[1]/div[2]/div[6]/table[1]/tbody[1]/tr/td[2]", "");
		delay(3);
		driver.close();
	}
	
	@Test(priority = 3)
	public void test_check_FieldSearch_perusahaan() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		RecordingPage recordingPage = mainPage.clickRecording();
		delay(1);
		recordingPage.sendFieldSearchRec("//div[1]/div[1]/div[2]/div[6]/table[1]/tbody[1]/tr/td[2]", "wihh_skincare");
		delay(3);
		driver.close();
	}
	
	@Test(priority = 4)
	public void test_check_FieldSearch_telepon() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		RecordingPage recordingPage = mainPage.clickRecording();
		delay(1);
		try {
			recordingPage.sendFieldSearchRec("//div[1]/div[1]/div[2]/div[6]/table[1]/tbody[1]/tr/td[3]", "085607417494");
		} finally {
			delay(3);
			driver.close();
		}
	}
	
	@Test(priority = 5)
	public void test_check_FieldSearch_kota() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		RecordingPage recordingPage = mainPage.clickRecording();
		delay(1);
		try {
			recordingPage.sendFieldSearchRec("//div[1]/div[1]/div[2]/div[6]/table[1]/tbody[1]/tr/td[4]", "Sleman");
		} finally {
			delay(3);
			driver.close();
		}
	}
	
	@Test(priority = 6)
	public void test_check_FieldSearch_kategory() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		RecordingPage recordingPage = mainPage.clickRecording();
		delay(1);
		try {
			recordingPage.sendFieldSearchRec("//div[1]/div[1]/div[2]/div[6]/table[1]/tbody[1]/tr/td[5]", "Small Social Seller");
		} finally {
			delay(3);
			driver.close();
		}
	}
	
	@Test(priority = 7)
	public void test_check_FieldSearch_tanggal() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		RecordingPage recordingPage = mainPage.clickRecording();
		delay(1);
		try {
			recordingPage.sendFieldSearchRec("//div[1]/div[1]/div[2]/div[6]/table[1]/tbody[1]/tr/td[6]", "2022-06-29");
		} finally {
			delay(3);
			driver.close();
		}
	}
	
	@Test(priority = 8)
	public void test_check_FieldSearch_catatan() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		RecordingPage recordingPage = mainPage.clickRecording();
		delay(1);
		try {
			recordingPage.sendFieldSearchRec("//div[1]/div[1]/div[2]/div[6]/table[1]/tbody[1]/tr/td[7]", "wa outlet");
		} finally {
			delay(3);
			driver.close();
		}
	}
	
	@Test(priority = 9)
	public void test_check_FieldSearch_namaAgent() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		RecordingPage recordingPage = mainPage.clickRecording();
		delay(1);
		try {
			recordingPage.sendFieldSearchRec("//div[1]/div[1]/div[2]/div[6]/table[1]/tbody[1]/tr/td[8]", "agent02");
		} finally {
			delay(3);
			driver.close();
		}
	}
	
	@Test(priority = 10)
	public void test_check_FieldSearch_statusResult() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		RecordingPage recordingPage = mainPage.clickRecording();
		delay(1);
		try {
			recordingPage.sendFieldSearchRec("//div[1]/div[1]/div[2]/div[6]/table[1]/tbody[1]/tr/td[9]", "setuju");
		} finally {
			delay(3);
			driver.close();
		}
	}
	
	@Test(priority = 11)
	public void test_check_FieldSearch_huruf() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		RecordingPage recordingPage = mainPage.clickRecording();
		delay(1);
		try {
			recordingPage.sendFieldSearchRec("//div[1]/div[1]/div[2]/div[6]/table[1]/tbody[1]/tr/td[2]", "a");
		} finally {
			delay(3);
			driver.close();
		}
	}
	
	@Test(priority = 12)
	public void test_check_FieldSearch_kata() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		RecordingPage recordingPage = mainPage.clickRecording();
		delay(1);
		try {
			recordingPage.sendFieldSearchRec("//div[1]/div[1]/div[2]/div[6]/table[1]/tbody[1]/tr/td[2]", "bakery");
		} finally {
			delay(3);
			driver.close();
		}
	}
	
	@Test(priority = 13)
	public void test_check_FieldSearch_angka() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		RecordingPage recordingPage = mainPage.clickRecording();
		delay(1);
		try {
			recordingPage.sendFieldSearchRec("//div[1]/div[1]/div[2]/div[6]/table[1]/tbody[1]/tr/td[2]", "12");
		} finally {
			delay(3);
			driver.close();
		}
	}
	
	@Test(priority = 14)
	public void test_check_FieldSearch_specChar() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		RecordingPage recordingPage = mainPage.clickRecording();
		delay(1);
		try {
			recordingPage.sendFieldSearchRec("//div[1]/div[1]/div[2]/div[6]/table[1]/tbody[1]/tr/td[2]", ".");
		} finally {
			delay(3);
			driver.close();
		}
	}
	
	@Test(priority = 15)
	public void test_check_FieldSearch_specChar2() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		RecordingPage recordingPage = mainPage.clickRecording();
		delay(1);
		try {
			recordingPage.sendFieldSearchRec("//div[1]/div[1]/div[2]/div[6]/table[1]/tbody[1]/tr/td[2]", ".as");
		} finally {
			delay(3);
			driver.close();
		}
	}
	
	@Test(priority = 16)
	public void test_btnHijau() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		RecordingPage recordingPage = mainPage.clickRecording();
		delay(1);
		try {
			recordingPage.testBtnHijau("//div[1]/div[1]/div[2]/div[6]/table[1]/tbody[1]/tr/td[2]", "hijau");
		} finally {
			delay(3);
			driver.close();
		}
	}
	
	@Test(priority = 17)
	public void test_clickPopupIsiTabel() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		RecordingPage recordingPage = mainPage.clickRecording();
		delay(1);
		assertEquals(recordingPage.getTxtPopup("//div[1]/div[1]/div[2]/div[6]/table[1]/tbody[1]/tr/td[2]"), "[d] Records");
		driver.close();
	}
	
	@Test(priority = 18)
	public void test_pageButton_first() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.clickRecording();
		delay(1);
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage("<<");
		other.verifPage("1");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 19)
	public void test_pageButton_2() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.clickRecording();
		delay(1);
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage("2");
		other.verifPage("2");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 20)
	public void test_pageButton_3() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.clickRecording();
		delay(1);
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage("3");
		other.verifPage("3");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 21)
	public void test_pageButton_4() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.clickRecording();
		delay(1);
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage("4");
		other.verifPage("4");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 22)
	public void test_pageButton_last() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.clickRecording();
		delay(1);
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage(">>");
		other.verifPageLast("//tr[1]/td[2]/div[1]/div[1]/div[2]/div[4]/ul[1]/li[7]/a[1]");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 23)
	public void test_showPage_10() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.clickRecording();
		delay(1);
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.showPageFunc("10");
		int jmlRowAct = other.verifDataRow();
		assertTrue(jmlRowAct <= 10);
		delay(5);
		driver.close();
	}
	
	@Test(priority = 24)
	public void test_showPage_25() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.clickRecording();
		delay(1);
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.showPageFunc("25");
		int jmlRowAct = other.verifDataRow();
		assertTrue(jmlRowAct <= 25);
		delay(5);
		driver.close();
	}
	
	@Test(priority = 25)
	public void test_showPage_50() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.clickRecording();
		delay(1);
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.showPageFunc("50");
		int jmlRowAct = other.verifDataRow();
		assertTrue(jmlRowAct <= 50);
		delay(5);
		driver.close();
	}
	
	@Test(priority = 26)
	public void test_showPage_100() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.clickRecording();
		delay(1);
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.showPageFunc("100");
		int jmlRowAct = other.verifDataRow();
		assertTrue(jmlRowAct <= 100);
		delay(5);
		driver.close();
	}
	
	@Test(priority = 27)
	public void test_showPage_500() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.clickRecording();
		delay(1);
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.showPageFunc("500");
		int jmlRowAct = other.verifDataRow();
		assertTrue(jmlRowAct <= 500);
		delay(5);
		driver.close();
	}
}
