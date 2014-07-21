package webdriver.Tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.dataart.project.repositories.Arrangement;

import webdriver.arrangement.pages.EventsPage;

public class EventsPageTest {
	
	WebDriver driver;
	
	@Before
	public void doBefore() {
		// driver = new FirefoxDriver();
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

	  driver.findElement(By.id("submitButton")).submit();
	  //Thread.sleep(2000);  // Let the user actually see something!
		}
	  driver.quit();
	}

	@Ignore
	public void testTablePrint() {
		EventsPage page = EventsPage.getInstance(driver);
		page.getListOfEvents();
		page.goToCreateEventPage();
	}
	
	@Ignore
	public void testGoogleSearch() throws InterruptedException {
	  // Optional, if not specified, WebDriver will search your path for chromedriver.
	 System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");

	  WebDriver driver = new ChromeDriver();
	  driver.get("http://www.google.com/xhtml");
	  Thread.sleep(5000);  // Let the user actually see something!
	  WebElement searchBox = driver.findElement(By.name("q"));
	  searchBox.sendKeys("ChromeDriver");
	  searchBox.submit();
	  Thread.sleep(5000);  // Let the user actually see something!
	  driver.quit();
	}
	
	@Test
	public void testDateParsing() {
		String date="2014-05-19";
		String time="04:54";
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			Date dateDate = (Date)format.parse(date + " " + time);
			System.out.println(dateDate.getDay());
			System.out.println(dateDate.getMonth());
			System.out.println(dateDate.getYear());			
			System.out.println(dateDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
