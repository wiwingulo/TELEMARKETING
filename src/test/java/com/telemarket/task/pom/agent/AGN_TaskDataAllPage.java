package com.telemarket.task.pom.agent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AGN_TaskDataAllPage extends AGN_MainPage {
	
	protected WebDriver driver;

	public AGN_TaskDataAllPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(id = "tl_all_data--53024_text")
	protected WebElement txtTaskDataAll;

	public String getTextDataAll() {
		return txtTaskDataAll.getAttribute("value");
	}
	
	@FindBy(id = "tl_all_data--53023_text")
	protected WebElement inputCustomerDataAll;
	
	public void setSearchAll(String in) {
		inputCustomerDataAll.sendKeys(in);
	}
	
	@FindBy(id = "tl_all_data--53023_finder")
	protected WebElement btnGreenCustomerDataAll;
	
	public void clickGreenSearchAll() {
		btnGreenCustomerDataAll.click();
	}
	
	@FindBy(xpath = "//option[@value='AGENT01']")
	protected WebElement selectAgent01DataAll;

	@FindBy(xpath = "//option[@value='AGENT03']")
	protected WebElement selectAgent03DataAll;
	
	@FindBy(xpath = "//option[@value='AGENT07']")
	protected WebElement selectAgent07DataAll;
	
	@FindBy(xpath = "//option[@value='ridho']")
	protected WebElement selectAgentRidhoDataAll;

	public void clickAgent(String in) {
		switch (in) {
		case "0":
			break;
		case "AGENT01":
			selectAgent01DataAll.click();
			break;
		case "AGENT03":
			selectAgent03DataAll.click();
			break;
		case "AGENT07":
			selectAgent07DataAll.click();
			break;
		case "ridho":
			selectAgentRidhoDataAll.click();
			break;
		default:
			break;
		}
	}
	
	@FindBy(xpath = "//option[@value='Berhasil']")
	protected WebElement selectStatusBerhasil;

	@FindBy(xpath = "//option[@value='Follow Up']")
	protected WebElement selectStatusFollowUp;
	
	@FindBy(xpath = "//option[@value='Mailbox']")
	protected WebElement selectStatusMailbox;

	@FindBy(xpath = "//option[@value='Nomer Salah']")
	protected WebElement selectStatusNomerSalah;
	
	@FindBy(xpath = "//option[@value='Salah Sambung']")
	protected WebElement selectStatusSalahSambung;
	
	@FindBy(xpath = "//option[@value='Setuju']")
	protected WebElement selectStatusSetuju;

	@FindBy(xpath = "//option[@value='Tidak Ada Nomor Telepon']")
	protected WebElement selectStatusTidakAdaNomorTelepon;

	@FindBy(xpath = "//option[@value='Tidak Berhasil']")
	protected WebElement selectStatusTidakBerhasil;

	@FindBy(xpath = "//option[@value='Tidak Diangkat']")
	protected WebElement selectStatusTidakDiangkat;

	@FindBy(xpath = "//option[@value='Tidak Terdaftar']")
	protected WebElement selectStatusTidakTerdaftar;
	
	@FindBy(xpath = "//option[@value='Tolak']")
	protected WebElement selectStatusTolak;
	
	public void clickStatus(String inString) {
		switch (inString) {
		case "0":
			break;
		case "Berhasil":
			selectStatusBerhasil.click();
			break;
		case "FollowUp":
			selectStatusFollowUp.click();
			break;
		case "Mailbox":
			selectStatusMailbox.click();
			break;
		case "NomerSalah":
			selectStatusNomerSalah.click();
			break;
		case "SalahSambung":
			selectStatusSalahSambung.click();
			break;
		case "Setuju":
			selectStatusSetuju.click();
			break;
		case "TidakAdaNomorTelepon":
			selectStatusTidakAdaNomorTelepon.click();
			break;
		case "TidakBerhasil":
			selectStatusTidakBerhasil.click();
			break;
		case "TidakDiangkat":
			selectStatusTidakDiangkat.click();
			break;
		case "TidakTerdaftar":
			selectStatusTidakTerdaftar.click();
			break;
		case "Tolak":
			selectStatusTolak.click();
			break;
		default:
			break;
		}
	}
	
	@FindBy(xpath = "//span[normalize-space()='Search']")
	protected WebElement btnSearch;
	
	public void clickSearchDataAll() {
		btnSearch.click();
	}
	
	@FindBy(xpath = "//span[normalize-space()='Export']")
	protected WebElement btnExport;
	
	public void clickExportDataAll() {
		btnExport.click();
	}
	
	@FindBy(xpath = "(//tr)[43]")
	protected WebElement topTable;

	public void clickTopTable() {
		topTable.click();
	}
	
	/////// ACTIVITY -------------
	@FindBy(id = "tl_user_activity--53043_text")
	protected WebElement txtAllActivity;

	public String getTextDataAllActivity() {
		return txtAllActivity.getAttribute("value");
	}
	
	@FindBy(xpath = "//span[@class='ui-button-icon-primary ui-icon ui-icon-close']")
	protected WebElement btnCloseAllActivity;
	
	public void closeDataAllActivity() {
		btnCloseAllActivity.click();
	}
	
	
	/////// PAGINATION ---------------------------
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
