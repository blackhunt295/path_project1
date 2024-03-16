package advancedSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropDown {
   public static void main(String[] args) {
	   
	   WebDriver d;
	   WebDriverManager.chromedriver().setup();		
		d = new ChromeDriver();
		d.get("https://the-internet.herokuapp.com/dropdown");
		
		d.manage().window().maximize(); // maximize or minimized is by default
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement dropDown = d.findElement(By.xpath("//select[@id='dropdown']"));
		
		Select s= new Select(dropDown);
		s.selectByIndex(0);
		s.selectByValue("2");
		s.selectByVisibleText("Option 1");
//		s.deselectByIndex(1);
		
		List<WebElement> myElements = s.getOptions();
		
		for (WebElement str : myElements) {
			System.out.println(str);
		}
		
   }
}
