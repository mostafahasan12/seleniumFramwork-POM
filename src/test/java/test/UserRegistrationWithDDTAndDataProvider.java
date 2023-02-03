package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegistrationWithDDTAndDataProvider extends TestBase{

	HomePage homeObject ; 
	UserRegisterationPage registerObject ; 
	LoginPage loginObject ; 


	@DataProvider(name="testData")
	public static Object[][] userData()
	{
		return new Object[][] {
			{"mostafa" , "hasan","tes588x996@gmail.com","1223456"},
			{"lleo","tarek","testuser173@gmail.com","124897878"}
		};
	}

	@Test(priority=1,dataProvider="testData")
	public void UserCanRegisterSuccssfully(String fname, String lname , String email , String password ) 
	{
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegisterationPage(driver); 
		registerObject.userRegistration(fname,lname,email,password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver); 
		loginObject.UserLogin(email, password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
		registerObject.userLogout();
	}
}
