package com.xo88.info;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.xo88_AccountPageObject;
import pageObjects.xo88_HomePageObject;
import pageObjects.xo88_LobbyGamePageObject;
import pageObjects.xo88_PageGeneratorManager;

public class page_ext_link_with_xo88 extends AbstractTest {

	WebDriver driver;
	xo88_HomePageObject homepage;
	xo88_AccountPageObject accountpage;
	xo88_LobbyGamePageObject lobbygamepage;
	String userNameXo88;

	String userName = "kakute05";
	String password = "Quoc782442";
	String tournamentName;
	int typeVirtualSport;
	int typeCardGame;
	String parentID;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://xo88.info/");
	}

	@Test
	public void TC_01_Login_Account() {
		homepage = xo88_PageGeneratorManager.getHomePage_Xo88(driver);

		log.info("Tắt popup Khuyến Mãi");
		homepage.closePopupRandom();

		log.info("TC_05_Check_Payment - Step 01: Sendkey to UserName At Lobby");
		homepage.sendkeyUserNameAtLobby(userName);

		log.info("TC_05_Check_Payment - Step 02: Sendkey to Password At Lobby");
		homepage.sendkeyPassWordAtLobby(password);

		log.info("TC_05_Check_Payment - Step 03: Click to Login");
		homepage.clickToLoginAtLobby();
	}

	public void TC_02_Check_Link_Ext() {

		log.info("TC_01_Check_Link_Ext - Step 01: Click to Thể Thao từ MenuBar");
		homepage.clickToSport("Thể Thao");

		log.info("TC_01_Check_Link_Ext - Step 01: Click to K SPORTS");
		homepage.clickToKSport();

		userNameXo88 = homepage.getTextUserNamePageXO88();
		log.info("TC_01_Check_Link_Ext - Step 02: Check Tên hiển thị K SPORT = Tên hiển thị XO88");
		verifyTrue(homepage.getTextUserNamePageKSport().contains(userNameXo88));

		log.info("TC_01_Check_Link_Ext - Step 01: Trở về trang Thể Thao");
		homepage.backPageSport();

		log.info("TC_01_Check_Link_Ext - Step 01: Click to SABA SPORTS");
		homepage.clickToSaBaSport();

		homepage.clickToClosePopup();

		log.info("TC_01_Check_Link_Ext - Step 02: Check Tên hiển thị SABA SPORT = Tên hiển thị XO88");
		verifyTrue(homepage.getTextUserNamePageSaBaSport().contains("xo88_" + userName));

		log.info("TC_01_Check_Link_Ext - Step 01: Trở về trang Thể Thao");
		homepage.backPageSport();

		log.info("TC_01_Check_Link_Ext - Step 01: Click to BTI SPORTS");
		homepage.clickToBTISport("");

		log.info("TC_01_Check_Link_Ext - Step 02: Check Tên hiển thị BTI SPORT = Tên hiển thị XO88");
		verifyTrue(homepage.getTextUserNamePageBTISport().contains("xo88_" + userName));

		log.info("TC_01_Check_Link_Ext - Step 01: Trở về trang Thể Thao");
		homepage.backPageSport();

		log.info("TC_01_Check_Link_Ext - Step 01: Click to Xem thêm");
		homepage.clickToSchedules();

		log.info("TC_01_Check_Link_Ext - Step 01: Check Trận đấu hot xuất hiện");
		verifyTrue(homepage.isVisibleHotMatchList());

		// p[contains(text(),'K-SPORTS')]
		log.info("TC_01_Check_Link_Ext - Step 01: Click to radio check K-SPORT");
		homepage.clickToRadioCheckKSport();

		log.info("TC_01_Check_Link_Ext - Step 01: Check Button Đặt Cược K-SPORT xuất hiện");
		verifyTrue(homepage.isVisibleButtonKSport());

		// p[contains(text(),'SABA-SPORTS')]
		log.info("TC_01_Check_Link_Ext - Step 01: Click to radio check SABA-SPORT");
		homepage.clickToRadioCheckSaBaSport();

		log.info("TC_01_Check_Link_Ext - Step 01: Check Button Đặt Cược SABA-SPORT xuất hiện");
		verifyTrue(homepage.isVisibleButtonSaBaSport());

		log.info("TC_01_Check_Link_Ext - Step 01: Click to Kèo Bóng Hôm Nay");
		homepage.clickToMatchToDay();

		log.info("TC_01_Check_Link_Ext - Step 01: Check Lịch bóng đá ngày hôm nay");
		verifyTrue(homepage.isVisibleMatchToDay());

		// p[contains(text(),'K-SPORTS')]
		log.info("TC_01_Check_Link_Ext - Step 01: Click to radio check K-SPORT");
		homepage.clickToRadioCheckKSport();

		log.info("TC_01_Check_Link_Ext - Step 01: Check Button Đặt Cược K-SPORT xuất hiện");
		verifyTrue(homepage.isVisibleButtonKSport());

		// p[contains(text(),'SABA-SPORTS')]
		log.info("TC_01_Check_Link_Ext - Step 01: Click to radio check SABA-SPORT");
		homepage.clickToRadioCheckSaBaSport();

		log.info("TC_01_Check_Link_Ext - Step 01: Check Button Đặt Cược SABA-SPORT xuất hiện");
		verifyTrue(homepage.isVisibleButtonSaBaSport());

		log.info("TC_01_Check_Link_Ext - Step 01: Click to Dropdown Chọn Giải Đấu");
		homepage.clickToDropdownTournament();
		tournamentName = homepage.getTextDropdownSelect();

		log.info("TC_01_Check_Link_Ext - Step 01: Click check Dropdown Giải đầu tiên");
		homepage.clickToDropdownNumber2();

		verifyTrue(homepage.getTextTournament().contains(tournamentName));
		log.info("TC_01_Check_Link_Ext - Step 01: Check Tên giải đấu được chọn đúng " + tournamentName + " = "
				+ homepage.getTextTournament());
	}

	public void TC_03_Check_Link_Ext_Virtual_Sports() {
		log.info("TC_03_Check_Link_Ext_Virtual_Sports - Step 01: Click to Thể Thao từ MenuBar");
		homepage.clickToVirtualSports("Thể Thao Ảo");

		typeVirtualSport = homepage.checkToVirtualSport();
		log.info("TC_03_Check_Link_Ext_Virtual_Sports - Step 02: Có " + typeVirtualSport + " game Ảo");
		for (int i = 1; i < typeVirtualSport + 1; i++) {
			log.info("TC_03_Check_Link_Ext_Virtual_Sports - Game " + i + " '"
					+ homepage.getTextNameVirtualSport(i).toString() + "'");
		}

		log.info("TC_03_Check_Link_Ext_Virtual_Sports - Step 03: Sendkey 'Tennis' to Tìm Kiếm");
		homepage.sendkeyToSearch("Tennis");

		// log.info("TC_03_Check_Link_Ext_Virtual_Sports - Step 04: Click to Chơi
		// Ngay");
		// homepage.clickToPlayGame();

		// log.info("TC_03_Check_Link_Ext_Virtual_Sports - Step 04: Click to Vào Xem
		// Game");
		// homepage.clickToViewGame();
	}

	public void TC_04_Check_Link_Ext_Card_Game() {
		log.info("TC_01_Check_Link_Ext - Step 01: Click to Game Bài từ MenuBar");
		homepage.clickToSport("Game Bài");

		typeCardGame = homepage.checkToCardGame();
		log.info("TC_03_Check_Link_Ext_Virtual_Sports - Step 02: Có " + typeCardGame + " game Ảo");
		for (int i = 1; i < typeCardGame + 1; i++) {
			log.info("TC_03_Check_Link_Ext_Virtual_Sports - Game " + i + " '"
					+ homepage.getTextNameCardGame(i).toString() + "'");
		}

		homepage.getHomePageID(parentID);

		for (int i = 1; i < typeCardGame + 1; i++) {
			homepage.clickCardGameNumber(i);
			homepage.clickToViewGame();
			log.info("TC_02_Check_Link_Int_HomePage - ------- " + homepage.getTextNameCardGame(i).toString() + " = "
					+ homepage.getTextTitlePage());
			homepage.switchToHomePage(parentID);
		}
	}

	public void TC_05_Check_Link_Ext_Lobby_Game() {
		log.info("TC_05_Check_Link_Ext_Lobby_Game - Step 01: Click to Sảnh Game XO từ MenuBar");
		homepage.clickToSport("Sảnh Game XO");

		lobbygamepage = xo88_PageGeneratorManager.getLobbyGamePage(driver);

		log.info("TC_05_Check_Link_Ext_Lobby_Game - Step 02: Click to Bắn Cá từ Lobby Game");
		lobbygamepage.clickToLobbyGame("Bắn Cá");

		int typeGame = lobbygamepage.checkToCardGame();
		log.info("TC_05_Check_Link_Ext_Lobby_Game - Step 02: Có " + typeGame + " game Bắn Cá");
		for (int i = 1; i < typeGame + 1; i++) {
			log.info("TC_05_Check_Link_Ext_Lobby_Game - Game " + i + " '"
					+ lobbygamepage.getTextNameCardGame(i).toString() + "'");
		}
		lobbygamepage.getParentPageID(parentID);
		for (int i = 1; i < typeGame + 1; i++) {
			lobbygamepage.clickCardGameNumber(i);
			lobbygamepage.clickToViewGame();
			log.info("TC_05_Check_Link_Ext_Lobby_Game - ------- " + lobbygamepage.getTextNameCardGame(i).toString()
					+ " = " + lobbygamepage.getTextTitlePage());
			lobbygamepage.switchToHomePage(parentID);
		}
	}

	public void TC_06_Check_Link_Ext_Lobby_Game_GameFlash() {

		log.info("TC_05_Check_Link_Ext_Lobby_Game - Step 01: Click to Sảnh Game XO từ MenuBar");
		homepage.clickToSport("Sảnh Game XO");

		lobbygamepage = xo88_PageGeneratorManager.getLobbyGamePage(driver);

		log.info("TC_06_Check_Link_Ext_Lobby_Game_GameFlash - Step 02: Click to Games Nhanh từ Lobby Game");
		lobbygamepage.clickToLobbyGame("Games Nhanh");
		for (int i = 1; i < 10; i++) {
				if (!lobbygamepage.isButtonViewMoreVisible()) {
					break ;
				}
				else {
					lobbygamepage.clickToViewMore();
				}
		}
	
		int typeGame = lobbygamepage.checkToCardGame();
		log.info("TC_06_Check_Link_Ext_Lobby_Game_GameFlash - Step 02: Có " + typeGame + " Games Nhanh");
		for (int i = 1; i < typeGame + 1; i++) {
			log.info("TC_06_Check_Link_Ext_Lobby_Game_GameFlash - Game " + i + " '"
					+ lobbygamepage.getTextNameCardGame(i).toString() + "'");
		}
		lobbygamepage.getParentPageID(parentID);
		for (int i = 1; i < typeGame + 1; i++) {
			lobbygamepage.clickCardGameNumber(i);
			lobbygamepage.clickToViewGame();
			log.info("TC_06_Check_Link_Ext_Lobby_Game_GameFlash - ------- "
					+ lobbygamepage.getTextNameCardGame(i).toString() + " = " + lobbygamepage.getTextTitlePage());
			lobbygamepage.switchToHomePage(parentID);
		}
	}
	
	public void TC_07_Check_Link_Ext_Lobby_Game_InGame() {

		log.info("TC_05_Check_Link_Ext_Lobby_Game - Step 01: Click to Sảnh Game XO từ MenuBar");
		homepage.clickToSport("Sảnh Game XO");

		lobbygamepage = xo88_PageGeneratorManager.getLobbyGamePage(driver);

		log.info("TC_06_Check_Link_Ext_Lobby_Game_GameFlash - Step 02: Click to Games Nhanh từ Lobby Game");
		lobbygamepage.clickToLobbyGame("INGAME");
		for (int i = 1; i < 10; i++) {
				if (!lobbygamepage.isButtonViewMoreVisible()) {
					break ;
				}
				else {
					lobbygamepage.clickToViewMore();
				}
		}
	
		int typeGame = lobbygamepage.checkToCardGame();
		log.info("TC_06_Check_Link_Ext_Lobby_Game_GameFlash - Step 02: Có " + typeGame + " INGAME");
		for (int i = 1; i < typeGame + 1; i++) {
			log.info("TC_06_Check_Link_Ext_Lobby_Game_GameFlash - Game " + i + " '"
					+ lobbygamepage.getTextNameCardGame(i).toString() + "'");
		}
		lobbygamepage.getParentPageID(parentID);
		for (int i = 1; i < typeGame + 1; i++) {
			lobbygamepage.clickCardGameNumber(i);
			lobbygamepage.clickToViewGame();
			log.info("TC_06_Check_Link_Ext_Lobby_Game_GameFlash - ------- "
					+ lobbygamepage.getTextNameCardGame(i).toString() + " = " + lobbygamepage.getTextTitlePage());
			lobbygamepage.switchToHomePage(parentID);
		}
	}
	
	public void TC_08_Check_Link_Ext_Lobby_Game_Jackpot() {

		log.info("TC_08_Check_Link_Ext_Lobby_Game_Jackpot - Step 01: Click to Sảnh Game XO từ MenuBar");
		homepage.clickToSport("Sảnh Game XO");

		lobbygamepage = xo88_PageGeneratorManager.getLobbyGamePage(driver);

		log.info("TC_08_Check_Link_Ext_Lobby_Game_Jackpot - Step 02: Click to Jackpot từ Lobby Game");
		lobbygamepage.clickToLobbyGame("Nổ Hũ");
		for (int i = 1; i < 10; i++) {
				if (!lobbygamepage.isButtonViewMoreVisible()) {
					break ;
				}
				else {
					lobbygamepage.clickToViewMore();
				}
		}
	
		int typeGame = lobbygamepage.checkToCardGame();
		log.info("TC_08_Check_Link_Ext_Lobby_Game_Jackpot - Step 02: Có " + typeGame + " Nổ Hũ");
		for (int i = 1; i < typeGame + 1; i++) {
			log.info("TC_08_Check_Link_Ext_Lobby_Game_Jackpot - Game " + i + " '"
					+ lobbygamepage.getTextNameCardGame(i).toString() + "'");
		}
		lobbygamepage.getParentPageID(parentID);
		for (int i = 1; i < typeGame + 1; i++) {
			lobbygamepage.clickCardGameNumber(i);
			lobbygamepage.clickToViewGame();
			log.info("TC_08_Check_Link_Ext_Lobby_Game_Jackpot - ------- "
					+ lobbygamepage.getTextNameCardGame(i).toString() + " = " + lobbygamepage.getTextTitlePage());
			lobbygamepage.switchToHomePage(parentID);
		}
	}
	
	public void TC_09_Check_Link_Ext_Lobby_Game_Keno() {

		log.info("TC_09_Check_Link_Ext_Lobby_Game_Keno - Step 01: Click to Sảnh Game XO từ MenuBar");
		homepage.clickToSport("Sảnh Game XO");

		lobbygamepage = xo88_PageGeneratorManager.getLobbyGamePage(driver);

		log.info("TC_09_Check_Link_Ext_Lobby_Game_Keno - Step 02: Click to Quay số, Keno từ Lobby Game");
		lobbygamepage.clickToLobbyGame("Quay Số, Keno");
		for (int i = 1; i < 10; i++) {
				if (!lobbygamepage.isButtonViewMoreVisible()) {
					break ;
				}
				else {
					lobbygamepage.clickToViewMore();
				}
		}
	
		int typeGame = lobbygamepage.checkToCardGame();
		log.info("TC_09_Check_Link_Ext_Lobby_Game_Keno - Step 02: Có " + typeGame + " Keno");
		for (int i = 1; i < typeGame + 1; i++) {
			log.info("TC_09_Check_Link_Ext_Lobby_Game_Keno - Game " + i + " '"
					+ lobbygamepage.getTextNameCardGame(i).toString() + "'");
		}
		lobbygamepage.getParentPageID(parentID);
		for (int i = 1; i < typeGame + 1; i++) {
			lobbygamepage.clickCardGameNumber(i);
			lobbygamepage.clickToViewGame();
			log.info("TC_09_Check_Link_Ext_Lobby_Game_Keno - ------- "
					+ lobbygamepage.getTextNameCardGame(i).toString() + " = " + lobbygamepage.getTextTitlePage());
			lobbygamepage.switchToHomePage(parentID);
		}
	}
	
	public void TC_10_Check_Link_Ext_Lobby_Game_Slots() {

		log.info("TC_10_Check_Link_Ext_Lobby_Game_Slots - Step 01: Click to Sảnh Game XO từ MenuBar");
		homepage.clickToSport("Sảnh Game XO");

		lobbygamepage = xo88_PageGeneratorManager.getLobbyGamePage(driver);

		log.info("TC_10_Check_Link_Ext_Lobby_Game_Slots - Step 02: Click to Slots từ Lobby Game");
		lobbygamepage.clickToLobbyGame("Slots");
		for (int i = 1; i < 15; i++) {
				if (!lobbygamepage.isButtonViewMoreVisible()) {
					break ;
				}
				else {
					lobbygamepage.clickToViewMore();
				}
		}
		int typeGame = lobbygamepage.checkToCardGame();
		log.info("TC_10_Check_Link_Ext_Lobby_Game_Slots - Step 02: Có " + typeGame + "game Slots");
		for (int i = 1; i < typeGame + 1; i++) {
			log.info("TC_10_Check_Link_Ext_Lobby_Game_Slots - Game " + i + " '"
					+ lobbygamepage.getTextNameCardGame(i).toString() + "'");
		}
		lobbygamepage.getParentPageID(parentID);
		for (int i = 1; i < typeGame + 1; i++) {
			lobbygamepage.clickCardGameNumber(i);
			lobbygamepage.clickToViewGame();
			log.info("TC_10_Check_Link_Ext_Lobby_Game_Slots - ------- "
					+ lobbygamepage.getTextNameCardGame(i).toString() + " = " + lobbygamepage.getTextTitlePage());
			lobbygamepage.switchToHomePage(parentID);
		}
	}
	@Test
	public void TC_11_Check_Link_Ext_Lobby_Game_Table_Games() {

		log.info("TC_11_Check_Link_Ext_Lobby_Game_Table_Games - Step 01: Click to Sảnh Game XO từ MenuBar");
		homepage.clickToSport("Sảnh Game XO");

		lobbygamepage = xo88_PageGeneratorManager.getLobbyGamePage(driver);

		log.info("TC_11_Check_Link_Ext_Lobby_Game_Table_Games - Step 02: Click to Table Games từ Lobby Game");
		lobbygamepage.clickToLobbyGame("Table Games");
		for (int i = 1; i < 3; i++) {
				if (!lobbygamepage.isButtonViewMoreVisible()) {
					break ;
				}
				else {
					lobbygamepage.clickToViewMore();
				}
		}
		int typeGame = lobbygamepage.checkToCardGame();
		log.info("TC_11_Check_Link_Ext_Lobby_Game_Table_Games - Step 02: Có " + typeGame + "game tại Table Games");
		for (int i = 1; i < typeGame + 1; i++) {
			log.info("TC_11_Check_Link_Ext_Lobby_Game_Table_Games - Game " + i + " '"
					+ lobbygamepage.getTextNameCardGame(i).toString() + "'");
		}
		lobbygamepage.getParentPageID(parentID);
		for (int i = 1; i < typeGame + 1; i++) {
			lobbygamepage.clickCardGameNumber(i);
			lobbygamepage.clickToViewGame();
			log.info("TC_11_Check_Link_Ext_Lobby_Game_Table_Games - ------- "
					+ lobbygamepage.getTextNameCardGame(i).toString() + " = " + lobbygamepage.getTextTitlePage());
			lobbygamepage.switchToHomePage(parentID);
		}
	}

	@BeforeSuite
	public void deleteAllFilesInReportNGScreenshot() {
		System.out.print("-----------START delete file in folder-----------");
		deleteAllFileInFolder();
		System.out.print("-----------END delete file in folder-----------");
	}

	public void deleteAllFileInFolder() {
		try {
			String workingDir = System.getProperty("user.dir");
			String pathFolderDownload = workingDir + "\\ReportNGScreenshots";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.print(listOfFiles[i].getName());
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
