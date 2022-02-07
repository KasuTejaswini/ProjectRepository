package MavenProject.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import MavenProject.Utilities.Screenshot;

public class TestcaseActivity implements ITestListener{

	
	public void onTestStart(ITestResult result) {
		System.out.println("test execution is :" +result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("test case is successfull :"+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("test case is failed :"+result.getName());
		try {
			Screenshot.takess();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("test case is skipped :"+result.getName());
		try {
			Screenshot.takess();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		System.out.println("suite execution is started");
		
	}
	
	public void onFinish(ITestContext context) {
		System.out.println("suite execution is finished");
	}

}
