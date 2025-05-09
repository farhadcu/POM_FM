package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductPage {
	protected WebDriver driver;

	// constructor
	public ProductPage(WebDriver driver) {
		this.driver = driver;

	}

	// Verify by checking for the Products page. (Assertion)
	public void verifyProductPage() {
		WebElement title = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
		String actTitle = title.getText();
		String expTitle = "Products";
		Assert.assertEquals(actTitle, expTitle, "Condition Mismatch");
		System.out.println("Verified that successful login by checking for the Products page");
	}

	public void BuyFirstTwoProducts() throws InterruptedException {

		// Add the first two products to the cart by clicking Add to cart.
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		System.out.println("first two products added to cart");

		Thread.sleep(4000);
		// Click the cart icon to view the cart.
		driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
		Thread.sleep(5000);

	}

	public void addRemoveProducts() throws InterruptedException {

		// Add and remove items two times.
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("remove-sauce-labs-fleece-jacket")).click();
		System.out.println("Added and removed two items two times.");

		// Verify cart badge count updates correctly (Assertion)
		WebElement cartIconBtn = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a"));
		String actCartBadgeCount = cartIconBtn.getText();
		System.out.println(actCartBadgeCount);
		String expCartBadgeCount = "2";
		Assert.assertEquals(actCartBadgeCount, expCartBadgeCount, "Condition Mismatch");
		System.out.println("Verified that cart badge count updates correctly");
		// assertion end

		Thread.sleep(5000);

	}

	public void addSingleProduct() throws InterruptedException {
		// Add a product to the cart.
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		// Click the cart icon to view the cart.
		driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
		Thread.sleep(5000);
	}

//	Used the Sort by drop down to sort products functions
	public void priceLowToHigh() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select"));
		Select select = new Select(dropdown);
		select.selectByIndex(2);
		System.out.println("Dorpdown Price (low to high) Completed");

		// Verify that the products are displayed in the correct order based on the selected option (Assertion)
		List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));
		String actualProductName = productNames.get(0).getText(); // first product name selected
		System.out.println(actualProductName);
		String expProductName = "Sauce Labs Onesie";
		Assert.assertEquals(actualProductName, expProductName, "Condition Mismatch");
		System.out.println("Verified that the products are displayed in the correct order based on: Price (low to high)");
		// assertion end
		Thread.sleep(5000);
	}

	public void priceHighToLow() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select"));
		Select select = new Select(dropdown);
		select.selectByIndex(3);
		System.out.println("Dorpdown Price (high to low) Completed");

		// Verify that the products are displayed in the correct order based on the selected option (Assertion)
		List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));
		String actualProductName = productNames.get(0).getText(); // first product name selected
		System.out.println(actualProductName);
		String expProductName = "Sauce Labs Fleece Jacket";
		Assert.assertEquals(actualProductName, expProductName, "Condition Mismatch");
		System.out.println("Verified that the products are displayed in the correct order based on: Price (high to low)");
		// assertion end
		Thread.sleep(5000);
	}

	public void nameAToZ() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select"));
		Select select = new Select(dropdown);
		select.selectByIndex(0);
		System.out.println("Dorpdown Name (A to Z) Completed");

		// Verify that the products are displayed in the correct order based on the selected option (Assertion)
		List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));
		String actualProductName = productNames.get(0).getText(); // first product name selected
		System.out.println(actualProductName);
		String expProductName = "Sauce Labs Backpack";
		Assert.assertEquals(actualProductName, expProductName, "Condition Mismatch");
		System.out.println("Verified that the products are displayed in the correct order based on: Name (A to Z)");
		// assertion end
		Thread.sleep(5000);
	}

	public void nameZToA() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select"));
		Select select = new Select(dropdown);
		select.selectByIndex(1);
		System.out.println("Dorpdown Name (Z to A) Completed");

		// Verify that the products are displayed in the correct order based on the selected option (Assertion)
		List<WebElement> productNames = driver.findElements(By.className("inventory_item_name"));
		String actualProductName = productNames.get(0).getText(); // first product name selected
		System.out.println(actualProductName);
		String expProductName = "Test.allTheThings() T-Shirt (Red)";
		Assert.assertEquals(actualProductName, expProductName, "Condition Mismatch");
		System.out.println("Verified that the products are displayed in the correct order based on: Name (Z to A)");
		// assertion end
		Thread.sleep(5000);
	}

	public void CartBadgeCountValidation() throws InterruptedException {
		// Add the four products to the cart by clicking Add to cart.
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		Thread.sleep(4000);

		// Verify the cart badge shows the correct item count (Assertion)
		WebElement cartIconBtn = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a"));
		String actCartBadgeCount = cartIconBtn.getText();
		System.out.println(actCartBadgeCount);
		String expCartBadgeCount = "4";
		Assert.assertEquals(actCartBadgeCount, expCartBadgeCount, "Condition Mismatch");
		System.out.println("Verified that the cart badge shows the correct item count");
		// assertion end

		// remove an item
		driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
		System.out.println("Added four products and removed a product");
		Thread.sleep(4000);

		// Verify the badge updates accordingly (Assertion)
		WebElement cartIconBtn2 = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a"));
		String actCartBadgeCount2 = cartIconBtn2.getText();
		System.out.println(actCartBadgeCount2);
		String expCartBadgeCount2 = "3";
		Assert.assertEquals(actCartBadgeCount2, expCartBadgeCount2, "Condition Mismatch");
		System.out.println("Verified that the badge updates accordingly");
		// assertion end
	}

}
