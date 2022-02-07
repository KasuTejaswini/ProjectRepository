package MavenProject.Utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpDemo {
 public static void main(String[] args) {
	
	 String input="Kasu saketh ram";
	 int count=0;
	 
	 Pattern pattern=Pattern.compile("Kasu");
	 Matcher matcher=pattern.matcher(input);
	while(matcher.find()) 
	{
		String matched=matcher.group();
		System.out.println(matched);
		count++;
		
		int startindex=matcher.start();
		System.out.println("index :"+startindex);
		
		int endindex=matcher.end();
		System.out.println("index :"+endindex);
	}
	System.out.println("sum :"+count);
}
}
