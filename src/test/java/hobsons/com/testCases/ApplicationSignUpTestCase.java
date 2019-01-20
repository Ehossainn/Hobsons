package hobsons.com.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import hobsons.com.baseClass.ParentCls;
import hobsons.com.pages.ApplicationSignUp;
import hobsons.com.pages.OpenPositions;
import hobsons.com.pages.careerPage;
import hobsons.com.pages.homePage;
import hobsons.com.utility.supportUtility;

public class ApplicationSignUpTestCase extends ParentCls {
	
	homePage Hmpage;
	careerPage Crpage;
	OpenPositions opportunitypage;
	ApplicationSignUp SignUpForm;
	supportUtility utility;
	
	public ApplicationSignUpTestCase() {
		super();
	}
	
	@BeforeMethod(groups= {"smoke","Regression"})
	public void setUp() throws Exception{
		initialization();
		utility = new supportUtility();
		utility.popupHndler();
		Hmpage = new homePage();
		Crpage=Hmpage.openPositions();
		opportunitypage=Crpage.OpenPositions();
		SignUpForm=opportunitypage.applyNow(utility.JObtitle);
	}
	
	@Test(priority=1,groups= {"Regression"})
	public void applicationformFillUp() throws Exception
	{
		SignUpForm.applicationform();
	}
	@Test(priority=2,groups= {"Smoke"})
	public void RequireFielderrorMessageValidation() throws Exception
	{
		Assert.assertEquals(SignUpForm.requireFieldvalidation(), "Please provide this information.");
	}
	
	
	@AfterMethod(groups= {"smoke","Regression"})
	public void tearDown(){
		driver.close();
	}
}
