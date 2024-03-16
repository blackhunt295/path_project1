package advancedSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mouseHover {

	public static void main(String[] args) {
		
		WebDriver d;
		WebDriverManager.chromedriver().setup();		
		d = new ChromeDriver();
		d.get("https://the-internet.herokuapp.com/hovers");
		d.manage().window().maximize(); // maximize or minimized is by default
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement img1 = d.findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));
		WebElement text1 = d.findElement(By.xpath("(//div[@class='figcaption'])[1]/h5"));
		WebElement link1 = d.findElement(By.xpath("(//div[@class='figcaption'])[1]/a"));
		
		Actions act = new Actions(d);
		act.moveToElement(img1).build().perform();
		
		Assert.assertEquals(text1.getText(), "name: user1");
		Assert.assertTrue(link1.isEnabled());

	}

}
