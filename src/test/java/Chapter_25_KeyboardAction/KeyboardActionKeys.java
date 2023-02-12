package Chapter_25_KeyboardAction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActionKeys {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://text-compare.com");
		driver.manage().window().maximize();
		
		WebElement input1=driver.findElement(By.xpath("textarea[@id=\"inputText1\"]"));
		WebElement input2=driver.findElement(By.xpath("textarea[@id=\"inputText2\"]"));
		
		input1.sendKeys("Welcome to Selenium");
		
		Actions act=new Actions(driver);
		
		//CTRL + A
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//CTRL + C
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//TAB -Shift to input2 box
		act.sendKeys(Keys.TAB);
		act.perform();
		
		//CTRL + V
		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//Compare text
		if (input1.getAttribute("value").equals(input2.getAttribute("value"))) 
		{
			System.out.println("Text copied");
		}
		else
		{
			System.out.println("Text Not copied");
		}
		
		
		
	}

}
