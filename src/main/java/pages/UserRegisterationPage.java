package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage  extends PageBase{
	public UserRegisterationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="gender-male")
	WebElement genderRdoBtn ; 
	
	@FindBy(id="FirstName")
	WebElement fnTxtBox; 
	
	@FindBy(id="LastName")
	WebElement lnTxtBox ; 
	
	@FindBy(id="Email")
	WebElement emailTxtBox ; 
	
	@FindBy(id="Password")
	WebElement passwordTxtBox ; 
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPasswordTxtBox ; 
	
	@FindBy(id="register-button")
	WebElement registerBtn ; 
	
	@FindBy(css="div.result")
	public WebElement successMessage ; 
	
	@FindBy(xpath ="/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	public WebElement logoutLink; 
	
	@FindBy (xpath ="/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a")
	public WebElement ButtonContinue; 
	
	@FindBy (linkText = "Log in")
	public WebElement loginlink;
	
	@FindBy(linkText="My account")
	WebElement myAccountLink; 
	
	public void userRegistration(String firstName , String lastName , String email , String password) 
	{
		clickButton(genderRdoBtn);
		setTextElementText(fnTxtBox, firstName);
		setTextElementText(lnTxtBox, lastName);
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		setTextElementText(confirmPasswordTxtBox, password);
		clickButton(registerBtn);
	}
	
	public void clickContinue() 
	{
		clickButton(ButtonContinue);
	}
	
	public void clickLogin() 
	{
		clickButton(loginlink);
	}
	public void userLogout() 
	{
		clickButton(logoutLink);
	}
	
	public void openMyAccountPage() 
	{
		clickButton(myAccountLink);
	}
}
