package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	public static void main(String[] args) throws IOException, InterruptedException {
		  
		WebDriverManager.chromedriver().setup();
	    ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("one plus 9 pro" , Keys.ENTER);
		
		 String price = driver.findElement(By.xpath("(//span[@class = 'a-price-whole'])[1]")).getText();
		 System.out.println("price of one plus 9 pro: " + price);
		 
		 String rating = driver.findElement(By.xpath("//i[contains(@class,'a-icon a-icon-star-small')]")).getText();
		 System.out.println("customer rating is : " + rating);
		
		
		driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base')]")).click();
		 
		File sourceImage = driver.findElement(By.xpath("//img[@class='a-dynamic-image a-stretch-vertical']")).getScreenshotAs(OutputType.FILE);
		File finalImage = new File ("./snap/img001.png");
		FileUtils.copyFile(sourceImage, finalImage);
		System.out.println("File Captured");
		
		
		driver.findElement(By.xpath("(//input[@name='submit.buy-now'])[2]")).click();
		Thread.sleep(2000);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String >windowHandleslist = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowHandleslist.get(1));
		Thread.sleep(3000);
		
		String subtotal = driver.findElement(By.xpath("(//span[contains(@class,'a-size-base a-color-base')])[2]")).getText();
		
		System.out.println("subtototal is:" + subtotal);
		if((price).equals(subtotal)) {
			System.out.println("cart total is verified");
		}
		
		
		
		
		
		
		
	}

}
