package pageObjects;

import org.openqa.selenium.WebDriver;

public class xo88_PageGeneratorManager {
	
	public static xo88_HomePageObject getHomePage_Xo88(WebDriver driver) {
		return new xo88_HomePageObject(driver);
	}
	
	public static xo88_AccountPageObject getAccountPage(WebDriver driver) {
		return new xo88_AccountPageObject(driver);
	}

}
