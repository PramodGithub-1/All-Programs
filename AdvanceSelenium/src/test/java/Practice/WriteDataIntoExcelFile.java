package Practice;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataIntoExcelFile {

	public static void main(String[] args)throws Exception {
		//1.create a excel file
	XSSFWorkbook xwb=new XSSFWorkbook();
	//2.create a sheet and name of sheet
	XSSFSheet sheet=xwb.createSheet("Employee");
	Object employees[][]= {{"Firstname","Lastname","Salary"},{"sama","leelasaipramod",34000},{"sama","pranydeepu",44000}};
	int rowcount=0;
	for(Object[] emp:employees)
	{
		Row r=sheet.createRow(rowcount++);
		int cellccount=0;
		for(Object cf:emp)
		{
			Cell c=r.createCell(cellccount++);
			if(cf instanceof String)
			{
				c.setCellValue((String)cf);
			}
			else if(cf instanceof Integer)
			{
			c.setCellValue((Integer)cf);
			
			}
		}
	}
FileOutputStream fos=new FileOutputStream(new File("C:\\Selenium\\Selenium\\DavicoCRM\\Writedata.xlsx"));
xwb.write(fos);
fos.close();
xwb.close();
System.out.println("Excel sheet created successfully!");

	}

}
