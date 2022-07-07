package com.telemarket.usermanagement.test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.telemarket.report.pom.LoginPage;
import com.telemarket.report.pom.MainPage;
import com.telemarket.usermanagement.pom.PhoneApprovePage;
import com.telemarket.wa.pom.WhatsAppPage;

public class PhoneApproveTest {
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
	public void test_goto_phoneApprove() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		PhoneApprovePage phoneApprovePage = mainPage.clickPhoneApprove();
		delay(1);
		assertEquals(phoneApprovePage.getTxtPhoneApprove(), "ADDITIONAL PHONE");
		delay(3);
		driver.close();
	}
	
	@Test(priority = 2)
	public void test_sendKeysFieldAgentSearch_Kosong() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		PhoneApprovePage phoneApprovePage = mainPage.clickPhoneApprove();
		delay(1);
		phoneApprovePage.sendFieldAgentSearch("//div[5]/div[6]/table[1]/tbody[1]/tr/td[3]", "");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 3)
	public void test_sendKeysFieldAgentSearch_Huruf() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		PhoneApprovePage phoneApprovePage = mainPage.clickPhoneApprove();
		delay(1);
		phoneApprovePage.sendFieldAgentSearch("//div[5]/div[6]/table[1]/tbody[1]/tr/td[3]", "g");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 4)
	public void test_sendKeysFieldAgentSearch_Angka() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		PhoneApprovePage phoneApprovePage = mainPage.clickPhoneApprove();
		delay(1);
		phoneApprovePage.sendFieldAgentSearch("//div[5]/div[6]/table[1]/tbody[1]/tr/td[3]", "5");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 5)
	public void test_sendKeysFieldAgentSearch_SpecChar() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		PhoneApprovePage phoneApprovePage = mainPage.clickPhoneApprove();
		delay(1);
		phoneApprovePage.sendFieldAgentSearch("//div[5]/div[6]/table[1]/tbody[1]/tr/td[3]", "#");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 6)
	public void test_sendKeysFieldAgentSearch_Kata() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		PhoneApprovePage phoneApprovePage = mainPage.clickPhoneApprove();
		delay(1);
		phoneApprovePage.sendFieldAgentSearch("//div[5]/div[6]/table[1]/tbody[1]/tr/td[3]", "ridho");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 7)
	public void test_approveButton_notChecked() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		PhoneApprovePage phoneApprovePage = mainPage.clickPhoneApprove();
		delay(1);
		phoneApprovePage.clickApprove();
		
		try {
			phoneApprovePage.verifApproveNotChecked();
		} 
		finally {
			delay(5);
			driver.close();
		}
	}
	
	@Test(priority = 8)
	public void test_approveButton_1Checked() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		PhoneApprovePage phoneApprovePage = mainPage.clickPhoneApprove();
		delay(1);
		phoneApprovePage.checkBoxChecked(1);
//		delay(1);
//		phoneApprovePage.clickApprove();
//		phoneApprovePage.verifApproveNotChecked();
		delay(5);
		driver.close();
	}
}
