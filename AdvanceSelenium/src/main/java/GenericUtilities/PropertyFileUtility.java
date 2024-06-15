package GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * This class consists of generic methods related to property file
 * @author LENOVO
 *
 */
public class PropertyFileUtility {
/**
 * This method read data from property file and return a value to a caller
 * @param Key
 * @return
 * @throws Exception
 */
	public String readDataFromPropertyFile(String Key) throws Exception
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.Properties");
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(Key);
		return value;
		
	}

}
