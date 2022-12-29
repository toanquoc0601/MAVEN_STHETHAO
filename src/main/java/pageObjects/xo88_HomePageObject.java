package pageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.AbstractPage;
import pageUIs.HomePageUI;
import pageUIs.xo88_AccountPageUI;
import pageUIs.xo88_HomePageUI;

public class xo88_HomePageObject extends AbstractPage{

	WebDriver driver;
	public xo88_HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToButtonRegister() {
		waitToElementClickable(driver, xo88_HomePageUI.REGISTER);
		clickToElement(driver, xo88_HomePageUI.REGISTER);
		sleepInSecond(2);
	}

	public void clickToLogin() {
		waitToElementClickable(driver, "//span[contains(text(),'ĐĂNG NHẬP')]");
		clickToElement(driver, "//span[contains(text(),'ĐĂNG NHẬP')]");
		sleepInSecond(1);
	}

	public void clickToRegister() {
		waitToElementClickable(driver, "(//span[contains(text(),'ĐĂNG KÝ')])");
		clickToElement(driver, "(//span[contains(text(),'ĐĂNG KÝ')])");
		sleepInSecond(1);
	}

	public void sendkeyUserName(String userName) {
		waitToElementVisuble(driver, "//input[@name='username']");
		clickToElement(driver, "//input[@name='username']");
		sendkeyToElement(driver, "//input[@name='username']", userName);
	}

	public void sendkeyPassword(String passWord) {
		waitToElementVisuble(driver, "//input[@name='password']");
		clickToElement(driver, "//input[@name='password']");
		sendkeyToElement(driver, "//input[@name='password']", passWord);
	}

	public void sendkeyPhoneNumber(String phoneNumber) {
		waitToElementVisuble(driver, "//input[@name='phone']");
		clickToElement(driver, "//input[@name='phone']");
		sendkeyToElement(driver, "//input[@name='phone']", phoneNumber);
	}
	
	public void clickToButtonRegister2() {
		waitToElementClickable(driver, "(//span[@class='base-button__slot'][contains(text(),'Đăng ký')])[2]");
		clickToElement(driver, "(//span[@class='base-button__slot'][contains(text(),'Đăng ký')])[2]");
		sleepInSecond(1);
	}

	public String getTextError1UserName() {
		return getElementText(driver, "//p[contains(text(),'Vui lòng nhập tên đăng nhập')]");
	}

	public String getTextError1Password() {
		return getElementText(driver, "//p[contains(text(),'Vui lòng nhập mật khẩu')]");
	}

	public String getTextError1NumberPhone() {
		return getElementText(driver, "//p[contains(text(),'Vui lòng nhập số điện thoại')]");
	}

	public void clearTextUserName() {
		waitToElementVisuble(driver, "//input[@name='username']");
		clickToElement(driver, "//input[@name='username']");
		clearTextToElement(driver, "//input[@name='username']");
	}

	public void clearTextPassword() {
		waitToElementVisuble(driver, "//input[@name='password']");
		clickToElement(driver, "//input[@name='password']");
		clearTextToElement(driver, "//input[@name='password']");
	}

	public void clearTextPhoneNumber() {
		waitToElementVisuble(driver, "//input[@name='phone']");
		clickToElement(driver, "//input[@name='phone']");
		clearTextToElement(driver, "//input[@name='phone']");
	}

	public String getTextError2UserName() {
		return getElementText(driver, "//p[contains(text(),'Vui lòng không nhập ít hơn 6 ký tự')]");
	}

	public String getTextError2Password() {
		return getElementText(driver, "//p[contains(text(),'Vui lòng không nhập ít hơn 8 ký tự')]");
	}

	public String getTextError2NumberPhone() {
		return getElementText(driver, "//p[contains(text(),'Vui lòng không nhập ít hơn 10 chữ số')]");
	}

	public String getTextError3UserName() {
		return getElementText(driver, "//p[contains(text(),'Tên đăng nhập không chứa các ký tự đặc biệt')]");
	}

	public String getTextError3Password() {
		return getElementText(driver, "//p[contains(text(),'Mật khẩu phải tối thiểu 8 ký tự, có chứa chữ VIẾT HOA và chữ số.')]");
	}

	public String getTextError3NumberPhone() {
		return getElementText(driver, "//p[contains(text(),'Số điện thoại phải bắt đầu với số 0')]");
	}

	public boolean isButtonRegisterEnable() {
		return isElementEnable(driver, "(//span[@class='base-button__slot'][contains(text(),'Đăng ký')])[2]");
	}

	public void clickToRegisterInPopup() {
		waitToElementClickable(driver, "(//span[@class='base-button__slot'][contains(text(),'Đăng ký')])[2]");
		clickToElement(driver, "(//span[@class='base-button__slot'][contains(text(),'Đăng ký')])[2]");
		sleepInSecond(1);
	}

	public void sendkeyDisplayName(String displayName) {
		waitToElementVisuble(driver, "//input[@placeholder=' Tên hiển thị']");
		sendkeyToElement(driver, "//input[@placeholder=' Tên hiển thị']", displayName);
	}

