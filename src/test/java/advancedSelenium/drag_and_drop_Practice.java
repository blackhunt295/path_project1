package advancedSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class drag_and_drop_Practice {

	public static void main(String[] args) {
		
		 WebDriver d; 		
		 WebDriverManager.chromedriver().setup();		
			d = new ChromeDriver();
			d.get("https://the-internet.herokuapp.com/drag_and_drop");
			d.manage().window().maximize(); // maximize or minimized is by default
			d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			WebElement colA = d.findElement(By.xpath("//div[@id='column-a']"));
			WebElement colb = d.findElement(By.xpath("//div[@id='column-b']"));
			
			Actions act = new Actions(d);
			act.dragAndDrop(colA, colb).build().perform();
			act.dragAndDropBy(colb, 100, 200).build().perform();
		}

	

}
