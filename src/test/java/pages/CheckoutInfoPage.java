package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage {
	protected WebDriver driver;

	// constructor
	public CheckoutInfoPage(WebDriver driver) {
		this.driver = driver;
	}

	// enter first name
	public void enterFirstName(String firstName) {
		driver.findElement(By.id("first-name")).sendKeys(firstName);
		System.out.println("First Name set completed");
	}

	// enter last name
	public void enterLastName(String lastName) {
		driver.findElement(By.id("last-name")).sendKeys(lastName);
		System.out.println("Last Name set completed");
	}

	// enter postal code
	public void enterPostalCode(String zipCode) throws InterruptedException {
		driver.findElement(By.id("postal-code")).sendKeys(zipCode);
		System.out.println("Zip Code set completed");
		Thread.sleep(3000);
	}

	// click continue function
	public void clickContinue() {
		driver.findElement(By.id("continue")).click();
		System.out.println("Click Continue completed");

	}
}
