package com.game789d.club;

import java.io.File;
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
import page789clubObjects.HomePageObject;
import page789clubObjects.PageGeneratorManager;
import pageUIs.HomePageUI;

public class homepage_with_789dclub extends AbstractTest {

	WebDriver driver;
	HomePageObject homepage;
	String typeSport;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName);
		driver.get(url);
	}

	@Test
	public void TC_01_Check_Betting() {
		homepage = PageGeneratorManager.getHomePage(driver);
		log.info("TC_01_Check_Betting - Step 01: Click to 'Phiên bản Châu Á'");
		homepage.clickToAsiaViewButton();

		log.info("TC_01_Check_Betting - Step 02: Click to 'Thể thao'");
		homepage.clickToSportButton();

		log.info("TC_01_Check_Betting - Step 02.1: Click to 'Bóng đá'");
		homepage.clickToTypeSportButton("Bóng đá");

		log.info("TC_01_Check_Betting - Step 03: Click to 'Kèo sớm'");
		homepage.clickToTypeTime("Kèo sớm");

		log.info("TC_01_Check_Betting - Step 04: Click to 'Chọn kèo bất kỳ trên trang'");
		homepage.clickToAnyBetButton();

		// Chuyển iframe
		homepage.switchToFrameBetSlipApp();

		log.info("TC_01_Check_Betting - Step 05: Click to '-'");
		homepage.clickToMinusButton();

		log.info("TC_01_Check_Betting - Step 06: Click to '+'");
		homepage.clickToPlusButton();

		log.info("TC_01_Check_Betting - Step 07: Click to '+'");
		homepage.clickToPlusButton();

		log.info("TC_01_Check_Betting - Step 08: Click to '+5'");
		homepage.clickToPlus5Button();

		log.info("TC_01_Check_Betting - Step 09: Click to '-'");
		homepage.clickToMinus1Button();

		log.info("TC_01_Check_Betting - Step 10: Click to '-'");
		homepage.clickToMinus1Button();

		log.info("TC_01_Check_Betting - Step 11: Click to 'Xóa tất cả'");
		homepage.clickClearAllButton();

		// Chuyển iframe
		homepage.switchToFrameDefaul();

		log.info("TC_01_Check_Betting - Step 12: Click to 'Kèo bất kỳ trên trang'");
		homepage.clickToAnyBetForm2Button();
		// Chuyển iframe
		homepage.switchToFrameBetSlipApp();

		log.info("TC_01_Check_Betting - Step 13: Click to 'Đặt cược'");
		homepage.clickToSumitBetButton();

		log.info("TC_01_Check_Betting - Step 14: Xuất hiện text 'Cược được chấp nhận'");
		verifyTrue(homepage.getTextBetSuccess().contains("Cược được chấp nhận"));

		log.info("TC_01_Check_Betting - Step 15: Click to 'Xóa tất cả'");
		homepage.clickToDeleteAllButton();

	}

	@Test
	public void TC_02_Check_Cancel_Bet_Successful() {
		// chuyển iframe về defaul
		homepage.switchToFrameDefaul();

		log.info("TC_02_Check_Cancel_Bet_Successful - Step 01: Click to 'Phiếu cược'");
		homepage.clickToBetSlipButton();

		// chuyển iframe
		homepage.switchToFrameBetSlipApp();

		log.info("TC_02_Check_Cancel_Bet_Successful - Step 02: Click to 'Cược của tôi'");
		homepage.clickToMyBetSlipButton();

		log.info("TC_02_Check_Cancel_Bet_Successful - Step 03: Click to 'Xả kèo'");
		homepage.clickToAmountButton();

		log.info("TC_02_Check_Cancel_Bet_Successful - Step 04: Verify xuất hiện 'Xác nhận xả kèo'");
		verifyEquals(homepage.getTextCashOutButton(""), "Xác nhận xả kèo");

		log.info("TC_02_Check_Cancel_Bet_Successful - Step 05: Đợi 5s");
		sleepInSecond(5);

		log.info("TC_02_Check_Cancel_Bet_Successful - Step 06: Click to 'Xả kèo phiếu đầu tiên'");
		homepage.clickToAmountButton();

		log.info("TC_02_Check_Cancel_Bet_Successful - Step 07: Click to 'Xác nhận Xả kèo'");
		homepage.clickToAmountAgainButton();

		log.info("TC_02_Check_Cancel_Bet_Successful - Step 08: Click to 'Xem tất cả'");
		homepage.clickToViewAllButton();

		// Chuyển iframe
		homepage.switchToFrameDefaul();

		log.info("TC_02_Check_Cancel_Bet_Successful - Step 09: Click to 'Mở chi tiết phiếu'");
		homepage.clickToShowDetailsButton();

		log.info("TC_02_Check_Cancel_Bet_Successful - Step 10: Click to 'Ẩn chi tiết phiếu'");
		homepage.clickToShowDetailsButton();

		log.info("TC_02_Check_Cancel_Bet_Successful - Step 11: Click to 'Xả kèo'");
		homepage.clickToCashOutButton();

		log.info("TC_02_Check_Cancel_Bet_Successful - Step 12: Đợi 5s và không làm gì");
		sleepInSecond(5);

		log.info("TC_02_Check_Cancel_Bet_Successful - Step 13: Click to 'Xả kèo' button bên cạnh 'Tất cả cược'");
		homepage.clicToSwitchOutCashButton();

		log.info("TC_02_Check_Cancel_Bet_Successful - Step 14: Click to 'Mở chi tiết phiếu'");
		homepage.clickToShowDetailsButton();

		log.info("TC_02_Check_Cancel_Bet_Successful - Step 15: Click to 'Ẩn chi tiết phiếu'");
		homepage.clickToShowDetailsButton();

		log.info("TC_02_Check_Cancel_Bet_Successful - Step 16: Click to 'Xả kèo'");
		homepage.clickToCashOutButton();

		log.info("TC_02_Check_Cancel_Bet_Successful - Step 17: Click to 'Xác nhận Xả kèo'");
		homepage.clickToCashOutButton();

		log.info("TC_02_Check_Cancel_Bet_Successful - Step 18: Click to 'Tất cả cược'");
		homepage.clickToAllCashButton();

		log.info("TC_02_Check_Cancel_Bet_Successful - Step 19: Click to 'X'");
		homepage.clickToCloseButton();
	}

	@Test
	public void TC_03_Check_Bet_Not_Successful() {
		log.info("TC_03_Check_Bet_Not_Successful - Step 01: Click to 'Thể thao'");
		homepage.clickToSportButton();

		log.info("TC_03_Check_Bet_Not_Successful - Step 02: Click to 'Kèo sớm'");
		homepage.clickToEarltBetButton();

		log.info("TC_03_Check_Bet_Not_Successful - Step 03: Click to 'Kèo bất kỳ trên trang'");
		homepage.clickToAnyBetButton();
		// chuyển iframe
		homepage.switchToFrameBetSlipApp();

		log.info("TC_03_Check_Bet_Not_Successful - Step 04: Click to '+'");
		homepage.clickToPlusButton();

		log.info("TC_03_Check_Bet_Not_Successful - Step 05: Click to '+100'");
		homepage.clickToPlus100Button();

		log.info("TC_03_Check_Bet_Not_Successful - Step 06: Click to '+500'");
		homepage.clickToPlus500Button();

		log.info("TC_03_Check_Bet_Not_Successful - Step 07: Verify button 'Đặt cược' Disable");
		verifyFalse(homepage.isDisableSumitButton());

		log.info("TC_03_Check_Bet_Not_Successful - Step 08:  Click to 'Xóa tất cả'");
		homepage.clickToDeleteAllButton();
	}

	@Test
	public void TC_04_Check_Cancle_Bet() {
		// chuyển iframe
		homepage.switchToDefaulContent(driver, null);

		log.info("TC_04_Check_Cancle_Bet - Step 01: Click to 'Phiếu cược'");
		homepage.clickToBetSlipButton();

		// chuyển iframe
		homepage.switchToFrameBetSlipApp();

		log.info("TC_04_Check_Cancle_Bet - Step 02: Click to 'Cược của tôi'");
		homepage.clickToMyBetSlipButton();

		log.info("TC_04_Check_Cancle_Bet - Step 03: Click to 'Trở lại phiếu cược'");
		homepage.clickToBackBetSlipButton();

		log.info("TC_04_Check_Cancle_Bet - Step 04: Click to 'Xem tất cả'");
		homepage.clickToViewAllButton();

		// Chuyển iframe
		homepage.switchToFrameDefaul();

		log.info("TC_04_Check_Cancle_Bet - Step 05: Click to 'Xả kèo'");
		homepage.clickToCashOutHeaderButton();

		log.info("TC_04_Check_Cancle_Bet - Step 06: Click to 'X'");
		homepage.clickToCloseButton();
	}

	@Test
	public void TC_05_Check_History_Bet_And_Cancel() {
		// Chuyển iframe
		homepage.switchToFrameBetSlipApp();
		// Click button "Xem tất cả"
		log.info("TC_05_Check_History_Bet_And_Cancel - Step 01: Click to 'Xem tất cả'");
		homepage.clickToViewAllButton();

		// Chuyển iframe
		homepage.switchToFrameDefaul();
		
		// Click button "Lịch sử cược"
		log.info("TC_05_Check_History_Bet_And_Cancel - Step 02: Click to 'Lịch sử cược'");
		homepage.clickToHistoryBet();

		// Click button "Mở chi tiết phiêu"
		log.info("TC_05_Check_History_Bet_And_Cancel - Step 03: Click to 'Mở chi tiết phiếu'");
		homepage.clickToShowDetailsAtHistoriBettingButton();

		sleepInSecond(3);

		// Click button "Ẩn chi tiết phiêu"
		log.info("TC_05_Check_History_Bet_And_Cancel - Step 04: Click to 'Ẩn chi tiết phiếu'");
		homepage.clickToShowDetailsAtHistoriBettingButton();

		// Click Button "V" tại list thời gian
		log.info("TC_05_Check_History_Bet_And_Cancel - Step 05: Click to 'V'");
		homepage.clickToDropdown();

		// Click chọn Dropdown "48 giờ qua"
		log.info("TC_05_Check_History_Bet_And_Cancel - Step 06: Click to dropdown '48 giờ qua'");
		homepage.clickToDropdownTimeSelect("48 giờ qua");
		
		log.info("TC_05_Check_History_Bet_And_Cancel - Step 07: Click to 'V'");
		homepage.clickToDropdown();

		// Click chọn Dropdown "3 tháng qua"
		log.info("TC_05_Check_History_Bet_And_Cancel - Step 08: Click to dropdown '3 tháng qua'");
		homepage.clickToDropdownTimeSelect("3 tháng qua");
		// Click button Close "X"
		log.info("TC_05_Check_History_Bet_And_Cancel - Step 09: Click to 'X'");
		homepage.clickToCloseButton();
	}

	@Test
	public void TC_06_Check_Slant_Bet() {
		log.info("TC_06_Check_History_Bet_And_Cancel - Step 01: Click to 'Thể thao'");
		homepage.clickToSportButton();

		log.info("TC_06_Check_History_Bet_And_Cancel - Step 02: Click to 'Kèo sớm'");
		homepage.clickToEarltBetButton();

		log.info("TC_06_Check_History_Bet_And_Cancel - Step 03: Click to 'Show time'");
		homepage.clickToShowTimeButton();

		log.info("TC_06_Check_History_Bet_And_Cancel - Step 04: Click to 'Trở lại'");
		homepage.clickToBackButton();

		log.info("TC_06_Check_History_Bet_And_Cancel - Step 05: Click to 'Cược thêm'");
		homepage.clickToMoreCellButton();

		log.info("TC_06_Check_History_Bet_And_Cancel - Step 06: Click to 'Cược xiên trận đấu lần 1'");
		homepage.clickToSlanBetButton();
		sleepInSecond(3);

		log.info("TC_06_Check_History_Bet_And_Cancel - Step 07: Click to 'Cược xiên trận đấu lần 2'");
		homepage.clickToSlanBetButton();
		sleepInSecond(3);

		log.info("TC_06_Check_History_Bet_And_Cancel - Step 08: Click to 'Cược xiên trận đấu lần 3'");
		homepage.clickToSlanBetButton();
		sleepInSecond(3);

		log.info("TC_06_Check_History_Bet_And_Cancel - Step 09: Click to 'Cược đầu tiên của page'");
		homepage.clickToEarlyBetButtonAtSlanBet();

		// chuyển iframe
		homepage.switchToFrameBetSlipApp();

		log.info("TC_06_Check_History_Bet_And_Cancel - Step 10: Verify button 'Đặt cược' disabled");
		verifyFalse(homepage.isDisabledSumitButton());

		log.info("TC_06_Check_History_Bet_And_Cancel - Step 11: Click to '+'");
		homepage.clickToPlusButton();

		// chuyển iframe
		homepage.switchToFrameDefaul();

		log.info("TC_06_Check_History_Bet_And_Cancel - Step 12: Click to 'Cược bất kỳ của page'");
		homepage.clickToRandomBetButtonAtSlanBet();

		// chuyển iframe
		homepage.switchToFrameBetSlipApp();
		
	
		log.info("TC_06_Check_History_Bet_And_Cancel - Step 13: Verify button 'Đặt cược' enabled");
		verifyTrue(homepage.isEnabledSumitButton());
		
		log.info("TC_06_Check_History_Bet_And_Cancel - Step 14: Click to 'Đặt cược'");
		homepage.clickToSumitBetButton();

	}

	
	@Test
	public void TC_07_Check_Slant_Bet() {
		log.info("TC_07_Check_Slant_Bet - Step 01: Click to 'Cược thêm'");
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
			for(int i = 0; i <listOfFiles.length; i++) {
				if(listOfFiles[i].isFile()) {
					System.out.print(listOfFiles[i].getName());
					new File(listOfFiles[i].toString()).delete();
				}
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
