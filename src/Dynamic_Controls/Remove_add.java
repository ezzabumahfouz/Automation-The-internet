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

public class Remove_add {

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
		String test1 = driver.findElement(By.xpath("//*[@id=\"checkbox\"]")).getText();
		StopWatch watch = new StopWatch();
		watch.start();

		if (test1 == null) {
			System.err.println("Done!!!!!!");
		} else {
			driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button")).click();
			String test2 = driver.findElement(By.xpath("//*[@id=\"message\"]")).getText();
			watch.stop();
			long result = watch.getTime();
			long seconds = TimeUnit.MILLISECONDS.toSeconds(result);

			System.out.println(seconds);
			System.out.println(test2);
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
