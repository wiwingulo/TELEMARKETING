package com.telemarket.task.test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.telemarket.task.pom.LoginPage;
import com.telemarket.task.pom.MainPage;
import com.telemarket.task.pom.TaskAgreePage;
import com.telemarket.task.pom.TaskDataAllPage;
import com.telemarket.task.pom.TaskFinalPage;
import com.telemarket.task.pom.TaskFollowUpPage;
import com.telemarket.task.pom.TaskNewPage;

public class TLMKT_TestLogin {
	
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected MainPage mainPage;

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String screenShot() {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String waktu = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String namaFile = "D:\\selenium-workspace\\TLMKT\\TELEMARKETING\\hasilScreenshot\\" + waktu + ".png";
		File screenshot = new File(namaFile);
		try {
			FileUtils.copyFile(srcFile, screenshot);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return namaFile;
	}

	@BeforeTest
	public void init() {
		System.setProperty("url", "https://sqa.peluangkerjaku.com/tele/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		loginPage = new LoginPage(driver);
		mainPage = new MainPage(driver);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
	}

	@BeforeMethod
	public void cekSession() {
		driver.get(System.getProperty("url"));
	}

	@Test(priority = 1)
	public void test_login_username_valid_password_valid() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage("developer", "23", "ok");
		delay(1);
		assertEquals(mainPage.getTextPopUp(), "Information");
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		assertEquals(mainPage.getTextMainPage(), "Tele Marketing");
//		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
//		Reporter.log(file);
		delay(1);
		mainPage.clickBtnLogoutAtMain();
		delay(1);
		assertEquals(mainPage.getTextPopUp(), "Logout");
		mainPage.logout();
		delay(1);
		assertEquals(loginPage.getTextLogin(), "[d] LOGIN");
	}

	@Test(priority = 2)
	public void test_login_username_valid_password_invalid() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginToMainPage("developer", "400", "ok");
		delay(1);
		assertEquals(loginPage.txtPeringatanLogin.getText(), "Peringatan");
//		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
//		Reporter.log(file);
		delay(1);
		loginPage.btnOKPeringatan.click();
	}

	@Test(priority = 3)
	public void test_login_username_invalid_password_invalid() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginToMainPage("mamam", "kue", "ok");
		delay(1);
		assertEquals(loginPage.txtPeringatanLogin.getText(), "Peringatan");
//		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
//		Reporter.log(file);
		delay(1);
		loginPage.btnOKPeringatan.click();
	}

	@Test(priority = 4)
	public void test_login_username_empty_password_empty() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginToMainPage("", "", "ok");
		delay(1);
		assertEquals(loginPage.txtPeringatanLogin.getText(), "Peringatan");
//		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
//		Reporter.log(file);
		delay(1);
		loginPage.btnOKPeringatan.click();
	}

	@Test(priority = 5)
	public void testLogin_usernameAndPasswordValid_clickGreenUsername() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage("developer", "23", "username");
		delay(1);
		assertEquals(mainPage.getTextPopUp(), "Information");
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		assertEquals(mainPage.getTextMainPage(), "Tele Marketing");
//		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
//		Reporter.log(file);
		delay(1);
		mainPage.clickBtnLogoutAtMain();
		delay(1);
		assertEquals(mainPage.getTextPopUp(), "Logout");
		mainPage.logout();
		delay(1);
		assertEquals(loginPage.getTextLogin(), "[d] LOGIN");
	}
	
	@Test(priority = 6)
	public void testLogin_usernameAndPasswordValid_clickGreenPassword() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage("developer", "23", "password");
		delay(1);
		assertEquals(mainPage.getTextPopUp(), "Information");
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		assertEquals(mainPage.getTextMainPage(), "Tele Marketing");
//		String file = "<img src='file://" + screenShot() + "'height=\"450\" width=\"1017\"/>";
//		Reporter.log(file);
		delay(1);
		mainPage.clickBtnLogoutAtMain();
		delay(1);
		assertEquals(mainPage.getTextPopUp(), "Logout");
		mainPage.logout();
		delay(1);
		assertEquals(loginPage.getTextLogin(), "[d] LOGIN");
	}
	
	@Test(priority=7)
	public void testNavigate() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage("developer", "23", "ok");
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(2);
		assertEquals(newPage.getTextNew(),"DATA NEW");
		delay(1);
		TaskAgreePage agreePage = mainPage.clickDataAgree();
		delay(2);
		assertEquals(agreePage.getTextAgree(),"DATA AGREE");
		delay(1);
		TaskFollowUpPage folUp = mainPage.clickDataFollowUp();
		delay(2);
		assertEquals(folUp.getTextFollowUp(),"DATA THINKING");
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(2);
		assertEquals(allPage.getTextDataAll(),"DATA ALL");
		delay(1);
		TaskFinalPage finalPage = mainPage.clickTaskFinal();
		delay(2);
		assertEquals(finalPage.getTextFinal(),"DATA FINAL");
		delay(1);
		mainPage.clickBtnLogoutAtMain();
		delay(1);
		assertEquals(mainPage.getTextPopUp(), "Logout");
		mainPage.logout();
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
}
