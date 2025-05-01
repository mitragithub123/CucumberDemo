package stepdefinations;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

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

    @Given("User launches Chrome browser")
    public void user_launches_chrome_browser() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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

    @When("Clicks on Login")
    public void clicks_on_login() {
        l.submitLogin();
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        Assert.assertEquals(expectedTitle, driver.getTitle());
    }

    @When("User clicks on the customers list item in the left menu")
    public void user_clicks_on_the_customers_list_item_in_the_left_menu() {
        cs.customersParentClick();
    }

    @When("Clicks on the customers option")
    public void clicks_on_the_customers_option() {
        cs.customersChildClick();
    }

    @Then("Clicks on the {string} button")
    public void clicks_on_the_button(String buttonName) {
        if (buttonName.equalsIgnoreCase("add new")) {
            cs.addNewBtnclick();
        } else if (buttonName.equalsIgnoreCase("Save")) {
            cs.clickOnSave();
        }
    }

    @When("User enters customer information")
    public void user_enters_customer_information() {
        String email = cs.generateRandomEmail();
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

    @Then("User should see a confirmation message {string}")
    public void user_should_see_a_confirmation_message(String expectedConfirmationMsg) {
        String actualConfirmationMsg = cs.successMsgCheck().trim();
        Pattern pattern = Pattern.compile(expectedConfirmationMsg);
        Matcher matcher = pattern.matcher(actualConfirmationMsg);
        Assert.assertTrue(matcher.find());
    }

    @When("User enters email in email search box")
    public void user_enters_email_in_email_search_box() {
        s.enterEmail("victoria_victoria@nopCommerce.com");
    }

    @When("Clicks on search button")
    public void clicks_on_search_button() {
        s.clickOnSearch();
    }

    @Then("Email ID should be found in the table")
    public void email_id_should_be_found_in_the_table() {
        String expectedEmailAdd = "victoria_victoria@nopCommerce.com";
        Assert.assertTrue(s.foundEmail(expectedEmailAdd));
    }

    @Then("Closes the browser")
    public void closes_the_browser() {
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
