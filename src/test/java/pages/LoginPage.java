package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
	protected WebDriver driver;

	// Locate the web element new style
	// private By usernameField = By.id("user-name");//replace by 22 no line
	// private By passwordField = By.id("password"); //replace by 28 no line
	// private By loginButton = By.id("login-button"); //replace by 35 no line

	// constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// enter username
	public void enterUser(String username) {
		// driver.findElement(usernameField).sendKeys(username);
		driver.findElement(By.id("user-name")).sendKeys(username);
		System.out.println("User set completed");
	}

	// enter password
	public void enterPassword(String password) {
		// driver.findElement(passwordField).sendKeys(password);
		driver.findElement(By.id("password")).sendKeys(password);
		System.out.println("Password set completed");

	}

	// click login function
	public void clickLogin() {
		// driver.findElement(loginButton).click();
		driver.findElement(By.id("login-button")).click();
		System.out.println("Click completed");
	}

	// Verify Incorrect username/password should not successful login (Assertion)
	public void incorrectUserLoginValidation() {
		WebElement title = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3"));
		String actTitle = title.getText();
		System.out.println(actTitle);
		String expTitle = "Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(actTitle, expTitle, "Condition Mismatch for login funtionality");
		System.out.println("Verified that Incorrect username/password should not successful login");

	}

	// Verify that this user has been locked out (Assertion)
	public void lockedOutUserValidation() {
		WebElement title = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3"));
		String actTitle = title.getText();
		System.out.println(actTitle);
		String expTitle = "Sorry, this user has been locked out";
		Assert.assertTrue(actTitle.contains(expTitle), "Condition Mismatch");
		System.out.println("Verified that the error message: Sorry, this user has been locked out.");

	}

}
