package com.telemarket.test;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.telemarket.pom.data.Dashboard;
import com.telemarket.pom.data.EditData;
import com.telemarket.pom.data.LoginPage;
import com.telemarket.pom.data.MainPage;
import com.telemarket.pom.data.UploadData;

public class EditDataTest {
	
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected MainPage mainPage;
	protected Dashboard dash;
	protected UploadData upload;
	protected EditData edit;
	
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
		edit = new EditData(driver);
		dash = new Dashboard(driver);
		upload = new UploadData(driver);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
	}
	
	@DataProvider(name = "validData")
	public Object[] validData() {
		Object[] myData = { "somad2" , "medan" , "puji"};
		return myData;
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

	@Test(priority = 2, dataProvider = "validData")
	public void test_search_valid(String in) {
		Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
		EditData edit = PageFactory.initElements(driver, EditData.class);
		delay(2);
		dash.btnData.click();
		delay(1);
		dash.btnEditData.click();
		delay(1);
		edit.searchDataNew(in);
		delay(4);
		List<WebElement> lstElement = driver.findElements(By.xpath("(//tr)[40]"));
		String expectedChar = in;
		boolean check = false;
		for (WebElement webElement : lstElement) {
			if (webElement.getText().contains(expectedChar)) {
				System.out.println(in);
				check = true;
				delay(3);
				break;
			}
		}
		//td[@id='tl_user_management--51688-cell-0-2']
		assertTrue(check);
		delay(3);
		dash.btnData.click();
	}
}
