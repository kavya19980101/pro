package Pra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReaMultipleData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
FileInputStream fis=new FileInputStream("C:\\Users\\Kaviya S\\Downloads\\excelddt\\ExampleForDataDrivenTesting.xlsx");
	Workbook book= WorkbookFactory.create(fis);
    Sheet sheet=book.getSheet("Organization");
       int rowcount= sheet.getLastRowNum();
       
    for(int i=0;i<=rowcount;i++)
    {
    	
    Row row= sheet.getRow(i);
    System.out.println("");
    
    for (int j = 0; j <=row.getLastCellNum(); j++) {
    Cell cell= row.getCell(j);
    if (cell!=null) {
    	  System.out.print(cell.getStringCellValue()+"\t");
	}
  
    }
    }
	
	}
}
