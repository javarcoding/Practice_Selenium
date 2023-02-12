package first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindows {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebElement username=driver.findElement(By.xpath("//input[@name=\"username\"]"));
		
		username.sendKeys("Admin");
		WebElement password=driver.findElement(By.xpath("//input[@name=\"password\"]"));
		
		password.sendKeys("admin");
		
		
		
	}

}
