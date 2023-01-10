package pageObjects;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.xo88_HomePageUI;
import pageUIs.xo88_LobbyGamePageUI;

public class xo88_LobbyGamePageObject extends AbstractPage {

	WebDriver driver;

	public xo88_LobbyGamePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLobbyGame(String string) {
		waitToElementClickable(driver, xo88_LobbyGamePageUI.DYNAMIC_BUTTON_LOBBY_GAME, string);
		clickToElement(driver, xo88_LobbyGamePageUI.DYNAMIC_BUTTON_LOBBY_GAME, string);
	}

	public int checkToCardGame() {
		return getElements(driver, "//div[@class='lobby-game-list__contain']/div").size();
	}

	public Object getTextNameCardGame(int i) {
		scrollToElement(driver, "(//div[@class='lobby-game-list__contain']/div)[" + i + "]//p");
		return getElementText(driver, "(//div[@class='lobby-game-list__contain']/div)[" + i + "]//p");
	}

	public String getParentPageID(String parentID) {
		return parentID = driver.getWindowHandle();
	}

	public void clickCardGameNumber(int i) {
		waitToElementClickable(driver, "//div[@class='lobby-game-list__contain']/div[" + i + "]//a");
		hoverMouseToElement(driver, "//div[@class='lobby-game-list__contain']/div[" + i + "]//a");
		waitToElementClickable(driver, "//div[@class='lobby-game-list__contain']/div[" + i + "]//button");
		clickToElement(driver, "//div[@class='lobby-game-list__contain']/div[" + i + "]//button");
	}

	public void switchToHomePage(String parentID) {
		driver.close();
		switchToWindowByID(driver, parentID);
	}

	public void clickToViewGame() {
		waitToElementClickable(driver, "//button[@class='base-button btn show-game']");
		clickToElement(driver, "//button[@class='base-button btn show-game']");
	}

	public String getTextTitlePage() {
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();
		while (I1.hasNext()) {
			String child_window = I1.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
			}
		}
		return getCurrenPageTitle(driver);
	}

	public boolean isButtonViewMoreVisible() {
		try {
			getElement(driver, "//a[@class='load-more__link']").isDisplayed();
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	public void clickToViewMore() {
		scrollToElement(driver, "//a[@class='load-more__link']");
		clickToElement(driver, "//a[@class='load-more__link']");
	}

}
