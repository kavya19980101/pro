package Pra.Organization;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileIntegrity {

	static public String datafetch() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Kaviya S\\Downloads\\excelddt\\TestScriptData.xlsx");
		Workbook book= WorkbookFactory.create(fis);
		Sheet sheet= book.getSheet("Organization");
		Row row= sheet.getRow(1);
		Cell cell=row.getCell(2);
		String OrganizationName=cell.getStringCellValue();
		return OrganizationName;
		
	}
}
