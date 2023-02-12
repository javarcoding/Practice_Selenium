package first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDown {

	public static void main(String[] args) 
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://www.opencart.com/index.php?route=account/register");
	
	WebElement countrydrpEle=driver.findElement(By.id("input-country"));
	Select countryDrp=new Select(countrydrpEle);
	
	countryDrp.selectByVisibleText("Brazil");
	
	
	

	}

}
