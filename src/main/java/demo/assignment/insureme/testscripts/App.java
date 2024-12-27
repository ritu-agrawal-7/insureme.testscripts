package demo.assignment.insureme.testscripts;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Executing selenium script" );

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://3.14.248.175:8081/contact.html");
		// invoke implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

		driver.findElement(By.name("your_name")).sendKeys("Ritu");
		
		driver.findElement(By.name("phone_number")).sendKeys("999999999");
		
		driver.findElement(By.name("email_address")).sendKeys("xyz@abc.com");
		
		driver.findElement(By.name("your_message")).sendKeys("Hello, How are you?");
		
		driver.findElement(By.id("my-button")).click();
	
		//assert Result
		String message = driver.findElement(By.id("response")).getText();
		
		System.out.println(message);
		
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

		File destFile = new File("test-report.jpg");

		FileUtils.copyFile(srcFile, destFile);

		driver.quit();

		System.out.println("Script Executed and Result Captured");
    }
}
