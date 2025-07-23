package Pra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataBackInExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
FileInputStream fis=new FileInputStream("C:\\Users\\Kaviya S\\Downloads\\excelddt\\ExampleForDataDrivenTesting.xlsx");
Workbook book= WorkbookFactory.create(fis);
Sheet sheet=book.getSheet("Organization");
Row row= sheet.getRow(2);
Cell cell= row.createCell(4);
cell.setCellType(CellType.STRING);
cell.setCellValue("Fail");

FileOutputStream fos=new FileOutputStream("C:\\Users\\Kaviya S\\Downloads\\excelddt\\ExampleForDataDrivenTesting.xlsx");
book.write(fos);
book.close();
System.out.println("========executed========");
	}

}
