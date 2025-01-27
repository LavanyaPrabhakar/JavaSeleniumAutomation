package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class AllLocator {
	//External declaration of browser value
	
	public static String browser="edge";
	// driver - global reference variable of WebDriver interface
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		if(browser.equals("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			driver= new EdgeDriver();
		}
		
		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("input.btn_action")).click();
		boolean appLogo=driver.findElement(By.cssSelector("div.app_logo")).isDisplayed();
		System.out.println("appLogo display : "+appLogo);
		
		String product_label=driver.findElement(By.xpath("//div[contains(@class,\"product_label\" )]")).getText();
		System.out.println("product_label : "+product_label);
		
		driver.findElement(By.className("inventory_item_img")).click();
		boolean priceDisp=driver.findElement(By.className("inventory_details_price")).isDisplayed();
		System.out.println("price display is : "+priceDisp);
		String expectedPrice="$29.99";
		String actualPrice=driver.findElement(By.xpath("//div[@class='inventory_details_price']")).getText();
		System.out.println(actualPrice);
		if(expectedPrice.equals(actualPrice))
		{
			System.out.println("Price is correct");
		}
		else
		{
			System.out.println("Price is incorrect");
		}
		driver.close();

	}

}
