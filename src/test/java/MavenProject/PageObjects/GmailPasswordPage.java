package MavenProject.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import MavenProject.Project.BaseClass;
import junit.framework.Assert;

public class GmailPasswordPage extends BaseClass{
   
	static
	{
		PageFactory.initElements(getDriver(),GmailPasswordPage.class);
	}
	
	@FindBy(name="password")
	private static WebElement password;
	@FindBy(xpath="//input[@type='checkbox']")
	private static WebElement showpwd;
	@FindBy(xpath="//input[text()='Forgot password?']")
	private static WebElement frgtpwd;
	@FindBy(xpath="//span[text()='Next']")
	private static WebElement Next;
	
	public void enterPwd(String data) 
	{
      try
      {
    	Assert.assertTrue(password.isDisplayed()&&password.isEnabled()); 
    	password.sendKeys(data);
    	getExtentTest().log(LogStatus.PASS,"password is identified and enabled");
      }
      finally
      {
    	  getExtentTest().log(LogStatus.FAIL,"password is not identified and enabled");
      }
	}
	
	public void clickonShowpwd() {
		try
		{
		Assert.assertTrue(showpwd.isDisplayed()&&showpwd.isEnabled());	
		getExtentTest().log(LogStatus.PASS,"Showpassword is identified and enabled");
		showpwd.click();
		}
		finally
		{
			 getExtentTest().log(LogStatus.FAIL,"Showpassword is not identified and enabled");	
		}
	}
	
	public void clickonFrgtpwd() {
		try
		{
			Assert.assertTrue(frgtpwd.isDisplayed()&&frgtpwd.isEnabled());
			getExtentTest().log(LogStatus.PASS,"Forgot password is identified and enabled");
			frgtpwd.click();
		}
		finally
		{
			 getExtentTest().log(LogStatus.FAIL,"Forgotpassword is not identified and enabled");	
		}

	}
	
	public void clickonNext() {
		try
		{
			Assert.assertTrue(Next.isDisplayed()&&Next.isEnabled());
			getExtentTest().log(LogStatus.PASS,"Next is identified and enabled");
			Next.click();
		}
		finally
		{
			 getExtentTest().log(LogStatus.FAIL,"Next is not identified and enabled");	
		}

	}
}
