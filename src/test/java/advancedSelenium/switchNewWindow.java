package advancedSelenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class switchNewWindow {
	public static void main(String[] args) {
		
		WebDriver d;
		   WebDriverManager.chromedriver().setup();		
			d = new ChromeDriver();
			d.get("https://the-internet.herokuapp.com/windows");
			
			d.manage().window().maximize(); // maximize or minimized is by default
			d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			WebElement clickHereButton = d.findElement(By.linkText("Click Here"));
			clickHereButton.click();
			
			String mainWindow = d.getWindowHandle();			
			Set<String> windows = d.getWindowHandles();
			
			Iterator<String> i = windows.iterator();
			while(i.hasNext()) {
				String childWindow = i.next();
				if (!mainWindow.equalsIgnoreCase(childWindow)) {
					d.switchTo().window(childWindow);
				}
			}
			
			System.out.println(mainWindow);
			System.out.println(d.getTitle());

	}

}
