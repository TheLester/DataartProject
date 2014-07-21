package webdriver.Tests;

import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.sql.Delete;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
	Connection conn;

	public EventsTest() {
		conn = setUpDB();
	}

	@Before
	public void doBefore() {
		/* set path to chrome driver */
	//	System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
		driver = new FirefoxDriver();
		cleanDB();
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
		Thread.sleep(5000);
		event_page= delete_page.submitEvent();
		assertEquals(false, event_page.checkForEvent("New Event", "1992-05-24", "18:45"));
	}

	@Test
	public void testEdit() {
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
		event_page=edit_page.submitEvent();
		assertEquals(true, event_page.checkForEvent("Changed Name", "2014-03-24", "05:10"));	
		
	}

	private Connection setUpDB() {		
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost/LOGDB";		
		String USER = "root";
		String PASS = "123";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}		
		try {
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return conn;
	}

	private void cleanDB() {		
		Statement stmt = null;
		try {
			stmt = (Statement) conn.createStatement();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		String sql = "DELETE FROM Arrangements";
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
}
