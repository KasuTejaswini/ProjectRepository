package MavenProject.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import MavenProject.Project.BaseClass;

public interface Screenshot {
 
	public static String takess(String Tcname) throws IOException {
		
		TakesScreenshot takesScreenshot= (TakesScreenshot) BaseClass.getDriver();
		File file=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String imagepath=System.getProperty("user.dir")+"\\screenshots\\"+Tcname+".jpeg";
		FileUtils.copyFile(file,new File(imagepath));
		return imagepath;
	}	
   
	public static String takess() throws IOException {
		
		TakesScreenshot takesScreenshot= (TakesScreenshot) BaseClass.getDriver();
		File file=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String imagepath=System.getProperty("user.dir")+"\\screenshots\\"+BaseClass.getTcname()+".jpeg";
		FileUtils.copyFile(file,new File(imagepath));
		return imagepath;
	}	
}
