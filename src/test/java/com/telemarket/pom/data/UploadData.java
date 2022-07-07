package com.telemarket.pom.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadData {

	public WebDriver driver;

	@FindBy(xpath = "//input[@id='tl_upload_new--52043_text']")
	public WebElement btnUpload;

	@FindBy(xpath = "//span[normalize-space()='Upload']")
	public WebElement btnUploadExcel;

	@FindBy(xpath = "//span[normalize-space()='Simpan']")
	public WebElement btnSimpan;

	@FindBy(xpath = "(//span[normalize-space()='SIMPAN'])[1]")
	public WebElement btnSimpan1;

	@FindBy(xpath = "/html[1]/body[1]/div[8]/div[3]/div[1]/button[1]/span[1]")
	public WebElement btnOKUpload;

	@FindBy(xpath = "(//span[normalize-space()='OK'])[1]")
	public WebElement btnOkWrongData;

	@FindBy(xpath = "(//li)[3]")
	public WebElement btn2;

	@FindBy(xpath = "(//li)[4]")
	public WebElement btn3;

	@FindBy(xpath = "(//li)[5]")
	public WebElement btn4;

	@FindBy(xpath = "(//li)[6]")
	public WebElement btn5;

	@FindBy(xpath = "(//li)[7]")
	public WebElement lastStep;

	@FindBy(xpath = "(//li)[1]")
	public WebElement firstStep;

	@FindBy(xpath = "(//select[@id='tl_upload_new--52045_show_text'])[1]")
	public WebElement showPage;

	@FindBy(xpath = "//option[@value='10']")
	protected WebElement value10;
	@FindBy(xpath = "//option[@value='25']")
	protected WebElement value25;
	@FindBy(xpath = "//option[@value='50']")
	protected WebElement value50;
	@FindBy(xpath = "//option[@value='100']")
	protected WebElement value100;
	@FindBy(xpath = "//option[@value='500']")
	protected WebElement value500;

	

	public UploadData(WebDriver driver) {
		this.driver = driver;
	}

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void uploadData() {
		btnUpload.sendKeys("D:\\Data.xlsx");
		delay(10);
		btnUploadExcel.click();
		delay(5);
		btnSimpan.click();
		delay(2);
		btnSimpan1.click();
		delay(5);
		btnOKUpload.click();
		delay(5);
	}

	public void uploadDataWrongFormat() {
		btnUpload.sendKeys("D:\\testdata.png");
		delay(10);
		btnUploadExcel.click();
		delay(5);
		btnOkWrongData.click();
	}

	public void testButtonPage() {
		btn2.click();
		delay(1);
		btn3.click();
		delay(1);
		btn4.click();
		delay(1);
		btn5.click();
		delay(1);
		lastStep.click();
		delay(1);
		firstStep.click();
		delay(1);
	}
	
	public void viewTable(int in) {
		switch (in) {
		case 10:
			value10.click();
			break;
		case 25:
			value25.click();
			break;
		case 50:
			value50.click();
			break;
		case 100:
			value100.click();
			break;
		case 500:
			value500.click();
			break;
		default:
			break;
		}
	}
}
