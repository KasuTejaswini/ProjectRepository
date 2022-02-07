package MavenProject.BussinessScripts;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import MavenProject.Project.BaseClass;

public class PopUpsDemo extends BaseClass{
    @Test
	public void PromptPopupTest() 
	{	
      getDriver().get("");
      getDriver().findElement(By.xpath("")).click();
      
      Alert alert=getDriver().switchTo().alert();
      alert.sendKeys("text to be typed");
      String txt=alert.getText();
      System.out.println(txt);
      alert.accept();
	}
	@Test
	public void WindowBasedPopup() 
	{
		getDriver().get("");
		getDriver().findElement(By.xpath("")).sendKeys("send req file by mentioning location");
	}
	
	@Test
	public void WindowBasedAutoIt() throws IOException {
		getDriver().get("");
		getDriver().findElement(By.xpath("")).click();
		Runtime runtime=Runtime.getRuntime();
		runtime.exec("C:\\Users\\saketh\\eclipse-workspace\\Project\\popups\\Popup.exe");
	}
}
