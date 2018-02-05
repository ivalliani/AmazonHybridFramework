package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class HomePage {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	
	public void openBrowser(WebDriver Idriver)
	{
		this.driver=Idriver;
		report = new ExtentReports("./Reports/AmazonReport.html");
		logger = report.startTest("Amazon Page Verification");
		
	}
	
	@FindBy (xpath=".//*[@id='nav-logo']/a[2]") WebElement clickonPrime;
	
	@FindBy (xpath="//a[contains(@id,'nav-your-amazon')]") WebElement yourAmazon;
	
	@FindBy (xpath=".//*[@id='nav-xshop']/a[2]") WebElement todayDeal;
	
	@FindBy (xpath=".//*[@id='nav-xshop']/a[3]") WebElement giftCards;
	
	@FindBy (xpath=".//*[@id='nav-xshop']/a[4]") WebElement Registry;
	
	@FindBy (xpath=".//*[@id='nav-xshop']/a[5]") WebElement sell;
	
	@FindBy (xpath=".//*[@id='nav-xshop']/a[6]") WebElement help;
	
	
	public void checkPrimepage()
	{
		clickonPrime.click();
	}
	
	public void yourAmazonPage()
	{
		yourAmazon.click();
	}
	
	public void todaysDeals()
	{
		todayDeal.click();
	}
	
	public void GiftCards()
	{
		giftCards.click();
	}
	
	public void RegistryPage()
	{
		Registry.click();
	}
	
	public void SellPage()
	{
		sell.click();
	}
	
	public void HelpPage()
	{
		help.click();
	}

}
