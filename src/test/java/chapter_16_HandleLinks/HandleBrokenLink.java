package chapter_16_HandleLinks;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class HandleBrokenLink {

	public static void main(String[] args) throws IOException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		int brokenLinks=0;
		
		for (WebElement element:links) 
		{
			String url=element.getAttribute("href");
			if (url==null || url.isEmpty()) 
			{
				System.out.println("URL is empty");
				continue;
			}
			URL link=new URL(url);
			try 
			{
				HttpsURLConnection httpConn=(HttpsURLConnection) link.openConnection();
				httpConn.connect();
				if (httpConn.getResponseCode()>=400) 
				{
					System.out.println(httpConn.getResponseCode()+url+ " is"+" Broken link");
					brokenLinks++;
				}
				else 
				{
					System.out.println(httpConn.getResponseCode()+ url+" is"+" Valid link");
				}
			}
			catch (Exception e) 
			{


			}
			
			
			
		}
		System.out.println("Number of broken Links :"+brokenLinks);
		
		
	}

}

