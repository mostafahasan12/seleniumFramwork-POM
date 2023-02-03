package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class AddProductReviewTest extends TestBase {

	/*
	 * 1- User registration
	 * 2- Search for product
	 * 3- Add reivew 
	 * 4- Logout
	 */

	HomePage homeObject ; 
	UserRegisterationPage registerObject ; 
	LoginPage loginObject1 ; 
	String productName = "Apple MacBook Pro 13-inch"; 
	SearchPage searchObject ; 
	ProductDetailsPage detailsObject ;
	ProductReviewPage reviewObject ; 

	// 1- User Registration 
	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegisterationPage(driver); 
		registerObject.userRegistration("Mostafa", "hasan", "test715@gmail.com", "123456784");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.clickContinue();
		registerObject.clickLogin();
		homeObject.openLoginPage();
		loginObject1 = new LoginPage(driver); 		
		loginObject1.UserLogin("test715@gmail.com", "123456784");
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

	// 3- Add review
	@Test(priority=3)
	public void RegisteredUserCanReviewProduct() 
	{
		detailsObject.openAddReviewPage();
		reviewObject = new ProductReviewPage(driver); 
		reviewObject.AddProductReview("new reivew", "the product is very good");
		Assert.assertTrue(reviewObject.reviewNotification.getText()
				.contains("Product review is successfully added."));
	}

	// 4- User Logout
	@Test(priority=4)
	public void RegisteredUserCanLogout() 
	{
		registerObject.userLogout();
	}

}
