package Pra;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadDataFromJson {
	
  public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
	  JSONParser parser=new JSONParser();
	 Object obj= parser.parse(new FileReader("C:\\Users\\Kaviya S\\Downloads\\excelddt\\commondata.json"));
JSONObject map=(JSONObject)obj;	  
	  
			String browser=map.get("browser").toString();
			String URL=map.get("url").toString();
			WebDriver driver;
			if(browser.equals("chrome"))
			{
				driver=new ChromeDriver();
			}
			else if (browser.equals("firefox"))
			{
				driver=new FirefoxDriver();
			}
			else {
				driver=new ChromeDriver();
			}
			driver.get(URL);
}

}
