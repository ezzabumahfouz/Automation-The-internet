package AB_Testing;

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

public class Entry_Ad {

	public WebDriver driver;

	@BeforeTest

	public void init() {

		driver = new ChromeDriver();
		//
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
	}

	@Test

	public void test() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15000));
		//
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[15]/a")).click();
		//
		Thread.sleep(3000);
		//
		String actual = "It's commonly used to encourage a user to take an action (e.g., give their e-mail address to sign up for something or disable their ad blocker).";
		String expect = driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/div[2]/p")).getText();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"modal\"]/div[2]/div[3]/p")).click();

		Assert.assertEquals(expect, actual);
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
