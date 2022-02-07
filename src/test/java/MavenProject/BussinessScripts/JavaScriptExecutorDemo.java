package MavenProject.BussinessScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import MavenProject.Utilities.Driverpaths;

public class JavaScriptExecutorDemo {
public static void main(String[] args) {
	   
	System.setProperty(Driverpaths.Chromekey,Driverpaths.Chromevalue);
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
	
	JavascriptExecutor jse=(JavascriptExecutor) driver;
	
	jse.executeScript("window.location='https://www.gmail.com';");
	jse.executeScript("document.getElementById('identifierId').value='kasu';");
	jse.executeScript("document.getElementById('identifierNext').click();");


	WebElement un=driver.findElement(By.id("identifierId"));
	jse.executeScript("arguments[0].click();",un);
	WebElement nxt=driver.findElement(By.id("identifierId"));
	jse.executeScript("arguments[0].value='teju';",nxt);  
	
	driver.close();
}
}
