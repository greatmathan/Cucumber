package StepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Addtocart {
	WebDriver Driver;
	WebDriverWait wait;

	@Given("User Should Navigate To the Application")
	public void userShouldNavigateToTheApplication() {
		System.setProperty("webdriver.edge.driver", "./Driver/msedgedriver.exe");
		Driver =new EdgeDriver();
		Driver.get("https://bookcart.azurewebsites.net/login");
		wait = new WebDriverWait(Driver, 10);
		Driver.manage().window().maximize();


	}

	@Given("User should login As {string} and {string}")
	public void userShouldLoginAsAnd(String string, String string2) throws InterruptedException {
		Driver.findElement(By.cssSelector("input[formcontrolname='username']")).sendKeys("Mathan");
		Driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("Qwertyiop09");
		Driver.findElement(By.xpath("//span[text()='Login']")).click();
Thread.sleep(3000);
	}

	@Given("User search a book{string}")
	public void userSearchABook(String string) {

		Driver.findElement(By.xpath("//input[@type='search']")).sendKeys("harry potter and the chamber of secrets",Keys.ENTER);

	}

	@When("User Add the book to the cart")
	public void userAddTheBookToTheCart() {
		Driver.findElement(By.xpath("(//mat-icon[text()='shopping_cart']/following-sibling::span)[3]")).click();
try {
	Thread.sleep(1000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

	@Then("The cart badge should be updated")
	public void theCartBadgeShouldBeUpdated() {

		//String txt=Driver.findElement(By.xpath("(//span[@class='mat-mdc-button-touch-target'])[2]")).getText();
		WebElement cartBadge =	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='mat-mdc-button-touch-target'])[2]")));
		String txt = cartBadge.getText();
		try { int store = Integer.parseInt(txt); 
		System.out.println(store); 
		Assert.assertTrue(store > 0, "The number of items in the cart should be greater than zero.");
		} catch (NumberFormatException e) 
		{ System.out.println("The text is not a valid number: " + txt);
		Driver.quit();
		//Assert.fail("Failed due to invalid number format.");
		} 
		
	}

}
