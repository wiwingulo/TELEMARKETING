package com.telemarket.task.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskFinalPage extends MainPage {

	protected WebDriver driver;

	public TaskFinalPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(id = "tl_final--52228_text")
	protected WebElement txtTaskFinal;

	public String getTextFinal() {
		return txtTaskFinal.getAttribute("value");
	}
	
	@FindBy(id = "tl_final--52227_text")
	protected WebElement inputSearchFinal;
	
	public void setSearchFinal(String in) {
		inputSearchFinal.sendKeys(in);
	}
	
	@FindBy(id = "tl_final--52227_finder")
	protected WebElement btnGreenFinal;
	
	public void clickGreenSearchFinal() {
		btnGreenFinal.click();
	}
	
	@FindBy(xpath = "//span[normalize-space()='Search']")
	protected WebElement btnSearchFinal;
	
	public void clickSearchFinal() {
		btnSearchFinal.click();
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
