package com.telemarket.report.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.telemarket.main.LoginPage;
import com.telemarket.main.MainPage;
import com.telemarket.report.pom.ReportCallTrackPage;
import com.telemarket.utilities.OtherFunc;


public class ReportCallTrackTest {
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
	public void test_goto_reportCallTrackPagePage() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		ReportCallTrackPage reportCallTrackPage = mainPage.clickReportCallTrack();
		delay(1);
		assertEquals(reportCallTrackPage.getTxtReportCallTrack(), "REPORT CALL TRACK");
		delay(3);
		driver.close();
	}
	
	@Test(priority = 2)
	public void test_checkNoAgent_Valid() {
		System.out.println("No Agent");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		ReportCallTrackPage reportCallTrackPage = mainPage.clickReportCallTrack();
		delay(1);
		reportCallTrackPage.getAllDropDown();
		delay(1);
		reportCallTrackPage.setStartDate("12112021");
		reportCallTrackPage.setEndDate("12122022");
		delay(1);
		reportCallTrackPage.clickView();
		
		reportCallTrackPage.checkCallTrackAgentContains("//div[2]/div[3]/table[1]/tbody[1]/tr/td[3]", "");
		delay(5);
		driver.close();
	}

	@Test(priority = 3)
	public void test_check1Agent_Valid() {
		System.out.println("1 Agent");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		ReportCallTrackPage reportCallTrackPage = mainPage.clickReportCallTrack();
		delay(1);
		reportCallTrackPage.getAllDropDown();
		reportCallTrackPage.setStartDate("12112021");
		reportCallTrackPage.setEndDate("12122022");
		delay(1);
		reportCallTrackPage.openDropDownAgent();
		reportCallTrackPage.agentRidho.click();
		delay(2);
		reportCallTrackPage.openDropDownAgent();
		delay(1);
		reportCallTrackPage.clickView();

		String agent = reportCallTrackPage.isiDropDown.getText();
		String[] agentA = agent.split(" , ");
		try {
			reportCallTrackPage.checkCallTrackAgentArray("//div[2]/div[3]/table[1]/tbody[1]/tr/td[3]", agentA);
		} finally {
			OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
			String file = "<img src='file://" + other.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(3);
			driver.close();
		}
	}

	@Test(priority = 4)
	public void test_check2Agent_Valid() {
		System.out.println("2 Agent");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		ReportCallTrackPage reportCallTrackPage = mainPage.clickReportCallTrack();
		delay(1);
		reportCallTrackPage.getAllDropDown();
		reportCallTrackPage.setStartDate("12112021");
		reportCallTrackPage.setEndDate("12122022");
		delay(1);
		reportCallTrackPage.openDropDownAgent();
		reportCallTrackPage.agentRidho.click();
		reportCallTrackPage.agentDian.click();
		delay(2);
		reportCallTrackPage.openDropDownAgent();
		delay(1);
		reportCallTrackPage.clickView();

		String agent = reportCallTrackPage.isiDropDown.getText();
		String[] agentA = agent.split(" , ");
		try {
			reportCallTrackPage.checkCallTrackAgentArray("//div[2]/div[3]/table[1]/tbody[1]/tr/td[3]", agentA);
		} finally {
			OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
			String file = "<img src='file://" + other.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(5);
			driver.close();
		}
	}
	
	@Test(priority = 5)
	public void test_checkAllAgent_Valid() {
		System.out.println("All Agent");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		ReportCallTrackPage reportCallTrackPage = mainPage.clickReportCallTrack();
		delay(1);
		reportCallTrackPage.setStartDate("12112021");
		reportCallTrackPage.setEndDate("12122022");
		delay(1);
		reportCallTrackPage.clickView();
		
		String agent = reportCallTrackPage.isiDropDown.getText();
		String[] agentA = agent.split(" , ");
		try {
			reportCallTrackPage.checkCallTrackAgentArray("//div[2]/div[3]/table[1]/tbody[1]/tr/td[3]", agentA);
		} finally {
			OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
			String file = "<img src='file://" + other.screenShot() + "'height=\"450\" width=\"1017\"/>";
			Reporter.log(file);
			delay(5);
			driver.close();
		}
	}
	
	@Test(priority = 6, enabled=false)
	public void click_export() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		
		ReportCallTrackPage reportCallTrackPage = mainPage.clickReportCallTrack();
		delay(1);
		reportCallTrackPage.setStartDate("12112021");
		reportCallTrackPage.setEndDate("12122022");
		reportCallTrackPage.clickView();
		reportCallTrackPage.clickExport();
		delay(5);
		driver.close();
	}

}
