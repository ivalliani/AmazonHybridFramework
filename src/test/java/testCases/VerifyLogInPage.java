package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import facotry.BrowserFactory;
import facotry.DataProviderFactory;
import pages.LoginPage;
import utility.Helper;

public class VerifyLogInPage {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void openBrowser()
	{
		driver = BrowserFactory.getBrowser("Chrome");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		report = new ExtentReports("./Reports/loginreports.html");
		logger = report.startTest("Login Report");
		
	}

	
	@Test
	public void  startTest()
	{
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		login.clickonsignon();
		
		
		
		
		
		/*if (bodytext.contains("Password"))
		{
			
			String username =DataProviderFactory.getExcel().getData(0, 1, 0);
			String password=DataProviderFactory.getExcel().getData(0, 1, 1);
			login.logindetails(username, password);
			login.logintopage();
			logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "Login Details")));
		}
		
		else
		{
			String username =DataProviderFactory.getExcel().getData(0, 1, 0);
			login.continuepage();
			String password=DataProviderFactory.getExcel().getData(0, 1, 1);
			login.logindetails(username, password);
			login.logintopage();
			
			
		}*/
		
		String bodytext = driver.findElement(By.tagName("body")).getText();
		
		if (bodytext.contains("Password"))
		{
			String username =DataProviderFactory.getExcel().getData(0, 1, 0);
			String password=DataProviderFactory.getExcel().getData(0, 1, 1);
			login.username(username);
			login.password(password);
			logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "Login Details")));
			System.out.println("Login Page title "+ driver.getTitle());
			
			login.logintopage();
		}
		
		else
		{
			String username =DataProviderFactory.getExcel().getData(0, 1, 0);
			String password=DataProviderFactory.getExcel().getData(0, 1, 1);
			login.username(username);
			login.continuepage();
			login.password(password);
			login.logintopage();
			logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShots(driver, "Login Details")));
			System.out.println("Login Page title "+ driver.getTitle());
			
			
		}
		
		
		
		
		
		report.endTest(logger);
		report.flush();
		
		driver.quit();
	}
	
	@AfterTest
	public void teardown()
	{
		//BrowserFactory.closeBrowser(driver);
	}
	
	
}
