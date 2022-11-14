package page789clubObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.Game789Club_HomePageUI;


public class HomePageObject extends AbstractPage{
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToAsiaViewButton() {
		highlightElement(driver, "//a[@class='asian-view']");
		waitToElementClickable(driver, "//a[@class='asian-view']");
		clickToElement(driver, "//a[@class='asian-view']");
	}
	public void clickToSportButton() {
		waitToElementClickable(driver, "//div[@class='master_fe_ViewStyles_asianNavTabs']//div[2]");
		highlightElement(driver, "//div[@class='master_fe_ViewStyles_asianNavTabs']//div[2]");
		clickToElement(driver, "//div[@class='master_fe_ViewStyles_asianNavTabs']//div[2]");
	}
	public void clickToEarltBetButton() {
		waitToElementClickable(driver, "//div[@class='navigation_asia_fe_Sport_dropDownContainer']//div[3]/span[1]");
		highlightElement(driver, "//div[@class='navigation_asia_fe_Sport_dropDownContainer']//div[3]/span[1]");
		clickToElement(driver, "//div[@class='navigation_asia_fe_Sport_dropDownContainer']//div[3]/span[1]");
	}
	public void clickToAnyBetButton() {
		waitToElementClickable(driver, "//span[@class='eventlist_asia_fe_OddsArrow_oddsArrowNumber']");
		highlightElement(driver, "//span[@class='eventlist_asia_fe_OddsArrow_oddsArrowNumber']");
		clickToElement(driver, "//span[@class='eventlist_asia_fe_OddsArrow_oddsArrowNumber']");
	}
	public void switchToFrameBetSlipApp() {
		switchToFrame(driver, "//iframe[@title='betSlipApp']");
	}
	public void clickToMinusButton() {
		highlightElement(driver, "//button[contains(text(),'-')]");
		if(isElementEnable(driver, "//button[contains(text(),'-')]")) {
		waitToElementClickable(driver, "//button[contains(text(),'-')]");
		clickToElement(driver, "//button[contains(text(),'-')]");
		}
	}
	public void clickToPlusButton() {
		waitToElementClickable(driver, "//button[@value='+']");
		highlightElement(driver, "//button[@value='+']");
		clickToElement(driver, "//button[@value='+']");
	}
	public void clickToPlus5Button() {
		waitToElementClickable(driver, "//button[text()='+5']");
		clickToElement(driver, "//button[text()='+5']");
	}
	public void clickToMinus1Button() {
		highlightElement(driver, "//button[contains(text(),'-')]");
		if(isElementEnable(driver, "//button[contains(text(),'-')]")) {
		waitToElementClickable(driver, "//button[contains(text(),'-')]");
		clickToElement(driver, "//button[contains(text(),'-')]");
		}
		
	}
	
