package pageFactory;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingIn_PO {

	private WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//a[@class='login']")
	private WebElement signinButton;

	@FindBy(xpath = "//input[@id='email_create']")
	WebElement email;

	@FindBy(id = "SubmitCreate")
	WebElement submitButton;

	@FindBy(xpath = "//input[@id='id_gender1']")
	WebElement gender;

	@FindBy(id = "customer_firstname")
	WebElement firstName;

	@FindBy(id = "customer_lastname")
	WebElement lastName;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "days")
	WebElement days;

	@FindBy(id = "months")
	WebElement months;

	@FindBy(id = "years")
	WebElement year;

	@FindBy(id = "firstname")
	WebElement addFirstName;

	@FindBy(id = "lastname")
	WebElement AddLastName;

	@FindBy(id = "company")
	WebElement companyName;

	@FindBy(id = "address1")
	WebElement address1;

	@FindBy(id = "address2")
	WebElement address2;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "id_state")
	WebElement state;

	@FindBy(id = "id_country")
	WebElement country;

	@FindBy(id = "phone_mobile")
	WebElement mobile;

	@FindBy(xpath = "//span[contains(text(),'Register')]")
	WebElement registerButton;

	@FindBy(id = "postcode")
	WebElement postcode;

	// Login Page Locator

	@FindBy(id = "email")
	WebElement userName;

	@FindBy(id = "passwd")
	WebElement loginPassword;

	@FindBy(id = "SubmitLogin")
	WebElement loginButton;

	@FindBy(xpath = "//span[contains(text(),'Abhishek Karandikar')]")
	WebElement checkLogin;
	
	@SuppressWarnings("deprecation")
	public SingIn_PO(WebDriver driver) throws FileNotFoundException {

		this.driver = driver;
		// This initElements method will create all WebElements
		wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);

	}

	// Methods

	public void SignInButton() {
		try {
			wait.until(ExpectedConditions.visibilityOf(signinButton)).click();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void emailAddress(String emailAdd) {

		try {

			wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(emailAdd);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void submit() {

		try {
			submitButton.click();
		} catch (Exception e) {

			System.out.println(e);
		}
	}

	public void gender() {

		try {
			wait.until(ExpectedConditions.visibilityOf(gender)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void firstName(String first) {

		try {
			wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(first);
		} catch (Exception e) {

			System.out.println(e);

		}
	}

	public void lastName(String last) {

		lastName.sendKeys(last);
	}

	public void password(String pass) {

		password.sendKeys(pass);
	}

	public void days() {

		Select dropdown = new Select(days);

		dropdown.selectByValue("23");

	}

	public void month() {

		Select dropdown = new Select(months);

		dropdown.selectByValue("6");

	}

	public void year() {

		Select dropdown = new Select(year);

		dropdown.selectByValue("1993");

	}

	public void firstNameAdd(String add1) {

		addFirstName.sendKeys(add1);

	}

	public void lastNameAdd(String add2) {

		AddLastName.sendKeys(add2);

	}

	public void address(String address) {

		try {

			address1.sendKeys(address);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cityName(String cityName) {

		city.sendKeys(cityName);

	}

	public void state() {

		try {

			Select dropdown = new Select(state);

			dropdown.selectByIndex(2);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void postalcode(String code) {

		postcode.sendKeys(code);
	}

	public void mobileNumber(String mobileNum) {

		mobile.sendKeys(mobileNum);
	}

	public void regButton() {

		registerButton.click();
	}

	public boolean checkLoginSuccess() {
		
		wait.until(ExpectedConditions.visibilityOf(checkLogin));
		
		return checkLogin.isDisplayed();
		
	}
	
	public void Login(String username, String passWord) {
		
		
	wait.until(ExpectedConditions.visibilityOf(this.signinButton)).click();
	wait.until(ExpectedConditions.visibilityOf(userName));	
	this.userName.sendKeys(username);	
	
	this.password.sendKeys(passWord);
	
	this.loginButton.click();
		
	}
	

}
