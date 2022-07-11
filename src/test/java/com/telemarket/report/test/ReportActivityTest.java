package com.telemarket.report.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.telemarket.main.LoginPage;
import com.telemarket.main.MainPage;
import com.telemarket.report.pom.ReportActivityPage;
import com.telemarket.utilities.OtherFunc;

public class ReportActivityTest {
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
		
		reportActivityPage.checkDataAgentActivityContains("//div[6]/table[1]/tbody[1]/tr/td[9]", "");
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
	
	@Test(priority = 6)
	public void test_checkAllAgent_Valid() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		ReportActivityPage reportActivityPage = mainPage.clickReportActivity();
		delay(1);
		reportActivityPage.openDropDownAgent();
		reportActivityPage.clickAllDropDownAgent();
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
	
	@Test(priority = 7)
	public void test_checkEmptying_fieldDate() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		ReportActivityPage reportActivityPage = mainPage.clickReportActivity();
		delay(1);
		driver.findElement(By.xpath("(//input[@id='tl_perform_report--51781_text'])[1]")).click();
		delay(2);
		driver.findElement(By.xpath("(//input[@id='tl_perform_report--51788_text'])[1]")).click();
		String fieldStart = driver.findElement(By.xpath("(//input[@id='tl_perform_report--51781_text'])[1]")).getAttribute("value");
		String fieldEnd = driver.findElement(By.xpath("(//input[@id='tl_perform_report--51788_text'])[1]")).getAttribute("value");
		
		try {
			assertTrue(fieldStart == null || fieldEnd == null || fieldStart == "" || fieldEnd == "");
		}
		finally {
			OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
			String file = "<img src='file://" + other.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(5);
			driver.close();
		}
	}
	
	@Test(priority = 8)
	public void set_endDateBeforeStartDate() {
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		
		ReportActivityPage reportActivityPage = mainPage.clickReportActivity();
		delay(1);
		reportActivityPage.setStartDate("12112021");
		reportActivityPage.setEndDate("12122020");
		reportActivityPage.clickView();
		
		try {
			reportActivityPage.checkActivityDate("//div[6]/table[1]/tbody[1]/tr/td[4]", "12112021", "12122020");
		} finally {
			OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
			String file = "<img src='file://" + other.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(5);
			driver.close();
		}
	}
	
	@Test(priority = 9)
	public void set_StartDateEndDateAfterCurrentDate() {
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		
		ReportActivityPage reportActivityPage = mainPage.clickReportActivity();
		delay(1);
		reportActivityPage.setStartDate("12022023");
		reportActivityPage.setEndDate("12052023");
		reportActivityPage.clickView();
		
		try {
			reportActivityPage.checkActivityDate("//div[6]/table[1]/tbody[1]/tr/td[4]", "01012023", "05012023");
		} finally {
			OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
			String file = "<img src='file://" + other.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(5);
			driver.close();
		}
	}
	
	@Test(priority = 10, enabled=false)
	public void click_export() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		
		ReportActivityPage reportActivityPage = mainPage.clickReportActivity();
		delay(1);
		reportActivityPage.setStartDate("12112021");
		reportActivityPage.setEndDate("12122022");
	
		reportActivityPage.clickView();
		reportActivityPage.clickExport();
		delay(5);
		driver.close();
	}
	
	@Test(priority = 11)
	public void test_pageButton_first() {
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
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage("<<");
		other.verifPage("1");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 12)
	public void test_pageButton_2() {
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
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage("2");
		other.verifPage("2");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 13)
	public void test_pageButton_3() {
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
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage("3");
		other.verifPage("3");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 14)
	public void test_pageButton_4() {
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
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage("4");
		other.verifPage("4");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 15)
	public void test_pageButton_last() {
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
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.changePage(">>");
		other.verifPageLast("//tr[1]/td[2]/div[1]/div[1]/div[2]/div[4]/ul[1]/li[7]/a[1]");
		delay(5);
		driver.close();
	}
	
	@Test(priority = 16)
	public void test_ShowPage_10() {
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
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.showPageFunc("10");
		int jmlRowAct = other.verifDataRow();
		assertTrue(jmlRowAct <= 10);
		delay(5);
		driver.close();
	}
	
	@Test(priority = 17)
	public void test_ShowPage_25() {
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
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.showPageFunc("25");
		int jmlRowAct = other.verifDataRow();
		assertTrue(jmlRowAct <= 25);
		delay(5);
		driver.close();
	}
	
	@Test(priority = 18)
	public void test_ShowPage_50() {
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
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.showPageFunc("50");
		int jmlRowAct = other.verifDataRow();
		assertTrue(jmlRowAct <= 50);
		delay(5);
		driver.close();
	}
	
	@Test(priority = 19)
	public void test_ShowPage_100() {
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
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.showPageFunc("100");
		int jmlRowAct = other.verifDataRow();
		assertTrue(jmlRowAct <= 100);
		delay(5);
		driver.close();
	}
	
	@Test(priority = 20)
	public void test_ShowPage_500() {
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
		
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.showPageFunc("500");
		int jmlRowAct = other.verifDataRow();
		assertTrue(jmlRowAct <= 500);
		delay(5);
		driver.close();
	}
}
