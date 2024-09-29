import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonProject1 {

	public static void main(String[] args) throws InterruptedException {
		

		// Set up driver executable
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Lanching Aamazon site
		driver.get("https://www.amazon.com/");
		Thread.sleep(3000);

		// locating search bar field and sending text
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Boost Mobile| Apple iPhone 16 pro");
		driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(3000);
		// selecting particular phone
		driver.findElement(By.className("s-image")).click();

		// locating Instock element
		WebElement availabiltyEle = driver.findElement(By.xpath("//div[starts-with(@id,'availabilityInsideBuyBox')]"));

		// getting text visible and printing
		String AvailabiltyMessage = availabiltyEle.getText();
		System.out.println(AvailabiltyMessage);

		// Verifying availabilty text
		if (AvailabiltyMessage.contains("In Stock"))
		{
			System.out.println("Item is in stock");
		} 
		else if (AvailabiltyMessage.contains("Out of Stock"))
		{
			System.out.println("Item is out of stock");
		}
		else 
		{
			System.out.println("only few items are available");
		}
		

		// closing the browser
		driver.quit();
	}
	

	}


