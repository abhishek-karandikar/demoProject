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
import pageFactory.placeOrder_PO;
import utils.Base;

public class PlaceOrder extends Base {

    private WebDriver driver;
    private String testCaseName = getClass().getName().substring(17);
    placeOrder_PO order;
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
    public void placeOrder() {

	try {

	    Properties obj = new Properties();
	    FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
	    obj.load(ip);

	    register = new SingIn_PO(driver);
	    order = new placeOrder_PO(driver);

	    // Login to application
	    register.Login(obj.getProperty("username"), obj.getProperty("password"));

	    // Add product to card and proceed to checkout
	    order.addProductToCard();
	    order.proceedToCheckOut();

	    String pricePaidForOrder = order.pricePaid.getText();
	    
	    order.comparePrice();

	    String priceInOrderDetails = order.comparePrice.getText();
	   
	    // Compare the paid and order details price is displayed same
	    
	    if (pricePaidForOrder.equals(priceInOrderDetails)) {

		test.log(LogStatus.PASS, "Test cases passed");
	    } else {

		test.log(LogStatus.FAIL, "Test case failed");
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
