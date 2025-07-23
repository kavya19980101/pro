package Pra;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnCondition {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		String expectedcondition="TC_01";
		String data1="";
		String data2="";
		String data3="";
		boolean flag=false;
		FileInputStream fis=new FileInputStream("C:\\Users\\Kaviya S\\Downloads\\excelddt\\ExampleForDataDrivenTesting.xlsx");
      Workbook book= WorkbookFactory.create(fis);
      Sheet sheet= book.getSheet("Organization");
      int rowcount=sheet.getLastRowNum();
      for(int i=1;i<rowcount;i++)
      {
    	  String data="";
    	  try {
    	  data=sheet.getRow(i).getCell(0).toString();
    	  if(data.equals(expectedcondition))
    	  {
    		  flag=true;
    	   data1= sheet.getRow(i).getCell(1).getStringCellValue();
    	   data2=sheet.getRow(i).getCell(2).getStringCellValue();
    	   data3=sheet.getRow(i).getCell(3).getStringCellValue();
    	  }
    	  }
    	  catch (Exception e) {
			// TODO: handle exception
		}
      } 
      if(flag==true)
      {
    	  System.out.println(data1 +" "+ data2 + " "+ data3);
      }
      else {
		System.out.println(expectedcondition+" data is not available");
	}
      book.close();
    	  
      }}
