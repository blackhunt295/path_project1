package advancedSelenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class switchWindowByTitle {
	public static void main(String[] args) {
		
		   WebDriver d;
		   WebDriverManager.chromedriver().setup();		
			d = new ChromeDriver();
			d.get("https://the-internet.herokuapp.com/windows");
			
			d.manage().window().maximize(); // maximize or minimized is by default
			d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			WebElement clickHereButton = d.findElement(By.linkText("Click Here"));
			clickHereButton.click();
			
			windowByTitle(d,"New Window");
			System.out.println(d.getTitle());

	}
	
	public static void windowByTitle(WebDriver driver, String title) {
		
		String mainWindow =driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		
		for(String s : windows){
			if(!driver.switchTo().window(s).getTitle().equals(title)) {
				driver.switchTo().window(mainWindow);
			}
		}
	}

	
	
}
