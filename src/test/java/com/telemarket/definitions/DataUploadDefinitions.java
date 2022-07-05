package com.telemarket.definitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.telemarket.pom.data.Dashboard;
import com.telemarket.pom.data.LoginPage;
import com.telemarket.pom.data.MainPage;
import com.telemarket.pom.data.UploadData;

public class DataUploadDefinitions {
	
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
	public void test_show_login_page() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.login_goto_main_page("developer", "23");
		delay(1);
		System.out.println("login berhasil");
		delay(1);
		mainPage.btnOK.click();
		System.out.println("click ok");
		delay(1);
		
	}
	
	@Test(priority = 2)
	public void clickDataMenu() {
		MainPage main = PageFactory.initElements(driver, MainPage.class);
		main.btnOK.click();
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		dash.btnData.click();
		delay(1);
		dash.btnUploadData.click();
	}
	
	@Test(priority = 3)
	public void uploadDataExcel() {
		delay(5);
		System.out.println("Upload Data");
		delay(2);
		upload.btnUpload.click();
		delay(5);
		upload.btnUpload.sendKeys("D:\\Data.xlsx");
//		upload.btnUploadExcel.click();
	}

}
