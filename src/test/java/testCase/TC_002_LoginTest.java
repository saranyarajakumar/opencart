package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups = {"Sanity","Master"}) //Groups added
	public void test_Login()
	{
		logger.info("********TC_002_LoginTest started********");
		try
		{		
		//homepage --MyAccyount--Login
		HomePage hp = new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		
		//LoginPage--Email--Password--Click
		
		LoginPage lgnPage = new LoginPage(driver);
		lgnPage.setEmail(p.getProperty("email"));
		lgnPage.setPassword(p.getProperty("password"));
		lgnPage.clkLogin();
		//Check MyAccount  Label is present
		
		MyAccountPage myacc = new MyAccountPage(driver);
		boolean targetPage = myacc.ismyAccountPageExists();
		Assert.assertEquals(targetPage, true);
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*****Test Finished ************");
		
	}

}
