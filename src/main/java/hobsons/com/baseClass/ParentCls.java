package hobsons.com.baseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import hobsons.com.utility.supportUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ParentCls {

	public static WebDriver driver;
	public static Properties prop;

	public ParentCls()

	{
		prop = new Properties();
		FileInputStream Fis = null;
		try {
			Fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/hobsons/com/configFile/config.properties");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			prop.load(Fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization()

	{
		String browser = prop.getProperty("browser");
		String Url = prop.getProperty("url");
		if (browser.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(Url);
		driver.manage().timeouts().pageLoadTimeout(supportUtility.pageLoad, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(supportUtility.impwait, TimeUnit.SECONDS);

	}

}
