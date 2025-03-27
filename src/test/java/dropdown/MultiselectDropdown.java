package dropdown;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiselectDropdown {
	public static WebDriver driver;
	public static String browser="Firefox";

	public static void main(String[] args) {
		if(browser.equals("Firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(browser.equals("Chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browser.equals("Edge"))
		{
			driver= new EdgeDriver();
		}
		
		driver.get("https://testautomationcentral.com/demo/");

	}

}
