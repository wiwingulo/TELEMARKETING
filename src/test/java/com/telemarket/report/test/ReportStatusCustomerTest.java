package com.telemarket.report.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.telemarket.main.LoginPage;
import com.telemarket.main.MainPage;
import com.telemarket.report.pom.ReportStatusCustomerPage;
import com.telemarket.utilities.OtherFunc;

public class ReportStatusCustomerTest {
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
	public void test_goto_reportStatusCustomerPage() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		ReportStatusCustomerPage reportStatusCustomerPage = mainPage.clickReportStatusCustomer();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='REPORT LEVEL CUSTOMER']")));
		assertEquals(reportStatusCustomerPage.getTxtReportStatusCustomer(), "REPORT LEVEL CUSTOMER");
		delay(3);
		driver.close();
	}
	
	@Test(priority = 2, enabled=false)
	public void click_export() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		
		ReportStatusCustomerPage reportStatusCustomerPage = mainPage.clickReportStatusCustomer();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='REPORT LEVEL CUSTOMER']")));
		reportStatusCustomerPage.clickExport();
		delay(5);
		driver.close();
	}
	
	@Test(priority = 3)
	public void test_pageButton_first() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.clickReportStatusCustomer();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='REPORT LEVEL CUSTOMER']")));
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage("<<");
		delay(10);
		other.verifPage("1");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 4)
	public void test_pageButton_2() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.clickReportStatusCustomer();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='REPORT LEVEL CUSTOMER']")));
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage("2");
		delay(10);
		other.verifPage("2");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 5)
	public void test_pageButton_3() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.clickReportStatusCustomer();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='REPORT LEVEL CUSTOMER']")));
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage("3");
		delay(10);
		other.verifPage("3");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 6)
	public void test_pageButton_4() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.clickReportStatusCustomer();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='REPORT LEVEL CUSTOMER']")));
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage("4");
		delay(10);
		other.verifPage("4");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 7)
	public void test_pageButton_last() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.clickReportStatusCustomer();
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage(">>");
		delay(10);
		other.verifPageLast("//tr[1]/td[2]/div[1]/div[1]/div[2]/div[2]/div[4]/ul[1]/li[7]/a[1]");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 8)
	public void test_ShowPage_10() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.clickReportStatusCustomer();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='REPORT LEVEL CUSTOMER']")));
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.showPageFunc("10");
		delay(10);
		int jmlRowAct = other.verifDataRow();
		assertTrue(jmlRowAct <= 10);
		delay(5);
		driver.close();
	}
	
	@Test(priority = 9)
	public void test_ShowPage_25() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.clickReportStatusCustomer();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='REPORT LEVEL CUSTOMER']")));
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.showPageFunc("25");
		delay(10);
		int jmlRowAct = other.verifDataRow();
		assertTrue(jmlRowAct <= 25);
		delay(5);
		driver.close();
	}
	
	@Test(priority = 10)
	public void test_ShowPage_50() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.clickReportStatusCustomer();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='REPORT LEVEL CUSTOMER']")));
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.showPageFunc("50");
		delay(10);
		int jmlRowAct = other.verifDataRow();
		assertTrue(jmlRowAct <= 50);
		delay(5);
		driver.close();
	}
	
	@Test(priority = 11)
	public void test_ShowPage_100() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.clickReportStatusCustomer();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='REPORT LEVEL CUSTOMER']")));
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.showPageFunc("100");
		delay(10);
		int jmlRowAct = other.verifDataRow();
		assertTrue(jmlRowAct <= 100);
		delay(5);
		driver.close();
	}
	
	@Test(priority = 12)
	public void test_ShowPage_500() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		mainPage.clickReportStatusCustomer();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='REPORT LEVEL CUSTOMER']")));
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.showPageFunc("500");
		delay(10);
		int jmlRowAct = other.verifDataRow();
		assertTrue(jmlRowAct <= 500);
		delay(5);
		driver.close();
	}
}
