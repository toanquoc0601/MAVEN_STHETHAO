package com.xo88.info;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.xo88_AccountPageObject;
import pageObjects.xo88_HomePageObject;
import pageObjects.xo88_PageGeneratorManager;

public class page_int_link_with_xo88 extends AbstractTest {

	WebDriver driver;
	xo88_HomePageObject homepage;
	xo88_AccountPageObject accountpage;
	String parentID;
	int stepTotal;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://xo88.info/");
	}
	@Test
	public void TC_01_Check_Link_Int_HomePage() {
		homepage = xo88_PageGeneratorManager.getHomePage_Xo88(driver);
		log.info("Tắt popup Khuyến Mãi");
		homepage.closePopupRandom();
		
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
		
		log.info("TC_01_Check_Link_Int_Page - Step 02: Check Page được chuyển đến Chính sách Bảo mật");
		verifyTrue(homepage.getTextNamePage().contains("CHÍNH SÁCH BẢO MẬT"));
		
		log.info("TC_01_Check_Link_Int_Page - Step 01: Click to Hướng Dẫn Nạp Rút");
		homepage.clickToInfoDetail("Hướng Dẫn Nạp Rút");
		
		log.info("TC_01_Check_Link_Int_Page - Step 02: Check Page được chuyển đến Hướng Dẫn Nạp Rút");
		verifyTrue(homepage.getTextNamePage().contains("LIÊN HỆ & HỖ TRỢ"));
		
		log.info("TC_01_Check_Link_Int_Page - Step 01: Click to Liên Hệ và Hỗ Trợ");
		homepage.clickToInfoDetail("Liên Hệ và Hỗ Trợ");
		
		log.info("TC_01_Check_Link_Int_Page - Step 02: Check Page được chuyển đến Liên Hệ và Hỗ Trợ");
		verifyTrue(homepage.getTextNamePage().contains("LIÊN HỆ & HỖ TRỢ"));
		
		
	}
	
	@Test
	public void TC_02_Check_Link_Int_HomePage() {
		homepage.getHomePageID(parentID);
		
		log.info("TC_02_Check_Link_Int_HomePage - Step 01: Click to Telegram");
		homepage.clickToSupportPage("@CSKHXO88");
		
		log.info("TC_02_Check_Link_Int_HomePage - -------Title Telegram = " + homepage.getTextTitlePage());
		homepage.switchToHomePage(parentID);
		
		
		log.info("TC_02_Check_Link_Int_HomePage - Step 02: Click to Cộng Đồng X088");
		homepage.clickToSupportPage("Cộng Đồng X088");
		
		log.info("TC_02_Check_Link_Int_HomePage - -------Title Cộng Đồng X088 = " + homepage.getTextTitlePage());
		homepage.switchToHomePage(parentID);
	}
	@Test
	public void TC_03_Check_Link_Int_SupportPage() {
		log.info("TC_03_Check_Link_Int_SupportPage - Step 01: Click to Nạp Codepay");
		homepage.clickToSupportDeposit("Nạp Codepay");
		
		log.info("TC_03_Check_Link_Int_SupportPage - Step 02: Check các bước hướng dẫn");
		homepage.clickToGuideStops();
		
		stepTotal = homepage.checkToStepTotal();
		for (int i = 1; i < stepTotal + 1; i++) {
			homepage.getTextStepContent(i);
			log.info("TC_03_Check_Link_Int_SupportPage -'" + homepage.getTextStepTitle(i).toString() + "': '" + homepage.getTextStepContent(i).toString() + "'");
			homepage.clickToStep(i);
		}
		
		log.info("TC_03_Check_Link_Int_SupportPage - Step 03: Click to Nạp Qua Ngân Hàng");
		homepage.clickToSupportDeposit("Nạp Qua ngân hàng ");
		
		log.info("TC_03_Check_Link_Int_SupportPage - Step 04: Check các bước hướng dẫn");
		homepage.clickToGuideStops();
		
		stepTotal = homepage.checkToStepTotal();
		for (int i = 1; i < stepTotal + 1; i++) {
			homepage.getTextStepContent(i);
			log.info("TC_03_Check_Link_Int_SupportPage -'" + homepage.getTextStepTitle(i).toString() + "': '" + homepage.getTextStepContent(i).toString() + "'");
			homepage.clickToStep(i);
		}
		
		log.info("TC_03_Check_Link_Int_SupportPage - Step 05: Click to Nạp Qua Momo");
		homepage.clickToSupportDeposit("nạp qua Momo");
		
		log.info("TC_03_Check_Link_Int_SupportPage - Step 06: Check các bước hướng dẫn");
		homepage.clickToGuideStops();
		
		stepTotal = homepage.checkToStepTotal();
		for (int i = 1; i < stepTotal + 1; i++) {
			homepage.getTextStepContent(i);
			log.info("TC_03_Check_Link_Int_SupportPage -'" + homepage.getTextStepTitle(i).toString() + "': '" + homepage.getTextStepContent(i).toString() + "'");
			homepage.clickToStep(i);
		}
		
		log.info("TC_03_Check_Link_Int_SupportPage - Step 07: Click to Nạp Qua Paywin");
		homepage.clickToSupportDeposit("nạp Paywin");
		
		log.info("TC_03_Check_Link_Int_SupportPage - Step 08: Check các bước hướng dẫn");
		homepage.clickToGuideStops();
		
		stepTotal = homepage.checkToStepTotal();
		for (int i = 1; i < stepTotal + 1; i++) {
			homepage.getTextStepContent(i);
			log.info("TC_03_Check_Link_Int_SupportPage -'" + homepage.getTextStepTitle(i).toString() + "': '" + homepage.getTextStepContent(i).toString() + "'");
			homepage.clickToStep(i);
		}
		
		log.info("TC_03_Check_Link_Int_SupportPage - Step 09: Click to Nạp Qua Thẻ Cào");
		homepage.clickToSupportDeposit("nạp thẻ cào");
		
		log.info("TC_03_Check_Link_Int_SupportPage - Step 10: Check các bước hướng dẫn");
		homepage.clickToGuideStops();
		
		stepTotal = homepage.checkToStepTotal();
		for (int i = 1; i < stepTotal + 1; i++) {
			homepage.getTextStepContent(i);
			log.info("TC_03_Check_Link_Int_SupportPage -'" + homepage.getTextStepTitle(i).toString() + "': '" + homepage.getTextStepContent(i).toString() + "'");
			homepage.clickToStep(i);
		}
		
		log.info("TC_03_Check_Link_Int_SupportPage - Step 11: Click to Rút qua ngân hàng");
		homepage.clickToSupportDeposit("rút qua ngân hàng");
		
		log.info("TC_03_Check_Link_Int_SupportPage - Step 12: Check các bước hướng dẫn");
		homepage.clickToGuideStops();
		
		stepTotal = homepage.checkToStepTotal();
		for (int i = 1; i < stepTotal + 1; i++) {
			homepage.getTextStepContent(i);
			log.info("TC_03_Check_Link_Int_SupportPage -'" + homepage.getTextStepTitle(i).toString() + "': '" + homepage.getTextStepContent(i).toString() + "'");
			homepage.clickToStep(i);
		}
		
		log.info("TC_03_Check_Link_Int_SupportPage - Step 13: Click to Rút qua thẻ cào");
		homepage.clickToSupportDeposit("rút qua thẻ cào");
		
		log.info("TC_03_Check_Link_Int_SupportPage - Step 14: Check các bước hướng dẫn");
		homepage.clickToGuideStops();
		
		stepTotal = homepage.checkToStepTotal();
		for (int i = 1; i < stepTotal + 1; i++) {
			homepage.getTextStepContent(i);
			log.info("TC_03_Check_Link_Int_SupportPage -'" + homepage.getTextStepTitle(i).toString() + "': '" + homepage.getTextStepContent(i).toString() + "'");
			homepage.clickToStep(i);
		}
		
		log.info("TC_03_Check_Link_Int_SupportPage - Step 15: Click to Thêm tài khoản ngân hàng");
		homepage.clickToSupportDeposit("Thêm tài khoản ngân hàng");
		
		log.info("TC_03_Check_Link_Int_SupportPage - Step 16: Check Page được chuyển đến Thêm tài khoản ngân hàng");
		verifyTrue(homepage.getTextNamePage().contains("THÊM TÀI KHOẢN NGÂN HÀNG"));
		
		log.info("TC_01_Check_Link_Int_Page - Step 17: Click to Soi Kèo Bóng Đá");
		homepage.clickToInfoDetail2("Soi Kèo Bóng Đá");
		
		//log.info("TC_01_Check_Link_Int_Page - Step 18: Check Active Category Soi Kèo Bóng Đá");
		//verifyTrue(homepage.getTextNamePage().contains("THÊM TÀI KHOẢN NGÂN HÀNG"));
		
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
