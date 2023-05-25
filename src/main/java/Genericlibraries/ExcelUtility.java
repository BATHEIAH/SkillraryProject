package Genericlibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
private Workbook Workbook;
private DataFormatter df;
/**
 * This method is Used to initialize excel file
 * @param excelpath
 */
public void excelInit(String excelpath) 
{
	FileInputStream fis=null;
try {
	fis=new FileInputStream(excelpath);
} catch (FileNotFoundException e) {
	e.printStackTrace();
}
try {
	Workbook=WorkbookFactory.create(fis);
} catch (EncryptedDocumentException | IOException e) {
	e.printStackTrace();
}
}
/**
 * this method is used to read single  data from Excel
 * @param SheetName
 * @param rowNum
 * @param cellNum
 * @return
 */
public String readDataFromExcel(String SheetName, int rowNum, int cellNum) 
{
	df=new DataFormatter();
	return df.formatCellValue(Workbook.getSheet(SheetName).getRow(rowNum).getCell(cellNum));
}
/**
 * this method is used to read multipled data from Excel
 * @param SheetName
 * @return
 */
public Map<String, String> readDataFromExcel(String SheetName)
{
	Map<String, String> map=new HashMap<>();
	df=new DataFormatter();
	Sheet sheet=Workbook.getSheet(SheetName);
	
	for (int i = 0; i <= sheet.getLastRowNum(); i++) 
	{
	String key=df.formatCellValue(sheet.getRow(i).getCell(0));
	String value=df.formatCellValue(sheet.getRow(i).getCell(1));
	map.put(key, value);
	}
	return map;	
}
/**
 * this method is used to Write And Save data to Excel
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @param Value
 * @param excelPath
 */
public void WriteToExcel(String sheetName, int rowNum, int cellNum, Date Value, String excelPath) 
{
Cell cell=Workbook.getSheet(sheetName).getRow(rowNum).createCell(cellNum);	
cell.setCellValue(Value);
FileOutputStream fos=null;
try {
	fos=new FileOutputStream(excelPath);
} catch (FileNotFoundException e) {
	e.printStackTrace();
}
try {
	Workbook.write(fos);
} catch (IOException e) {
	e.printStackTrace();
}
}
/**
 * this is used to close the Excel WorkBook
 */
public void closeExcel()
{
try {
	Workbook.close();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	
}
}

