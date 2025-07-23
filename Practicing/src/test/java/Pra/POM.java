package Pra;

import java.util.Iterator;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class POM {
	
	
	@FindBy(xpath  = "//div[@class='KzDlHZ']")
	private List<WebElement> ele1;
	
	@FindBy(xpath  = "//div[@class='Nx9bqj _4b5DiR']")
	private List<WebElement> ele2;
	
	
	POM(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public List<WebElement> getpro() {
		
	return ele1;
		
	}
	
	public List<WebElement> getprice() {
		return ele2;
		
	}
	
}
	
		  
	

