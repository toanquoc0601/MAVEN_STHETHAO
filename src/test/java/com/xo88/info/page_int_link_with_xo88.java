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

public class page_int_link_with_xo88 extends AbstractTest {

	WebDriver driver;
	xo88_HomePageObject homepage;
	xo88_AccountPageObject accountpage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://xo88.info/");
	}
	@Test
	public void TC_01_Check_Link_Int_Page() {
		homepage = xo88_PageGeneratorManager.getHomePage_Xo88(driver);
		
		log.info("TC_01_Check_Link_Int_Page - Step 01: Click to Giới Thiệu XO88");
		homepage.clickToInfoDetail("Giới Thiệu XO88");
		
		log.info("TC_01_Check_Link_Int_Page - Step 02: Check Page được chuyển đến Giới Thiệu XO88");
		verifyTrue(homepage.getTextNamePage().contains("GIỚI THIỆU XO88"));
		
		log.info("TC_01_Check_Link_Int_Page - Step 01: Click to Điều Khoản & Điều Kiện");
		homepage.clickToInfoDetail("Điều Khoản & Điều Kiện");
		
		log.info("TC_01_Check_Link_Int_Page - Step 02: Check Page được chuyển đến điều khoản & điều kiện");
		verifyTrue(homepage.getTextNamePage().contains("ĐIỀU KHOẢN & ĐIỀU KIỆN"));
		
		log.info("TC_01_Check_Link_Int_Page - Step 01: Click to Chính sách Bảo mật");
		homepage.clickToInfoDetail("Chính sách Bảo mật");
		
		log.info("TC_01_Check_Link_Int_Page - Step 02: Check Page được chuyển đến điều khoản & điều kiện");
		verifyTrue(homepage.getTextNamePage().contains("CHÍNH SÁCH BẢO MẬT"));
		
		log.info("TC_01_Check_Link_Int_Page - Step 01: Click to Hướng Dẫn Nạp Rút");
		homepage.clickToInfoDetail("Hướng Dẫn Nạp Rút");
		
		log.info("TC_01_Check_Link_Int_Page - Step 02: Check Page được chuyển đến điều khoản & điều kiện");
		verifyTrue(homepage.getTextNamePage().contains("LIÊN HỆ & HỖ TRỢ"));
		
		log.info("TC_01_Check_Link_Int_Page - Step 01: Click to Telegram");
		//homepage.clickToTelegeam();
		
		log.info("TC_01_Check_Link_Int_Page - Step 02: Check Page được chuyển đến điều khoản & điều kiện");
		verifyTrue(homepage.getTextNamePage().contains("LIÊN HỆ & HỖ TRỢ"));
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
