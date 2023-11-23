package TestNG;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Extended_report {
	WebDriver driver;
	
	String openurl = "https://www.facebook.com/";
	
	ExtentHtmlReporter reporter;  //ExtentHtmlReporter is an class and  reporter is an object // reporter reference is created
	ExtentTest test;             // reporter,test,extent these objects will be used to create and manage  test reports.
	ExtentReports extent;
	
	@BeforeTest
	public void setup() {
		reporter = new ExtentHtmlReporter("./Reports/myreport1.html"); //This line initializes the reporter object by creating an instance of ExtentHtmlReporter and specifying the path where you want to save the HTML report file.
		reporter.config().setDocumentTitle("Automation test report"); //This line configures the document title for the HTML report. The title I set is "Automation test report". This title is displayed at the top of the HTML report.
		reporter.config().setReportName("Functional test"); // To set Report name
		reporter.config().setTheme(Theme.STANDARD); // To set the theme of the HTML report to DARK.
		
		extent = new ExtentReports(); //creating an object extent of the ExtentReports class which is declared at top . This object represents the overall test report, and  will use it to manage and organize test information.
		extent.attachReporter(reporter); //This line attaches the previously created reporter (reference of ExtentHtmlReporter) to the extent object. This step connects the HTML reporter with the main ExtentReports object, allowing it to accumulate and display the test results in the HTML report.
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("os", "windows 11");  //To set system information for the test report.
		extent.setSystemInfo("Tester name", "shrin");
		extent.setSystemInfo("Browser name", "chrome");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void url() {
		driver.get(openurl);
	}
	
	@Test
	public void test1() {
		
		driver.manage().window().maximize();
		
		test = extent.createTest("Fb Title Verification"); //To set heading for test
		String expected = "Facebook – log in or sign up"; 
		String actual = driver.getTitle();
		System.out.println(actual);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		test = extent.createTest("fb button test");
		String btntest = driver.findElement(By.name("login")).getText();
		System.out.println(btntest);
		Assert.assertEquals(btntest, "Log in");
	}
	
	@AfterTest
	public void teardown() {
		extent.flush();
	}
	
	@AfterMethod
	public void closebrowser(ITestResult result) {  //ITestResult is an Listener which has methods : SUCCESS, FAILURE, SKIP
		if(result.getStatus()==ITestResult.FAILURE)  //If test result status is failed
		{
			test.log(Status.FAIL, "Test case Failed due to:"+result.getTestName());  //Log the test failure status and the test name
			test.log(Status.FAIL, "test failed due to:"+result.getThrowable());  //Log the details of the failure (exception/stack trace)
		}
		else if (result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP,"Test case skipped is"+result.getName());
		}
		else if (result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS,"test case paased is:"+result.getName());
		}
	}
}
