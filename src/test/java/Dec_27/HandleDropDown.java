package Dec_27;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDown {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.opencart.com/index.php?route=account/register");
		
		WebElement drpcountryele=driver.findElement(By.id("input-country"));
		
		Select contrydrp=new Select(drpcountryele);
		
		contrydrp.selectByVisibleText("Bahamas");
		Thread.sleep(3000);
		
		contrydrp.selectByValue("36");
		Thread.sleep(3000);
		
		contrydrp.selectByIndex(58);
		
		//Without using select class method 
		List<WebElement> allOptions=contrydrp.getOptions();
		
		for ( WebElement option:allOptions) {
			if (option.getText().equals("Haiti")) {
				option.click();
				break;
			}
			
			
		}
		
	}

}
