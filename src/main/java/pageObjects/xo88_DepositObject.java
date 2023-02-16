package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.xo88_DepositUI;
import pageUIs.xo88_HomePageUI;

public class xo88_DepositObject extends AbstractPage{

	WebDriver driver;
	public xo88_DepositObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToDepositAtHeader() {
		waitToElementClickable(driver, xo88_DepositUI.DEPOSIT_AT_HEADER);
		clickToElement(driver, xo88_DepositUI.DEPOSIT_AT_HEADER);
	}
	public void clickToLogoXOAtHeader() {
		waitToElementClickable(driver, xo88_DepositUI.LOGOXO_88_AT_HEADER);
		clickToElement(driver, xo88_DepositUI.LOGOXO_88_AT_HEADER);
	}
	public void clickToAvatarUserAtHeader() {
		waitToElementClickable(driver, xo88_DepositUI.LOGOXO_88_AT_HEADER);
		clickToElement(driver, xo88_DepositUI.LOGOXO_88_AT_HEADER);
	}
	public void sendkeyToNumberMoneyAtPaywin(String string) {
		waitToElementVisuble(driver, xo88_DepositUI.NUMBER_MONEY_AT_PAYWIN);
//		clickToElement(driver, xo88_DepositUI.NUMBER_MONEY_AT_PAYWIN);
		sendkeyToElement(driver, xo88_DepositUI.NUMBER_MONEY_AT_PAYWIN, string);
	}
	public void clickToNextAtPaywin() {
		waitToElementClickable(driver, xo88_DepositUI.NEXT_AT_PAYWIN);
		clickToElement(driver, xo88_DepositUI.NEXT_AT_PAYWIN);
	}
	public String getTextErrorAtPaywin() {
		return getElementText(driver, xo88_DepositUI.TEXT_ERROR_AT_PAYWIN);
	}
	public void clearTextToNumberMoneyAtPaywin() {
		waitToElementVisuble(driver, xo88_DepositUI.NUMBER_MONEY_AT_PAYWIN);
		clickToElement(driver, xo88_DepositUI.NUMBER_MONEY_AT_PAYWIN);
		clearTextToElement(driver, xo88_DepositUI.NUMBER_MONEY_AT_PAYWIN);
	}
	public void clickToPaywinAtMenubar() {
		waitToElementClickable(driver, xo88_DepositUI.PAYWIN_MENUBAR_AT_HEADER);
		clickToElement(driver, xo88_DepositUI.PAYWIN_MENUBAR_AT_HEADER);
		
	}
	public void switchToHomePage(String string) {
		driver.close();
		switchToWindowByID(driver, string);
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
	public int checkPromotion() {
		return getElements(driver, "//p[text()='Chọn Khuyến mãi']/following-sibling::div/label").size();
	}
	public void clickToTypePromotion(int i) {
		waitToElementClickable(driver, xo88_DepositUI.DYNAMIC_TYPE_PROMOTION, i);
		clickToElement(driver, xo88_DepositUI.DYNAMIC_TYPE_PROMOTION, i);
	}
	public String getHomePageID(String parentID) {
		return parentID = driver.getWindowHandle();
	}
	public int checkTypeBank() {
		return getElements(driver, "//div[@class='base-bank-slider']//div[@class='swiper-wrapper']//div").size();
	}
	public void clickToBankAtBankSlide(int i) {
		waitToElementClickable(driver, xo88_DepositUI.DYNAMIC_TYPE_BANK_AT_BANK_SLIDE, i);
		clickToElementByJS(driver, xo88_DepositUI.DYNAMIC_TYPE_BANK_AT_BANK_SLIDE, i);
		
	}
	public void clickToButtonCoppyAtBankInfo(int i) {
		waitToElementClickable(driver, xo88_DepositUI.DYNAMIC_BUTTON_COPPY_AT_BANK_INFO, i);
		clickToElement(driver, xo88_DepositUI.DYNAMIC_BUTTON_COPPY_AT_BANK_INFO, i);
	}
	public String getTextButtonCoppyAtBankInfo(int i) {
		return getElementText(driver, xo88_DepositUI.DYNAMIC_BUTTON_COPPY_AT_BANK_INFO, i);
	}
	public void clickToCodepayAtMenubar() {
		waitToElementClickable(driver, xo88_DepositUI.CODEPAY_MENUBAR_AT_HEADER);
		clickToElement(driver, xo88_DepositUI.CODEPAY_MENUBAR_AT_HEADER);
	}


}
