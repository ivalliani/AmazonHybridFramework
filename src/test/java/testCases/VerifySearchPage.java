package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import facotry.BrowserFactory;
import facotry.DataProviderFactory;
import pages.SearchPage;
import utility.Helper;

public class VerifySearchPage {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeTest
	public void openBrowser()
	{
		driver = BrowserFactory.getBrowser("Chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		report = new ExtentReports("./Reports/searchpage.html");
		logger = report.startTest("Search Page Report");
	}
	
	@Test
	public void startTest()
	{
		SearchPage search = PageFactory.initElements(driver, SearchPage.class);
		search.searchbox(DataProviderFactory.getExcel().getData(0, 0, 0));
		search.clicksearchbutton();
		
		String tagname=search.bodytags();
		if(tagname.contains("alexa"))
		{
			logger.log(LogStatus.PASS, "The Body text for Alexa has been confirmed");
			logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "Alexa")));
		}
		
		else 
		{
			logger.log(LogStatus.FAIL, "The Body text for Alexa has NOT been confirmed");
			System.out.println("The Body text for Alexa has NOT been confirmed");
		}
		
		
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.getMessage();
		}
		
		search.searchbox(DataProviderFactory.getExcel().getData(0, 0, 1));
		search.clicksearchbutton();
		
		
		
		String tagnamelaptop=search.bodytags();
		if(tagnamelaptop.contains("Laptops"))
		{
			logger.log(LogStatus.PASS, "The Body text for LapTop has been confirmed");
			logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "LapTop")));
		}
		
		else 
		{
			logger.log(LogStatus.FAIL, "The Body text for LapTop has NOT been confirmed");
			System.out.println("The Body text for LapTop has NOT been confirmed");
		}
		
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.getMessage();
		}
		
		
		report.endTest(logger);
		report.flush();
		
	}
	
	@AfterTest
	public void teardown()
	{
		BrowserFactory.closeBrowser(driver);
	}
}
