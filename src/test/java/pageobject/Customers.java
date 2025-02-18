package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Customers {
	public WebDriver driver;

	public Customers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//p[contains(text(),'Customers')])[1]")
	public WebElement customersParent;

	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	public WebElement customersChild;

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	public WebElement btnAddnew;

	@FindBy(xpath = "//input[@id='Email']")
	public WebElement txtEmail;

	@FindBy(xpath = "//input[@id='Password']")
	public WebElement txtPassword;

	@FindBy(xpath = "//div[@class='k-multiselect-wrap k-floatwrap']")
	public WebElement txtCustomerRoles;

	@FindBy(xpath = "//li[contains(text(),'Administrators')]")
	public WebElement listItemAdministrators;

	@FindBy(xpath = "//li[contains(text(),'Registered')]")
	public WebElement listItemRegistered;

	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	public WebElement listItemGuests;

	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	public WebElement listItemVendors;
	// VendorId

	@FindBy(xpath = "//*[@id='VendorId']")
	public WebElement dropdownVendorMgr;

	@FindBy(id = "Gender_Male")
	public WebElement MaleGender;

	@FindBy(id = "Gender_Female")
	public WebElement FeMaleGender;

	@FindBy(xpath = "//input[@id='FirstName']")
	public WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='LastName']")
	public WebElement txtLastName;

	@FindBy(xpath = "//input[@id='DateOfBirth']")
	public WebElement txtDob;

	@FindBy(xpath = "//input[@id='Company']")
	public WebElement txtCompanyName;

	@FindBy(xpath = "//textarea[@id='AdminComment']")
	public WebElement txtAdminContent;

	@FindBy(xpath = "//button[@name='save']")
	public WebElement btnSave;

	@FindBy(css = ".alert.alert-success.alert-dismissable")
	public WebElement successMsg;

	public void customersParentClick() {
		customersParent.click();
	}

	public void customersChildClick() {
		customersChild.click();
	}

	public void addNewBtnclick() {
		btnAddnew.click();
	}

	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void enterFirstName(String firstName) {
		txtFirstName.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		txtLastName.sendKeys(lastName);
	}

	public void enterDob(String dob) {
		txtDob.sendKeys(dob);
	}

	public void enterCompanyName(String coName) {
		txtCompanyName.sendKeys(coName);
	}

	public void enterAdminContent(String content) {
		txtAdminContent.sendKeys(content);
	}

	public void enterManagerOfVendor(String value) {
		Select drp = new Select(dropdownVendorMgr);
		drp.selectByVisibleText(value);
	}

	public void enterGender(String gender) {
		if (gender.equals("Male")) {
			MaleGender.click();
		} else if (gender.equals("Female")) {
			FeMaleGender.click();
		} else {
			MaleGender.click();
		}

	}

	public void clickOnSave() {
		btnSave.click();
	}

	public String successMsgCheck() {
		String successMessage = successMsg.getText();
		System.out.println(successMessage);
		return successMessage;

	}

	public String generateRandomEmail() {
		String usernameCharacters = "abcdefghijklmnopqrstuvwxyz0123456789";
		int usernameLength = 8;
		String[] domainNames = { "gmail.com", "yahoo.com", "hotmail.com" };
		java.util.Random rand = new java.util.Random();
		StringBuilder username = new StringBuilder();
		for (int i = 0; i < usernameLength; i++) {
			int randomIndex = rand.nextInt(usernameCharacters.length());
			username.append(usernameCharacters.charAt(randomIndex));
		}
		int randomDomainIndex = rand.nextInt(domainNames.length);
		String domain = domainNames[randomDomainIndex];
		return username.toString() + "@" + domain;
	}

}
