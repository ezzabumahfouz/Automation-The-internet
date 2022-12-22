package AB_Testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Add_Remove_Elements {

	public WebDriver driver;

	@BeforeTest

	public void init() {

		driver = new ChromeDriver();
		//
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
	}

	@Test

	public void addButtons() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(9000));
		//
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a")).click();
		//
		int y = 500;
		for (int x = 0; x < y; x++) {
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
		}
	}

	@Test

	public void removeButtons() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(9000));
		//
		int y = 0;
		for (int x = 500; x > y; x--) {
			driver.findElement(By.xpath("//*[@id=\"elements\"]/button[" + x + "]")).click();
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
