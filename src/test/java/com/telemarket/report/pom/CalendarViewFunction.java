package com.telemarket.report.pom;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarViewFunction {

	public WebDriver driver;
	
	public int vGlobal;
	
	@FindBy(xpath = "//span[@class='ui-datepicker-month']")
	public WebElement txtGetMonth;
	@FindBy(xpath = "//span[@class='ui-datepicker-year']")
	public WebElement txtGetYear;
	@FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-w']")
	public WebElement prevYearBtn;
	@FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-e']")
	public WebElement nextYearBtn;

	public void delay(int inInt) {
		try {
			Thread.sleep(inInt * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public CalendarViewFunction(WebDriver driver) {
		this.driver = driver;
	}

	public void setDate(String dateUser) {
		
		String month = txtGetMonth.getText();
		String year = txtGetYear.getText();

		String tanggal = dateUser.substring(0, 2);
		String bulan = dateUser.substring(2, 4);
		String tahun = dateUser.substring(4, 8);

		int currentMonth;
		int currentYear = Integer.valueOf(year);

		switch (month) {
		case "January":
			currentMonth = 1;
			break;
		case "February":
			currentMonth = 2;
			break;
		case "March":
			currentMonth = 3;
			break;
		case "April":
			currentMonth = 4;
			break;
		case "May":
			currentMonth = 5;
			break;
		case "June":
			currentMonth = 6;
			break;
		case "July":
			currentMonth = 7;
			break;
		case "August":
			currentMonth = 8;
			break;
		case "September":
			currentMonth = 9;
			break;
		case "October":
			currentMonth = 10;
			break;
		case "November":
			currentMonth = 11;
			break;
		case "December":
			currentMonth = 12;
			break;
		default: currentMonth = 0;
		}
		
		int targetMonth = Integer.valueOf(bulan);
		int targetYear = Integer.valueOf(tahun);
		
		int stepYear = Math.abs(((currentYear-targetYear)*12));
		int stepMonth = Math.abs(currentMonth-targetMonth);
		
		int step;
		if(currentMonth < targetMonth) {
			step = Math.abs(stepYear-stepMonth);
		}
		else{
			step = Math.abs(stepYear+stepMonth);
		}
		
		if (currentYear < targetYear) {
			for (int z = 0; z < step; z++) {
				nextYearBtn.click();
			}
		} else if (currentYear > targetYear) {
			for (int y = 0; y < step; y++) {
				prevYearBtn.click();
			}
		}
		
		if(stepYear == 0) {
			if (currentMonth < targetMonth) {
				for (int z = 0; z < step; z++) {
					nextYearBtn.click();
				}
			} else if (currentMonth > targetMonth) {
				for (int y = 0; y < step; y++) {
					prevYearBtn.click();
				}
			}
		}
		
		int tanggalAngka = Integer.valueOf(tanggal);
		
		delay(2);

		driver.findElement(By.xpath("(//a[normalize-space()='" + tanggalAngka + "'])[1]")).click();
	}

}
