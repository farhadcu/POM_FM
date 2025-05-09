package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LogoutPage {
	protected WebDriver driver;

	// constructor
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public void logoutClick() throws InterruptedException {
		// Click the hamburger menu (☰) in the top-left corner.
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(3000);
		System.out.println("Burger Menu clicked");

		// Logout Button click
		driver.findElement(By.id("logout_sidebar_link")).click();
		System.out.println("Logout Button clicked");

		// Verify successful login by checking for the Products page url. (Assertion)
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/";
		Assert.assertEquals(currentUrl, expectedUrl, "Condition Mismatch");
		System.out.println("Verified that the user is redirected to the login page.");
		// assertion end

	}

}
