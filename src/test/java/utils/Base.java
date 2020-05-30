package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base {

	// Declaring member variables common among Test Classes
	public static String oSName;
	public static String homedir;
	static String browserName;
	protected static WebDriver driver;
	protected String siteURL;
	protected static String emailAddress;
	protected static ExtentTest test;
	protected static ExtentReports report;
	

	// Function to instantiate the WebDriver based on the OS
	public WebDriver driverIns() throws IOException {

		switch (getOSName().toString()) {

		case "Windows 10":
			
			driver = driverInsWindows();

			break;
		case "LINUX":

			System.out.println("NO CODE ADDED FOR LINUX");

			break;
		case "MAC":

			System.out.println("No CODE ADDED FOR MAC");

			break;

		}
		System.out.println("-----------------------------------" + getOSName());
		return driver;

	}

	// Function to instantiate the WebDriver instance based on the Browser
	// selected for Windows
	public WebDriver driverInsWindows() throws IOException {

		try {

			switch (getBrowser()) {
			case "Chrome":

				System.out.println("selected browser is "+ getBrowser());
				
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();

				break;

			case "Firefox":

				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();

				break;

			case "Edge":

				/*
				 * Add the code
				 */
				break;

			case "IE":

				/*
				 * 
				 * Add the code
				 */

				break;
				
				
			default:

			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		return driver;

	}

	// Function to get the Browser
	public static String getBrowser() throws IOException {

		Properties obj = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
		obj.load(ip);

		return browserName = obj.getProperty("browser");

	}
	
	public static String generateEmail() {
		
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		return emailAddress = "user" + randomInt + "@testing.com";	
		
	}
	
	public static void generateReport(String TestName) {
		
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		test = report.startTest(TestName);
	}

	// Function to get the user directory
	public static String getHomeDirectory() {

		File f = new File(System.getProperty("user.dir"));
		do {
			f = f.getParentFile();
		} while (f.getParentFile() != null);
		return f.getPath();

	}
	
	
	public static void getURL(WebDriver driver) {
		try {
		
		Properties obj = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
		obj.load(ip);
		
		driver.navigate().to(obj.getProperty("url"));

		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	// Function to get the OS Name
	public static String getOSName() {

		return System.getProperty("os.name");

	}

	// Base Class Constructor:
	public Base() {

		homedir = getHomeDirectory();
		getOSName();

	}

}