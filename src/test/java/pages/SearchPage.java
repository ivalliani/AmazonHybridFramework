package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {
	
	WebDriver driver;
	
	public void OpenBrowser(WebDriver Idriver)
	{
		this.driver=Idriver;
		
	}
	
	@FindBy (id="twotabsearchtextbox") WebElement searchterm;
	
	@FindBy (xpath=".//*[@id='nav-search']/form/div[2]/div/input") WebElement clicksearch;
	
	public void searchbox(String keyword)
	{
		searchterm.sendKeys(keyword);
	}
	
	public void clicksearchbutton()
	{
		clicksearch.click();
	}

}
