package advancedSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkBox {

	public static void main(String[] args) {
		
		WebDriver d;
		   WebDriverManager.chromedriver().setup();		
			d = new ChromeDriver();
			d.get("https://the-internet.herokuapp.com/checkboxes");
			
			d.manage().window().maximize(); // maximize or minimized is by default
			d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			
			WebElement chek1 = d.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
			WebElement chek2 = d.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
			
			
			if(!chek1.isSelected()) {
				chek1.click();
			}
			else {
				System.out.println("Chek box is already selected.");
			}
			
			if(chek2.isSelected()) {
				chek2.click();
			}

	}

}
