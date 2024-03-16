package steps;

import org.testng.Assert;
import common.googleBase;
/*webdriver is an interface which exists in a selineum  library.
  wedrivermangaer its self a library which gives us differant browser.
  
  selineum people implemented webdriver interface(abstruct class like clik()) into a remote web driver class.
  And remotewebdriver class will extend to chromedriver class or firfoxdriverclass or sufaridriver class.
  
  click() method from webdriver interface  might not work for firefox driver or a fifferant browser class 
  so we have to over write the click() method in remotewebDriver class.  
 */
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.googleHomePage;


public class searchProducts extends googleBase{
	
	googleHomePage gp;

	@Given("i am on google homepage")
	public void i_am_on_google_homepage() {
	    launchBrowser();		
	}

	@When("i enter the {string} in the search bar")
	public void i_enter_the_in_the_search_bar(String string) {
	    gp= new googleHomePage(d);
	    gp.enterProductNameInSearchBar(string);
	}

	@When("i click on the search button")
	public void i_click_on_the_search_button() {
		gp.clickOnSearchButton();
	}

	@Then("i can see the search result successfully")
	public void i_can_see_the_search_result_successfully() {
	    Assert.assertTrue(gp.varifySearchResult());
	    closeAll();
/*	    
	    Assert.assertEquals("Expected",searchResult.getText());
	    Assert.assertNotEquals("Expected",searchResult.getText());
	    Assert.assertFalse(searchResult.isDisplayed());
	    Assert.assertNotNull(searchResult);
*/	    
	}

}
