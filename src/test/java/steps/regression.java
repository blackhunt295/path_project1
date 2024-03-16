package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class regression {
	
	WebDriver d;
	@Given("i am on the target homepage")
	public void i_am_on_the_target_homepage() {
	    
		WebDriverManager.chromedriver().setup();		
		d = new ChromeDriver();
		d.get("https://www.target.com");
		d.manage().window().maximize(); // maximize or minimized is by default
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}
