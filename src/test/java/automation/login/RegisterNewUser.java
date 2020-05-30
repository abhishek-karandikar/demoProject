package automation.login;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import pageFactory.SingIn_PO;
import utils.Base;

public class RegisterNewUser extends Base {

	private WebDriver driver;
	private String testCaseName = getClass().getName().substring(17);
	SingIn_PO register;
	

	public void navigateToURL(WebDriver driver) throws IOException {

		getURL(driver);

	}

	@BeforeClass
	public void executeScript() throws IOException {

		try {

			generateReport(testCaseName);
			this.driver = driverIns();
			System.out.println(testCaseName);
			navigateToURL(this.driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void register() {

		try {

			Properties obj = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
			obj.load(ip);


			register.SignInButton();

			register.emailAddress(generateEmail());

			register.submit();

			register.gender();

			register.firstName(obj.getProperty("firstname"));

			register.lastName(obj.getProperty("lastname"));

			register.password(obj.getProperty("password"));

			register.days();

			register.month();

			register.year();

			register.address(obj.getProperty("address"));

			register.cityName(obj.getProperty("city"));

			register.state();

			register.postalcode(obj.getProperty("zip"));

			register.mobileNumber(obj.getProperty("mobile"));

			register.regButton();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {

		driver.close();
		report.endTest(test);
		report.flush();
	}

}
