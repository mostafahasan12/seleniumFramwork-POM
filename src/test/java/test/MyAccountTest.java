package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterationPage;

public class MyAccountTest extends TestBase{
	HomePage homeObject ; 
	UserRegisterationPage registerObject ; 
	LoginPage loginObject1 ; 
	MyAccountPage myAccountObject ; 
	String oldPassword = "12345678" ; 
	String newPassword = "123456" ; 
	String firstName = "mostafa" ; 
	String lastName = "hasan" ; 
	String email = "cssa9l341@gmail.com" ; 
	

	@Test(priority=1)
	public void UserCanRegisterSuccssfully() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegisterationPage(driver); 
		registerObject.userRegistration(firstName, lastName, email, oldPassword);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.clickContinue();
		registerObject.clickLogin();
		loginObject1 = new LoginPage(driver); 		
		loginObject1.UserLogin(email , oldPassword);		
	}
	
	@Test(priority=2)
	public void RegisteredUserCanChangePassword() 
	{
		myAccountObject = new MyAccountPage(driver) ; 
		registerObject.openMyAccountPage();
		myAccountObject.openChangePasswordPage();
		myAccountObject.ChangePassword(oldPassword, newPassword);
		Assert.assertTrue(myAccountObject.resultLbl.getText().contains("Password was changed"));
		myAccountObject.closechangepassword();	
		driver.navigate().to("https://demo.nopcommerce.com");	
	}
	
	@Test(priority=3)
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}
	
	@Test(priority=4)
	public void RegisteredUserCanLogin() 
	{
		homeObject.openLoginPage();
		loginObject1 = new LoginPage(driver); 
		loginObject1.UserLogin(email, newPassword);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
	
	@Test(priority=5)
	public void UserLogout() 
	{
		registerObject.userLogout();
	}
	
}
