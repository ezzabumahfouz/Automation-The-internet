package AB_Testing;

import java.awt.AWTException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Drag_and_Drop {

	public WebDriver driver;

	@BeforeTest

	public void init() {

		driver = new ChromeDriver();
		//
		driver.get("http://the-internet.herokuapp.com/");
//		driver.manage().window().maximize();
	}

	@Test

	public void dragAndDrop() throws AWTException {

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(9000));
		//
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[10]/a")).click();
		//
		WebElement from = driver.findElement(By.xpath("//*[@id=\"column-a\"]/header"));
		WebElement to = driver.findElement(By.xpath("//*[@id=\"column-b\"]/header"));
		//
		Actions action = new Actions(driver);
		action.dragAndDrop(from, to).build().perform();
		//
		Assert.assertEquals(from.getText(), "B");
		Assert.assertEquals(to.getText(), "A");

	}

	@Test

	public void checkFooter() {

		String footer = "Powered by Elemental Selenium";
		String actualFooter = driver.findElement(By.id("page-footer")).getText();
		Assert.assertEquals(footer, actualFooter);

	}

//	@AfterTest
//
//	public void close() {
//		driver.close();
//	}

}
