package hobsons.com.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.apache.log4j.Logger;
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
	Logger log = Logger.getLogger(ApplicationSignUpTestCase.class);
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
		log.info("___ applicationformFillUp test case execution has started____");
		SignUpForm.applicationform();
		log.info("___ applicationformFillUp test case execution has ended____");
	}
	@Test(priority=2,groups= {"Smoke"})
	public void RequireFielderrorMessageValidation() throws Exception
	{
		log.info("___ RequireFielderrorMessageValidation test case execution has started____");
		Assert.assertEquals(SignUpForm.requireFieldvalidation(), "Please provide this information.");
		log.info("___ RequireFielderrorMessageValidation test case execution has ended____");
	}
	
	
	@AfterMethod(groups= {"smoke","Regression"})
	public void tearDown(){
		driver.close();
	}
}
