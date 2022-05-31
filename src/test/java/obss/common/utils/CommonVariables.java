package obss.common.utils;
import org.openqa.selenium.WebDriver;

public class CommonVariables {
	public static WebDriver DRIVER ;
	public final String OBSS_PATH = "https://obss.com.tr/en/" ;
	public final String CHROME_BROWSER = "chrome";
	public final String DRIVER_PATH= System.getProperty("user.dir")+"/drivers/chromedriver/chromedriver.exe";
	public final String ACCEPT_COOKIES="cookieAcceptance";
	public final int WAIT_TIME = 10;
	public final String SEARCH_AREA="search-icon";
	public final String TEXT_AREA="search-box";
	public final String LIST_FIRST_ITEM="Testing & Automation";
	public final String AUTOMATION_PAGE_URL="https://obss.com.tr/en/yetkinlikler/yetenekler/yazilim-testi-otomasyonu/";
	public final String FOOTER_TEXT_XPATH="/html/body/div[11]/div/div/div[1]/h2";
}
