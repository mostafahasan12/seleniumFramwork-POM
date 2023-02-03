package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class EmailFriendTest extends TestBase{
	HomePage homeObject ; 
	UserRegisterationPage registerObject ; 
	LoginPage loginObject1 ; 
	String productName = "Apple MacBook Pro 13-inch"; 
	SearchPage searchObject ; 
	ProductDetailsPage detailsObject ;
	EmailPage emailObject ; 

	// 1- User Registration 
	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegisterationPage(driver); 
		registerObject.userRegistration("mostafa", "hasan", "test7888@gmail.com", "12345678");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.clickContinue();
		registerObject.clickLogin();
		homeObject.openLoginPage();
		loginObject1 = new LoginPage(driver); 		
		loginObject1.UserLogin("test7888@gmail.com", "12345678");
	}
	
	// 2- Search For Product
	@Test(priority=2)
	public void UserCanSearchWithAutoSuggest() 
	{
		try {
			searchObject = new SearchPage(driver); 
			searchObject.ProductSearchUsingAutoSuggest("MacB");
			detailsObject = new ProductDetailsPage(driver); 
			Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);						
		} catch (Exception e) {
			System.out.println("Error occurred  " + e.getMessage());
		}
	}
	
	// 3- Email to Friend
	@Test(priority=3)
	public void RegisteredUserCanSendProductToFriend() 
	{
		detailsObject.openSendEmail();
		emailObject = new EmailPage(driver); 
		emailObject.SendEmailToFriend("aaa@tte.com", "Hello my friend , check this product");
		Assert.assertTrue(emailObject.messageNotification.getText().contains("Your message has been sent."));
	}
	
	// 4- User Logout
	@Test(priority=4)
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}
}
