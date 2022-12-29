package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener{

	public ExtentSparkReporter sparkReporter;  // UI of the report
	public ExtentReports extent;  //populate common info on the report
	public ExtentTest test; // creating test case entries in the report and update status of the test methods

	String repName;

	public void onStart(ITestContext context) {
		//(Approach)
			
		/*sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/myReport.html");//specify location of the report
		
		sparkReporter.config().setDocumentTitle("Automation Report"); // TiTle of report
		sparkReporter.config().setReportName("Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer Name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("Tester Name","Pavan");
		extent.setSystemInfo("os","Windows10");
		extent.setSystemInfo("Browser name","Chrome,Firefox,Edge");*/


		
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		repName = "Test-Report-" + timeStamp + ".html";

		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);// specify location of the report

		sparkReporter.config().setDocumentTitle("opencart Automation Report"); // Title of report
		sparkReporter.config().setReportName("opencart Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environemnt", "QA");
					
	}


	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName()); // create a new enty in the report
		test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s
		
	}

	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable()); 
		
		try {
			String imgPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
					
	}

	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		//test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
		//test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}

	
	public void onFinish(ITestContext context) {
		
		extent.flush();
		/*
		 * try { URL url = new
		 * URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
		 * 
		 * // Create the email message 
		 * ImageHtmlEmail email = new ImageHtmlEmail();
		 * email.setDataSourceResolver(new DataSourceUrlResolver(url));
		 * email.setHostName("smtp.googlemail.com"); 
		 * email.setSmtpPort(465);
		 * email.setAuthenticator(new DefaultAuthenticator("pavanoltraining@gmail.com","password")); 
		 * email.setSSLOnConnect(true);
		 * email.setFrom("pavanoltraining@gmail.com"); //Sender
		 * email.setSubject("Test Results");
		 * email.setMsg("Please find Attached Report....");
		 * email.addTo("pavankumar.busyqa@gmail.com"); //Receiver 
		 * email.attach(url, "extent report", "please check report..."); 
		 * email.send(); // send the email 
		 * }
		 * catch(Exception e) { e.printStackTrace(); }
		 */
	}
	
}