	public void clickToConfirm() {
		waitToElementClickable(driver, "//div[@class='button-action']/button");
		clickToElement(driver, "//div[@class='button-action']/button");
		sleepInSecond(1);
	}

	public String getTextErrorDisplayName() {
		return getElementText(driver, "//p[@class='error']");
	}

	public void clickToAvatarAccount() {
		waitToElementClickable(driver, "//div[@role='button']//div[contains(@class,'user-login')]");
		clickToElement(driver, "//div[@role='button']//div[contains(@class,'user-login')]");
		sleepInSecond(1);
	}

	public void clickToLogout() {
		waitToElementClickable(driver, "//div[contains(@class,'body-logout')]");
		clickToElement(driver, "//div[contains(@class,'body-logout')]");
		sleepInSecond(1);
	}

	public void sendkeyUserNameAtLobby(String UserName) {
		waitToElementVisuble(driver, "//input[@placeholder='Tên đăng nhập']");
		sendkeyToElement(driver, "//input[@placeholder='Tên đăng nhập']", UserName);
	}

	public void sendkeyPassWordAtLobby(String Password) {
		waitToElementVisuble(driver, "//input[@placeholder='Mật khẩu']");
		sendkeyToElement(driver, "//input[@placeholder='Mật khẩu']", Password);
	}

	public String getTextErrorLogin1() {
		return getElementText(driver, "//div[@id='swal2-content']");
	}

	public void clickToForgotPassword() {
		waitToElementClickable(driver, "//div[@class='forgot-password']");
		clickToElement(driver, "//div[@class='forgot-password']");
		sleepInSecond(1);
	}

	public void sendkeyEmailAtPopup(String string) {
		waitToElementVisuble(driver, "//input[@placeholder=' Email']");
		clickToElement(driver, "//input[@placeholder=' Email']");
		sendkeyToElement(driver, "//input[@placeholder=' Email']", string);
	}

	public void clickToSumitForgotPassword() {
		waitToElementClickable(driver, "//button[contains(@class,'forgot-password__submit')]");
		clickToElement(driver, "//button[contains(@class,'forgot-password__submit')]");
		sleepInSecond(1);
	}

	public String getTextError1Email() {
		return getElementText(driver, "//p[@class='error']");
	}


	public int checkToPayment() {
		 return getElements(driver, "//div[@class='user__menu-bar']//div").size();
	}


	public String getTextTypePayment(int i) {
		return getElementText(driver, "//div[@class='user__menu-bar']//div["+i+"]//span");
	}

	public void clickToLoginAtLobby() {
		waitToElementClickable(driver, "//span[contains(text(),'Đăng nhập')]");
		clickToElement(driver, "//span[contains(text(),'Đăng nhập')]");
		sleepInSecond(1);
	}


	public void clickToDeposit() {
		waitToElementClickable(driver, xo88_AccountPageUI.DYNAMIC_BUTTON_ACCOUNTMENU,"Nạp Tiền");
		clickToElement(driver, xo88_AccountPageUI.DYNAMIC_BUTTON_ACCOUNTMENU,"Nạp Tiền");
		sleepInSecond(1);
	}

	public void clickToWithdraw() {
		waitToElementClickable(driver, xo88_AccountPageUI.DYNAMIC_BUTTON_ACCOUNTMENU," Rút Tiền");
		clickToElement(driver, xo88_AccountPageUI.DYNAMIC_BUTTON_ACCOUNTMENU," Rút Tiền");
		sleepInSecond(1);
	}

	public int checkToWithdraw() {
		 return getElements(driver, "//div[@class='user__menu-bar']//a").size();
	}
	public String getTextTypeWithdraw(int i) {
		return getElementText(driver, "//div[@class='user__menu-bar']//a["+i+"]");
	}

	public String getTextNameAccount(String displayName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void clickToButtonProfile() {
		waitToElementClickable(driver, "//span[contains(text(),'Thông tin tài khoản')]");
		clickToElement(driver, "//span[contains(text(),'Thông tin tài khoản')]");
		sleepInSecond(1);
	}

	public boolean isUserNameDisable() {
		return isElementEnable(driver, "//input[@placeholder=' Tên đăng nhập']");
	}

	public boolean isPasswordDisable() {
		return isElementEnable(driver, "//input[@placeholder=' Tên hiển thị']");
	}

	public void sendkeyEmailAtProfile(String string) {
		waitToElementVisuble(driver, "//label[text()='Email']//preceding-sibling::input");
		clickToElement(driver, "//label[text()='Email']//preceding-sibling::input");
		sendkeyToElement(driver, "//label[text()='Email']//preceding-sibling::input", string);
	}

	public void clearTextEmailAtProfile() {
		waitToElementVisuble(driver, "//label[text()='Email']//preceding-sibling::input");
		clickToElement(driver, "//label[text()='Email']//preceding-sibling::input");
		clearTextToElement(driver, "//label[text()='Email']//preceding-sibling::input");
	}

	public void clickToButtonSaveProfile() {
		waitToElementClickable(driver, "//span[@class='base-button__slot']");
		clickToElement(driver, "//span[@class='base-button__slot']");
		sleepInSecond(1);
	}

	

	
	
}
