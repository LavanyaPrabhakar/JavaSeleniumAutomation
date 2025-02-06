/*
 Testcase 1:Use implicit wait
 Testcase 2: default selected option displayed on dropdown button
 Testcase 3:  Use explicitWait to select an option from the dropdown menu &
 			  Print current selected textdisplay
 Testcase 4: Print all options in dropdown menu

 Use other Select class methods for dropdown button:
Testcase 5: Use selectByValue() method
Testcase 6: Use selectByValue() method
Testcase 7: Use selectByVisibleText() method
Testcase 8: Use isMultiple() method

 */
package dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingleDropdown {
	//External declaration of browser value
	
	public static String browser="edge";
	// driver - global reference variable of WebDriver interface
	public static WebDriver driver;
	public static void main(String[] args) {
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().window().maximize();	
		
		// Locator using ID
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		// Locator using cssSelector-Tagname & ID
		driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
		// Locator using cssSelector-Tagname & Class
		driver.findElement(By.cssSelector("input.btn_action")).click();
		
		// Locator using cssSelector-Tagname & Class
		WebElement drpdwn= driver.findElement(By.cssSelector("select[class='product_sort_container']"));
		Select select= new Select(drpdwn);
		
		//Testcase 1: default selected option displayed on dropdown button
		String defaultTextDisplay=select.getFirstSelectedOption().getText();
		
		System.out.println("default selected option :"+defaultTextDisplay);
		
		//Testcase 2: Use explicitWait to select an option from the dropdown menu &
		// 			  Print current selected textdisplay
		
		WebDriverWait myWait= new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement opt=myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[contains(text(),'Price (low to high)')]")));
		opt.click();
		
		System.out.println("display selected option :"+select.getFirstSelectedOption().getText());
		
		//Testcase 3: Print all options in dropdown menu
		
		List<WebElement> allOptions=select.getOptions();
		
		System.out.println("List of all options in dropdown: ");
		for(WebElement we:allOptions)
		{
			
			System.out.println(we.getText());
		}
		// Use other Select class methods for dropdown button
		//Testcase 4: Use selectByValue() method
		select.selectByValue("za");

		//Testcase 5: Use selectByValue() method
		select.selectByIndex(0);
		
		//Testcase 6: Use selectByVisibleText() method
		select.selectByVisibleText("Price (high to low)");
		
		//Testcase 7: Use isMultiple() method
		System.out.println("is it a multi-select dropdown? :"+select.isMultiple());
		driver.close();
	}

}
