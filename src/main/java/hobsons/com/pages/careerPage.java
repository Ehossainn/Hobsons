package hobsons.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hobsons.com.baseClass.ParentCls;

public class careerPage extends ParentCls{
	
	@FindBy(xpath=".//div[@class='pagetitle c']/h1[text()='We Are Hobsons']")
	WebElement CareerPagetxt;
	
	@FindBy(xpath="//iframe[@frameborder='0']")
	static WebElement viframe;
	
	@FindBy(xpath="//div[@class='play-icon']//*[@viewBox='0 0 20 20']")
	static WebElement playbtn;
	
	@FindBy(xpath="//div[@class='pause-icon']//*[@viewBox='0 0 20 20']")
	static WebElement pausebtn;
	
	@FindBy(xpath=".//a[text()='Open positions']")
	WebElement jobs;
	
		public careerPage(){
			PageFactory.initElements(driver, this);
		}
	
		public String careerPageTitle(){
			return driver.getTitle();
		}
		
		public String CareerPageText() {
			return CareerPagetxt.getText();			
		}
		
		public OpenPositions OpenPositions() {
			jobs.click();
			return new OpenPositions();			
		}
		public void introVideo() {
			driver.switchTo().frame(viframe);
			Actions actionBuilder = new Actions(driver);
			actionBuilder.click(playbtn).build().perform();
			try {
				Thread.sleep(17000);
				actionBuilder.click(pausebtn).build().perform();
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
	

}
