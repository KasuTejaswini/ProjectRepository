package MavenProject.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteExcelData {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
	FileInputStream fip= new FileInputStream("C:\\Users\\saketh\\eclipse-workspace\\Project\\src\\test\\java\\MavenProject\\testdata\\testdata1.xlsx");
	Workbook workbook=WorkbookFactory.create(fip);
	
	Sheet sheet=workbook.getSheet("data");
	Row row4=sheet.createRow(4);
	Cell cell40=row4.createCell(0);
	cell40.setCellValue("Tejaswini");
	Cell cell41=row4.createCell(1);
	cell41.setCellValue("Tejaswini");
	
	FileOutputStream fop=new FileOutputStream("C:\\Users\\saketh\\eclipse-workspace\\Project\\src\\test\\java\\MavenProject\\testdata\\testdata1.xlsx");
    workbook.write(fop);
}
}
