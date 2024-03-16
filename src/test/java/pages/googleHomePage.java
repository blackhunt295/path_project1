package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class googleHomePage {	
    WebDriver p;  
    
	public googleHomePage(WebDriver dr) {		
		p=dr;
		PageFactory.initElements(p, this);		
	}	
	
	@FindBy(className = "gLFyf")
	WebElement searchBar;
	
	@FindBy(name = "btnK")
	WebElement searchButton;
	
	@FindBy(id= "result-stats")
	WebElement searchResult;
	
	public void enterProductNameInSearchBar(String product) {
		searchBar.sendKeys(product);
	}
	public void clickOnSearchButton() {
		searchButton.submit();
	}
	public  boolean varifySearchResult() {
		return searchResult.isDisplayed();
	}
	
	
	
	
}
