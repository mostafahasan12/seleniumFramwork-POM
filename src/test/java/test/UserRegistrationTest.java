package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegistrationTest  extends TestBase{
	HomePage homeObject ; 
	UserRegisterationPage registerObject ; 
	LoginPage loginObject1 ; 

	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegisterationPage(driver); 
		registerObject.userRegistration("mostafa", "hasan", "test115@gmail.com", "123456784");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.clickContinue();
		registerObject.clickLogin();
	}
	
	@Test(dependsOnMethods = {"UserCanRegisterSuccssfully"})
	public void RegisteredUserCanLogin() 
	{
		homeObject.openLoginPage();
		loginObject1 = new LoginPage(driver); 		
		loginObject1.UserLogin("test115@gmail.com", "123456784");		

	}
	@Test(dependsOnMethods = {"RegisteredUserCanLogin"})
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}
	
}
