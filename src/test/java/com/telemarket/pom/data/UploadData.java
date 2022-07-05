package com.telemarket.pom.data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadData {

	protected WebDriver driver;
	//input[@id='tl_upload_new--52043_text']
	@FindBy(xpath = "//tbody/tr/td/form[@id='tl_upload_new--52043_form']/div/div[1]")
	public WebElement btnUpload;
	
	@FindBy(id = "52044_query")
	public WebElement btnUploadExcel;
	
	@FindBy(xpath = "//span[normalize-space()='Simpan']")
	public WebElement btnSimpan;
	
	@FindBy(xpath = "(//span[normalize-space()='SIMPAN'])[1]")
	public WebElement btnSimpan1;
	
	@FindBy(xpath = "(//span[normalize-space()='OK'])[1]")
	public WebElement btnOKUpload;
	
	public UploadData (WebDriver driver) {
		this.driver=driver;
	}

}