	public void clickClearAllButton() {
		waitToElementClickable(driver, "//button[@class='betslip_fe_PlaceBetBlock_clearAll']");
		clickToElement(driver, "//button[@class='betslip_fe_PlaceBetBlock_clearAll']");
	}
	public void switchToFrameDefaul() {
		switchToDefaulContent(driver, null);
	}
	public void clickToAnyBetForm2Button() {
		
		waitToElementClickable(driver, "//span[@class='eventlist_asia_fe_OddsArrow_oddsArrowNumber']");
		highlightElement(driver, "//span[@class='eventlist_asia_fe_OddsArrow_oddsArrowNumber']");
		clickToElement(driver, "//span[@class='eventlist_asia_fe_OddsArrow_oddsArrowNumber']");
	}
	public void clickToSumitBetButton() {
		waitToElementClickable(driver, "//button[@class='betslip_fe_PlaceBetBlock_submit']");
		clickToElement(driver, "//button[@class='betslip_fe_PlaceBetBlock_submit']");
	}
	public void clickToDeleteAllButton() {
		waitToElementClickable(driver, "//button[@class='betslip_fe_PlaceBetBlock_clearAll']");
		clickToElement(driver, "//button[@class='betslip_fe_PlaceBetBlock_clearAll']");
	}
	public void clickToBetSlipButton() {
		waitToElementClickable(driver, "//div[@class='master_fe_ViewStyles_asianNavTabs']//div[1]");
		clickToElement(driver, "//div[@class='master_fe_ViewStyles_asianNavTabs']//div[1]");
	}
	public void clickToMyBetSlipButton() {
		waitToElementClickable(driver, "//div[@class='betslip_fe_DesktopView_systemButtonsWrapper']//div[1]//button");
		clickToElement(driver, "//div[@class='betslip_fe_DesktopView_systemButtonsWrapper']//div[1]//button");
	}
	public void clickToAmountButton() {
		waitToElementClickable(driver, "//div[@class='betslip_fe_MyBets_item'][1]//div[@class='betslip_fe_CashOutButton_wrapper']");
		clickToElement(driver, "//div[@class='betslip_fe_MyBets_item'][1]//div[@class='betslip_fe_CashOutButton_wrapper']");
	}
	public String getTextCashOutButton(String suggetAmount) {
		waitToElementClickable(driver, "//div[@class='betslip_fe_MyBets_item'][1]//div[@class='betslip_fe_CashOutButton_wrapper']");
		suggetAmount = getElementText(driver, "//div[@class='betslip_fe_MyBets_item'][1]//div[@class='betslip_fe_CashOutButton_wrapper']//span[1]");
		return suggetAmount;
	}
	public void clickToAmountAgainButton() {
		waitToElementClickable(driver, "//div[@class='betslip_fe_MyBets_item'][1]//div[@class='betslip_fe_CashOutButton_wrapper']");
		clickToElement(driver, "//div[@class='betslip_fe_MyBets_item'][1]//div[@class='betslip_fe_CashOutButton_wrapper']");
		
	}
	public void clickToViewAllButton() {
		waitToElementClickable(driver, "//button[contains(text(),'Xem tất cả')]");
		clickToElement(driver, "//button[contains(text(),'Xem tất cả')]");
	}
	public void clickToShowDetailsButton() {
		waitToElementClickable(driver, "//div[@data-auto='OpenBets-Item'][1]//div[@data-auto = 'Bets-Item-ShowDetails']");
		clickToElement(driver, "//div[@data-auto='OpenBets-Item'][1]//div[@data-auto = 'Bets-Item-ShowDetails']");
	}
	public void clickToCashOutButton() {
		waitToElementClickable(driver, "//div[@class='master_fe_CashOutButton_wrapper'][1]");
		clickToElement(driver, "//div[@class='master_fe_CashOutButton_wrapper'][1]");
	}
	public void clicToSwitchOutCashButton() {
		waitToElementClickable(driver, "//div[@class='master_fe_TwoTabsFilter_filter']//div[2]");
		clickToElement(driver, "//div[@class='master_fe_TwoTabsFilter_filter']//div[2]");
	}
	public void clickToAllCashButton() {
		waitToElementClickable(driver, "//div[@class='master_fe_TwoTabsFilter_filter']//div[1]");
		clickToElement(driver, "//div[@class='master_fe_TwoTabsFilter_filter']//div[1]");
	}
	public void clickToCloseButton() {
		waitToElementClickable(driver, "//div[@class='components-fe_Popup_iconClose master_fe_ViewStyles_defaultCloseButton']");
		clickToElement(driver, "//div[@class='components-fe_Popup_iconClose master_fe_ViewStyles_defaultCloseButton']");
	}

	public void clickToPlus100Button() {
		waitToElementClickable(driver, "//button[text()='+100']");
		clickToElement(driver, "//button[text()='+100']");
	}

	public void clickToPlus500Button() {
		waitToElementClickable(driver, "//button[text()='+500']");
		clickToElement(driver, "//button[text()='+500']");
	}

	public boolean isDisableSumitButton() {
		return isElementEnable(driver, "//button[@class='betslip_fe_PlaceBetBlock_submit']");
	}

	public void clickToBackBetSlipButton() {
		// TODO Auto-generated method stub
		
	}

	public void switchToFrameBetSlipIframe() {
		switchToFrame(driver, "//iframe[@title='Betslip-Iframe']");
	}

	public String getTextBetSuccess() {
		// TODO Auto-generated method stub
		return getElementText(driver, "//div[contains(text(),'Cược được chấp nhận')]");
	}

	public void clickToTypeSportButton(String typeSport) {
		waitToElementClickable(driver, Game789Club_HomePageUI.TYPESPORT_BUTTON, typeSport);
		clickToElement(driver, Game789Club_HomePageUI.TYPESPORT_BUTTON, typeSport);
		
	}

	public void clickToTypeTime(String typeTime) {
		waitToElementClickable(driver, Game789Club_HomePageUI.TYPETIME_BUTTON, typeTime);
		clickToElement(driver, Game789Club_HomePageUI.TYPETIME_BUTTON, typeTime);
	}

	public void clickToHistoryBet() {
		// TODO Auto-generated method stub
		
	}

	public void clickToDropdown() {
		// TODO Auto-generated method stub
		
	}

	public void clickToDropdownTimeSelect() {
		// TODO Auto-generated method stub
		
	}

	public void clickToShowTimeButton() {
		// TODO Auto-generated method stub
		
	}

	public void clickToBackButton() {
		// TODO Auto-generated method stub
		
	}

	public void clickToMoreCellButton() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
