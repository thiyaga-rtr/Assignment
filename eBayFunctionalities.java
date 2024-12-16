package eBay;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eBayFunctionalities {

	@Test
	
	public void eBayFunctions() {
		
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.ebay.com");
	driver.manage().window().maximize();
	
	WebElement searchBox = driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));
	searchBox.sendKeys("book");
	WebElement searchButton =  driver.findElement(By.id("gh-btn"));
	searchButton.click();
	
	WebElement bookName = driver.findElement(By.xpath("(//div[@class='s-item__title']//span//span)[1]"));
	bookName.click();
	
	Set<String> windowHandles = driver.getWindowHandles();
	
	List<String> list = new LinkedList<>(windowHandles);
	
	driver.switchTo().window(list.get(1));
	
	driver.findElement(By.xpath("//span[text()='Add to cart']")).click();
	
	WebElement cart= driver.findElement(By.xpath("//i[@id='gh-cart-n']"));
	String cartValue = cart.getText();
	int Actual = 1;
	
	Assert.assertEquals(cartValue, Actual);


	}
}
