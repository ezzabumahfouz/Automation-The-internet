package Dynamic_Controls;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Enable_disable {

	public WebDriver driver;

	@BeforeTest

	public void init() {

		driver = new ChromeDriver();
		//
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
	}

	@Test

	public void test() {

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15000));
		//
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[13]/a")).click();
		//
		boolean test = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input")).isEnabled();

		if (test == true) {
			System.err.println("What  !!!!!!");
		} else {

			StopWatch watch = new StopWatch();
			watch.start();

			driver.findElement(By.xpath("//*[@id=\"input-example\"]/button")).click();

			if (test == true) {
				System.err.println("Not .........");
			} else {

				watch.stop();
				long result = watch.getTime();
				long seconds = TimeUnit.MILLISECONDS.toSeconds(result);

				System.out.println("Complete");
				System.out.println(seconds);
			}
		}

	}

	@Test

	public void checkFooter() {

		String footer = "Powered by Elemental Selenium";
		String actualFooter = driver.findElement(By.id("page-footer")).getText();
		Assert.assertEquals(footer, actualFooter);

	}

	@AfterTest

	public void close() {
		driver.close();
	}

}
