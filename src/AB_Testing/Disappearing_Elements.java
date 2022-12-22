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

public class Disappearing_Elements {

	public WebDriver driver;

	@BeforeTest

	public void init() {

		driver = new ChromeDriver();
		//
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
	}

	@Test(invocationCount = 20)

	public void disappearing() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(9000));
		//
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[9]/a")).click();
		//
		List<WebElement> buttons = driver.findElements(By.tagName("li"));

		for (int x = 0; x < buttons.size(); x++) {
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[" + (x + 1) + "]/a")).click();
			driver.navigate().back();
		}

		Assert.assertEquals(buttons.size(), 5);

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
