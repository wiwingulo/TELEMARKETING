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
	
	public void delay(int inInt) {
		try {
			Thread.sleep(inInt*500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
	
	@FindBy(id = "53069_query")
	protected WebElement btnAddPhone;
	
	public void clickAddPhone(){
		btnAddPhone.click();
	}
	
///// PHONE WA --------------------------------------
	@FindBy(id = "tl_user_activity--53073_text")
	protected WebElement inputPhoneWA;

	@FindBy(id = "tl_user_activity--53071_text")
	protected WebElement inputPesanWA;

	@FindBy(xpath = "//span[normalize-space()='SEND WA']")
	protected WebElement btnSendWA;

	public void inputDataWA(String inPhone, String inMsg) {
		inputPhoneWA.clear();
		inputPhoneWA.sendKeys(inPhone);
		inputPesanWA.clear();
		inputPesanWA.sendKeys(inMsg);
		delay(1);
		btnSendWA.click();
	}
	
	@FindBy(id = "ui-id-17")
	protected WebElement btnMessageWA;
	
	public void clickMessageWA() {
		btnMessageWA.click();
	}
	
	@FindBy(xpath = "//span[normalize-space()='WA']")
	protected WebElement btnWA;
	
	public void clickWA() {
		btnWA.click();
	}
	
	@FindBy(id = "tl_data_message--52167-cell-0-1")
	protected WebElement txtMessageWA;
	
	public String getTextMessageWA() {
		return txtMessageWA.getText();
	}
	
	@FindBy(id = "tl_data_message--52167-cell-0-2")
	protected WebElement txtPhoneWA;
	
	public String getTextPhoneWA() {
		return txtPhoneWA.getText();
	}

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
	protected WebElement txtKonfirmasi; 

	public String getTextKonfirmasi() {
		return txtKonfirmasi.getText();
	}

	@FindBy(xpath = "//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']")
	protected WebElement btnCloseKonfirmasi;
	
	public void clickCloseKonfirmasi() {
		btnCloseKonfirmasi.click();
	}
	
	@FindBy(xpath = "//span[normalize-space()='OK']")
	protected WebElement btnSaveKonfirmasi;
	
	public void clickSaveKonfirmasi() {
		btnSaveKonfirmasi.click();
	}
	
	/////// STATUS ACTIVITY ------------------------------------------------
	@FindBy(xpath = "(//option[@value='Call'])[1]")
	protected WebElement btnChannel_Call;

	@FindBy(xpath = "//option[@value='Tersambung']")
	protected WebElement btnStatus_Tersambung;

	@FindBy(xpath = "(//option[@value='Diangkat'])[1]")
	protected WebElement btnStatusCall_Diangkat;

	@FindBy(xpath = "(//option[@value='Setuju'][normalize-space()='Setuju'])[2]")
	protected WebElement btnStatusResult_Setuju;

	@FindBy(xpath = "//option[@value='Berhasil Download']")
	protected WebElement btnReason_BerhasilDownload;

	@FindBy(xpath = "//option[@value='Follow Up Download']")
	protected WebElement btnReason_FollowUpDownload;

	@FindBy(xpath = "(//option[@value='Follow Up'][normalize-space()='Follow Up'])[2]")
	protected WebElement btnStatusResult_FollowUp;

	@FindBy(xpath = "(//option[@value='Telpon Kembali Lain Waktu'])[1]")
	protected WebElement btnReason_TelponKembali;

	@FindBy(xpath = "//option[@value='Request Kirim Whatsapp Untuk Dipelajari']")
	protected WebElement btnReason_RequestKirim;

	@FindBy(xpath = "//option[@value='Minta Nomer Manager/Pemilik']")
	protected WebElement btnReason_MintaNomer;

	@FindBy(xpath = "//option[@value='Minta Pendapat Partner/Pasangan/Orangtua']")
	protected WebElement btnReason_MintaPendapat;

	@FindBy(xpath = "(//option[@value='Follow Up'][normalize-space()='Follow Up'])[2]")
	protected WebElement btnReason_FollowUp;

	@FindBy(xpath = "//option[@value='Follow Convert']")
	protected WebElement btnReason_FollowConvert;

	@FindBy(xpath = "(//option[@value='Tolak'][normalize-space()='Tolak'])[2]")
	protected WebElement btnStatusResult_Tolak;

	@FindBy(xpath = "//option[@value='Tidak Bersedia Memberikan Kontak Owner']")
	protected WebElement btnReason_TidakBersedia;

	@FindBy(xpath = "//option[@value='Tidak Fokus Online']")
	protected WebElement btnReason_TidakFokus;

	@FindBy(xpath = "//option[@value='Tidak Tertarik, Tidak Memberi Alasan']")
	protected WebElement btnReason_TidakTertarik;

	@FindBy(xpath = "//option[@value='Tidak Mengerti dan Tidak Bersedia Dijelaskan']")
	protected WebElement btnReason_TidakMengerti;

	@FindBy(xpath = "//option[@value='Tidak Mengenal Tokko/Bukukas']")
	protected WebElement btnReason_TidakMengenal;

	@FindBy(xpath = "//option[@value='Rating/Comment Buruk Tokko di Sosial Media']")
	protected WebElement btnReason_RatingComment;

	@FindBy(xpath = "//option[@value='Tidak Mau Dipersulit Menggunakan Tokko']")
	protected WebElement btnReason_TidakMau;

	@FindBy(xpath = "//option[@value='Terlalu Banyak Aplikasi atau Platform']")
	protected WebElement btnReason_TerlaluBanyak;

	@FindBy(xpath = "//option[@value='Memory Handphone Penuh']")
	protected WebElement btnReason_MemoryHandphone;

	@FindBy(xpath = "//option[@value='Tidak Punya Android']")
	protected WebElement btnReason_TidakPunya;

	@FindBy(xpath = "//option[@value='Lebih Nyaman Dengan Platform Selain Tokko']")
	protected WebElement btnReason_LebihNyaman;

	@FindBy(xpath = "//option[@value='Usaha Sudah Tutup/Bangkrut']")
	protected WebElement btnReason_UsahaSudahTutup;

	@FindBy(xpath = "(//option[@value='Berhasil'][normalize-space()='Berhasil'])[2]")
	protected WebElement btnStatusResult_Berhasil;

	@FindBy(xpath = "(//option[@value='Berhasil'][normalize-space()='Berhasil'])[3]")
	protected WebElement btnReason_Berhasil;

	@FindBy(xpath = "(//option[@value='Tidak Berhasil'][normalize-space()='Tidak Berhasil'])[2]")
	protected WebElement btnStatusResult_TidakBerhasil;

	@FindBy(xpath = "(//option[@value='Tidak Berhasil'][normalize-space()='Tidak Berhasil'])[3]")
	protected WebElement btnReason_TidakBerhasil;

	@FindBy(xpath = "//option[@value='Salah Sambung']")
	protected WebElement btnStatusCall_SalahSambung;

	@FindBy(xpath = "(//option[@value='Salah Sambung'][normalize-space()='Salah Sambung'])[2]")
	protected WebElement btnStatusResult_SalahSambung;

	@FindBy(xpath = "(//option[@value='Salah Sambung'][normalize-space()='Salah Sambung'])[3]")
	protected WebElement btnReason_SalahSambung;

	@FindBy(xpath = "//option[@value='Tidak Diangkat']")
	protected WebElement btnStatusCall_TidakDiangkat;

	@FindBy(xpath = "(//option[@value='Tidak Diangkat'][normalize-space()='Tidak Diangkat'])[2]")
	protected WebElement btnStatusResult_TidakDiangkat;

	@FindBy(xpath = "(//option[@value='Tidak Diangkat'][normalize-space()='Tidak Diangkat'])[3]")
	protected WebElement btnReason_TidakDiangkat;

	@FindBy(xpath = "//option[@value='Tidak Tersambung']")
	protected WebElement btnStatus_TidakTersambung;

	@FindBy(xpath = "(//option[@value='Nomer Salah'][normalize-space()='Nomer Salah'])[1]")
	protected WebElement btnStatusCall_NomerSalah;

	@FindBy(xpath = "(//option[@value='Nomer Salah'][normalize-space()='Nomer Salah'])[2]")
	protected WebElement btnStatusResult_NomerSalah;

	@FindBy(xpath = "(//option[@value='Nomer Salah'][normalize-space()='Nomer Salah'])[3]")
	protected WebElement btnReason_NomerSalah;

	@FindBy(xpath = "//option[@value='Mailbox']")
	protected WebElement btnStatusCall_Mailbox;

	@FindBy(xpath = "(//option[@value='Mailbox'][normalize-space()='Mailbox'])[2]")
	protected WebElement btnStatusResult_Mailbox;

	@FindBy(xpath = "(//option[@value='Mailbox'][normalize-space()='Mailbox'])[3]")
	protected WebElement btnReason_Mailbox;

	@FindBy(xpath = "//option[@value='Invalid Number']")
	protected WebElement btnStatusCall_InvalidNumber;

	@FindBy(xpath = "(//option[@value='Tidak Ada Nomor Telepon'][normalize-space()='Tidak Ada Nomor Telepon'])[1]")
	protected WebElement btnStatusResult_TidakAda;

	@FindBy(xpath = "(//option[@value='Tidak Ada Nomor Telepon'][normalize-space()='Tidak Ada Nomor Telepon'])[2]")
	protected WebElement btnReason_TidakAda;

	@FindBy(xpath = "//option[@value='Telepon Not Register ']")
	protected WebElement btnStatusCall_TeleponNot;

	@FindBy(xpath = "(//option[@value='Tidak Terdaftar'][normalize-space()='Tidak Terdaftar'])[1]")
	protected WebElement btnStatusResult_TidakTerdaftar;

	@FindBy(xpath = "(//option[@value='Tidak Terdaftar'][normalize-space()='Tidak Terdaftar'])[2]")
	protected WebElement btnReason_TidakTerdaftar;

	@FindBy(xpath = "//option[@value='Whatsapp']")
	protected WebElement btnChannel_WA;

	public void clickStatus(String channel, String status, String statusCall, String statusResult, String reason) {
		switch (channel) {
		case "Call":
			btnChannel_Call.click();
			break;
		case "Whatsapp":
			btnChannel_WA.click();
			break;
		}
		switch (status) {
		case "Tersambung":
			btnStatus_Tersambung.click();
			delay(1);
			switch (statusCall) {
			case "Diangkat":
				btnStatusCall_Diangkat.click();
				delay(1);
				switch (statusResult) {
				case "Setuju":
					btnStatusResult_Setuju.click();
					delay(1);
					switch (reason) {
					case "Berhasil Download":
						btnReason_BerhasilDownload.click();
						break;
					case "Follow Up Download":
						btnReason_FollowUpDownload.click();
						break;
					default:
						break;
					}
					break;
				case "Follow Up":
					btnStatusResult_FollowUp.click();
					delay(1);
					switch (reason) {
					case "Telpon Kembali Lain Waktu":
						btnReason_TelponKembali.click();
						break;
					case "Request Kirim Whatsapp Untuk Dipelajari":
						btnReason_RequestKirim.click();
						break;
					case "Minta Nomer Manager/Pemilik":
						btnReason_MintaNomer.click();
						break;
					case "Minta Pendapat Partner/Pasangan/Orangtua":
						btnReason_MintaPendapat.click();
						break;
					case "Follow Up":
						btnReason_FollowUp.click();
						break;
					case "Follow Convert":
						btnReason_FollowConvert.click();
						break;
					default:
						break;
					}
					break;
				case "Tolak":
					btnStatusResult_Tolak.click();
					delay(1);
					switch (reason) {
					case "Tidak Bersedia Memberikan Kontak Owner":
						btnReason_TidakBersedia.click();
						break;
					case "Tidak Fokus Online":
						btnReason_TidakFokus.click();
						break;
					case "Tidak Tertarik, Tidak Memberi Alasan":
						btnReason_TidakTertarik.click();
						break;
					case "Tidak Mengerti dan Tidak Bersedia Dijelaskan":
						btnReason_TidakMengerti.click();
						break;
					case "Tidak Mengenal Tokko/Bukukas":
						btnReason_TidakMengenal.click();
						break;
					case "Rating/Comment Buruk Tokko di Sosial Media":
						btnReason_RatingComment.click();
						break;
					case "Tidak Mau Dipersulit Menggunakan Tokko":
						btnReason_TidakMau.click();
						break;
					case "Terlalu Banyak Aplikasi atau Platform":
						btnReason_TerlaluBanyak.click();
						break;
					case "Memory Handphone Penuh":
						btnReason_MemoryHandphone.click();
						break;
					case "Tidak Punya Android":
						btnReason_TidakPunya.click();
						break;
					case "Lebih Nyaman Dengan Platform Selain Tokko":
						btnReason_LebihNyaman.click();
						break;
					case "Usaha Sudah Tutup/Bangkrut":
						btnReason_UsahaSudahTutup.click();
						break;
					default:
						break;
					}
					break;
				case "Berhasil":
					btnStatusResult_Berhasil.click();
					delay(1);
					if (reason.equals("Berhasil")) {
						btnReason_Berhasil.click();
					}
					break;
				case "Tidak Berhasil":
					btnStatusResult_TidakBerhasil.click();
					delay(1);
					if (reason.equals("Tidak Berhasil")) {
						btnReason_TidakBerhasil.click();
					}
					break;
				default:
					break;
				}
				break;
			case "Salah Sambung":
				btnStatusCall_SalahSambung.click();
				delay(1);
				if (statusResult.equals("Salah Sambung")) {
					btnStatusResult_SalahSambung.click();
					delay(1);
					if (reason.equals("Salah Sambung")) {
						btnReason_SalahSambung.click();
					}
				}
				break;
			case "Tidak Diangkat":
				btnStatusCall_TidakDiangkat.click();
				delay(1);
				if (statusResult.equals("Tidak Diangkat")) {
					btnStatusResult_TidakDiangkat.click();
					delay(1);
					if (reason.equals("Tidak Diangkat")) {
						btnReason_TidakDiangkat.click();
					}
				}
				break;
			default:
				break;
			}
			break;
		case "Tidak Tersambung":
			btnStatus_TidakTersambung.click();
			delay(1);
			switch (statusCall) {
			case "Nomer Salah":
				btnStatusCall_NomerSalah.click();
				delay(1);
				if (statusResult.equals("Nomer Salah")) {
					btnStatusResult_NomerSalah.click();
					delay(1);
					if (reason.equals("Nomer Salah")) {
						btnReason_NomerSalah.click();
					}
				}
				break;
			case "Mailbox":
				btnStatusCall_Mailbox.click();
				delay(1);
				if (statusResult.equals("Mailbox")) {
					btnStatusResult_Mailbox.click();
					delay(1);
					if (reason.equals("Mailbox")) {
						btnReason_Mailbox.click();
					}
				}
				break;
			case "Invalid Number":
				btnStatusCall_InvalidNumber.click();
				delay(1);
				if (statusResult.equals("Tidak Ada Nomor Telepon")) {
					btnStatusResult_TidakAda.click();
					delay(1);
					if (reason.equals("Tidak Ada Nomor Telepon")) {
						btnReason_TidakAda.click();
					}
				}
				break;
			case "Telepon Not Register":
				btnStatusCall_TeleponNot.click();
				delay(1);
				if (statusResult.equals("Tidak Terdaftar")) {
					btnStatusResult_TidakTerdaftar.click();
					delay(1);
					if (reason.equals("Tidak Terdaftar")) {
						btnReason_TidakTerdaftar.click();
					}
				}
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
	}

	@FindBy(xpath = "//span[normalize-space()='SUBMIT']")
	protected WebElement btnSubmit;

	public void clickSubmit() {
		btnSubmit.click();
	}

	@FindBy(xpath = "//p[normalize-space()='Apakah Anda Yakin?']")
	protected WebElement checkPemberitahuan;

	public String getTextPemberitahuan() {
		return checkPemberitahuan.getText();
	}

	@FindBy(xpath = "//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick']")
	protected WebElement btnPemberitahuanClose;

	public void clickClosePemberitahuan() {
		btnPemberitahuanClose.click();
	}

	@FindBy(xpath = "//span[normalize-space()='NO']")
	protected WebElement btnPemberitahuanNO;

	public void clickNOPemberitahuan() {
		btnPemberitahuanNO.click();
	}

	@FindBy(xpath = "//span[normalize-space()='YES']")
	protected WebElement btnPemberitahuanYES;

	public void clickYESPemberitahuan() {
		btnPemberitahuanYES.click();
	}
	
	//////PEMBERITAHUAN STATUS GAGAL ------------------------------
	
	@FindBy(xpath = "(//p[normalize-space()='Status Result Wajib Diisi !'])[1]")
	protected WebElement txtPemberitahuan;
	
	public String getTextPemberitahuanGagal() {
		return txtPemberitahuan.getText();
	}
	
	@FindBy(xpath = "(//span[@class='ui-button-icon-primary ui-icon ui-icon-closethick'])[1]")
	protected WebElement btnClosePemberitahuanGagal;

	public void clickClosePemberitahuanGagal() {
		btnClosePemberitahuanGagal.click();
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
