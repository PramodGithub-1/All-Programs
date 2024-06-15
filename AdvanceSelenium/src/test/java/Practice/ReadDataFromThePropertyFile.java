package Practice;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromThePropertyFile {

	public static void main(String[] args) throws Exception{
		
        //1.open the document in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.Properties");
		//2.create an object of properties from java.util
		Properties p=new Properties();
		//3.load fis to the properties class
		p.load(fis);
		//4.provide the key and read the value
		String value=p.getProperty("url");
		System.out.println(value);
		
			}

}
