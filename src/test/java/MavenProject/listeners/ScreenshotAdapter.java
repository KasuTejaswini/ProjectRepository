package MavenProject.listeners;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import MavenProject.Utilities.Screenshot;

public class ScreenshotAdapter extends TestListenerAdapter{
	
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

}
