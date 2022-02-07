package MavenProject.PageObjects;

import java.sql.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import MavenProject.Project.BaseClass;

public class GmailHomepage extends BaseClass
{
   static
   {
	   PageFactory.initElements(getDriver(),GmailHomepage.class);
   }

   @FindBy(id="identifierId")
   private static WebElement username;
   
   @FindBy(xpath="//button[text()='Forgot email?']")
   private static WebElement frgtemail;
   
   @FindBy(xpath="//span[text()='Create account']")
   private static WebElement createaccnt;
   
   @FindBy(xpath="//span[text()='Next']")
   private static WebElement next;
   
   public void enterUsername(String data)
   {
	   try
	   {
		   Assert.assertTrue(username.isDisplayed()&&username.isEnabled());  
		   getExtentTest().log(LogStatus.PASS,"username is identified and displayed");
		   username.clear();
		   username.sendKeys(data);
		   getExtentTest().log(LogStatus.PASS,"username is entered");
	   }
	   catch (Exception exception) 
	   {
		getExtentTest().log(LogStatus.FAIL,"username is not identified and displayed");
	   }	
   }
   
   public void createAccnt()
   {
	try
	{
	Assert.assertTrue(createaccnt.isDisplayed()&&createaccnt.isEnabled());	
	getExtentTest().log(LogStatus.PASS,"createaccnt is identified and displayed");
	createaccnt.click();
	}
	finally
	{
		getExtentTest().log(LogStatus.FAIL,"createaccnt is not identified and displayed");
	}
   }
   
   public void clickonnxt() {
	try
	{
	Assert.assertTrue(next.isDisplayed()&&next.isEnabled());
	getExtentTest().log(LogStatus.FAIL,"Next button is identified and displayed");
	next.click();
	}
   catch(Exception exception) 
	{
	   getExtentTest().log(LogStatus.FAIL,"Next is not identified and displayed");
    }
  }
   
   public void clickonfrgtemail() {
	try
	{
		Assert.assertTrue(frgtemail.isDisplayed()&&frgtemail.isEnabled());
		getExtentTest().log(LogStatus.FAIL,"Forgot email button is identified and displayed");
		frgtemail.click();
	}
    finally
    {
    	getExtentTest().log(LogStatus.FAIL,"forgot email button is not identified and displayed");
    }
  }
     
}
