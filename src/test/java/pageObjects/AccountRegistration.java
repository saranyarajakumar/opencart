package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage {
	
	
public AccountRegistration(WebDriver driver)
{

super(driver);
}

//Elements

@FindBy(name="firstname")
WebElement txtfirstname;

@FindBy(name="lastname")
WebElement txtlastname;
@FindBy(name="email")
WebElement txtemail;
@FindBy(name="telephone")
WebElement txttelephone;
@FindBy(name="password")
WebElement txtpassword;
@FindBy(name="confirm")
WebElement txtconfirm;
@FindBy(name="agree")
WebElement chkdPolicy;
@FindBy(xpath="//input[@value='Continue']")
WebElement btnContinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;

public void setFirstName(String fname)
{
	txtfirstname.sendKeys(fname);
}

public void setLastName(String lname)
{
	txtlastname.sendKeys(lname);
}

public void setEmail(String email)
{
	txtemail.sendKeys(email);
}
public void setTelephone(String telephone)
{
	txttelephone.sendKeys(telephone);
}
public void setPassword(String pwd)
{
	txtpassword.sendKeys(pwd);
}
public void setConfirmPassword(String pwd)
{
	txtconfirm.sendKeys(pwd);
}

public void setPrivacyPolicy()
{
	chkdPolicy.click();
}
public void clickContinue()
{
	
	//sol1 
	btnContinue.click();
	
	//sol2 
	//btnContinue.submit();
	
	//sol3
	//Actions act=new Actions(driver);
	//act.moveToElement(btnContinue).click().perform();
				
	//sol4
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("arguments[0].click();", btnContinue);
	
	//Sol 5
	//btnContinue.sendKeys(Keys.RETURN);
	
	//Sol6  
	//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();

}
public String getConfirmationMsg()
{
	try
	{
		return (msgConfirmation.getText());
	}
	catch(Exception e)
	{
		return (e.getMessage());
	}
	
}
}
