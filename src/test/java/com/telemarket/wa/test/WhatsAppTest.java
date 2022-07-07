package com.telemarket.wa.test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.telemarket.report.pom.LoginPage;
import com.telemarket.report.pom.MainPage;
import com.telemarket.report.pom.ReportCallMonitoringPage;
import com.telemarket.wa.pom.WhatsAppPage;

public class WhatsAppTest {
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
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		WhatsAppPage whatsAppPage = mainPage.clickMessageWA();
		delay(1);
		assertEquals(whatsAppPage.getTxtMessageWA(), "DATA MESSAGE WA");
		delay(3);
		driver.close();
	}

	@Test(priority = 2)
	public void test_popupWA_SameNumber() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
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
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		WhatsAppPage whatsAppPage = mainPage.clickMessageWA();
		try {
			whatsAppPage.assertPopUpWithinPopUp();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			delay(3);
			driver.close();
		}
	}
}
