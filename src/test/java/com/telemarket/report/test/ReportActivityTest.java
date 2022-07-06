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
import com.telemarket.report.pom.ReportActivityPage;


public class ReportActivityTest {
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
	public void test_goto_reportActivityPage() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		
		delay(1);
		
		mainPage.btnOKPopUpOnMainPage.click();
		
		delay(1);
		
		ReportActivityPage reportActivityPage = mainPage.clickReportActivity();
		delay(1);
		assertEquals(reportActivityPage.getTxtReportActivity(), "PERFORM REPORT");
		delay(3);
		driver.close();
	}
	
	@Test(priority = 2)
	public void test_checkNoAgent_Valid() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		
		delay(1);
		
		mainPage.btnOKPopUpOnMainPage.click();
		
		delay(1);
		
		ReportActivityPage reportActivityPage = mainPage.clickReportActivity();
		delay(1);
	
		reportActivityPage.setStartDate("12112021");
		reportActivityPage.setEndDate("12122022");
		
		reportActivityPage.clickView();
		delay(5);
		driver.close();
	}
	
	@Test(priority = 3)
	public void test_check1Agent_Valid() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		
		delay(1);
		
		mainPage.btnOKPopUpOnMainPage.click();
		
		delay(1);
		
		ReportActivityPage reportActivityPage = mainPage.clickReportActivity();
		delay(1);
		
		reportActivityPage.openDropDownAgent();
		reportActivityPage.click1DropDownAgent();
		delay(1);
		reportActivityPage.openDropDownAgent();
		
		delay(1);
		
		reportActivityPage.setStartDate("12112021");
		reportActivityPage.setEndDate("12122022");
		
		reportActivityPage.clickView();
		
		String agent = reportActivityPage.isiDropDown.getText();
		
		String[] agentA = agent.split(" , ");
		
		reportActivityPage.checkDataAgentActivity("//div[6]/table[1]/tbody[1]/tr/td[9]", agentA);	
		delay(5);
		driver.close();
		
	}
	
	@Test(priority = 4)
	public void test_check2Agent_Valid() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		
		delay(1);
		
		mainPage.btnOKPopUpOnMainPage.click();
		
		delay(1);
		
		ReportActivityPage reportActivityPage = mainPage.clickReportActivity();
		delay(1);
		
		reportActivityPage.openDropDownAgent();
		reportActivityPage.click2DropDownAgent();
		delay(1);
		reportActivityPage.openDropDownAgent();
		
		driver.findElement(By.xpath("(//div[@id='tl_perform_report--51784'])[1]")).click();
		
		delay(1);
		
		reportActivityPage.setStartDate("12112021");
		reportActivityPage.setEndDate("12122022");
		
		reportActivityPage.clickView();
		
		String agent = reportActivityPage.isiDropDown.getText();
		
		String[] agentA = agent.split(" , ");
		
		reportActivityPage.checkDataAgentActivity("//div[6]/table[1]/tbody[1]/tr/td[9]", agentA);
		delay(5);
		driver.close();
		
	}
	
	@Test(priority = 5)
	public void test_check3Agent_Valid() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		
		delay(1);
		
		mainPage.btnOKPopUpOnMainPage.click();
		
		delay(1);
		
		ReportActivityPage reportActivityPage = mainPage.clickReportActivity();
		delay(1);
		
		reportActivityPage.openDropDownAgent();
		reportActivityPage.click3DropDownAgent();
		delay(1);
		reportActivityPage.openDropDownAgent();
		
		driver.findElement(By.xpath("(//div[@id='tl_perform_report--51784'])[1]")).click();
		
		delay(1);
		
		reportActivityPage.setStartDate("12112021");
		reportActivityPage.setEndDate("12122022");
		
		reportActivityPage.clickView();
		
		String agent = reportActivityPage.isiDropDown.getText();
		
		String[] agentA = agent.split(" , ");
		
		reportActivityPage.checkDataAgentActivity("//div[6]/table[1]/tbody[1]/tr/td[9]", agentA);
		delay(5);
		driver.close();
		
	}
	
}
