package com.telemarket.report.test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.telemarket.main.LoginPage;
import com.telemarket.main.MainPage;
import com.telemarket.report.pom.ReportActivityPage;
import com.telemarket.report.pom.ReportCallMonitoringPage;
import com.telemarket.utilities.OtherFunc;

public class ReportCallMonitoringTest {
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
	public void test_goto_reportCallMonitoringPage() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		ReportCallMonitoringPage reportCallMonitoringPage = mainPage.clickReportCallMonitoring();
		delay(1);
		assertEquals(reportCallMonitoringPage.getTxtReportCallMonitoring(), "REPORT CALL MONITORING");
		delay(3);
		driver.close();
	}
	
	@Test(priority = 2)
	public void test_verif_monitoringALL_with_taskALL() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		ReportCallMonitoringPage reportCallMonitoringPage = mainPage.clickReportCallMonitoring();
		String dataMonitoringALL = driver.findElement(By.xpath("//div[1]/div[1]/div[3]/div[3]/table[1]/tbody[1]/tr[5]/td[4]")).getText();
		delay(1);
		int jmlDataMonALL = Integer.parseInt(dataMonitoringALL);
		delay(1);
		driver.findElement(By.xpath("(//h3[normalize-space()='Task'])[1]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Data ALL']")).click();
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage(">>");
		delay(1);
		String dataTaskALL = driver.findElement(By.xpath("//div[6]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]")).getText();
		int jmlDataTaskALL = Integer.parseInt(dataTaskALL);
		assertEquals(jmlDataTaskALL, jmlDataMonALL);
		delay(3);
		driver.close();
	}
	
	@Test(priority = 3)
	public void test_verif_monitoringNEW_with_taskNEW() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		ReportCallMonitoringPage reportCallMonitoringPage = mainPage.clickReportCallMonitoring();
		delay(1);
		String dataMonitoringNEW = driver.findElement(By.xpath("//div[1]/div[1]/div[3]/div[3]/table[1]/tbody[1]/tr[5]/td[5]")).getText();
		int jmlDataMonNEW = Integer.parseInt(dataMonitoringNEW);
		delay(1);
		driver.findElement(By.xpath("(//h3[normalize-space()='Task'])[1]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='New']")).click();
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage(">>");
		delay(1);
		String dataTaskNEW = driver.findElement(By.xpath("//div[6]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]")).getText();
		int jmlDataTaskNew = Integer.parseInt(dataTaskNEW);
		try {
			assertEquals(jmlDataTaskNew, jmlDataMonNEW);
		} finally {
			String file = "<img src='file://" + other.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(3);
			driver.close();
		}
	}
}
