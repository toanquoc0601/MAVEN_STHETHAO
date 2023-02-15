package com.xo88.info;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.xo88_AccountPageObject;
import pageObjects.xo88_DepositObject;
import pageObjects.xo88_HomePageObject;
import pageObjects.xo88_PageGeneratorManager;

public class deposit_with_xo88 extends AbstractTest {

	WebDriver driver;
	xo88_HomePageObject homepage;
	xo88_DepositObject deposit;
	String parentID;
	int typePromotion;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://xo88.info/");
		
	}

	@Test
	public void DEPOSIT_PAYWIN_00_LOGING() {

		homepage = xo88_PageGeneratorManager.getHomePage_Xo88(driver);
		log.info("Tắt popup Khuyến Mãi");
		homepage.closePopupRandom();

		log.info("TC_Loging - Step 01: Sendkey to UserName = kakute06 At Lobby");
		homepage.sendkeyUserNameAtLobby("kakute05");

		log.info("TC_Loging - Step 02: Sendkey to Password = Abcd1234 At Lobby");
		homepage.sendkeyPassWordAtLobby("Quoc782442!");

		log.info("TC_Loging - Step 03: Click to Đăng nhập");
		homepage.clickToLoginAtLobby();
		
	}
	@Test
	public void DEPOSIT_PAYWIN_01() {
		log.info("DEPOSIT_PAYWIN_01 Step 1. Vào link XO");
		driver.get("https://xo88.info/");
		deposit = xo88_PageGeneratorManager.getDepositPage(driver);
		
		log.info("DEPOSIT_PAYWIN_01 Step 2. CLick Btn Nạp");
		deposit.clickToDepositAtHeader();
		
		log.info("DEPOSIT_PAYWIN_01 Step 3. CLick logo XO");
		deposit.clickToLogoXOAtHeader();
	}
	
	public void DEPOSIT_PAYWIN_02() {
		log.info("DEPOSIT_PAYWIN_02 Step 1. Click cụm avatar user");
		deposit.clickToAvatarUserAtHeader();
		
		log.info("DEPOSIT_PAYWIN_02 Step 2. Click btn Nạp Tiền");
		deposit.clickToDepositAtHeader();
		
		log.info("DEPOSIT_PAYWIN_02 Step 3. CLick logo XO");
		deposit.clickToLogoXOAtHeader();
	}
	@Test
	public void DEPOSIT_PAYWIN_03() {
		log.info("DEPOSIT_PAYWIN_03 Step 1. CLick Btn Nạp");
		deposit.clickToDepositAtHeader();
		
		log.info("DEPOSIT_PAYWIN_03 Step 2. Click btn Paywin");
		deposit.clickToPaywinAtMenubar();
		
		log.info("DEPOSIT_PAYWIN_03 Step 3. Input data vào ô số tiền nạp '49'");
		deposit.sendkeyToNumberMoneyAtPaywin("49");
		
		log.info("DEPOSIT_PAYWIN_03 Step 4. CLick btn Tiếp tục");
		deposit.clickToNextAtPaywin();
		
		log.info("Verify thông báo 'Số tiền nạp tối thiểu là 50k'");
		verifyEquals(deposit.getTextErrorAtPaywin(), "Số tiền nạp tối thiểu là 50.000 VND");
		
		log.info("DEPOSIT_PAYWIN_03 Step 5. Xóa số 49k trong ô số tiền nạp");
		deposit.clearTextToNumberMoneyAtPaywin();
	}
	@Test
	public void DEPOSIT_PAYWIN_04() {
		log.info("DEPOSIT_PAYWIN_04 Step 1. Input data vào ô số tiền nạp '1.000.001'");
		deposit.sendkeyToNumberMoneyAtPaywin("1000001");
		
		log.info("Verify thông báo 'Số tiền nạp tối đa là 1B'");
		verifyEquals(deposit.getTextErrorAtPaywin(), "Số tiền nạp tối đa là 1.000.000.000 VND");
		
		log.info("DEPOSIT_PAYWIN_04 Step 2. CLick btn Tiếp tục");
		deposit.clickToNextAtPaywin();
		
		log.info("DEPOSIT_PAYWIN_04 Step 3. CLick logo XO");
		deposit.clickToLogoXOAtHeader();
	}
	@Test
	public void DEPOSIT_PAYWIN_05() {
		log.info("DEPOSIT_PAYWIN_05 Step 1. CLick Btn Nạp");
		deposit.clickToDepositAtHeader();
		
		log.info("DEPOSIT_PAYWIN_05 Step 2. Click btn Paywin");
		deposit.clickToPaywinAtMenubar();
		
		log.info("DEPOSIT_PAYWIN_05 Step 3. Input data vào ô số tiền nạp '10'");
		deposit.sendkeyToNumberMoneyAtPaywin("10");
		
		log.info("DEPOSIT_PAYWIN_05 Step 4. Click btn Tiếp tục");
		deposit.clickToNextAtPaywin();
		
		log.info("DEPOSIT_PAYWIN_05 Step 5. Xóa số 10 trong ô số tiền nạp");
		deposit.clearTextToNumberMoneyAtPaywin();
		
		log.info("Verify thông báo 'Vui lòng nhập số tiền nạp'");
		verifyEquals(deposit.getTextErrorAtPaywin(), "Vui lòng nhập số tiền nạp");
		
		log.info("DEPOSIT_PAYWIN_05 Step 6. Click btn Tiếp tục");
		deposit.clickToNextAtPaywin();
		
		log.info("DEPOSIT_PAYWIN_05 Step 7. CLick logo XO");
		deposit.clickToLogoXOAtHeader();
	}
	@Test
	public void DEPOSIT_PAYWIN_06() {
		deposit.getHomePageID(parentID);
		
		log.info("DEPOSIT_PAYWIN_06 Step 1. CLick Btn Nạp");
		deposit.clickToDepositAtHeader();
		
		log.info("DEPOSIT_PAYWIN_06 Step 2. Click btn Paywin");
		deposit.clickToPaywinAtMenubar();
		
		log.info("DEPOSIT_PAYWIN_06 Step 3. Input data vào ô số tiền nạp '50'");
		deposit.sendkeyToNumberMoneyAtPaywin("50");
		
		log.info("DEPOSIT_PAYWIN_06 Step 4. Click btn Tiếp tục");
		deposit.clickToNextAtPaywin();
		
		log.info("DEPOSIT_PAYWIN_06 Step 5. Mở page Nạp với ngân hàng đang chọn");
		System.out.println(deposit.getTextTitlePage());
		
		log.info("DEPOSIT_PAYWIN_06 Step 6. Back lại page XO");
		deposit.switchToHomePage(parentID);
	}
	@Test
	public void DEPOSIT_PAYWIN_07() {
		log.info("DEPOSIT_PAYWIN_07 Step 1. CLick Btn Nạp");
		deposit.clickToDepositAtHeader();
		
		log.info("DEPOSIT_PAYWIN_07 Step 2. Click btn Paywin");
		deposit.clickToPaywinAtMenubar();
		
		log.info("DEPOSIT_PAYWIN_07 Step 3. Input data vào ô số tiền nạp");
		deposit.sendkeyToNumberMoneyAtPaywin("1000000");
		
		log.info("DEPOSIT_PAYWIN_07 Step 4. Click btn Tiếp tục");
		deposit.clickToNextAtPaywin();
		
		log.info("DEPOSIT_PAYWIN_07 Step 5. Mở page Nạp với ngân hàng đang chọn");
		System.out.println(deposit.getTextTitlePage());
		
		log.info("DEPOSIT_PAYWIN_07 Step 6. Back lại page XO");
		deposit.switchToHomePage(parentID);
	}
	@Test
	public void DEPOSIT_PAYWIN_08() {
		typePromotion = deposit.checkPromotion();
		System.out.println(typePromotion);
		for (int i = 1; i <= typePromotion; i++) {
			log.info("Check Khuyến mãi "+i+"");
			
			log.info("DEPOSIT_PAYWIN_08 Step 1. CLick Btn Nạp");
			deposit.clickToDepositAtHeader();
			
			log.info("DEPOSIT_PAYWIN_08 Step 2. Click btn Paywin");
			deposit.clickToPaywinAtMenubar();
			
			log.info("DEPOSIT_PAYWIN_08 Step 3. Chọn khuyến mãi "+i+"");
			deposit.clickToTypePromotion(i);
			
			log.info("DEPOSIT_PAYWIN_08 Step 4. Input 50000 vào ô số tiền nạp");
			deposit.sendkeyToNumberMoneyAtPaywin("50000");
			
			log.info("DEPOSIT_PAYWIN_08 Step 5. Click btn Tiếp tục");
			deposit.clickToNextAtPaywin();
			
			log.info("DEPOSIT_PAYWIN_08 Step 6. Back lại page XO");
			deposit.switchToHomePage(parentID);
			
			log.info("DEPOSIT_PAYWIN_08 Step 7. CLick logo XO");
			deposit.clickToLogoXOAtHeader();
		}
		
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


	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

}
