package hobsons.com.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import hobsons.com.baseClass.ParentCls;
import hobsons.com.pages.careerPage;
import hobsons.com.pages.homePage;

public class HomePageTestCases extends ParentCls {
	homePage Hmpage;
	careerPage Crpage;
	
	public HomePageTestCases() {
		super();
	}
	
	@BeforeMethod(groups= {"smoke","Regression"})
	public void setUp(){
		initialization();
		Hmpage = new homePage();	
	}
	
	@Test(priority=1,groups= {"smoke"})
	public void homePageTitle(){
		String title = Hmpage.validateHomePageTitle();
		Assert.assertEquals(title, "Education Advances | Hobsons");
	}
	
	@Test(priority=2,groups= {"smoke"})
	public void homePageTest() throws Exception{
		String Hmtxt = Hmpage.validateHomePageText();
		Assert.assertTrue(Hmtxt.equalsIgnoreCase("Education Advances"));
		
	}
	@Test(priority=3,groups= {"Regression"})
	public void visitCareerPage() throws Exception
	{
		Crpage=Hmpage.openPositions();
	}
	

	@AfterMethod(groups= {"smoke","Regression"})
	public void tearDown(){
		driver.close();
	}
}
