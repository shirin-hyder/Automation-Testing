package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rediff_Complete_testing {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void url() {
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
	}
	
	@Test
	public void rediff() {
		
		WebElement fullname = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input"));
		fullname.sendKeys("Shirin");
		
		WebElement mail = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]"));
		mail.sendKeys("shirin@gmail.com");
		
		WebElement pass = driver.findElement(By.xpath("//*[@id=\"newpasswd\"]"));
		pass.sendKeys("shirin598/*");
		
		WebElement repass = driver.findElement(By.xpath("//*[@id=\"newpasswd1\"]"));
		repass.sendKeys("shirin598/*");
		
		WebElement check = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[15]/td[2]/table/tbody/tr/td[1]/input"));
		check.click();
		
		// Drop down list Security Question
		WebElement drop1 = driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[2]/td[3]/select"));
		Select secdrop = new Select(drop1);
		secdrop.selectByVisibleText("What is the name of your first school?");
		
		WebElement secanswer = driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[4]/td[3]/input"));
		secanswer.sendKeys("mes school");
		
		driver.findElement(By.xpath("//*[@id=\"div_hintQS\"]/table/tbody/tr[6]/td[3]/input")).sendKeys("Ramla");
		
		// mobile code
		WebElement countrycode=driver.findElement(By.xpath("//*[@id=\"div_mob\"]/table/tbody/tr/td[3]/div[2]"));
		countrycode.click();          //  //*[@id="div_mob"]/table/tbody/tr/td[3]/div[2]/div[1]
		
		WebElement usa=driver.findElement(By.xpath("//*[@id=\"country_id\"]/ul/li[2]"));
		usa.click();  // //*[@id="country_id"]/ul/li[2]
		
		WebElement mobileno = driver.findElement(By.xpath("//*[@id=\"mobno\"]"));
		mobileno.sendKeys("9632587415");
		
		// DOB
		//day
		WebElement day = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[1]"));
		Select daydrop = new Select(day);
		daydrop.selectByValue("05");
		
		//month
		WebElement month = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[2]"));
		Select monthdrop = new Select(month);
		monthdrop.selectByVisibleText("APR");
		
		//Year
		WebElement year = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[3]"));
		Select yeardrop = new Select(year);
		yeardrop.selectByIndex(06);
		
		//Gender
		WebElement female = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[2]"));
		female.click();
		
		//country
		WebElement country = driver.findElement(By.xpath("//*[@id=\"country\"]"));
		Select countrydrop = new Select(country);
		countrydrop.selectByVisibleText("Armenia");
		
		//create account button
		WebElement createbtn = driver.findElement(By.xpath("//*[@id=\"Register\"]"));
		createbtn.submit();
		}
}
