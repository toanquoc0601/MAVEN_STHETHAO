package TestChucNangMoi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class sendkeyToDynamicTextBoxByRowNumber extends AbstractPage {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
	}
	@Test
	public void TC_01_sendkeyToDynamicTextBoxByRowNumber() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		sendkeyToDynamicTextBoxByRowNumber1("Company", "2", "Toàn Quốc");
	}

	@Test
	public void TC_01_getTextToDynamicTextBoxByRowNumber() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		String a = getTextToDynamicTextBoxByRowNumber("Females", "1");

		System.out.println(a);

	}

	public void sendkeyToDynamicTextBoxByRowNumber1(String columnName, String rowNumber, String value) {
		String locator = "//th[contains(text(),'%s')]/preceding-sibling::*";
		int index = getElements(driver, getDynamicLocator(locator, columnName)).size() + 1;
		System.out.println(index);
		System.out.println(getElements(driver, getDynamicLocator(locator, columnName)).toString());

		locator = "(//td[" + index + "]/input)[" + rowNumber + "]";
		System.out.println(locator);
		waitToElementVisuble(driver, locator);
		sendkeyToElement(driver, locator, value);
	}

	public String getTextToDynamicTextBoxByRowNumber(String columnName, String rowNumber) {

		String locator = "//div[contains(text(),'%s')]/ancestor::th/preceding-sibling::th";
		int index = getElements(driver, getDynamicLocator(locator, columnName)).size() + 1;

		locator = "//tr[" + rowNumber + "]/td[" + index + "]";

		System.out.println(locator);
		waitToElementVisuble(driver, locator);
		return getElementText(driver, locator);
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
