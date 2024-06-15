package Practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws Exception{
		
 //1.open the document in java read format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//2.create a workbook
		Workbook wb=WorkbookFactory.create(fis);
		//3.naviagte to sheet
		Sheet sh=wb.getSheet("Contacts");
		//4.naviagte to row
		Row r=sh.getRow(1);
		//5.navigate to cell
		Cell c=r.getCell(2);
		//6.fetch the data
		String value=c.getStringCellValue();
		System.out.println(value);
		//7.close the excel document
		wb.close();
		
	}

}
