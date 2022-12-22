package AB_Testing;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dropdown_List {

	public WebDriver driver;

	@BeforeTest

	public void init() {

		driver = new ChromeDriver();
		//
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
	}

	@Test

	public void disappearing() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(9000));
		//
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[11]/a")).click();
		//
		List<WebElement> options = driver.findElements(By.tagName("option"));
		//
		for (int x = 0; x < options.size() - 1; x++) {

			driver.findElement(By.id("dropdown")).click();
			driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[" + (x + 2) + "]")).click();
			String option = driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[" + (x + 2) + "]")).getText();
			Assert.assertEquals(option, ("Option " + (x + 1)));
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body")).click();
			Thread.sleep(1000);

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
