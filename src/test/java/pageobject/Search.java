package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {
	public WebDriver driver;

	public Search(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#SearchEmail")
	public WebElement emailField;

	@FindBy(css = "#search-customers")
	public WebElement searchBtn;

	@FindBy(css = "td:nth-child(2)")
	public List<WebElement> tableRow;

	public void enterEmail(String email) {
		emailField.sendKeys(email);

	}

	public void clickOnSearch() {
		searchBtn.click();
	}

	public boolean foundEmail(String email) {
	    boolean found = false;
	    for (int i = 0; i < tableRow.size(); i++) {
	        WebElement emailFound = driver.findElement(By.cssSelector("tr:nth-child(" + (i + 1) + ") td:nth-child(2)"));
	        String actualEmailAdd = emailFound.getText();
	        if (actualEmailAdd.equals(email)) {
	            found = true;
	            break;
	        }
	    }
	    return found;
	}

}
