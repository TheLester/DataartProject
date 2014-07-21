package webdriver.arrangement.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteEventPage {
	private final WebDriver driver;
	private static DeleteEventPage page;
	private static String url = "http://localhost:8082/DataartProject/delete-arrangement.html";

	public DeleteEventPage(WebDriver driver) {
		this.driver = driver;
		// Check that we're on the right page.
		if (!"Delete Event".equals(driver.getTitle())) {
			// Alternatively, we could navigate to the login page, perhaps
			// logging out first
			throw new IllegalStateException("This is not the Delete Event page");
		}
	}

	public static DeleteEventPage getInstance(WebDriver driver) {
		driver.get(url);
		if (page == null)
			return new DeleteEventPage(driver);
		return page;
	}

	By nameLocator = By.name("selector");
	By submitLocator = By.id("submitDemo");

	public DeleteEventPage selectName(String name) {
		driver.findElement(nameLocator).sendKeys(name);
		return this;
	}

	public DeleteEventPage submitEventExpectingFailure() {
		driver.findElement(submitLocator).submit();
		return new DeleteEventPage(driver);
	}

	public EventsPage submitEvent() {
		driver.findElement(submitLocator).submit();
		return new EventsPage(driver);
	}

	public EventsPage deleteEvent(String name) {
		selectName(name);
		submitEvent();
		return new EventsPage(driver);
	}
}
