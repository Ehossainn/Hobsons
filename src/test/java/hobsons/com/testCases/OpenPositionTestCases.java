package hobsons.com.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import hobsons.com.baseClass.ParentCls;
import hobsons.com.pages.ApplicationSignUp;
import hobsons.com.pages.OpenPositions;
import hobsons.com.pages.careerPage;
import hobsons.com.pages.homePage;
import hobsons.com.utility.supportUtility;

public class OpenPositionTestCases extends ParentCls {

	homePage Hmpage;
	careerPage Crpage;
	OpenPositions opportunitypage;
	ApplicationSignUp SignupForm;
	supportUtility utility;

	public OpenPositionTestCases() {
		super();
	}


	@BeforeMethod(groups= {"smoke","Regression"})
	public void setUp() throws Exception {
		initialization();
		utility = new supportUtility();
		utility.popupHndler();
		Hmpage = new homePage();
		Crpage = Hmpage.openPositions();
		opportunitypage = Crpage.OpenPositions();

	}

	@Test(priority = 1,groups= {"smoke"})
	public void OpenPositionInArlington() {
		opportunitypage.OpenPositionswithjobTitle();
	}

	@Test(priority = 2,groups= {"Regression"})
	public void applyforaposition() throws InterruptedException {
		SignupForm=opportunitypage.applyNow(utility.JObtitle);
	}

	
	@AfterMethod(groups= {"smoke","Regression"})
	public void tearDown(){
		driver.close();
	}
}
