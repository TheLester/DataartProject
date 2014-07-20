package webdriver.arrangement.pages;

import org.openqa.selenium.WebDriver;

public class EditEventPage {
	  private final WebDriver driver;
	  private static EditEventPage page;
	  private static String url = "http://localhost:8082/DataartProject/edit-arrangement.html";
	  
	  public EditEventPage(WebDriver driver) {
	        this.driver = driver;
	        // Check that we're on the right page.
	        if (!"Edit Event".equals(driver.getTitle())) {
	            // Alternatively, we could navigate to the login page, perhaps logging out first
	            throw new IllegalStateException("This is not the Edit Event page");
	        }
	    }
	  
	  public static EditEventPage getInstance(WebDriver driver) {
		  driver.get(url);
		  if (page==null)
			  return new EditEventPage(driver);
		  return page;
	  }
	
}
