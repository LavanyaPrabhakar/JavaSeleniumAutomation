package launchBrowsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChromeBrowser {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.get("https://letcode.in/test");
	driver.manage().window().maximize();
	String title = driver.getTitle();
	System.out.println("Title of the webpage = "+title);
	String currentLink =driver.getCurrentUrl();
	System.out.println("url of the website = "+currentLink);
	driver.close();

	}

}
