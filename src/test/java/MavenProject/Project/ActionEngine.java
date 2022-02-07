package MavenProject.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class ActionEngine extends BaseClass
{
    public static void enterURL(String url) {
		try
		{
		getExtentTest().log(LogStatus.PASS,"url is :"+url);
		getDriver().get(url);
		getExtentTest().log(LogStatus.PASS,"url is entered");
		}
		catch(Exception exception)
        {
        	getExtentTest().log(LogStatus.FAIL,"url is not entered");	
        }
	}
	
	public static void navigateURL(String url) 
	{
		try
		{
			getExtentTest().log(LogStatus.PASS,"url is:"+url);
			getDriver().navigate().to(url);
			getExtentTest().log(LogStatus.PASS,"url is entered");
		}
        catch(Exception exception)
		{
        	getExtentTest().log(LogStatus.FAIL,"url is not entered");
		}
	}
	
	public static void ClickByWebElement(WebElement element,String elementName) 
	{
		try
		{
			if(element.isDisplayed()&&element.isEnabled())
			{
				getExtentTest().log(LogStatus.PASS,"element is displayed and enabled:"+elementName);
				element.click();
				getExtentTest().log(LogStatus.PASS,"clicked on element:"+elementName);
			}
		}
        catch(Exception exception)
		{
        	getExtentTest().log(LogStatus.FAIL,"clickable action is not performed");
		}
	}
	
	public static void ClickByActions(WebElement element,String elementName)
	{
		try
		{
			if(element.isDisplayed()&&element.isEnabled())
			{
				getExtentTest().log(LogStatus.PASS,"element is displayed and enabled:"+elementName);
				Actions actions=new Actions(getDriver());
				actions.click(element).build().perform();
				getExtentTest().log(LogStatus.PASS,"clicked on element:"+elementName);
			}
		}
        catch(Exception exception)
		{
        	getExtentTest().log(LogStatus.FAIL,"clickable action is not performed");
		}
	}
		
	public static void DoubleClickByActions(WebElement element,String elementName)
	{
		try
		{
			 Assert.assertTrue(element.isDisplayed()&&element.isEnabled());
				getExtentTest().log(LogStatus.PASS,"element is displayed and enabled:"+elementName);
				Actions actions=new Actions(getDriver());
				actions.doubleClick(element).build().perform();
				getExtentTest().log(LogStatus.PASS,"clicked on element:"+elementName);
			
		}
        catch(Exception exception)
		{
        	getExtentTest().log(LogStatus.FAIL,"clickable action is not performed");
		}
	}	
	
	public static void ClickByActionsSubmit(WebElement element,String elementName)
	{
		try
		{
			    Assert.assertTrue(element.isDisplayed()&&element.isEnabled());
				getExtentTest().log(LogStatus.PASS,"element is displayed and enabled:"+elementName);
				Actions actions=new Actions(getDriver());
				actions.sendKeys(element,Keys.ENTER).build().perform();
				getExtentTest().log(LogStatus.PASS,"clicked on element:"+elementName);
			
		}
        catch(Exception exception)
		{
        	getExtentTest().log(LogStatus.FAIL,"clickable action is not performed");
		}
	}
	
	public static void ClickByJS(WebElement element,String elementName)
	{
		try
		{
			    Assert.assertTrue(element.isDisplayed()&&element.isEnabled());
				getExtentTest().log(LogStatus.PASS,"element is displayed and enabled:"+elementName);
				Actions actions=new Actions(getDriver());
				actions.sendKeys(element,Keys.ENTER).build().perform();
				getExtentTest().log(LogStatus.PASS,"clicked on element:"+elementName);
			
		}
        catch(Exception exception)
		{
        	getExtentTest().log(LogStatus.FAIL,"clickable action is not performed");
		}
	}
	
	public static void DTA(WebElement element,String elementName,String testdata)
	{
		try 
		{
			Assert.assertTrue(element.isDisplayed()&&element.isEnabled());
		    element.clear();
		    element.sendKeys(testdata);
		    getExtentTest().log(LogStatus.PASS,"DTA is done on the element :"+elementName +"using data from :" +testdata);	
		}
		catch(Exception exception)
		{
			getExtentTest().log(LogStatus.FAIL,"DTA is not performed");	
		}
	}
	
	public static void DTAByActions(WebElement element,String elementName,String testdata)
	{
		try 
		{
			Assert.assertTrue(element.isDisplayed()&&element.isEnabled());
			Actions actions = new Actions(getDriver());
			actions.sendKeys(element,testdata).build().perform();
		    getExtentTest().log(LogStatus.PASS,"DTA is done on the element :"+elementName +"using data from :" +testdata);	
		}
		catch(Exception exception)
		{
			getExtentTest().log(LogStatus.FAIL,"DTA is not performed");	
		}
	}
	
	public static void DTAByJS(WebElement element,String elementName,String testdata)
	{
		try 
		{
			Assert.assertTrue(element.isDisplayed()&&element.isEnabled());
			Actions actions = new Actions(getDriver());
			actions.sendKeys(element,testdata).build().perform();
		    getExtentTest().log(LogStatus.PASS,"DTA is done on the element :"+elementName +"using data from :" +testdata);	
		}
		catch(Exception exception)
		{
			getExtentTest().log(LogStatus.FAIL,"DTA is not performed");	
		}
	}
	
	public static void HandleDropDrown(WebElement element,String elementName,String how,String howvalue) 
	{
		try
		{
			Assert.assertTrue(element.isDisplayed()&&element.isEnabled());
			Select select=new Select(element);
			if(how.equalsIgnoreCase("value"))
			{
				select.selectByValue(howvalue);
			}
			else if(how.equalsIgnoreCase("index"))
			{
				int index=Integer.parseInt(howvalue);
				select.selectByIndex(index);
			}
			else if(how.equalsIgnoreCase("text"))
			{
				select.selectByVisibleText(howvalue);
			}
		}
		catch(Exception exception)
		{
			getExtentTest().log(LogStatus.FAIL,"dropdown handling is not performed");	
		}
	}
	
	public static void multiWindows() 
	{
		try
		{
			String currentwindow=getDriver().getWindowHandle();
	        Set<String> windows=getDriver().getWindowHandles();
	        for(String window:windows)
	        {
	        	if(!currentwindow.equalsIgnoreCase(window))
	        	{
	        		getDriver().switchTo().window(window);
	        	}
				getExtentTest().log(LogStatus.PASS,"window handling is performed");
	        }	
		}
		catch(Exception exception)
		{
			getExtentTest().log(LogStatus.FAIL,"window handling is not performed");
		}		
	}
	
	public static void multiWindows(int index)
	{
		try
		{
			Set<String> windows=getDriver().getWindowHandles();
			List<String> listwindows=new ArrayList<String>(windows);
			String window=listwindows.get(index);
			getDriver().switchTo().window(window);
			getExtentTest().log(LogStatus.PASS,"window handling is performed");
		}
		catch(Exception exception)
		{
			getExtentTest().log(LogStatus.FAIL,"window handling is not performed");
		}
	}
}
