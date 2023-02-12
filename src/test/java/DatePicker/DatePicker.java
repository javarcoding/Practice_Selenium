package DatePicker;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.redbus.in");
		
		String year="2023";
		String month="feb";
		String date="9";
		
		driver.findElement(By.id("onward_cal")).click();
		
		while (true) 
		{
			String monthyear=driver.findElement(By.xpath("//*[@class=\"monthTitle\"]")).getText();
			
			String arr[]=monthyear.split(" ");
			String mon=arr[0];
			String yr=arr[1];
			
			if (mon.equalsIgnoreCase(month)&& yr.equalsIgnoreCase(year)) 
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("//*[@class=\"next\"]")).click();
			}
			
		}
		
		List<WebElement> alldates=driver.findElements(By.xpath("//table[@class=\"rb-monthTable first last\"]//td"));
		
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
