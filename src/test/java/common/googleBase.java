package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class googleBase {

	public WebDriver d; // d is our public web driver abstract method.
	
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();		
		d = new ChromeDriver();
		d.get("https://www.google.com");
		d.manage().window().maximize(); // maximize or minimized is by default
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void closeOne() { 
		d.close();
	}
	
	public void closeAll() {
		d.quit();
	}
	

}
