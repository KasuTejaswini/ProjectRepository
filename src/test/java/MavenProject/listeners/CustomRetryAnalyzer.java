package MavenProject.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class CustomRetryAnalyzer implements IRetryAnalyzer{
	int retrycount=0;
	int maxretrycount=2;
	@Override
	public boolean retry(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus() && retrycount<=maxretrycount)
		{
			System.out.println("test count is:"+retrycount+"executing testcase is :"+result.getName());
			retrycount++;
			return true;
		}
		return false;
	}

}
