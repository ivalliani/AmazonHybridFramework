package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	
	public void openBrowser(WebDriver Idriver)
	{
		this.driver=Idriver;
	}
	
	@FindBy (css="#nav-link-accountList") WebElement clickonsignon;
	
	@FindBy (css="#ap_email") WebElement username;
	
	@FindBy (css="#ap_password") WebElement password;
	
	@FindBy (xpath="//input[contains(@id,'continue')]") WebElement continuenext;
	
	@FindBy (xpath="//input[contains(@id,'signInSubmit')]") WebElement loginclick;
	
	@FindBy (tagName="body") WebElement pagetags;
	
	
	

	
	public void clickonsignon()
	{
		clickonsignon.click();
	}
	
	public void username(String user)
	{
		username.sendKeys(user);
		
		
		
	}
	
	public void password(String pass)
	

	{
		password.sendKeys(pass);
	}
	
	public void logintopage()
	{
			loginclick.click();
			
			
	
			
			
			
		
		
	}
	
	public void continuepage()
	{
		continuenext.click();
	}

	public String pagetag()
	{
		pagetags.getText();
		return "pass";
	}
	
	
		
	}


