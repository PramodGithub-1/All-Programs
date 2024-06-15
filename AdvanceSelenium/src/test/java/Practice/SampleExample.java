package Practice;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtility;
import GenericUtilities.PropertyFileUtility;

public class SampleExample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
/*PropertyFileUtility pfu=new PropertyFileUtility();
String URL=pfu.readDataFromPropertyFile("url");
System.out.println(URL);
ExcelFileUtility eu=new ExcelFileUtility();
String value=eu.readDataFromExcelFile("Contacts",1,2);
System.out.println(value);*/
		JavaUtility ju=new JavaUtility();
		System.out.println(ju.getSystemDate());

	}

}
