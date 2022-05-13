package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();
	driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
	driver.manage().window().maximize();
	
	driver.switchTo().frame("frame1");
	
	
	driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input[1]")).sendKeys("animals");
	
	Thread.sleep(2000);
	WebElement frameElement = driver.findElement(By.id("frame3"));
	
	driver.switchTo().frame(frameElement);
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//input[@id='a']")).click();
	driver.switchTo().defaultContent();
	
	WebElement frameElement2 = driver.findElement(By.id("frame2"));
	driver.switchTo().frame(frameElement2);
	Thread.sleep(2000);
	
	
	WebElement sourcedp = driver.findElement(By.id("animals"));
	
	Select select = new Select (sourcedp);
	select.selectByIndex(3);
	
	
	
	
	
	
	
	
	
	
}
}
