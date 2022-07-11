package com.telemarket.utilities;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OtherFunc {

	public WebDriver driver;
	public Select page;
	public WebDriverWait wait;
	public JavascriptExecutor jse;

	@FindBy(xpath = "//select[@class='nikitacomboboxselect']")
	public WebElement optionShowPage;
	@FindBy(xpath = "(//select[@class='nikitacomboboxselect'])[2]")
	public WebElement altShowPage;
	
	public OtherFunc(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		jse = (JavascriptExecutor) driver;
	}

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean verifDataAgree(String xpathIsi) {
		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String status = webElement.getText();
			System.out.println(status);
			if (status.equalsIgnoreCase("AGREE")) {
				checkData = true;
			} else if (status.isBlank()) {
				break;
			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);

		return checkData;
	}

	public boolean verifActivityDate(String xpathIsi, String startDate, String endDate) {

		String tanggalAwal = startDate.substring(0, 2);
		String bulanAwal = startDate.substring(2, 4);
		String tahunAwal = startDate.substring(4, 8);
		String tanggalAkhir = endDate.substring(0, 2);
		String bulanAkhir = endDate.substring(2, 4);
		String tahunAkhir = endDate.substring(4, 8);

		String dateAwalS = tahunAwal + bulanAwal + tanggalAwal;
		String dateAkhirS = tahunAkhir + bulanAkhir + tanggalAkhir;

		int dateAwal = Integer.parseInt(dateAwalS);
		int dateAkhir = Integer.parseInt(dateAkhirS);

		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String actDateS = webElement.getText();

			String actDateThnS = actDateS.substring(0, 4);
			String actDateBlnS = actDateS.substring(5, 7);
			String actDateTglS = actDateS.substring(8, 10);

			actDateS = actDateThnS + actDateBlnS + actDateTglS;

			int actDate = Integer.valueOf(actDateS);
		
			if (actDate < dateAkhir && actDate > dateAwal) {
				checkData = true;
			} else if (actDateS.isBlank()) {
				break;
			} else {
				checkData = false;
			}
		}
		assertTrue(checkData);
		return checkData;
	}

	public boolean verifDataArray(String xpathIsi, String refArray[]) {
		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		boolean finalCheckData = false;
		for (WebElement webElement : lstElement) {
			finalCheckData = false;
			String isiElement = webElement.getText();
			System.out.println(isiElement);
			for (String i : refArray) {
				if (isiElement.equalsIgnoreCase(i)) {
					checkData = true;
				} else if (isiElement.isBlank()) {
					break;
				} else {
					checkData = false;
				}
				if (checkData = true) {
					finalCheckData = true;
				}
			}
		}

		assertTrue(finalCheckData);
		
		return finalCheckData;
	}
	
	public boolean verifDataOnlyInArray(String xpathIsi, String refArray[]) {
		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		boolean finalCheckData = false;
		boolean shouldNotExist = false;
		for (WebElement webElement : lstElement) {
			finalCheckData = false;
			shouldNotExist = false;
			String isiElement = webElement.getText();
			System.out.println(isiElement);
			for (String i : refArray) {
				if (isiElement.equalsIgnoreCase(i)) {
					checkData = true;
					shouldNotExist = true;
//				} else if (isiElement.isBlank()) {
//					break;
				} else {
					checkData = false;
				}
				if (checkData = true) {
					finalCheckData = true;
				}
			}
			if (shouldNotExist == false) {
				break;
			}
		}
		if(shouldNotExist == false) {
			assertTrue(shouldNotExist);
		}
		else {
			assertTrue(finalCheckData);
	
		}
		return finalCheckData;
	}
	
	public boolean verifDataNotArray(String xpathIsi, String refData) {
		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String isiElement = webElement.getText();
			System.out.println(isiElement);
			if (isiElement.equalsIgnoreCase(refData)) {
				checkData = true;
			} 
			else if (isiElement.isBlank()) {
				break;
			} 
			else {
				checkData = false;
			}
		}
		assertTrue(checkData);

		return checkData;
	}
	
	public boolean verifDataContainsNotArray(String xpathIsi, String refData) {
		delay(3);
		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String isiElement = webElement.getText().toLowerCase();
			System.out.println(isiElement);
			if (isiElement.contains(refData.toLowerCase())) {
				checkData = true;
			} 
//			else if (isiElement.isBlank()) {
//				break;
//			} 
			else {
				checkData = false;
			}
		}
		assertTrue(checkData);

		return checkData;
	}
	
	public void selectShowPage(String jmlBaris) {
		delay(2);
		jse.executeScript("window.scrollBy(0,1000)");
		jse.executeScript("arguments[0].scrollIntoView(true);", optionShowPage);
		delay(2);
		this.page = new Select(optionShowPage);
		this.page.selectByValue(jmlBaris);
	}
	
	public void showPageFunc(String jmlBaris) {
		delay(1);
		scrollToElement(driver.findElement(By.xpath("//option[@value='" + jmlBaris + "']")));
		delay(1);
		driver.findElement(By.xpath("//option[@value='"+ jmlBaris +"']")).click();
	}
	
	public void moveToFunc(String xpath) {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath(xpath))).perform();
	}
	
	public void scrollToElement(WebElement element) {
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public int verifDataRow() {
		delay(2);
		List<WebElement> lstElement = driver.findElements(By.xpath("//div[6]/table[1]/tbody[1]/tr/td[1]"));
		int jmlRow = 0;
		boolean checkData = false;
		for (WebElement webElement : lstElement) {
			String isiElement = webElement.getText();
			jmlRow++;
			System.out.println(jmlRow);
		}
		return jmlRow;
	}
	
	public void changePage(String page) {
		delay(1);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@href,'#')][normalize-space()='" + page + "'])[1]")));
		driver.findElement(By.xpath("(//a[contains(@href,'#')][normalize-space()='" + page + "'])[1]")).click();
		delay(1);
	}
	
	public void verifPage(String page) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[6]/table[1]/tbody[1]/tr[10]/td[1]")));
		String isiUrutanS = driver.findElement(By.xpath("//div[6]/table[1]/tbody[1]/tr[10]/td[1]")).getText();
		System.out.println(isiUrutanS);
		int isiUrutan = Integer.parseInt(isiUrutanS);
		System.out.println(isiUrutan);
		int actualPage = isiUrutan/10;
		int clickedPage = Integer.parseInt(page);
		assertEquals(actualPage, clickedPage);
	}
	
	public void verifPageLast(String xpathLast) {
		delay(1);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLast)));
		String lastPageS = driver.findElement(By.xpath(xpathLast)).getText();
		String isiUrutanS = driver.findElement(By.xpath("//div[6]/table[1]/tbody[1]/tr[1]/td[1]")).getText();
		System.out.println(isiUrutanS);
		int isiUrutan = Integer.parseInt(isiUrutanS);
		int lastPage = Integer.parseInt(lastPageS);
		System.out.println(isiUrutan);
		System.out.println(lastPage);
		int actual = isiUrutan/lastPage;
		assertTrue(actual <= 10 && actual >=1);
	}
	
	public String screenShot() {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String waktu = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String namaFile = "C:\\Users\\Nexsoft\\eclipse-workspace\\TELEMARKETING\\hasilScreenshot\\" + waktu + ".png";
		File screenshot = new File(namaFile);
		try {
			FileUtils.copyFile(srcFile, screenshot);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return namaFile;
	}

}
