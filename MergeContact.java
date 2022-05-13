package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
	    ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();
		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
	    List<String> windowHandlesList = new ArrayList<String>(windowHandles);
	    driver.switchTo().window(windowHandlesList.get(1));    
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("//a[@class='linktext']")).click();
	    driver.switchTo().window(windowHandlesList.get(0));
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	    
	    Set<String>windowHandles1 = driver.getWindowHandles();
	    List<String>windowHandles1List = new ArrayList<String>(windowHandles1);
	    driver.switchTo().window(windowHandles1List.get(1));
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[3]")).click();
	    
	    driver.switchTo().window(windowHandles1List.get(0));
	    driver.findElement(By.linkText("Merge")).click();
	    
	     Alert alert = driver.switchTo().alert();
	    
	     alert.accept();
	     
	     
	     
	     
	    
		
		
		
		
		
		
	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


