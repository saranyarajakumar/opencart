package testCase;

import static org.testng.Assert.fail;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups = {"Regression","Master"})
	public void test_Account_Registration()
	{
		 logger.info("***TC_001_Account Registration****");
		    logger.trace("Capturing Trace Logs");
		try
		{   
	    
		HomePage hp = new HomePage(driver);
		logger.info("***Clicking on my account link****");
		hp.clickMyaccount();
		logger.info("***Clicking on Registration Link***");
		hp.clickRegister();
		
				
		AccountRegistration regpage = new AccountRegistration(driver);
		logger.info("***Providing Customer Info****");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeString());		
		String password = randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		logger.info("***Clicking on Continue Button***");
		regpage.clickContinue();
		String confmsg = regpage.getConfirmationMsg();
		logger.info("***Verifying customer registraion***");
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.warn("Customer registration is not  successful");
			logger.info("Test Passed");
			
			Assert.assertTrue(true);
			
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		else
		{
			Assert.assertTrue(false);
			logger.error("Test Failed");
		}
		}
		catch(Exception e)
		{
			//logger.warn("Customer registration Info is not successul");
			//logger.error("Customer Registraion Failed");
			Assert.fail();
		}
		logger.info("***Finished TC_001_Registration");
		}
		
	}
	
	
