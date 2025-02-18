package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	public WebDriver driver;

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#Email")
	public WebElement email;

	@FindBy(css = "#Password")
	public WebElement password;

	@FindBy(css = "button[type='submit']")
	public WebElement loginBtn;

	@FindBy(xpath = "//a[text()='Logout']")
	public WebElement logoutBtn;

	public void enterEmail(String mail) {
		email.clear();
		email.sendKeys(mail);
	}

	public void enterPassword(String pass) {
		password.clear();
		password.sendKeys(pass);
	}

	public void submitLogin() {
		loginBtn.click();
	}

	public void logout() {
		logoutBtn.click();
	}

	public void driverClose() {
		driver.close();
	}

}
