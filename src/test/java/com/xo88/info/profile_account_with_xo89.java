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


public class profile_account_with_xo89 extends AbstractTest {

	WebDriver driver;
	xo88_HomePageObject homepage;
	xo88_AccountPageObject accountpage;
	@Parameters({ "browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://xo88.info/");
	}
	String email;
	int typePayment;
	int typeGame;

	@Test
	public void TC_05_Check_Payment() {
		homepage = xo88_PageGeneratorManager.getHomePage_Xo88(driver);
		
		log.info("TC_05_Check_Payment - Step 01: Sendkey to UserName At Lobby");
		homepage.sendkeyUserNameAtLobby("kakute02");
		
		log.info("TC_05_Check_Payment - Step 02: Sendkey to Password At Lobby");
		homepage.sendkeyPassWordAtLobby("Quoc782442");
		
		log.info("TC_05_Check_Payment - Step 03: Click to Login");
		homepage.clickToLoginAtLobby();
		
		log.info("TC_05_Check_Payment - Step 04: Click to Nạp Tiền");
		homepage.clickToDeposit();
		
		log.info("TC_05_Check_Payment - Step 05: Check các loại nạp tiền");
		typePayment = homepage.checkToPayment();
		log.info("TC_05_Check_Payment - Step 05.1: Có "+typePayment+" loại nạp tiền");
		for (int i = 1; i < typePayment +1 ; i++) {
			homepage.getTextTypePayment(i);
			log.info("TC_05_Check_Payment - Loại "+i+" '"+homepage.getTextTypePayment(i).toString()+"'");
		}
		
		log.info("TC_05_Check_Payment - Step 06: Click to Rút tiền");
		homepage.clickToWithdraw();
		
		log.info("TC_05_Check_Payment - Step 07: Check các loại rút tiền");
		typePayment = homepage.checkToWithdraw();
		log.info("TC_05_Check_Payment - Step 07.1: Có "+typePayment+" loại rút tiền");
		for (int i = 1; i < typePayment +1 ; i++) {
			homepage.getTextTypeWithdraw(i);
			log.info("TC_05_Check_Payment - Loại "+i+" '"+homepage.getTextTypeWithdraw(i).toString()+"'");
		}
	}
	
	@Test
	public void TC_06_Check_Profile() {
		log.info("TC_06_Check_Profile - Step 01: Click to Thông tin tài khoản");
		homepage.clickToButtonProfile();
		
		log.info("TC_06_Check_Profile - Step 02: Check Tên Đăng Nhập disabled");
		verifyFalse(homepage.isUserNameDisable());
		
		log.info("TC_06_Check_Profile - Step 03: Check Password disabled");
		verifyFalse(homepage.isPasswordDisable());
		
		log.info("TC_06_Check_Profile - Step 04: Sendkey to Email");
		homepage.sendkeyEmailAtProfile("taptap.valkyle512@gmail");

		log.info("TC_06_Check_Profile - Step 05: Check Message 'Địa chỉ email không hợp lệ'");
		verifyTrue(homepage.getTextErrorDisplayName().contains("Địa chỉ email không hợp lệ"));
		
		log.info("TC_06_Check_Profile - Step 06: Clear text to Email");
		homepage.clearTextEmailAtProfile();
		
		log.info("TC_06_Check_Profile - Step 07: Sendkey to Email = 'taptap.valkyle512@gmail.com'");
		homepage.sendkeyEmailAtProfile("taptap.valkyle512@gmail.com");
		
		log.info("TC_06_Check_Profile - Step 08: Click to Lưu thay đổi");
		homepage.clickToButtonSaveProfile();
		
		log.info("TC_06_Check_Profile - Step 09: Check Message 'Email đã tồn tại trong hệ thống'");
		verifyTrue(homepage.getTextErrorLogin1().contains("Email đã tồn tại trong hệ thống"));
		
		log.info("TC_06_Check_Profile - Step 10: Clear text to Email");
		homepage.clearTextEmailAtProfile();
		
		homepage.sendkeyEmailAtProfile(generateUserName());
		log.info("TC_06_Check_Profile - Step 11: Sendkey to Email = "+email+"");
		
		log.info("TC_06_Check_Profile - Step 12: Click to Lưu thay đổi");
		homepage.clickToButtonSaveProfile();
		
		log.info("TC_06_Check_Profile - Step 12: Check Message 'Cập nhật thông tin tài khoản thành công.'");
		verifyTrue(homepage.getTextErrorLogin1().contains("Cập nhật thông tin tài khoản thành công."));
		
		
		
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
	
	public String generateUserName() {
		Random random = new Random();
		return email = "estg3hello" + random.nextInt(9999) + "@yopmail.com";
	}

}
