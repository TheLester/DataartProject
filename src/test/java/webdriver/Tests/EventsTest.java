package webdriver.Tests;

import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.hibernate.sql.Delete;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import service.TestUtilities;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import webdriver.arrangement.pages.CreateEventPage;
import webdriver.arrangement.pages.DeleteEventPage;
import webdriver.arrangement.pages.EditEventPage;
import webdriver.arrangement.pages.EventsPage;

/*
 * This class contains a set of tests for managing events
 */

public class EventsTest {

	WebDriver driver;
	TestUtilities utilities=TestUtilities.getInstance();
	
	@Before
	public void doBefore() {
		/* set path to chrome driver */
	//	System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
		driver = new FirefoxDriver();
		utilities.cleanDB();
	}

	@Test
	public void testCreate() throws InterruptedException {
		CreateEventPage create_page = CreateEventPage.getInstance(driver);
		create_page.typeName("New Event");
		create_page.typeDate("1992-05-24");
		create_page.typeTime("18:45");
		//Thread.sleep(5000);
		EventsPage event_page = create_page.submitEvent();
		assertEquals(true, event_page.checkForEvent("New Event", "1992-05-24", "18:45"));		
	}

	@Test
	public void testDelete() throws InterruptedException {
		CreateEventPage create_page = CreateEventPage.getInstance(driver);
		create_page.typeName("New Event");
		create_page.typeDate("1992-05-24");
		create_page.typeTime("18:45");
		//Thread.sleep(5000);
		EventsPage event_page = create_page.submitEvent();
		DeleteEventPage delete_page=event_page.goToDeleteEventPage();
		delete_page.selectName("New Event");
		//Thread.sleep(5000);
		event_page= delete_page.submitEvent();
		assertEquals(false, event_page.checkForEvent("New Event", "1992-05-24", "18:45"));
	}

	@Test
	public void testEdit() throws InterruptedException {
		CreateEventPage create_page = CreateEventPage.getInstance(driver);
		create_page.typeName("New Event");
		create_page.typeDate("1992-05-24");
		create_page.typeTime("18:45");		
		EventsPage event_page = create_page.submitEvent();
		EditEventPage edit_page=event_page.goToEditEventPage();
		edit_page.selectName("New Event");
		edit_page.typeName("Changed Name");
		edit_page.typeDate("2014-03-24");
		edit_page.typeTime("05:10");
		//Thread.sleep(5000);
		event_page=edit_page.submitEvent();
		assertEquals(true, event_page.checkForEvent("Changed Name", "2014-03-24", "05:10"));	
		
	}
}
