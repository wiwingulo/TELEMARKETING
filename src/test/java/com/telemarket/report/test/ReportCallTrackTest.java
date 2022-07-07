package com.telemarket.report.test;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.telemarket.report.pom.LoginPage;
import com.telemarket.report.pom.MainPage;
import com.telemarket.report.pom.ReportCallTrack;



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
	public void test_check1Agent_Valid() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		ReportCallTrack reportCallTrack = mainPage.clickReportCallTrack();
		
		delay(1);
		
		reportCallTrack.getAllDropDown();
		
		reportCallTrack.setStartDate("12112021");
		reportCallTrack.setEndDate("12122022");
		delay(1);
		reportCallTrack.openDropDownAgent();
		reportCallTrack.agentCici.click();
		delay(2);
		String agent1 = reportCallTrack.agentCici.getAttribute("value");
		reportCallTrack.openDropDownAgent();
		delay(1);
		reportCallTrack.clickView();
		
		try {
			reportCallTrack.checkDataAgentCallTrack("//div[6]/table[1]/tbody[1]/tr/td[3]", agent1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			delay(3);
			driver.close();
		}
	}
	
	@Test(priority = 2)
	public void test_check2Agent_Valid() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		mainPage.btnOKPopUpOnMainPage.click();
		delay(1);
		ReportCallTrack reportCallTrack = mainPage.clickReportCallTrack();
		
		delay(1);
		
		reportCallTrack.getAllDropDown();
		
		reportCallTrack.setStartDate("12112015");
		reportCallTrack.setEndDate("12122022");
		delay(1);
		reportCallTrack.openDropDownAgent();
		reportCallTrack.agentCici.click();
		reportCallTrack.agentDian.click();
		delay(2);
		
		
		reportCallTrack.openDropDownAgent();
		delay(1);
		reportCallTrack.clickView();
		
		try {
			reportCallTrack.checkCallTrack2Agent("//div[6]/table[1]/tbody[1]/tr/td[3]");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			delay(3);
			driver.close();
		}
	}

}
