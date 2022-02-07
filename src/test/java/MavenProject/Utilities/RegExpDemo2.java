package MavenProject.Utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpDemo2 {
public static void main(String[] args) {
	
	int sum=0;
	String target="kasu1819 Tejaswini2845";
	
	Pattern pattern=Pattern.compile("[0-9]");
	Matcher matcher=pattern.matcher(target);
	
	while(matcher.find())
	{
		String matched=matcher.group();
		int value=Integer.parseInt(matched);
		sum=sum+value;
	}
	System.out.println(sum);
}
}
