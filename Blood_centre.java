package bagmo_private_limited;
import java.time.Duration;
import java.util.concurrent.Executor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Blood_centre {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void url() {
		driver.get("https://app.bagmo.in/user/login");
	}
	
	@Test
	public void test() {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		email.sendKeys("tester@bagmo.in");
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		password.sendKeys("Bagmotester321");
		WebElement login = driver.findElement(By.xpath("//*[@id=\"submit-btn\"]/span[1]"));
		login.click();
		
		Actions act = new Actions(driver);
		WebElement blooddonation = driver.findElement(By.xpath("//*[@id=\"kt_app_header_menu\"]/div[2]/span/span[1]"));
		act.moveToElement(blooddonation);
		act.build().perform();
		
		WebElement donorregister = driver.findElement(By.xpath("//*[@id=\"donor_donations\"]/div/div/div/div[1]/div[1]/a/span[2]"));
		act.moveToElement(donorregister);
		donorregister.click();
		
		WebElement wholeblood = driver.findElement(By.xpath("//*[@id=\"kt_create_account_form\"]/div[1]/div/div[2]/div/div[1]/label/span[2]"));
		wholeblood.click();
		WebElement voluntary = driver.findElement(By.xpath("//*[@id=\"autologous-hide\"]/div[2]/div[1]/label/span[2]"));
		voluntary.click();
		WebElement continuebtn = driver.findElement(By.xpath("//*[@id=\"continue-btn\"]"));
		continuebtn.click();
		
		//Donor Info
		WebElement contact = driver.findElement(By.xpath("//*[@id=\"phone_no\"]"));
		contact.sendKeys("8885967485");
		
		WebElement grp=driver.findElement(By.xpath("//*[@id=\"kt_create_account_form\"]/div[2]/div/div[3]/div[1]/div[2]/div[1]/span/span[1]/span"));
		grp.click();  //Blood group drop down
		WebElement blood=driver.findElement(By.xpath("//*[@id=\"select2-blood_group_id-container\"]"));
		blood.click();  // Choosing blood group
		
		WebElement fullname = driver.findElement(By.xpath("//*[@id=\"donor_name\"]"));
		fullname.sendKeys("ammu");
		
		
		/*WebElement pin=driver.findElement(By.xpath("//*[@id=\"select2-zipcode-container\"]/span"));
		pin.click();
		
	    WebElement pin1=driver.findElement(By.xpath("//*[@id=\"kt_app_body\"]/span/span/span[1]/input"));
		pin1.sendKeys("534456");
		
		
		WebElement gender=driver.findElement(By.xpath("//*[@id=\"select2-gender-container\"]/span"));
		JavascriptExecutor exe=(JavascriptExecutor)driver;
		exe.executeScript("document.querySelector(\"#select2-gender-container > span\").click()",gender);
		
		WebElement address = driver.findElement(By.xpath("//*[@id=\"permanent_address\"]"));
		address.sendKeys("SN Ladies Hostel");
		
		 WebElement nationality = driver.findElement(By.xpath("//*[@id=\"kt_create_account_form\"]/div[2]/div/div[6]/div/div[1]/span/span[1]/span"));
		nationality.click(); 
		
		WebElement country=driver.findElement(By.xpath("//*[@id=\"kt_app_body\"]/span/span/span[1]/input"));
		country.sendKeys("Japan");*/
		
		WebElement education = driver.findElement(By.xpath("//*[@id=\"education\"]"));
		education.sendKeys("BCA");
		
		WebElement email2 = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		email2.sendKeys("AMMU89@gmail.com");
		
		//Parent name
		WebElement parent = driver.findElement(By.xpath("//*[@id=\"guardian_name\"]"));
		parent.sendKeys("AKASH");
		
		WebElement mob2 = driver.findElement(By.xpath("//*[@id=\"secondary_phone\"]"));
		mob2.sendKeys("8563526341");
		
		//occupation
		WebElement occupation = driver.findElement(By.xpath("//*[@id=\"occupation\"]"));
		occupation.sendKeys("DOCTOR");
		
		//Toggle1
		WebElement married=driver.findElement(By.xpath("//*[@id=\"married\"]"));
		married.click();
		
		//Toggle2
		WebElement donation = driver.findElement(By.xpath("//*[@id=\"first_donation\"]"));
		donation.click();
		
		//DOB
		WebElement dob = driver.findElement(By.xpath("//*[@id=\"dob\"]"));
		dob.click();
		
		WebElement month=driver.findElement(By.xpath("//*[@id=\"kt_app_body\"]/div[4]/div[1]/span[1]"));
		month.click();
		
		WebElement date=driver.findElement(By.xpath("//*[@id=\"kt_app_body\"]/div[4]/div[2]/div/div[2]/div/span[4]"));
		date.click();
		
		// Donor time
		WebElement donortime = driver.findElement(By.xpath("//*[@id=\"donor_last_in_time\"]"));
		donortime.click();
		WebElement hour=driver.findElement(By.xpath("//*[@id=\"kt_app_body\"]/div[3]/div/div[1]/span[2]"));
		hour.click();
		
		WebElement button=driver.findElement(By.xpath("//*[@id=\"continue-btn\"]"));
		button.click();
		
		WebElement submit=driver.findElement(By.xpath("//*[@id=\"submit-btn\"]/span[1]"));
		submit.click();
		
		//Logout
		WebElement logoutimg = driver.findElement(By.xpath("//*[@id=\"kt_header_user_menu_toggle\"]/div[1]/div[2]/img"));
		logoutimg.click();
		
		WebElement logout = driver.findElement(By.xpath("//*[@id=\"logout-btn\"]"));
		logout.click();
		
		WebElement out = driver.findElement(By.xpath("//*[@id=\"kt_app_body\"]/div[5]/div/div[6]/button[1]"));
		out.click();
		
        //Login again
		WebElement email1 = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		email1.sendKeys("tester@bagmo.in");
		WebElement password1 = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		password1.sendKeys("Bagmotester321");
		WebElement login1 = driver.findElement(By.xpath("//*[@id=\"submit-btn\"]/span[1]"));
		login1.click();
		
		//Negative test
		//Performing login after logout when the values passed it showed "Donor is already Registered Today" hence Negative test is passed.
		
		
		

		
		
		
		
		
		
	}

}
