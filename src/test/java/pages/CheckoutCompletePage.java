package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckoutCompletePage {
	protected WebDriver driver;

	// constructor
	public CheckoutCompletePage(WebDriver driver) {
		this.driver = driver;

	}

	// Verify Success Message (Assertion)
	public void verifySuccessMessage() {
		WebElement title = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/h2"));
		String actTitle = title.getText();
		System.out.println(actTitle);
		String expTitle = "Thank you for your order!";
		Assert.assertEquals(actTitle, expTitle, "Condition Mismatch");
		System.out.println("Verified that success message: Thank you for your order!");
	}
}
