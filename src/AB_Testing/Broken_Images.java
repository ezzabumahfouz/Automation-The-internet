package AB_Testing;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
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

public class Broken_Images {

	public WebDriver driver;

	@BeforeTest

	public void init() {

		driver = new ChromeDriver();
		//
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
	}

	@Test

	public void images() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(9000));
		//
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[4]/a")).click();
		//
		List<WebElement> links = driver.findElements(By.tagName("img"));
		int brokenImagesCount = 0;
		for (int i = 0; i < links.size(); i++) {
			String linkURL = links.get(i).getAttribute("src");
			URL url = new URL(linkURL);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			http.setConnectTimeout(10000);
			http.setReadTimeout(20000);
			int statusCode = http.getResponseCode();
			if (statusCode == 404 || statusCode == 500) {
				brokenImagesCount += 1;
			}
		}
		System.out.println("Total image are: " + links.size());
		System.out.println("Good image are: " + (links.size() - brokenImagesCount));
		System.err.println("Broken images are: " + brokenImagesCount);
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
