package webdriver.arrangement.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EventsPage {

	private final WebDriver driver;
	private static EventsPage page;
	private static String url = "http://localhost:8082/DataartProject/arrangements.html";

	public EventsPage(WebDriver driver) {
		this.driver = driver;
		// Check that we're on the right page.
		if (!"Events".equals(driver.getTitle())) {
			// Alternatively, we could navigate to the login page, perhaps
			// logging out first
			throw new IllegalStateException("This is not the Events page");
		}
	}

	public static EventsPage getInstance(WebDriver driver) {
		driver.get(url);
		if (page == null)
			return new EventsPage(driver);
		return page;
	}

	By createLocator = By.id("create");
	By deleteLocator = By.id("delete");
	By editLocator = By.id("edit");
	By tableLocator = By.id("events");

	public void getListOfEvents() {
		// Grab the table
		WebElement table = driver.findElement(tableLocator);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		Iterator<WebElement> i = rows.iterator();
		System.out.println("Table has following content");
		while (i.hasNext()) {
			WebElement row = i.next();
			List<WebElement> columns = row.findElements(By.tagName("td"));
			Iterator<WebElement> j = columns.iterator();
			while (j.hasNext()) {
				WebElement column = j.next();
				System.out.print(column.getText());
				System.out.print("    |  ");
			}
			System.out.println("");
		}
		System.out.println("Table content is printed");
	}

	public CreateEventPage goToCreateEventPage() {
		driver.findElement(createLocator).click();
		return (new CreateEventPage(driver));
	}

	public DeleteEventPage goToDeleteEventPage() {
		driver.findElement(deleteLocator).click();
		return (new DeleteEventPage(driver));
	}

	public EditEventPage goToEditEventPage() {
		driver.findElement(editLocator).click();
		return (new EditEventPage(driver));
	}

	public boolean checkForEvent(String name, String date, String time) {
		WebElement table = driver.findElement(tableLocator);
		String content = table.getText();
		System.out.println(content.contains(name));
		System.out.println(content.contains(date));
		System.out.println(content);
		
		return content.contains(name) && content.contains(date)
				&& content.contains(time);
	}
}
