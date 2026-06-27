package Contact;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class With_Saving_Details {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("https://practicesoftwaretesting.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.findElement(By.linkText("Contact")).click();

		System.out.println("Clicked on Contact");

		// Fill the form with details

		driver.findElement(By.id("first_name")).sendKeys("Sree");

		driver.findElement(By.id("last_name")).sendKeys("Vemuri");

		driver.findElement(By.id("email")).sendKeys("sree123@gmail.com");

		WebElement dropdown = driver.findElement(By.id("subject"));
		dropdown.click();
		
		Select select = new Select(dropdown);
		
		List<WebElement> options = select.getOptions();

		for (int i = 0; i < options.size(); i++) 
		{
			
			System.out.println(options.get(i).getText());
		}

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please select below options: ");
		int selectedoption = scanner.nextInt();
		scanner.close();
		
		select.selectByIndex(selectedoption);

		driver.findElement(By.xpath("//textarea[@formcontrolname='message']"))
				.sendKeys("AbcdefghijklmnopqrstuvwxyzAbcdefghijklmnopqrstuvwxyz");

		driver.findElement(By.xpath("//input[@value='Send']")).click();

		driver.findElement(By.className("btnSubmit")).click();
		System.out.println("Clicked on Save button");
		
		//verification
		WebElement orderSuccess = driver.findElement(By.xpath("//div[text()=' Thanks for your message! We will contact you shortly. ']"));
		

			
			System.out.println(orderSuccess.isDisplayed());
		}
	}
