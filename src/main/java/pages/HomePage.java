package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage  extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText="Register")
	WebElement registerLink ; 

	@FindBy(linkText="Log in")
	WebElement loginLink; 
	
	@FindBy(linkText="Contact us")
	WebElement contactUsLink ; 
	
	@FindBy(xpath ="/html/body/div[6]/div[4]/div[1]/div[1]/ul/li[6]/a")
			
	WebElement contactUsLink1 ; 
	
	@FindBy(id="customerCurrency")
	WebElement currencydrl; 
	
	@FindBy(linkText="Computers")
	WebElement ComputerMenu; 
	
	@FindBy(linkText="Notebooks")
	WebElement NotbooksMenu; 
	
	
	
	public void openRegistrationPage() 
	{
		clickButton(registerLink);
	}
	
	public void openLoginPage() 
	{
		clickButton(loginLink);
	}
	
	public void openContactUsPage1() 
	
	{
		clickButton(contactUsLink1);
	}
public void openContactUsPage() 
	
	{
		scrollToBottom();
		clickButton(contactUsLink);
	}
	
	
	public void changeCurrency() 
	{
		select = new Select(currencydrl); 
		select.selectByVisibleText("Euro");
	}
	
	public void selectNotebooksMenu() 
	{
		action
		.moveToElement(ComputerMenu)
		.moveToElement(NotbooksMenu)
		.click()
		.build()
		.perform();
	}
	
}
