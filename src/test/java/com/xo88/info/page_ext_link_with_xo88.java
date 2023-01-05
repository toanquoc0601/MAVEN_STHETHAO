package com.xo88.info;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.xo88_AccountPageObject;
import pageObjects.xo88_HomePageObject;
import pageObjects.xo88_PageGeneratorManager;
import pageUIs.HomePageUI;

public class page_ext_link_with_xo88 extends AbstractTest {

	WebDriver driver;
	xo88_HomePageObject homepage;
	xo88_AccountPageObject accountpage;
	String userNameXo88;

	String userName = "kakute05";
	String password = "Quoc782442";
	String tournamentName;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://xo88.info/");
	}

	@Test
	public void TC_01_Login_Account() {
		homepage = xo88_PageGeneratorManager.getHomePage_Xo88(driver);

		log.info("TC_05_Check_Payment - Step 01: Sendkey to UserName At Lobby");
		homepage.sendkeyUserNameAtLobby(userName);

		log.info("TC_05_Check_Payment - Step 02: Sendkey to Password At Lobby");
		homepage.sendkeyPassWordAtLobby(password);

		log.info("TC_05_Check_Payment - Step 03: Click to Login");
		homepage.clickToLoginAtLobby();
	}

	@Test
	public void TC_02_Check_Link_Ext() {

		log.info("TC_01_Check_Link_Ext - Step 01: Click to Thể Thao từ MenuBar");
		homepage.clickToSport("Thể Thao");

		log.info("TC_01_Check_Link_Ext - Step 01: Click to K SPORTS");
		homepage.clickToKSport();

		userNameXo88 = homepage.getTextUserNamePageXO88();
		log.info("TC_01_Check_Link_Ext - Step 02: Check Tên hiển thị K SPORT = Tên hiển thị XO88");
		verifyTrue(homepage.getTextUserNamePageKSport().contains(userNameXo88));

		log.info("TC_01_Check_Link_Ext - Step 01: Trở về trang Thể Thao");
		homepage.backPageSport();

		log.info("TC_01_Check_Link_Ext - Step 01: Click to SABA SPORTS");
		homepage.clickToSaBaSport();
		
		homepage.clickToClosePopup();

		log.info("TC_01_Check_Link_Ext - Step 02: Check Tên hiển thị SABA SPORT = Tên hiển thị XO88");
		verifyTrue(homepage.getTextUserNamePageSaBaSport().contains("xo88_"+ userName));

		log.info("TC_01_Check_Link_Ext - Step 01: Trở về trang Thể Thao");
		homepage.backPageSport();

		log.info("TC_01_Check_Link_Ext - Step 01: Click to BTI SPORTS");
		homepage.clickToBTISport("");

		log.info("TC_01_Check_Link_Ext - Step 02: Check Tên hiển thị BTI SPORT = Tên hiển thị XO88");
		verifyTrue(homepage.getTextUserNamePageBTISport().contains("xo88_"+ userName));

		log.info("TC_01_Check_Link_Ext - Step 01: Trở về trang Thể Thao");
		homepage.backPageSport();

		log.info("TC_01_Check_Link_Ext - Step 01: Click to Xem thêm");
		homepage.clickToSchedules();

		log.info("TC_01_Check_Link_Ext - Step 01: Check Trận đấu hot xuất hiện");
		verifyTrue(homepage.isVisibleHotMatchList());

		// p[contains(text(),'K-SPORTS')]
		log.info("TC_01_Check_Link_Ext - Step 01: Click to radio check K-SPORT");
		homepage.clickToRadioCheckKSport();

		log.info("TC_01_Check_Link_Ext - Step 01: Check Button Đặt Cược K-SPORT xuất hiện");
		verifyTrue(homepage.isVisibleButtonKSport());

		// p[contains(text(),'SABA-SPORTS')]
		log.info("TC_01_Check_Link_Ext - Step 01: Click to radio check SABA-SPORT");
		homepage.clickToRadioCheckSaBaSport();

		log.info("TC_01_Check_Link_Ext - Step 01: Check Button Đặt Cược SABA-SPORT xuất hiện");
		verifyTrue(homepage.isVisibleButtonSaBaSport());

		log.info("TC_01_Check_Link_Ext - Step 01: Click to Kèo Bóng Hôm Nay");
		homepage.clickToMatchToDay();

		log.info("TC_01_Check_Link_Ext - Step 01: Check Lịch bóng đá ngày hôm nay");
		verifyTrue(homepage.isVisibleMatchToDay());

		// p[contains(text(),'K-SPORTS')]
		log.info("TC_01_Check_Link_Ext - Step 01: Click to radio check K-SPORT");
		homepage.clickToRadioCheckKSport();

		log.info("TC_01_Check_Link_Ext - Step 01: Check Button Đặt Cược K-SPORT xuất hiện");
		verifyTrue(homepage.isVisibleButtonKSport());

		// p[contains(text(),'SABA-SPORTS')]
		log.info("TC_01_Check_Link_Ext - Step 01: Click to radio check SABA-SPORT");
		homepage.clickToRadioCheckSaBaSport();

		log.info("TC_01_Check_Link_Ext - Step 01: Check Button Đặt Cược SABA-SPORT xuất hiện");
		verifyTrue(homepage.isVisibleButtonSaBaSport());

		log.info("TC_01_Check_Link_Ext - Step 01: Click to Dropdown Chọn Giải Đấu");
		homepage.clickToDropdownTournament();
		tournamentName = homepage.getTextDropdownSelect();

		log.info("TC_01_Check_Link_Ext - Step 01: Click check Dropdown Giải đầu tiên");
		homepage.clickToDropdownNumber2();
		
		
		verifyTrue(homepage.getTextTournament().contains(tournamentName));
		log.info("TC_01_Check_Link_Ext - Step 01: Check Tên giải đấu được chọn đúng " + tournamentName + " = " + homepage.getTextTournament());
	}

	@BeforeSuite
	public void deleteAllFilesInReportNGScreenshot() {
		System.out.print("-----------START delete file in folder-----------");
		deleteAllFileInFolder();
		System.out.print("-----------END delete file in folder-----------");
	}

	public void deleteAllFileInFolder() {
		try {
			String workingDir = System.getProperty("user.dir");
			String pathFolderDownload = workingDir + "\\ReportNGScreenshots";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.print(listOfFiles[i].getName());
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
