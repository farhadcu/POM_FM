package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckoutOverviewPage {
	protected WebDriver driver;

	// constructor
	public CheckoutOverviewPage(WebDriver driver) {
		this.driver = driver;

	}

	// verify the correct item appears in the summary (Assertion)
	public void verifyAddedProduct() {
		WebElement addedProduct = driver.findElement(By.id("item_4_title_link"));
		String actAddedProductName = addedProduct.getText();
		System.out.println(actAddedProductName);
		String expAddedProductName = "Sauce Labs Backpack";
		Assert.assertEquals(actAddedProductName, expAddedProductName, "Condition Mismatch");
		System.out.println("Verifed that the correct item appears in the summary");
	}

	// checkout finish order click
	public void checkoutOverviewFinish() {
		driver.findElement(By.id("finish")).click();
		System.out.println("Now we are in Checkout Complete Page");
	}
}
