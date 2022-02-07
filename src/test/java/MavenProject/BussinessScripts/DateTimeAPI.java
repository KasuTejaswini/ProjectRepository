package MavenProject.BussinessScripts;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeAPI {
public static void main(String[] args) {
	  
	LocalDate date=LocalDate.now();
	System.out.println(date);
	
	LocalDate minusdays=date.minusDays(2);
	System.out.println(minusdays);
	
	LocalDate plusdays=date.plusDays(3);
	System.out.println(plusdays);
	
	System.out.println(date.isLeapYear());
	
	LocalTime localtime=LocalTime.now();
	System.out.println(localtime);
	
	int hour=localtime.getHour();
	System.out.println(hour);
	
	LocalDateTime datetime=LocalDateTime.now();
	System.out.println(datetime);

	DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("MM-dd-yyyy  HH:mm:ss");
	String formatteddatetime=dateTimeFormatter.format(date);
	System.out.println(formatteddatetime);
}
}
