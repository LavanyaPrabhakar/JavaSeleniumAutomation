/* Testcases:
 *  1. Launch chrome browser
 *  2. Open the url: "https://letcode.in/test"
 *  3. Maximise the window
 *  4. Get the actual title
 * 	5. Validate the expected title as "LetCode - Testing Hub" with the actual title
 *  6. Get the url of current page and print it
 * 	7. Close browser
 */
package launchBrowsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChromeBrowser {

	public static void main(String[] args) {
		// 1. Launch chrome browser
	WebDriver driver = new ChromeDriver();
	// 2. Open the url
	driver.get("https://letcode.in/test");
	// 3. Maximise the window
	driver.manage().window().maximize();
	// 4. Get the actual title and print it
	String actualTitle = driver.getTitle();
	System.out.println("Title of the webpage = "+actualTitle);
	// 5. Validate the expected title as "LetCode - Testing Hub" with the actual title
	
	if (actualTitle.equals("LetCode - Testing Hub"))
	{
		System.out.println("Test passed");
	}
	else
	{
		System.out.println("Test failed");
	}
	// 6. Get the url of current page
	String currentUrl =driver.getCurrentUrl();
	System.out.println("url of the website = "+currentUrl);
	// 7. close the browser
	driver.close();

	}

}
