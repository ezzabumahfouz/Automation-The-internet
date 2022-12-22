package Dynamic_Loading;

import java.time.Duration;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Example_2 {

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
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[14]/a")).click();
		//
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[2]")).click();
		//
		driver.findElement(By.xpath("//*[@id=\"start\"]/button")).click();
		//
		StopWatch watch = new StopWatch();
		watch.start();
		String message = driver.findElement(By.xpath("//*[@id=\"finish\"]/h4")).getText();
		if (message == "") {
		} else {
			watch.stop();
			long result = watch.getTime();
			System.out.println(result);
			System.out.println(message);
		}

	}

	@Test

	public void checkFooter() {

		String footer = "Powered by Elemental Selenium";
		String actualFooter = driver.findElement(By.id("page-footer")).getText();
		Assert.assertEquals(footer, actualFooter);

	}

}
