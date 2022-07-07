package com.telemarket.task.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskDataAllPage extends MainPage {

	protected WebDriver driver;

	public TaskDataAllPage(WebDriver driver) {
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

	public void clickAgent1() {
		selectAgent01DataAll.click();
	}
	
	@FindBy(xpath = "//option[@value='AGENT03']")
	protected WebElement selectAgent03DataAll;
	
	public void clickAgent3() {
		selectAgent03DataAll.click();
	}
	
	@FindBy(xpath = "//option[@value='AGENT07']")
	protected WebElement selectAgent07DataAll;
	
	public void clickAgent7() {
		selectAgent07DataAll.click();
	}
	
	@FindBy(xpath = "//option[@value='ridho']")
	protected WebElement selectAgentRidhoDataAll;
	
	public void clickAgentRidho() {
		selectAgentRidhoDataAll.click();
	}
	
	@FindBy(xpath = "//option[@value='Berhasil']")
	protected WebElement selectStatusBerhasil;
	
	public void clickStatusBerhasil() {
		selectStatusBerhasil.click();
	}
	
	@FindBy(xpath = "//option[@value='Follow Up']")
	protected WebElement selectStatusFollowUp;
	
	public void clickStatusFollowUp() {
		selectStatusFollowUp.click();
	}
	
	@FindBy(xpath = "//option[@value='Mailbox']")
	protected WebElement selectStatusMailbox;
	
	public void clickStatusMailbox() {
		selectStatusMailbox.click();
	}
	
	@FindBy(xpath = "//option[@value='Nomer Salah']")
	protected WebElement selectStatusNomerSalah;
	
	public void clickStatusNomerSalah() {
		selectStatusNomerSalah.click();
	}
	
	@FindBy(xpath = "//option[@value='Salah Sambung']")
	protected WebElement selectStatusSalahSambung;
	
	public void clickStatusSalahSambung() {
		selectStatusSalahSambung.click();
	}
	
	@FindBy(xpath = "//option[@value='Setuju']")
	protected WebElement selectStatusSetuju;
	
	public void clickStatusSetuju() {
		selectStatusSetuju.click();
	}
	
	@FindBy(xpath = "//option[@value='Tidak Ada Nomor Telepon']")
	protected WebElement selectStatusTidakAdaNomorTelepon;
	
	public void clickStatusTidakAdaNoTelp() {
		selectStatusTidakAdaNomorTelepon.click();
	}
	
	@FindBy(xpath = "//option[@value='Tidak Berhasil']")
	protected WebElement selectStatusTidakBerhasil;
	
	public void clickStatusTidakBerhasil() {
		selectStatusTidakBerhasil.click();
	}

	@FindBy(xpath = "//option[@value='Tidak Diangkat']")
	protected WebElement selectStatusTidakDiangkat;

	public void clickStatusTidakDiangkat() {
		selectStatusTidakDiangkat.click();
	}

	@FindBy(xpath = "//option[@value='Tidak Terdaftar']")
	protected WebElement selectStatusTidakTerdaftar;

	public void clickStatusTidakTerdaftar() {
		selectStatusTidakTerdaftar.click();
	}

	@FindBy(xpath = "//option[@value='Tolak']")
	protected WebElement selectStatusTolak;

	public void clickStatusTolak() {
		selectStatusTolak.click();
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
	
}
