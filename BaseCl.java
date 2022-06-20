package Week5day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

  public class BaseCl {
	public ChromeDriver driver;
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void preCondition(String url,String name, String pwd) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys(name);
	    driver.findElement(By.id("password")).sendKeys(pwd);
	    Thread.sleep(10000);
	    driver.findElement(By.className("decorativeSubmit")).click();
	    driver.findElement(By.linkText("CRM/SFA")).click();
	}
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
	}
