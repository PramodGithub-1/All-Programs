package GenericUtilities;

import java.util.Date;
/**
 * This class consists of generic methods related to java
 * @author LENOVO
 *
 */
public class JavaUtility {
	/**
	 * This method will capture the system date into required format 
	 * @return date
	 */
 public String getSystemDate()
 {
	 Date d=new Date();
	 String darr[]=d.toString().split(" ");
	 String date=darr[2]+"-"+darr[1]+"-"+darr[5]+"_"+darr[3].replace(":", "-");
	 return date;
	 
 }
}
