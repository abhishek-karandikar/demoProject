package pageFactory;

import java.io.FileNotFoundException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class placeOrder_PO {

    private WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
    WebElement Women;

    @FindBy(xpath = "//a[contains(text(),'Faded Short Sleeve T-shirts')]")
    WebElement hoverOnProduct;

    @FindBy(xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line hovered']//a[@class='quick-view']")
    WebElement quickView;

    @FindBy(xpath = "//a[@class='btn btn-default button-plus product_quantity_up']")
    WebElement Add;

    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    WebElement AddToCart;

    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    WebElement ProceedToCheckout;

    @FindBy(xpath = "//span[@id='total_price']")
    WebElement totalPrice;

    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
    WebElement ProcceedToCheckOut2;

    @FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
    WebElement Checkout3;

    @FindBy(xpath = "//label[contains(text(),'I agree to the terms of service and will adhere to')]")
    WebElement accept;

    @FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
    WebElement checkout4;

    @FindBy(xpath = "//a[@class='bankwire']")
    WebElement selectPayment;

    @FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
    WebElement confirmOrder;

    @FindBy(xpath = "//strong[contains(text(),'$35.02')]")
    public WebElement pricePaid;

    @FindBy(xpath = "//span[contains(text(),'Abhishek Karandikar')]")
    WebElement profileClick;

    @FindBy(xpath = "//span[contains(text(),'Order history and details')]")
    WebElement orderHostory;

    @FindBy(xpath = "//tr[contains(@class,'first_item')]//td[@class='history_price']")
    public WebElement comparePrice;

    @SuppressWarnings("deprecation")
    public placeOrder_PO(WebDriver driver) throws FileNotFoundException {

	this.driver = driver;
	// This initElements method will create all WebElements
	wait = new WebDriverWait(driver, 30);
	PageFactory.initElements(driver, this);

    }

    // Methods starts here

    public void addProductToCard() throws InterruptedException {

	wait.until(ExpectedConditions.visibilityOf(this.Women)).click();

	JavascriptExecutor je = (JavascriptExecutor) driver;
	je.executeScript("window.scrollBy(0,1000)");

	Thread.sleep(2000);

	Actions action = new Actions(driver);
	action.moveToElement(hoverOnProduct).build().perform();

	this.quickView.click();

	Thread.sleep(5000);

	// Switch the iFrame
	driver.switchTo().defaultContent();
	driver.switchTo().frame(0);

	this.Add.click();
	this.AddToCart.click();

    }

    public void proceedToCheckOut() {

	wait.until(ExpectedConditions.visibilityOf(this.ProceedToCheckout)).click();

	driver.switchTo().parentFrame();

	wait.until(ExpectedConditions.visibilityOf(this.ProcceedToCheckOut2)).click();

	wait.until(ExpectedConditions.visibilityOf(this.Checkout3)).click();

	wait.until(ExpectedConditions.visibilityOf(this.accept)).click();

	wait.until(ExpectedConditions.visibilityOf(this.checkout4)).click();

	wait.until(ExpectedConditions.visibilityOf(this.selectPayment)).click();

	wait.until(ExpectedConditions.visibilityOf(this.confirmOrder)).click();

    }

    public void comparePrice() {

	this.profileClick.click();

	this.orderHostory.click();

    }
}
