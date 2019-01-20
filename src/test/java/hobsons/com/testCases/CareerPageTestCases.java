package hobsons.com.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;


import hobsons.com.baseClass.ParentCls;
import hobsons.com.pages.OpenPositions;
import hobsons.com.pages.careerPage;
import hobsons.com.pages.homePage;
import hobsons.com.utility.supportUtility;

public class CareerPageTestCases extends ParentCls {
	
	homePage Hmpage;
	careerPage Crpage;
	OpenPositions opportunitypage;
	supportUtility utility;
	
	public CareerPageTestCases() {
		super();
	}
	
	@BeforeMethod(groups= {"smoke","Regression"})
	public void setUp() throws Exception{
		initialization();
		utility = new supportUtility();
		utility.popupHndler();
		Hmpage = new homePage();
		Crpage=Hmpage.openPositions();	
	}
	
	@Test(priority=1,groups= {"smoke"})
	public void Validatepagetitle()
	{
		String pgtitle = Crpage.careerPageTitle();
		Assert.assertEquals(pgtitle, "Who We Are | Hobsons");
	}
	
	@Test(priority=2,groups= {"Regression"})
	public void IntroVideo()
	{
		Crpage.introVideo();
	}
	
	@Test(priority=3,groups= {"Regression"})
	public void VisitOpenOpportunities()
	{
		opportunitypage=Crpage.OpenPositions();
	}
	
	
	@AfterMethod(groups= {"smoke","Regression"})
	public void tearDown(){
		driver.close();
	}
}
