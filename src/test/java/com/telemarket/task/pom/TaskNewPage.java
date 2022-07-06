package com.telemarket.task.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskNewPage extends MainPage {

	protected WebDriver driver;

	public TaskNewPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(id = "tl_data_new--52964_text")
	protected WebElement txtDataNew;

	public String getTextNew() {
		return txtDataNew.getAttribute("value");
	}

	@FindBy(id = "tl_data_new--52963_text")
	protected WebElement inputSearchNew;

	@FindBy(id = "52969_query")
	protected WebElement btnSearchNew;

	public void searchDataNew(String inString) {
		inputSearchNew.clear();
		inputSearchNew.sendKeys(inString);
		btnSearchNew.click();
	}

	@FindBy(xpath = "(//button[@id='52971_query'])[1]")
	protected WebElement btnExportNew;

	public void clickExportNew() {
		btnExportNew.click();
	}

	@FindBy(xpath = "(//tr)[41]")
	protected WebElement topTable;

	public void clickTopTable() {
		topTable.click();
	}

	/////// ACTIVITY  -----------------------------------------------------------------
	@FindBy(id = "tl_user_activity--53043_text")
	protected WebElement txtNewActivity;

	public String getTextNewActivity() {
		return txtNewActivity.getAttribute("value");
	}

	@FindBy(id = "tl_user_activity--53053_text")
	protected WebElement txtNewActName;

	public String getTextNewActname() {
		return txtNewActName.getAttribute("value");
	}

	@FindBy(xpath = "//span[@class='ui-button-icon-primary ui-icon ui-icon-close']")
	public WebElement btnCloseNewActivity;

	@FindBy(xpath = "//option[@value='087796678733']")
	public WebElement setPhone;

	@FindBy(id = "53069_query")
	public WebElement btnAddPhone;

	/////// MULTI ADD PHONE -------------------
	@FindBy(id = "(//td)[68]")
	public WebElement txtMultiAddPhone; // Request_Phone_

	@FindBy(id = "51839_query")
	public WebElement btnSaveMultiAddPhone;

	@FindBy(id = "tl_multi_add_phone--51838_text")
	protected WebElement inputMultiAddPhone;

	public void setTextMultiAddPhone(String in) {
		inputMultiAddPhone.sendKeys(in);
	}

	@FindBy(xpath = "(//span[@class='ui-button-icon-primary ui-icon ui-icon-close'])[2]")
	protected WebElement btnCloseMultiAddPhone;

	public void clickCloseMultiAddPhone() {
		btnCloseMultiAddPhone.click();
	}

	@FindBy(id = "ui-id-21")
	protected WebElement txtKonfirmasi; // tak terpakai

	@FindBy(xpath = "//p[normalize-space()='Data Berhasil Diajukan!']")
	public WebElement txtDataKonfirmasi;

	public String getTextKonfirmasi() {
		return txtDataKonfirmasi.getText();
	}

	@FindBy(xpath = "//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']")
	public WebElement btnCloseKonfirmasi;

	@FindBy(xpath = "(//button[@role='button'])[34]")
	public WebElement btnSaveKonfirmasi;

	/////// PAGINATION
	/////// -----------------------------------------------------------------
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

	@FindBy(xpath = "(//td[contains(text(),'10')])[3]")
	public WebElement check10;
	@FindBy(xpath = "(//td[contains(text(),'25')])[3]")
	public WebElement check25;
	@FindBy(xpath = "(//td[contains(text(),'50')])[3]")
	public WebElement check50;
	@FindBy(xpath = "(//td[contains(text(),'100')])[3]")
	public WebElement check100;
	@FindBy(xpath = "(//td[contains(text(),'500')])[3]")
	public WebElement check500;

	@FindBy(xpath = "(//a[@href='#'][normalize-space()='<<'])[1]")
	protected WebElement btnFirstPagination;
	@FindBy(xpath = "(//a[@href='#'][normalize-space()='>>'])[1]")
	protected WebElement btnLastPagination;
	@FindBy(xpath = "(//a[@href='#'][normalize-space()='1'])[1]")
	protected WebElement btnPage1;
	@FindBy(xpath = "(//a[@href='#'][normalize-space()='2'])[1]")
	protected WebElement btnPage2;
	@FindBy(xpath = "(//a[@href='#'][normalize-space()='3'])[1]")
	protected WebElement btnPage3;
	@FindBy(xpath = "(//a[@href='#'][normalize-space()='4'])[1]")
	protected WebElement btnPage4;
	@FindBy(xpath = "(//a[@href='#'][normalize-space()='5'])[1]")
	protected WebElement btnPage5;
	@FindBy(xpath = "(//a[@href='#'][normalize-space()='6'])[1]")
	protected WebElement btnPage6;

	public void clickFirstPagination() {
		btnFirstPagination.click();
	}

	public void clickLastPagination() {
		btnLastPagination.click();
	}

	public void clickPage1() {
		btnPage1.click();
	}

	public void clickPage2() {
		btnPage2.click();
	}

	public void clickPage3() {
		btnPage3.click();
	}

	public void clickPage4() {
		btnPage4.click();
	}

	public void clickPage5() {
		btnPage5.click();
	}

	public void clickPage6() {
		btnPage6.click();
	}

}
