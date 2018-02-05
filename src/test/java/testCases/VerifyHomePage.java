package testCases;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
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
import junit.framework.Assert;
import pages.HomePage;

public class VerifyHomePage {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	
	@BeforeTest
	public void openBrowser()
	{
		driver = BrowserFactory.getBrowser("Chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		report = new ExtentReports("./Reports/AmazonHomePageReport.html");
		logger = report.startTest("Amazon.Com Report Page");
		
	}
	@Test
	public void startTest()
	{
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		
		String homepageTitle = driver.getTitle();
		
		if(homepageTitle.contains("Online Shopping for"))
		{
			logger.log(LogStatus.PASS, "Home Page Title has been Verified");
			System.out.println("The Home Page title has been verified");
		}
		
		else
		{
			logger.log(LogStatus.FAIL, "Home Page Title has NOT been Verified");
			System.out.println("The Home Page title has NOT been verified");
		}
		
		
		
		
		home.checkPrimepage();
		String primepageTitle = driver.getTitle();
		System.out.println("The title for Prime Page is "+ primepageTitle);
		logger.log(LogStatus.INFO, "The title for Prime page: "+primepageTitle);
		
		
		home.yourAmazonPage();
		String youramazonpageTitle = driver.getTitle();
		System.out.println("The title for Your Amazon Page is "+ youramazonpageTitle);
		logger.log(LogStatus.INFO, "The title for Your Amazon Page is : "+youramazonpageTitle);
		
		
		driver.navigate().back();
		
		home.todaysDeals();
		String todaydealsTitle = driver.getTitle();
		System.out.println("The title for Todays Deals is "+ todaydealsTitle);
		logger.log(LogStatus.INFO, "The title for Your Todays Deals is : "+todaydealsTitle);
		
		
		home.GiftCards();
		String giftcardTitle = driver.getTitle();
		System.out.println("The title for Gift Card Page is "+ giftcardTitle);
		logger.log(LogStatus.INFO, "The title for Gift Cards Page is : "+giftcardTitle);
		
		
		
		report.endTest(logger);
		report.flush();
		
		
	}
	
		
	
	@AfterTest
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	}

}
