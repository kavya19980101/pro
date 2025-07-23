package Pra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;






public class ReadDataFromExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\Kaviya S\\Downloads\\excelddt\\ExampleForDataDrivenTesting.xlsx");
         Workbook book= WorkbookFactory.create(fis);
         Sheet sheet=book.getSheet("Organization");
         Row row=sheet.getRow(1);
         Cell cell=row.getCell(2);
          String cellvalue=cell.getStringCellValue();
          System.out.println(cellvalue);
          book.close();
	}

}
