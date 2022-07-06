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



import org.openqa.selenium.interactions.Actions;

public class ReportCallTrack {

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
	@FindBy(xpath = "//label[normalize-space()='Rika Nurul Khotimah']")
	public WebElement agentRika;
	@FindBy(xpath = "//label[normalize-space()='Cici Amelia']")
	public WebElement agentCici;
	@FindBy(xpath = "//input[@value='AGENT05']")
	public WebElement agentAhmad;

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

	public ReportCallTrack(WebDriver driver) {
		this.driver = driver;
	}

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getTxtReportActivity() {
		return txtReportCallTrack.getAttribute("value");
	}

	public void openDropDownAgent() {
		dropdDownAgent.click();
	}

	public void click1DropDownAgent() {
		agentCici.click();
	}

	public void click2DropDownAgent() {
		agentCici.click();
		agentRiska.click();
	}

	public void click3DropDownAgent() {
		agentCici.click();
		agentRiska.click();
		agentRika.click();
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
		return other.verifDataAgentNotArray(xpath, agent);
	}

	public void scrollToAgentCici() {
		je.executeScript("arguments[0].scrollIntoView(true);", agentCici);
		agentCici.click();
	}

	public void getAllDropDown() {
		Actions actions = new Actions(driver);
		String agent = isiDropDown.getText();
		String[] agentA = agent.split(" , ");
		openDropDownAgent();
		actions.moveToElement(driver.findElement(By.xpath("//input[@value='REPORT CALL TRACK']"))).perform();
		delay(3);
		agentAhmad.click();
		for (String i : agentA) {
			if (!i.equals("Ahmad Fajri Saleh")) {
				actions.moveToElement(driver.findElement(By.xpath("//label[normalize-space()='" + i + "']"))).perform();
				driver.findElement(By.xpath("//label[normalize-space()='" + i + "']")).click();
			}
		}
		openDropDownAgent();
	}

	public void checkCallTrack2Agent(String xpathIsi) {
		delay(3);

		List<WebElement> lstElement = driver.findElements(By.xpath(xpathIsi));

		openDropDownAgent();
		String agent1 = agentCici.getAttribute("value");
		String agent2 = agentDian.getAttribute("value");

		boolean checkData = false;
		boolean finalCheckData = false;
		boolean shouldNotExistData = true;
		for (WebElement webElement : lstElement) {
			String agent = webElement.getText();

			if (agent.equalsIgnoreCase(agent1)) {
				checkData = true;
			} else if (agent.equalsIgnoreCase(agent2)) {
				checkData = true;
			} else if (agent.isBlank()) {
				break;
			} else {
				checkData = false;
			}
			if (!agent.equalsIgnoreCase(agent1)) {
				shouldNotExistData = false;
			} else if (!agent.equalsIgnoreCase(agent2)) {
				shouldNotExistData = false;
				if (checkData = true) {
					finalCheckData = true;
				}
				if (shouldNotExistData = false) {
					finalCheckData = false;
				}
			}
			assertTrue(finalCheckData);

		}
	}

}
