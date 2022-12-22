package AB_Testing;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AB_Testing {

	public WebDriver driver;

	@BeforeTest

	public void init() {

		driver = new ChromeDriver();
		//
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
	}

	@Test

	public void check() {

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(9000));
		//
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a")).click();

		String text = "A/B Test Variation";
		String actualText = driver.findElement(By.className("example")).getText();

		if (actualText.contains(text)) {
			System.out.println("Done");
		} else {
			System.err.println("Not HERE !!");
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
