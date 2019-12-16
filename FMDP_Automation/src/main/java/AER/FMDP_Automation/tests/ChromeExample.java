/**
 * TEST CASE :
 * 1. Open chrome browser
 * 2. Maximize browser
 * 3. Open www.google.com URL
 * 4. Print window header/title
 * 5. Print Current URL
 * 6. Closes browser
*/

package AER.FMDP_Automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeExample
{
	public static WebDriver driver;

	public static void main(String[] args)
	{
		System.out.println("launching chrome browser");
						
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kalpesht\\git\\FMDP_Automation\\FMDP_Automation\\lib\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.navigate().to("https://test.zpecloud.com/login");
		
		String actual = driver.findElement(By.xpath("//p[contains(.,'© 2013-2019 ZPE Systems, Inc.')]")).getText();
		
		System.out.println(actual);
			
		if (actual.equals("© 2013-2019 ZPE Systems, Inc."))
		{
			System.out.println("Text Found");
		}
		else
		{
			System.out.println("Text NOT found");
		}		
					
		driver.close();
	}
}
