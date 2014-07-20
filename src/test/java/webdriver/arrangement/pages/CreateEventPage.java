package webdriver.arrangement.pages;

import org.openqa.selenium.WebDriver;

public class CreateEventPage {
	  private final WebDriver driver;
	  private static CreateEventPage page;
	  private static String url = "http://localhost:8082/DataartProject/create-arrangement.html";
	  
	  public CreateEventPage(WebDriver driver) {
	        this.driver = driver;
	        // Check that we're on the right page.
	        if (!"Create Event".equals(driver.getTitle())) {
	            // Alternatively, we could navigate to the login page, perhaps logging out first
	            throw new IllegalStateException("This is not the Create Event page");
	        }
	    }
	  
	  public static CreateEventPage getInstance(WebDriver driver) {
		  driver.get(url);
		  if (page==null)
			  return new CreateEventPage(driver);
		  return page;
	  }
}
