package Contact;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Without_Saving_Details {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://practicesoftwaretesting.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.findElement(By.linkText("Contact")).click();

		System.out.println("Clicked on Contact");

		driver.findElement(By.className("btnSubmit")).click();
		System.out.println("Clicked on Save button");
		
	}
}