package GenericUtilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class consists of generic method for excel file
 * @author LENOVO
 *
 */

public class ExcelFileUtility {
	/**
	 * This method return all the values
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Exception
	 */
public String readDataFromExcelFile(String sheetName,int rowNum,int cellNum)throws Exception
{
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetName);
	String value=sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
	return value;
	
	
	
}
}
