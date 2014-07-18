package webdriver.arrangement;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestEventsPage {
	
	WebDriver driver;
	
	@Before
	public void doBefore() {
		 driver = new FirefoxDriver();
	}

	// http://stackoverflow.com/questions/17972359/selenium-webdriver-with-java-element-not-found-in-the-cache-perhaps-the-page
	@Test
	public void testCreatingImage() throws InterruptedException {	 
	  driver.get("http://localhost:8080/DataartProject/create-arrangement.html");
	  Thread.sleep(5000);  // Let the user actually see something!
	  WebElement Name = driver.findElement(By.name("name"));
	  WebElement Date = driver.findElement(By.name("date"));
	  WebElement Time = driver.findElement(By.name("time"));
	  
	  Name.sendKeys("EventName");
	  Date.sendKeys("2014-07-26");
	  Time.sendKeys("0.3:43");
	  
	  Name.submit();
	  Date.submit();
	  Time.submit();
	  driver.findElement(By.id("submitDemo")).click();
	  Thread.sleep(5000);  // Let the user actually see something!
	  driver.quit();
	}

}
