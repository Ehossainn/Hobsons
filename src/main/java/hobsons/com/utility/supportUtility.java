package hobsons.com.utility;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hobsons.com.baseClass.ParentCls;

public class supportUtility extends ParentCls {

	public static long pageLoad = 40;
	public static long impwait = 50;
	public String JObtitle = "Cloud Operations Engineer Intern";
	
	private static String TestData_File_Path = "./src/main/java/hobsons/com/testData/TestDataFile.xlsx";
	public static String docfile = "./src/main/java/hobsons/com/testData/Sample_resume.txt";

	private static FileInputStream fis;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	
	public void popupHndler()
	{
		driver.findElement(By.xpath("//div[@id='cookienotice']//button[text()='OK']")).click();
	}
	
	public static String readStringFromFile(String filePath) throws Exception {
	    String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
	    return fileContent;
	}
	
	public static void colorBorder(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px outset red'", element);
	}
	
	public static void elementVisible(WebElement element, int wait_Time) {
		new WebDriverWait(driver, wait_Time).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void takescreenshot(String imageName) throws Exception

	{

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'-'HH-mm-ss.SSS");
		String ScreenShortName = (imageName+"-"+dateFormat.format(new Date())) + ".jpg";
		FileUtils.copyFile(src, new File(("./ScreenShorts/" + ScreenShortName)));
	}
	
	public static void Copy_String(String string)
	{
		
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

	}
	
	private static void loadFile() throws Exception {

		File file = new File(TestData_File_Path);
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("SignUp");
		fis.close();

	}
	private static Map<String, Map<String, String>> getData() throws Exception {
		if (sheet == null) {
			loadFile();
		}

		Map<String, Map<String, String>> parentMap = new HashMap<String, Map<String, String>>();
		Map<String, String> innerMap = new HashMap<String, String>();

		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			
			String keyCell = row.getCell(0).getStringCellValue();

			int collNum = row.getLastCellNum();

			for (int j = 1; j < collNum; j++) {

				String keyValue = row.getCell(j).getStringCellValue();
				innerMap.put(keyCell, keyValue);

			}
			parentMap.put("MasterData", innerMap);
		}

		return parentMap;

	}
	
	public static String getValue(String key) throws Exception
	{
		Map<String, String> expectedValue = getData().get("MasterData");
		String retValue = expectedValue.get(key);
		return retValue;
		
	}
	
}
