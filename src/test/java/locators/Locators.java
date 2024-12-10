/* using linkText() and partialLinkText()
 * 
 */
package locators;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Locators {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://letcode.in");
	/*	WebDriver driver = new EdgeDriver();
	  	driver.get("https://letcode.in");
		driver.manage().window().maximise();
		driver.findElement(By.linkText("Work-Space")).click();
	//	driver.findElement(By.partialLinkText("Space")).click();
	  */
	
		
	}

}
