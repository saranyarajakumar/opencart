package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	
	public HomePage(WebDriver driver)
	{
		super(driver); // passing the driver to the parent class by the "super" Keyword
	}
	//Elements
	@FindBy(xpath="//span[text()='My Account']")
	WebElement lnkMyaccount;
	@FindBy(linkText="Register")
	WebElement lnkregister;
	
	@FindBy(linkText="Login")
	WebElement lnkLogin;
	
	//Action Methods
	public void clickMyaccount()
	{
		lnkMyaccount.click();
	}
	public void clickRegister()
	{
		lnkregister.click();
	}
	public void clickLogin()
	{
		lnkLogin.click();
	}
}
