package com.telemarket.report.pom;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.telemarket.utilities.CalendarViewFunction;
import com.telemarket.utilities.OtherFunc;

import org.openqa.selenium.interactions.Actions;

public class ReportCallTrackPage {

	protected WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor je;

	@FindBy(xpath = "//input[@value='REPORT CALL TRACK']")
	public WebElement txtReportCallTrack;
	@FindBy(xpath = "//span[contains(@class,'ui-dropdownchecklist-text')]")
	public WebElement dropdDownAgent;
	@FindBy(xpath = "//input[@value='AGENT01']")
	public WebElement agentDian;
	@FindBy(xpath = "//input[@value='AGENT03']")
	public WebElement agentRiska;
	@FindBy(xpath = "//label[normalize-space()='Katerina Evy Wurlianty']")
	public WebElement agentKate;
	@FindBy(xpath = "//label[normalize-space()='ridho']")
	public WebElement agentRidho;

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
	@FindBy(xpath = "//select[@class='nikitaentry nikitacombolistselect']")
	private WebElement selectAgent;

	public ReportCallTrackPage(WebDriver driver) {
		this.driver = driver;
	}

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getTxtReportCallTrack() {
		return txtReportCallTrack.getAttribute("value");
	}

	public void openDropDownAgent() {
		dropdDownAgent.click();
	}

	public void click1DropDownAgent() {
		agentRidho.click();
	}

	public void click2DropDownAgent() {
		agentRidho.click();
		agentRiska.click();
	}

	public void click3DropDownAgent() {
		agentRidho.click();
		agentRiska.click();
		agentDian.click();
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

	public boolean checkDataAgentCallTrack(String xpath, String agent) {
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		return other.verifDataNotArray(xpath, agent);
	}

	public void getAllDropDown() {
		String agent = isiDropDown.getText();
		String[] agentA = agent.split(" , ");
		openDropDownAgent();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//input[@value='REPORT CALL TRACK']"))).perform();
		delay(3);
		for (String i : agentA) {
			actions.moveToElement(driver.findElement(By.xpath("//label[normalize-space()='" + i + "']"))).perform();
			driver.findElement(By.xpath("//label[normalize-space()='" + i + "']")).click();
		}
		openDropDownAgent();
	}

	public void checkCallTrackAgentArray(String xpath, String[] agentA) {
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.verifDataOnlyInArray(xpath, agentA);
	}
	
	public void checkCallTrackAgentContains(String xpath, String agent) {
		OtherFunc other = PageFactory.initElements(driver, OtherFunc.class);
		other.verifDataContainsNotArray(xpath, agent);
	}

}
