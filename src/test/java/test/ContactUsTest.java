package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
	HomePage home;
	ContactUsPage contactPage;

	String email = "test1@test.com";
	String fullName = "Test User";
	String enquiry = "Hello Admin , this is for test";

	@Test
	public void UserCanUseContactUs() throws InterruptedException {
		home = new HomePage(driver);
		home.openContactUsPage1();
		contactPage = new ContactUsPage(driver);
		contactPage.ContactUs(fullName, email, enquiry);
		 Assert.assertTrue(contactPage.successMessage.getText()
				 .contains("Your enquiry has been successfully sent to the store owner."));
	}

}
