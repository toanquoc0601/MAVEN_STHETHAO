package com.game789d.club;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import page789clubObjects.HomePageObject;

public class Canvas extends AbstractTest {

	WebDriver driver;
	HomePageObject homepage;
	String typeSport;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName);
		driver.get(url);
	}

	@Test
	public void TC_01_Check_Betting() {
		WebElement canvas = driver.findElement(By.id("GameCanvas"));
		sleepInSecond(10);
		Dimension canvas_dimensions = canvas.getSize();
        int canvas_center_x = canvas_dimensions.getWidth() / 2;
        int canvas_center_y = canvas_dimensions.getHeight() / 2;

		int button_x1 = -((canvas_center_x / 8) * 1);
		int button_y1 = -((canvas_center_y / 8) * 7);


		System.out.println(canvas_center_x);
		System.out.println(canvas_center_y);
		System.out.println(button_x1);
		System.out.println(button_y1);

		// Click button on the canvas
		log.info("Click 1");
		new Actions(driver).moveToElement(canvas, button_x1, button_y1).click().perform();
		sleepInSecond(2);
		log.info("Click 2");
		new Actions(driver).moveToElement(canvas, -100, -200).click().perform();
		driver.findElement(By.xpath("//input[@id='EditBoxId_1']")).sendKeys("Abcdef");
		sleepInSecond(2);
		log.info("Click 3");
		new Actions(driver).moveToElement(canvas, -100, -100).click().perform();
		driver.findElement(By.xpath("//input[@id='EditBoxId_2']")).sendKeys("Abcdef");
		sleepInSecond(2);
		log.info("Click 4");
		new Actions(driver).moveToElement(canvas, -100, -5).click().perform();
		driver.findElement(By.xpath("//input[@id='EditBoxId_3']")).sendKeys("Abcdef");
		sleepInSecond(2);
		log.info("Click 5");
		new Actions(driver).moveToElement(canvas, -100, 100).click().perform();
		driver.findElement(By.xpath("//input[@id='EditBoxId_4']")).sendKeys("Abcdef");
		sleepInSecond(2);
		log.info("Click 6");
		new Actions(driver).moveToElement(canvas, -100, 180).click().perform();
		driver.findElement(By.xpath("//input[@id='EditBoxId_5']")).sendKeys("Abcdef");
		sleepInSecond(2);

	}

	public void sendKeyBoardToElement(WebDriver driver, String locator, String key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}

	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(By.xpath(locator));
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private Actions action;

}
