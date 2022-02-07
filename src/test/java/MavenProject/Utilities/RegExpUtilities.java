package MavenProject.Utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface RegExpUtilities {

	public static boolean isvalidPhNo(String target)
	 {
		boolean valid=true;
		Pattern pattern=Pattern.compile("[0/91]?[6-9][0-9]{9}"); 
		Matcher matcher=pattern.matcher(target);
		if(matcher.find()&&matcher.group().equalsIgnoreCase(target))
		{
			System.out.println("valid phone number");
		}
		else 
		{
			System.out.println("invalid phone number");
			valid=false;
		}
		return valid;
	 }
}
