package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
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
import pages.HomePage;
import utility.Helper;

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
		
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "Amazon Home Page")));
		
		
		home.checkPrimepage();
		String primepageTitle = driver.getTitle();
		System.out.println("The title for Prime Page is "+ primepageTitle);
		logger.log(LogStatus.INFO, "The title for Prime page: "+primepageTitle);
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "Prime Page")));
		
		
		home.yourAmazonPage();
		String youramazonpageTitle = driver.getTitle();
		System.out.println("The title for Your Amazon Page is "+ youramazonpageTitle);
		logger.log(LogStatus.INFO, "The title for Your Amazon Page is : "+youramazonpageTitle);
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "Your Amazon Page")));
		
		
		/*driver.navigate().back();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.getMessage();
		}
		
		home.todaysDeals();
		String todaydealsTitle = driver.getTitle();
		System.out.println("The title for Todays Deals is "+ todaydealsTitle);
		logger.log(LogStatus.INFO, "The title for Your Todays Deals is : "+todaydealsTitle);
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "Amazon Todays Deals")));
		
		
		home.GiftCards();
		String giftcardTitle = driver.getTitle();
		System.out.println("The title for Gift Card Page is "+ giftcardTitle);
		logger.log(LogStatus.INFO, "The title for Gift Cards Page is : "+giftcardTitle);
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "Amazon Gift Cards")));
		
		home.RegistryPage();
		String registryTitle = driver.getTitle();
		System.out.println("The title for Registry Page is "+ registryTitle);
		logger.log(LogStatus.INFO, "The title for Registry Page is : "+giftcardTitle);
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "Registry Page")));
		
		home.SellPage();
		String sellTitle = driver.getTitle();
		System.out.println("The title for Sell Page is "+ sellTitle);
		logger.log(LogStatus.INFO, "The title for Sell Page is : "+sellTitle);
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "Registry Page")));
		
		
		home.HelpPage();
		String helpTitle = driver.getTitle();
		System.out.println("The title for Help Page is "+ helpTitle);
		logger.log(LogStatus.INFO, "The title for Help Page is : "+helpTitle);
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "Registry Page")));
		*/
		
		
		report.endTest(logger);
		report.flush();
		
		driver.quit();
		
		
	}
	
		
	
	
	

}
