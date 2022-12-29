package pageObjects;

import org.openqa.selenium.WebDriver;

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
		sleepInSecond(1);
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
		return getElementText(driver, "//p[contains(text(),'Tên hiển thị không trùng với tên đăng nhập.')]");
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

	

	
	
}
