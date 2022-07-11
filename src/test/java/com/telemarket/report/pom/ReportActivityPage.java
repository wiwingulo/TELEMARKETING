package com.telemarket.report.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.telemarket.utilities.CalendarViewFunction;
import com.telemarket.utilities.OtherFunc;



public class ReportActivityPage {

	protected WebDriver driver;
	
	@FindBy(xpath = "//input[@value='PERFORM REPORT']")
	public WebElement txtReportActivity;
	@FindBy(xpath = "//span[contains(@class,'ui-dropdownchecklist-text')]")
	public WebElement dropdDownAgent;
	@FindBy(xpath = "//label[normalize-space()='ADMIN']")
	public WebElement agentAdmin;
	@FindBy(xpath = "//label[normalize-space()='AGENT01']")
	public WebElement agent01;
	@FindBy(xpath = "//label[normalize-space()='AGENT03']")
	public WebElement agent03;
	@FindBy(xpath = "//label[normalize-space()='AGENT07']")
	public WebElement agent07;
	@FindBy(xpath = "//label[normalize-space()='DEVELOPER']")
	public WebElement agentDeveloper;
	@FindBy(xpath = "//label[normalize-space()='ridho']")
	public WebElement agentRidho;
	@FindBy(xpath = "//label[normalize-space()='SPV01']")
	public WebElement agentSPV01;
	
	@FindBy(xpath = "//span[normalize-space()='View']")
	public WebElement btnView;
	@FindBy(xpath = "//span[normalize-space()='Export']")
	public WebElement btnExport;
	
	@FindBy(xpath = "(//img[@alt='Nikita Gebnerator'])[1]")
	public WebElement btnStartDate;
	@FindBy(xpath = "(//img[@alt='Nikita Gebnerator'])[2]")
	public WebElement btnEndDate;
	
	@FindBy(xpath = "//span[@class='ui-dropdownchecklist-text']")
	public WebElement isiDropDown;
	
	
	public ReportActivityPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTxtReportActivity() {
		return txtReportActivity.getAttribute("value");
	}
	
	public void openDropDownAgent() {
		dropdDownAgent.click();
	}
	
	public void click1DropDownAgent() {
		agentAdmin.click();
	}
	
	public void click2DropDownAgent() {
		agentAdmin.click();
		agent01.click();
	}
	
	public void click3DropDownAgent() {
		agentAdmin.click();
		agent01.click();
		agent03.click();
	}
	
	public void clickAllDropDownAgent() {
		agentAdmin.click();
		agent01.click();
		agent03.click();
		agent07.click();
		agentDeveloper.click();
		agentRidho.click();
		agentSPV01.click();
	}
	
	public void clickView() {
		btnView.click();
	}
	
	public void clickExport() {
		btnExport.click();
	}
	
	public void setStartDate(String date) {
		btnStartDate.click();
		CalendarViewFunction calendar = PageFactory.initElements(driver, CalendarViewFunction.class);
		calendar.setDate(date);
	}
	
	public void setEndDate(String date) {
		btnEndDate.click();
		CalendarViewFunction calendar = PageFactory.initElements(driver, CalendarViewFunction.class);
		calendar.setDate(date);
	}
	
	public void checkDataAgentActivity(String xpath, String agentA[]) {
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.verifDataOnlyInArray(xpath, agentA);
	}
	
	public void checkDataAgentActivityContains(String xpath, String agent) {
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.verifDataContainsNotArray(xpath, agent);
	}
	
	public void checkActivityDate(String xpath, String startDate, String endDate) {
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.verifActivityDate(xpath, startDate, endDate);
	}
	
	
	
}
