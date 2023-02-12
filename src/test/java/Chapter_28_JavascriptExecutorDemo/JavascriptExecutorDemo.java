package Chapter_28_JavascriptExecutorDemo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutorDemo 
{

	public static void main(String[] args) throws IOException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com");
		driver.manage().window().maximize();
		
		//Syntax
		//JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executescript(script, args);
		
		//flash:- 
		 WebElement logo1=driver.findElement(By.xpath("//img[@alt=\"nopCommerce demo store\"]"));
		JavaScriptUntil.flash(logo1, driver);
		/*
		//Drawing border & take screenshot
		WebElement logo=driver.findElement(By.xpath("//img[@alt=\"nopCommerce demo store\"]"));
		JavaScriptUntil.drawBorder(logo, driver);
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File(".//screenshots/logo.png");
		FileUtils.copyFile(src, trg);
		
		//Getting title of the page
		String title=JavaScriptUntil.getTitleByJS(driver);
		System.out.println(title);
		*/
		//Click Action
		WebElement reglink=driver.findElement(By.xpath("//a[@class=\"ico-register\"]"));
		JavaScriptUntil.clickElementByJS(reglink, driver);
		
		//Generate Alert
		JavaScriptUntil.generateAlert(driver, "This is my Alert...");
		
		//Refreshing the page
		JavaScriptUntil.refreshBrowserByJS(driver);
		
		//Scrolling down page
		JavaScriptUntil.scrollPageDown(driver);
		
		//Scroll up page
		JavaScriptUntil.scrollPageUp(driver);
		/*
		//zoom page
		JavaScriptUntil.zoomPageByJS(driver);
		
		*/
	}

}
