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

public class GmailTest extends BaseClass {

	@Test(retryAnalyzer = CustomRetryAnalyzer.class)
    public void gmailtest() throws InterruptedException, IOException, CustomException {
	
		String url=PojoReaderClass.getPrConfObj().getPropertyValue("gmail_url");
		getExtentTest().log(LogStatus.PASS,"url is :"+url);
	    getDriver().get(url);
	    
	    String unID= PojoReaderClass.getPrOrObj().getPropertyValue("gmail_un_id");
	    getExtentTest().log(LogStatus.PASS,"gmail id is :"+unID);
	    String nxt=PojoReaderClass.getPrOrObj().getPropertyValue("gmail_nxt_xpath");
	    getExtentTest().log(LogStatus.PASS,"gmail next button xpath is :"+nxt);
	    
	    WebElement username=getDriver().findElement(By.id(unID));
        username.clear();
        username.sendKeys("kasutejaswini18@gmail.com");
       
        WebElement next=getDriver().findElement(By.xpath(nxt));
        next.click();
        Thread.sleep(2000);
}
}
