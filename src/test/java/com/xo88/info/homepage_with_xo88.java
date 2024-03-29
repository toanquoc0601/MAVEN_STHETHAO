package com.xo88.info;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.xo88_AccountPageObject;
import pageObjects.xo88_HomePageObject;
import pageObjects.xo88_PageGeneratorManager;

public class homepage_with_xo88 extends AbstractTest {

	WebDriver driver;
	xo88_HomePageObject homepage;
	xo88_AccountPageObject accountpage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://xo88.info/");

	}

	String userName;
	String passWord;
	String phoneNumber;
	String displayName;
	List<WebElement> typePayment;

	@Test
	public void TC_01_Check_Register() {

		homepage = xo88_PageGeneratorManager.getHomePage_Xo88(driver);

		log.info("Tắt popup Khuyến Mãi");
		homepage.closePopupRandom();

		log.info("TC_01_Loggin - Step 01: Click to Register");
		homepage.clickToButtonRegister();

		log.info("TC_01_Loggin - Step 02: Click to Login");
		homepage.clickToLogin();

		log.info("TC_01_Loggin - Step 03: Click to Button Register");
		homepage.clickToRegister();

		log.info("TC_01_Loggin - Step 04: Sendkey to UserName = estg3hello");
		homepage.sendkeyUserName("estg3hello");

		log.info("TC_01_Loggin - Step 05: Sendkey to PassWord = Abcd1234");
		homepage.sendkeyPassword("Abcd1234");

		log.info("TC_01_Loggin - Step 06: Sendkey to PhoneNumber = 0777888aaa");
		homepage.sendkeyPhoneNumber("0777888aaa");

		log.info("TC_01_Loggin - Step 07: Click to Button Register In Popup");
		homepage.clickToButtonRegister2();

		log.info("TC_01_Loggin - Step 08: Clear text to UserName");
		homepage.clearTextUserName();

		log.info("TC_01_Loggin - Step 09: Clear text to Password");
		homepage.clearTextPassword();

		log.info("TC_01_Loggin - Step 10: Clear text to PhoneNumber");
		homepage.clearTextPhoneNumber();

		log.info("TC_01_Loggin - Step 11: Check Message 'Vui lòng nhập tên đăng nhập'");
		verifyTrue(homepage.getTextError1UserName().contains("Vui lòng nhập tên đăng nhập"));

		log.info("TC_01_Loggin - Step 12: Check Message 'Vui lòng nhập mật khẩu'");
		verifyTrue(homepage.getTextError1Password().contains("Vui lòng nhập mật khẩu"));

		log.info("TC_01_Loggin - Step 13: Check Message 'Vui lòng nhập số điện thoại'");
		verifyTrue(homepage.getTextError1NumberPhone().contains("Vui lòng nhập số điện thoại"));

		log.info("TC_01_Loggin - Step 14: Sendkey to UserName = estg3");
		homepage.sendkeyUserName("estg3");

		log.info("TC_01_Loggin - Step 15: Sendkey to PassWord = Abcd12");
		homepage.sendkeyPassword("Abcd12");

		log.info("TC_01_Loggin - Step 16: Sendkey to PhoneNumber = 077788899");
		homepage.sendkeyPhoneNumber("077788899");

		log.info("TC_01_Loggin - Step 17: Check Message 'Vui lòng không nhập ít hơn 6 ký tự'");
		verifyTrue(homepage.getTextError2UserName().contains("Vui lòng không nhập ít hơn 6 ký tự"));

		log.info("TC_01_Loggin - Step 18: Check Message 'Vui lòng không nhập ít hơn 8 ký tự'");
		verifyTrue(homepage.getTextError2Password().contains("Vui lòng không nhập ít hơn 8 ký tự"));

		log.info("TC_01_Loggin - Step 19: Check Message 'Vui lòng không nhập ít hơn 10 chữ số'");
		verifyTrue(homepage.getTextError2NumberPhone().contains("Vui lòng không nhập ít hơn 10 chữ số"));

		log.info("TC_01_Loggin - Step 20: Clear text to UserName");
		homepage.clearTextUserName();

		log.info("TC_01_Loggin - Step 21: Clear text to Password");
		homepage.clearTextPassword();

		log.info("TC_01_Loggin - Step 22: Clear text to PhoneNumber");
		homepage.clearTextPhoneNumber();

		log.info("TC_01_Loggin - Step 23: Sendkey to UserName = estg3@");
		homepage.sendkeyUserName("estg3@");

		log.info("TC_01_Loggin - Step 24: Sendkey to PassWord = abcd1234");
		homepage.sendkeyPassword("abcd1234");

		log.info("TC_01_Loggin - Step 25: Sendkey to PhoneNumber = 7778889990");
		homepage.sendkeyPhoneNumber("7778889990");

		log.info("TC_01_Loggin - Step 26: Check Message 'Tên đăng nhập không chứa các ký tự đặc biệt'");
		verifyTrue(homepage.getTextError3UserName().contains("Tên đăng nhập không chứa các ký tự đặc biệt"));

		log.info(
				"TC_01_Loggin - Step 27: Check Message 'Mật khẩu phải tối thiểu 8 ký tự, có chứa chữ VIẾT HOA và chữ số.'");
		verifyTrue(homepage.getTextError3Password()
				.contains("Mật khẩu phải tối thiểu 8 ký tự, có chứa chữ VIẾT HOA và chữ số."));

		verifyEquals(homepage.getTextError3Password(), "Mật khẩu phải tối thiểu 8 ký tự, có chứa chữ VIẾT HOA và chữ số.");
		
		log.info("TC_01_Loggin - Step 28: Check Message 'Số điện thoại phải bắt đầu với số 0'");
		verifyTrue(homepage.getTextError3NumberPhone().contains("Số điện thoại phải bắt đầu với số 0"));

		log.info("TC_01_Loggin - Step 29: Clear text to UserName");
		homepage.clearTextUserName();

		log.info("TC_01_Loggin - Step 30: Clear text to Password");
		homepage.clearTextPassword();

		log.info("TC_01_Loggin - Step 31: Clear text to PhoneNumber");
		homepage.clearTextPhoneNumber();

		homepage.sendkeyUserName(generateUserName());
		log.info("TC_01_Loggin - Step 32: Sendkey to UserName = " + userName);

		homepage.sendkeyPassword(generatePassword());
		log.info("TC_01_Loggin - Step 33: Sendkey to PassWord = " + passWord);

		homepage.sendkeyPhoneNumber(generatePhoneNumber());
		log.info("TC_01_Loggin - Step 34: Sendkey to PhoneNumber = " + phoneNumber);

		log.info("TC_01_Loggin - Step 35: Check button Register Enable");
		verifyTrue(homepage.isButtonRegisterEnable());

		log.info("TC_01_Loggin - Step 36: Click to Button Register");
		homepage.clickToRegisterInPopup();

		log.info("TC_01_Loggin - Step 37: Sendkey to DisplayName = " + userName);
		homepage.sendkeyDisplayName(userName);

		log.info("TC_01_Loggin - Step 38: Click to button Confirm");
		homepage.clickToConfirm();

		log.info("TC_01_Loggin - Step 39: Check Message 'Tên hiển thị không trùng với tên đăng nhập.'");
		verifyTrue(homepage.getTextErrorDisplayName().contains("Tên hiển thị không trùng với tên đăng nhập."));

		log.info("TC_01_Loggin - Step 40: Clear text to Tên hiển thị");
		homepage.clearTextDisplayName();

		log.info("TC_01_Loggin - Step 40: Sendkey to Tên hiển thị = est");
		homepage.sendkeyDisplayName("est");

		log.info("TC_01_Loggin - Step 41: Check Message 'Tên hiển thị yêu cầu ít nhất 4 ký tự'");
		verifyTrue(homepage.getTextErrorDisplayName().contains("Tên hiển thị yêu cầu ít nhất 4 ký tự"));

		log.info("TC_01_Loggin - Step 42: Click to button Confirm");
		homepage.clickToConfirm();

		log.info("TC_01_Loggin - Step 43: Clear text to Tên hiển thị");
		homepage.clearTextDisplayName();

		log.info("TC_01_Loggin - Step 44: Sendkey to Tên hiển thị = ét @");
		homepage.sendkeyDisplayName("ét @");

		log.info(
				"TC_01_Loggin - Step 45: Check Message 'Tên hiển thị không bao gồm chữ Tiếng Việt, không chứa ký tự đặc biệt và không chứa khoảng trắng.'");
		verifyTrue(homepage.getTextErrorDisplayName().contains(
				"Tên hiển thị không bao gồm chữ Tiếng Việt, không chứa ký tự đặc biệt và không chứa khoảng trắng."));

		log.info("TC_01_Loggin - Step 46: Clear text to Tên hiển thị");
		homepage.clearTextDisplayName();

		homepage.sendkeyDisplayName(generateDisplayName());
		log.info("TC_01_Loggin - Step 47: Sendkey to Tên hiển thị = " + displayName);

		log.info("TC_01_Loggin - Step 48: Click to button Confirm");
		homepage.clickToConfirm();

		log.info("TC_01_Loggin - Step 49: Check thông báo 'Cập nhật thông tin tài khoản thành công.'");
		verifyTrue(homepage.getTextErrorFlashNotice().contains("Cập nhật thông tin tài khoản thành công."));

		log.info("TC_01_Loggin - Step 50: Check Avatar tài khoản");
		verifyTrue(homepage.getTextNameAccount(displayName).contains(displayName));

	}

	@Test
	public void TC_02_Check_Logout() {
		log.info("TC_02_Check_Logout - Step 01: Click to Avatar Account");
		homepage.clickToAvatarAccount();

		log.info("TC_02_Check_Logout - Step 01: Click to Logout");
		homepage.clickToLogout();
	}

	@Test
	public void TC_03_Check_Login() {
		log.info("TC_03_Check_Login - Step 01: Sendkey to UserName = estg3 At Lobby");
		homepage.sendkeyUserNameAtLobby("estg3");

		log.info("TC_03_Check_Login - Step 02: Sendkey to Password = Abcd1234 At Lobby");
		homepage.sendkeyPassWordAtLobby("Abcd1234");

		log.info("TC_03_Check_Login - Step 03: Click to Đăng nhập");
		homepage.clickToLoginAtLobby();

		log.info("TC_03_Check_Login - Step 04: Check Message 'Không tìm thấy người dùng'");
		verifyTrue(homepage.getTextErrorFlashNotice().contains("Không tìm thấy người dùng"));
		System.out.println(homepage.getTextErrorFlashNotice());

		log.info("TC_03_Check_Login - Step 05: Sendkey to UserName = '' At Lobby");
		homepage.sendkeyUserNameAtLobby("");

		log.info("TC_03_Check_Login - Step 06: Sendkey to Password = 'Abcd1234' At Lobby");
		homepage.sendkeyPassWordAtLobby("Abcd1234");

		log.info("TC_03_Check_Login - Step 07: Click to Đăng nhập");
		homepage.clickToLoginAtLobby();

		log.info("TC_03_Check_Login - Step 08: Check Message 'Yêu cầu nhập tên tài khoản'");
		verifyTrue(homepage.getTextErrorFlashNotice().contains("Yêu cầu nhập tên tài khoản"));
		System.out.println(homepage.getTextErrorFlashNotice());

		log.info("TC_03_Check_Login - Step 09: Sendkey to UserName = " + userName + " At Lobby");
		homepage.sendkeyUserNameAtLobby(userName);

		log.info("TC_03_Check_Login - Step 10: Sendkey to Password = 'Abcd' At Lobby");
		homepage.sendkeyPassWordAtLobby("Abcd");

		log.info("TC_03_Check_Login - Step 11: Click to Đăng nhập");
		homepage.clickToLoginAtLobby();

		log.info("TC_03_Check_Login - Step 12: Check Message 'Tên đăng nhập và mật khẩu không đúng'");
		verifyTrue(homepage.getTextErrorFlashNotice().contains("Tên đăng nhập và mật khẩu không đúng"));
		System.out.println(homepage.getTextErrorFlashNotice());
	}

	@Test
	public void TC_04_Check_Forgot_Password() {
		log.info("TC_04_Check_Forgot_Password - Step 1: Click to Forgot Passowrd");
		homepage.clickToForgotPassword();

		log.info("TC_04_Check_Forgot_Password - Step 2: Sendkey to Email = 'estg3hello' At Lobby");
		homepage.sendkeyEmailAtPopup("estg3hello");

		log.info("TC_04_Check_Forgot_Password - Step 3: Click to button Confirm");
		homepage.clickToSumitForgotPassword();

		log.info("TC_04_Check_Forgot_Password - Step 4: Check Message 'Địa chỉ email không hợp lệ'");
		verifyTrue(homepage.getTextError1Email().contains("Địa chỉ email không hợp lệ"));

		log.info("TC_04_Check_Forgot_Password - Step 5: Sendkey to Email = 'estg3hello@yopmail.com' At Lobby");
		homepage.sendkeyEmailAtPopup("estg3hello@yopmail.com");

		log.info("TC_04_Check_Forgot_Password - Step 6: Click to button Confirm");
		homepage.clickToSumitForgotPassword();

		log.info("TC_04_Check_Forgot_Password - Step 7: Check thông báo 'Email không tồn tại trong hệ thống.'");
		verifyTrue(homepage.getTextErrorFlashNotice().contains("Email không tồn tại trong hệ thống."));

		log.info("TC_04_Check_Forgot_Password - Step 5: Sendkey to Email = 'taptap.valkyle512@gmail.com' At Lobby");
		homepage.sendkeyEmailAtPopup("taptap.valkyle512@gmail.com");

		log.info("TC_04_Check_Forgot_Password - Step 6: Click to button Confirm");
		homepage.clickToSumitForgotPassword();

		log.info(
				"TC_04_Check_Forgot_Password - Step 7: Check thông báo 'Vui lòng kiểm tra Email để thay đổi mật khẩu.'");
		verifyTrue(homepage.getTextErrorFlashNotice().contains("Vui lòng kiểm tra Email để thay đổi mật khẩu."));
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
		return userName = "estg3" + random.nextInt(9999);
	}

	public String generatePassword() {
		Random random = new Random();
		return passWord = "Abc" + random.nextInt(9999999);
	}

	public String generateDisplayName() {
		Random random = new Random();
		return displayName = "estg3" + random.nextInt(99999);
	}

	public String generatePhoneNumber() {
		Random random = new Random();
		return phoneNumber = "0909" + random.nextInt(999999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
