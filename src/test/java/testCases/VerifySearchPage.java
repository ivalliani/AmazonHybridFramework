package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import facotry.BrowserFactory;
import facotry.DataProviderFactory;
import pages.HomePage;
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
		report = new ExtentReports("./Reports/SearchPage.html");
		logger = report.startTest("Search Page Validation");
		
	}
	
	@Test
	public void startTest()
	{
		
		SearchPage search = PageFactory.initElements(driver, SearchPage.class);
		
		//search.searchbox("alexa");
		
		//search.searchbox("alexa");
		//search.clicksearchbutton();
		
		
		
		search.searchbox(DataProviderFactory.getExcel().getData(0, 0, 0));
		
		search.clicksearchbutton();
		
		
		System.out.println("The title for Alexa search page is "+ driver.getTitle());
		
		String alexatitle=driver.findElement(By.tagName("body")).getText();
		if(alexatitle.contains("alexa"))
		{
			System.out.println("The Title for Alexa Search has been Verified");
			logger.log(LogStatus.PASS, "Alexa Search Title has been Verified");
			logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "Alexa Search has been verified")));
		}
		
		else
		{
			System.out.println("The Title for Alexa Search has NOT been Verified");
			logger.log(LogStatus.FAIL, "Alexa Search Title has NOT been Verified");
			logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "Alexa Search has NoT been verified")));
		
		}
				
		
		
		report.endTest(logger);
		report.flush();
	}
	
	@AfterMethod
	
	public void tearDown()
	{
		//BrowserFactory.closeBrowser(driver);
		driver.quit();
	}

}
