package obss.scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import obss.common.utils.CommonVariables;

public class Case_Success {

	CommonVariables variables = new CommonVariables();

	public static WebDriver DRIVER;

	public void setDriver() {
		System.setProperty("webdriver.chrome.driver", variables.DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();
		Map prefs = new HashMap();
		prefs.put("profile.default_content_settings.cookies", 2);
		options.setExperimentalOption("prefs", prefs);

		DRIVER = new ChromeDriver(options);
		DRIVER.manage().window().maximize();
	}

	@Given("open {string}")
	public void openBrowserAndGoTo(String browser) {
		if (browser.equals("chrome")) {
			setDriver();
		} else {
			System.out.println("Only chrome driver implemented");
			System.exit(-1);
		}

	}

	@And("go to {string}")
	public void go_to(String obssPath) {
		DRIVER.get(obssPath);
	}

	@And("accept cookies")
	public void accept_cookies() {
		WebElement addButton = DRIVER.findElement(By.id(variables.ACCEPT_COOKIES));
		addButton.click();

	}

	@Then("click search area")
	public void click_search_area() {
		WebElement searchIcon = DRIVER.findElement(By.id(variables.SEARCH_AREA));
		searchIcon.click();
	}

	@Then("search area write {string}")
	public void search_area_write(String searchKey) {
		WebElement textArea = DRIVER.findElement(By.id(variables.TEXT_AREA));
		textArea.sendKeys(searchKey);
		textArea.submit();

	}

	@Then("verify that results are listed")
	public void verify_that_results_are_listed() {
		new WebDriverWait(DRIVER, Duration.ofSeconds(variables.WAIT_TIME))
				.until(ExpectedConditions.elementToBeClickable(By.linkText(variables.LIST_FIRST_ITEM)));
	}

	@Then("click the first")
	public void click_the_first() {
		WebElement link = DRIVER.findElement(By.linkText(variables.LIST_FIRST_ITEM));
		link.click();
	}

	@Then("verify that the page is out")
	public void verify_that_the_page_is_out() {
		String currentUrl = DRIVER.getCurrentUrl();
		if (!currentUrl.equals(variables.AUTOMATION_PAGE_URL)) {
			throw new io.cucumber.java.PendingException();
		}

	}

	@Then("go to the bottom of the page")
	public void go_to_the_bottom_of_the_page() {
		DRIVER.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
	}

	@Then("verify obss footer")
	public void verify_obss_footer() {
		WebElement element = DRIVER.findElement(By.linkText("KVKK"));
		System.out.println(element.getText());
	}

	@AfterAll
	public static void closeBrowser() {
		DRIVER.quit();
	}
}
