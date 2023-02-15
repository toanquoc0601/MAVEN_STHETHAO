package com.chanvietnam.net;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class register_allin_tai extends AbstractPage {

	WebDriver driver;

	String userName;
	String passWord = "quoc782442";
	String phoneNumber = "090500000";
	@Parameters({ "userName1"})
	@BeforeClass
	public void beforeClass(String userName1) {
		userName = userName1;
	}
	@Test
	public void TC_01_Check_Betting() {
		for (int i = 1; i < 11; i++) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://chanvietnam.net/");
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			//driver.manage().window().maximize();

			clickToElement(driver, "(//img[@id='bt_dangki'])[1]");
			sendkeyToElement(driver, "(//input[@id='textfield_username_dangki'])[1]", userName + i + "@gmail.com");
			sendkeyToElement(driver, "(//input[@id='textfield_pass_dangki'])[1]", passWord);
			sendkeyToElement(driver, "(//input[@id='textfield_confirmpass_dangki'])[1]", passWord);
			clickToElement(driver, "(//img[@id='bt_dangki'])[1]");
			
			if (!CheckLoading()) {
			}
			else {
				refreshToPage(driver);
				acceptAlert(driver);
				refreshToPage(driver);
				sleepInSecond(1);
				refreshToPage(driver);
				driver.get("https://chanvietnam.net/");
			}
			clickToElement(driver, "//img[@id='iframe_close']");
			clickToElement(driver, "(//input[@id='lobby_displayname_tfdisPlayname'])[1]");
			sendkeyToElement(driver, "(//input[@id='lobby_displayname_tfdisPlayname'])[1]", userName + i);
			clickToElement(driver, "(//img[@id='lobby_displayName_bt_dongy'])[1]");
			clickToElement(driver, "(//img[@id='lobby_updateInfo_selectNamOff'])[1]");
			sendkeyToElement(driver, "//input[@id='lobby_updateInfo_date']", "15");
			sendkeyToElement(driver, "//input[@id='lobby_updateInfo_month']", "05");
			sendkeyToElement(driver, "//input[@id='lobby_updateInfo_year']", "1996");
			sendkeyToElement(driver, "//input[@id='lobby_updateInfo_tfSDT']", phoneNumber + i);
			sendkeyToElement(driver, "//input[@id='lobby_updateInfo_tfEmail']", userName + i + "@gmail.com");
			clickToElement(driver, "//img[@id='lobby_updateInfo_bt_dongy']");
			clickToElement(driver, "//img[@id='popup_dong']");
			clickToElement(driver, "//img[@id='bt_lobby_taixiu']");
			clickToElement(driver, "//div[@id='infoBetTai']//span[@id='txtContent']");
			clickToElement(driver, "//img[@id='btnTatTay']");
			clickToElement(driver, "//img[@id='btnBet']");
			driver.quit();
		}
	}
	public boolean CheckLoading() {
		try {
			getElement(driver, "//img[@src='res/loadingicon.png']").isDisplayed();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
