package com.xo88.info;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.xo88_AccountPageObject;
import pageObjects.xo88_HomePageObject;
import pageObjects.xo88_PageGeneratorManager;

public class profile_account_with_xo89 extends AbstractTest {

	WebDriver driver;
	xo88_HomePageObject homepage;
	xo88_AccountPageObject accountpage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://xo88.info/");
	}

	String email;
	int typePayment;
	int typeGame;

	String userName = "kakute05";
	String password = "Quoc782442";
	String newPassword = "Quoc782443!";
	String phoneNumber;

	@Test
	public void TC_05_Check_Payment() {
		homepage = xo88_PageGeneratorManager.getHomePage_Xo88(driver);
		log.info("Tắt popup Khuyến Mãi");
		homepage.closePopupRandom();
		
		log.info("TC_05_Check_Payment - Step 01: Sendkey to UserName At Lobby");
		homepage.sendkeyUserNameAtLobby(userName);

		log.info("TC_05_Check_Payment - Step 02: Sendkey to Password At Lobby");
		homepage.sendkeyPassWordAtLobby(password);

		log.info("TC_05_Check_Payment - Step 03: Click to Login");
		homepage.clickToLoginAtLobby();

		log.info("TC_05_Check_Payment - Step 04: Click to Nạp Tiền");
		homepage.clickToDeposit();

		log.info("TC_05_Check_Payment - Step 05: Check các loại nạp tiền");
		typePayment = homepage.checkToPayment();
		log.info("TC_05_Check_Payment - Step 05.1: Có " + typePayment + " loại nạp tiền");
		for (int i = 1; i < typePayment + 1; i++) {
			homepage.getTextTypePayment(i);
			log.info("TC_05_Check_Payment - Loại " + i + " '" + homepage.getTextTypePayment(i).toString() + "'");
		}

		log.info("TC_05_Check_Payment - Step 06: Click to Rút tiền");
		homepage.clickToWithdraw();

		log.info("TC_05_Check_Payment - Step 07: Check các loại rút tiền");
		typePayment = homepage.checkToWithdraw();
		log.info("TC_05_Check_Payment - Step 07.1: Có " + typePayment + " loại rút tiền");
		for (int i = 1; i < typePayment + 1; i++) {
			homepage.getTextTypeWithdraw(i);
			log.info("TC_05_Check_Payment - Loại " + i + " '" + homepage.getTextTypeWithdraw(i).toString() + "'");
		}
	}

	@Test
	public void TC_06_Check_Profile() {
		log.info("TC_06_Check_Profile - Step 01: Click to Thông tin tài khoản");
		homepage.clickToButtonProfile();

		log.info("TC_06_Check_Profile - Step 02: Check Tên Đăng Nhập disabled");
		verifyFalse(homepage.isUserNameDisable());

		log.info("TC_06_Check_Profile - Step 03: Check Mật khẩu disabled");
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
		verifyTrue(homepage.getTextErrorFlashNotice().contains("Email đã tồn tại trong hệ thống"));

		log.info("TC_06_Check_Profile - Step 10: Clear text to Email");
		homepage.clearTextEmailAtProfile();

		homepage.sendkeyEmailAtProfile(generateUserName());
		log.info("TC_06_Check_Profile - Step 11: Sendkey to Email = " + email + "");

		log.info("TC_06_Check_Profile - Step 12: Click to Lưu thay đổi");
		homepage.clickToButtonSaveProfile();

		log.info("TC_06_Check_Profile - Step 13: Check Message 'Cập nhật thông tin tài khoản thành công.'");
		verifyTrue(homepage.getTextErrorFlashNotice().contains("Cập nhật thông tin tài khoản thành công."));

		log.info("TC_06_Check_Profile - Step 14: Sendkey to Số điện thoại = 077788899");
		homepage.sendkeyPhoneNumberAtProfile("077788899");

		log.info("TC_06_Check_Profile - Step 15: Check Message 'Vui lòng không nhập ít hơn 10 chữ số'");
		verifyTrue(homepage.getTextError().contains("Vui lòng không nhập ít hơn 10 chữ số"));

		homepage.sendkeyPhoneNumberAtProfile(generatePhoneNumber());
		log.info("TC_06_Check_Profile - Step 16: Sendkey to Số điện thoại = " + phoneNumber);
		

		log.info("TC_06_Check_Profile - Step 17: Click to Lưu thay đổi");
		homepage.clickToButtonSaveProfile();

		log.info("TC_06_Check_Profile - Step 18: Check Message 'Cập nhật thông tin tài khoản thành công.'");
		verifyTrue(homepage.getTextErrorFlashNotice().contains("Cập nhật thông tin tài khoản thành công."));

		log.info("TC_06_Check_Profile - Step 19: Click to Thay Đổi Mật Khẩu");
		homepage.clickToChangePassword();

		log.info("TC_06_Check_Profile - Step 20: Sendkey to Mật khẩu hiện tại = Abcd1235");
		homepage.sendkeyCurentPassword("Abcd1235");

		log.info("TC_06_Check_Profile - Step 21: Sendkey to Mật khẩu mới = 1234Abcd");
		homepage.sendkeyNewPassword("1234Abcd");

		log.info("TC_06_Check_Profile - Step 22: Sendkey to Xác nhận mật khẩu = 1234Abcd");
		homepage.sendkeyConfirmPassword("1234Abcd");
		
		log.info("TC_06_Check_Profile - Step 23: Click to Lưu mật khẩu");
		homepage.clickToSavePassword();

		log.info("TC_06_Check_Profile - Step 24: Check Message 'Mật khẩu cũ không đúng. Vui lòng thử lại'");
		verifyTrue(homepage.getTextErrorFlashNotice().contains("Mật khẩu cũ không đúng. Vui lòng thử lại"));

		log.info("TC_06_Check_Profile - Step 25: Sendkey to Mật khẩu mới = 123");
		homepage.sendkeyNewPassword("123");

		log.info("TC_06_Check_Profile - Step 29: Sendkey to Xác nhận mật khẩu = 123");
		homepage.sendkeyConfirmPassword("123");
		
		log.info("TC_06_Check_Profile - Step 27: Click to Lưu mật khẩu");
		homepage.clickToSavePassword();

		log.info("TC_06_Check_Profile - Step 28: Check Message 'Vui lòng không nhập ít hơn 8 ký tự'");
		verifyTrue(homepage.getTextError().contains("Vui lòng không nhập ít hơn 8 ký tự"));

		log.info("TC_06_Check_Profile - Step 29: Sendkey to Mật khẩu mới = abcdabcd");
		homepage.sendkeyNewPassword("abcdabcd");

		log.info("TC_06_Check_Profile - Step 30: Sendkey to Xác nhận mật khẩu = abcdabcd");
		homepage.sendkeyConfirmPassword("abcdabcd");
		
		log.info("TC_06_Check_Profile - Step 31: Click to Lưu mật khẩu");
		homepage.clickToSavePassword();

		log.info("TC_06_Check_Profile - Step 32: Check Message 'Mật khẩu mới phải tối thiểu 8 ký tự, có chứa chữ VIẾT HOA và chữ số.'");
		verifyTrue(homepage.getTextError().contains("Mật khẩu mới phải tối thiểu 8 ký tự, có chứa chữ VIẾT HOA và chữ số."));

		log.info("TC_06_Check_Profile - Step 33: Sendkey to Mật khẩu mới = 1234Abcd");
		homepage.sendkeyNewPassword("1234Abcd");

		log.info("TC_06_Check_Profile - Step 34: Sendkey to Xác nhận mật khẩu = Abcd123A");
		homepage.sendkeyConfirmPassword("Abcd123A");
		
		log.info("TC_06_Check_Profile - Step 35: Click to Lưu mật khẩu");
		homepage.clickToSavePassword();

		log.info("TC_06_Check_Profile - Step 36: Check Message 'Xác nhận mật khẩu mới không trùng khớp'");
		verifyTrue(homepage.getTextError().contains("Xác nhận mật khẩu mới không trùng khớp"));

		log.info("TC_06_Check_Profile - Step 37: Sendkey to Mật khẩu hiện tại = " + password);
		homepage.sendkeyCurentPassword(password);

		log.info("TC_06_Check_Profile - Step 38: Sendkey to Mật khẩu mới = "+ password);
		homepage.sendkeyNewPassword(password);

		log.info("TC_06_Check_Profile - Step 39: Sendkey to Xác nhận mật khẩu = "+password);
		homepage.sendkeyConfirmPassword(password);
		
		log.info("TC_06_Check_Profile - Step 40: Click to Lưu mật khẩu");
		homepage.clickToSavePassword();

		log.info("TC_06_Check_Profile - Step 41: Check Message 'Vui lòng nhập mật khẩu không trùng với mật khẩu cũ'");
		verifyTrue(homepage.getTextError().contains("Vui lòng nhập mật khẩu không trùng với mật khẩu cũ"));

		log.info("TC_06_Check_Profile - Step 42: Sendkey to Mật khẩu hiện tại = " + password);
		homepage.sendkeyCurentPassword(password);

		log.info("TC_06_Check_Profile - Step 43: Sendkey to Mật khẩu mới = " + newPassword);
		homepage.sendkeyNewPassword(newPassword);

		log.info("TC_06_Check_Profile - Step 44: Sendkey to Xác nhận mật khẩu =" + newPassword);
		homepage.sendkeyConfirmPassword(newPassword);
		
		log.info("TC_06_Check_Profile - Step 45: Click to Lưu mật khẩu");
		homepage.clickToSavePassword();

		log.info("TC_06_Check_Profile - Step 46: Check Message 'Đổi mật khẩu thành công'");
		verifyTrue(homepage.getTextErrorFlashNotice().contains("Đổi mật khẩu thành công"));
		
		log.info("TC_06_Check_Profile - Step 47: Click to Đăng xuất");
		homepage.clickToLogoutAtProfile();

		log.info("TC_06_Check_Profile - Step 48: Sendkey to UserName At Lobby");
		homepage.sendkeyUserNameAtLobby(userName);

		log.info("TC_06_Check_Profile - Step 49: Sendkey to Password At Lobby");
		homepage.sendkeyPassWordAtLobby(newPassword);

		log.info("TC_06_Check_Profile - Step 50: Click to Login");
		homepage.clickToLoginAtLobby();
		
		log.info("TC_05_Check_Payment - Step 51: Click to Thông tin tài khoản");
		homepage.clickProfile();
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
	public String generatePhoneNumber() {
		Random random = new Random();
		return phoneNumber =  "0777" + random.nextInt(999999);
	}

}
