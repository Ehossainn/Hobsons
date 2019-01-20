package hobsons.com.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import hobsons.com.baseClass.ParentCls;
import hobsons.com.utility.supportUtility;

public class OpenPositions extends ParentCls{
	
	public static List<WebElement> TotalNumberOfJObs = 
			driver.findElements(By.xpath("//*[@id='north-america']/tbody/tr/td[1]/ul/li/a"));;	
	public void OpenPositionswithjobTitle()
	{
		System.out.println("There are "+TotalNumberOfJObs.size()+" open positions in Arlington, VA\nPosition's titles are:\n");
		Iterator<WebElement> itr = TotalNumberOfJObs.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next().getText());
		}
		
	}
	
	public ApplicationSignUp applyNow(String JobTitle) throws InterruptedException
	{
		for (WebElement Links:TotalNumberOfJObs) {
			if(Links.getText().matches(JobTitle+".*"))
			{
				supportUtility.elementVisible(Links, 30);
				Links.click();
				break;
			}
		}
		return new ApplicationSignUp();
	}

	
	
}
