package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;
import pageUIs.xo88_AccountPageUI;
import pageUIs.xo88_HomePageUI;

public class xo88_AccountPageObject extends AbstractPage{

	WebDriver driver;
	public xo88_AccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToProfile() {
		waitToElementClickable(driver, xo88_AccountPageUI.DYNAMIC_BUTTON_ACCOUNTMENU, "Thông tin tài khoản");
		clickToElement(driver, xo88_AccountPageUI.DYNAMIC_BUTTON_ACCOUNTMENU, "Thông tin tài khoản");
	}
	public void sendkeyEmail() {
		waitToElementVisuble(driver, "//input[@type='email']");
		sendkeyToElement(driver, "//input[@type='email']", "toanquoc060196@gmail.com");
	}
	public void sendkeyPhone() {
		waitToElementVisuble(driver, "//input[@type='tel']");
		sendkeyToElement(driver, "//input[@type='tel']", "0905777888");
	}
	public void clickToSave() {
		waitToElementClickable(driver,"//span[@class='base-button__slot']");
		clickToElement(driver, "//span[@class='base-button__slot']");
	}


}
