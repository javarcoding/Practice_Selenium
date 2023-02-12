package chapter_16_HandleLinks;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleLinks {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C://Users/adsul/Drivers/chromedriver_win32/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//linkText() method and PartialLinkText() method
		driver.findElement(By.linkText("Today's Deals")).click();
		//driver.findElement(By.partialLinkText("Deals")).click();
		
		driver.findElement(By.partialLinkText("Don't Change")).click();
		//How to capture all the links
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Number of Links ::"+links.size());
		
		//Normal for Loop (To read link from links)
		
		for (int i=0; i<=links.size(); i++) 
		{
			System.out.println(links.get(i).getText());
			System.out.println(links.get(i).getAttribute("href"));
			
		}
		
		//for-each loop
		
		for (WebElement link:links) 
		{
			System.out.println(link.getText());
			System.out.println(link.getAttribute("href"));
			
		}
	}

}
