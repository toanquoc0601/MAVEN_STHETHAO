package TestChucNangMoi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Upload_File extends AbstractPage {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@Parameters({ "userName1" })
	@BeforeClass
	public void beforeClass() {

	}

	public void TC_01_Upload_1_File_With_Sendkey() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		System.out.println(projectPath + "\\src\\main\\resources\\uploadFiles\\Locator_Xpath.png");

		waitToElementVisuble(driver, "//input[@name='files[]']");
		sendkeyToElement(driver, "//input[@name='files[]']",
				projectPath + "\\src\\main\\resources\\uploadFiles\\Locator_Xpath.png");

		waitToElementClickable(driver, "//span[normalize-space()='Start']");
		clickToElement(driver, "//span[normalize-space()='Start']");

	}

	@Test
	public void TC_01_Upload_Multiple_Files() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println(projectPath + "\\src\\main\\resources\\uploadFiles\\Locator_Xpath.png");

		// Mảng chứa đường dẫn đến các tập tin cần upload
		String[] filePaths = { projectPath + "\\src\\main\\resources\\uploadFiles\\Locator_Xpath.png",
				projectPath + "\\src\\main\\resources\\uploadFiles\\Locator_Xpath2.png" };
		
		for (String filePath : filePaths) {
			sendkeyToElement(driver, "//input[@name='files[]']", filePath);
			System.out.println(filePath);
		}

		for (int i = 1; i <= filePaths.length; i++) {
			 waitToElementClickable(driver, "(//span[normalize-space()='Start'])["+i+"]");
			 clickToElement(driver, "(//span[normalize-space()='Start'])["+i+"]");
		}

	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean isExisted(int[] a, int n) {
		boolean result = false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == n) {
				result = true;
			}
		}
		return result;
	}

}
