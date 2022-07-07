package com.telemarket.test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.telemarket.pom.data.Dashboard;
import com.telemarket.pom.data.LoginPage;
import com.telemarket.pom.data.MainPage;
import com.telemarket.pom.data.UploadData;

public class DataUploadTest {
	
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected MainPage mainPage;
	protected Dashboard dash;
	protected UploadData upload;
	
	public void delay(int inInt) {
		try {
			Thread.sleep(inInt*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@BeforeTest
	public void init() {
		System.setProperty("url", "https://sqa.peluangkerjaku.com/tele/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		loginPage = new LoginPage(driver);
		mainPage = new MainPage(driver);
		dash = new Dashboard(driver);
		upload = new UploadData(driver);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
		
	}

	@BeforeMethod
	public void cekSession() {
		driver.get(System.getProperty("url"));
	}
	

	@Test(priority = 1)
	public void uploadData() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		UploadData upload = PageFactory.initElements(driver, UploadData.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.btnData.click();
		delay(1);
		dash.btnUploadData.click();
		delay(10);
		upload.uploadData();
		delay(2);
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}
	
	@Test(priority = 2)
	public void clickDataMenuIfDataisAnotherFormat() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		UploadData upload = PageFactory.initElements(driver, UploadData.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.btnData.click();
		delay(1);
		dash.btnUploadData.click();
		delay(10);
		upload.uploadDataWrongFormat();
		delay(2);
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}
		
	@Test(priority = 3)
	public void clickButtonStep() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		UploadData upload = PageFactory.initElements(driver, UploadData.class);
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);

		dash.btnData.click();
		delay(1);
		dash.btnUploadData.click();
		delay(10);
		upload.btnUpload.sendKeys("D:\\Data.xlsx");
		delay(10);
		upload.btnUploadExcel.click();
		delay(5);
		upload.testButtonPage();
		delay(2);
		upload.viewTable(10);
		delay(1);
		upload.viewTable(25);
		delay(1);
		upload.viewTable(50);
		delay(1);
		upload.viewTable(100);
		delay(1);
		upload.viewTable(500);
		delay(1);
		
		//logout
		dash.clickBtnLogoutAtMain();
		delay(1);
		dash.logout();
		delay(2);
	}

}
