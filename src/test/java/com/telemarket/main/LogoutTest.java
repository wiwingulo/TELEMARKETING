package com.telemarket.main;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest {
public WebDriver driver;
	
	public void delay(int inInt) {
		try {
			Thread.sleep(inInt*1000);
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
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	@Test(priority = 1)
	public void test_goto_popupLogout() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.btnLogoutMainPage.click();
		delay(1);
		assertEquals(mainPage.txtPopUpLogout.getText(), "Logout");
		delay(3);
		driver.close();
	}
	
	@Test(priority = 2)
	public void test_YesLogout() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.btnLogoutMainPage.click();
		delay(1);
		mainPage.btnYesLogout.click();
		delay(1);
		assertEquals(loginPage.txtLogin.getText(), "[d] LOGIN");
		delay(3);
		driver.close();
	}
	
	@Test(priority = 3)
	public void test_NoLogout() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.btnLogoutMainPage.click();
		delay(1);
		mainPage.btnNoLogout.click();
		delay(1);
		assertEquals(mainPage.txtMainPage.getText(), "Tele Marketing");
		delay(3);
		driver.close();
	}
	
	@Test(priority = 4)
	public void test_goto_popupLogout_Agn() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("AGENT01", "1");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.btnLogoutMainPage.click();
		delay(1);
		assertEquals(mainPage.txtPopUpLogout.getText(), "Logout");
		delay(3);
		driver.close();
	}
	
	@Test(priority = 5)
	public void test_YesLogout_Agn() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("AGENT01", "1");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.btnLogoutMainPage.click();
		delay(1);
		mainPage.btnYesLogout.click();
		delay(1);
		assertEquals(loginPage.txtLogin.getText(), "[d] LOGIN");
		delay(3);
		driver.close();
	}
	
	@Test(priority = 6)
	public void test_NoLogout_Agn() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("AGENT01", "1");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.btnLogoutMainPage.click();
		delay(1);
		mainPage.btnNoLogout.click();
		delay(1);
		assertEquals(mainPage.txtMainPage.getText(), "Tele Marketing");
		delay(3);
		driver.close();
	}
}
