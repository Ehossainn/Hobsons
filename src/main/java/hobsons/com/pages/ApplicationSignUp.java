package hobsons.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import hobsons.com.baseClass.ParentCls;
import hobsons.com.utility.supportUtility;

public class ApplicationSignUp extends ParentCls {
	
	@FindBy(xpath="//div[@class='intro']/a[@class = 'button cta' and text()='Apply Now']")
	WebElement ApplyNow;
	
	@FindBy(xpath="//*[@id='jv_careersite_iframe_id']")
	WebElement signupFrame;
	
	@FindBy(xpath="//button[@class='jv-button jv-button-primary ng-isolate-scope']")
	WebElement SelectResume;
	
	@FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='File'])[1]/following::span[1]")
	WebElement TypeOrPaste;
	
	@FindBy(id="jv-paste-resume-textarea0")
	WebElement TextArea;
	
	@FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")
	WebElement SaveResume;
	
	@FindBy(id="jv-field-ypbtXfwK")
	WebElement Firstname;
	
	@FindBy(id="jv-field-ydatXfwx")
	WebElement Lastname;
	
	@FindBy(id="jv-field-ygatXfwA")
	WebElement Email;
	
	@FindBy(id="jv-field-yqbtXfwL")
	WebElement Phone;
	
	@FindBy(id="jv-field-ycatXfww")
	WebElement Address;
	
	@FindBy(id="jv-field-yrbtXfwM")
	WebElement City;
		
	@FindBy(id="jv-field-yhatXfwB")
	WebElement ZipCode;
	
	@FindBy(id="jv-field-yjatXfwD")
	WebElement PrefLocation;
	
	@FindBy(id="jv-field-yh9eYfwm")
	WebElement DesireBseSalary;
	
	@FindBy(id="jv-field-yi9eYfwn")
	WebElement TotalCompns;
	
	@FindBy(id="jv-error-ypbtXfwK")
	WebElement FieldValidation;
		
	@FindBy(xpath=".//span[text()=\"Send Application\"]")
	WebElement submitButton;
	
	public ApplicationSignUp() {
		PageFactory.initElements(driver, this);
	}
	
	public void applicationform() throws Exception
	{
		ApplyNow.click();
		supportUtility.colorBorder(signupFrame);
		supportUtility.takescreenshot("applicationform");
		driver.switchTo().frame(signupFrame);
		
		
		SelectResume.click();
		TypeOrPaste.click();
		Thread.sleep(1000);
		supportUtility.Copy_String(supportUtility.readStringFromFile(supportUtility.docfile));
		TextArea.sendKeys(Keys.CONTROL, "v");
		SaveResume.click();
		
		
		Firstname.sendKeys(supportUtility.getValue("First Name"));
		supportUtility.colorBorder(Firstname);
		supportUtility.takescreenshot("applicationform");
		Lastname.sendKeys(supportUtility.getValue("Last Name"));
		
		Email.sendKeys(supportUtility.getValue("Email"));
		Phone.sendKeys(supportUtility.getValue("Phone"));
		
		Address.sendKeys(supportUtility.getValue("Address"));
		City.sendKeys(supportUtility.getValue("City"));
		
		Select State= new Select(driver.findElement(By.id("jv-field-y9atXfwt")));
		State.selectByVisibleText(supportUtility.getValue("State"));
		
		ZipCode.sendKeys(supportUtility.getValue("Postal Code"));
		PrefLocation.sendKeys(supportUtility.getValue("Preferred Work Location"));
		DesireBseSalary.sendKeys(supportUtility.getValue("Desired Base Salary"));
		TotalCompns.sendKeys(supportUtility.getValue("Desired Total Compensation"));
		
		
		Select WorkAuthorization= new Select(driver.findElement(By.id("jv-field-ybatXfwv")));
		WorkAuthorization.selectByVisibleText("Yes");
		

		Select SponsorShip= new Select(driver.findElement(By.id("jv-field-ymatXfwG")));
		SponsorShip.selectByVisibleText("No");
		
		
		Select nonCmpltAgrmnt= new Select(driver.findElement(By.id("jv-field-yobtXfwJ")));
		nonCmpltAgrmnt.selectByVisibleText("No");
		
	
		Select hobsonsempornot= new Select(driver.findElement(By.id("jv-field-yvbtXfwQ")));
		hobsonsempornot.selectByVisibleText("No");
		
		
	}
	
	public String requireFieldvalidation() throws Exception {
		ApplyNow.click();
		driver.switchTo().frame(signupFrame);
		submitButton.click();
		supportUtility.colorBorder(FieldValidation);
		supportUtility.takescreenshot("FieldValidation");
		return FieldValidation.getText();
	}
	

}
