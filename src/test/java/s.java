
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class s {

	public static void main(String[] args)
	{
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://admin-demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		
		WebElement uname=driver.findElement(By.id("Email"));
		uname.clear();
		uname.sendKeys("admin@yourstore.com");
		
		WebElement pass=driver.findElement(By.id("Password"));
		pass.clear();
		pass.sendKeys("admin");
		
		driver.findElement(By.xpath("//button[text()=\"Log in\"]")).click();
		System.out.println(driver.getTitle());
		
		
			
		
			
		
	}

}
