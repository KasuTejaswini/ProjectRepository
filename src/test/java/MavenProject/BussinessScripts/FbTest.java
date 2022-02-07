package MavenProject.BussinessScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import MavenProject.CustomizedExceptions.CustomException;
import MavenProject.Project.BaseClass;
import MavenProject.Utilities.PojoReaderClass;
import MavenProject.listeners.CustomRetryAnalyzer;

public class FbTest extends BaseClass{

	@Test(retryAnalyzer = CustomRetryAnalyzer.class)
   public void fbTest() throws InterruptedException, IOException, CustomException {
	  
	  String url=PojoReaderClass.getPrConfObj().getPropertyValue("fb_url");
      getDriver().get(url); 
      
      String fbid=PojoReaderClass.getPrOrObj().getPropertyValue("fb_un_id");
      getExtentTest().log(LogStatus.PASS,"fb id is :"+fbid);
      String passid= PojoReaderClass.getPrOrObj().getPropertyValue("fb_pwd_id");
      getExtentTest().log(LogStatus.PASS,"pwd id is :"+passid);
      String loginpath=PojoReaderClass.getPrOrObj().getPropertyValue("fb_login_xpath");
      getExtentTest().log(LogStatus.PASS,"login button xpath is :"+loginpath);
      WebElement emailId=getDriver().findElement(By.id(fbid));
      emailId.clear();
      emailId.sendKeys("tejaswinikasu1838@gmail.com");
      
      WebElement password=getDriver().findElement(By.xpath(passid));
      password.clear();
      password.sendKeys("34566");
      
     WebElement login= getDriver().findElement(By.xpath(loginpath));
     login.click();
     
     Thread.sleep(2000);
 }	
}
