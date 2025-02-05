/* 1.  External declaration of browser value
 * 2.  driver - global reference variable of WebDriver interface
 * 3.  wait()- use implicit wait
 * 4.  Locator using ID
 * 5.  Locator using cssSelector-Tagname & ID
 * 6.  Locator using cssSelector-Tagname & Class
 * 7.  Locator using XPath
 * 8.  Locator using className
 * 9.  Method: isDisplayed()
 * 10. Method: getText()
 * 11. CssSelector :substring using three special chars ^	$ *
 * 		^= prefix of string
 * 		$= suffix of string
 * 		*=middle of string
 * 12. Locator for Dropdown button and use Select class
 */
package locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class AllLocator {
	//External declaration of browser value
	
	public static String browser="edge";
	// driver - global reference variable of WebDriver interface
	public static WebDriver driver;

	public static void main(String[] args)  {
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
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().window().maximize();
		// Locator using ID
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		// Locator using cssSelector-Tagname & ID
		driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
		// Locator using cssSelector-Tagname & Class
		driver.findElement(By.cssSelector("input.btn_action")).click();
		
		//Method: isDisplayed() - return type boolean
		boolean appLogo=driver.findElement(By.cssSelector("div.app_logo")).isDisplayed();
		System.out.println("appLogo display : "+appLogo);
		
		//Method: getText() - return type String
		String product_label=driver.findElement(By.xpath("//div[contains(@class,\"product_label\" )]")).getText();
		System.out.println("product_label : "+product_label);
		
		// Locator using className
		driver.findElement(By.className("inventory_item_img")).click();
		boolean priceDisp=driver.findElement(By.className("inventory_details_price")).isDisplayed();
		System.out.println("price display is : "+priceDisp);
		String expectedPrice="$29.99";
		
		// Locator using XPath
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
		
		/*
		CssSelector :substring using three special chars ^	$ *
		button[class='inventory_details_back_button']
		button[class^='inventory_details_']
		button[class$='_back_button']
		button[class*='_details_back_']
		 */
		
		WebElement we=driver.findElement(By.cssSelector("button[class^='inventory_details_']"));
		
		we.click();
		
		/* Locator for Dropdown button and use Select class
		 Methods: 
		 selectByContainsVisibleText()
		 selectByIndex()
		 selectByValue()
		 
		*/
		WebElement drpdown=driver.findElement(By.cssSelector("select[class$='_sort_container']"));
		Select drpOption = new Select(drpdown);
		drpOption.selectByContainsVisibleText("Price (high to low)");
		
		drpOption.selectByIndex(1);
		
		drpOption.selectByValue("lohi");
		
		driver.close();

	}

}
