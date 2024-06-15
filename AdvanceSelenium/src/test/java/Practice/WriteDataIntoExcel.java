package Practice;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataIntoExcel {
public static void main(String[] args)throws Exception {
	//1.Excel book creation
	XSSFWorkbook wb=new XSSFWorkbook();
	//2.sheet creation with name
	XSSFSheet  sh=wb.createSheet("Organizations");
	//3. insterting values
	Object [][]orgs= {{"TC_ID","TC_Name","LastName"},{01,"Verify that user can be able to create an organization","Lakshya"},{02,"Verify that user can be able to create an organization","Tapasya"}};
	int rc=0;
	for(Object[]org:orgs )
	{
		Row r=sh.createRow(rc++);
		int cc=0;
		for(Object cf:org)
		{
			Cell c=r.createCell(cc++);
			if(cf instanceof String)
				c.setCellValue((String) cf);
			else if(cf instanceof Integer)
				c.setCellValue((Integer) cf);
		}
	}
	FileOutputStream fos=new FileOutputStream(new File("C:\\Selenium\\Selenium\\AdvanceSelenium\\WriteData.xlsx"));
	wb.write(fos);
	fos.close();
	wb.close();
	
}
}
