package TestNG;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_reg {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void url() {
		driver.get("https://www.amazon.in/ap/register?openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fref%3Drhf_sign_in&openid.assoc_handle=inflex");
	}
	@Test
	public void amz() throws InterruptedException, IOException {
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"ap_customer_name\"]")).sendKeys("shirin");
		
		// Mobile number
		WebElement countrycode = driver.findElement(By.xpath("//*[@id=\"auth-country-picker-container\"]/span/span/span"));
		countrycode.click();
		
		WebElement newzealand = driver.findElement(By.xpath("//*[@id=\"auth-country-picker_144\"]"));
		newzealand.click();
		
		// Mobile number
		WebElement number = driver.findElement(By.xpath("//*[@id=\"ap_phone_number\"]"));
		number.sendKeys("8569856985");
		
		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("shirin@gmail.com"); // Email
		driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("6khbYCH5672345"); //password
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).submit();  // Submit button
		
		Thread.sleep(5000);
		driver.navigate().back(); 
		
		// screenshot
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//photo//pic.png"));
	}
	
	
	@Test
	public void basics() {
		// Title verification
		String actual = driver.getTitle();
		System.out.println(actual);
		
		String expected = "Amazon Registration";
		
		if(actual.contentEquals(expected) ) {
			System.out.println("correct");
		}
		else {
			System.out.println("in correct");
			
		}
		// to test presence of element
		String element = driver.getPageSource();  //element is user defined variable and driver is the created object
		if(element.contains("Log in")) 
		{
			System.out.println("Pass");
		}
			else {
				System.out.println("fail");
			}
	}

}
