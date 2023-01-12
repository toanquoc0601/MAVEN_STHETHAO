package pageObjects;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
	}

	public void clickToLogin() {
		waitToElementClickable(driver, "//span[contains(text(),'ĐĂNG NHẬP')]");
		clickToElement(driver, "//span[contains(text(),'ĐĂNG NHẬP')]");
	}

	public void clickToRegister() {
		waitToElementClickable(driver, "(//span[contains(text(),'ĐĂNG KÝ')])");
		clickToElement(driver, "(//span[contains(text(),'ĐĂNG KÝ')])");
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
	}

	public void sendkeyDisplayName(String displayName) {
		waitToElementVisuble(driver, "//label[text()='Tên hiển thị']/preceding-sibling::input");
		clickToElement(driver, "//label[text()='Tên hiển thị']/preceding-sibling::input");
		sendkeyToElement(driver, "//label[text()='Tên hiển thị']/preceding-sibling::input", displayName);
	}

	public void clickToConfirm() {
		waitToElementClickable(driver, "(//div[@class='button-action']/button)");
		clickToElement(driver, "(//div[@class='button-action']/button)");
	}

	public String getTextErrorDisplayName() {
		return getElementText(driver, "//p[@class='error']");
	}

	public void clickToAvatarAccount() {
		waitToElementClickable(driver, "//div[@role='button']//div[contains(@class,'user-login')]");
		clickToElement(driver, "//div[@role='button']//div[contains(@class,'user-login')]");
	}

	public void clickToLogout() {
		waitToElementClickable(driver, "//div[contains(@class,'body-logout')]");
		clickToElement(driver, "//div[contains(@class,'body-logout')]");
	}

	public void sendkeyUserNameAtLobby(String UserName) {
		waitToElementVisuble(driver, "//input[@placeholder='Tên đăng nhập']");
		clearTextToElement(driver, "//input[@placeholder='Tên đăng nhập']");
		sendkeyToElement(driver, "//input[@placeholder='Tên đăng nhập']", UserName);
	}

	public void sendkeyPassWordAtLobby(String Password) {
		waitToElementVisuble(driver, "//input[@placeholder='Mật khẩu']");
		clearTextToElement(driver, "//input[@placeholder='Mật khẩu']");
		sendkeyToElement(driver, "//input[@placeholder='Mật khẩu']", Password);
	}

	public String getTextErrorFlashNotice() {
		waitToElementVisuble(driver, "//div[@id='swal2-content']");
		return getElementText(driver, "//div[@id='swal2-content']");
	}

	public void clickToForgotPassword() {
		waitToElementClickable(driver, "//div[@class='forgot-password']");
		clickToElement(driver, "//div[@class='forgot-password']");
	}

	public void sendkeyEmailAtPopup(String string) {
		waitToElementVisuble(driver, "//label[contains(text(),'Email')]/preceding-sibling::input");
		clickToElement(driver, "//label[contains(text(),'Email')]/preceding-sibling::input");
		clearTextToElement(driver, "//label[contains(text(),'Email')]/preceding-sibling::input");
		sendkeyToElement(driver, "//label[contains(text(),'Email')]/preceding-sibling::input", string);
	}

	public void clickToSumitForgotPassword() {
		waitToElementClickable(driver, "//button[contains(@class,'forgot-password__submit')]");
		clickToElement(driver, "//button[contains(@class,'forgot-password__submit')]");
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
	}


	public void clickToDeposit() {
		waitToElementClickable(driver, xo88_AccountPageUI.DYNAMIC_BUTTON_ACCOUNTMENU,"Nạp Tiền");
		clickToElement(driver, xo88_AccountPageUI.DYNAMIC_BUTTON_ACCOUNTMENU,"Nạp Tiền");
	}

	public void clickToWithdraw() {
		waitToElementClickable(driver, xo88_AccountPageUI.DYNAMIC_BUTTON_ACCOUNTMENU," Rút Tiền");
		clickToElement(driver, xo88_AccountPageUI.DYNAMIC_BUTTON_ACCOUNTMENU," Rút Tiền");
	}

	public int checkToWithdraw() {
		 return getElements(driver, "//div[@class='user__menu-bar']//a").size();
	}
	public String getTextTypeWithdraw(int i) {
		return getElementText(driver, "//div[@class='user__menu-bar']//a["+i+"]");
	}

	public String getTextNameAccount(String displayName) {
		return getElementText(driver, "//div[@class='wrapper-user-login__right--name']/span");
	}

	public void clickToButtonProfile() {
		waitToElementClickable(driver, "//span[contains(text(),'Thông tin tài khoản')]");
		clickToElement(driver, "//span[contains(text(),'Thông tin tài khoản')]");
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
	}

	public void sendkeyPhoneNumberAtProfile(String string) {
		waitToElementVisuble(driver, "//label[contains(text(),'Số điện thoại')]/preceding-sibling::input");
		clickToElement(driver, "//label[contains(text(),'Số điện thoại')]/preceding-sibling::input");
		clearTextToElement(driver, "//label[contains(text(),'Số điện thoại')]/preceding-sibling::input");
		sendkeyToElement(driver, "//label[contains(text(),'Số điện thoại')]/preceding-sibling::input", string);
	}

	public String getTextError() {
		return getElementText(driver, "//p[@class='error']");
	}

	public void clickToChangePassword() {
		waitToElementClickable(driver, "//span[contains(text(),'Thay Đổi Mật Khẩu')]");
		clickToElement(driver, "//span[contains(text(),'Thay Đổi Mật Khẩu')]");
	}

	public void sendkeyCurentPassword(String string) {
		waitToElementVisuble(driver, "//label[contains(text(),'Mật khẩu hiện tại')]/preceding-sibling::input");
		clickToElement(driver, "//label[contains(text(),'Mật khẩu hiện tại')]/preceding-sibling::input");
		clearTextToElement(driver, "//label[contains(text(),'Mật khẩu hiện tại')]/preceding-sibling::input");
		sendkeyToElement(driver, "//label[contains(text(),'Mật khẩu hiện tại')]/preceding-sibling::input", string);
	}

	public void sendkeyNewPassword(String string) {
		waitToElementVisuble(driver, "//label[contains(text(),'Mật khẩu mới')]/preceding-sibling::input");
		clickToElement(driver, "//label[contains(text(),'Mật khẩu mới')]/preceding-sibling::input");
		clearTextToElement(driver, "//label[contains(text(),'Mật khẩu mới')]/preceding-sibling::input");
		sendkeyToElement(driver, "//label[contains(text(),'Mật khẩu mới')]/preceding-sibling::input", string);
	}
	
	public void sendkeyConfirmPassword(String string) {
		waitToElementVisuble(driver, "//label[contains(text(),'Xác nhận mật khẩu mới')]/preceding-sibling::input");
		clickToElement(driver, "//label[contains(text(),'Xác nhận mật khẩu mới')]/preceding-sibling::input");
		clearTextToElement(driver, "//label[contains(text(),'Xác nhận mật khẩu mới')]/preceding-sibling::input");
		sendkeyToElement(driver, "//label[contains(text(),'Xác nhận mật khẩu mới')]/preceding-sibling::input", string);
	}

	public void clearTextDisplayName() {
		waitToElementVisuble(driver, "//label[text()='Tên hiển thị']/preceding-sibling::input");
		clickToElement(driver, "//label[text()='Tên hiển thị']/preceding-sibling::input");
		clearTextToElement(driver, "//label[text()='Tên hiển thị']/preceding-sibling::input");
	}

	public void clickToLogoutAtProfile() {
		waitToElementClickable(driver, "//span[contains(text(),'Đăng Xuất')]");
		clickToElement(driver, "//span[contains(text(),'Đăng Xuất')]");
	}

	public void clickProfile() {
		waitToElementClickable(driver, xo88_AccountPageUI.DYNAMIC_BUTTON_ACCOUNTMENU,"Thông tin tài khoản");
		clickToElement(driver, xo88_AccountPageUI.DYNAMIC_BUTTON_ACCOUNTMENU,"Thông tin tài khoản");
	}

	public void clickToSavePassword() {
		waitToElementClickable(driver, "//span[contains(text(),'Lưu Mật Khẩu')]");
		clickToElement(driver, "//span[contains(text(),'Lưu Mật Khẩu')]");
	}

	public void clickToInfoDetail(String string) {
		waitToElementClickable(driver, "(//ul[@class='list-info-detail'])[1]//a[contains(text(),'"+string+"')]");
		scrollToElement(driver, "(//ul[@class='list-info-detail'])[1]//a[contains(text(),'"+string+"')]");
		clickToElement(driver, "(//ul[@class='list-info-detail'])[1]//a[contains(text(),'"+string+"')]");
	}

	public String getTextNamePage() {
		return getElementText(driver, "//h1");
	}

	public void clickToSupportPage(String string) {
		waitToElementClickable(driver, "//span[contains(text(),'"+string+"')]/ancestor::button");
		scrollToElement(driver, "//span[contains(text(),'"+string+"')]/ancestor::button");
		clickToElement(driver, "//span[contains(text(),'"+string+"')]/ancestor::button");
	}


	public String getTextTitlePage() {
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
		String child_window=I1.next();
		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		}
		}
	
		return getCurrenPageTitle(driver);
		
	}

	public void closePage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void switchToHomePage(String string) {
		driver.close();
		switchToWindowByID(driver, string);
	}

	public String getHomePageID(String parentID) {
		return parentID = driver.getWindowHandle();
	}

	public void clickToSupportDeposit(String string) {
		waitToElementClickable(driver, "//p[contains(text(),'"+string+"')]");
		scrollToElement(driver, "//p[contains(text(),'"+string+"')]");
		clickToElement(driver, "//p[contains(text(),'"+string+"')]");
	}

	public void clickToGuideStops() {
	}

	public int checkToStepTotal() {
		return getElements(driver, "//div[@class='guide__step steps']/div").size();
	}

	public String getTextStepContent(int i) {
		return getElementText(driver, "//div[@class='guide__step steps']/div["+i+"]//div[@class='steps__content']");
	}

	public void clickToStep(int i) {
		waitToElementClickable(driver, "//div[@class='guide__step steps']/div["+i+"]//div[@class='steps__action__btn']");
		clickToElement(driver, "//div[@class='guide__step steps']/div["+i+"]//div[@class='steps__action__btn']");
	}

	public String getTextStepTitle(int i) {
		return getElementText(driver, "//div[@class='guide__step steps']/div["+i+"]/div[@class='steps__title']");
	}

	public void clickToInfoDetail2(String string) {
		waitToElementClickable(driver, "(//ul[@class='list-info-detail'])[2]//a[contains(text(),'"+string+"')]");
		scrollToElement(driver, "(//ul[@class='list-info-detail'])[2]//a[contains(text(),'"+string+"')]");
		clickToElement(driver, "(//ul[@class='list-info-detail'])[2]//a[contains(text(),'"+string+"')]");
	}

	public void clickToSport(String string) {
		waitToElementClickable(driver, xo88_HomePageUI.DYNAMIC_BUTTON_MENUBAR,string);
		clickToElement(driver, xo88_HomePageUI.DYNAMIC_BUTTON_MENUBAR,string);
		
	}

	public void clickToKSport() {
		waitToElementClickable(driver, "//a[@class='btn ksports']/parent::div");
		clickToElement(driver, "//a[@class='btn ksports']/parent::div");	
	}

	public String getTextUserNamePageKSport() {
		switchToFrame(driver, "//iframe[@name='my-frame']");
		waitToElementVisuble(driver, "//div[@class='user-name long-txt']");
		return getElementText(driver, "//div[@class='user-name long-txt']");
	}

	public void backPageSport() {
		switchToDefaulContent(driver, null);
		backToPage(driver);
	}

	public String getTextUserNamePageXO88() {
		return getElementText(driver, "//div[@class='wrapper-user-login__right--name']");
	}

	public void clickToSaBaSport() {
		waitToElementClickable(driver, "//a[@class='btn asports']/parent::div");
		clickToElement(driver, "//a[@class='btn asports']/parent::div");	
	}

	public String getTextUserNamePageSaBaSport() {
		waitToElementVisuble(driver, "//div[@class='l-text-group']/div");
		return getElementText(driver, "//div[@class='l-text-group']/div");
	}

	public void clickToBTISport(String string) {
		waitToElementClickable(driver, "//a[@class='btn msports']/parent::div");
		clickToElement(driver, "//a[@class='btn msports']/parent::div");	
	}

	public String getTextUserNamePageBTISport() {
		switchToFrame(driver, "//iframe[@name='my-frame']");
		waitToElementVisuble(driver, "//span[@data-auto='Header-Item-Username']");
		return getElementText(driver, "//span[@data-auto='Header-Item-Username']");
	}

	public void clickToSchedules() {
		waitToElementClickable(driver, "//div[@class='schedules']");
		clickToElement(driver, "//div[@class='schedules']");	
	}

	public boolean isVisibleHotMatchList() {
		return isElementDisplayed(driver, "//div[@class='league']");
	}

	public void clickToRadioCheckKSport() {
		waitToElementClickable(driver, "//p[contains(text(),'K-SPORTS')]");
		clickToElement(driver, "//p[contains(text(),'K-SPORTS')]");	
	}

	public boolean isVisibleButtonKSport() {
		return isElementDisplayed(driver, "(//span[contains(text(),'đặt cược')])[1]/parent::div[@class='btn-asport']");
	}

	public void clickToRadioCheckSaBaSport() {
		waitToElementClickable(driver, "//span[contains(text(),'SABA-SPORTS')]");
		clickToElement(driver, "//span[contains(text(),'SABA-SPORTS')]");
	}

	public boolean isVisibleButtonSaBaSport() {
		return isElementDisplayed(driver, "(//span[contains(text(),'đặt cược')])[1]/parent::div[@class='btn-ksport']");
		
	}

	public void clickToMatchToDay() {
		waitToElementClickable(driver, "//div[@class='tabs__title undefined']");
		clickToElement(driver, "//div[@class='tabs__title undefined']");
	}

	public boolean isVisibleMatchToDay() {
		return isElementDisplayed(driver, "//h1[@class='schedule-section__tilte']");
	}

	public void clickToClosePopup() {
		switchToFrame(driver, "//iframe[@name='my-frame']");
		switchToFrame(driver, "//iframe[@name='sportsFrame']");
		waitToElementClickable(driver, "//i[@class='c-icon c-icon--clear']/parent::div");
		clickToElementByJS(driver, "//i[@class='c-icon c-icon--clear']/parent::div");
	}

	public void clickToDropdownTournament() {
		waitToElementClickable(driver, "//p[contains(text(),'Chọn giải đấu')]");
		clickToElement(driver, "//p[contains(text(),'Chọn giải đấu')]");
	}

	public void clickToDropdownNumber2() {
		waitToElementClickable(driver, "//div[@class='dropdown-list']/div[2]");
		clickToElement(driver, "//div[@class='dropdown-list']/div[2]");
	}

	public String getTextDropdownSelect() {
		return getElementText(driver, "//div[@class='dropdown-list']/div[2]/span");
	}

	public String getTextTournament() {
		return getElementText(driver, "//div[@class='left']/span");
	}

	public void closePopupRandom() {
		if(isElementDisplayed(driver, "//div[@class='modal-notification__head']/img")) {
			clickToElement(driver, "//div[@class='modal-notification__head']/img");
			sleepInSecond(1);
		}
			
	}
	public void clickToVirtualSports(String string) {
		waitToElementClickable(driver, xo88_HomePageUI.DYNAMIC_BUTTON_MENUBAR, "Thể Thao");
		hoverMouseToElement(driver, xo88_HomePageUI.DYNAMIC_BUTTON_MENUBAR, "Thể Thao");
		waitToElementClickable(driver, xo88_HomePageUI.DYNAMIC_BUTTON_DROPDOWN_MENUBAR,string);
		clickToElementByJS(driver, xo88_HomePageUI.DYNAMIC_BUTTON_DROPDOWN_MENUBAR,string);
	}

	public int checkToVirtualSport() {
		return getElements(driver, "//div[@class='lobby-game-list__contain']/div").size();
	}

	public Object getTextNameVirtualSport(int i) {
		return getElementText(driver, "(//div[@class='lobby-game-list__contain']/div)["+i+"]//p");
	}

	public void sendkeyToSearch(String string) {
		waitToElementVisuble(driver, "//input[@class='input-search']");
		sendkeyToElement(driver, "//input[@class='input-search']", string);
	}

	public void clickToPlayGame() {
		waitToElementClickable(driver, "//button[contains(text(),'Chơi ngay')]");
		clickToElementByJS(driver, "//button[contains(text(),'Chơi ngay')]");
	}

	public void clickToViewGame() {
		waitToElementClickable(driver, "//button[@class='base-button btn show-game']");
		clickToElement(driver, "//button[@class='base-button btn show-game']");
	}

	public int checkToCardGame() {
		return getElements(driver, "//div[@class='lobby-game-list__contain']/div").size();
	}

	public Object getTextNameCardGame(int i) {
		scrollToElement(driver, "(//div[@class='lobby-game-list__contain']/div)["+i+"]//p");
		return getElementText(driver, "(//div[@class='lobby-game-list__contain']/div)["+i+"]//p");
	}

	public void clickCardGameNumber(int i) {
		waitToElementClickable(driver, "//div[@class='lobby-game-list__contain']/div["+i+"]");
		clickToElement(driver, "//div[@class='lobby-game-list__contain']/div["+i+"]");
	}

	
}
