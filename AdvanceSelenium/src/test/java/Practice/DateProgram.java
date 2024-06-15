package Practice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateProgram {
public static void main(String[] args)throws Exception {
	DateFormat fd=new SimpleDateFormat("dd/MM/YYYY  HH:mm:ss");
	Date d=new Date();
	String systemDate=fd.format(d);
	System.out.println(systemDate);
	
	
	
}
}
