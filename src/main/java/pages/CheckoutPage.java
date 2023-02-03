package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = "button.button-1 checkout-as-guest-button")
	private WebElement guestBtn;

	@FindBy(id = "BillingNewAddress_FirstName")
	private WebElement fnTxt;

	@FindBy(id = "BillingNewAddress_LastName")
	private WebElement lnTxt;

	@FindBy(id = "BillingNewAddress_Email")
	private WebElement emailTxt;

	@FindBy(id = "BillingNewAddress_CountryId")
	private WebElement countryList;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	private WebElement phoneTxt;

	@FindBy(id = "BillingNewAddress_City")
	private WebElement cityTxt;

	@FindBy(id = "BillingNewAddress_Address1")
	private WebElement addressTxt;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	private WebElement postCodeTxt;

	@FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/button[4]")
	private WebElement continueBtn;

	@FindBy(id = "shippingoption_1")
	private WebElement shippingMethodRdo;

	@FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/button")
	private WebElement continueShippingBtn;

	@FindBy(xpath  = "//*[@id=\"payment-method-buttons-container\"]/button")
	private WebElement continuePaymentBtn;

	@FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/button")
	private WebElement continueInfoBtn;

	@FindBy(css = "button.button-1 confirm-order-next-step-button")
	public WebElement prodcutName;

	@FindBy(xpath  = "//*[@id=\"confirm-order-buttons-container\"]/button")
	private WebElement confirmBtn;

	@FindBy(css = "div.page-title")
	public WebElement ThankYoulbl;

	@FindBy(css = "div.title")
	private WebElement successMessage;

//	@FindBy(linkText="Click here for order details.")
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[2]/div[2]/a")
	private WebElement orderDetailsLink;
	
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[3]/button")
	private WebElement complutedLink;


	public void RegisteredUserCheckoutProduct(String countryName, String address, 
			String postcode, String phone, String city, String productName) throws InterruptedException {
		select = new Select(countryList);
		select.selectByVisibleText(countryName);
		setTextElementText(cityTxt, city);
		setTextElementText(addressTxt, address);
		setTextElementText(postCodeTxt, postcode);
		setTextElementText(phoneTxt, phone);
		clickButton(continueBtn);
		clickButton(shippingMethodRdo);
		clickButton(continueShippingBtn);
		Thread.sleep(1000);
		clickButton(continuePaymentBtn);
		Thread.sleep(1000);
		clickButton(continueInfoBtn);
//		clickButton(confirmBtn);
	}

	public void confirmOrder() throws InterruptedException 
	{
		clickButton(confirmBtn);
		Thread.sleep(2000);
	}

	public void viewOrderDetails() {
		clickButton(orderDetailsLink);
	}
	public void complteedbtn() {
		clickButton(complutedLink);
	}

	public void CheckoutProduct(String firstName, String lastName, String countryName,
			String email, String address, String postcode, 
			String phone, String city, String productName) throws InterruptedException {
		setTextElementText(fnTxt, firstName);
		setTextElementText(lnTxt, lastName);
		setTextElementText(emailTxt, email);
		select = new Select(countryList);
		select.selectByVisibleText(countryName);
		setTextElementText(cityTxt, city);
		setTextElementText(addressTxt, address);
		setTextElementText(postCodeTxt, postcode);
		setTextElementText(phoneTxt, phone);
		clickButton(continueBtn);
		clickButton(shippingMethodRdo);
		clickButton(continueShippingBtn);
		Thread.sleep(2000);
		clickButton(continuePaymentBtn);
		Thread.sleep(2000);
		clickButton(continueInfoBtn);
		clickButton(confirmBtn);
	}
}
