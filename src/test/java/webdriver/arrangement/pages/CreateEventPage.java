package webdriver.arrangement.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateEventPage {
	private final WebDriver driver;
	private static CreateEventPage page;
	private static String url = "http://localhost:8082/DataartProject/create-arrangement.html";

	public CreateEventPage(WebDriver driver) {
		this.driver = driver;
		// Check that we're on the right page.
		if (!"Create Event".equals(driver.getTitle())) {
			// Alternatively, we could navigate to the login page, perhaps
			// logging out first
			throw new IllegalStateException("This is not the Create Event page");
		}
	}

	public static CreateEventPage getInstance(WebDriver driver) {
		driver.get(url);
		if (page == null)
			return new CreateEventPage(driver);
		return page;
	}

	By nameLocator = By.id("name");
	By dateLocator = By.id("date");
	By timeLocator = By.id("time");
	By submitLocator = By.id("submitButton");

	public CreateEventPage typeName(String name) {
		driver.findElement(nameLocator).sendKeys(name);
		return this;
	}

	public CreateEventPage typeDate(String date) {
		driver.findElement(dateLocator).sendKeys(date);
		return this;
	}

	public CreateEventPage typeTime(String time) {
		driver.findElement(timeLocator).sendKeys(time);
		return this;
	}

	public EventsPage submitEvent() {
		driver.findElement(submitLocator).submit();
		return new EventsPage(driver);
	}

	public CreateEventPage submitEventExpectingFailure() {
		driver.findElement(submitLocator).submit();
		return new CreateEventPage(driver);
	}

	public EventsPage createEvent(String name, String date, String time) {
		typeName(name);
		typeDate(date);
		typeTime(time);
		return submitEvent();
	}
}
