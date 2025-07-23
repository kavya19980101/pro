package Pra;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		List<WebElement> ele= driver.findElements(By.xpath("//a"));
		for (WebElement e : ele) {
			String s=e.getAttribute("href");
			try {
			URL url=new URL(s); 
			HttpURLConnection http=(HttpURLConnection) url.openConnection();
			http.connect();
			int code=http.getResponseCode();
			if(code>=400)
			{
				System.out.println("Broken link "+s);
			}
			else {
				System.out.println("Not a Broken link "+s);
			}
			}
			catch (Exception e1) {
				System.out.println("Broken link with Exception"+s);
			}
			
			
		}
	}

}
