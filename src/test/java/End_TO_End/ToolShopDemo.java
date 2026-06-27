package End_TO_End;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolShopDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		// Navigate to targeted URL
		driver.get("https://practicesoftwaretesting.com/");

		// Maximize the screen
		driver.manage().window().maximize();
		
		//ImplicitWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Click on Categories
		driver.findElement(By.xpath("//button[contains(text(),'Categories')] ")).click();

		// By using For each loop
		List<WebElement> dropdown = driver.findElements(By.xpath("//a[contains(@href,'/category/')]"));

		for (WebElement option : dropdown) {

			String selectedop = option.getText();

			if (selectedop.equals("Other")) {
				option.click();

				// Click on page 2
				option.findElement(By.xpath("//a[text()='2']")).click();

				// select the product
				option.findElement(By.xpath("//h5[contains(text(),'Flat-Head')]")).click();

				// add to cart
				driver.findElement(By.id("btn-add-to-cart")).click();
				
				//Explicit Wait 
				WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(5));
				WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
				
				//Verify the Popup
				
				if(popup.isDisplayed()) {
				String text	= popup.getText();
					System.out.println("verified :" +text );
				}else {
					System.out.println("please check the logic");
				}
				
			WebElement addtoCartIcon = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-test='nav-cart']")));
			
			//Using Jscript Interface for clicking 
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",  addtoCartIcon);
			
			
			// Price 
			String unitPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(
			    By.xpath("//span[@data-test='product-price']"))).getText();

			// Quantity
			String quantity = driver.findElement(By.xpath("//input[@data-test='product-quantity']")).getAttribute("value");

			// Total
			String actualTotal = driver.findElement(By.xpath("//td[@data-test='cart-total']")).getText();

			//remove $ 
			double up = Double.parseDouble(unitPrice.replace("$", ""));
			int qty = Integer.parseInt(quantity.trim());
			double at = Double.parseDouble(actualTotal.replace("$", ""));

			// 4. Calculate what the price mathematically SHOULD be
			double finalTotal = up * qty;

			// check
			if (at == finalTotal) {
			  
			    System.out.println("Checked working fine");
			} else {
			    System.out.println("Pls Check Again");
			}
			} 
		}

	}
}