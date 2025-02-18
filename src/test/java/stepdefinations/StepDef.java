package stepdefinations;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.Customers;
import pageobject.Login;
import pageobject.Search;



public class StepDef extends BaseTest {

	@Given("User launch firefox browser")
	public void user_launch_firefox_browser() throws IOException {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		l = new Login(driver);
		cs = new Customers(driver);
		s = new Search(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	}

	@When("User enters Email as {string}")
	public void user_enters_email_as(String email) {
		l.enterEmail(email);
	}

	@When("User enters Password as {string}")
	public void user_enters_password_as(String password) {
		l.enterPassword(password);

	}

	@When("Click on Login")
	public void click_on_login() {
		l.submitLogin();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Page Title should {string}")
	public void page_title_should(String expectedTitle) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@When("User clicks log out button")
	public void user_clicks_log_out_button() {
		l.logout();

	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	/*----------------Customer Page------------------------*/
	@When("user clicks on customers list item in left menu")
	public void user_clicks_on_customers_list_item_in_left_menu() {
		cs.customersParentClick();
	}

	@When("clicks on customers option")
	public void clicks_on_customers_option() {
		cs.customersChildClick();
	}

	@Then("page title should show {string}")
	public void page_title_should_show(String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Then("click on add new button")
	public void click_on_add_new_button() {
		cs.addNewBtnclick();
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		String email = cs.generateRandomEmail();
		System.out.println(email);
		cs.enterEmail(email);
		cs.enterPassword("test1");
		cs.enterFirstName("Mitrabhanu");
		cs.enterLastName("Prusty");
		cs.enterGender("Male");
		cs.enterDob("9/11/1994");
		cs.enterCompanyName("CodeStudio");
		cs.enterAdminContent("Admin content");
		cs.enterManagerOfVendor("Vendor 1");
	}

	@When("click on Save button")
	public void click_on_save_button() {
		cs.clickOnSave();

	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMsg) {
		// Get the actual confirmation message from the page and trim leading and
		// trailing whitespace
		String actualConfirmationMsg = cs.successMsgCheck().trim();

		// Create a pattern from the expected confirmation message
		Pattern pattern = Pattern.compile(expectedConfirmationMsg);

		// Create a matcher to match the pattern against the actual confirmation message
		Matcher matcher = pattern.matcher(actualConfirmationMsg);

		// Assert that the pattern matches any part of the actual confirmation message
		Assert.assertTrue(matcher.find());
	}

	/* -------------Search customer by email-------------------- */

	@When("user enters email in email search box")
	public void user_enters_email_in_email_search_box() {
		s.enterEmail("victoria_victoria@nopCommerce.com");
	}

	@When("clicks on search button")
	public void clicks_on_search_button() {
		s.clickOnSearch();
	}

	@Then("email id should found in table")
	public void email_id_should_found_in_table() {
		String expectedEmailAdd = "victoria_victoria@nopCommerce.com";
		if (s.foundEmail(expectedEmailAdd) == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	/* --------Close browser---------- */
	@Then("close browser")
	public void close_browser() {
		l.driverClose();
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}

}
