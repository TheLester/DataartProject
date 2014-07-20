package webdriver.Tests;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import webdriver.arrangement.pages.EvenstPage;



public class EventsPageTest {
	
	WebDriver driver;
	
	@Before
	public void doBefore() {
		 driver = new FirefoxDriver();
	}

	// http://stackoverflow.com/questions/17972359/selenium-webdriver-with-java-element-not-found-in-the-cache-perhaps-the-page
	@Ignore
	public void testCreatingImage() throws InterruptedException {	
		for (int i=0; i<11;i++){
	  driver.get("http://localhost:8082/DataartProject/create-arrangement.html");
	  //Thread.sleep(5000);  // Let the user actually see something!
	  WebElement Name = driver.findElement(By.name("name"));
	  WebElement Date = driver.findElement(By.name("date"));
	  WebElement Time = driver.findElement(By.name("time"));
	  
	  Name.sendKeys("EventName_"+i);
	  Date.sendKeys("2014-07-26");
	  Time.sendKeys("03:43");

	  driver.findElement(By.id("submitDemo")).submit();
	  Thread.sleep(2000);  // Let the user actually see something!
		}
	//  driver.quit();
	}

	@Test
	public void testTablePrint() {
		EvenstPage page = EvenstPage.getInstance(driver);
		page.getListOfEvents();
		page.goToCreateEventPage();
	}
}
