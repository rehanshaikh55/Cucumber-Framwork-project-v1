package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class extentReportUtilities implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;
	
	public void onStart(ITestContext testContext) {
	/*SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	Date dt=new Date();
	String currentdatetimestamp=df.format(dt);
	*/
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	repName = "Test-Report-" + timeStamp + ".html";
	sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName); 
	sparkReporter.config().setDocumentTitle("opencart Automation Report"); 
	sparkReporter.config().setReportName("opencart Functional Testing");
	sparkReporter.config().setTheme (Theme.DARK);
	extent = new ExtentReports();
	extent.attachReporter (sparkReporter);
	extent.setSystemInfo("Application", "opencart");
	extent.setSystemInfo("Module", "Admin");
	extent.setSystemInfo("Sub Module", "Customers");
	extent.setSystemInfo("User Name", System.getProperty("user.name"));
	extent.setSystemInfo("Environemnt", "QA");
	String os = testContext.getCurrentXmlTest().getParameter("os");
	extent.setSystemInfo("Operating System", os);
	String browser = testContext.getCurrentXmlTest().getParameter("browser");
	extent.setSystemInfo("Browser", browser);
	List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
	if(!includedGroups.isEmpty()) {
	extent.setSystemInfo("Groups", includedGroups.toString());
	}
	}
	public void onTestSuccess (ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory (result.getMethod().getGroups()); // to display groups in report
		test.log(Status. PASS, result.getName()+" got successfully executed");
		}
	
	public void onTestFailure (ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status. FAIL, result.getName()+" got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
	
	}
	
	public void onTestSkipped (ITestResult result) {
		test = extent.createTest (result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+" got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
		}
	
	public void onFinish (ITestContext testContext) {
		
		extent.flush();
		String pathOfExtentReport = System.getProperty("user.dir")+"\\target\\"+"htmlreport.html";
		File extentReport = new File(pathOfExtentReport);
		try {
		Desktop.getDesktop().browse (extentReport.toURI());
		} catch (IOException e) {
		e.printStackTrace();
		}
	/*	
		try {
			URL url = new URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
			// Create the email message
			ImageHtmlEmail email = new ImageHtmlEmail();
			email.setDataSourceResolver(new DataSourceUrlResolver(url));
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("dankdankdank0126@gmail.com","Rehan@786"));
			email.setSSLOnConnect (true);
			email.setFrom("pavanoltraining@gmail.com"); //Sender
			email.setSubject("Test Results");
			email.setMsg("Please find Attached Report....");
			email.addTo("shaikhrehan1016@gmail.com"); //Receiver
			email.attach(url, "extent report", "please check report...");
			email.send(); // send the email
			}
			catch (Exception e)
			{
			e.printStackTrace();
			}
	*/
	}
}
