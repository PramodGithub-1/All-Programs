package Practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {
public static void main(String[] args) throws Exception {
	FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\Genreal.xlsx");
	Workbook wb=WorkbookFactory.create(fise);
	Sheet sh=wb.getSheet("sheet1");
	DataFormatter df=new DataFormatter();
	for(int i=1;i<sh.getLastRowNum();i++)
	{
		Row r=sh.getRow(i);
		for(int j=0;j<r.getLastCellNum();j++)
		{
			Cell c=r.getCell(j);
			String data=df.formatCellValue(c);
			System.out.println(data);
		}
	}
}
}
