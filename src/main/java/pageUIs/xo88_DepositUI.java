package pageUIs;

public class xo88_DepositUI {
	public static final String DEPOSIT_AT_HEADER = "//span[contains(text(),'NẠP')]";
	public static final String LOGOXO_88_AT_HEADER = "//div[@id='canvasPlayer']//canvas";
	public static final String AVATAR_USER_AT_HEADER = "//div[@class='wrapper-user-login__right--name']/span";
	public static final String PAYWIN_MENUBAR_AT_HEADER = "//span[text()='Paywin']/parent::div";

	
	/*Paywin */
	public static final String NUMBER_MONEY_AT_PAYWIN = "//label[contains(text(),'Số tiền nạp (VND)')]//preceding-sibling::input";
	public static final String NEXT_AT_PAYWIN = "//span[@class='base-button__slot']";
	public static final String TEXT_ERROR_AT_PAYWIN = "//p[@class='error']";
	public static final String DYNAMIC_TYPE_PROMOTION = "//p[text()='Chọn Khuyến mãi']/following-sibling::div/label['%s']";
	
}