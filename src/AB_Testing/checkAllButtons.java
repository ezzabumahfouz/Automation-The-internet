package AB_Testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class checkAllButtons {

	public WebDriver driver;

	@BeforeTest

	public void init() {

		driver = new ChromeDriver();
		//
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
	}

	@Test

	public void allButtons() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(9000));
		//
		int num = 45;
		for (int x = 1; x < num; x++) {
			driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[" + x + "]/a")).click();
			driver.navigate().back();
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
