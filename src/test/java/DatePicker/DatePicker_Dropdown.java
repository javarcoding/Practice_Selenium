package DatePicker;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker_Dropdown {

	public static void main(String[] args)
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		
		driver.findElement(By.id("dob")).click();
		
		//Selecting month
		WebElement monthele=driver.findElement(By.xpath("//select[@class=\"ui-datepicker-month\"]"));
		Select month_drp=new Select(monthele);
		month_drp.selectByVisibleText("Feb");
		
		//Selecting Year
		WebElement yearele=driver.findElement(By.xpath("//select[@class=\"ui-datepicker-year\"]"));
		Select year_drp=new Select(yearele);
		year_drp.selectByVisibleText("2020");
		
		//Selecting date
		String date="9";
		List<WebElement> alldates=driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//td"));
		for (WebElement ele:alldates) 
		{
			String dt=ele.getText();
			
			if (dt.equalsIgnoreCase(date)) 
			{
				ele.click();
				break;
			}
			
		}
		
		
		

	}

}
