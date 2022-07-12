package com.telemarket.task.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.telemarket.task.pom.LoginPage;
import com.telemarket.task.pom.MainPage;
import com.telemarket.task.pom.TaskAgreePage;
import com.telemarket.task.pom.TaskDataAllPage;
import com.telemarket.task.pom.TaskFinalPage;
import com.telemarket.task.pom.TaskFollowUpPage;
import com.telemarket.task.pom.TaskNewPage;

public class TLMKT_TestLogin extends Utility {

	protected WebDriver driver;

	@BeforeMethod
	public void cekSession() {
		System.setProperty("url", "https://sqa.peluangkerjaku.com/tele/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
	}

	@Test(priority = 1)
	public void testSPVLogin_validUsernamePassword() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage("developer", "23", "ok");
		delay(1);
		assertEquals(mainPage.getTextPopUp(), "Information");
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		assertEquals(mainPage.getTextMainPage(), "Tele Marketing");
		delay(1);
		mainPage.clickBtnLogoutAtMain();
		delay(1);
		assertEquals(mainPage.getTextPopUp(), "Logout");
		mainPage.logout();
		delay(1);
		assertEquals(loginPage.getTextLogin(), "[d] LOGIN");
	}

	@Test(priority = 2)
	public void testSPVLogin_validUsername_invalidPassword() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginToMainPage("developer", "400", "ok");
		delay(1);
		assertEquals(loginPage.txtPeringatanLogin.getText(), "Peringatan");
		delay(1);
		loginPage.btnOKPeringatan.click();
	}

	@Test(priority = 3)
	public void testSPVLogin_invalidUsernamePassword() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginToMainPage("mamam", "kue", "ok");
		delay(1);
		assertEquals(loginPage.txtPeringatanLogin.getText(), "Peringatan");
		delay(1);
		loginPage.btnOKPeringatan.click();
	}

	@Test(priority = 4)
	public void testSPVLogin_emptyUsernamePassword() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginToMainPage("", "", "ok");
		delay(1);
		assertEquals(loginPage.txtPeringatanLogin.getText(), "Peringatan");
		delay(1);
		loginPage.btnOKPeringatan.click();
	}

	@Test(priority = 5)
	public void testSPVLogin_validUsernamePassword_btnGreenAtUsername() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage("developer", "23", "username");
		delay(1);
		assertEquals(mainPage.getTextPopUp(), "Information");
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		assertEquals(mainPage.getTextMainPage(), "Tele Marketing");
		delay(1);
		mainPage.clickBtnLogoutAtMain();
		delay(1);
		assertEquals(mainPage.getTextPopUp(), "Logout");
		mainPage.logout();
		delay(1);
		assertEquals(loginPage.getTextLogin(), "[d] LOGIN");
	}

	@Test(priority = 6)
	public void testSPVLogin_validUsernamePassword_btnGreenAtPassword() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage("developer", "23", "password");
		delay(1);
		assertEquals(mainPage.getTextPopUp(), "Information");
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		assertEquals(mainPage.getTextMainPage(), "Tele Marketing");
		delay(1);
		mainPage.clickBtnLogoutAtMain();
		delay(1);
		assertEquals(mainPage.getTextPopUp(), "Logout");
		mainPage.logout();
		delay(1);
		assertEquals(loginPage.getTextLogin(), "[d] LOGIN");
	}

	@Test(priority = 7)
	public void testSPVLogin_navigateMainPage() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		MainPage mainPage = loginPage.loginToMainPage("developer", "23", "ok");
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		TaskNewPage newPage = mainPage.clickDataNew();
		delay(2);
		assertEquals(newPage.getTextNew(), "DATA NEW");
		delay(1);
		TaskAgreePage agreePage = mainPage.clickDataAgree();
		delay(2);
		assertEquals(agreePage.getTextAgree(), "DATA AGREE");
		delay(1);
		TaskFollowUpPage folUp = mainPage.clickDataFollowUp();
		delay(2);
		assertEquals(folUp.getTextFollowUp(), "DATA THINKING");
		delay(1);
		TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(2);
		assertEquals(allPage.getTextDataAll(), "DATA ALL");
		delay(1);
		TaskFinalPage finalPage = mainPage.clickTaskFinal();
		delay(2);
		assertEquals(finalPage.getTextFinal(), "DATA FINAL");
		delay(1);
		mainPage.clickBtnLogoutAtMain();
		delay(1);
		assertEquals(mainPage.getTextPopUp(), "Logout");
		mainPage.logout();
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}
