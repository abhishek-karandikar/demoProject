package automation.login;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.SingIn_PO;
import utils.Base;

public class LoginWithRegisteredUser extends Base {

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
			navigateToURL(this.driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void LoginAndVerify() {

		try {

			Properties obj = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
			obj.load(ip);
			String name = obj.getProperty("username");
			String pass = obj.getProperty("password");

			register = new SingIn_PO(driver);
			
			register.Login(name, pass);

			boolean check = register.checkLoginSuccess();

			if (check == true) {
				test.log(LogStatus.PASS, "User logged in successfully");

			} else {

				test.log(LogStatus.FAIL, "User login failed, please check the logs");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {

		report.endTest(test);
		report.flush();
		driver.close();

	}

}
