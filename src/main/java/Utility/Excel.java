package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	 public static String getTestData(int row, int cell,  String sheetName ) throws IOException {
		  FileInputStream file = new FileInputStream("D:\\project\\kavish\\Zerodha\\src\\test\\resources\\Book1.xlsx");
		   String value = WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		   System.out.println(value);
		   return value;
	
		 }
}
