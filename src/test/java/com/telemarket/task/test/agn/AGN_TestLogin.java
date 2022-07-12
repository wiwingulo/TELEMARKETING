package com.telemarket.task.test.agn;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.telemarket.task.pom.agent.AGN_LoginPage;
import com.telemarket.task.pom.agent.AGN_MainPage;
import com.telemarket.task.pom.agent.AGN_TaskAgreePage;
import com.telemarket.task.pom.agent.AGN_TaskDataAllPage;
import com.telemarket.task.pom.agent.AGN_TaskFinalPage;
import com.telemarket.task.pom.agent.AGN_TaskFollowUpPage;
import com.telemarket.task.pom.agent.AGN_TaskNewPage;
import com.telemarket.task.test.Utility;


public class AGN_TestLogin extends Utility {
	
	protected WebDriver driver;
	String uname_login = "agent01"; 
	String pass_login = "1";

	@BeforeMethod
	public void cekSession() {
		System.setProperty("url", "https://sqa.peluangkerjaku.com/tele/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
	}

	@Test(priority = 1)
	public void testAGNLogin_validUsernamePassword() {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage(uname_login, pass_login, "ok");
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
	public void testAGNLogin_validUsername_invalidPassword() {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		loginPage.loginToMainPage("agent01", "400", "ok");
		delay(1);
		assertEquals(loginPage.txtPeringatanLogin.getText(), "Peringatan");
		delay(1);
		loginPage.btnOKPeringatan.click();
	}

	@Test(priority = 3)
	public void testAGNLogin_invalidUsernamePassword() {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		loginPage.loginToMainPage("mamam", "kue", "ok");
		delay(2);
		assertEquals(loginPage.txtPeringatanLogin.getText(), "Peringatan");
		delay(1);
		loginPage.btnOKPeringatan.click();
	}

	@Test(priority = 4)
	public void testAGNLogin_emptyUsernamePassword() {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		loginPage.loginToMainPage("", "", "ok");
		delay(1);
		assertEquals(loginPage.txtPeringatanLogin.getText(), "Peringatan");
		delay(1);
		loginPage.btnOKPeringatan.click();
	}

	@Test(priority = 5)
	public void testAGNLogin_validUsernamePassword_btnGreenAtUsername() {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage(uname_login, pass_login, "username");
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
	public void testAGNLogin_validUsernamePassword_btnGreenAtPassword() {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage(uname_login, pass_login, "password");
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
	
	@Test(priority=7)
	public void testAGNLogin_navigateMainPage() {
		AGN_LoginPage loginPage = PageFactory.initElements(driver, AGN_LoginPage.class);
		AGN_MainPage mainPage = loginPage.loginToMainPage(uname_login, pass_login, "ok");
		delay(1);
		mainPage.clickOKPopUpAfterLogin();
		delay(1);
		mainPage.clickTask();
		delay(1);
		AGN_TaskNewPage newPage = mainPage.clickDataNew();
		delay(2);
		assertEquals(newPage.getTextNew(),"DATA NEW");
		delay(1);
		AGN_TaskAgreePage agreePage = mainPage.clickDataAgree();
		delay(2);
		assertEquals(agreePage.getTextAgree(),"DATA AGREE");
		delay(1);
		AGN_TaskFollowUpPage folUp = mainPage.clickDataFollowUp();
		delay(2);
		assertEquals(folUp.getTextFollowUp(),"DATA THINKING");
		delay(1);
		AGN_TaskDataAllPage allPage = mainPage.clickTaskAll();
		delay(2);
		assertEquals(allPage.getTextDataAll(),"DATA ALL");
		delay(1);
		AGN_TaskFinalPage finalPage = mainPage.clickTaskFinal();
		delay(2);
		assertEquals(finalPage.getTextFinal(),"DATA FINAL");
		delay(1);
		mainPage.clickBtnLogoutAtMain();
		delay(1);
		assertEquals(mainPage.getTextPopUp(), "Logout");
		mainPage.logout();
	}
	
	@AfterMethod
	public void close(){
		driver.close();
	}
}
