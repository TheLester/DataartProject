package webdriver.arrangement.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditEventPage {
	private final WebDriver driver;
	private static EditEventPage page;
	private static String url = "http://localhost:8082/DataartProject/edit-arrangement.html";

	public EditEventPage(WebDriver driver) {
		this.driver = driver;
		// Check that we're on the right page.
		if (!"Edit Event".equals(driver.getTitle())) {
			// Alternatively, we could navigate to the login page, perhaps
			// logging out first
			throw new IllegalStateException("This is not the Edit Event page");
		}
	}

	public static EditEventPage getInstance(WebDriver driver) {
		driver.get(url);
		if (page == null)
			return new EditEventPage(driver);
		return page;
	}

	By selectorLocator = By.name("selector");
	By nameLocator = By.id("name");
	By dateLocator = By.id("date");
	By timeLocator = By.id("time");
	By submitLocator = By.id("submitDemo");

	public EditEventPage selectName(String name) {
		driver.findElement(nameLocator).sendKeys(name);
		return this;
	}

	public EditEventPage typeName(String name) {
		driver.findElement(nameLocator).clear();
		driver.findElement(nameLocator).sendKeys(name);
		return this;
	}

	public EditEventPage typeDate(String date) {
		driver.findElement(dateLocator).clear();
		driver.findElement(dateLocator).sendKeys(date);
		return this;
	}

	public EditEventPage typeTime(String time) {
		driver.findElement(timeLocator).clear();
		driver.findElement(timeLocator).sendKeys(time);
		return this;
	}

	public EventsPage submitEvent() {
		driver.findElement(submitLocator).submit();
		return new EventsPage(driver);
	}

	public EditEventPage submitEventExpectingFailure() {
		driver.findElement(submitLocator).submit();
		return new EditEventPage(driver);
	}

	public EventsPage editEvent(String oldname, String newname, String date,
			String time) {
		selectName(oldname);
		typeName(newname);
		typeDate(date);
		typeTime(time);
		submitEvent();
		return new EventsPage(driver);
	}
	
}
