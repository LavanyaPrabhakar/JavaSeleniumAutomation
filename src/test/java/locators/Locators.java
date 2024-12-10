/* using linkText() and partialLinkText()
 * 
 */
package locators;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Locators {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("https://letcode.in");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Work-Space")).click();
	//	driver.findElement(By.partialLinkText("Space")).click();
		
	}

}
