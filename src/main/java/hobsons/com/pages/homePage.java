package hobsons.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hobsons.com.baseClass.ParentCls;
import hobsons.com.utility.supportUtility;

public class homePage extends ParentCls {

	@FindBy(xpath="//div[@class ='wrapper']/div[@class='pagetitle c']/h1[text() = 'Education Advances']")
	WebElement HmpageTxt;
	@FindBy(xpath="//div[@class='sitemap']//ul[4]//li[5]//a")
	WebElement CareerPage;
	@FindBy(xpath="//div[@id='cookienotice']//button[text()='OK']")
	WebElement cookies;
		
	
	public homePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateHomePageTitle(){
		return driver.getTitle();
	}
	
	public String validateHomePageText() throws Exception {
		supportUtility.colorBorder(HmpageTxt);
		supportUtility.takescreenshot("validateHomePageText");
		return HmpageTxt.getText();			
	}
	
	public careerPage openPositions() throws Exception
	{
		cookies.click();
		Thread.sleep(5000);
		CareerPage.click();
		return new careerPage();
	}

}

