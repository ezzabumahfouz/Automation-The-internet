package AB_Testing;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Checkboxes {

	public WebDriver driver;

	@BeforeTest

	public void init() {

		driver = new ChromeDriver();
		//
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
	}

	@Test

	public void checkboxes() {

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(9000));
		//
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[6]/a")).click();
		//
		driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click();
		//
		WebElement checkBox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		WebElement checkBox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		//
		boolean isSelected1 = checkBox1.isSelected();
		boolean isSelected2 = checkBox2.isSelected();
		//
		Assert.assertEquals(isSelected1, true);
		Assert.assertEquals(isSelected2, false);

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
