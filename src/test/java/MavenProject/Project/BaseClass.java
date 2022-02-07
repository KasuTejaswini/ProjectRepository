package MavenProject.Project;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.internal.IResultListener;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import MavenProject.CustomizedExceptions.CustomException;
import MavenProject.Utilities.Driverpaths;
import MavenProject.Utilities.Screenshot;
import lombok.Getter;

public class BaseClass{
	@Getter static WebDriver driver;
	@Getter static ExtentReports extentReports;
	@Getter static ExtentTest extentTest;
	@Getter static String Tcname;
 
	@Parameters({"browser"})
	@BeforeSuite
	public void OpenBrowser(@Optional("Chrome") String browser) 
	{
		System.out.println("BS");
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty(Driverpaths.Chromekey,Driverpaths.Chromevalue);
			driver= new ChromeDriver();	
			wora();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty(Driverpaths.iekey,Driverpaths.ievalue);
			driver= new InternetExplorerDriver();
			wora();
		}
	}
	
	public void wora() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void CloseBrowser() throws CustomException {
		System.out.println("AS");
		if(driver!=null)
		{
			driver.quit();
		}
		else
		{
		 System.out.println("driver is pointing to null");
		 CustomException excep=new CustomException("driver is pointing to null");
		 throw excep;
		}
	}
	
	@BeforeMethod
	public void BeforeTestExecution(Method method) {
	System.out.println("BM");
	String TCName=method.getName();
    System.out.println("current executing testcase is "+TCName);
    extentTest= extentReports.startTest(TCName);
	}
	
	@AfterMethod
	public void AfterTestExecution(ITestResult result) throws IOException {
		System.out.println("AM");
		Tcname=result.getName();
		if(result.getStatus()==result.SUCCESS)
		{
			System.out.println("test case is success:"+Tcname);
			extentTest.log(LogStatus.PASS,"testcase is passed :"+Tcname);
		}
		else  if(result.getStatus()==result.FAILURE)
       {
    	 System.out.println("test case is failed :"+Tcname);
    	 extentTest.log(LogStatus.FAIL,"test case is failed :"+Tcname);
    	 extentTest.log(LogStatus.FAIL,result.getThrowable());
         String imagepath=Screenshot.takess(Tcname);  
         extentTest.addScreenCapture(imagepath);
       }
		else if(result.getStatus()==result.SKIP)
       {
    	   System.out.println("test case is skipped");
    	   extentTest.log(LogStatus.SKIP,"test case is skipped :"+Tcname);
    	   extentTest.log(LogStatus.SKIP,result.getThrowable());
    	   String imagepath=Screenshot.takess(Tcname);  
           extentTest.addScreenCapture(imagepath);
       }
	}
	
	@BeforeTest
	public void initReports() {
		System.out.println("BT");
	 extentReports=new ExtentReports("C:\\Users\\saketh\\eclipse-workspace\\Project\\reports\\report.html");
	}
	
	@AfterTest
	public void getReports() throws CustomException {
		System.out.println("AT");
		if(extentReports!=null)
		{
			extentReports.endTest(extentTest);
			extentReports.flush();
		}
		else
		{
			System.out.println("extentreports is pointing to null");
			CustomException excep=new CustomException("extentreports is pointing to null");
			throw excep;
		}
	}
}
