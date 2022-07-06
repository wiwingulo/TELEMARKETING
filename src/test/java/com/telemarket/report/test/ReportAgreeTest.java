package com.telemarket.report.test;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.telemarket.report.pom.LoginPage;
import com.telemarket.report.pom.MainPage;
import com.telemarket.report.pom.ReportAgreePage;


public class ReportAgreeTest {
	
	protected WebDriver driver;
	
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
	public void test_show_login_page() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		
		delay(1);
		
		assertEquals(mainPage.txtPopUpOnMainPage.getText(), "Welcome to Tele Kita");
		mainPage.btnOKPopUpOnMainPage.click();
		
		assertEquals(mainPage.getTxtMainPage(), "Tele Marketing");
		delay(2);
		driver.close();
	}
	
	@Test(priority = 2)
	public void test_goto_report_agree_page() {
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		
		delay(1);
		
		mainPage.btnOKPopUpOnMainPage.click();
		
		delay(1);
		
		ReportAgreePage reportAgreePage = mainPage.clickReportAgree();
		delay(1);
		assertEquals(reportAgreePage.getTxtReportAgree(), "REPORT SETUJU");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 3)
	public void set_start_date_valid() {
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		
		delay(1);
		
		mainPage.btnOKPopUpOnMainPage.click();
		System.out.println("click ok");
		
		ReportAgreePage reportAgreePage = mainPage.clickReportAgree();
		delay(1);
		
		reportAgreePage.setStartDate("12112021");
		reportAgreePage.setEndDate("12122022");
		
		reportAgreePage.clickView();
		delay(5);
		driver.close();
		/* LogOut
		mainPage.btnLogoutMainPage.click();
		delay(1);
		mainPage.btnYesLogout.click();
		*/
	}
	
	@Test(priority = 4)
	public void click_view() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		
		delay(1);
		
		mainPage.btnOKPopUpOnMainPage.click();
		System.out.println("click ok");
		
		ReportAgreePage reportAgreePage = mainPage.clickReportAgree();
		delay(1);
		
		reportAgreePage.setStartDate("12112021");
		reportAgreePage.setEndDate("12122022");
		
		reportAgreePage.clickView();
		delay(5);
		driver.close();
	}
	
	@Test(priority = 5, enabled=false)
	public void click_export() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		
		delay(1);
		
		mainPage.btnOKPopUpOnMainPage.click();
		System.out.println("click ok");
		
		ReportAgreePage reportAgreePage = mainPage.clickReportAgree();
		delay(1);
		
		reportAgreePage.setStartDate("12112021");
		reportAgreePage.setEndDate("12122022");
		
		reportAgreePage.clickView();
		reportAgreePage.clickExport();
		delay(5);
		driver.close();
	}
	
	@Test(priority = 6)
	public void check_reportAgree_dataAgree() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		
		delay(1);
		
		mainPage.btnOKPopUpOnMainPage.click();
		System.out.println("click ok");
		
		ReportAgreePage reportAgreePage = mainPage.clickReportAgree();
		delay(1);
		
		reportAgreePage.setStartDate("12112021");
		reportAgreePage.setEndDate("12122022");
		
		reportAgreePage.clickView();
		
		reportAgreePage.checkDataAgree("//tr/td[6]");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 7)
	public void check_reportAgree_activityDate() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		
		delay(1);
		
		mainPage.btnOKPopUpOnMainPage.click();
		System.out.println("click ok");
		
		ReportAgreePage reportAgreePage = mainPage.clickReportAgree();
		delay(1);
		
		reportAgreePage.setStartDate("12112021");
		reportAgreePage.setEndDate("12122022");
		
		reportAgreePage.clickView();
		
		reportAgreePage.checkActivityDate("//div[6]/table[1]/tbody[1]/tr/td[4]" ,"12112021", "12122022");
		delay(5);
		driver.close();
	}
}
