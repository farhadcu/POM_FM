package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartPage {
	protected WebDriver driver;

	// constructor
	public CartPage(WebDriver driver) {
		this.driver = driver;

	}

	public void verifyCartProducts() {
		// Verify that both products are present in the cart page (Assertion)
		WebElement firstProduct = driver.findElement(By.id("item_4_title_link"));
		String actFirstProduct = firstProduct.getText();
		System.out.println(actFirstProduct);
		String expFirstProduct = "Sauce Labs Backpack";
		Assert.assertEquals(actFirstProduct, expFirstProduct, "Condition Mismatch");

		WebElement secondProduct = driver.findElement(By.id("item_0_title_link"));
		String actSecondProduct = secondProduct.getText();
		System.out.println(actSecondProduct);
		String expSecondProduct = "Sauce Labs Bike Light";
		Assert.assertEquals(actSecondProduct, expSecondProduct, "Condition Mismatch");

		System.out.println("Verified that both products are present in the cart");
		// assertion end

		// continue shopping click
		driver.findElement(By.id("continue-shopping")).click();
	}

	public void checkoutProduct() throws InterruptedException {
		// proceed to checkout
		driver.findElement(By.id("checkout")).click();
		System.out.println("proceeded to checkout");
	}

}
