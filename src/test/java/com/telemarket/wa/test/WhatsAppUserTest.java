package com.telemarket.wa.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.telemarket.main.LoginPage;
import com.telemarket.main.MainPage;
import com.telemarket.utilities.OtherFunc;
import com.telemarket.wa.pom.WhatsAppPage;

public class WhatsAppUserTest {
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
	public void test_goto_messageWA() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("AGENT01", "1");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		WhatsAppPage whatsAppPage = mainPage.clickMessageWA();
		delay(1);
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.showPageFunc("500");
		assertEquals(whatsAppPage.getTxtMessageWA(), "DATA MESSAGE WA");
		delay(3);
		driver.close();
	}

	@Test(priority = 2)
	public void test_popupWA_SameNumber() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("AGENT01", "1");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		WhatsAppPage whatsAppPage = mainPage.clickMessageWA();
		whatsAppPage.assertNomorWA();
		delay(3);
		driver.close();
	}

	@Test(priority = 3)
	public void test_popupWA_NoMorePopUp() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("AGENT01", "1");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		WhatsAppPage whatsAppPage = mainPage.clickMessageWA();
		try {
			whatsAppPage.assertPopUpWithinPopUp();
		} finally {
			OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
			String file = "<img src='file://" + other.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(3);
			driver.close();
		}
	}
	
	@Test(priority = 4)
	public void test_pageButton_first() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("AGENT01", "1");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		WhatsAppPage whatsAppPage = mainPage.clickMessageWA();
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage("<<");
		other.verifPage("1");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 5)
	public void test_pageButton_2() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("AGENT01", "1");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		WhatsAppPage whatsAppPage = mainPage.clickMessageWA();
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage("2");
		other.verifPage("2");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 6)
	public void test_pageButton_3() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("AGENT01", "1");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		WhatsAppPage whatsAppPage = mainPage.clickMessageWA();
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage("3");
		other.verifPage("3");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 7)
	public void test_pageButton_4() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("AGENT01", "1");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		WhatsAppPage whatsAppPage = mainPage.clickMessageWA();
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage("4");
		other.verifPage("4");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 8)
	public void test_pageButton_5() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("AGENT01", "1");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		WhatsAppPage whatsAppPage = mainPage.clickMessageWA();
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage("5");
		other.verifPage("5");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 9)
	public void test_pageButton_last() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("AGENT01", "1");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		WhatsAppPage whatsAppPage = mainPage.clickMessageWA();
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage(">>");
		other.verifPageLast("//tr[1]/td[2]/div[1]/div[1]/div[1]/div[3]/div[4]/ul[1]/li[7]/a[1]");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 10)
	public void test_showPage_10() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("AGENT01", "1");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		WhatsAppPage whatsAppPage = mainPage.clickMessageWA();
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.showPageFunc("10");
		int jmlRowAct = other.verifDataRow();
		assertTrue(jmlRowAct <= 10);
		delay(5);
		driver.close();
	}
	
	@Test(priority = 11)
	public void test_showPage_25() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("AGENT01", "1");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		WhatsAppPage whatsAppPage = mainPage.clickMessageWA();
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.showPageFunc("25");
		int jmlRowAct = other.verifDataRow();
		assertTrue(jmlRowAct <= 25);
		delay(5);
		driver.close();
	}
	
	@Test(priority = 12)
	public void test_showPage_50() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("AGENT01", "1");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		WhatsAppPage whatsAppPage = mainPage.clickMessageWA();
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.showPageFunc("50");
		int jmlRowAct = other.verifDataRow();
		assertTrue(jmlRowAct <= 50);
		delay(5);
		driver.close();
	}
	
	@Test(priority = 13)
	public void test_showPage_100() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("AGENT01", "1");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		WhatsAppPage whatsAppPage = mainPage.clickMessageWA();
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.showPageFunc("100");
		int jmlRowAct = other.verifDataRow();
		assertTrue(jmlRowAct <= 100);
		delay(5);
		driver.close();
	}
	
	@Test(priority = 14)
	public void test_showPage_500() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("AGENT01", "1");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		WhatsAppPage whatsAppPage = mainPage.clickMessageWA();
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.showPageFunc("500");
		int jmlRowAct = other.verifDataRow();
		assertTrue(jmlRowAct <= 500);
		delay(5);
		driver.close();
	}
}
