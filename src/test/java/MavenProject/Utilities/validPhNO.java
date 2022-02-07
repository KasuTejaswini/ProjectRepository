package MavenProject.Utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validPhNO {
public static void main(String[] args) {
	
	String phno="8790033825";
	System.out.println(RegExpUtilities.isvalidPhNo(phno));
	
/*	Pattern pattern=Pattern.compile("[0/91]?[6-9][0-9]{9}");
	Matcher matcher=pattern.matcher(target);
	if(matcher.find()&&matcher.group().equalsIgnoreCase(target))
	{
		System.out.println("valid");
	}
	else
	{
		System.out.println("invalid");
	}  */
}
}
